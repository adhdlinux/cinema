package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

public final class SqlTypesSupport {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f31135a;

    /* renamed from: b  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType<? extends Date> f31136b;

    /* renamed from: c  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType<? extends Date> f31137c;

    /* renamed from: d  reason: collision with root package name */
    public static final TypeAdapterFactory f31138d;

    /* renamed from: e  reason: collision with root package name */
    public static final TypeAdapterFactory f31139e;

    /* renamed from: f  reason: collision with root package name */
    public static final TypeAdapterFactory f31140f;

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f31135a = z2;
        if (z2) {
            f31136b = new DefaultDateTypeAdapter.DateType<java.sql.Date>(java.sql.Date.class) {
                /* access modifiers changed from: protected */
                /* renamed from: e */
                public java.sql.Date d(Date date) {
                    return new java.sql.Date(date.getTime());
                }
            };
            f31137c = new DefaultDateTypeAdapter.DateType<Timestamp>(Timestamp.class) {
                /* access modifiers changed from: protected */
                /* renamed from: e */
                public Timestamp d(Date date) {
                    return new Timestamp(date.getTime());
                }
            };
            f31138d = SqlDateTypeAdapter.f31129b;
            f31139e = SqlTimeTypeAdapter.f31131b;
            f31140f = SqlTimestampTypeAdapter.f31133b;
            return;
        }
        f31136b = null;
        f31137c = null;
        f31138d = null;
        f31139e = null;
        f31140f = null;
    }

    private SqlTypesSupport() {
    }
}
