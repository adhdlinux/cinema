package com.orm;

public class SugarContext {
    public static SugarContext a() {
        throw new NullPointerException("SugarContext has not been initialized properly. Call SugarContext.init(Context) in your Application.onCreate() method and SugarContext.terminate() in your Application.onTerminate() method.");
    }
}
