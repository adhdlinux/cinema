package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f26388d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b  reason: collision with root package name */
    private final int f26389b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26390c;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    private static void b(int i2, List<Integer> list) {
        if (Ints.j(f26388d, i2) != -1 && !list.contains(Integer.valueOf(i2))) {
            list.add(Integer.valueOf(i2));
        }
    }

    @SuppressLint({"SwitchIntDef"})
    private Extractor d(int i2, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        if (i2 == 0) {
            return new Ac3Extractor();
        }
        if (i2 == 1) {
            return new Ac4Extractor();
        }
        if (i2 == 2) {
            return new AdtsExtractor();
        }
        if (i2 == 7) {
            return new Mp3Extractor(0, 0);
        }
        if (i2 == 8) {
            return e(timestampAdjuster, format, list);
        }
        if (i2 == 11) {
            return f(this.f26389b, this.f26390c, format, list, timestampAdjuster);
        }
        if (i2 != 13) {
            return null;
        }
        return new WebvttExtractor(format.f23062d, timestampAdjuster);
    }

    private static FragmentedMp4Extractor e(TimestampAdjuster timestampAdjuster, Format format, List<Format> list) {
        int i2;
        if (g(format)) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(i2, timestampAdjuster, (Track) null, list);
    }

    private static TsExtractor f(int i2, boolean z2, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        int i3 = i2 | 16;
        if (list != null) {
            i3 |= 32;
        } else if (z2) {
            list = Collections.singletonList(new Format.Builder().g0("application/cea-608").G());
        } else {
            list = Collections.emptyList();
        }
        String str = format.f23068j;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.b(str, "audio/mp4a-latm")) {
                i3 |= 2;
            }
            if (!MimeTypes.b(str, com.unity3d.services.core.device.MimeTypes.VIDEO_H264)) {
                i3 |= 4;
            }
        }
        return new TsExtractor(2, timestampAdjuster, (TsPayloadReader.Factory) new DefaultTsPayloadReaderFactory(i3, list));
    }

    private static boolean g(Format format) {
        Metadata metadata = format.f23069k;
        if (metadata == null) {
            return false;
        }
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) e2).f26533d.isEmpty();
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static boolean h(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            boolean g2 = extractor.g(extractorInput);
            extractorInput.e();
            return g2;
        } catch (EOFException unused) {
            extractorInput.e();
            return false;
        } catch (Throwable th) {
            extractorInput.e();
            throw th;
        }
    }

    /* renamed from: c */
    public BundledHlsMediaChunkExtractor a(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException {
        int a2 = FileTypes.a(format.f23071m);
        int b2 = FileTypes.b(map);
        int c2 = FileTypes.c(uri);
        int[] iArr = f26388d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a2, arrayList);
        b(b2, arrayList);
        b(c2, arrayList);
        for (int b3 : iArr) {
            b(b3, arrayList);
        }
        extractorInput.e();
        Extractor extractor = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Extractor extractor2 = (Extractor) Assertions.e(d(intValue, format, list, timestampAdjuster));
            if (h(extractor2, extractorInput)) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster);
            }
            if (extractor == null && (intValue == a2 || intValue == b2 || intValue == c2 || intValue == 11)) {
                extractor = extractor2;
            }
        }
        return new BundledHlsMediaChunkExtractor((Extractor) Assertions.e(extractor), format, timestampAdjuster);
    }

    public DefaultHlsExtractorFactory(int i2, boolean z2) {
        this.f26389b = i2;
        this.f26390c = z2;
    }
}
