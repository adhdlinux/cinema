package com.adcolony.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

public class AdColonyEventTracker {

    /* renamed from: a  reason: collision with root package name */
    private static final List<f1> f12851a = Collections.synchronizedList(new ArrayList());

    static void a(f1 f1Var) {
        List<f1> list = f12851a;
        synchronized (list) {
            if (200 > list.size()) {
                list.add(f1Var);
            }
        }
    }

    static boolean b() {
        boolean z2;
        List<f1> list = f12851a;
        synchronized (list) {
            if (list.size() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    static void c() {
        k f2 = a.f();
        if (!f2.M0().equals("") && f2.h()) {
            List<f1> list = f12851a;
            synchronized (list) {
                for (f1 d2 : list) {
                    d(d2);
                }
                f12851a.clear();
            }
        }
    }

    private static void d(f1 f1Var) {
        k f2 = a.f();
        if (f2.M0().equals("") || !f2.h()) {
            a(f1Var);
            return;
        }
        e(f1Var);
        new h0("AdColony.log_event", 1, f1Var).e();
    }

    private static void e(f1 f1Var) {
        f1 C = c0.C(f1Var, "payload");
        if (l.I) {
            c0.n(C, "api_key", "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            c0.n(C, "api_key", a.f().M0());
        }
        try {
            f1Var.J("payload");
            f1Var.e("payload", C);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
