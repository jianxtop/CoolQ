package top.jianx.coolq.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CacheConfig {
    private Map<String, String> configMap;
    public CacheConfig() {
        configMap = new HashMap<>();
    }



}
