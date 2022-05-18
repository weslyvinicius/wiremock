package com.academy.mockserver.util;

import com.academy.mockserver.config.MapperConfig;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestUtils {


    public static <T> T mapperReader(String fileNameOrObject, Class<T> className) throws IOException {
        return mapperReader(fileNameOrObject, className, true);
    }

    public static <T> T mapperReader(String fileNameOrObject, Class<T> className, boolean isFile) throws IOException {
        return MapperConfig.objectMapperConfig().readValue(isFile ? readFile(fileNameOrObject) : fileNameOrObject, className);
    }

    private static String readFile(String path) throws IOException {
        File jsonRequest = ResourceUtils.getFile(path);
        return new String(Files.readAllBytes(jsonRequest.toPath()));
    }

    public static String writeValueAsString(Object obj) throws JsonProcessingException {
        return MapperConfig.objectMapperConfig().writeValueAsString(obj);
    }


}
