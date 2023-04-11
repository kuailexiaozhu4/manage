package com.zhu.manage.utils;

import com.zhu.manage.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Component
public class TokenFactory {
    //    盐值不可以设置过短,太短会报异常
    private String secret = "zhuwulong";
    //    过期时间 s  30*60
    private long expiration = 60 * 60;

    public String generateToken(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", user.getPhone());
        map.put("hospitalId", user.getHospitalId());
//        token产生时间
        map.put("created", new Date());
        return this.generateJwt(map);
    }

    public String generateJwt(Map<String, Object> map) {
        return Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    //    从token中获取荷载
    public Claims getTokenBody(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }

    public String getUserPhoneByToken(String token) {
        return (String) this.getTokenBody(token).get("phone");
    }

    public Integer getHospitalIdByToken(String token) {
        return (Integer) this.getTokenBody(token).get("hospitalId");
    }

    public boolean expiredToken(String token) {
//        false 没过期
        try {
            return this.getTokenBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public String refreshToken(String token) {
        Claims claims = this.getTokenBody(token);
        claims.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000));
        return this.generateJwt(claims);
    }

    public boolean validateToken(String token) {
        return expiredToken(token);
    }
}
