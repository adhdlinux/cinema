package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderException;

public final class FfmpegDecoderException extends DecoderException {
    FfmpegDecoderException(String str) {
        super(str);
    }

    FfmpegDecoderException(String str, Throwable th) {
        super(str, th);
    }
}
