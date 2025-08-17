package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

public final class WebvttDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f27618o = new ParsableByteArray();

    /* renamed from: p  reason: collision with root package name */
    private final WebvttCssParser f27619p = new WebvttCssParser();

    public WebvttDecoder() {
        super("WebvttDecoder");
    }

    private static int B(ParsableByteArray parsableByteArray) {
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

    private static void C(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.s()));
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        WebvttCueInfo m2;
        this.f27618o.S(bArr, i2);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.e(this.f27618o);
            do {
            } while (!TextUtils.isEmpty(this.f27618o.s()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int B = B(this.f27618o);
                if (B == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (B == 1) {
                    C(this.f27618o);
                } else if (B == 2) {
                    if (arrayList2.isEmpty()) {
                        this.f27618o.s();
                        arrayList.addAll(this.f27619p.d(this.f27618o));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (B == 3 && (m2 = WebvttCueParser.m(this.f27618o, arrayList)) != null) {
                    arrayList2.add(m2);
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException((Throwable) e2);
        }
    }
}
