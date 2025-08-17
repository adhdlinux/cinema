package com.google.android.exoplayer2.source.smoothstreaming.offline;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class SsDownloader extends SegmentDownloader<SsManifest> {
    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem.b().i(Util.B(((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c)).f23202a)).a(), new SsManifestParser(), factory, executor, 20000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, SsManifest ssManifest, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (SsManifest.StreamElement streamElement : ssManifest.f27139f) {
            for (int i2 = 0; i2 < streamElement.f27154j.length; i2++) {
                for (int i3 = 0; i3 < streamElement.f27155k; i3++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.e(i3), new DataSpec(streamElement.a(i2, i3))));
                }
            }
        }
        return arrayList;
    }

    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
    }
}
