package com.movie.data.remotejs;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.movie.data.remotejs.RemoteJSModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoteJSPackage implements ReactPackage, RemoteJSModule.ReactListener {

    /* renamed from: a  reason: collision with root package name */
    private RemoteJSModule f31948a;

    /* renamed from: b  reason: collision with root package name */
    RemoteJSModule.ReactListener f31949b;

    public void a(String str, String str2) {
        RemoteJSModule.ReactListener reactListener = this.f31949b;
        if (reactListener != null) {
            reactListener.a(str, str2);
        }
    }

    public void b(String str) {
        RemoteJSModule.ReactListener reactListener = this.f31949b;
        if (reactListener != null) {
            reactListener.b(str);
        }
    }

    public void c(RemoteJSModule.ReactListener reactListener) {
        this.f31949b = reactListener;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        RemoteJSModule remoteJSModule = new RemoteJSModule(reactApplicationContext);
        this.f31948a = remoteJSModule;
        remoteJSModule.setReactListener(this);
        arrayList.add(this.f31948a);
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public void onError(String str) {
        RemoteJSModule.ReactListener reactListener = this.f31949b;
        if (reactListener != null) {
            reactListener.onError(str);
        }
    }
}
