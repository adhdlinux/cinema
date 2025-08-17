package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;

public final class SubtitleTranscodingExtractorOutput implements ExtractorOutput {

    /* renamed from: b  reason: collision with root package name */
    private final ExtractorOutput f8805b;

    /* renamed from: c  reason: collision with root package name */
    private final SubtitleParser.Factory f8806c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<SubtitleTranscodingTrackOutput> f8807d = new SparseArray<>();

    public SubtitleTranscodingExtractorOutput(ExtractorOutput extractorOutput, SubtitleParser.Factory factory) {
        this.f8805b = extractorOutput;
        this.f8806c = factory;
    }

    public void a() {
        for (int i2 = 0; i2 < this.f8807d.size(); i2++) {
            this.f8807d.valueAt(i2).k();
        }
    }

    public TrackOutput d(int i2, int i3) {
        if (i3 != 3) {
            return this.f8805b.d(i2, i3);
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = this.f8807d.get(i2);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(this.f8805b.d(i2, i3), this.f8806c);
        this.f8807d.put(i2, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }

    public void m() {
        this.f8805b.m();
    }

    public void r(SeekMap seekMap) {
        this.f8805b.r(seekMap);
    }
}
