package com.startapp;

import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r7 {

    /* renamed from: a  reason: collision with root package name */
    public static r7 f35760a = new r7();

    /* renamed from: b  reason: collision with root package name */
    public List<q7> f35761b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Map<AdPreferences.Placement, List<q7>> f35762c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<q7>> f35763d = new HashMap();

    public static r7 a() {
        return f35760a;
    }

    public int b() {
        return this.f35761b.size();
    }

    public synchronized void a(q7 q7Var) {
        this.f35761b.add(0, q7Var);
        List list = this.f35762c.get(q7Var.f35683b);
        if (list == null) {
            list = new ArrayList();
            this.f35762c.put(q7Var.f35683b, list);
        }
        list.add(0, q7Var);
        List list2 = this.f35763d.get(q7Var.f35684c);
        if (list2 == null) {
            list2 = new ArrayList();
            this.f35763d.put(q7Var.f35684c, list2);
        }
        list2.add(0, q7Var);
    }
}
