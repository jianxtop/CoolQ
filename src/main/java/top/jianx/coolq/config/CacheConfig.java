package top.jianx.coolq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.jianx.coolq.service.MsgService;

import java.util.HashMap;
import java.util.Map;

public class CacheConfig {
    private static Map<String, String> cikuChche;
    @Autowired
    private MsgService msgService;
    public CacheConfig() {
        this.cikuChche = new HashMap<>();
        setCikuCache();
    }

    public static Map<String, String> getLibrary(){
        return cikuChche;
    }

    private void setCikuCache() {
        Map<String, String> map = msgService.getCikuChche("all");
        for (Map.Entry<String, String> entry : map.entrySet()) {

        }
    }


}
