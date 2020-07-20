package com.mycompany.pos.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

public class CouponGenerator {
    private static final String COUPON_PREFIX = "KM";
    private static final int COUPON_LENGTH = 8;

    public String createCouponCode(){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();

        sb.append(COUPON_PREFIX);

        Random random = new SecureRandom();
        for (int i = 0; i < COUPON_LENGTH; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output ;
    }
}
