package cn.tekin.jbpm.demo.jbpmdemo;

import cn.tekin.jbpm.demo.config.DroolsAutoConfiguration;
import cn.tekin.jbpm.demo.util.MD5Util;
import cn.tekin.jbpm.demo.util.ShaUtil;

public class Test {

    @org.junit.Test
    public void md5Test(){
        System.out.println(MD5Util.getMD5("123123"));
    }

    @org.junit.Test
    public void shaTest() {
        System.out.println(ShaUtil.getSHA256("888888"));
    }

    public static void main(String[] args){
        DroolsAutoConfiguration droolsAutoConfiguration = new DroolsAutoConfiguration();

    }
}
