package com.xuhao.didi.core.utils;

import java.io.PrintStream;

public class SLog {
    private static boolean isDebug;

    public static void e(String str) {
        if (isDebug) {
            PrintStream printStream = System.err;
            printStream.println("OkSocket, " + str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            PrintStream printStream = System.out;
            printStream.println("OkSocket, " + str);
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setIsDebug(boolean z2) {
        isDebug = z2;
    }

    public static void w(String str) {
        i(str);
    }
}
