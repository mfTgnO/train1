package com.example.demo.config;

public enum RedisKeyPrefix {
    /**
     * 省份
     */
    PROVINCE("province:"),
    /**
     * 城市
     */
    CITY("city:"),
    /**
     * 区、县
     */
    COUNTRY("country:"),
    /**
     * 镇、街道
     */
    TOWN("town:"),
    /**
     * 用户（测试数据）
     */
    USER("user:");

    private String prefix;

    RedisKeyPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
