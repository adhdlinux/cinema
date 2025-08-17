package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class Period {

    /* renamed from: a  reason: collision with root package name */
    public final String f26313a;

    /* renamed from: b  reason: collision with root package name */
    public final long f26314b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AdaptationSet> f26315c;

    /* renamed from: d  reason: collision with root package name */
    public final List<EventStream> f26316d;

    /* renamed from: e  reason: collision with root package name */
    public final Descriptor f26317e;

    public Period(String str, long j2, List<AdaptationSet> list, List<EventStream> list2) {
        this(str, j2, list, list2, (Descriptor) null);
    }

    public int a(int i2) {
        int size = this.f26315c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f26315c.get(i3).f26269b == i2) {
                return i3;
            }
        }
        return -1;
    }

    public Period(String str, long j2, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        this.f26313a = str;
        this.f26314b = j2;
        this.f26315c = Collections.unmodifiableList(list);
        this.f26316d = Collections.unmodifiableList(list2);
        this.f26317e = descriptor;
    }
}
