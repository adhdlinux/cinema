package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.offline.Download;
import kotlin.jvm.internal.Intrinsics;

public final class q4 {

    /* renamed from: a  reason: collision with root package name */
    public final Download f18429a;

    public q4(Download download) {
        Intrinsics.f(download, "download");
        this.f18429a = download;
    }

    public final Download a() {
        return this.f18429a;
    }

    public final String b() {
        String str = this.f18429a.f25519a.f25572b;
        Intrinsics.e(str, "download.request.id");
        return str;
    }

    public final float c() {
        return this.f18429a.b();
    }

    public final int d() {
        return this.f18429a.f25520b;
    }

    public final long e() {
        return this.f18429a.f25522d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q4) && Intrinsics.a(this.f18429a, ((q4) obj).f18429a);
    }

    public final String f() {
        String uri = this.f18429a.f25519a.f25573c.toString();
        Intrinsics.e(uri, "download.request.uri.toString()");
        return uri;
    }

    public int hashCode() {
        return this.f18429a.hashCode();
    }

    public String toString() {
        return "DownloadWrapper(download=" + this.f18429a + ')';
    }
}
