package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void> {
    private final NativeModuleCallExceptionHandler mExceptionHandler;

    @Deprecated
    protected GuardedAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    /* access modifiers changed from: protected */
    public abstract void doInBackgroundGuarded(Params... paramsArr);

    protected GuardedAsyncTask(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }

    /* access modifiers changed from: protected */
    public final Void doInBackground(Params... paramsArr) {
        try {
            doInBackgroundGuarded(paramsArr);
            return null;
        } catch (RuntimeException e2) {
            this.mExceptionHandler.handleException(e2);
            return null;
        }
    }
}
