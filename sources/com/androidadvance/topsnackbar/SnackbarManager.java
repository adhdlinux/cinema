package com.androidadvance.topsnackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

class SnackbarManager {

    /* renamed from: e  reason: collision with root package name */
    private static SnackbarManager f13670e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f13671a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f13672b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.f((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private SnackbarRecord f13673c;

    /* renamed from: d  reason: collision with root package name */
    private SnackbarRecord f13674d;

    interface Callback {
        void a(int i2);

        void show();
    }

    private static class SnackbarRecord {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<Callback> f13676a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f13677b;

        SnackbarRecord(int i2, Callback callback) {
            this.f13676a = new WeakReference<>(callback);
            this.f13677b = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean d(Callback callback) {
            return callback != null && this.f13676a.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    private boolean b(SnackbarRecord snackbarRecord, int i2) {
        Callback callback = (Callback) snackbarRecord.f13676a.get();
        if (callback == null) {
            return false;
        }
        callback.a(i2);
        return true;
    }

    static SnackbarManager e() {
        if (f13670e == null) {
            f13670e = new SnackbarManager();
        }
        return f13670e;
    }

    /* access modifiers changed from: private */
    public void f(SnackbarRecord snackbarRecord) {
        synchronized (this.f13671a) {
            if (this.f13673c == snackbarRecord || this.f13674d == snackbarRecord) {
                b(snackbarRecord, 2);
            }
        }
    }

    private boolean h(Callback callback) {
        SnackbarRecord snackbarRecord = this.f13673c;
        return snackbarRecord != null && snackbarRecord.d(callback);
    }

    private boolean i(Callback callback) {
        SnackbarRecord snackbarRecord = this.f13674d;
        return snackbarRecord != null && snackbarRecord.d(callback);
    }

    private void m(SnackbarRecord snackbarRecord) {
        int i2;
        if (snackbarRecord.f13677b != -2) {
            if (snackbarRecord.f13677b > 0) {
                i2 = snackbarRecord.f13677b;
            } else if (snackbarRecord.f13677b == -1) {
                i2 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            } else {
                i2 = 2750;
            }
            this.f13672b.removeCallbacksAndMessages(snackbarRecord);
            Handler handler = this.f13672b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), (long) i2);
        }
    }

    private void o() {
        SnackbarRecord snackbarRecord = this.f13674d;
        if (snackbarRecord != null) {
            this.f13673c = snackbarRecord;
            this.f13674d = null;
            Callback callback = (Callback) snackbarRecord.f13676a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f13673c = null;
            }
        }
    }

    public void c(Callback callback) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                this.f13672b.removeCallbacksAndMessages(this.f13673c);
            }
        }
    }

    public void d(Callback callback, int i2) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                b(this.f13673c, i2);
            } else if (i(callback)) {
                b(this.f13674d, i2);
            }
        }
    }

    public boolean g(Callback callback) {
        boolean z2;
        synchronized (this.f13671a) {
            if (!h(callback)) {
                if (!i(callback)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public void j(Callback callback) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                this.f13673c = null;
                if (this.f13674d != null) {
                    o();
                }
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                m(this.f13673c);
            }
        }
    }

    public void l(Callback callback) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                m(this.f13673c);
            }
        }
    }

    public void n(int i2, Callback callback) {
        synchronized (this.f13671a) {
            if (h(callback)) {
                int unused = this.f13673c.f13677b = i2;
                this.f13672b.removeCallbacksAndMessages(this.f13673c);
                m(this.f13673c);
                return;
            }
            if (i(callback)) {
                int unused2 = this.f13674d.f13677b = i2;
            } else {
                this.f13674d = new SnackbarRecord(i2, callback);
            }
            SnackbarRecord snackbarRecord = this.f13673c;
            if (snackbarRecord == null || !b(snackbarRecord, 4)) {
                this.f13673c = null;
                o();
            }
        }
    }
}
