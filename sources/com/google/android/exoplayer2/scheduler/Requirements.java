package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        /* renamed from: a */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        /* renamed from: b */
        public Requirements[] newArray(int i2) {
            return new Requirements[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f25672b;

    public Requirements(int i2) {
        this.f25672b = (i2 & 2) != 0 ? i2 | 1 : i2;
    }

    private int c(Context context) {
        if (!k()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.e(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !j(connectivityManager)) {
            return this.f25672b & 3;
        }
        if (!n() || !connectivityManager.isActiveNetworkMetered()) {
            return 0;
        }
        return 2;
    }

    private boolean g(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    private boolean h(Context context) {
        PowerManager powerManager = (PowerManager) Assertions.e(context.getSystemService("power"));
        int i2 = Util.f28808a;
        if (i2 >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (i2 < 20 ? powerManager.isScreenOn() : powerManager.isInteractive()) {
            return false;
        }
        return true;
    }

    private static boolean j(ConnectivityManager connectivityManager) {
        if (Util.f28808a < 24) {
            return true;
        }
        Network a2 = connectivityManager.getActiveNetwork();
        if (a2 == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(a2);
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
            return true;
        }
    }

    private boolean l(Context context) {
        return context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public Requirements b(int i2) {
        int i3 = this.f25672b;
        int i4 = i2 & i3;
        if (i4 == i3) {
            return this;
        }
        return new Requirements(i4);
    }

    public int d(Context context) {
        int c2 = c(context);
        if (f() && !g(context)) {
            c2 |= 8;
        }
        if (i() && !h(context)) {
            c2 |= 4;
        }
        if (!m() || l(context)) {
            return c2;
        }
        return c2 | 16;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f25672b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Requirements.class == obj.getClass() && this.f25672b == ((Requirements) obj).f25672b) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return (this.f25672b & 8) != 0;
    }

    public int hashCode() {
        return this.f25672b;
    }

    public boolean i() {
        return (this.f25672b & 4) != 0;
    }

    public boolean k() {
        return (this.f25672b & 1) != 0;
    }

    public boolean m() {
        return (this.f25672b & 16) != 0;
    }

    public boolean n() {
        return (this.f25672b & 2) != 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f25672b);
    }
}
