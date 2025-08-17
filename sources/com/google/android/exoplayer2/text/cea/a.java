package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).f27323b, ((Cea708Decoder.Cea708CueInfo) obj).f27323b);
    }
}
