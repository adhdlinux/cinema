package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.Cookie;

class IdentifiableCookie {

    /* renamed from: a  reason: collision with root package name */
    private Cookie f22053a;

    IdentifiableCookie(Cookie cookie) {
        this.f22053a = cookie;
    }

    static List<IdentifiableCookie> a(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Cookie identifiableCookie : collection) {
            arrayList.add(new IdentifiableCookie(identifiableCookie));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Cookie b() {
        return this.f22053a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.f22053a.name().equals(this.f22053a.name()) || !identifiableCookie.f22053a.domain().equals(this.f22053a.domain()) || !identifiableCookie.f22053a.path().equals(this.f22053a.path()) || identifiableCookie.f22053a.secure() != this.f22053a.secure() || identifiableCookie.f22053a.hostOnly() != this.f22053a.hostOnly()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.f22053a.name().hashCode()) * 31) + this.f22053a.domain().hashCode()) * 31) + this.f22053a.path().hashCode()) * 31) + (this.f22053a.secure() ^ true ? 1 : 0)) * 31) + (this.f22053a.hostOnly() ^ true ? 1 : 0);
    }
}
