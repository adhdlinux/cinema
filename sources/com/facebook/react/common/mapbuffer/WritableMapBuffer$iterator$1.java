package com.facebook.react.common.mapbuffer;

import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.WritableMapBuffer;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class WritableMapBuffer$iterator$1 implements Iterator<MapBuffer.Entry>, KMappedMarker {
    private int count;
    final /* synthetic */ WritableMapBuffer this$0;

    WritableMapBuffer$iterator$1(WritableMapBuffer writableMapBuffer) {
        this.this$0 = writableMapBuffer;
    }

    public final int getCount() {
        return this.count;
    }

    public boolean hasNext() {
        return this.count < this.this$0.values.size();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCount(int i2) {
        this.count = i2;
    }

    public MapBuffer.Entry next() {
        WritableMapBuffer writableMapBuffer = this.this$0;
        int i2 = this.count;
        this.count = i2 + 1;
        return new WritableMapBuffer.MapBufferEntry(writableMapBuffer, i2);
    }
}
