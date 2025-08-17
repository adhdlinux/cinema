package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HlsMediaPlaylist extends HlsPlaylist {

    /* renamed from: d  reason: collision with root package name */
    public final int f26582d;

    /* renamed from: e  reason: collision with root package name */
    public final long f26583e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f26584f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f26585g;

    /* renamed from: h  reason: collision with root package name */
    public final long f26586h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f26587i;

    /* renamed from: j  reason: collision with root package name */
    public final int f26588j;

    /* renamed from: k  reason: collision with root package name */
    public final long f26589k;

    /* renamed from: l  reason: collision with root package name */
    public final int f26590l;

    /* renamed from: m  reason: collision with root package name */
    public final long f26591m;

    /* renamed from: n  reason: collision with root package name */
    public final long f26592n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f26593o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f26594p;

    /* renamed from: q  reason: collision with root package name */
    public final DrmInitData f26595q;

    /* renamed from: r  reason: collision with root package name */
    public final List<Segment> f26596r;

    /* renamed from: s  reason: collision with root package name */
    public final List<Part> f26597s;

    /* renamed from: t  reason: collision with root package name */
    public final Map<Uri, RenditionReport> f26598t;

    /* renamed from: u  reason: collision with root package name */
    public final long f26599u;

    /* renamed from: v  reason: collision with root package name */
    public final ServerControl f26600v;

    public static final class Part extends SegmentBase {

        /* renamed from: m  reason: collision with root package name */
        public final boolean f26601m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f26602n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Part(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z2, boolean z3, boolean z4) {
            super(str, segment, j2, i2, j3, drmInitData, str2, str3, j4, j5, z2);
            this.f26601m = z3;
            this.f26602n = z4;
        }

        public Part b(long j2, int i2) {
            int i3 = i2;
            return new Part(this.f26608b, this.f26609c, this.f26610d, i3, j2, this.f26613g, this.f26614h, this.f26615i, this.f26616j, this.f26617k, this.f26618l, this.f26601m, this.f26602n);
        }
    }

    public static final class RenditionReport {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f26603a;

        /* renamed from: b  reason: collision with root package name */
        public final long f26604b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26605c;

        public RenditionReport(Uri uri, long j2, int i2) {
            this.f26603a = uri;
            this.f26604b = j2;
            this.f26605c = i2;
        }
    }

    public static class SegmentBase implements Comparable<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final String f26608b;

        /* renamed from: c  reason: collision with root package name */
        public final Segment f26609c;

        /* renamed from: d  reason: collision with root package name */
        public final long f26610d;

        /* renamed from: e  reason: collision with root package name */
        public final int f26611e;

        /* renamed from: f  reason: collision with root package name */
        public final long f26612f;

        /* renamed from: g  reason: collision with root package name */
        public final DrmInitData f26613g;

        /* renamed from: h  reason: collision with root package name */
        public final String f26614h;

        /* renamed from: i  reason: collision with root package name */
        public final String f26615i;

        /* renamed from: j  reason: collision with root package name */
        public final long f26616j;

        /* renamed from: k  reason: collision with root package name */
        public final long f26617k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f26618l;

        /* renamed from: a */
        public int compareTo(Long l2) {
            if (this.f26612f > l2.longValue()) {
                return 1;
            }
            if (this.f26612f < l2.longValue()) {
                return -1;
            }
            return 0;
        }

        private SegmentBase(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z2) {
            this.f26608b = str;
            this.f26609c = segment;
            this.f26610d = j2;
            this.f26611e = i2;
            this.f26612f = j3;
            this.f26613g = drmInitData;
            this.f26614h = str2;
            this.f26615i = str3;
            this.f26616j = j4;
            this.f26617k = j5;
            this.f26618l = z2;
        }
    }

    public static final class ServerControl {

        /* renamed from: a  reason: collision with root package name */
        public final long f26619a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f26620b;

        /* renamed from: c  reason: collision with root package name */
        public final long f26621c;

        /* renamed from: d  reason: collision with root package name */
        public final long f26622d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f26623e;

        public ServerControl(long j2, boolean z2, long j3, long j4, boolean z3) {
            this.f26619a = j2;
            this.f26620b = z2;
            this.f26621c = j3;
            this.f26622d = j4;
            this.f26623e = z3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HlsMediaPlaylist(int i2, String str, List<String> list, long j2, boolean z2, long j3, boolean z3, int i3, long j4, int i4, long j5, long j6, boolean z4, boolean z5, boolean z6, DrmInitData drmInitData, List<Segment> list2, List<Part> list3, ServerControl serverControl, Map<Uri, RenditionReport> map) {
        super(str, list, z4);
        long j7 = j2;
        String str2 = str;
        List<String> list4 = list;
        this.f26582d = i2;
        this.f26586h = j3;
        this.f26585g = z2;
        this.f26587i = z3;
        this.f26588j = i3;
        this.f26589k = j4;
        this.f26590l = i4;
        this.f26591m = j5;
        this.f26592n = j6;
        this.f26593o = z5;
        this.f26594p = z6;
        this.f26595q = drmInitData;
        this.f26596r = ImmutableList.n(list2);
        this.f26597s = ImmutableList.n(list3);
        this.f26598t = ImmutableMap.d(map);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.d(list3);
            this.f26599u = part.f26612f + part.f26610d;
        } else if (!list2.isEmpty()) {
            Segment segment = (Segment) Iterables.d(list2);
            this.f26599u = segment.f26612f + segment.f26610d;
        } else {
            this.f26599u = 0;
        }
        long j8 = -9223372036854775807L;
        if (j7 != -9223372036854775807L) {
            if (j7 >= 0) {
                j8 = Math.min(this.f26599u, j2);
            } else {
                j8 = Math.max(0, this.f26599u + j7);
            }
        }
        this.f26583e = j8;
        this.f26584f = j7 >= 0;
        this.f26600v = serverControl;
    }

    /* renamed from: b */
    public HlsMediaPlaylist a(List<StreamKey> list) {
        return this;
    }

    public HlsMediaPlaylist c(long j2, int i2) {
        return new HlsMediaPlaylist(this.f26582d, this.f26645a, this.f26646b, this.f26583e, this.f26585g, j2, true, i2, this.f26589k, this.f26590l, this.f26591m, this.f26592n, this.f26647c, this.f26593o, this.f26594p, this.f26595q, this.f26596r, this.f26597s, this.f26600v, this.f26598t);
    }

    public HlsMediaPlaylist d() {
        if (this.f26593o) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.f26582d, this.f26645a, this.f26646b, this.f26583e, this.f26585g, this.f26586h, this.f26587i, this.f26588j, this.f26589k, this.f26590l, this.f26591m, this.f26592n, this.f26647c, true, this.f26594p, this.f26595q, this.f26596r, this.f26597s, this.f26600v, this.f26598t);
        return hlsMediaPlaylist;
    }

    public long e() {
        return this.f26586h + this.f26599u;
    }

    public boolean f(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j2 = this.f26589k;
        long j3 = hlsMediaPlaylist.f26589k;
        if (j2 > j3) {
            return true;
        }
        if (j2 < j3) {
            return false;
        }
        int size = this.f26596r.size() - hlsMediaPlaylist.f26596r.size();
        if (size == 0) {
            int size2 = this.f26597s.size();
            int size3 = hlsMediaPlaylist.f26597s.size();
            if (size2 > size3) {
                return true;
            }
            if (size2 != size3 || !this.f26593o || hlsMediaPlaylist.f26593o) {
                return false;
            }
            return true;
        } else if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static final class Segment extends SegmentBase {

        /* renamed from: m  reason: collision with root package name */
        public final String f26606m;

        /* renamed from: n  reason: collision with root package name */
        public final List<Part> f26607n;

        public Segment(String str, long j2, long j3, String str2, String str3) {
            this(str, (Segment) null, "", 0, -1, -9223372036854775807L, (DrmInitData) null, str2, str3, j2, j3, false, ImmutableList.r());
        }

        public Segment b(long j2, int i2) {
            ArrayList arrayList = new ArrayList();
            long j3 = j2;
            for (int i3 = 0; i3 < this.f26607n.size(); i3++) {
                Part part = this.f26607n.get(i3);
                arrayList.add(part.b(j3, i2));
                j3 += part.f26610d;
            }
            int i4 = i2;
            return new Segment(this.f26608b, this.f26609c, this.f26606m, this.f26610d, i2, j2, this.f26613g, this.f26614h, this.f26615i, this.f26616j, this.f26617k, this.f26618l, arrayList);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Segment(String str, Segment segment, String str2, long j2, int i2, long j3, DrmInitData drmInitData, String str3, String str4, long j4, long j5, boolean z2, List<Part> list) {
            super(str, segment, j2, i2, j3, drmInitData, str3, str4, j4, j5, z2);
            this.f26606m = str2;
            this.f26607n = ImmutableList.n(list);
        }
    }
}
