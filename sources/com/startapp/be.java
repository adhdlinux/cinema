package com.startapp;

import android.content.Context;
import android.os.Bundle;

public abstract class be implements Runnable {
    public final a callback;
    public final Context context;
    public final Bundle extras;

    public interface a {
        void a(be beVar, boolean z2);
    }

    public be(Context context2, a aVar, Bundle bundle) {
        this.context = context2;
        this.callback = aVar;
        this.extras = bundle;
    }

    public void run() {
        this.callback.a(this, runSync());
    }

    public boolean runSync() {
        return false;
    }
}
