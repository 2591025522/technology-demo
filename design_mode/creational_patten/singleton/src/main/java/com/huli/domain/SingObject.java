package com.huli.domain;

public class SingObject {

    //创建SingleObject对象
    private static SingObject instance = new SingObject();

    //让构造函数为私有就不能被实例化。
    private SingObject(){};

    //获取可用对象
    public static SingObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("欢迎来到单例模式！");
    }

}
