package com.hk;

import java.util.HashMap;
import java.util.Map;

// android 里面的 wms，ams 等等系统单例服务都是这样的
// 利用 map 管理就可以
class SingletonManager {
    private static Map<String, Object> objectMap = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object obj) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key, obj);
        }
    }

    public static Object getService(String key) {
        return objectMap.get(key);
    }
}
