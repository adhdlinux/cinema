package com.startapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

public class zb implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f37012a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f37013b = false;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f37012a.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
