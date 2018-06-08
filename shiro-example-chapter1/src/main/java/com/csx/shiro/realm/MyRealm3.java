package com.csx.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author csx
 * @Package com.csx.shiro.realm
 * @Description: TODO
 * @date 2018/6/8 0008
 */
public class MyRealm3 implements Realm {
    private static final String NAME="zhang";
    private static final String PW="123";
    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        String loginName = (String) authenticationToken.getPrincipal();
        // 得到密码
        String password= new String((char[]) authenticationToken.getCredentials());
        if(!NAME.equals(loginName)){
            //用户名错误
            throw new UnknownAccountException();
        }
        if(!PW.equals(password)){
            //密码错误
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(loginName+"@163.com",password,getName());
    }
}
