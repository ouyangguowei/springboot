package com.ouyoung.web.entity;

import com.alibaba.fastjson.JSONObject;
import com.ouyoung.api.dto.BaseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: ouyoung
 * @Date: 2018/9/19
 */
@Getter@Setter
public class Test extends BaseDTO {

    private String id;
    private Date time;
    private Boolean flag;
    private Long num;


    public static void main(String[] args) {
        Test t = new Test();
        t.setId("1");
        t.setTime(new Date());
        t.setFlag(true);
        t.setNum(1l);
        System.out.println(t);
        System.out.println(JSONObject.toJSONString(t));
    }
}
