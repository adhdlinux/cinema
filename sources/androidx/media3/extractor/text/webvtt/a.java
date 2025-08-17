package androidx.media3.extractor.text.webvtt;

import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((WebvttCueParser.Element) obj).f9126a.f9129b, ((WebvttCueParser.Element) obj2).f9126a.f9129b);
    }
}
