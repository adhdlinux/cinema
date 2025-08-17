package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f27568o = new ParsableByteArray();

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
    }

    private static Cue B(ParsableByteArray parsableByteArray, int i2) throws SubtitleDecoderException {
        CharSequence charSequence = null;
        Cue.Builder builder = null;
        while (i2 > 0) {
            if (i2 >= 8) {
                int q2 = parsableByteArray.q();
                int q3 = parsableByteArray.q();
                int i3 = q2 - 8;
                String E = Util.E(parsableByteArray.e(), parsableByteArray.f(), i3);
                parsableByteArray.V(i3);
                i2 = (i2 - 8) - i3;
                if (q3 == 1937011815) {
                    builder = WebvttCueParser.o(E);
                } else if (q3 == 1885436268) {
                    charSequence = WebvttCueParser.q((String) null, E.trim(), Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (builder != null) {
            return builder.o(charSequence).a();
        }
        return WebvttCueParser.l(charSequence);
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f27568o.S(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.f27568o.a() > 0) {
            if (this.f27568o.a() >= 8) {
                int q2 = this.f27568o.q();
                if (this.f27568o.q() == 1987343459) {
                    arrayList.add(B(this.f27568o, q2 - 8));
                } else {
                    this.f27568o.V(q2 - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }
}
