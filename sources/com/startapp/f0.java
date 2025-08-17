package com.startapp;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<View, String> f34494a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<View, a> f34495b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, View> f34496c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<View> f34497d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f34498e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashSet<String> f34499f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f34500g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final Map<View, Boolean> f34501h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    public boolean f34502i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final i f34503a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<String> f34504b = new ArrayList<>();

        public a(i iVar, String str) {
            this.f34503a = iVar;
            a(str);
        }

        public void a(String str) {
            this.f34504b.add(str);
        }
    }
}
