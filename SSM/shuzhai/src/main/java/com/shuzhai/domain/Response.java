package com.shuzhai.domain;


/**
 * {
 *     "meta":{
 *         "success":"true/false",
 *         "message":"ok/error/自定义错误信息",
 *     },
 *     "data":{
 *         ....
 *     }
 * }
 *
 *
 * */


import javafx.scene.paint.Material;

/**
 * @program: shuzhai
 * @description: 统一的 json 返回格式
 * @author: Jay
 * @create: 2019-10-11 17:23
 **/

public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;

    public Response success(){
        this.meta = new Meta(true, OK);
        return this;
    }

    public Response success(Object data){
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure(){
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String message){
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*
    *  @description: 内部类
    * */
    public class Meta{
        private boolean success;
        private String message;

        Meta(boolean success, String message){
            this.success = success;
            this.message = message;
        }

        Meta(boolean success){
            this.success =  success;
        }

        public boolean isSuccess(){
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

}
