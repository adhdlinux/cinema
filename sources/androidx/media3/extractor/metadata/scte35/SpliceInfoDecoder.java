package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;

public final class SpliceInfoDecoder extends SimpleMetadataDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8360a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f8361b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private TimestampAdjuster f8362c;

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        Metadata.Entry entry;
        TimestampAdjuster timestampAdjuster = this.f8362c;
        if (timestampAdjuster == null || metadataInputBuffer.f8265j != timestampAdjuster.f()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.f5069f);
            this.f8362c = timestampAdjuster2;
            timestampAdjuster2.a(metadataInputBuffer.f5069f - metadataInputBuffer.f8265j);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f8360a.S(array, limit);
        this.f8361b.o(array, limit);
        this.f8361b.r(39);
        long h2 = (((long) this.f8361b.h(1)) << 32) | ((long) this.f8361b.h(32));
        this.f8361b.r(20);
        int h3 = this.f8361b.h(12);
        int h4 = this.f8361b.h(8);
        this.f8360a.V(14);
        if (h4 == 0) {
            entry = new SpliceNullCommand();
        } else if (h4 == 255) {
            entry = PrivateCommand.b(this.f8360a, h3, h2);
        } else if (h4 == 4) {
            entry = SpliceScheduleCommand.b(this.f8360a);
        } else if (h4 == 5) {
            entry = SpliceInsertCommand.b(this.f8360a, h2, this.f8362c);
        } else if (h4 != 6) {
            entry = null;
        } else {
            entry = TimeSignalCommand.b(this.f8360a, h2, this.f8362c);
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
