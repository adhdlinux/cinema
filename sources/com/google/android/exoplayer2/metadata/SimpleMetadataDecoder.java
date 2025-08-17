package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    public final Metadata a(MetadataInputBuffer metadataInputBuffer) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(metadataInputBuffer.f23961d);
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (metadataInputBuffer.j()) {
            return null;
        }
        return b(metadataInputBuffer, byteBuffer);
    }

    /* access modifiers changed from: protected */
    public abstract Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
