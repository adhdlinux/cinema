package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class EventMessageDecoder extends SimpleMetadataDecoder {
    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return new Metadata(c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) Assertions.f(parsableByteArray.B()), (String) Assertions.f(parsableByteArray.B()), parsableByteArray.A(), parsableByteArray.A(), Arrays.copyOfRange(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.g()));
    }
}
