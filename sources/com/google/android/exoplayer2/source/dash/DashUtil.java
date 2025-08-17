package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;

public final class DashUtil {
    private DashUtil() {
    }

    public static DataSpec a(Representation representation, String str, RangedUri rangedUri, int i2) {
        return new DataSpec.Builder().i(rangedUri.b(str)).h(rangedUri.f26323a).g(rangedUri.f26324b).f(g(representation, rangedUri)).b(i2).a();
    }

    public static ChunkIndex b(DataSource dataSource, int i2, Representation representation) throws IOException {
        return c(dataSource, i2, representation, 0);
    }

    /* JADX INFO: finally extract failed */
    public static ChunkIndex c(DataSource dataSource, int i2, Representation representation, int i3) throws IOException {
        if (representation.n() == null) {
            return null;
        }
        ChunkExtractor f2 = f(i2, representation.f26328b);
        try {
            d(f2, dataSource, representation, i3, true);
            f2.release();
            return f2.b();
        } catch (Throwable th) {
            f2.release();
            throw th;
        }
    }

    private static void d(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, int i2, boolean z2) throws IOException {
        RangedUri rangedUri = (RangedUri) Assertions.e(representation.n());
        if (z2) {
            RangedUri m2 = representation.m();
            if (m2 != null) {
                RangedUri a2 = rangedUri.a(m2, representation.f26329c.get(i2).f26274a);
                if (a2 == null) {
                    e(dataSource, representation, i2, chunkExtractor, rangedUri);
                    rangedUri = m2;
                } else {
                    rangedUri = a2;
                }
            } else {
                return;
            }
        }
        e(dataSource, representation, i2, chunkExtractor, rangedUri);
    }

    private static void e(DataSource dataSource, Representation representation, int i2, ChunkExtractor chunkExtractor, RangedUri rangedUri) throws IOException {
        new InitializationChunk(dataSource, a(representation, representation.f26329c.get(i2).f26274a, rangedUri, 0), representation.f26328b, 0, (Object) null, chunkExtractor).a();
    }

    private static ChunkExtractor f(int i2, Format format) {
        boolean z2;
        Extractor extractor;
        String str = format.f23070l;
        if (str == null || (!str.startsWith(MimeTypes.VIDEO_WEBM) && !str.startsWith("audio/webm"))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            extractor = new MatroskaExtractor();
        } else {
            extractor = new FragmentedMp4Extractor();
        }
        return new BundledChunkExtractor(extractor, i2, format);
    }

    public static String g(Representation representation, RangedUri rangedUri) {
        String a2 = representation.a();
        if (a2 != null) {
            return a2;
        }
        return rangedUri.b(representation.f26329c.get(0).f26274a).toString();
    }
}
