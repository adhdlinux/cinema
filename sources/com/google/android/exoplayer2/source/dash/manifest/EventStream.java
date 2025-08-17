package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class EventStream {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f26308a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f26309b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26310c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26311d;

    /* renamed from: e  reason: collision with root package name */
    public final long f26312e;

    public EventStream(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        this.f26310c = str;
        this.f26311d = str2;
        this.f26312e = j2;
        this.f26309b = jArr;
        this.f26308a = eventMessageArr;
    }

    public String a() {
        return this.f26310c + "/" + this.f26311d;
    }
}
