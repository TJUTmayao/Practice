package xsl.sso.service;

import pojo.JWTpojo;
import pojo.Result;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/26 16:11
 * @Description:
 */
public interface JwtService {

    Result getJWTToken(JWTpojo jwTpojo);
    boolean checkJWTSign(String token);
    Result getPayloadByToken(String token);
    Result setTokenInRedis(String token);
}
