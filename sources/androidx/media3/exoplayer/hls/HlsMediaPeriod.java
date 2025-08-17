package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Label;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    private SequenceableLoader A;

    /* renamed from: b  reason: collision with root package name */
    private final HlsExtractorFactory f6354b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final HlsPlaylistTracker f6355c;

    /* renamed from: d  reason: collision with root package name */
    private final HlsDataSourceFactory f6356d;

    /* renamed from: e  reason: collision with root package name */
    private final TransferListener f6357e;

    /* renamed from: f  reason: collision with root package name */
    private final DrmSessionManager f6358f;

    /* renamed from: g  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f6359g;

    /* renamed from: h  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f6360h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f6361i;

    /* renamed from: j  reason: collision with root package name */
    private final Allocator f6362j;

    /* renamed from: k  reason: collision with root package name */
    private final IdentityHashMap<SampleStream, Integer> f6363k;

    /* renamed from: l  reason: collision with root package name */
    private final TimestampAdjusterProvider f6364l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f6365m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f6366n;

    /* renamed from: o  reason: collision with root package name */
    private final int f6367o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f6368p;

    /* renamed from: q  reason: collision with root package name */
    private final PlayerId f6369q;

    /* renamed from: r  reason: collision with root package name */
    private final HlsSampleStreamWrapper.Callback f6370r = new SampleStreamWrapperCallback();

    /* renamed from: s  reason: collision with root package name */
    private final long f6371s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public MediaPeriod.Callback f6372t;

    /* renamed from: u  reason: collision with root package name */
    private int f6373u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public TrackGroupArray f6374v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public HlsSampleStreamWrapper[] f6375w;

    /* renamed from: x  reason: collision with root package name */
    private HlsSampleStreamWrapper[] f6376x;

    /* renamed from: y  reason: collision with root package name */
    private int[][] f6377y;

    /* renamed from: z  reason: collision with root package name */
    private int f6378z;

    private class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        public void a() {
            if (HlsMediaPeriod.m(HlsMediaPeriod.this) <= 0) {
                int i2 = 0;
                for (HlsSampleStreamWrapper n2 : HlsMediaPeriod.this.f6375w) {
                    i2 += n2.n().f7178a;
                }
                TrackGroup[] trackGroupArr = new TrackGroup[i2];
                int i3 = 0;
                for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.f6375w) {
                    int i4 = hlsSampleStreamWrapper.n().f7178a;
                    int i5 = 0;
                    while (i5 < i4) {
                        trackGroupArr[i3] = hlsSampleStreamWrapper.n().b(i5);
                        i5++;
                        i3++;
                    }
                }
                TrackGroupArray unused = HlsMediaPeriod.this.f6374v = new TrackGroupArray(trackGroupArr);
                HlsMediaPeriod.this.f6372t.m(HlsMediaPeriod.this);
            }
        }

        /* renamed from: b */
        public void p(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.f6372t.p(HlsMediaPeriod.this);
        }

        public void k(Uri uri) {
            HlsMediaPeriod.this.f6355c.d(uri);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z2, int i2, boolean z3, PlayerId playerId, long j2) {
        this.f6354b = hlsExtractorFactory;
        this.f6355c = hlsPlaylistTracker;
        this.f6356d = hlsDataSourceFactory;
        this.f6357e = transferListener;
        this.f6358f = drmSessionManager;
        this.f6359g = eventDispatcher;
        this.f6360h = loadErrorHandlingPolicy;
        this.f6361i = eventDispatcher2;
        this.f6362j = allocator;
        this.f6365m = compositeSequenceableLoaderFactory;
        this.f6366n = z2;
        this.f6367o = i2;
        this.f6368p = z3;
        this.f6369q = playerId;
        this.f6371s = j2;
        this.A = compositeSequenceableLoaderFactory.empty();
        this.f6363k = new IdentityHashMap<>();
        this.f6364l = new TimestampAdjusterProvider();
        this.f6375w = new HlsSampleStreamWrapper[0];
        this.f6376x = new HlsSampleStreamWrapper[0];
        this.f6377y = new int[0][];
    }

    private static Map<String, DrmInitData> A(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i2);
            String str = drmInitData.f3972d;
            i2++;
            int i3 = i2;
            while (i3 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i3);
                if (TextUtils.equals(drmInitData2.f3972d, str)) {
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

    private static Format B(Format format) {
        String Q = Util.Q(format.f4011j, 2);
        return new Format.Builder().a0(format.f4002a).c0(format.f4003b).d0(format.f4004c).Q(format.f4014m).o0(MimeTypes.g(Q)).O(Q).h0(format.f4012k).M(format.f4008g).j0(format.f4009h).v0(format.f4021t).Y(format.f4022u).X(format.f4023v).q0(format.f4006e).m0(format.f4007f).K();
    }

    static /* synthetic */ int m(HlsMediaPeriod hlsMediaPeriod) {
        int i2 = hlsMediaPeriod.f6373u - 1;
        hlsMediaPeriod.f6373u = i2;
        return i2;
    }

    private void v(long j2, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        boolean z2;
        List<HlsMultivariantPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list4.get(i2).f6555d;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z3 = true;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (Util.c(str, list4.get(i3).f6555d)) {
                        HlsMultivariantPlaylist.Rendition rendition = list4.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(rendition.f6552a);
                        arrayList2.add(rendition.f6553b);
                        if (Util.P(rendition.f6553b.f4011j, 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 &= z2;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper y2 = y(str2, 1, (Uri[]) arrayList.toArray((Uri[]) Util.j(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j2);
                list3.add(Ints.n(arrayList3));
                list2.add(y2);
                if (this.f6366n && z3) {
                    y2.f0(new TrackGroup[]{new TrackGroup(str2, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist r20, long r21, java.util.List<androidx.media3.exoplayer.hls.HlsSampleStreamWrapper> r23, java.util.List<int[]> r24, java.util.Map<java.lang.String, androidx.media3.common.DrmInitData> r25) {
        /*
            r19 = this;
            r10 = r19
            r11 = r20
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r0 = r11.f6543e
            int r0 = r0.size()
            int[] r1 = new int[r0]
            r12 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0010:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r5 = r11.f6543e
            int r5 = r5.size()
            r6 = 2
            r13 = 1
            if (r2 >= r5) goto L_0x0049
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r5 = r11.f6543e
            java.lang.Object r5 = r5.get(r2)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r5 = (androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist.Variant) r5
            androidx.media3.common.Format r5 = r5.f6557b
            int r7 = r5.f4022u
            if (r7 > 0) goto L_0x0042
            java.lang.String r7 = r5.f4011j
            java.lang.String r7 = androidx.media3.common.util.Util.Q(r7, r6)
            if (r7 == 0) goto L_0x0031
            goto L_0x0042
        L_0x0031:
            java.lang.String r5 = r5.f4011j
            java.lang.String r5 = androidx.media3.common.util.Util.Q(r5, r13)
            if (r5 == 0) goto L_0x003e
            r1[r2] = r13
            int r4 = r4 + 1
            goto L_0x0046
        L_0x003e:
            r5 = -1
            r1[r2] = r5
            goto L_0x0046
        L_0x0042:
            r1[r2] = r6
            int r3 = r3 + 1
        L_0x0046:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0049:
            if (r3 <= 0) goto L_0x004e
            r14 = r3
            r0 = 1
            goto L_0x0057
        L_0x004e:
            if (r4 >= r0) goto L_0x0055
            int r0 = r0 - r4
            r14 = r0
            r0 = 0
            r2 = 1
            goto L_0x0058
        L_0x0055:
            r14 = r0
            r0 = 0
        L_0x0057:
            r2 = 0
        L_0x0058:
            android.net.Uri[] r3 = new android.net.Uri[r14]
            androidx.media3.common.Format[] r15 = new androidx.media3.common.Format[r14]
            int[] r8 = new int[r14]
            r4 = 0
            r5 = 0
        L_0x0060:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r11.f6543e
            int r7 = r7.size()
            if (r4 >= r7) goto L_0x008c
            if (r0 == 0) goto L_0x006e
            r7 = r1[r4]
            if (r7 != r6) goto L_0x0089
        L_0x006e:
            if (r2 == 0) goto L_0x0074
            r7 = r1[r4]
            if (r7 == r13) goto L_0x0089
        L_0x0074:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r11.f6543e
            java.lang.Object r7 = r7.get(r4)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r7 = (androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist.Variant) r7
            android.net.Uri r9 = r7.f6556a
            r3[r5] = r9
            androidx.media3.common.Format r7 = r7.f6557b
            r15[r5] = r7
            int r7 = r5 + 1
            r8[r5] = r4
            r5 = r7
        L_0x0089:
            int r4 = r4 + 1
            goto L_0x0060
        L_0x008c:
            r1 = r15[r12]
            java.lang.String r1 = r1.f4011j
            int r9 = androidx.media3.common.util.Util.P(r1, r6)
            int r7 = androidx.media3.common.util.Util.P(r1, r13)
            if (r7 == r13) goto L_0x00a4
            if (r7 != 0) goto L_0x00ad
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition> r1 = r11.f6545g
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00ad
        L_0x00a4:
            if (r9 > r13) goto L_0x00ad
            int r1 = r7 + r9
            if (r1 <= 0) goto L_0x00ad
            r16 = 1
            goto L_0x00af
        L_0x00ad:
            r16 = 0
        L_0x00af:
            if (r0 != 0) goto L_0x00b5
            if (r7 <= 0) goto L_0x00b5
            r2 = 1
            goto L_0x00b6
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            java.lang.String r6 = "main"
            androidx.media3.common.Format r5 = r11.f6548j
            java.util.List<androidx.media3.common.Format> r4 = r11.f6549k
            r0 = r19
            r1 = r6
            r17 = r4
            r4 = r15
            r12 = r6
            r6 = r17
            r17 = r7
            r7 = r25
            r13 = r8
            r18 = r9
            r8 = r21
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper r0 = r0.y(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r23
            r1.add(r0)
            r1 = r24
            r1.add(r13)
            boolean r1 = r10.f6366n
            if (r1 == 0) goto L_0x01d5
            if (r16 == 0) goto L_0x01d5
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r18 <= 0) goto L_0x0172
            androidx.media3.common.Format[] r2 = new androidx.media3.common.Format[r14]
            r3 = 0
        L_0x00ec:
            if (r3 >= r14) goto L_0x00f9
            r4 = r15[r3]
            androidx.media3.common.Format r4 = B(r4)
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x00ec
        L_0x00f9:
            androidx.media3.common.TrackGroup r3 = new androidx.media3.common.TrackGroup
            r3.<init>(r12, r2)
            r1.add(r3)
            if (r17 <= 0) goto L_0x0136
            androidx.media3.common.Format r2 = r11.f6548j
            if (r2 != 0) goto L_0x010f
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition> r2 = r11.f6545g
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0136
        L_0x010f:
            androidx.media3.common.TrackGroup r2 = new androidx.media3.common.TrackGroup
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r4 = ":audio"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 1
            androidx.media3.common.Format[] r5 = new androidx.media3.common.Format[r4]
            r4 = 0
            r6 = r15[r4]
            androidx.media3.common.Format r7 = r11.f6548j
            androidx.media3.common.Format r6 = z(r6, r7, r4)
            r5[r4] = r6
            r2.<init>(r3, r5)
            r1.add(r2)
        L_0x0136:
            java.util.List<androidx.media3.common.Format> r2 = r11.f6549k
            if (r2 == 0) goto L_0x018d
            r4 = 0
        L_0x013b:
            int r3 = r2.size()
            if (r4 >= r3) goto L_0x018d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r5 = ":cc:"
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            androidx.media3.common.TrackGroup r5 = new androidx.media3.common.TrackGroup
            r6 = 1
            androidx.media3.common.Format[] r7 = new androidx.media3.common.Format[r6]
            androidx.media3.exoplayer.hls.HlsExtractorFactory r6 = r10.f6354b
            java.lang.Object r8 = r2.get(r4)
            androidx.media3.common.Format r8 = (androidx.media3.common.Format) r8
            androidx.media3.common.Format r6 = r6.c(r8)
            r8 = 0
            r7[r8] = r6
            r5.<init>(r3, r7)
            r1.add(r5)
            int r4 = r4 + 1
            goto L_0x013b
        L_0x0172:
            androidx.media3.common.Format[] r2 = new androidx.media3.common.Format[r14]
            r4 = 0
        L_0x0175:
            if (r4 >= r14) goto L_0x0185
            r3 = r15[r4]
            androidx.media3.common.Format r5 = r11.f6548j
            r6 = 1
            androidx.media3.common.Format r3 = z(r3, r5, r6)
            r2[r4] = r3
            int r4 = r4 + 1
            goto L_0x0175
        L_0x0185:
            androidx.media3.common.TrackGroup r3 = new androidx.media3.common.TrackGroup
            r3.<init>(r12, r2)
            r1.add(r3)
        L_0x018d:
            androidx.media3.common.TrackGroup r2 = new androidx.media3.common.TrackGroup
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r4 = ":id3"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 1
            androidx.media3.common.Format[] r5 = new androidx.media3.common.Format[r4]
            androidx.media3.common.Format$Builder r4 = new androidx.media3.common.Format$Builder
            r4.<init>()
            java.lang.String r6 = "ID3"
            androidx.media3.common.Format$Builder r4 = r4.a0(r6)
            java.lang.String r6 = "application/id3"
            androidx.media3.common.Format$Builder r4 = r4.o0(r6)
            androidx.media3.common.Format r4 = r4.K()
            r6 = 0
            r5[r6] = r4
            r2.<init>(r3, r5)
            r1.add(r2)
            androidx.media3.common.TrackGroup[] r3 = new androidx.media3.common.TrackGroup[r6]
            java.lang.Object[] r3 = r1.toArray(r3)
            androidx.media3.common.TrackGroup[] r3 = (androidx.media3.common.TrackGroup[]) r3
            r4 = 1
            int[] r4 = new int[r4]
            int r1 = r1.indexOf(r2)
            r4[r6] = r1
            r0.f0(r3, r6, r4)
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaPeriod.w(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void x(long j2) {
        Map<String, DrmInitData> map;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.f(this.f6355c.c());
        if (this.f6368p) {
            map = A(hlsMultivariantPlaylist.f6551m);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z2 = !hlsMultivariantPlaylist.f6543e.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.f6545g;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.f6546h;
        this.f6373u = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z2) {
            w(hlsMultivariantPlaylist, j2, arrayList, arrayList2, map2);
        }
        v(j2, list, arrayList, arrayList2, map2);
        this.f6378z = arrayList.size();
        int i2 = 0;
        while (i2 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i2);
            String str = "subtitle:" + i2 + ":" + rendition.f6555d;
            Format format = rendition.f6553b;
            int i3 = i2;
            HlsSampleStreamWrapper y2 = y(str, 3, new Uri[]{rendition.f6552a}, new Format[]{format}, (Format) null, Collections.emptyList(), map2, j2);
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(new int[]{i3});
            arrayList.add(y2);
            y2.f0(new TrackGroup[]{new TrackGroup(str, this.f6354b.c(format))}, 0, new int[0]);
            i2 = i3 + 1;
            arrayList2 = arrayList3;
        }
        this.f6375w = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.f6377y = (int[][]) arrayList2.toArray(new int[0][]);
        this.f6373u = this.f6375w.length;
        for (int i4 = 0; i4 < this.f6378z; i4++) {
            this.f6375w[i4].o0(true);
        }
        for (HlsSampleStreamWrapper C : this.f6375w) {
            C.C();
        }
        this.f6376x = this.f6375w;
    }

    private HlsSampleStreamWrapper y(String str, int i2, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j2) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.f6354b, this.f6355c, uriArr, formatArr, this.f6356d, this.f6357e, this.f6364l, this.f6371s, list, this.f6369q, (CmcdConfiguration) null);
        return new HlsSampleStreamWrapper(str, i2, this.f6370r, hlsChunkSource, map, this.f6362j, j2, format, this.f6358f, this.f6359g, this.f6360h, this.f6361i, this.f6367o);
    }

    private static Format z(Format format, Format format2, boolean z2) {
        List<Label> list;
        String str;
        String str2;
        int i2;
        int i3;
        int i4;
        Metadata metadata;
        String str3;
        int i5;
        List<Label> r2 = ImmutableList.r();
        int i6 = -1;
        if (format2 != null) {
            str3 = format2.f4011j;
            metadata = format2.f4012k;
            i4 = format2.B;
            i3 = format2.f4006e;
            i2 = format2.f4007f;
            str2 = format2.f4005d;
            str = format2.f4003b;
            list = format2.f4004c;
        } else {
            String Q = Util.Q(format.f4011j, 1);
            metadata = format.f4012k;
            if (z2) {
                i4 = format.B;
                i3 = format.f4006e;
                i2 = format.f4007f;
                str2 = format.f4005d;
                str = format.f4003b;
                r2 = format.f4004c;
            } else {
                i3 = 0;
                str2 = null;
                str = null;
                i4 = -1;
                i2 = 0;
            }
            List<Label> list2 = r2;
            str3 = Q;
            list = list2;
        }
        String g2 = MimeTypes.g(str3);
        if (z2) {
            i5 = format.f4008g;
        } else {
            i5 = -1;
        }
        if (z2) {
            i6 = format.f4009h;
        }
        return new Format.Builder().a0(format.f4002a).c0(str).d0(list).Q(format.f4014m).o0(g2).O(str3).h0(metadata).M(i5).j0(i6).N(i4).q0(i3).m0(i2).e0(str2).K();
    }

    public void D() {
        this.f6355c.k(this);
        for (HlsSampleStreamWrapper h02 : this.f6375w) {
            h02.h0();
        }
        this.f6372t = null;
    }

    public void a() {
        for (HlsSampleStreamWrapper d02 : this.f6375w) {
            d02.d0();
        }
        this.f6372t.p(this);
    }

    public long b() {
        return this.A.b();
    }

    public boolean c() {
        return this.A.c();
    }

    public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        boolean z3 = true;
        for (HlsSampleStreamWrapper c02 : this.f6375w) {
            z3 &= c02.c0(uri, loadErrorInfo, z2);
        }
        this.f6372t.p(this);
        return z3;
    }

    public long e() {
        return this.A.e();
    }

    public void f(long j2) {
        this.A.f(j2);
    }

    public boolean g(LoadingInfo loadingInfo) {
        if (this.f6374v != null) {
            return this.A.g(loadingInfo);
        }
        for (HlsSampleStreamWrapper C : this.f6375w) {
            C.C();
        }
        return false;
    }

    public long h(long j2, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f6376x) {
            if (hlsSampleStreamWrapper.S()) {
                return hlsSampleStreamWrapper.h(j2, seekParameters);
            }
        }
        return j2;
    }

    public long i(long j2) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f6376x;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean k02 = hlsSampleStreamWrapperArr[0].k0(j2, false);
            int i2 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.f6376x;
                if (i2 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i2].k0(j2, k02);
                i2++;
            }
            if (k02) {
                this.f6364l.b();
            }
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() throws IOException {
        for (HlsSampleStreamWrapper l2 : this.f6375w) {
            l2.l();
        }
    }

    public TrackGroupArray n() {
        return (TrackGroupArray) Assertions.f(this.f6374v);
    }

    public void o(long j2, boolean z2) {
        for (HlsSampleStreamWrapper o2 : this.f6376x) {
            o2.o(j2, z2);
        }
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
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
                i2 = this.f6363k.get(sampleStream2).intValue();
            }
            iArr[i3] = i2;
            iArr2[i3] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i3];
            if (exoTrackSelection != null) {
                TrackGroup h2 = exoTrackSelection.h();
                int i4 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f6375w;
                    if (i4 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i4].n().d(h2) != -1) {
                        iArr2[i3] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.f6363k.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.f6375w.length];
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        while (i6 < this.f6375w.length) {
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
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f6375w[i6];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i8 = i5;
            int i9 = length;
            int i10 = i6;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean l02 = hlsSampleStreamWrapper.l0(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2, z3);
            int i11 = 0;
            boolean z4 = false;
            while (true) {
                z2 = true;
                if (i11 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream3 = sampleStreamArr4[i11];
                if (iArr2[i11] == i10) {
                    Assertions.f(sampleStream3);
                    sampleStreamArr3[i11] = sampleStream3;
                    this.f6363k.put(sampleStream3, Integer.valueOf(i10));
                    z4 = true;
                } else if (iArr[i11] == i10) {
                    if (sampleStream3 != null) {
                        z2 = false;
                    }
                    Assertions.h(z2);
                }
                i11++;
            }
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = hlsSampleStreamWrapperArr3;
            if (z4) {
                hlsSampleStreamWrapperArr4[i8] = hlsSampleStreamWrapper2;
                i5 = i8 + 1;
                if (i8 == 0) {
                    hlsSampleStreamWrapper2.o0(true);
                    if (!l02) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = this.f6376x;
                        if (hlsSampleStreamWrapperArr5.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr5[0]) {
                        }
                    }
                    this.f6364l.b();
                    z3 = true;
                } else {
                    if (i10 >= this.f6378z) {
                        z2 = false;
                    }
                    hlsSampleStreamWrapper2.o0(z2);
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
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr6 = (HlsSampleStreamWrapper[]) Util.U0(hlsSampleStreamWrapperArr2, i5);
        this.f6376x = hlsSampleStreamWrapperArr6;
        ImmutableList o2 = ImmutableList.o(hlsSampleStreamWrapperArr6);
        this.A = this.f6365m.a(o2, Lists.l(o2, new a()));
        return j2;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f6372t = callback;
        this.f6355c.l(this);
        x(j2);
    }
}
