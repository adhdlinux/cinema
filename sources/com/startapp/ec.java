package com.startapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashSet;
import java.util.List;

public class ec implements CookieStore {

    /* renamed from: a  reason: collision with root package name */
    public final CookieStore f34484a = new CookieManager().getCookieStore();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f34485b;

    public ec(Context context) {
        HttpCookie httpCookie;
        x6 x6Var = new x6(context.getSharedPreferences("com.startapp.android.publish.CookiePrefsFile", 0));
        this.f34485b = x6Var;
        String string = x6Var.getString("names", (String) null);
        if (string != null) {
            for (String str : TextUtils.split(string, ";")) {
                SharedPreferences sharedPreferences = this.f34485b;
                String string2 = sharedPreferences.getString("cookie_" + str, (String) null);
                if (!(string2 == null || (httpCookie = (HttpCookie) h0.a(string2, HttpCookie.class)) == null)) {
                    if (httpCookie.hasExpired()) {
                        b(httpCookie);
                        a();
                    } else if (httpCookie.getDomain() != null) {
                        this.f34484a.add(URI.create(httpCookie.getDomain()), httpCookie);
                    }
                }
            }
        }
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f34485b.edit();
        HashSet hashSet = new HashSet();
        for (HttpCookie a2 : this.f34484a.getCookies()) {
            hashSet.add(a(a2));
        }
        edit.putString("names", TextUtils.join(";", hashSet));
        edit.apply();
    }

    public void add(URI uri, HttpCookie httpCookie) {
        String a2 = a(httpCookie);
        this.f34484a.add(uri, httpCookie);
        SharedPreferences.Editor edit = this.f34485b.edit();
        edit.putString("cookie_" + a2, String.valueOf(h0.b(httpCookie)));
        edit.apply();
        a();
    }

    public final void b(HttpCookie httpCookie) {
        SharedPreferences.Editor edit = this.f34485b.edit();
        edit.remove("cookie_" + a(httpCookie));
        edit.apply();
    }

    public List<HttpCookie> get(URI uri) {
        return this.f34484a.get(uri);
    }

    public List<HttpCookie> getCookies() {
        return this.f34484a.getCookies();
    }

    public List<URI> getURIs() {
        return this.f34484a.getURIs();
    }

    public boolean remove(URI uri, HttpCookie httpCookie) {
        if (!this.f34484a.remove(uri, httpCookie)) {
            return false;
        }
        b(httpCookie);
        a();
        return true;
    }

    public boolean removeAll() {
        if (!this.f34484a.removeAll()) {
            return false;
        }
        SharedPreferences.Editor edit = this.f34485b.edit();
        edit.clear();
        edit.apply();
        a();
        return true;
    }

    public final String a(HttpCookie httpCookie) {
        return httpCookie.getDomain() + "_" + httpCookie.getName();
    }
}
