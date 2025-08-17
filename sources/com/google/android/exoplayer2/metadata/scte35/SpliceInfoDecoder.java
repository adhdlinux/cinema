package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

public final class SpliceInfoDecoder extends SimpleMetadataDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f25463a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f25464b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private TimestampAdjuster f25465c;

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        Metadata.Entry entry;
        TimestampAdjuster timestampAdjuster = this.f25465c;
        if (timestampAdjuster == null || metadataInputBuffer.f25354j != timestampAdjuster.e()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.f23963f);
            this.f25465c = timestampAdjuster2;
            timestampAdjuster2.a(metadataInputBuffer.f23963f - metadataInputBuffer.f25354j);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f25463a.S(array, limit);
        this.f25464b.o(array, limit);
        this.f25464b.r(39);
        long h2 = (((long) this.f25464b.h(1)) << 32) | ((long) this.f25464b.h(32));
        this.f25464b.r(20);
        int h3 = this.f25464b.h(12);
        int h4 = this.f25464b.h(8);
        this.f25463a.V(14);
        if (h4 == 0) {
            entry = new SpliceNullCommand();
        } else if (h4 == 255) {
            entry = PrivateCommand.b(this.f25463a, h3, h2);
        } else if (h4 == 4) {
            entry = SpliceScheduleCommand.b(this.f25463a);
        } else if (h4 == 5) {
            entry = SpliceInsertCommand.b(this.f25463a, h2, this.f25465c);
        } else if (h4 != 6) {
            entry = null;
        } else {
            entry = TimeSignalCommand.b(this.f25463a, h2, this.f25465c);
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
