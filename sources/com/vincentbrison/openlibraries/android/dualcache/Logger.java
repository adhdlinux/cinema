package com.vincentbrison.openlibraries.android.dualcache;

import android.util.Log;

final class Logger {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f37815a;

    Logger(boolean z2) {
        this.f37815a = z2;
    }

    private void a(int i2, String str, String str2) {
        if (this.f37815a) {
            Log.println(i2, str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Throwable th) {
        if (this.f37815a) {
            Log.e("dualcache", "error : ", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        a(4, "dualcache", str);
    }
}
