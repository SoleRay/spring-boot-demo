package com.demo.util.token;


import com.demo.util.Constants;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Administrator on 2017-8-5.
 */
public class TokenUtil {

    public static String generateToken(String param) {
        String token = DigestUtils.md5Hex((System.currentTimeMillis()+ Constants.TOKEN_SALT+param));
        return token;
    }
}
