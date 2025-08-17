package com.startapp;

import android.content.Context;
import android.net.Uri;
import com.facebook.hermes.intl.Constants;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.components.ComponentLocator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class s7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35847a;

    /* renamed from: b  reason: collision with root package name */
    public final List<AppPresenceDetails> f35848b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f35849c = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            s7 s7Var = s7.this;
            s7Var.getClass();
            try {
                s7Var.b();
            } catch (Throwable th) {
                y8.a(s7Var.f35847a, th);
            }
        }
    }

    public s7(Context context, List<AppPresenceDetails> list) {
        this.f35848b = list;
        this.f35847a = context;
    }

    public void a() {
        ComponentLocator.a(this.f35847a).o().execute(this.f35849c);
    }

    public final void b() {
        String c2;
        String str;
        List<AppPresenceDetails> list = this.f35848b;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (AppPresenceDetails next : list) {
            if (!next.e() && (c2 = next.c()) != null) {
                try {
                    str = Uri.parse(c2).getQueryParameter("d");
                } catch (Throwable th) {
                    y8.a(this.f35847a, th);
                    str = null;
                }
                if (str != null) {
                    if (next.d()) {
                        arrayList2.add("d=" + str);
                    } else {
                        arrayList3.add("d=" + str);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(o6.a((List<String>) arrayList2, Constants.CASEFIRST_FALSE, "true"));
        }
        if (!arrayList3.isEmpty()) {
            arrayList.addAll(o6.a((List<String>) arrayList3, Constants.CASEFIRST_FALSE, Constants.CASEFIRST_FALSE));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2.length() != 0) {
                Context context = this.f35847a;
                TrackingParams a2 = new TrackingParams().a("APP_PRESENCE");
                if (!str2.equalsIgnoreCase("")) {
                    lb.a(context, false, "Sending impression", true);
                    o6.b(context, str2, a2);
                }
            }
        }
    }
}
