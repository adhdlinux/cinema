package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;

@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f22059a;

    public SharedPrefsCookiePersistor(Context context) {
        this(context.getSharedPreferences("CookiePersistence", 0));
    }

    private static String c(Cookie cookie) {
        StringBuilder sb = new StringBuilder();
        sb.append(cookie.secure() ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME);
        sb.append("://");
        sb.append(cookie.domain());
        sb.append(cookie.path());
        sb.append("|");
        sb.append(cookie.name());
        return sb.toString();
    }

    public void a(Collection<Cookie> collection) {
        SharedPreferences.Editor edit = this.f22059a.edit();
        for (Cookie next : collection) {
            edit.putString(c(next), new SerializableCookie().c(next));
        }
        edit.commit();
    }

    public List<Cookie> b() {
        ArrayList arrayList = new ArrayList(this.f22059a.getAll().size());
        for (Map.Entry<String, ?> value : this.f22059a.getAll().entrySet()) {
            Cookie b2 = new SerializableCookie().b((String) value.getValue());
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public void removeAll(Collection<Cookie> collection) {
        SharedPreferences.Editor edit = this.f22059a.edit();
        for (Cookie c2 : collection) {
            edit.remove(c(c2));
        }
        edit.commit();
    }

    public SharedPrefsCookiePersistor(SharedPreferences sharedPreferences) {
        this.f22059a = sharedPreferences;
    }
}
