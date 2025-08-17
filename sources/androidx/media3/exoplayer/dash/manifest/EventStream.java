package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.extractor.metadata.emsg.EventMessage;

public final class EventStream {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f6079a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f6080b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6081c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6082d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6083e;

    public EventStream(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        this.f6081c = str;
        this.f6082d = str2;
        this.f6083e = j2;
        this.f6080b = jArr;
        this.f6079a = eventMessageArr;
    }

    public String a() {
        return this.f6081c + "/" + this.f6082d;
    }
}
