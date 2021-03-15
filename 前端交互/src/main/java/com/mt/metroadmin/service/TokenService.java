package com.mt.metroadmin.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.metroadmin.entity.Admin;
import com.mt.metroadmin.entity.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    @Autowired
    Audience audience;

    public String getToken(Admin admin) {
        String token = "";
        token = JWT.create().withAudience(admin.getUserName())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(audience.getBase64Secret()));// 以 password 作为 token 的密钥
        return token;
    }


}
