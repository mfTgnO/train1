package com.example.demo.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.JSONFiledUtils;
import org.junit.Test;

/**
 * @createDate: 2019-09-24 17:27
 * @description:
 */
public class FastjsonDemo {
    @Test
    public void test1() {
//        String content = "{\"sentUser\":\"hanmangniu\",\"money\":\"0.00999960677160304\",\"content\":\"回复内容：<img alt=\'\uD83D\uDE1C\' class=\'emojioneemoji\' src=\'https://cdn.jsdelivr.net/emojione/assets/3.1/png/32/1f61c.png\'>\',\"cityCode\":\"610c22ec927111e9bbe854e1adf07fa6\",\"cityName\":\"Жезказган\",\"pictureCode\":\"p_2019091909282309243\"}";
        String content = "{\"sentUser\":\"hanmangniu\",\"money\":\"0.00999960677160304\",\"content\":\"回复内容：<img alt=\"\uD83D\uDE1C\" class=\"emojioneemoji\" src=\"https://cdn.jsdelivr.net/emojione/assets/3.1/png/32/1f61c.png\">\",\"cityCode\":\"610c22ec927111e9bbe854e1adf07fa6\",\"cityName\":\"Жезказган\",\"pictureCode\":\"p_2019091909282309243\"}";
//        String content = "{\"sentUser\":\"hanmangniu\",\"money\":\"0.00999945251250941\",\"content\":\"回复内容：1111111111\",\"cityCode\":\"610c22ec927111e9bbe854e1adf07fa6\",\"cityName\":\"Жезказган\",\"pictureCode\":\"p_2019091909282309243\"}";
        /*JSONObject  jsonObject= JSONObject.parseObject(content);
        System.out.println(jsonObject);*/

        String s = JSONFiledUtils.backSensitiveChar(content);
        JSONObject result = new JSONObject();
        result.put("content", s);
        /*JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);*/

        System.out.println(result);
    }
}