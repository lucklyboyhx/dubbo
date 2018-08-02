package org.hx.redis.service;

import org.hx.common.service.service.redis.RedisService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService{

    @Override
    public void put(String key, Object value, int expireTime) {
        RedisUtil.put(key, value);
    }

    @Override
    public Object get(String key) {
        return RedisUtil.get(key);
    }

}
