package com.facebook.ads.internal.view.a;

import java.util.HashMap;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f20838a;

    /* renamed from: b  reason: collision with root package name */
    public final long f20839b;

    /* renamed from: c  reason: collision with root package name */
    public final long f20840c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20841d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20842e;

    /* renamed from: f  reason: collision with root package name */
    public final long f20843f;

    /* renamed from: g  reason: collision with root package name */
    public final long f20844g;

    /* renamed from: h  reason: collision with root package name */
    public final long f20845h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f20846a;

        /* renamed from: b  reason: collision with root package name */
        private long f20847b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f20848c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f20849d = -1;

        /* renamed from: e  reason: collision with root package name */
        private long f20850e = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f20851f = -1;

        /* renamed from: g  reason: collision with root package name */
        private long f20852g = -1;

        /* renamed from: h  reason: collision with root package name */
        private long f20853h = -1;

        public a(String str) {
            this.f20846a = str;
        }

        public a a(long j2) {
            this.f20847b = j2;
            return this;
        }

        public c a() {
            return new c(this.f20846a, this.f20847b, this.f20848c, this.f20849d, this.f20850e, this.f20851f, this.f20852g, this.f20853h);
        }

        public a b(long j2) {
            this.f20848c = j2;
            return this;
        }

        public a c(long j2) {
            this.f20849d = j2;
            return this;
        }

        public a d(long j2) {
            this.f20850e = j2;
            return this;
        }

        public a e(long j2) {
            this.f20851f = j2;
            return this;
        }

        public a f(long j2) {
            this.f20852g = j2;
            return this;
        }

        public a g(long j2) {
            this.f20853h = j2;
            return this;
        }
    }

    private c(String str, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.f20838a = str;
        this.f20839b = j2;
        this.f20840c = j3;
        this.f20841d = j4;
        this.f20842e = j5;
        this.f20843f = j6;
        this.f20844g = j7;
        this.f20845h = j8;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f20838a);
        hashMap.put("handler_time_ms", String.valueOf(this.f20839b));
        hashMap.put("load_start_ms", String.valueOf(this.f20840c));
        hashMap.put("response_end_ms", String.valueOf(this.f20841d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.f20842e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f20843f));
        hashMap.put("load_finish_ms", String.valueOf(this.f20844g));
        hashMap.put("session_finish_ms", String.valueOf(this.f20845h));
        return hashMap;
    }
}
