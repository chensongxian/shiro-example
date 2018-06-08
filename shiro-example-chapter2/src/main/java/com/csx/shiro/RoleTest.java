package com.csx.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author csx
 * @Package com.csx.shiro
 * @Description: TODO
 * @date 2018/6/8 0008
 */
public class RoleTest extends BaseTest{
    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini","zhang","123");
        // 判断拥有角色role1
        Assert.assertEquals(true,subject().hasRole("role1"));
        // 判断拥有角色role1、role2
        Assert.assertEquals(true,subject().hasAllRoles(Arrays.asList("role1","role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }
}
