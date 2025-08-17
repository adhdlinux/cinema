package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import java.util.ArrayList;

public final class WebvttParser implements SubtitleParser {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9145a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final WebvttCssParser f9146b = new WebvttCssParser();

    private static int d(ParsableByteArray parsableByteArray) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = parsableByteArray.f();
            String s2 = parsableByteArray.s();
            if (s2 == null) {
                i2 = 0;
            } else if ("STYLE".equals(s2)) {
                i2 = 2;
            } else if (s2.startsWith("NOTE")) {
                i2 = 1;
            } else {
                i2 = 3;
            }
        }
        parsableByteArray.U(i3);
        return i2;
    }

    private static void e(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.s()));
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        WebvttCueInfo m2;
        this.f9145a.S(bArr, i3 + i2);
        this.f9145a.U(i2);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.e(this.f9145a);
            do {
            } while (!TextUtils.isEmpty(this.f9145a.s()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int d2 = d(this.f9145a);
                if (d2 == 0) {
                    LegacySubtitleUtil.c(new WebvttSubtitle(arrayList2), outputOptions, consumer);
                    return;
                } else if (d2 == 1) {
                    e(this.f9145a);
                } else if (d2 == 2) {
                    if (arrayList2.isEmpty()) {
                        this.f9145a.s();
                        arrayList.addAll(this.f9146b.d(this.f9145a));
                    } else {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                } else if (d2 == 3 && (m2 = WebvttCueParser.m(this.f9145a, arrayList)) != null) {
                    arrayList2.add(m2);
                }
            }
        } catch (ParserException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 1;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }
}
