package androidx.media3.exoplayer.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.FileTypes;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.TsExtractor;
import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f6294f = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b  reason: collision with root package name */
    private final int f6295b;

    /* renamed from: c  reason: collision with root package name */
    private SubtitleParser.Factory f6296c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6297d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6298e;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    private static void e(int i2, List<Integer> list) {
        if (Ints.j(f6294f, i2) != -1 && !list.contains(Integer.valueOf(i2))) {
            list.add(Integer.valueOf(i2));
        }
    }

    @SuppressLint({"SwitchIntDef"})
    private Extractor g(int i2, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
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
            return h(this.f6296c, this.f6297d, timestampAdjuster, format, list);
        }
        if (i2 == 11) {
            return i(this.f6295b, this.f6298e, format, list, timestampAdjuster, this.f6296c, this.f6297d);
        } else if (i2 != 13) {
            return null;
        } else {
            return new WebvttExtractor(format.f4005d, timestampAdjuster, this.f6296c, this.f6297d);
        }
    }

    private static FragmentedMp4Extractor h(SubtitleParser.Factory factory, boolean z2, TimestampAdjuster timestampAdjuster, Format format, List<Format> list) {
        int i2;
        if (k(format)) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z2) {
            factory = SubtitleParser.Factory.f8798a;
            i2 |= 32;
        }
        SubtitleParser.Factory factory2 = factory;
        int i3 = i2;
        if (list == null) {
            list = ImmutableList.r();
        }
        return new FragmentedMp4Extractor(factory2, i3, timestampAdjuster, (Track) null, list, (TrackOutput) null);
    }

    private static TsExtractor i(int i2, boolean z2, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z3) {
        SubtitleParser.Factory factory2;
        int i3;
        int i4 = i2 | 16;
        if (list != null) {
            i4 |= 32;
        } else if (z2) {
            list = Collections.singletonList(new Format.Builder().o0("application/cea-608").K());
        } else {
            list = Collections.emptyList();
        }
        String str = format.f4011j;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.b(str, "audio/mp4a-latm")) {
                i4 |= 2;
            }
            if (!MimeTypes.b(str, com.unity3d.services.core.device.MimeTypes.VIDEO_H264)) {
                i4 |= 4;
            }
        }
        if (!z3) {
            factory2 = SubtitleParser.Factory.f8798a;
            i3 = 1;
        } else {
            factory2 = factory;
            i3 = 0;
        }
        return new TsExtractor(2, i3, factory2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i4, list), 112800);
    }

    private static boolean k(Format format) {
        Metadata metadata = format.f4012k;
        if (metadata == null) {
            return false;
        }
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) e2).f6445d.isEmpty();
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static boolean m(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            boolean i2 = extractor.i(extractorInput);
            extractorInput.e();
            return i2;
        } catch (EOFException unused) {
            extractorInput.e();
            return false;
        } catch (Throwable th) {
            extractorInput.e();
            throw th;
        }
    }

    public Format c(Format format) {
        String str;
        if (!this.f6297d || !this.f6296c.c(format)) {
            return format;
        }
        Format.Builder S = format.a().o0("application/x-media3-cues").S(this.f6296c.a(format));
        StringBuilder sb = new StringBuilder();
        sb.append(format.f4015n);
        if (format.f4011j != null) {
            str = " " + format.f4011j;
        } else {
            str = "";
        }
        sb.append(str);
        return S.O(sb.toString()).s0(Clock.MAX_TIME).K();
    }

    /* renamed from: f */
    public BundledHlsMediaChunkExtractor d(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException {
        Format format2 = format;
        int a2 = FileTypes.a(format2.f4015n);
        int b2 = FileTypes.b(map);
        int c2 = FileTypes.c(uri);
        int[] iArr = f6294f;
        ArrayList arrayList = new ArrayList(iArr.length);
        e(a2, arrayList);
        e(b2, arrayList);
        e(c2, arrayList);
        for (int e2 : iArr) {
            e(e2, arrayList);
        }
        extractorInput.e();
        Extractor extractor = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Extractor extractor2 = (Extractor) Assertions.f(g(intValue, format2, list, timestampAdjuster));
            if (m(extractor2, extractorInput)) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster, this.f6296c, this.f6297d);
            }
            if (extractor == null && (intValue == a2 || intValue == b2 || intValue == c2 || intValue == 11)) {
                extractor = extractor2;
            }
        }
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        return new BundledHlsMediaChunkExtractor((Extractor) Assertions.f(extractor), format, timestampAdjuster, this.f6296c, this.f6297d);
    }

    /* renamed from: j */
    public DefaultHlsExtractorFactory b(boolean z2) {
        this.f6297d = z2;
        return this;
    }

    /* renamed from: l */
    public DefaultHlsExtractorFactory a(SubtitleParser.Factory factory) {
        this.f6296c = factory;
        return this;
    }

    public DefaultHlsExtractorFactory(int i2, boolean z2) {
        this.f6295b = i2;
        this.f6298e = z2;
        this.f6296c = new DefaultSubtitleParserFactory();
    }
}
