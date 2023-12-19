package com.green;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam1 {

    @Test
    @DisplayName("이것은 무엇무엇을 테스트")
    public void 테스트1(){
        System.out.println("test1");
        int sum =2+2;
        Assertions.assertEquals(4, sum);
    }
    @Test
    public void test2(){
        System.out.println("test2");
        int multi =2*3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    void test3(){
        System.out.println("test3");
        Assertions.assertEquals(4, MyUtils.sum(2,2));
        Assertions.assertEquals(5,MyUtils.sum(2,3));
        Assertions.assertEquals(15,MyUtils.sum(12,3));
        Assertions.assertEquals(18,MyUtils.sum(5,13));

    }
    @Test
    void test4(){
        MyUtils utils = new MyUtils();
        Assertions.assertEquals(4, MyUtils.sum(2,2));
    }
}
