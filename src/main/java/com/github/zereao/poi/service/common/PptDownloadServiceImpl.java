package com.github.zereao.poi.service.common;

import com.github.zereao.poi.common.PathUtil;
import com.github.zereao.poi.common.ReturnCode;
import com.github.zereao.poi.dao.UserDownloadHistoryDao;
import com.github.zereao.poi.entity.User;
import com.github.zereao.poi.entity.UserDownloadHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Service
public class PptDownloadServiceImpl implements PptDownloadService {
    private Logger logger = LogManager.getLogger(this.getClass());

    private final UserDownloadHistoryDao userDownloadHistoryDao;

    @Autowired
    public PptDownloadServiceImpl(UserDownloadHistoryDao userDownloadHistoryDao) {
        this.userDownloadHistoryDao = userDownloadHistoryDao;
    }

    @Override
    public String pptDownloader(String pptId, HttpServletRequest request, HttpServletResponse response) {
        logger.info("------->  start!" +
                "   pptId = " + pptId);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File pptFile = PathUtil.getNo1PptFile(pptId);
            if (pptFile == null) {
                logger.error("------->  ERROR!" +
                        "   本地不存在 pptId = " + pptId + " 的PPT！  return " + ReturnCode.RESOURCES_NOT_EXISTS);
                return ReturnCode.RESOURCES_NOT_EXISTS;
            }
            inputStream = new FileInputStream(pptFile);
            bufferedInputStream = new BufferedInputStream(inputStream);
            // 创建输出流
            outputStream = response.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 创建缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区中
            while ((len = bufferedInputStream.read(buffer)) > 0) {
                // 输出缓冲区内容到浏览器，实现文件下载
                bufferedOutputStream.write(buffer, 0, len);
            }
            // 如果用户登录，则添加用户的下载记录到数据库
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                UserDownloadHistory userDownloadHistory = new UserDownloadHistory();
                userDownloadHistory.setPptId(Integer.parseInt(pptId));
                userDownloadHistory.setEmail(user.getEmail());
                userDownloadHistory.setPptType("PPT");
                userDownloadHistoryDao.addDownloadHistory(userDownloadHistory);
            }
            logger.info("------->  end ! SUCCESS");
            return ReturnCode.SUCCESS;
        } catch (Exception e) {
            logger.error("------->  ERROR!  返回 FAILED ");
            logger.error(e.getMessage());
        } finally {
            try {
                // 关闭输出流   关闭顺序，还是要深入理解下
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                // 关闭文件流
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ReturnCode.FAILED;
    }
}
