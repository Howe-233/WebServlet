package com.hzlx.utils;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/5/24 16:45
 */
@Data
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    private BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static String success() {
        Gson gson = new Gson();
        return gson.toJson(new BaseResponse(200, "success", null));
    }

    public static <T> String success(T data) {
        Gson gson = new Gson();
        return gson.toJson(new BaseResponse(200, "success", data));
    }

    public static String error(Integer code, String msg) {
        Gson gson = new Gson();
        return gson.toJson(new BaseResponse(code, msg, null));
    }
}
