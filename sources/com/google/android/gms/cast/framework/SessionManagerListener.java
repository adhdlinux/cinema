package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.Session;

public interface SessionManagerListener<T extends Session> {
    void onSessionEnded(T t2, int i2);

    void onSessionEnding(T t2);

    void onSessionResumeFailed(T t2, int i2);

    void onSessionResumed(T t2, boolean z2);

    void onSessionResuming(T t2, String str);

    void onSessionStartFailed(T t2, int i2);

    void onSessionStarted(T t2, String str);

    void onSessionStarting(T t2);

    void onSessionSuspended(T t2, int i2);
}
