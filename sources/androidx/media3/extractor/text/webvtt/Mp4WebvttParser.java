package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import java.util.ArrayList;
import java.util.Collections;

public final class Mp4WebvttParser implements SubtitleParser {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9096a = new ParsableByteArray();

    private static Cue d(ParsableByteArray parsableByteArray, int i2) {
        boolean z2;
        CharSequence charSequence = null;
        Cue.Builder builder = null;
        while (i2 > 0) {
            if (i2 >= 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "Incomplete vtt cue box header found.");
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            int i3 = q2 - 8;
            String I = Util.I(parsableByteArray.e(), parsableByteArray.f(), i3);
            parsableByteArray.V(i3);
            i2 = (i2 - 8) - i3;
            if (q3 == 1937011815) {
                builder = WebvttCueParser.o(I);
            } else if (q3 == 1885436268) {
                charSequence = WebvttCueParser.q((String) null, I.trim(), Collections.emptyList());
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

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        boolean z2;
        this.f9096a.S(bArr, i3 + i2);
        this.f9096a.U(i2);
        ArrayList arrayList = new ArrayList();
        while (this.f9096a.a() > 0) {
            if (this.f9096a.a() >= 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "Incomplete Mp4Webvtt Top Level box header found.");
            int q2 = this.f9096a.q();
            if (this.f9096a.q() == 1987343459) {
                arrayList.add(d(this.f9096a, q2 - 8));
            } else {
                this.f9096a.V(q2 - 8);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 2;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }
}
