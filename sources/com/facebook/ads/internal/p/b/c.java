package com.facebook.ads.internal.p.b;

import com.facebook.ads.internal.p.b.a.a;
import java.io.File;

class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f20486a;

    /* renamed from: b  reason: collision with root package name */
    public final com.facebook.ads.internal.p.b.a.c f20487b;

    /* renamed from: c  reason: collision with root package name */
    public final a f20488c;

    c(File file, com.facebook.ads.internal.p.b.a.c cVar, a aVar) {
        this.f20486a = file;
        this.f20487b = cVar;
        this.f20488c = aVar;
    }

    /* access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f20486a, this.f20487b.a(str));
    }
}
