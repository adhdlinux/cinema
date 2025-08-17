package androidx.media3.common;

import android.content.Context;
import androidx.media3.common.VideoGraph;
import java.util.List;
import java.util.concurrent.Executor;

public interface PreviewingVideoGraph extends VideoGraph {

    public interface Factory {
        PreviewingVideoGraph a(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j2) throws VideoFrameProcessingException;
    }

    void b(long j2);
}
