package com.utils.subtitle.converter;

import java.util.Hashtable;
import java.util.TreeMap;

public class TimedTextObject {

    /* renamed from: a  reason: collision with root package name */
    public String f37733a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f37734b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f37735c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f37736d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f37737e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f37738f = "";

    /* renamed from: g  reason: collision with root package name */
    public Hashtable<String, Style> f37739g = new Hashtable<>();

    /* renamed from: h  reason: collision with root package name */
    public Hashtable<String, Object> f37740h = new Hashtable<>();

    /* renamed from: i  reason: collision with root package name */
    public TreeMap<Integer, Caption> f37741i = new TreeMap<>();

    /* renamed from: j  reason: collision with root package name */
    public String f37742j = "List of non fatal errors produced during parsing:\n\n";

    /* renamed from: k  reason: collision with root package name */
    public boolean f37743k = true;

    /* renamed from: l  reason: collision with root package name */
    public int f37744l = 0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f37745m = false;

    protected TimedTextObject() {
    }

    /* access modifiers changed from: protected */
    public void a() {
        Hashtable<String, Style> hashtable = new Hashtable<>();
        for (Caption next : this.f37741i.values()) {
            Style style = next.f37717a;
            if (style != null) {
                String str = style.f37723a;
                if (!hashtable.containsKey(str)) {
                    hashtable.put(str, next.f37717a);
                }
            }
        }
        this.f37739g = hashtable;
    }
}
