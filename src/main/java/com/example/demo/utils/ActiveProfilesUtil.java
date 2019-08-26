package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @createDate: 2019-08-26 16:40
 * @description:
 */
public class ActiveProfilesUtil {
    private Environment environment;

    @Autowired
    public ActiveProfilesUtil(Environment environment) {
        this.environment = environment;
    }

    public String getActiveProfiles() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles != null) {
            return activeProfiles[0];
        }
        return null;
    }
}
