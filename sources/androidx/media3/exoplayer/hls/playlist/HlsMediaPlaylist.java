package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HlsMediaPlaylist extends HlsPlaylist {

    /* renamed from: d  reason: collision with root package name */
    public final int f6499d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6500e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6501f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6502g;

    /* renamed from: h  reason: collision with root package name */
    public final long f6503h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f6504i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6505j;

    /* renamed from: k  reason: collision with root package name */
    public final long f6506k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6507l;

    /* renamed from: m  reason: collision with root package name */
    public final long f6508m;

    /* renamed from: n  reason: collision with root package name */
    public final long f6509n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f6510o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f6511p;

    /* renamed from: q  reason: collision with root package name */
    public final DrmInitData f6512q;

    /* renamed from: r  reason: collision with root package name */
    public final List<Segment> f6513r;

    /* renamed from: s  reason: collision with root package name */
    public final List<Part> f6514s;

    /* renamed from: t  reason: collision with root package name */
    public final Map<Uri, RenditionReport> f6515t;

    /* renamed from: u  reason: collision with root package name */
    public final long f6516u;

    /* renamed from: v  reason: collision with root package name */
    public final ServerControl f6517v;

    public static final class Part extends SegmentBase {

        /* renamed from: m  reason: collision with root package name */
        public final boolean f6518m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f6519n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Part(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z2, boolean z3, boolean z4) {
            super(str, segment, j2, i2, j3, drmInitData, str2, str3, j4, j5, z2);
            this.f6518m = z3;
            this.f6519n = z4;
        }

        public Part b(long j2, int i2) {
            int i3 = i2;
            return new Part(this.f6525b, this.f6526c, this.f6527d, i3, j2, this.f6530g, this.f6531h, this.f6532i, this.f6533j, this.f6534k, this.f6535l, this.f6518m, this.f6519n);
        }
    }

    public static final class RenditionReport {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f6520a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6521b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6522c;

        public RenditionReport(Uri uri, long j2, int i2) {
            this.f6520a = uri;
            this.f6521b = j2;
            this.f6522c = i2;
        }
    }

    public static class SegmentBase implements Comparable<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final String f6525b;

        /* renamed from: c  reason: collision with root package name */
        public final Segment f6526c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6527d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6528e;

        /* renamed from: f  reason: collision with root package name */
        public final long f6529f;

        /* renamed from: g  reason: collision with root package name */
        public final DrmInitData f6530g;

        /* renamed from: h  reason: collision with root package name */
        public final String f6531h;

        /* renamed from: i  reason: collision with root package name */
        public final String f6532i;

        /* renamed from: j  reason: collision with root package name */
        public final long f6533j;

        /* renamed from: k  reason: collision with root package name */
        public final long f6534k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f6535l;

        /* renamed from: a */
        public int compareTo(Long l2) {
            if (this.f6529f > l2.longValue()) {
                return 1;
            }
            if (this.f6529f < l2.longValue()) {
                return -1;
            }
            return 0;
        }

        private SegmentBase(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z2) {
            this.f6525b = str;
            this.f6526c = segment;
            this.f6527d = j2;
            this.f6528e = i2;
            this.f6529f = j3;
            this.f6530g = drmInitData;
            this.f6531h = str2;
            this.f6532i = str3;
            this.f6533j = j4;
            this.f6534k = j5;
            this.f6535l = z2;
        }
    }

    public static final class ServerControl {

        /* renamed from: a  reason: collision with root package name */
        public final long f6536a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6537b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6538c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6539d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f6540e;

        public ServerControl(long j2, boolean z2, long j3, long j4, boolean z3) {
            this.f6536a = j2;
            this.f6537b = z2;
            this.f6538c = j3;
            this.f6539d = j4;
            this.f6540e = z3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HlsMediaPlaylist(int i2, String str, List<String> list, long j2, boolean z2, long j3, boolean z3, int i3, long j4, int i4, long j5, long j6, boolean z4, boolean z5, boolean z6, DrmInitData drmInitData, List<Segment> list2, List<Part> list3, ServerControl serverControl, Map<Uri, RenditionReport> map) {
        super(str, list, z4);
        long j7 = j2;
        String str2 = str;
        List<String> list4 = list;
        this.f6499d = i2;
        this.f6503h = j3;
        this.f6502g = z2;
        this.f6504i = z3;
        this.f6505j = i3;
        this.f6506k = j4;
        this.f6507l = i4;
        this.f6508m = j5;
        this.f6509n = j6;
        this.f6510o = z5;
        this.f6511p = z6;
        this.f6512q = drmInitData;
        this.f6513r = ImmutableList.n(list2);
        this.f6514s = ImmutableList.n(list3);
        this.f6515t = ImmutableMap.d(map);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.d(list3);
            this.f6516u = part.f6529f + part.f6527d;
        } else if (!list2.isEmpty()) {
            Segment segment = (Segment) Iterables.d(list2);
            this.f6516u = segment.f6529f + segment.f6527d;
        } else {
            this.f6516u = 0;
        }
        long j8 = -9223372036854775807L;
        if (j7 != -9223372036854775807L) {
            if (j7 >= 0) {
                j8 = Math.min(this.f6516u, j2);
            } else {
                j8 = Math.max(0, this.f6516u + j7);
            }
        }
        this.f6500e = j8;
        this.f6501f = j7 >= 0;
        this.f6517v = serverControl;
    }

    /* renamed from: b */
    public HlsMediaPlaylist a(List<StreamKey> list) {
        return this;
    }

    public HlsMediaPlaylist c(long j2, int i2) {
        return new HlsMediaPlaylist(this.f6499d, this.f6562a, this.f6563b, this.f6500e, this.f6502g, j2, true, i2, this.f6506k, this.f6507l, this.f6508m, this.f6509n, this.f6564c, this.f6510o, this.f6511p, this.f6512q, this.f6513r, this.f6514s, this.f6517v, this.f6515t);
    }

    public HlsMediaPlaylist d() {
        if (this.f6510o) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.f6499d, this.f6562a, this.f6563b, this.f6500e, this.f6502g, this.f6503h, this.f6504i, this.f6505j, this.f6506k, this.f6507l, this.f6508m, this.f6509n, this.f6564c, true, this.f6511p, this.f6512q, this.f6513r, this.f6514s, this.f6517v, this.f6515t);
        return hlsMediaPlaylist;
    }

    public long e() {
        return this.f6503h + this.f6516u;
    }

    public boolean f(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j2 = this.f6506k;
        long j3 = hlsMediaPlaylist.f6506k;
        if (j2 > j3) {
            return true;
        }
        if (j2 < j3) {
            return false;
        }
        int size = this.f6513r.size() - hlsMediaPlaylist.f6513r.size();
        if (size == 0) {
            int size2 = this.f6514s.size();
            int size3 = hlsMediaPlaylist.f6514s.size();
            if (size2 > size3) {
                return true;
            }
            if (size2 != size3 || !this.f6510o || hlsMediaPlaylist.f6510o) {
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
        public final String f6523m;

        /* renamed from: n  reason: collision with root package name */
        public final List<Part> f6524n;

        public Segment(String str, long j2, long j3, String str2, String str3) {
            this(str, (Segment) null, "", 0, -1, -9223372036854775807L, (DrmInitData) null, str2, str3, j2, j3, false, ImmutableList.r());
        }

        public Segment b(long j2, int i2) {
            ArrayList arrayList = new ArrayList();
            long j3 = j2;
            for (int i3 = 0; i3 < this.f6524n.size(); i3++) {
                Part part = this.f6524n.get(i3);
                arrayList.add(part.b(j3, i2));
                j3 += part.f6527d;
            }
            int i4 = i2;
            return new Segment(this.f6525b, this.f6526c, this.f6523m, this.f6527d, i2, j2, this.f6530g, this.f6531h, this.f6532i, this.f6533j, this.f6534k, this.f6535l, arrayList);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Segment(String str, Segment segment, String str2, long j2, int i2, long j3, DrmInitData drmInitData, String str3, String str4, long j4, long j5, boolean z2, List<Part> list) {
            super(str, segment, j2, i2, j3, drmInitData, str3, str4, j4, j5, z2);
            this.f6523m = str2;
            this.f6524n = ImmutableList.n(list);
        }
    }
}
