package top.jianx.coolq.service;


import top.jianx.coolq.pojo.JqLibraryDialog;

import java.util.List;
import java.util.Map;

public interface MsgService {
    /**
     * 获取词库缓存
     * @param key all--获取全部缓存 key---获取key对应的value
     * @return
     */
    Map<String, String> getCikuChche(String key);
}
