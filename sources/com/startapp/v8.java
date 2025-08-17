package com.startapp;

import android.content.Context;
import java.lang.Thread;

public class v8 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36732a;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f36733b;

    public v8(Context context) {
        this.f36732a = context;
    }

    public final void a(Thread thread, Throwable th) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f36733b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (lb.a(th) != null) {
                if ("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n|   https://support.start.io/hc/en-us/articles/360014774799   |\n+-------------------------------------------------------------+\n".equals(th.getMessage())) {
                    a(thread, th);
                    return;
                }
                y8.a(this.f36732a, th, z8.f36999f);
            }
        } catch (Throwable unused) {
        }
        a(thread, th);
    }
}
