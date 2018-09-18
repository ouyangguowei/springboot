package com.oygw.pattern.reference;

import java.io.IOException;
import java.io.Serializable;

/**
 * @Author: ouyoung
 * @Date: 2018/9/8
 */
public class Reference {

    class adc implements Serializable {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int a = "a".hashCode();
        int bbb = "666".hashCode();
        int dif = "dif".hashCode();

        System.out.println( a) ;
        System.out.println( a & 15) ;
        System.out.println( bbb ) ;
        System.out.println( bbb & 15) ;
        System.out.println( dif ) ;
        System.out.println( dif & 15) ;



    }
}
