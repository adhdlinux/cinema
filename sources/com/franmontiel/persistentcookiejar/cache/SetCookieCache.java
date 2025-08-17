package com.franmontiel.persistentcookiejar.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Cookie;

public class SetCookieCache implements CookieCache {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Set<IdentifiableCookie> f22054b = new HashSet();

    private class SetCookieCacheIterator implements Iterator<Cookie> {

        /* renamed from: b  reason: collision with root package name */
        private Iterator<IdentifiableCookie> f22055b;

        public SetCookieCacheIterator() {
            this.f22055b = SetCookieCache.this.f22054b.iterator();
        }

        /* renamed from: a */
        public Cookie next() {
            return this.f22055b.next().b();
        }

        public boolean hasNext() {
            return this.f22055b.hasNext();
        }

        public void remove() {
            this.f22055b.remove();
        }
    }

    public void addAll(Collection<Cookie> collection) {
        for (IdentifiableCookie next : IdentifiableCookie.a(collection)) {
            this.f22054b.remove(next);
            this.f22054b.add(next);
        }
    }

    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator();
    }
}
