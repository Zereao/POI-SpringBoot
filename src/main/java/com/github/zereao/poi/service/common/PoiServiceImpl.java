package com.github.zereao.poi.service.common;

import com.github.zereao.poi.common.ReturnCode;
import com.github.zereao.poi.dao.PoiPptDao;
import com.github.zereao.poi.entity.No1PPT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PoiServiceImpl implements PoiService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PptOperateService pptOperateService;
    private final PptxOperateService pptxOperateService;
    private final PoiPptDao poiPptDao;

    @Autowired
    public PoiServiceImpl(PptOperateService pptOperateService, PptxOperateService pptxOperateService, PoiPptDao poiPptDao) {
        this.pptOperateService = pptOperateService;
        this.pptxOperateService = pptxOperateService;
        this.poiPptDao = poiPptDao;
    }

    @Override
    public String ppt2imgs(String pptId, String pptTag) {
        logger.info("------->  start!" +
                "   pptId = " + pptId +
                "   pptTag = " + pptTag);
//        try {
//            String result = null;
//            // 存放转换后图片的文件夹
//            String ppt2imgsPath = PathUtil.getAbsolutePpt2ImgPathByTag(pptId, pptTag);
//            File ppt2imgFolder = new File(ppt2imgsPath);
//            boolean isFolderAndExists = ppt2imgFolder.isDirectory() && ppt2imgFolder.exists();
//            boolean isNotNull = ppt2imgFolder.listFiles() != null && Objects.requireNonNull(ppt2imgFolder.listFiles()).length > 0;
//            if (isFolderAndExists && isNotNull) {
//                logger.info("------->  end !" +
//                        "  ID = " + pptId + " 的PPT已经被转化成了图片，" +
//                        "存在于 Path = 【" + ppt2imgsPath + "】下，可以直接读取。" +
//                        "   result = " + ReturnCode.SUCCESS);
//                return ReturnCode.SUCCESS;
//            }
//            File pptFile = PathUtil.getPptFileByTag(pptId, pptTag);
//            // 返回PPT所在目录下的所有文件
//            if (pptFile == null) {
//                logger.warn("------->  end !  PATH = 【" + PathUtil.getAbsolutePptPathByTag(pptId, pptTag) + "】" +
//                        "路径下不存在PPTX文件！" + "   return " + ReturnCode.RESOURCES_NOT_EXISTS);
//                return ReturnCode.RESOURCES_NOT_EXISTS;
//            }
//            String fileName = pptFile.getName();
//            if (fileName.toLowerCase().contains(".ppt") && (!(fileName.toLowerCase().contains(".pptx")))) {
//                result = pptOperateService.ppt2img(pptFile, ppt2imgsPath);
//            } else if (fileName.toLowerCase().contains(".pptx")) {
//                result = pptxOperateService.pptx2img(pptFile, ppt2imgsPath);
//            }
//            logger.info("------->  end ! result = " + result);
//            return result;
//        } catch (Exception e) {
//            logger.error("------->  ERROR! result = " + ReturnCode.FAILED);
//            logger.error(e.getMessage());
//        }
        return ReturnCode.FAILED;
    }

    @Override
    public int getImgsNum(String pptId, String pptTag) {
        logger.info("------->  start!" +
                "   pptID = " + pptId +
                "   pptTag = " + pptTag);
//        try {
//            // 存放转换后图片的文件夹
//            String ppt2imgPath = PathUtil.getAbsolutePpt2ImgPathByTag(pptId, pptTag);
//            if (ppt2imgPath == null || "".equals(ppt2imgPath)) {
//                logger.info("------->  ERROR!   pptTag错误！ pptTag = " + pptTag);
//                return -2;
//            }
//            File ppt2imgFolder = new File(ppt2imgPath);
//            File[] files = ppt2imgFolder.listFiles();
//            int imgsNum = 0;
//            if (files != null) {
//                imgsNum = files.length;
//            }
//            logger.info("------->  end!" +
//                    "   imgsNum = " + imgsNum);
//            return imgsNum;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return -1 ");
//            logger.error(e.getMessage());
//        }
        return -1;
    }

    @Override
    public List<No1PPT> selectPPTByPageNum(Collection<No1PPT> no1PPTCollection, int minPageNum, int elemNum) {
        logger.info("------->  start!" +
                "   no1PPTCollection = " + no1PPTCollection +
                "   minPage = " + minPageNum +
                "   elemNum = " + elemNum);
//        try {
//            List<No1PPT> resultList = new ArrayList<>();
//            int tag = 0;
//            for (No1PPT no1PPT : no1PPTCollection) {
//                if (tag == elemNum) {
//                    break;
//                }
//                String no1pptId = String.valueOf(no1PPT.getId());
//                File pptFile = PathUtil.getNo1PptFile(no1pptId);
//                // 如果PPT文件不存在，跳过当前No1PPT对象 ———————— 应该不会执行到这一步
//                if (pptFile == null) {
//                    logger.info(no1PPT.getId() + " 对应的PPT文件不存在！");
//                    continue;
//                }
//                String pptFileName = pptFile.getName();
//                boolean isMatchCondition = false;
//                if (pptFileName.toLowerCase().contains(".ppt") && (!(pptFileName.toLowerCase().contains(".pptx")))) {
//                    isMatchCondition = pptOperateService.isPageMatchCondition(pptFile, minPageNum);
//                } else if (pptFileName.toLowerCase().contains(".pptx")) {
//                    isMatchCondition = pptxOperateService.isPageMatchCondition(pptFile, minPageNum);
//                }
//                // 如果PPT幻灯页太少，跳过当前No1PPT对象
//                if (isMatchCondition) {
//                    logger.info(no1PPT.getId() + " 对应的PPT文件幻灯页数 小于 " + minPageNum);
//                    continue;
//                }
//                resultList.add(no1PPT);
//                tag++;
//            }
//            logger.info("------->  end!" +
//                    "   resultList = " + resultList);
//            return resultList;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public List<No1PPT> selectPPTByPageNum(Collection<No1PPT> no1PPTCollection, int minPageNum) {
        logger.info("------->  start!" +
                "   no1PPTCollection = " + no1PPTCollection +
                "   minPage = " + minPageNum);
//        try {
//            List<No1PPT> resultList = new ArrayList<>();
//            for (No1PPT no1PPT : no1PPTCollection) {
//                String no1pptId = String.valueOf(no1PPT.getId());
//                File pptFile = PathUtil.getNo1PptFile(no1pptId);
//                // 如果PPT文件不存在，跳过当前No1PPT对象 ———————— 应该不会执行到这一步
//                if (pptFile == null) {
//                    logger.info(no1PPT.getId() + " 对应的PPT文件不存在！");
//                    continue;
//                }
//                String pptFileName = pptFile.getName();
//                boolean isMatchCondition = false;
//                if (pptFileName.toLowerCase().contains(".ppt") && (!(pptFileName.toLowerCase().contains(".pptx")))) {
//                    isMatchCondition = pptOperateService.isPageMatchCondition(pptFile, minPageNum);
//                } else if (pptFileName.toLowerCase().contains(".pptx")) {
//                    isMatchCondition = pptxOperateService.isPageMatchCondition(pptFile, minPageNum);
//                }
//                // 如果PPT幻灯页太少，跳过当前No1PPT对象
//                if (isMatchCondition) {
//                    logger.info(no1PPT.getId() + " 对应的PPT文件幻灯页数 小于 " + minPageNum);
//                    continue;
//                }
//                resultList.add(no1PPT);
//            }
//            logger.info("------->  end!" +
//                    "   resultList = " + resultList);
//            return resultList;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public Map<No1PPT, int[]> selectPPT(No1PPT no1PPT, int minPageNum) {
        logger.info("------->  start!" +
                "   no1PPT = " + no1PPT +
                "   minPage = " + minPageNum);
        try {
            List<No1PPT> aNo1PPTList = new ArrayList<>();
            aNo1PPTList.add(no1PPT);
            List<Map<No1PPT, int[]>> resultMapList = selectPPT(aNo1PPTList, minPageNum);
            Map<No1PPT, int[]> resultMap = null;
            if (!(resultMapList == null || resultMapList.size() != 1)) {
                resultMap = resultMapList.get(0);
            }
            logger.info("------->  end!" +
                    "   resultMap = " + resultMap);
            return resultMap;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return null");
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Map<No1PPT, int[]>> selectPPT(Collection<No1PPT> no1PPTCollection, int minPageNum) {
        logger.info("------->  start!" +
                "   no1PPTCollection = " + no1PPTCollection +
                "   minPage = " + minPageNum);
//        try {
//            boolean isBaiduOcrOver = false;
//            boolean isTencentOcrOver = false;
//            List<Map<No1PPT, int[]>> resultList = new ArrayList<>();
//            for (No1PPT no1PPT : no1PPTCollection) {
//                // 从数据中读取，如果当前no1ppt对应的PoiPPT对象存在，则直接将当前NoPPT对象存入resultList
//                PoiPPT poiPPT = poiPptDao.getPoiPPTByNo1pptId(no1PPT.getId());
//                if (poiPPT != null) {
//                    Map<No1PPT, int[]> map = new HashMap<>();
//                    // 这里，第二位 错误index数组int[] 存入 null
//                    map.put(no1PPT, null);
//                    resultList.add(map);
//                    continue;
//                }
//                String no1pptId = String.valueOf(no1PPT.getId());
//
//                String resultOfPpt2Img = ppt2imgs(no1pptId, PptTag.TYPE_NO1);
//                // 以防万一，还是判断一下文件存在性，如果文件不存在，跳过当前No1PPT对象
//                if (resultOfPpt2Img.equals(ReturnCode.RESOURCES_NOT_EXISTS)) {
//                    logger.info("ppt2imgs方法返回的ReturnCode = " + ReturnCode.RESOURCES_NOT_EXISTS);
//                    continue;
//                }
//                // 调用OCR接口识别PPT转图片后的图片中的文字，准备提出包含广告的广告页
//                if (resultOfPpt2Img.equals(ReturnCode.SUCCESS)) {
//                    String ppt2imgPath = PathUtil.getAbsoluteNo1PPT2imgPath(no1pptId);
//                    int imgsNum = Objects.requireNonNull(new File(ppt2imgPath).listFiles()).length;
//                    // 对一个PPT的每一页进行循环识别
//                    for (int imgIndex = imgsNum, adPage = 0; imgIndex >= 1; imgIndex--, adPage++) {
//                        // 如果 腾讯和百度的Ocr使用次数     --没有同时用完
//                        if (!(isBaiduOcrOver && isTencentOcrOver)) {
//                            // 倒序图像识别，节约OCR成本成本
//                            String imgPath = ppt2imgPath + imgIndex + ".png";
//                            List<String> ocrWordsList = null;
//                            // 如果腾讯 没有用完，优先使用腾讯
//                            if (!isTencentOcrOver) {
//                                ocrWordsList = ocrService.getWordsWithTencentOCR(imgPath);
//                            }
//                            if ((ocrWordsList == null || ocrWordsList.size() == 0) && !isBaiduOcrOver) {
//                                // 腾讯用完
//                                isTencentOcrOver = true;
//                                logger.info("------->  Warn！当日腾讯OCR接口调用次数已达上限！下面调用百度OCR接口！");
//                                // 返回null，则腾讯的次数用完。若百度没用完，则使用百度Ocr接口
//                                ocrWordsList = ocrService.getWordsWithBaiduOCR(imgPath);
//                            }
//                            if (ocrWordsList == null || ocrWordsList.size() == 0) {
//                                // 百度也用光
//                                isBaiduOcrOver = true;
//                                logger.info("------->  Warn！当日百度OCR接口调用次数已达上限！今日将不再使用OCR筛选！");
//                                break;
//                            }
//                            // 当前页面的广告信息权重
//                            double weight = 0.0;
//                            for (String ocrWord : ocrWordsList) {
//                                Map<String, Double> adKeywordsMap = AdWordAnalyseUtil.adKeywordsMap;
//                                for (String word : adKeywordsMap.keySet()) {
//                                    if (ocrWord.toLowerCase().contains(word.toLowerCase())) {
//                                        weight += adKeywordsMap.get(word);
//                                    }
//                                }
//                            }
//                            logger.info("-------> 当前页面 index = " + imgIndex + " ，权重 = " + weight);
//                            Map<No1PPT, int[]> infoMap = new HashMap<>();
//                            // 如果广告词汇权重 小于等于 10 ，则我们认为其合格
//                            if (weight <= 10.0) {
//                                // adPage 广告页的总页数，有几页广告
//                                int[] adPageIndexs = new int[adPage];
//                                int imgNum_Temp = imgsNum - 1;
//                                for (int i = 0; i < adPage; i++) {
//                                    adPageIndexs[i] = imgNum_Temp;
//                                    imgNum_Temp--;
//                                }
//                                infoMap.put(no1PPT, adPageIndexs);
//                                resultList.add(infoMap);
//                                // 进入下一个PPT 的筛选
//                                break;
//                            }
//                        } else {
//                            logger.info("-------> 停止OCR识别，开始直接把No1PPT返回！");
//                            Map<No1PPT, int[]> infoMap = new HashMap<>();
//                            infoMap.put(no1PPT, new int[]{-1});
//                            resultList.add(infoMap);
//                            // 直接进入下一个PPT的筛选
//                            break;
//                        }
//                    }
//                }
//            }
//            // 存放转换后图片的文件夹
//            logger.info("------->  end!" +
//                    "   resultList.size() = " + resultList.size() +
//                    "   resultList = " + resultList);
//            return resultList;
//        } catch (Exception e) {
//            logger.error("------->  ERROR!  return null");
//            logger.error(e.getMessage());
//        }
        return null;
    }

    @Override
    public List<Map<No1PPT, int[]>> selectPPTSync(Collection<No1PPT> no1PPTCollection, int minPageNum) {
        logger.info("------->  start!" +
                "   no1PPTCollection = " + no1PPTCollection +
                "   minPage = " + minPageNum);
        try {
            int no1pptNum = no1PPTCollection.size();
            int spilt = no1pptNum / 4;
            if (spilt == 0) {
                logger.info("------->  不必使用多线程，直接调用selectPPT()方法!");
                return selectPPT(no1PPTCollection, minPageNum);
            }
            List<No1PPT> list1 = new ArrayList<>();
            List<No1PPT> list2 = new ArrayList<>();
            List<No1PPT> list3 = new ArrayList<>();
            List<No1PPT> list4 = new ArrayList<>();
            int index = 0;
            List<Map<No1PPT, int[]>> resultList = new ArrayList<>();
            for (No1PPT no1PPT : no1PPTCollection) {
                if (index < spilt) {
                    list1.add(no1PPT);
                    index++;
                } else if (index >= spilt && index < spilt * 2) {
                    list2.add(no1PPT);
                    index++;
                } else if (index >= spilt * 2 && index < spilt * 3) {
                    list3.add(no1PPT);
                    index++;
                } else {
                    list4.add(no1PPT);
                    index++;
                }
            }
            Thread thread1 = new Thread(() -> resultList.addAll(selectPPT(list1, minPageNum)));
            Thread thread2 = new Thread(() -> resultList.addAll(selectPPT(list2, minPageNum)));
            Thread thread3 = new Thread(() -> resultList.addAll(selectPPT(list3, minPageNum)));
            Thread thread4 = new Thread(() -> resultList.addAll(selectPPT(list4, minPageNum)));
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            logger.info("------->  end!" +
                    "   resultList.size() = " + resultList.size() +
                    "   resultList = " + resultList);
            return resultList;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return null");
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String rebuildPPT(No1PPT no1PPT, int[] adPageIndexs) {
        logger.info("------->  start!" +
                "   no1PPT = " + no1PPT +
                "   adPageIndexs = " + Arrays.toString(adPageIndexs));
//        try {
//            String pptFileName = no1PPT.getPptFileName();
//            if (pptFileName == null || "".equals(pptFileName)) {
//                String no1pptId = String.valueOf(no1PPT.getId());
//                File pptFile = PathUtil.getNo1PptFile(no1pptId);
//                assert pptFile != null;
//                pptFileName = pptFile.getName();
//            }
//            String result = null;
//            if (pptFileName.toLowerCase().contains(".ppt") && !pptFileName.toLowerCase().contains(".pptx")) {
//                result = pptOperateService.rebuildPPT(no1PPT, adPageIndexs);
//            } else if (pptFileName.toLowerCase().contains(".pptx")) {
//                result = pptxOperateService.rebuildPPTX(no1PPT, adPageIndexs);
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
    public String rebuildPPT(List<Map<No1PPT, int[]>> infoList) {
        logger.info("------->  start!" +
                "   infoList = " + infoList);
        try {
            String result = null;
            // 返回 Error 的个数
            int index = 0;
            for (Map<No1PPT, int[]> no1PPTMap : infoList) {
                for (No1PPT no1PPT : no1PPTMap.keySet()) {
                    result = rebuildPPT(no1PPT, no1PPTMap.get(no1PPT));
                    if (result.equals(ReturnCode.FAILED)) {
                        index++;
                    }
                }
            }
            logger.info("------->  end!" +
                    "   错误个数 = " + index);
            return ReturnCode.SUCCESS;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return FAILED");
            logger.error(e.getMessage());
        }
        return ReturnCode.FAILED;
    }

    @Override
    public String rebuildPPTSync(List<Map<No1PPT, int[]>> infoList) {
        logger.info("------->  start!" +
                "   infoList = " + infoList);
        try {
            int no1pptNum = infoList.size();
            int spilt = no1pptNum / 4;
            if (spilt == 0) {
                logger.info("------->  不必使用多线程，直接调用rebuildPPT()方法!");
                return rebuildPPT(infoList);
            }
            List<Map<No1PPT, int[]>> list1 = new ArrayList<>();
            List<Map<No1PPT, int[]>> list2 = new ArrayList<>();
            List<Map<No1PPT, int[]>> list3 = new ArrayList<>();
            List<Map<No1PPT, int[]>> list4 = new ArrayList<>();
            int index = 0;
            for (Map<No1PPT, int[]> no1PPTMap : infoList) {
                if (index < spilt) {
                    list1.add(no1PPTMap);
                    index++;
                } else if (index >= spilt && index < spilt * 2) {
                    list2.add(no1PPTMap);
                    index++;
                } else if (index >= spilt * 2 && index < spilt * 3) {
                    list3.add(no1PPTMap);
                    index++;
                } else if (index >= spilt * 3 && index < infoList.size()) {
                    list4.add(no1PPTMap);
                    index++;
                }
            }
            Thread thread1 = new Thread(() -> {
                String result = rebuildPPT(list1);
                logger.info("####  List 1 end !    result = " + result);
            });
            Thread thread2 = new Thread(() -> {
                String result = rebuildPPT(list2);
                logger.info("####  List 2 end !    result = " + result);
            });
            Thread thread3 = new Thread(() -> {
                String result = rebuildPPT(list3);
                logger.info("####  List 3 end !    result = " + result);
            });
            Thread thread4 = new Thread(() -> {
                String result = rebuildPPT(list4);
                logger.info("####  List 4 end !    result = " + result);
            });
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            logger.info("------->  end!   return SUCCESSF");
            return ReturnCode.SUCCESS;
        } catch (Exception e) {
            logger.error("------->  ERROR!  return FAILED");
            logger.error(e.getMessage());
        }
        return ReturnCode.FAILED;
    }


}