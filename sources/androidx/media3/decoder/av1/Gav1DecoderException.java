package androidx.media3.decoder.av1;

import androidx.media3.decoder.DecoderException;

public final class Gav1DecoderException extends DecoderException {
    Gav1DecoderException(String str) {
        super(str);
    }

    Gav1DecoderException(String str, Throwable th) {
        super(str, th);
    }
}
