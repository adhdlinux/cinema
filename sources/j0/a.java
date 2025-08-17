package j0;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

public final /* synthetic */ class a implements BinarySearchSeeker.SeekTimestampConverter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlacStreamMetadata f29216a;

    public /* synthetic */ a(FlacStreamMetadata flacStreamMetadata) {
        this.f29216a = flacStreamMetadata;
    }

    public final long a(long j2) {
        return this.f29216a.i(j2);
    }
}
