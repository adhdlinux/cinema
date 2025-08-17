package k;

import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.FlacStreamMetadata;

public final /* synthetic */ class a implements BinarySearchSeeker.SeekTimestampConverter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlacStreamMetadata f21894a;

    public /* synthetic */ a(FlacStreamMetadata flacStreamMetadata) {
        this.f21894a = flacStreamMetadata;
    }

    public final long a(long j2) {
        return this.f21894a.i(j2);
    }
}
