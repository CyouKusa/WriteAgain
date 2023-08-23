package com.example.writeagain.vo;

public class Result {
    private int code;
    private String text;
    private Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", text='" + text + '\'' +
                ", object=" + object +
                '}';
    }

    public static Result ok(Object object){
        Result result = new Result();
        result.code=200;
        result.text="成功";
        result.object= object;
        return result;
    }

    public static Result error(String... message){
        Result result = new Result();
        result.code=500;
        if (message.length==0){
            result.setText("系统出错,请联系管理员");
        } else{
            result.setText(message[0]);
        }
        result.object=null;
        return result;
    }
}
