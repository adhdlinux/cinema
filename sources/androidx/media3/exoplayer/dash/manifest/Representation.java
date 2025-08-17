package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.dash.DashSegmentIndex;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

public abstract class Representation {

    /* renamed from: a  reason: collision with root package name */
    public final long f6098a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f6099b;

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList<BaseUrl> f6100c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6101d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Descriptor> f6102e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f6103f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Descriptor> f6104g;

    /* renamed from: h  reason: collision with root package name */
    private final RangedUri f6105h;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {

        /* renamed from: i  reason: collision with root package name */
        final SegmentBase.MultiSegmentBase f6106i;

        public MultiSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j2, format, list, multiSegmentBase, list2, list3, list4);
            this.f6106i = multiSegmentBase;
        }

        public String a() {
            return null;
        }

        public long b(long j2) {
            return this.f6106i.j(j2);
        }

        public long c(long j2, long j3) {
            return this.f6106i.h(j2, j3);
        }

        public long d(long j2, long j3) {
            return this.f6106i.d(j2, j3);
        }

        public long e(long j2, long j3) {
            return this.f6106i.f(j2, j3);
        }

        public RangedUri f(long j2) {
            return this.f6106i.k(this, j2);
        }

        public long g(long j2, long j3) {
            return this.f6106i.i(j2, j3);
        }

        public long h(long j2) {
            return this.f6106i.g(j2);
        }

        public boolean i() {
            return this.f6106i.l();
        }

        public long j() {
            return this.f6106i.e();
        }

        public long k(long j2, long j3) {
            return this.f6106i.c(j2, j3);
        }

        public DashSegmentIndex l() {
            return this;
        }

        public RangedUri m() {
            return null;
        }
    }

    public static class SingleSegmentRepresentation extends Representation {

        /* renamed from: i  reason: collision with root package name */
        public final Uri f6107i;

        /* renamed from: j  reason: collision with root package name */
        public final long f6108j;

        /* renamed from: k  reason: collision with root package name */
        private final String f6109k;

        /* renamed from: l  reason: collision with root package name */
        private final RangedUri f6110l;

        /* renamed from: m  reason: collision with root package name */
        private final SingleSegmentIndex f6111m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, String str, long j3) {
            super(j2, format, list, singleSegmentBase, list2, list3, list4);
            SingleSegmentIndex singleSegmentIndex;
            List<BaseUrl> list5 = list;
            this.f6107i = Uri.parse(list.get(0).f6045a);
            RangedUri c2 = singleSegmentBase.c();
            this.f6110l = c2;
            this.f6109k = str;
            this.f6108j = j3;
            if (c2 != null) {
                singleSegmentIndex = null;
            } else {
                singleSegmentIndex = new SingleSegmentIndex(new RangedUri((String) null, 0, j3));
            }
            this.f6111m = singleSegmentIndex;
        }

        public String a() {
            return this.f6109k;
        }

        public DashSegmentIndex l() {
            return this.f6111m;
        }

        public RangedUri m() {
            return this.f6110l;
        }
    }

    public static Representation o(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, String str) {
        SegmentBase segmentBase2 = segmentBase;
        if (segmentBase2 instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j2, format, list, (SegmentBase.SingleSegmentBase) segmentBase2, list2, list3, list4, str, -1);
        } else if (segmentBase2 instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j2, format, list, (SegmentBase.MultiSegmentBase) segmentBase2, list2, list3, list4);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    public abstract String a();

    public abstract DashSegmentIndex l();

    public abstract RangedUri m();

    public RangedUri n() {
        return this.f6105h;
    }

    private Representation(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        List<Descriptor> list5;
        Assertions.a(!list.isEmpty());
        this.f6098a = j2;
        this.f6099b = format;
        this.f6100c = ImmutableList.n(list);
        if (list2 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list2);
        }
        this.f6102e = list5;
        this.f6103f = list3;
        this.f6104g = list4;
        this.f6105h = segmentBase.a(this);
        this.f6101d = segmentBase.b();
    }
}
