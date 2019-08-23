package com.example.demo.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @createDate: 2019-08-22 14:05
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterRedisConfig {
    private List<String> nodes;

    private int maxRedirects;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public int getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(int maxRedirects) {
        this.maxRedirects = maxRedirects;
    }
}
