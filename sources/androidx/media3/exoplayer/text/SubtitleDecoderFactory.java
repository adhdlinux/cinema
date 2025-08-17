package androidx.media3.exoplayer.text;

import androidx.media3.common.Format;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import java.util.Objects;

public interface SubtitleDecoderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final SubtitleDecoderFactory f7326a = new SubtitleDecoderFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final DefaultSubtitleParserFactory f7327b = new DefaultSubtitleParserFactory();

        public SubtitleDecoder a(Format format) {
            String str = format.f4015n;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        return new Cea608Decoder(str, format.G, 16000);
                    case 2:
                        return new Cea708Decoder(format.G, format.f4018q);
                }
            }
            if (this.f7327b.c(format)) {
                SubtitleParser b2 = this.f7327b.b(format);
                return new DelegatingSubtitleDecoder(b2.getClass().getSimpleName() + "Decoder", b2);
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        public boolean c(Format format) {
            String str = format.f4015n;
            if (this.f7327b.c(format) || Objects.equals(str, "application/cea-608") || Objects.equals(str, "application/x-mp4-cea-608") || Objects.equals(str, "application/cea-708")) {
                return true;
            }
            return false;
        }
    };

    SubtitleDecoder a(Format format);

    boolean c(Format format);
}
