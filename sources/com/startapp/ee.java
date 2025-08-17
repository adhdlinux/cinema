package com.startapp;

import com.startapp.sdk.jobs.JobRequest;

public final class ee extends JobRequest {

    /* renamed from: e  reason: collision with root package name */
    public final Long f34489e;

    public static final class a extends JobRequest.a<a> {

        /* renamed from: d  reason: collision with root package name */
        public Long f34490d;

        public a(Class<? extends be> cls) {
            super(cls);
        }

        public JobRequest.a a() {
            return this;
        }
    }

    public ee(a aVar) {
        super(aVar);
        this.f34489e = aVar.f34490d;
    }

    public boolean a(ge geVar) {
        return geVar.a(this, this.f34489e, (Long) null);
    }
}
