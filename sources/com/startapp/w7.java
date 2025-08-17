package com.startapp;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.HashSet;

public class w7 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x7 f36818a;

    public w7(x7 x7Var) {
        this.f36818a = x7Var;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            v7 v7Var = this.f36818a.f36921c;
            if (v7Var.f36731b == null) {
                v7Var.f36731b = new HashSet();
            }
            v7Var.f36731b.add(bluetoothDevice);
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            this.f36818a.c();
            x7 x7Var = this.f36818a;
            x7Var.f36920b.a(x7Var.b());
        }
    }
}
