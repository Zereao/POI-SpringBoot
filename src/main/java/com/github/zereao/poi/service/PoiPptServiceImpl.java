package com.github.zereao.poi.service;

import com.github.zereao.poi.common.ReturnCode;
import com.github.zereao.poi.dao.PoiPptDao;
import com.github.zereao.poi.entity.No1PPT;
import com.github.zereao.poi.entity.PoiPPT;
import com.github.zereao.poi.service.common.PoiService;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Service
public class PoiPptServiceImpl implements PoiPptService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PoiService poiService;
    private final No1PptService no1PptService;
    private final PoiPptDao poiPptDao;

    @Autowired
    public PoiPptServiceImpl(PoiService poiService, No1PptService no1PptService, PoiPptDao poiPptDao) {
        this.poiService = poiService;
        this.no1PptService = no1PptService;
        this.poiPptDao = poiPptDao;
    }

    /**
     * 根据多个 keyword关键词 按关联程度 模糊搜索符合条件的No1PPT对象
     *
     * @param keywordsList 包含关键词的List
     * @return 包含No1PPT对象的List - 内部使用了LinkedHashSet存储数据 保证去重 | 保证了有序
     */
    public List<No1PPT> getNo1PPTByKeyWordsRelevancy(List<String> keywordsList) {
//        try {
//            logger.info("------->  start!   keywordsList = " + keywordsList);
//            Set<No1PPT> resultSet = new LinkedHashSet<>();
//            List<List<String>> keywordCombinationList = new ArrayList<>();
//            for (int i = 1; i <= keywordsList.size(); i++) {
//                combination(keywordsList, new ArrayList<>(), i, keywordCombinationList);
//            }
//            // 反转 keywordCombinationList ，使关联度越高的 关键词组List 越靠前
//            Collections.reverse(keywordCombinationList);
//            for (List<String> stringList : keywordCombinationList) {
//                List<No1PPT> resultList = no1PptDao.getNo1PPTByKeyWordsExact(stringList);
//                resultSet.addAll(resultList);
//            }
//            List<No1PPT> resultList = new ArrayList<>(resultSet);
//            logger.info("------->  end !    resultList = " + resultSet);
//            return resultList;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  返回 null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public List<No1PPT> getNo1PptByKeyword(String keywords, HttpSession session) {
        logger.info("------->  start!   keywords = {}", keywords);
//        try {
//            List<String> keywordList = spiltKeywords(keywords);
//            // 根据关键词关联度搜索本地仓库中的No1PPT，存于LinkedHashSet中，保证有序、去重
//            List<No1PPT> no1PPTList = no1PptService.getNo1PPTByKeyWordsRelevancy(keywordList);
//            logger.info("------->  end!   result = {}", no1PPTList);
//            return no1PPTList;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public JSONArray getPoiPPTofMax80(List<No1PPT> no1PPTList) {
        logger.info("------->  start!   no1PPTList = " + no1PPTList);
//        try {
//            // 得到最多 80条 数据，其中所有的PPT 页面都大于7页
//            List<No1PPT> resultList = poiService.selectPPTByPageNum(no1PPTList, 7, 80);
//            JSONArray jsonArray = new JSONArray();
//            int i = 0;
//            for (No1PPT no1PPT : resultList) {
//                String id = String.valueOf(no1PPT.getId());
//                JSONObject json = new JSONObject();
//                json.put("id", id);
//                json.put("description", no1PPT.getSrcDescription());
//                json.put("imgUrl", no1PPT.getSrcImgUrl());
//                // 根据pptId获取到本地仓库  ZeroFilesOutput 目录下对应的PPT文件
//                File pptFile = PathUtil.getNo1PptFile(id);
//                if (pptFile == null) {
//                    logger.error("------->  ERROR!  本地仓库目录【" + PathUtil.getAbsoluteNo1PptPath(id) + "】路径下不存在PPT/PPTX文件！   return null");
//                    json.put("pptName", "");
//                } else {
//                    json.put("pptName", pptFile.getName());
//                }
//                jsonArray.add(json);
//            }
//            logger.info("------->  end!" +
//                    "   JSONArray = " + jsonArray);
//            return jsonArray;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public String operateForPoiPpt(String no1pptId) {
        logger.info("------->  start!" +
                "   no1pptId = " + no1pptId);
//        try {
//            No1PPT ppt = no1PptService.getNo1PptById(no1pptId);
//            Map<No1PPT, int[]> resultMap = poiService.selectPPT(ppt, 7);
//            String result = null;
//            if (resultMap != null && resultMap.size() == 1) {
//                for (No1PPT no1PPT : resultMap.keySet()) {
//                    result = poiService.rebuildPPT(no1PPT, resultMap.get(no1PPT));
//                }
//            } else {
//                result = ReturnCode.FAILED;
//            }
//            logger.info("------->  end!" +
//                    "   result = " + result);
//            return result;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return FAILED");
//            logger.error(e.getMessage());
//        }
        return ReturnCode.FAILED;
    }

    @Override
    public String operateForRemainPoiPptList(HttpSession session) {
        logger.info("------->  start!");
        try {
            if (session.getAttribute("remainList") == null) {
                logger.info("------->  session 中已经不存在未处理的 List！  return null!");
                return null;
            }
            List<No1PPT> no1PPTList = (List<No1PPT>) session.getAttribute("remainList");
            logger.info("------->  start!" +
                    "   no1PPTList = " + no1PPTList);
            // 即将处理的List元素
            List<No1PPT> opList = null;
            //  没有处理的List元素
            List<No1PPT> remainList = null;
            // 为了用户体验，截取其前16条信息先进行筛选，不足16条则全部处理
            if (no1PPTList.size() > 16) {
                opList = no1PPTList.subList(0, 16);
                remainList = no1PPTList.subList(16, no1PPTList.size());
            } else {
                opList = no1PPTList;
            }
            // 把这次已经读取了的List 放进Session
            session.setAttribute("remainList", remainList);
            // 挑选符合条件的No1PPT————幻灯片张数大于 7 的，同时通过OCR获取到图片的 广告页面信息
            List<Map<No1PPT, int[]>> resultNo1PPTList = poiService.selectPPTSync(opList, 7);
            String result = poiService.rebuildPPTSync(resultNo1PPTList);
            logger.info("------->  end!" +
                    "   result = " + result);
            return result;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return FAILED");
            logger.error(e.getMessage());
        }
        return ReturnCode.FAILED;
    }

    @Override
    public JSONArray getSearchResult(String keywords, HttpSession session) {
        logger.info("------->  start!" +
                "   keywords = " + keywords);
        try {
            List<No1PPT> no1PPTList = getNo1PptByKeyword(keywords, session);
            JSONArray jsonArray = getPoiPPTofMax80(no1PPTList);
            logger.info("------->  end!" +
                    "   jsonArray = " + jsonArray);
            return jsonArray;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return null");
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String ppt2img(String poipptId) {
        logger.info("------->  start!" +
                "  poipptId = " + poipptId);
//        try {
//            String result = poiService.ppt2imgs(poipptId, PptTag.TYPE_POI_REBUILD);
//            logger.info("------->  end!" +
//                    "   result = " + result);
//            return result;
//        } catch (Exception e) {
//            logger.error("------->  ERROR! result = " + ReturnCode.FAILED);
//            logger.error(e.getMessage());
//        }
        return ReturnCode.FAILED;
    }

    @Override
    public int getImgsNum(String poipptID) {
//        try {
//            logger.info("------->  start!" +
//                    "   pptId = " + poipptID);
//            int result = poiService.getImgsNum(poipptID, PptTag.TYPE_POI_REBUILD);
//            logger.info("------->  end ! result = " + result);
//            return result;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  返回 -1 ");
//            logger.error(e.getMessage());
//        }
        return -1;
    }

    @Override
    public int OperatePPT(String no1pptId) {
        logger.info("------->  start!" +
                "   poipptId = " + no1pptId);
        try {
            String result = operateForPoiPpt(no1pptId);
            logger.info("+++++++++++++++++++++++++++++++++++++");
            logger.info("+++++++++++++++++++++++++++++++++++++");
            if (result.equals(ReturnCode.FAILED)) {
                logger.error("------->  ERROR!" +
                        "   poipptId = " + no1pptId +
                        "   处理失败！  return -1");
                return -1;
            }
            logger.info("___________________________");
            PoiPPT poiPPT = poiPptDao.getPoiPPTByNo1pptId(Integer.parseInt(no1pptId));
            String poipptId = String.valueOf(poiPPT.getId());
            result = ppt2img(poipptId);
            logger.info("+++++++++++++++++++++++++++++++++++++ toImg");
            logger.info("+++++++++++++++++++++++++++++++++++++ toImg");
            int imgNum = getImgsNum(poipptId);
            logger.info("+++++++++++++++++++++++++++++++++++++ getImgSum");
            logger.info("+++++++++++++++++++++++++++++++++++++ getImgSum");
            logger.info("------->  end!" +
                    "   imgNum = " + imgNum);
            return imgNum;
        } catch (Exception e) {
            logger.error("------->  ERROR!    return -1");
            logger.error(e.getMessage());
        }
        return -1;
    }

    /**
     * 定时任务，每天凌晨2点，执行处理所有的PPT的程序
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void opForPoiPpt() {
        logger.info("------->  定时任务---处理本地仓库中所有PPT start!");
//        try {
//            List<No1PPT> no1PPTList = no1PptService.getAllNo1Ppts();
//            List<Map<No1PPT, int[]>> resultNo1PPTList = poiService.selectPPTSync(no1PPTList, 7);
//            String result = poiService.rebuildPPTSync(resultNo1PPTList);
//            logger.info("------->  定时任务---处理本地仓库中所有PPT end!   result = " + result);
//        } catch (Exception e) {
//            logger.error("------->  ERROR!");
//            logger.error(e.getMessage());
//        }
    }

    /**
     * 私有的方法，用于拆分关键词为一个List
     *
     * @param keywords 关键词
     * @return keywordList
     */
    private List<String> spiltKeywords(String keywords) {
        logger.info("------->  start!" +
                "   keywords = " + keywords);
        try {
            // 按照 半角/全角逗号、空格 拆分
            String[] strArray_1 = keywords.split(",");
            String[] strArray_2 = keywords.split("，");
            String[] strArray_3 = keywords.split(" ");
            List<String> keywordList = new ArrayList<>();
            keywordList.addAll(Arrays.asList(strArray_1));
            keywordList.addAll(Arrays.asList(strArray_2));
            keywordList.addAll(Arrays.asList(strArray_3));
            logger.info("------->  end ! keywordList = " + keywordList);
            return keywordList;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return null");
            logger.error(e.getMessage());
        }
        return null;
    }
}
