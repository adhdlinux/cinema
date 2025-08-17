package androidx.media3.decoder;

import androidx.media3.decoder.DecoderException;

public interface Decoder<I, O, E extends DecoderException> {
    O a() throws DecoderException;

    void c(I i2) throws DecoderException;

    I d() throws DecoderException;

    void e(long j2);

    void flush();

    String getName();

    void release();
}
