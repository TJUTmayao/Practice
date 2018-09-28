package xsl.sso.service;

import pojo.Result;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/21 15:34
 * @Description:
 */
public interface CheckService {

    Result getCheckResult(String token);
}
