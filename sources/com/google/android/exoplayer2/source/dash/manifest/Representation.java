package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

public abstract class Representation {

    /* renamed from: a  reason: collision with root package name */
    public final long f26327a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f26328b;

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList<BaseUrl> f26329c;

    /* renamed from: d  reason: collision with root package name */
    public final long f26330d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Descriptor> f26331e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f26332f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Descriptor> f26333g;

    /* renamed from: h  reason: collision with root package name */
    private final RangedUri f26334h;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {

        /* renamed from: i  reason: collision with root package name */
        final SegmentBase.MultiSegmentBase f26335i;

        public MultiSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j2, format, list, multiSegmentBase, list2, list3, list4);
            this.f26335i = multiSegmentBase;
        }

        public String a() {
            return null;
        }

        public long b(long j2) {
            return this.f26335i.j(j2);
        }

        public long c(long j2, long j3) {
            return this.f26335i.h(j2, j3);
        }

        public long d(long j2, long j3) {
            return this.f26335i.d(j2, j3);
        }

        public long e(long j2, long j3) {
            return this.f26335i.f(j2, j3);
        }

        public RangedUri f(long j2) {
            return this.f26335i.k(this, j2);
        }

        public long g(long j2, long j3) {
            return this.f26335i.i(j2, j3);
        }

        public long h(long j2) {
            return this.f26335i.g(j2);
        }

        public boolean i() {
            return this.f26335i.l();
        }

        public long j() {
            return this.f26335i.e();
        }

        public long k(long j2, long j3) {
            return this.f26335i.c(j2, j3);
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
        public final Uri f26336i;

        /* renamed from: j  reason: collision with root package name */
        public final long f26337j;

        /* renamed from: k  reason: collision with root package name */
        private final String f26338k;

        /* renamed from: l  reason: collision with root package name */
        private final RangedUri f26339l;

        /* renamed from: m  reason: collision with root package name */
        private final SingleSegmentIndex f26340m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, String str, long j3) {
            super(j2, format, list, singleSegmentBase, list2, list3, list4);
            SingleSegmentIndex singleSegmentIndex;
            List<BaseUrl> list5 = list;
            this.f26336i = Uri.parse(list.get(0).f26274a);
            RangedUri c2 = singleSegmentBase.c();
            this.f26339l = c2;
            this.f26338k = str;
            this.f26337j = j3;
            if (c2 != null) {
                singleSegmentIndex = null;
            } else {
                singleSegmentIndex = new SingleSegmentIndex(new RangedUri((String) null, 0, j3));
            }
            this.f26340m = singleSegmentIndex;
        }

        public String a() {
            return this.f26338k;
        }

        public DashSegmentIndex l() {
            return this.f26340m;
        }

        public RangedUri m() {
            return this.f26339l;
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
        return this.f26334h;
    }

    private Representation(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        List<Descriptor> list5;
        Assertions.a(!list.isEmpty());
        this.f26327a = j2;
        this.f26328b = format;
        this.f26329c = ImmutableList.n(list);
        if (list2 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list2);
        }
        this.f26331e = list5;
        this.f26332f = list3;
        this.f26333g = list4;
        this.f26334h = segmentBase.a(this);
        this.f26330d = segmentBase.b();
    }
}
