package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SsManifest implements FilterableManifest<SsManifest> {

    /* renamed from: a  reason: collision with root package name */
    public final int f27134a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27135b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27136c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f27137d;

    /* renamed from: e  reason: collision with root package name */
    public final ProtectionElement f27138e;

    /* renamed from: f  reason: collision with root package name */
    public final StreamElement[] f27139f;

    /* renamed from: g  reason: collision with root package name */
    public final long f27140g;

    /* renamed from: h  reason: collision with root package name */
    public final long f27141h;

    public static class ProtectionElement {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f27142a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f27143b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackEncryptionBox[] f27144c;

        public ProtectionElement(UUID uuid, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.f27142a = uuid;
            this.f27143b = bArr;
            this.f27144c = trackEncryptionBoxArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SsManifest(int i2, int i3, long j2, long j3, long j4, int i4, boolean z2, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this(i2, i3, j3 == 0 ? -9223372036854775807L : Util.R0(j3, 1000000, j2), j4 != 0 ? Util.R0(j4, 1000000, j2) : -9223372036854775807L, i4, z2, protectionElement, streamElementArr);
    }

    /* renamed from: b */
    public final SsManifest a(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i2);
            StreamElement streamElement2 = this.f27139f[streamKey.f25637c];
            if (!(streamElement2 == streamElement || streamElement == null)) {
                arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.f27154j[streamKey.f25638d]);
            i2++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.f27134a, this.f27135b, this.f27140g, this.f27141h, this.f27136c, this.f27137d, this.f27138e, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }

    public static class StreamElement {

        /* renamed from: a  reason: collision with root package name */
        public final int f27145a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27146b;

        /* renamed from: c  reason: collision with root package name */
        public final long f27147c;

        /* renamed from: d  reason: collision with root package name */
        public final String f27148d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27149e;

        /* renamed from: f  reason: collision with root package name */
        public final int f27150f;

        /* renamed from: g  reason: collision with root package name */
        public final int f27151g;

        /* renamed from: h  reason: collision with root package name */
        public final int f27152h;

        /* renamed from: i  reason: collision with root package name */
        public final String f27153i;

        /* renamed from: j  reason: collision with root package name */
        public final Format[] f27154j;

        /* renamed from: k  reason: collision with root package name */
        public final int f27155k;

        /* renamed from: l  reason: collision with root package name */
        private final String f27156l;

        /* renamed from: m  reason: collision with root package name */
        private final String f27157m;

        /* renamed from: n  reason: collision with root package name */
        private final List<Long> f27158n;

        /* renamed from: o  reason: collision with root package name */
        private final long[] f27159o;

        /* renamed from: p  reason: collision with root package name */
        private final long f27160p;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, formatArr, list, Util.S0(list, 1000000, j2), Util.R0(j3, 1000000, j2));
            String str6 = str;
            String str7 = str2;
            int i7 = i2;
        }

        public Uri a(int i2, int i3) {
            boolean z2;
            boolean z3;
            boolean z4 = true;
            if (this.f27154j != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            if (this.f27158n != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.g(z3);
            if (i3 >= this.f27158n.size()) {
                z4 = false;
            }
            Assertions.g(z4);
            String num = Integer.toString(this.f27154j[i2].f23067i);
            String l2 = this.f27158n.get(i3).toString();
            return UriUtil.e(this.f27156l, this.f27157m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l2).replace("{start_time}", l2));
        }

        public StreamElement b(Format[] formatArr) {
            String str = this.f27156l;
            return new StreamElement(str, this.f27157m, this.f27145a, this.f27146b, this.f27147c, this.f27148d, this.f27149e, this.f27150f, this.f27151g, this.f27152h, this.f27153i, formatArr, this.f27158n, this.f27159o, this.f27160p);
        }

        public long c(int i2) {
            if (i2 == this.f27155k - 1) {
                return this.f27160p;
            }
            long[] jArr = this.f27159o;
            return jArr[i2 + 1] - jArr[i2];
        }

        public int d(long j2) {
            return Util.i(this.f27159o, j2, true, true);
        }

        public long e(int i2) {
            return this.f27159o[i2];
        }

        private StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j3) {
            this.f27156l = str;
            this.f27157m = str2;
            this.f27145a = i2;
            this.f27146b = str3;
            this.f27147c = j2;
            this.f27148d = str4;
            this.f27149e = i3;
            this.f27150f = i4;
            this.f27151g = i5;
            this.f27152h = i6;
            this.f27153i = str5;
            this.f27154j = formatArr;
            this.f27158n = list;
            this.f27159o = jArr;
            this.f27160p = j3;
            this.f27155k = list.size();
        }
    }

    private SsManifest(int i2, int i3, long j2, long j3, int i4, boolean z2, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.f27134a = i2;
        this.f27135b = i3;
        this.f27140g = j2;
        this.f27141h = j3;
        this.f27136c = i4;
        this.f27137d = z2;
        this.f27138e = protectionElement;
        this.f27139f = streamElementArr;
    }
}
