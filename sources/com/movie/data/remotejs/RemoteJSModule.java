package com.movie.data.remotejs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RemoteJSModule extends ReactContextBaseJavaModule {
    private ReactListener reactListener;

    public interface ReactListener {
        void a(String str, String str2);

        void b(String str);

        void onError(String str);
    }

    public RemoteJSModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "RemoteJS";
    }

    public ReactListener getReactListener() {
        return this.reactListener;
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void onComplete(String str) {
        ReactListener reactListener2 = this.reactListener;
        if (reactListener2 != null) {
            reactListener2.b(str);
        }
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void onData(String str, String str2) {
        ReactListener reactListener2 = this.reactListener;
        if (reactListener2 != null) {
            reactListener2.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void onError(String str) {
        ReactListener reactListener2 = this.reactListener;
        if (reactListener2 != null) {
            reactListener2.onError(str);
        }
    }

    public void setReactListener(ReactListener reactListener2) {
        this.reactListener = reactListener2;
    }
}
