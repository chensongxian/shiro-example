package com.csx.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author csx
 * @Package com.csx.shiro
 * @Description: TODO
 * @date 2018/6/8 0008
 */
public class LoginLogoutTest {
    @Test
    public void testHelloWolrd(){
        // 获取SecurityManager工厂，使用shiro.ini初始化SecurityManager
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        // 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();

    }

    @Test
    public void testCustomerRealm(){
        // 获取SecurityManager工厂，使用shiro.ini初始化SecurityManager
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        // 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }

    @Test
    public void testMultiRealm(){
        // 获取SecurityManager工厂，使用shiro.ini初始化SecurityManager
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        // 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("wang", "123");

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }

    @Test
    public void testJdbcRealm(){
        // 获取SecurityManager工厂，使用shiro.ini初始化SecurityManager
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        // 得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("wang", "123");

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }
}
