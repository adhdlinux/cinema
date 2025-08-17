package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;

public final class TimelineWithUpdatedMediaItem extends ForwardingTimeline {

    /* renamed from: f  reason: collision with root package name */
    private final MediaItem f7175f;

    public TimelineWithUpdatedMediaItem(Timeline timeline, MediaItem mediaItem) {
        super(timeline);
        this.f7175f = mediaItem;
    }

    public Timeline.Window o(int i2, Timeline.Window window, long j2) {
        Object obj;
        super.o(i2, window, j2);
        MediaItem mediaItem = this.f7175f;
        window.f4374c = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f4079b;
        if (localConfiguration != null) {
            obj = localConfiguration.f4178h;
        } else {
            obj = null;
        }
        window.f4373b = obj;
        return window;
    }
}
