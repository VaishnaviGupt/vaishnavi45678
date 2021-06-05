package com.amcicustomer.utils;

import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.enums.ConfigProperties;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private static final Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try(FileInputStream fileInputStream = new FileInputStream( FrameWorkConstants.getCONFIGSPATH())) {
            properties.load(fileInputStream);
            properties.forEach((key, value) -> CONFIGMAP.put(String.valueOf(key), String.valueOf(value).trim()));//Remove the trailing and Leading spaces
           } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    private PropertyUtils() {

    }

    /**
     * @param key key name
     * @return value of key
     */
    @SneakyThrows
    public static String getValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("property name " + key + " is not found please check config.property");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }


}

