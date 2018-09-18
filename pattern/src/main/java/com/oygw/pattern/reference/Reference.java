package com.oygw.pattern.reference;

import org.apache.tomcat.jni.User;

import java.io.*;

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


        User user = new User();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(user);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        User newUser= (User)ois.readObject();

    }
}
