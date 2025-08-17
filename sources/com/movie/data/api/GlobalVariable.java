package com.movie.data.api;

import com.google.gson.GsonBuilder;
import com.movie.data.model.AppConfig;
import com.movie.data.model.ServerConfig;
import com.utils.PrefUtils;
import com.utils.Utils;

public class GlobalVariable {

    /* renamed from: c  reason: collision with root package name */
    private static GlobalVariable f31901c;

    /* renamed from: a  reason: collision with root package name */
    public ServerConfig f31902a = new ServerConfig();

    /* renamed from: b  reason: collision with root package name */
    private AppConfig f31903b = null;

    public static void a() {
        f31901c = null;
    }

    public static GlobalVariable c() {
        if (f31901c == null) {
            f31901c = new GlobalVariable();
        }
        return f31901c;
    }

    public AppConfig b() {
        Class cls = AppConfig.class;
        if (this.f31903b == null) {
            try {
                AppConfig appConfig = (AppConfig) new GsonBuilder().b().l(PrefUtils.j(Utils.v()), cls);
                this.f31903b = appConfig;
                if (appConfig != null) {
                    return appConfig;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                AppConfig appConfig2 = (AppConfig) new GsonBuilder().b().l(Utils.getFallbackCf(), cls);
                this.f31903b = appConfig2;
                if (appConfig2 != null) {
                    return appConfig2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return this.f31903b;
    }

    public void d(String str) {
        if (str.contains("android")) {
            PrefUtils.l(Utils.v(), str);
            this.f31903b = null;
        }
    }
}
