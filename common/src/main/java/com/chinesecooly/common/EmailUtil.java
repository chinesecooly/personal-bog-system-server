package com.chinesecooly.common;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
    public static void sendEmail(String emailAddress,String code) throws EmailException {
            //能发邮箱的一个对象
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.163.com");
            email.setCharset("UTF-8");
            // 收件人的邮箱地址
            email.addTo(emailAddress);
            //此处填发件人邮箱地址和用户名,用户名可以任意填写
            email.setFrom("superstallion@163.com", "superstallion.cn");
            //发件人的邮箱地址 和 发件人的授权码；这个授权码是需要发件人提前开通和生成的
            email.setAuthentication("superstallion@163.com", "KNFGKRLVNXUBNONZ");
            ////此处填写邮件主题
            Email email1 = email.setSubject("chinesecooly.com注册验证码");
            //设置邮件正文
            email.setMsg("<h2>尊敬的用户您好,您本次注册的验证码是:</h2>"+"<h1>"+code+"</h1>");
            email.send();
    }
}
