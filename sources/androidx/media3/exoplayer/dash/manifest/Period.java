package androidx.media3.exoplayer.dash.manifest;

import java.util.Collections;
import java.util.List;

public class Period {

    /* renamed from: a  reason: collision with root package name */
    public final String f6084a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6085b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AdaptationSet> f6086c;

    /* renamed from: d  reason: collision with root package name */
    public final List<EventStream> f6087d;

    /* renamed from: e  reason: collision with root package name */
    public final Descriptor f6088e;

    public Period(String str, long j2, List<AdaptationSet> list, List<EventStream> list2) {
        this(str, j2, list, list2, (Descriptor) null);
    }

    public int a(int i2) {
        int size = this.f6086c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f6086c.get(i3).f6040b == i2) {
                return i3;
            }
        }
        return -1;
    }

    public Period(String str, long j2, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        this.f6084a = str;
        this.f6085b = j2;
        this.f6086c = Collections.unmodifiableList(list);
        this.f6087d = Collections.unmodifiableList(list2);
        this.f6088e = descriptor;
    }
}
