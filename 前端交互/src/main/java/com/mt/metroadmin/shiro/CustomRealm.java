package com.mt.metroadmin.shiro;

import com.mt.metroadmin.entity.Admin;
import com.mt.metroadmin.mapper.AdminMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述：
 *
 * @author caojing
 * @create 2019-01-27-13:57
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Admin admin = adminMapper.selectByUserName(username);

        info.addRole(admin.getRole());
        //info.addStringPermission("show");

        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        System.out.println(userName+userPwd+"??");
        // 根据用户名从数据库获取密码
        // String password = "123";
        Admin admin = adminMapper.selectByUserName(userName);
        System.out.println(admin+"!!!!");
        if (admin == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(admin.getPassword())) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName, admin.getPassword(),getName());
    }
}
