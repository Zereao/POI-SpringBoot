package com.github.zereao.poi.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jupiter
 * @version 2018/03/09/10:45
 */
@Service
public interface InitializeService {
    /**
     * 获取页面初始化的信息
     *
     * @param request HttpServletRequest
     * @return 包含了index.jsp 的一些初始化信息的一个JSONObject对象
     */
    JSONObject getInitializeInfo(HttpServletRequest request);

}
