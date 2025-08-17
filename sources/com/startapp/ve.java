package com.startapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.Arrays;
import java.util.Map;

public class ve extends ye {

    /* renamed from: c  reason: collision with root package name */
    public BroadcastReceiver f36749c;

    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ qe f36750a;

        public a(qe qeVar) {
            this.f36750a = qeVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f36750a.a((Object) new Pair(ve.this, intent));
        }
    }

    public ve(String str, Map<String, String> map) {
        super(str, map);
    }

    public void a(Context context, qe qeVar) throws Exception {
        if (this.f36749c == null) {
            a aVar = new a(qeVar);
            this.f36749c = aVar;
            context.registerReceiver(aVar, new IntentFilter(this.f36971a));
            return;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ve.class != obj.getClass()) {
            return false;
        }
        return lb.a(this.f36749c, ((ve) obj).f36749c);
    }

    public int hashCode() {
        Object[] objArr = {this.f36749c};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public void a(Context context) throws Exception {
        BroadcastReceiver broadcastReceiver = this.f36749c;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f36749c = null;
            return;
        }
        throw new IllegalStateException();
    }
}
