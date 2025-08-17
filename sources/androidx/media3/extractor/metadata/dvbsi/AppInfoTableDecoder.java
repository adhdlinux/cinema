package androidx.media3.extractor.metadata.dvbsi;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    private static Metadata c(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(12);
        int d2 = (parsableBitArray.d() + parsableBitArray.h(12)) - 4;
        parsableBitArray.r(44);
        parsableBitArray.s(parsableBitArray.h(12));
        parsableBitArray.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (parsableBitArray.d() >= d2) {
                break;
            }
            parsableBitArray.r(48);
            int h2 = parsableBitArray.h(8);
            parsableBitArray.r(4);
            int d3 = parsableBitArray.d() + parsableBitArray.h(12);
            String str2 = null;
            while (parsableBitArray.d() < d3) {
                int h3 = parsableBitArray.h(8);
                int h4 = parsableBitArray.h(8);
                int d4 = parsableBitArray.d() + h4;
                if (h3 == 2) {
                    int h5 = parsableBitArray.h(16);
                    parsableBitArray.r(8);
                    if (h5 != 3) {
                    }
                    while (parsableBitArray.d() < d4) {
                        str = parsableBitArray.l(parsableBitArray.h(8), Charsets.US_ASCII);
                        int h6 = parsableBitArray.h(8);
                        for (int i2 = 0; i2 < h6; i2++) {
                            parsableBitArray.s(parsableBitArray.h(8));
                        }
                    }
                } else if (h3 == 21) {
                    str2 = parsableBitArray.l(h4, Charsets.US_ASCII);
                }
                parsableBitArray.p(d4 * 8);
            }
            parsableBitArray.p(d3 * 8);
            if (!(str == null || str2 == null)) {
                arrayList.add(new AppInfoTable(h2, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
