package com.startapp;

import android.bluetooth.BluetoothDevice;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class v7 {

    /* renamed from: a  reason: collision with root package name */
    public Set<BluetoothDevice> f36730a;

    /* renamed from: b  reason: collision with root package name */
    public Set<BluetoothDevice> f36731b;

    public final JSONArray a(Set<BluetoothDevice> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (BluetoothDevice next : set) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bluetoothClass", next.getBluetoothClass().getDeviceClass());
                jSONObject.put("name", next.getName());
                jSONObject.put("mac", next.getAddress());
                jSONObject.put("bondState", next.getBondState());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Exception unused) {
            return null;
        }
    }
}
