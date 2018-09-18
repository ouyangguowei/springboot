package com.ouyoung.api.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Author ouyoung
 * @Date 2018/9/19
 */
public class BaseDTO implements Serializable {

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
