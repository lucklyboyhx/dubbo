package org.hx.common.service.service.redis;

public interface RedisService {

    void put(String key, Object value, int expireTime);
    
    Object get(String key);
}
