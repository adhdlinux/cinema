package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

class SnackbarManager {

    /* renamed from: e  reason: collision with root package name */
    private static SnackbarManager f30047e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f30048a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f30049b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private SnackbarRecord f30050c;

    /* renamed from: d  reason: collision with root package name */
    private SnackbarRecord f30051d;

    interface Callback {
        void a(int i2);

        void show();
    }

    private static class SnackbarRecord {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<Callback> f30053a;

        /* renamed from: b  reason: collision with root package name */
        int f30054b;

        /* renamed from: c  reason: collision with root package name */
        boolean f30055c;

        SnackbarRecord(int i2, Callback callback) {
            this.f30053a = new WeakReference<>(callback);
            this.f30054b = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Callback callback) {
            return callback != null && this.f30053a.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    private boolean a(SnackbarRecord snackbarRecord, int i2) {
        Callback callback = snackbarRecord.f30053a.get();
        if (callback == null) {
            return false;
        }
        this.f30049b.removeCallbacksAndMessages(snackbarRecord);
        callback.a(i2);
        return true;
    }

    static SnackbarManager c() {
        if (f30047e == null) {
            f30047e = new SnackbarManager();
        }
        return f30047e;
    }

    private boolean f(Callback callback) {
        SnackbarRecord snackbarRecord = this.f30050c;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f30051d;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private void l(SnackbarRecord snackbarRecord) {
        int i2 = snackbarRecord.f30054b;
        if (i2 != -2) {
            if (i2 <= 0) {
                if (i2 == -1) {
                    i2 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
                } else {
                    i2 = 2750;
                }
            }
            this.f30049b.removeCallbacksAndMessages(snackbarRecord);
            Handler handler = this.f30049b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), (long) i2);
        }
    }

    private void n() {
        SnackbarRecord snackbarRecord = this.f30051d;
        if (snackbarRecord != null) {
            this.f30050c = snackbarRecord;
            this.f30051d = null;
            Callback callback = snackbarRecord.f30053a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f30050c = null;
            }
        }
    }

    public void b(Callback callback, int i2) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                a(this.f30050c, i2);
            } else if (g(callback)) {
                a(this.f30051d, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(SnackbarRecord snackbarRecord) {
        synchronized (this.f30048a) {
            if (this.f30050c == snackbarRecord || this.f30051d == snackbarRecord) {
                a(snackbarRecord, 2);
            }
        }
    }

    public boolean e(Callback callback) {
        boolean z2;
        synchronized (this.f30048a) {
            if (!f(callback)) {
                if (!g(callback)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public void h(Callback callback) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                this.f30050c = null;
                if (this.f30051d != null) {
                    n();
                }
            }
        }
    }

    public void i(Callback callback) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                l(this.f30050c);
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                SnackbarRecord snackbarRecord = this.f30050c;
                if (!snackbarRecord.f30055c) {
                    snackbarRecord.f30055c = true;
                    this.f30049b.removeCallbacksAndMessages(snackbarRecord);
                }
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                SnackbarRecord snackbarRecord = this.f30050c;
                if (snackbarRecord.f30055c) {
                    snackbarRecord.f30055c = false;
                    l(snackbarRecord);
                }
            }
        }
    }

    public void m(int i2, Callback callback) {
        synchronized (this.f30048a) {
            if (f(callback)) {
                SnackbarRecord snackbarRecord = this.f30050c;
                snackbarRecord.f30054b = i2;
                this.f30049b.removeCallbacksAndMessages(snackbarRecord);
                l(this.f30050c);
                return;
            }
            if (g(callback)) {
                this.f30051d.f30054b = i2;
            } else {
                this.f30051d = new SnackbarRecord(i2, callback);
            }
            SnackbarRecord snackbarRecord2 = this.f30050c;
            if (snackbarRecord2 == null || !a(snackbarRecord2, 4)) {
                this.f30050c = null;
                n();
            }
        }
    }
}
