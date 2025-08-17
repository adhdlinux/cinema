package androidx.media3.extractor.metadata.mp4;

import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ComparisonChain.j().e(((SlowMotionData.Segment) obj).f8352b, ((SlowMotionData.Segment) obj2).f8352b).e(((SlowMotionData.Segment) obj).f8353c, ((SlowMotionData.Segment) obj2).f8353c).d(((SlowMotionData.Segment) obj).f8354d, ((SlowMotionData.Segment) obj2).f8354d).i();
    }
}
