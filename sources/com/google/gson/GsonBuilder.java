package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class GsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Excluder f30869a = Excluder.f30940h;

    /* renamed from: b  reason: collision with root package name */
    private LongSerializationPolicy f30870b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private FieldNamingStrategy f30871c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, InstanceCreator<?>> f30872d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<TypeAdapterFactory> f30873e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<TypeAdapterFactory> f30874f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f30875g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f30876h = Gson.B;

    /* renamed from: i  reason: collision with root package name */
    private int f30877i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f30878j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f30879k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f30880l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f30881m = true;

    /* renamed from: n  reason: collision with root package name */
    private FormattingStyle f30882n = Gson.A;

    /* renamed from: o  reason: collision with root package name */
    private boolean f30883o = false;

    /* renamed from: p  reason: collision with root package name */
    private Strictness f30884p = Gson.f30838z;

    /* renamed from: q  reason: collision with root package name */
    private boolean f30885q = true;

    /* renamed from: r  reason: collision with root package name */
    private ToNumberStrategy f30886r = Gson.D;

    /* renamed from: s  reason: collision with root package name */
    private ToNumberStrategy f30887s = Gson.E;

    /* renamed from: t  reason: collision with root package name */
    private final ArrayDeque<ReflectionAccessFilter> f30888t = new ArrayDeque<>();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r4, int r5, int r6, java.util.List<com.google.gson.TypeAdapterFactory> r7) {
        /*
            boolean r0 = com.google.gson.internal.sql.SqlTypesSupport.f31135a
            r1 = 0
            if (r4 == 0) goto L_0x0024
            java.lang.String r2 = r4.trim()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0024
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<java.util.Date> r5 = com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType.f31002b
            com.google.gson.TypeAdapterFactory r5 = r5.b(r4)
            if (r0 == 0) goto L_0x0044
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<? extends java.util.Date> r6 = com.google.gson.internal.sql.SqlTypesSupport.f31137c
            com.google.gson.TypeAdapterFactory r1 = r6.b(r4)
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<? extends java.util.Date> r6 = com.google.gson.internal.sql.SqlTypesSupport.f31136b
            com.google.gson.TypeAdapterFactory r4 = r6.b(r4)
            goto L_0x0045
        L_0x0024:
            r4 = 2
            if (r5 != r4) goto L_0x002b
            if (r6 == r4) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            return
        L_0x002b:
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<java.util.Date> r4 = com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType.f31002b
            com.google.gson.TypeAdapterFactory r4 = r4.a(r5, r6)
            if (r0 == 0) goto L_0x0043
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<? extends java.util.Date> r1 = com.google.gson.internal.sql.SqlTypesSupport.f31137c
            com.google.gson.TypeAdapterFactory r1 = r1.a(r5, r6)
            com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType<? extends java.util.Date> r2 = com.google.gson.internal.sql.SqlTypesSupport.f31136b
            com.google.gson.TypeAdapterFactory r5 = r2.a(r5, r6)
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0045
        L_0x0043:
            r5 = r4
        L_0x0044:
            r4 = r1
        L_0x0045:
            r7.add(r5)
            if (r0 == 0) goto L_0x0050
            r7.add(r1)
            r7.add(r4)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.GsonBuilder.a(java.lang.String, int, int, java.util.List):void");
    }

    private static boolean c(Type type) {
        if (!(type instanceof Class) || (type != Object.class && !JsonElement.class.isAssignableFrom((Class) type))) {
            return false;
        }
        return true;
    }

    public Gson b() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.f30873e.size() + this.f30874f.size() + 3);
        arrayList2.addAll(this.f30873e);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.f30874f);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        a(this.f30876h, this.f30877i, this.f30878j, arrayList2);
        Excluder excluder = this.f30869a;
        FieldNamingStrategy fieldNamingStrategy = this.f30871c;
        HashMap hashMap = r5;
        HashMap hashMap2 = new HashMap(this.f30872d);
        boolean z2 = this.f30875g;
        boolean z3 = this.f30879k;
        boolean z4 = this.f30883o;
        boolean z5 = this.f30881m;
        FormattingStyle formattingStyle = this.f30882n;
        Strictness strictness = this.f30884p;
        boolean z6 = this.f30880l;
        boolean z7 = this.f30885q;
        LongSerializationPolicy longSerializationPolicy = this.f30870b;
        String str = this.f30876h;
        int i2 = this.f30877i;
        int i3 = this.f30878j;
        ArrayList arrayList4 = r1;
        Excluder excluder2 = excluder;
        ArrayList arrayList5 = new ArrayList(this.f30873e);
        ArrayList arrayList6 = r1;
        ArrayList arrayList7 = new ArrayList(this.f30874f);
        ToNumberStrategy toNumberStrategy = this.f30886r;
        ToNumberStrategy toNumberStrategy2 = this.f30887s;
        ArrayList arrayList8 = r1;
        ArrayList arrayList9 = new ArrayList(this.f30888t);
        return new Gson(excluder2, fieldNamingStrategy, hashMap, z2, z3, z4, z5, formattingStyle, strictness, z6, z7, longSerializationPolicy, str, i2, i3, arrayList4, arrayList6, arrayList, toNumberStrategy, toNumberStrategy2, arrayList8);
    }

    public GsonBuilder d(Type type, Object obj) {
        boolean z2;
        Objects.requireNonNull(type);
        boolean z3 = obj instanceof JsonSerializer;
        if (z3 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter)) {
            z2 = true;
        } else {
            z2 = false;
        }
        C$Gson$Preconditions.a(z2);
        if (!c(type)) {
            if (obj instanceof InstanceCreator) {
                this.f30872d.put(type, (InstanceCreator) obj);
            }
            if (z3 || (obj instanceof JsonDeserializer)) {
                this.f30873e.add(TreeTypeAdapter.c(TypeToken.b(type), obj));
            }
            if (obj instanceof TypeAdapter) {
                this.f30873e.add(TypeAdapters.a(TypeToken.b(type), (TypeAdapter) obj));
            }
            return this;
        }
        throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
    }

    public GsonBuilder e() {
        this.f30875g = true;
        return this;
    }

    @Deprecated
    public GsonBuilder f() {
        return g(Strictness.LENIENT);
    }

    public GsonBuilder g(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.f30884p = strictness;
        return this;
    }
}
