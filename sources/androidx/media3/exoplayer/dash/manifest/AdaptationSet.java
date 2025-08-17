package androidx.media3.exoplayer.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet {

    /* renamed from: a  reason: collision with root package name */
    public final long f6039a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6040b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Representation> f6041c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Descriptor> f6042d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Descriptor> f6043e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f6044f;

    public AdaptationSet(long j2, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        this.f6039a = j2;
        this.f6040b = i2;
        this.f6041c = Collections.unmodifiableList(list);
        this.f6042d = Collections.unmodifiableList(list2);
        this.f6043e = Collections.unmodifiableList(list3);
        this.f6044f = Collections.unmodifiableList(list4);
    }
}
