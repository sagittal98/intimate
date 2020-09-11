package com.intimate.common.token;

import com.intimate.common.enums.ResultStateEnum;
import com.intimate.common.model.CheckResult;
import io.jsonwebtoken.*;
import org.apache.directory.api.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtUtils {
    /**
     * 签发JWT
     *
     * @param jti  唯一标识
     * @param sub   可以是JSON数据 尽可能少
     * @param ttlMillis  过期时间
     * @return String
     *
     */
    public static String createJWT(String jti, String sub, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder().setId(jti).setSubject(sub) // 主题
                .setIssuer("hydrogen_honey") // 签发者
                .setIssuedAt(now) // 签发时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     *
     * @param jwtStr
     * @return
     */
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(ResultStateEnum.JWT_ERROR_CODE_EXPIRE.getState());
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(ResultStateEnum.JWT_ERROR_CODE_FAIL.getState());
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(ResultStateEnum.JWT_SECRET);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     *
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    private static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
    }

}
