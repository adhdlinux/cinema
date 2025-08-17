package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class WebvttExtractor implements Extractor {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f26541g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f26542h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private final String f26543a;

    /* renamed from: b  reason: collision with root package name */
    private final TimestampAdjuster f26544b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f26545c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private ExtractorOutput f26546d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f26547e = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    private int f26548f;

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster) {
        this.f26543a = str;
        this.f26544b = timestampAdjuster;
    }

    @RequiresNonNull({"output"})
    private TrackOutput b(long j2) {
        TrackOutput d2 = this.f26546d.d(0, 3);
        d2.d(new Format.Builder().g0("text/vtt").X(this.f26543a).k0(j2).G());
        this.f26546d.m();
        return d2;
    }

    @RequiresNonNull({"output"})
    private void d() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f26547e);
        WebvttParserUtil.e(parsableByteArray);
        long j2 = 0;
        long j3 = 0;
        for (String s2 = parsableByteArray.s(); !TextUtils.isEmpty(s2); s2 = parsableByteArray.s()) {
            if (s2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f26541g.matcher(s2);
                if (matcher.find()) {
                    Matcher matcher2 = f26542h.matcher(s2);
                    if (matcher2.find()) {
                        j3 = WebvttParserUtil.d((String) Assertions.e(matcher.group(1)));
                        j2 = TimestampAdjuster.f(Long.parseLong((String) Assertions.e(matcher2.group(1))));
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
        long d2 = WebvttParserUtil.d((String) Assertions.e(a2.group(1)));
        long b2 = this.f26544b.b(TimestampAdjuster.j((j2 + d2) - j3));
        TrackOutput b3 = b(b2 - d2);
        this.f26545c.S(this.f26547e, this.f26548f);
        b3.c(this.f26545c, this.f26548f);
        b3.e(b2, 1, this.f26548f, 0, (TrackOutput.CryptoData) null);
    }

    public void a(long j2, long j3) {
        throw new IllegalStateException();
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f26546d = extractorOutput;
        extractorOutput.u(new SeekMap.Unseekable(-9223372036854775807L));
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        extractorInput.c(this.f26547e, 0, 6, false);
        this.f26545c.S(this.f26547e, 6);
        if (WebvttParserUtil.b(this.f26545c)) {
            return true;
        }
        extractorInput.c(this.f26547e, 6, 3, false);
        this.f26545c.S(this.f26547e, 9);
        return WebvttParserUtil.b(this.f26545c);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        Assertions.e(this.f26546d);
        int length = (int) extractorInput.getLength();
        int i3 = this.f26548f;
        byte[] bArr = this.f26547e;
        if (i3 == bArr.length) {
            if (length != -1) {
                i2 = length;
            } else {
                i2 = bArr.length;
            }
            this.f26547e = Arrays.copyOf(bArr, (i2 * 3) / 2);
        }
        byte[] bArr2 = this.f26547e;
        int i4 = this.f26548f;
        int read = extractorInput.read(bArr2, i4, bArr2.length - i4);
        if (read != -1) {
            int i5 = this.f26548f + read;
            this.f26548f = i5;
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
