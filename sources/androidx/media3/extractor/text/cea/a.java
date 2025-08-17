package androidx.media3.extractor.text.cea;

import androidx.media3.extractor.text.cea.Cea708Decoder;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).f8860b, ((Cea708Decoder.Cea708CueInfo) obj).f8860b);
    }
}
