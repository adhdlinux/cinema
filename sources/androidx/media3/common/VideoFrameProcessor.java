package androidx.media3.common;

import android.view.Surface;
import java.util.List;

public interface VideoFrameProcessor {

    public interface Factory {
    }

    Surface b();

    void c(int i2, List<Effect> list, FrameInfo frameInfo);

    boolean d();

    int e();

    void flush();
}
