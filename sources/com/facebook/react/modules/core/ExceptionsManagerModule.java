package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.ExceptionDataHelper;
import com.facebook.react.util.JSStackTrace;

@ReactModule(name = "ExceptionsManager")
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {
    public static final String NAME = "ExceptionsManager";
    private final DevSupportManager mDevSupportManager;

    public ExceptionsManagerModule(DevSupportManager devSupportManager) {
        super((ReactApplicationContext) null);
        this.mDevSupportManager = devSupportManager;
    }

    public void dismissRedbox() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.hideRedboxDialog();
        }
    }

    public String getName() {
        return NAME;
    }

    public void reportException(ReadableMap readableMap) {
        String str;
        ReadableArray readableArray;
        boolean z2;
        if (readableMap.hasKey("message")) {
            str = readableMap.getString("message");
        } else {
            str = "";
        }
        if (readableMap.hasKey("stack")) {
            readableArray = readableMap.getArray("stack");
        } else {
            readableArray = Arguments.createArray();
        }
        if (readableMap.hasKey("isFatal")) {
            z2 = readableMap.getBoolean("isFatal");
        } else {
            z2 = false;
        }
        String extraDataAsJson = ExceptionDataHelper.getExtraDataAsJson(readableMap);
        if (!z2) {
            FLog.e(ReactConstants.TAG, JSStackTrace.format(str, readableArray));
            if (extraDataAsJson != null) {
                FLog.d(ReactConstants.TAG, "extraData: %s", (Object) extraDataAsJson);
                return;
            }
            return;
        }
        throw new JavascriptException(JSStackTrace.format(str, readableArray)).setExtraDataAsJson(extraDataAsJson);
    }

    public void reportFatalException(String str, ReadableArray readableArray, double d2) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d2);
        javaOnlyMap.putBoolean("isFatal", true);
        reportException(javaOnlyMap);
    }

    public void reportSoftException(String str, ReadableArray readableArray, double d2) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d2);
        javaOnlyMap.putBoolean("isFatal", false);
        reportException(javaOnlyMap);
    }

    public void updateExceptionMessage(String str, ReadableArray readableArray, double d2) {
        int i2 = (int) d2;
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.updateJSError(str, readableArray, i2);
        }
    }
}
