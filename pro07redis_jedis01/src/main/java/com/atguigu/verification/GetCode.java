package com.atguigu.verification;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Scanner;

public class GetCode {
    public static void main(String[] args) {
//        1.输入手机号
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入手机号码：");
        //2.点击发送后随机生成6位数字码，2分钟有效
        String phone = scanner.next();
        System.out.println("输入1确定发送：");
        String code = sendPhone(phone);
        if ("-1".equals(code)){
            System.out.println("今天输入验证码已经超过3次，请明天再试");
            return;//结束程序
        }
        System.out.println("验证码是："+code);
        //3、输入验证码，点击验证，返回成功或失败
        System.out.println("请输入验证码:");
        String myCode = scanner.next();
        boolean flag = verifyCode(phone, myCode);
        if (flag){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }

    }

    //验证
    public static boolean verifyCode(String phone,String myCode){
        boolean flag = false;
        Jedis jedis = new Jedis("192.168.6.99",6379);
        String codeKey = "code:"+phone;
        String code = jedis.get(codeKey);
        if (myCode.equals(code)){
            flag = true;
            jedis.close();
        }
        return flag;
    }

    //
    public static String sendPhone(String phone){
        Jedis jedis = new Jedis("192.168.6.99",6379);
        String code = getCode();
        String codeKey = "code:"+phone;
        //保存在redis中，并且设置两分钟有效
        //jedis.setex("codeKey",120,code);
        jedis.setex(codeKey,120,code);
        //每个手机号只能输入3次
        String countKey = "count:"+phone;
        String count = jedis.get(countKey);
        if (count == null){
            jedis.setex(countKey,60*60*24,"1");
        } else if (Integer.parseInt(count)<3){
            jedis.incr(countKey);
        } else {
            System.out.println("超过3次");
            code = "-1";
        }
        jedis.close();

        return code;
    }
    public static String getCode(){
        //生成六位数验证码
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            str.append(r);
        }
        return String.valueOf(str);
        //将验证码放入redis，设置过期时间2分钟
        //每次生成验证码以后+1
        //判断验证码是否正确
    }
}