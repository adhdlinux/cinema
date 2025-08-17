package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class HlsDownloader extends SegmentDownloader<HlsPlaylist> {
    public HlsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new HlsPlaylistParser(), factory, executor, 20000);
    }

    private void l(List<Uri> list, List<DataSpec> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list2.add(SegmentDownloader.f(list.get(i2)));
        }
    }

    private void m(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment, HashSet<Uri> hashSet, ArrayList<SegmentDownloader.Segment> arrayList) {
        String str = hlsMediaPlaylist.f26645a;
        long j2 = hlsMediaPlaylist.f26586h + segment.f26612f;
        String str2 = segment.f26614h;
        if (str2 != null) {
            Uri e2 = UriUtil.e(str, str2);
            if (hashSet.add(e2)) {
                arrayList.add(new SegmentDownloader.Segment(j2, SegmentDownloader.f(e2)));
            }
        }
        arrayList.add(new SegmentDownloader.Segment(j2, new DataSpec(UriUtil.e(str, segment.f26608b), segment.f26616j, segment.f26617k)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, HlsPlaylist hlsPlaylist, boolean z2) throws IOException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        if (hlsPlaylist instanceof HlsMultivariantPlaylist) {
            l(((HlsMultivariantPlaylist) hlsPlaylist).f26625d, arrayList);
        } else {
            arrayList.add(SegmentDownloader.f(Uri.parse(hlsPlaylist.f26645a)));
        }
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DataSpec dataSpec = (DataSpec) it2.next();
            arrayList2.add(new SegmentDownloader.Segment(0, dataSpec));
            try {
                HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) g(dataSource, dataSpec, z2);
                List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.f26596r;
                HlsMediaPlaylist.Segment segment = null;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    HlsMediaPlaylist.Segment segment2 = list.get(i2);
                    HlsMediaPlaylist.Segment segment3 = segment2.f26609c;
                    if (!(segment3 == null || segment3 == segment)) {
                        m(hlsMediaPlaylist, segment3, hashSet, arrayList2);
                        segment = segment3;
                    }
                    m(hlsMediaPlaylist, segment2, hashSet, arrayList2);
                }
            } catch (IOException e2) {
                if (!z2) {
                    throw e2;
                }
            }
        }
        return arrayList2;
    }

    public HlsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<HlsPlaylist> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
    }
}
