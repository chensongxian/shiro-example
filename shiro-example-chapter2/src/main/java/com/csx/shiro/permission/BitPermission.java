package com.csx.shiro.permission;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * @author csx
 * @Package com.csx.shiro.permission
 * @Description: TODO
 * @date 2018/6/8 0008
 */
public class BitPermission implements Permission {
    private String resourceIdentify;
    private int permissionBit;
    private String instanceId;

    private static Integer first=1;
    private static Integer second=2;
    private static Integer third=3;

    public BitPermission(String permissionStr) {
        String[] array=permissionStr.split("\\+");
        if(array.length>first){
            resourceIdentify=array[1];
        }
        if(StringUtils.isEmpty(resourceIdentify)){
            resourceIdentify="*";
        }

        if(array.length>second){
            permissionBit=Integer.valueOf(array[2]);
        }

        if(array.length>third){
            instanceId=String.valueOf(array[3]);
        }
        if(StringUtils.isEmpty(instanceId)){
            instanceId="*";
        }
    }

    @Override
    public boolean implies(Permission p) {
        if(!(p instanceof BitPermission)) {
            return false;
        }
        BitPermission other = (BitPermission) p;

        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {
            return false;
        }

        if(!(this.permissionBit ==0 || (this.permissionBit & other.permissionBit) != 0)) {
            return false;
        }

        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BitPermission{" +
                "resourceIdentify='" + resourceIdentify + '\'' +
                ", permissionBit=" + permissionBit +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
