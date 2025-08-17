package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {

    /* renamed from: b  reason: collision with root package name */
    private final HlsExtractorFactory f26444b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final HlsPlaylistTracker f26445c;

    /* renamed from: d  reason: collision with root package name */
    private final HlsDataSourceFactory f26446d;

    /* renamed from: e  reason: collision with root package name */
    private final TransferListener f26447e;

    /* renamed from: f  reason: collision with root package name */
    private final DrmSessionManager f26448f;

    /* renamed from: g  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f26449g;

    /* renamed from: h  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26450h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f26451i;

    /* renamed from: j  reason: collision with root package name */
    private final Allocator f26452j;

    /* renamed from: k  reason: collision with root package name */
    private final IdentityHashMap<SampleStream, Integer> f26453k;

    /* renamed from: l  reason: collision with root package name */
    private final TimestampAdjusterProvider f26454l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f26455m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f26456n;

    /* renamed from: o  reason: collision with root package name */
    private final int f26457o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f26458p;

    /* renamed from: q  reason: collision with root package name */
    private final PlayerId f26459q;

    /* renamed from: r  reason: collision with root package name */
    private final HlsSampleStreamWrapper.Callback f26460r = new SampleStreamWrapperCallback();
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public MediaPeriod.Callback f26461s;

    /* renamed from: t  reason: collision with root package name */
    private int f26462t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public TrackGroupArray f26463u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public HlsSampleStreamWrapper[] f26464v;

    /* renamed from: w  reason: collision with root package name */
    private HlsSampleStreamWrapper[] f26465w;

    /* renamed from: x  reason: collision with root package name */
    private int[][] f26466x;

    /* renamed from: y  reason: collision with root package name */
    private int f26467y;

    /* renamed from: z  reason: collision with root package name */
    private SequenceableLoader f26468z;

    private class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        public void a() {
            if (HlsMediaPeriod.k(HlsMediaPeriod.this) <= 0) {
                int i2 = 0;
                for (HlsSampleStreamWrapper n2 : HlsMediaPeriod.this.f26464v) {
                    i2 += n2.n().f26010b;
                }
                TrackGroup[] trackGroupArr = new TrackGroup[i2];
                int i3 = 0;
                for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.f26464v) {
                    int i4 = hlsSampleStreamWrapper.n().f26010b;
                    int i5 = 0;
                    while (i5 < i4) {
                        trackGroupArr[i3] = hlsSampleStreamWrapper.n().b(i5);
                        i5++;
                        i3++;
                    }
                }
                TrackGroupArray unused = HlsMediaPeriod.this.f26463u = new TrackGroupArray(trackGroupArr);
                HlsMediaPeriod.this.f26461s.p(HlsMediaPeriod.this);
            }
        }

        /* renamed from: b */
        public void d(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.f26461s.d(HlsMediaPeriod.this);
        }

        public void k(Uri uri) {
            HlsMediaPeriod.this.f26445c.d(uri);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z2, int i2, boolean z3, PlayerId playerId) {
        this.f26444b = hlsExtractorFactory;
        this.f26445c = hlsPlaylistTracker;
        this.f26446d = hlsDataSourceFactory;
        this.f26447e = transferListener;
        this.f26448f = drmSessionManager;
        this.f26449g = eventDispatcher;
        this.f26450h = loadErrorHandlingPolicy;
        this.f26451i = eventDispatcher2;
        this.f26452j = allocator;
        this.f26455m = compositeSequenceableLoaderFactory;
        this.f26456n = z2;
        this.f26457o = i2;
        this.f26458p = z3;
        this.f26459q = playerId;
        this.f26468z = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
        this.f26453k = new IdentityHashMap<>();
        this.f26454l = new TimestampAdjusterProvider();
        this.f26464v = new HlsSampleStreamWrapper[0];
        this.f26465w = new HlsSampleStreamWrapper[0];
        this.f26466x = new int[0][];
    }

    private static Format A(Format format) {
        String L = Util.L(format.f23068j, 2);
        return new Format.Builder().U(format.f23060b).W(format.f23061c).M(format.f23070l).g0(MimeTypes.g(L)).K(L).Z(format.f23069k).I(format.f23065g).b0(format.f23066h).n0(format.f23076r).S(format.f23077s).R(format.f23078t).i0(format.f23063e).e0(format.f23064f).G();
    }

    static /* synthetic */ int k(HlsMediaPeriod hlsMediaPeriod) {
        int i2 = hlsMediaPeriod.f26462t - 1;
        hlsMediaPeriod.f26462t = i2;
        return i2;
    }

    private void u(long j2, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        boolean z2;
        List<HlsMultivariantPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list4.get(i2).f26638d;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z3 = true;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (Util.c(str, list4.get(i3).f26638d)) {
                        HlsMultivariantPlaylist.Rendition rendition = list4.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(rendition.f26635a);
                        arrayList2.add(rendition.f26636b);
                        if (Util.K(rendition.f26636b.f23068j, 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 &= z2;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper x2 = x(str2, 1, (Uri[]) arrayList.toArray((Uri[]) Util.k(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j2);
                list3.add(Ints.n(arrayList3));
                list2.add(x2);
                if (this.f26456n && z3) {
                    x2.d0(new TrackGroup[]{new TrackGroup(str2, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist r21, long r22, java.util.List<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> r24, java.util.List<int[]> r25, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r26) {
        /*
            r20 = this;
            r0 = r21
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r1 = r0.f26626e
            int r1 = r1.size()
            int[] r2 = new int[r1]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000e:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r0.f26626e
            int r7 = r7.size()
            r8 = 2
            r9 = 1
            if (r4 >= r7) goto L_0x0047
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r0.f26626e
            java.lang.Object r7 = r7.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r7 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r7
            com.google.android.exoplayer2.Format r7 = r7.f26640b
            int r10 = r7.f23077s
            if (r10 > 0) goto L_0x0040
            java.lang.String r10 = r7.f23068j
            java.lang.String r10 = com.google.android.exoplayer2.util.Util.L(r10, r8)
            if (r10 == 0) goto L_0x002f
            goto L_0x0040
        L_0x002f:
            java.lang.String r7 = r7.f23068j
            java.lang.String r7 = com.google.android.exoplayer2.util.Util.L(r7, r9)
            if (r7 == 0) goto L_0x003c
            r2[r4] = r9
            int r6 = r6 + 1
            goto L_0x0044
        L_0x003c:
            r7 = -1
            r2[r4] = r7
            goto L_0x0044
        L_0x0040:
            r2[r4] = r8
            int r5 = r5 + 1
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0047:
            if (r5 <= 0) goto L_0x004c
            r1 = r5
            r4 = 1
            goto L_0x0053
        L_0x004c:
            if (r6 >= r1) goto L_0x0052
            int r1 = r1 - r6
            r4 = 0
            r5 = 1
            goto L_0x0054
        L_0x0052:
            r4 = 0
        L_0x0053:
            r5 = 0
        L_0x0054:
            android.net.Uri[] r13 = new android.net.Uri[r1]
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r1]
            int[] r7 = new int[r1]
            r10 = 0
            r11 = 0
        L_0x005c:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r12 = r0.f26626e
            int r12 = r12.size()
            if (r10 >= r12) goto L_0x0088
            if (r4 == 0) goto L_0x006a
            r12 = r2[r10]
            if (r12 != r8) goto L_0x0085
        L_0x006a:
            if (r5 == 0) goto L_0x0070
            r12 = r2[r10]
            if (r12 == r9) goto L_0x0085
        L_0x0070:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant> r12 = r0.f26626e
            java.lang.Object r12 = r12.get(r10)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r12 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r12
            android.net.Uri r14 = r12.f26639a
            r13[r11] = r14
            com.google.android.exoplayer2.Format r12 = r12.f26640b
            r6[r11] = r12
            int r12 = r11 + 1
            r7[r11] = r10
            r11 = r12
        L_0x0085:
            int r10 = r10 + 1
            goto L_0x005c
        L_0x0088:
            r2 = r6[r3]
            java.lang.String r2 = r2.f23068j
            int r5 = com.google.android.exoplayer2.util.Util.K(r2, r8)
            int r2 = com.google.android.exoplayer2.util.Util.K(r2, r9)
            if (r2 == r9) goto L_0x00a0
            if (r2 != 0) goto L_0x00a8
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition> r8 = r0.f26628g
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x00a8
        L_0x00a0:
            if (r5 > r9) goto L_0x00a8
            int r8 = r2 + r5
            if (r8 <= 0) goto L_0x00a8
            r8 = 1
            goto L_0x00a9
        L_0x00a8:
            r8 = 0
        L_0x00a9:
            if (r4 != 0) goto L_0x00af
            if (r2 <= 0) goto L_0x00af
            r12 = 1
            goto L_0x00b0
        L_0x00af:
            r12 = 0
        L_0x00b0:
            java.lang.String r4 = "main"
            com.google.android.exoplayer2.Format r15 = r0.f26631j
            java.util.List<com.google.android.exoplayer2.Format> r14 = r0.f26632k
            r10 = r20
            r11 = r4
            r16 = r14
            r14 = r6
            r17 = r26
            r18 = r22
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper r10 = r10.x(r11, r12, r13, r14, r15, r16, r17, r18)
            r11 = r24
            r11.add(r10)
            r11 = r25
            r11.add(r7)
            r7 = r20
            boolean r11 = r7.f26456n
            if (r11 == 0) goto L_0x01bb
            if (r8 == 0) goto L_0x01bb
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r5 <= 0) goto L_0x015c
            com.google.android.exoplayer2.Format[] r5 = new com.google.android.exoplayer2.Format[r1]
            r11 = 0
        L_0x00e0:
            if (r11 >= r1) goto L_0x00ed
            r12 = r6[r11]
            com.google.android.exoplayer2.Format r12 = A(r12)
            r5[r11] = r12
            int r11 = r11 + 1
            goto L_0x00e0
        L_0x00ed:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            r1.<init>(r4, r5)
            r8.add(r1)
            if (r2 <= 0) goto L_0x0128
            com.google.android.exoplayer2.Format r1 = r0.f26631j
            if (r1 != 0) goto L_0x0103
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition> r1 = r0.f26628g
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0128
        L_0x0103:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r5 = ":audio"
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.google.android.exoplayer2.Format[] r5 = new com.google.android.exoplayer2.Format[r9]
            r6 = r6[r3]
            com.google.android.exoplayer2.Format r11 = r0.f26631j
            com.google.android.exoplayer2.Format r6 = y(r6, r11, r3)
            r5[r3] = r6
            r1.<init>(r2, r5)
            r8.add(r1)
        L_0x0128:
            java.util.List<com.google.android.exoplayer2.Format> r0 = r0.f26632k
            if (r0 == 0) goto L_0x0176
            r1 = 0
        L_0x012d:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0176
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r5 = ":cc:"
            r2.append(r5)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.google.android.exoplayer2.source.TrackGroup r5 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r9]
            java.lang.Object r11 = r0.get(r1)
            com.google.android.exoplayer2.Format r11 = (com.google.android.exoplayer2.Format) r11
            r6[r3] = r11
            r5.<init>(r2, r6)
            r8.add(r5)
            int r1 = r1 + 1
            goto L_0x012d
        L_0x015c:
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r1]
            r5 = 0
        L_0x015f:
            if (r5 >= r1) goto L_0x016e
            r11 = r6[r5]
            com.google.android.exoplayer2.Format r12 = r0.f26631j
            com.google.android.exoplayer2.Format r11 = y(r11, r12, r9)
            r2[r5] = r11
            int r5 = r5 + 1
            goto L_0x015f
        L_0x016e:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            r0.<init>(r4, r2)
            r8.add(r0)
        L_0x0176:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = ":id3"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r9]
            com.google.android.exoplayer2.Format$Builder r4 = new com.google.android.exoplayer2.Format$Builder
            r4.<init>()
            java.lang.String r5 = "ID3"
            com.google.android.exoplayer2.Format$Builder r4 = r4.U(r5)
            java.lang.String r5 = "application/id3"
            com.google.android.exoplayer2.Format$Builder r4 = r4.g0(r5)
            com.google.android.exoplayer2.Format r4 = r4.G()
            r2[r3] = r4
            r0.<init>(r1, r2)
            r8.add(r0)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = new com.google.android.exoplayer2.source.TrackGroup[r3]
            java.lang.Object[] r1 = r8.toArray(r1)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = (com.google.android.exoplayer2.source.TrackGroup[]) r1
            int[] r2 = new int[r9]
            int r0 = r8.indexOf(r0)
            r2[r3] = r0
            r10.d0(r1, r3, r2)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.v(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void w(long j2) {
        Map<String, DrmInitData> map;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.e(this.f26445c.c());
        if (this.f26458p) {
            map = z(hlsMultivariantPlaylist.f26634m);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z2 = !hlsMultivariantPlaylist.f26626e.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.f26628g;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.f26629h;
        this.f26462t = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z2) {
            v(hlsMultivariantPlaylist, j2, arrayList, arrayList2, map2);
        }
        u(j2, list, arrayList, arrayList2, map2);
        this.f26467y = arrayList.size();
        int i2 = 0;
        while (i2 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i2);
            String str = "subtitle:" + i2 + ":" + rendition.f26638d;
            int i3 = i2;
            HlsSampleStreamWrapper x2 = x(str, 3, new Uri[]{rendition.f26635a}, new Format[]{rendition.f26636b}, (Format) null, Collections.emptyList(), map2, j2);
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(new int[]{i3});
            arrayList.add(x2);
            x2.d0(new TrackGroup[]{new TrackGroup(str, rendition.f26636b)}, 0, new int[0]);
            i2 = i3 + 1;
            arrayList2 = arrayList3;
        }
        this.f26464v = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.f26466x = (int[][]) arrayList2.toArray(new int[0][]);
        this.f26462t = this.f26464v.length;
        for (int i4 = 0; i4 < this.f26467y; i4++) {
            this.f26464v[i4].m0(true);
        }
        for (HlsSampleStreamWrapper B : this.f26464v) {
            B.B();
        }
        this.f26465w = this.f26464v;
    }

    private HlsSampleStreamWrapper x(String str, int i2, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j2) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.f26444b, this.f26445c, uriArr, formatArr, this.f26446d, this.f26447e, this.f26454l, list, this.f26459q);
        return new HlsSampleStreamWrapper(str, i2, this.f26460r, hlsChunkSource, map, this.f26452j, j2, format, this.f26448f, this.f26449g, this.f26450h, this.f26451i, this.f26457o);
    }

    private static Format y(Format format, Format format2, boolean z2) {
        String str;
        String str2;
        int i2;
        int i3;
        int i4;
        Metadata metadata;
        String str3;
        int i5;
        int i6 = -1;
        if (format2 != null) {
            str3 = format2.f23068j;
            metadata = format2.f23069k;
            i4 = format2.f23084z;
            i3 = format2.f23063e;
            i2 = format2.f23064f;
            str2 = format2.f23062d;
            str = format2.f23061c;
        } else {
            str3 = Util.L(format.f23068j, 1);
            metadata = format.f23069k;
            if (z2) {
                i4 = format.f23084z;
                i3 = format.f23063e;
                i2 = format.f23064f;
                str2 = format.f23062d;
                str = format.f23061c;
            } else {
                i3 = 0;
                str2 = null;
                str = null;
                i4 = -1;
                i2 = 0;
            }
        }
        String g2 = MimeTypes.g(str3);
        if (z2) {
            i5 = format.f23065g;
        } else {
            i5 = -1;
        }
        if (z2) {
            i6 = format.f23066h;
        }
        return new Format.Builder().U(format.f23060b).W(str).M(format.f23070l).g0(g2).K(str3).Z(metadata).I(i5).b0(i6).J(i4).i0(i3).e0(i2).X(str2).G();
    }

    private static Map<String, DrmInitData> z(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i2);
            String str = drmInitData.f24077d;
            i2++;
            int i3 = i2;
            while (i3 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i3);
                if (TextUtils.equals(drmInitData2.f24077d, str)) {
                    drmInitData = drmInitData.g(drmInitData2);
                    arrayList.remove(i3);
                } else {
                    i3++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    public void B() {
        this.f26445c.i(this);
        for (HlsSampleStreamWrapper f02 : this.f26464v) {
            f02.f0();
        }
        this.f26461s = null;
    }

    public void a() {
        for (HlsSampleStreamWrapper b02 : this.f26464v) {
            b02.b0();
        }
        this.f26461s.d(this);
    }

    public long b() {
        return this.f26468z.b();
    }

    public boolean c() {
        return this.f26468z.c();
    }

    public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        boolean z3 = true;
        for (HlsSampleStreamWrapper a02 : this.f26464v) {
            z3 &= a02.a0(uri, loadErrorInfo, z2);
        }
        this.f26461s.d(this);
        return z3;
    }

    public long e() {
        return this.f26468z.e();
    }

    public void f(long j2) {
        this.f26468z.f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f26465w) {
            if (hlsSampleStreamWrapper.R()) {
                return hlsSampleStreamWrapper.g(j2, seekParameters);
            }
        }
        return j2;
    }

    public boolean h(long j2) {
        if (this.f26463u != null) {
            return this.f26468z.h(j2);
        }
        for (HlsSampleStreamWrapper B : this.f26464v) {
            B.B();
        }
        return false;
    }

    public long i(long j2) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f26465w;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean i02 = hlsSampleStreamWrapperArr[0].i0(j2, false);
            int i2 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.f26465w;
                if (i2 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i2].i0(j2, i02);
                i2++;
            }
            if (i02) {
                this.f26454l.b();
            }
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() throws IOException {
        for (HlsSampleStreamWrapper l2 : this.f26464v) {
            l2.l();
        }
    }

    public TrackGroupArray n() {
        return (TrackGroupArray) Assertions.e(this.f26463u);
    }

    public void o(long j2, boolean z2) {
        for (HlsSampleStreamWrapper o2 : this.f26465w) {
            o2.o(j2, z2);
        }
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f26461s = callback;
        this.f26445c.j(this);
        w(j2);
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        boolean z2;
        SampleStream sampleStream;
        int i2;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i3 = 0; i3 < exoTrackSelectionArr2.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr2[i3];
            if (sampleStream2 == null) {
                i2 = -1;
            } else {
                i2 = this.f26453k.get(sampleStream2).intValue();
            }
            iArr[i3] = i2;
            iArr2[i3] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i3];
            if (exoTrackSelection != null) {
                TrackGroup h2 = exoTrackSelection.h();
                int i4 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f26464v;
                    if (i4 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i4].n().c(h2) != -1) {
                        iArr2[i3] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.f26453k.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.f26464v.length];
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        while (i6 < this.f26464v.length) {
            for (int i7 = 0; i7 < exoTrackSelectionArr2.length; i7++) {
                ExoTrackSelection exoTrackSelection2 = null;
                if (iArr[i7] == i6) {
                    sampleStream = sampleStreamArr2[i7];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i7] = sampleStream;
                if (iArr2[i7] == i6) {
                    exoTrackSelection2 = exoTrackSelectionArr2[i7];
                }
                exoTrackSelectionArr3[i7] = exoTrackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f26464v[i6];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i8 = i5;
            int i9 = length;
            int i10 = i6;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean j02 = hlsSampleStreamWrapper.j0(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2, z3);
            int i11 = 0;
            boolean z4 = false;
            while (true) {
                z2 = true;
                if (i11 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream3 = sampleStreamArr4[i11];
                if (iArr2[i11] == i10) {
                    Assertions.e(sampleStream3);
                    sampleStreamArr3[i11] = sampleStream3;
                    this.f26453k.put(sampleStream3, Integer.valueOf(i10));
                    z4 = true;
                } else if (iArr[i11] == i10) {
                    if (sampleStream3 != null) {
                        z2 = false;
                    }
                    Assertions.g(z2);
                }
                i11++;
            }
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = hlsSampleStreamWrapperArr3;
            if (z4) {
                hlsSampleStreamWrapperArr4[i8] = hlsSampleStreamWrapper2;
                i5 = i8 + 1;
                if (i8 == 0) {
                    hlsSampleStreamWrapper2.m0(true);
                    if (!j02) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = this.f26465w;
                        if (hlsSampleStreamWrapperArr5.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr5[0]) {
                        }
                    }
                    this.f26454l.b();
                    z3 = true;
                } else {
                    if (i10 >= this.f26467y) {
                        z2 = false;
                    }
                    hlsSampleStreamWrapper2.m0(z2);
                }
            } else {
                i5 = i8;
            }
            i6 = i10 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr4;
            length = i9;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr6 = (HlsSampleStreamWrapper[]) Util.K0(hlsSampleStreamWrapperArr2, i5);
        this.f26465w = hlsSampleStreamWrapperArr6;
        this.f26468z = this.f26455m.a(hlsSampleStreamWrapperArr6);
        return j2;
    }
}
