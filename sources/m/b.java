package m;

import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.mp3.Mp3Extractor;

public final /* synthetic */ class b implements Id3Decoder.FramePredicate {
    public final boolean a(int i2, int i3, int i4, int i5, int i6) {
        return Mp3Extractor.s(i2, i3, i4, i5, i6);
    }
}
