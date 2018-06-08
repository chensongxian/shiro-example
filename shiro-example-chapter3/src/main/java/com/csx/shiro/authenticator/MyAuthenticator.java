package com.csx.shiro.authenticator;

import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author csx
 * @Package com.csx.shiro.authenticator
 * @Description: TODO
 * @date 2018/6/8 0008
 */
public class MyAuthenticator extends ModularRealmAuthenticator {
    public void setBytes(byte[] bytes) {
        System.out.println(new String(bytes));
    }

    public void setArray(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }

    public void setSet(Set<Realm> realms) {
        System.out.println(realms);
    }

    public void setMap(Map<Object, Object> maps) {
        System.out.println(maps);
        System.out.println(maps.get("1"));
    }
}
