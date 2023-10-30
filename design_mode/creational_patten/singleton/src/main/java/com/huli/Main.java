package com.huli;

import com.huli.domain.SingObject;

public class Main {
    public static void main(String[] args) {


        //    //假设使用构造函数则会报错,说明是私有的构造函数
//    SingObject singObject = new SingObject();

        //获取唯一可用对象
        SingObject singObject = SingObject.getInstance();

        //显示信息
        singObject.showMessage();

    }

}