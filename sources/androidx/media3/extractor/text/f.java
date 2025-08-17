package androidx.media3.extractor.text;

import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

public final /* synthetic */ class f {
    public static Subtitle a(SubtitleParser subtitleParser, byte[] bArr, int i2, int i3) {
        ImmutableList.Builder k2 = ImmutableList.k();
        SubtitleParser.OutputOptions a2 = SubtitleParser.OutputOptions.f8799c;
        Objects.requireNonNull(k2);
        subtitleParser.a(bArr, i2, i3, a2, new e(k2));
        return new CuesWithTimingSubtitle(k2.k());
    }

    public static void b(SubtitleParser subtitleParser) {
    }
}
