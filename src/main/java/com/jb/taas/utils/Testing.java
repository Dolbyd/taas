package com.jb.taas.utils;


public class Testing {

    private static int count = 1;

    public static void printCaption(String content){
        System.out.printf("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Test #%d - %s @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n",count++,content);
    }
}