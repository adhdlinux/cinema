package com.franmontiel.persistentcookiejar.persistence;

import java.util.Collection;
import java.util.List;
import okhttp3.Cookie;

public interface CookiePersistor {
    void a(Collection<Cookie> collection);

    List<Cookie> b();

    void removeAll(Collection<Cookie> collection);
}
