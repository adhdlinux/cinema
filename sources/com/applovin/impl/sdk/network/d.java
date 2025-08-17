package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class d extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f15649a = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a();

        void b();
    }

    public d(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static boolean a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        Object obj = extras.get("networkInfo");
        if (obj instanceof NetworkInfo) {
            return ((NetworkInfo) obj).isConnected();
        }
        return false;
    }

    public void a(a aVar) {
        this.f15649a.add(aVar);
    }

    public void b(a aVar) {
        this.f15649a.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList arrayList = new ArrayList(this.f15649a);
            boolean a2 = a(intent);
            Iterator it2 = arrayList.iterator();
            if (a2) {
                while (it2.hasNext()) {
                    ((a) it2.next()).a();
                }
                return;
            }
            while (it2.hasNext()) {
                ((a) it2.next()).b();
            }
        }
    }
}
