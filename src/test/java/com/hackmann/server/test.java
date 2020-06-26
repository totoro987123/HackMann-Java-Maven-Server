package com.hackmann.server;

import com.hackmann.server.*;

import java.util.Arrays;

import com.hackmann.packets.*;

public class test {
    public static void main(String[] args){
        int headerSize = 10;
        Serializer ser = new Serializer(headerSize);
        byte[] send = {/*50, 55, 45, 45, 45, 45, 45, 45, 45, 45,*/ 123, 34, 99, 108, 97, 115, 115, 78, 97, 109, 101, 34, 58, 32, 34, 80, 108, 97, 121, 101, 114, 74, 111, 105, 110, 34, 125};
        System.out.println(Arrays.toString(send));
        send = ser.eventToBytes(ser.bytesToEvent(send));
        System.out.println(Arrays.toString(send));
        send = ser.eventToBytes(ser.bytesToEvent(send));
        System.out.println(Arrays.toString(send));
        send = ser.eventToBytes(ser.bytesToEvent(send));
        System.out.println(Arrays.toString(send));
        
    }
}