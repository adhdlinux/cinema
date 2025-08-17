package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.text.webvtt.WebvttParserUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class WebvttExtractor implements Extractor {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f6453i = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f6454j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private final String f6455a;

    /* renamed from: b  reason: collision with root package name */
    private final TimestampAdjuster f6456b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f6457c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f6458d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6459e;

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f6460f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f6461g = new byte[1024];

    /* renamed from: h  reason: collision with root package name */
    private int f6462h;

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z2) {
        this.f6455a = str;
        this.f6456b = timestampAdjuster;
        this.f6458d = factory;
        this.f6459e = z2;
    }

    @RequiresNonNull({"output"})
    private TrackOutput b(long j2) {
        TrackOutput d2 = this.f6460f.d(0, 3);
        d2.c(new Format.Builder().o0("text/vtt").e0(this.f6455a).s0(j2).K());
        this.f6460f.m();
        return d2;
    }

    @RequiresNonNull({"output"})
    private void d() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f6461g);
        WebvttParserUtil.e(parsableByteArray);
        long j2 = 0;
        long j3 = 0;
        for (String s2 = parsableByteArray.s(); !TextUtils.isEmpty(s2); s2 = parsableByteArray.s()) {
            if (s2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f6453i.matcher(s2);
                if (matcher.find()) {
                    Matcher matcher2 = f6454j.matcher(s2);
                    if (matcher2.find()) {
                        j3 = WebvttParserUtil.d((String) Assertions.f(matcher.group(1)));
                        j2 = TimestampAdjuster.h(Long.parseLong((String) Assertions.f(matcher2.group(1))));
                    } else {
                        throw ParserException.a("X-TIMESTAMP-MAP doesn't contain media timestamp: " + s2, (Throwable) null);
                    }
                } else {
                    throw ParserException.a("X-TIMESTAMP-MAP doesn't contain local timestamp: " + s2, (Throwable) null);
                }
            }
        }
        Matcher a2 = WebvttParserUtil.a(parsableByteArray);
        if (a2 == null) {
            b(0);
            return;
        }
        long d2 = WebvttParserUtil.d((String) Assertions.f(a2.group(1)));
        long b2 = this.f6456b.b(TimestampAdjuster.l((j2 + d2) - j3));
        TrackOutput b3 = b(b2 - d2);
        this.f6457c.S(this.f6461g, this.f6462h);
        b3.b(this.f6457c, this.f6462h);
        b3.f(b2, 1, this.f6462h, 0, (TrackOutput.CryptoData) null);
    }

    public void a(long j2, long j3) {
        throw new IllegalStateException();
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        ExtractorOutput extractorOutput2;
        if (this.f6459e) {
            extractorOutput2 = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f6458d);
        } else {
            extractorOutput2 = extractorOutput;
        }
        this.f6460f = extractorOutput2;
        extractorOutput.r(new SeekMap.Unseekable(-9223372036854775807L));
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        extractorInput.c(this.f6461g, 0, 6, false);
        this.f6457c.S(this.f6461g, 6);
        if (WebvttParserUtil.b(this.f6457c)) {
            return true;
        }
        extractorInput.c(this.f6461g, 6, 3, false);
        this.f6457c.S(this.f6461g, 9);
        return WebvttParserUtil.b(this.f6457c);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        Assertions.f(this.f6460f);
        int length = (int) extractorInput.getLength();
        int i3 = this.f6462h;
        byte[] bArr = this.f6461g;
        if (i3 == bArr.length) {
            if (length != -1) {
                i2 = length;
            } else {
                i2 = bArr.length;
            }
            this.f6461g = Arrays.copyOf(bArr, (i2 * 3) / 2);
        }
        byte[] bArr2 = this.f6461g;
        int i4 = this.f6462h;
        int read = extractorInput.read(bArr2, i4, bArr2.length - i4);
        if (read != -1) {
            int i5 = this.f6462h + read;
            this.f6462h = i5;
            if (length == -1 || i5 != length) {
                return 0;
            }
        }
        d();
        return -1;
    }

    public void release() {
    }
}
