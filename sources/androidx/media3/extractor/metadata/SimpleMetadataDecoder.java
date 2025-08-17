package androidx.media3.extractor.metadata;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    public final Metadata a(MetadataInputBuffer metadataInputBuffer) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(metadataInputBuffer.f5067d);
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        return b(metadataInputBuffer, byteBuffer);
    }

    /* access modifiers changed from: protected */
    public abstract Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
