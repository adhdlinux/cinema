package com.facebook.ads.internal.e;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;

abstract class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private a f20130a;

    public enum a {
        UNKNOWN(9000, "An unknown error has occurred."),
        DATABASE_SELECT(3001, "Failed to read from database."),
        DATABASE_INSERT(3002, "Failed to insert row into database."),
        DATABASE_UPDATE(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, "Failed to update row in database."),
        DATABASE_DELETE(AuthApiStatusCodes.AUTH_TOKEN_ERROR, "Failed to delete row from database.");
        

        /* renamed from: f  reason: collision with root package name */
        private final int f20137f;

        /* renamed from: g  reason: collision with root package name */
        private final String f20138g;

        private a(int i2, String str) {
            this.f20137f = i2;
            this.f20138g = str;
        }

        public int a() {
            return this.f20137f;
        }

        public String b() {
            return this.f20138g;
        }
    }

    f() {
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        this.f20130a = aVar;
    }

    /* access modifiers changed from: package-private */
    public abstract T b();

    public a c() {
        return this.f20130a;
    }
}
