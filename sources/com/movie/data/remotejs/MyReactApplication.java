package com.movie.data.remotejs;

import android.app.Application;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.reactnativecommunity.cookies.CookieManagerPackage;
import java.util.Arrays;
import java.util.List;

public class MyReactApplication extends Application implements ReactApplication {

    /* renamed from: b  reason: collision with root package name */
    private final ReactNativeHost f31945b = new ReactNativeHost(this) {
        /* access modifiers changed from: protected */
        public String getJSMainModuleName() {
            return "index";
        }

        /* access modifiers changed from: protected */
        public List<ReactPackage> getPackages() {
            MyReactApplication.this.f31946c = new RemoteJSPackage();
            return Arrays.asList(new ReactPackage[]{new MainReactPackage(), new CookieManagerPackage(), MyReactApplication.this.f31946c});
        }

        public boolean getUseDeveloperSupport() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    RemoteJSPackage f31946c;

    public RemoteJSPackage g() {
        return this.f31946c;
    }

    public ReactNativeHost getReactNativeHost() {
        return this.f31945b;
    }
}
