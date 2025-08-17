package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import java.io.EOFException;
import java.io.IOException;

public final class Id3Peeker {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8050a = new ParsableByteArray(10);

    public Metadata a(ExtractorInput extractorInput, Id3Decoder.FramePredicate framePredicate) throws IOException {
        Metadata metadata = null;
        int i2 = 0;
        while (true) {
            try {
                extractorInput.m(this.f8050a.e(), 0, 10);
                this.f8050a.U(0);
                if (this.f8050a.K() != 4801587) {
                    break;
                }
                this.f8050a.V(3);
                int G = this.f8050a.G();
                int i3 = G + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f8050a.e(), 0, bArr, 0, 10);
                    extractorInput.m(bArr, 10, G);
                    metadata = new Id3Decoder(framePredicate).e(bArr, i3);
                } else {
                    extractorInput.h(G);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        extractorInput.e();
        extractorInput.h(i2);
        return metadata;
    }
}
