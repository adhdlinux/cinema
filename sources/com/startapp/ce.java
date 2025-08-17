package com.startapp;

import com.startapp.sdk.jobs.JobRequest;

public class ce {

    /* renamed from: a  reason: collision with root package name */
    public final ge f34304a;

    /* renamed from: b  reason: collision with root package name */
    public final ge f34305b;

    public ce(ge geVar, ge geVar2) {
        this.f34304a = geVar;
        this.f34305b = geVar2;
    }

    public boolean a(JobRequest... jobRequestArr) {
        boolean z2 = true;
        for (JobRequest jobRequest : jobRequestArr) {
            if (jobRequest.f36515d) {
                if (jobRequest.a(this.f34305b)) {
                }
            } else if (jobRequest.a(this.f34304a)) {
            }
            z2 = false;
        }
        return z2;
    }

    public boolean a(int i2) {
        if (!this.f34305b.a(i2)) {
            return this.f34304a.a(i2);
        }
        return true;
    }
}
