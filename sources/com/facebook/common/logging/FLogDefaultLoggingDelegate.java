package com.facebook.common.logging;

import android.util.Log;
import com.facebook.infer.annotation.Nullsafe;
import java.io.PrintWriter;
import java.io.StringWriter;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    private String mApplicationTag = "unknown";
    private int mMinimumLoggingLevel = 5;

    private FLogDefaultLoggingDelegate() {
    }

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    private static String getMsg(String str, Throwable th) {
        return str + 10 + getStackTraceString(th);
    }

    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private String prefixTag(String str) {
        if (this.mApplicationTag == null) {
            return str;
        }
        return this.mApplicationTag + ":" + str;
    }

    private void println(int i2, String str, String str2) {
        Log.println(i2, prefixTag(str), str2);
    }

    public void d(String str, String str2) {
        println(3, str, str2);
    }

    public void e(String str, String str2) {
        println(6, str, str2);
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public void i(String str, String str2) {
        println(4, str, str2);
    }

    public boolean isLoggable(int i2) {
        return this.mMinimumLoggingLevel <= i2;
    }

    public void log(int i2, String str, String str2) {
        println(i2, str, str2);
    }

    public void setApplicationTag(String str) {
        this.mApplicationTag = str;
    }

    public void setMinimumLoggingLevel(int i2) {
        this.mMinimumLoggingLevel = i2;
    }

    public void v(String str, String str2) {
        println(2, str, str2);
    }

    public void w(String str, String str2) {
        println(5, str, str2);
    }

    public void wtf(String str, String str2) {
        println(6, str, str2);
    }

    private void println(int i2, String str, String str2, Throwable th) {
        Log.println(i2, prefixTag(str), getMsg(str2, th));
    }

    public void d(String str, String str2, Throwable th) {
        println(3, str, str2, th);
    }

    public void e(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public void i(String str, String str2, Throwable th) {
        println(4, str, str2, th);
    }

    public void v(String str, String str2, Throwable th) {
        println(2, str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        println(5, str, str2, th);
    }

    public void wtf(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }
}
