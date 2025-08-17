package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;

public class PlaybackException extends Exception implements Bundleable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f23368d = Util.u0(0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f23369e = Util.u0(1);

    /* renamed from: f  reason: collision with root package name */
    private static final String f23370f = Util.u0(2);

    /* renamed from: g  reason: collision with root package name */
    private static final String f23371g = Util.u0(3);

    /* renamed from: h  reason: collision with root package name */
    private static final String f23372h = Util.u0(4);

    /* renamed from: i  reason: collision with root package name */
    public static final Bundleable.Creator<PlaybackException> f23373i = new u1();

    /* renamed from: b  reason: collision with root package name */
    public final int f23374b;

    /* renamed from: c  reason: collision with root package name */
    public final long f23375c;

    protected PlaybackException(Bundle bundle) {
        this(bundle.getString(f23370f), c(bundle), bundle.getInt(f23368d, 1000), bundle.getLong(f23369e, SystemClock.elapsedRealtime()));
    }

    private static RemoteException a(String str) {
        return new RemoteException(str);
    }

    private static Throwable b(Class<?> cls, String str) throws Exception {
        return (Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    private static Throwable c(Bundle bundle) {
        String string = bundle.getString(f23371g);
        String string2 = bundle.getString(f23372h);
        Throwable th = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, PlaybackException.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                th = b(cls, string2);
            }
            if (th != null) {
                return th;
            }
        } catch (Throwable unused) {
        }
        return a(string2);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f23368d, this.f23374b);
        bundle.putLong(f23369e, this.f23375c);
        bundle.putString(f23370f, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(f23371g, cause.getClass().getName());
            bundle.putString(f23372h, cause.getMessage());
        }
        return bundle;
    }

    protected PlaybackException(String str, Throwable th, int i2, long j2) {
        super(str, th);
        this.f23374b = i2;
        this.f23375c = j2;
    }
}
