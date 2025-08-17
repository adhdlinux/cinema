package com.google.android.exoplayer2.source.dash.offline;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.dash.BaseUrlExclusionList;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class DashDownloader extends SegmentDownloader<DashManifest> {

    /* renamed from: l  reason: collision with root package name */
    private final BaseUrlExclusionList f26370l;

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor, 20000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(com.google.android.exoplayer2.upstream.DataSource r27, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r28, long r29, long r31, boolean r33, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> r34) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r26 = this;
            r7 = r26
            r8 = r28
            r9 = r33
            r10 = r34
            r0 = 0
            r11 = 0
        L_0x000a:
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r8.f26270c
            int r0 = r0.size()
            if (r11 >= r0) goto L_0x00bc
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r8.f26270c
            java.lang.Object r0 = r0.get(r11)
            com.google.android.exoplayer2.source.dash.manifest.Representation r0 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r0
            int r1 = r8.f26269b     // Catch:{ IOException -> 0x00b0 }
            r12 = r27
            com.google.android.exoplayer2.source.dash.DashSegmentIndex r13 = r7.n(r12, r1, r0, r9)     // Catch:{ IOException -> 0x00ae }
            if (r13 == 0) goto L_0x00a2
            r14 = r31
            long r16 = r13.h(r14)
            r1 = -1
            int r3 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x009a
            com.google.android.exoplayer2.source.dash.BaseUrlExclusionList r1 = r7.f26370l
            com.google.common.collect.ImmutableList<com.google.android.exoplayer2.source.dash.manifest.BaseUrl> r2 = r0.f26329c
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl r1 = r1.j(r2)
            java.lang.Object r1 = com.google.android.exoplayer2.util.Util.j(r1)
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl r1 = (com.google.android.exoplayer2.source.dash.manifest.BaseUrl) r1
            java.lang.String r6 = r1.f26274a
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r18 = r0.n()
            if (r18 == 0) goto L_0x0058
            r1 = r26
            r2 = r0
            r3 = r6
            r4 = r29
            r19 = r6
            r6 = r18
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            goto L_0x005a
        L_0x0058:
            r19 = r6
        L_0x005a:
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r6 = r0.m()
            if (r6 == 0) goto L_0x006e
            r1 = r26
            r2 = r0
            r3 = r19
            r4 = r29
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
        L_0x006e:
            long r1 = r13.j()
            long r16 = r1 + r16
            r20 = 1
            long r16 = r16 - r20
            r4 = r1
        L_0x0079:
            int r1 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x00b7
            long r1 = r13.b(r4)
            long r22 = r29 + r1
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r6 = r13.f(r4)
            r1 = r26
            r2 = r0
            r3 = r19
            r24 = r4
            r4 = r22
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            long r4 = r24 + r20
            goto L_0x0079
        L_0x009a:
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>(r1)
            throw r0
        L_0x00a2:
            r14 = r31
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException     // Catch:{ IOException -> 0x00ac }
            java.lang.String r1 = "Missing segment index"
            r0.<init>(r1)     // Catch:{ IOException -> 0x00ac }
            throw r0     // Catch:{ IOException -> 0x00ac }
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b5
        L_0x00ae:
            r0 = move-exception
            goto L_0x00b3
        L_0x00b0:
            r0 = move-exception
            r12 = r27
        L_0x00b3:
            r14 = r31
        L_0x00b5:
            if (r9 == 0) goto L_0x00bb
        L_0x00b7:
            int r11 = r11 + 1
            goto L_0x000a
        L_0x00bb:
            throw r0
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.offline.DashDownloader.l(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet, long, long, boolean, java.util.ArrayList):void");
    }

    private SegmentDownloader.Segment m(Representation representation, String str, long j2, RangedUri rangedUri) {
        return new SegmentDownloader.Segment(j2, DashUtil.a(representation, str, rangedUri, 0));
    }

    private DashSegmentIndex n(final DataSource dataSource, final int i2, final Representation representation, boolean z2) throws IOException, InterruptedException {
        DashSegmentIndex l2 = representation.l();
        if (l2 != null) {
            return l2;
        }
        ChunkIndex chunkIndex = (ChunkIndex) e(new RunnableFutureTask<ChunkIndex, IOException>(this) {
            /* access modifiers changed from: protected */
            /* renamed from: f */
            public ChunkIndex d() throws IOException {
                return DashUtil.b(dataSource, i2, representation);
            }
        }, z2);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.f26330d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, DashManifest dashManifest, boolean z2) throws IOException, InterruptedException {
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < dashManifest.e(); i2++) {
            Period d2 = dashManifest2.d(i2);
            long F0 = Util.F0(d2.f26314b);
            long g2 = dashManifest2.g(i2);
            int i3 = 0;
            for (List<AdaptationSet> list = d2.f26315c; i3 < list.size(); list = list) {
                l(dataSource, list.get(i3), F0, g2, z2, arrayList);
                i3++;
            }
        }
        return arrayList;
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
        this.f26370l = new BaseUrlExclusionList();
    }
}
