package com.demo.util.sensitive;

import com.demo.util.Constants;
import org.apache.commons.lang3.StringUtils;

public class SensitiveUtil {

    public static String deSensitivePhone(String phone){
        if(StringUtils.isNotBlank(phone)){
            String prefix = phone.substring(0,3);
            String suffix = phone.substring(7);
            return prefix + Constants.SENSITIVE_SYMBOL+suffix;
        }
        return null;
    }
}
