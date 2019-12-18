package top.jianx.coolq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jianx.coolq.mapper.JqLibraryDialogMapper;
import top.jianx.coolq.pojo.JqLibraryDialog;
import top.jianx.coolq.service.MsgService;

import java.beans.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MsgServiceImpl implements MsgService {
    @Autowired(required=true)
    private JqLibraryDialogMapper jqLibraryDialogMapper;

    @Override
    public Map<String, String> getCikuChche(String key) {
        Map<String, String> map = new HashMap<>();
        if (key=="all") {
            map = getCikuChcheAll();//缓存消息器 调用 （在v2.x中将实现）
        }else{
            return getCikuChcheByKey( key );
        }
        return map;
    }

    /**
     * 为消息对话缓存器注入map
     * @return
     */
    private Map<String, String>  getCikuChcheAll() {
        List<JqLibraryDialog> jqLibraryDialogs = jqLibraryDialogMapper.selectList(null);
        System.out.println(jqLibraryDialogs);
        //jdk1.8 中将 List转 Map的方法
        Map<String, String> map = jqLibraryDialogs.stream().collect(Collectors.toMap(JqLibraryDialog::getKkey, JqLibraryDialog::getValue, (key1, key2) -> key2));
        return map;
    }

    /**
     * 根据key查询对应val回答
     * @param key
     * @return
     */
    private Map<String, String> getCikuChcheByKey(String key) {
        HashMap<String, String> map = new HashMap<>();
        String valByKey = jqLibraryDialogMapper.getValByKey(key);
        if (valByKey == null) return null;
        map.put(key,valByKey);
        return map;
    }
}
