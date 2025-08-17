package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class EventMessageDecoder extends SimpleMetadataDecoder {
    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return new Metadata(c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) Assertions.e(parsableByteArray.B()), (String) Assertions.e(parsableByteArray.B()), parsableByteArray.A(), parsableByteArray.A(), Arrays.copyOfRange(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.g()));
    }
}
