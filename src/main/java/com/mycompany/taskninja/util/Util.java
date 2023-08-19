package com.mycompany.taskninja.util;

public class Util {
    public static int parseId(String id) {

        return (id==null) ? 0:Integer.parseInt(id);
    }
}
