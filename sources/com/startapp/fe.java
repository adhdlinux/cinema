package com.startapp;

import com.startapp.sdk.jobs.JobRequest;

public final class fe extends JobRequest {

    /* renamed from: e  reason: collision with root package name */
    public final Long f34538e;

    public static final class a extends JobRequest.a<a> {

        /* renamed from: d  reason: collision with root package name */
        public Long f34539d;

        public a(Class<? extends be> cls) {
            super(cls);
        }
    }

    public fe(a aVar) {
        super(aVar);
        this.f34538e = aVar.f34539d;
    }

    public boolean a(ge geVar) {
        return geVar.a(this, this.f34538e.longValue());
    }
}
