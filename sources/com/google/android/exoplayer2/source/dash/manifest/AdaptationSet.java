package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet {

    /* renamed from: a  reason: collision with root package name */
    public final int f26268a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26269b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Representation> f26270c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Descriptor> f26271d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Descriptor> f26272e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f26273f;

    public AdaptationSet(int i2, int i3, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        this.f26268a = i2;
        this.f26269b = i3;
        this.f26270c = Collections.unmodifiableList(list);
        this.f26271d = Collections.unmodifiableList(list2);
        this.f26272e = Collections.unmodifiableList(list3);
        this.f26273f = Collections.unmodifiableList(list4);
    }
}
