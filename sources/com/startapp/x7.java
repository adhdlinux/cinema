package com.startapp;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.HashSet;
import java.util.Set;

public class x7 {

    /* renamed from: a  reason: collision with root package name */
    public Context f36919a;

    /* renamed from: b  reason: collision with root package name */
    public xb f36920b;

    /* renamed from: c  reason: collision with root package name */
    public v7 f36921c = new v7();

    /* renamed from: d  reason: collision with root package name */
    public BluetoothAdapter f36922d = a();

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f36923e;

    public x7(Context context, xb xbVar) {
        this.f36919a = context;
        this.f36920b = xbVar;
    }

    @SuppressLint({"MissingPermission"})
    public void a(boolean z2) {
        BluetoothAdapter bluetoothAdapter = this.f36922d;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            this.f36920b.a((Object) null);
            return;
        }
        v7 v7Var = this.f36921c;
        Set<BluetoothDevice> hashSet = new HashSet<>();
        try {
            if (hc.a(this.f36919a, "android.permission.BLUETOOTH") && this.f36922d.isEnabled()) {
                hashSet = this.f36922d.getBondedDevices();
            }
        } catch (Throwable th) {
            y8.a(this.f36919a, th);
        }
        v7Var.f36730a = hashSet;
        if (!z2 || !hc.a(this.f36919a, "android.permission.BLUETOOTH_ADMIN")) {
            this.f36920b.a(b());
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        w7 w7Var = new w7(this);
        this.f36923e = w7Var;
        try {
            this.f36919a.registerReceiver(w7Var, intentFilter);
            this.f36922d.startDiscovery();
        } catch (Exception e2) {
            this.f36922d.cancelDiscovery();
            this.f36920b.a(b());
            y8.a(this.f36919a, (Throwable) e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|3|4|(3:8|9|10)|11|(3:15|16|17)|18|19|(2:21|23)(1:25)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject b() {
        /*
            r5 = this;
            r0 = 0
            com.startapp.v7 r1 = r5.f36921c     // Catch:{ Exception -> 0x003c }
            r1.getClass()     // Catch:{ Exception -> 0x003c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x003c }
            r2.<init>()     // Catch:{ Exception -> 0x003c }
            java.util.Set<android.bluetooth.BluetoothDevice> r3 = r1.f36730a     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x0020
            int r3 = r3.size()     // Catch:{ Exception -> 0x0035 }
            if (r3 <= 0) goto L_0x0020
            java.lang.String r3 = "paired"
            java.util.Set<android.bluetooth.BluetoothDevice> r4 = r1.f36730a     // Catch:{ Exception -> 0x0035 }
            org.json.JSONArray r4 = r1.a(r4)     // Catch:{ Exception -> 0x0035 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0035 }
        L_0x0020:
            java.util.Set<android.bluetooth.BluetoothDevice> r3 = r1.f36731b     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x0035
            int r3 = r3.size()     // Catch:{ Exception -> 0x0035 }
            if (r3 <= 0) goto L_0x0035
            java.lang.String r3 = "available"
            java.util.Set<android.bluetooth.BluetoothDevice> r4 = r1.f36731b     // Catch:{ Exception -> 0x0035 }
            org.json.JSONArray r1 = r1.a(r4)     // Catch:{ Exception -> 0x0035 }
            r2.put(r3, r1)     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            int r1 = r2.length()     // Catch:{ Exception -> 0x003c }
            if (r1 <= 0) goto L_0x003c
            r0 = r2
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.x7.b():org.json.JSONObject");
    }

    @SuppressLint({"MissingPermission"})
    public void c() {
        BluetoothAdapter bluetoothAdapter;
        if (hc.a(this.f36919a, "android.permission.BLUETOOTH_ADMIN") && this.f36923e != null && (bluetoothAdapter = this.f36922d) != null) {
            bluetoothAdapter.cancelDiscovery();
            try {
                this.f36919a.unregisterReceiver(this.f36923e);
            } catch (Throwable th) {
                y8.a(this.f36919a, th);
            }
            this.f36923e = null;
        }
    }

    public final BluetoothAdapter a() {
        if (hc.a(this.f36919a, "android.permission.BLUETOOTH")) {
            return BluetoothAdapter.getDefaultAdapter();
        }
        return null;
    }
}
