package com.startapp;

import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;

public class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TriggeredLinksMetadata f34381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34383c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f34384d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ bf f34385e;

    public df(bf bfVar, TriggeredLinksMetadata triggeredLinksMetadata, String str, String str2, int i2) {
        this.f34385e = bfVar;
        this.f34381a = triggeredLinksMetadata;
        this.f34382b = str;
        this.f34383c = str2;
        this.f34384d = i2;
    }

    public void run() {
        try {
            this.f34385e.a(this.f34381a, "Periodic", this.f34382b, this.f34383c);
        } catch (Throwable th) {
            if (this.f34385e.a(1)) {
                y8.a(this.f34385e.f34264a, th);
            }
        } finally {
            this.f34385e.a(this.f34382b, this.f34384d);
            this.f34385e.a(0);
        }
    }
}
