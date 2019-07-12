package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.example.demo.utils
 * @author:
 * @email:
 * @createDate: 2019-06-12 14:32
 * @description:
 */
@Setter
@Getter
public class JsonResult<T> implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer total;

    /**
     * 分页是数据合计
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer count;

    private String code;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private float accountBalance;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = "0";
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     *
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     *
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     *
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "0";
        this.msg = msg;
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     *
     * @param data
     * @param total
     */
    public JsonResult(T data, Integer total) {
        this.data = data;
        this.code = "0";
        this.msg = "操作成功！";
        this.total = total;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }


    public JsonResult(Builder builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = (T) builder.data;
    }


    public JsonResult Msg(String msg) {
        this.msg = msg;
        return new JsonResult(this);
    }

    public final static String SUCCESS = "0";
    public final static String FAIL = "1";
    public final static String EXCEPTION = "-1";

    public enum Code {

        Success("0"), // 成功
        Failure("1"),  // 失败
        Exception("-1"), // 异常
        SUCCESS("0", "调用成功"),
        FAIL("1", "操作失败"),
        EXCEPTION("-1", "请求异常"),

        USER_NOT_REGISTER_EXCEPTION("4000", "用户需要注册/wechat/user/{appid}/regist接口");

        private final String code;
        private String msg;

        Code(String code) {
            this.code = code;
        }

        Code(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }


        public String code() {
            return this.code;
        }

        public String msg() {
            return this.msg;
        }
    }

    public static class Builder<T> {

        private String code;

        private String msg;

        private HashMap<String, Object> data;

        public Builder code(Code code) {
            this.code = code.code();
            return this;
        }

        public Builder message(String message) {
            this.msg = message;
            return this;
        }

        public Builder data(String key, Object value) {
            if (this.data == null) {
                this.data = new HashMap<>();
            }
            this.data.put(key, value);
            return this;
        }

        public Builder data(Map<String, Object> map) {
            if (this.data == null) {
                this.data = new HashMap<>();
            }
            this.data.putAll(map);
            return this;
        }


        public JsonResult build() {
            return new JsonResult(this);
        }

        public JsonResult build(Code code) {
            this.code = code.code;
            this.msg = code.msg;
            return new JsonResult(this);
        }

        public JsonResult build(boolean result) {
            return build(result == true ? Code.SUCCESS : Code.FAIL);
        }
    }
}