package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;

public interface SubtitleParser {

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f8798a = new Factory() {
            public int a(Format format) {
                return 1;
            }

            public SubtitleParser b(Format format) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }

            public boolean c(Format format) {
                return false;
            }
        };

        int a(Format format);

        SubtitleParser b(Format format);

        boolean c(Format format);
    }

    public static class OutputOptions {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final OutputOptions f8799c = new OutputOptions(-9223372036854775807L, false);

        /* renamed from: a  reason: collision with root package name */
        public final long f8800a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8801b;

        private OutputOptions(long j2, boolean z2) {
            this.f8800a = j2;
            this.f8801b = z2;
        }

        public static OutputOptions b() {
            return f8799c;
        }

        public static OutputOptions c(long j2) {
            return new OutputOptions(j2, true);
        }
    }

    void a(byte[] bArr, int i2, int i3, OutputOptions outputOptions, Consumer<CuesWithTiming> consumer);

    Subtitle b(byte[] bArr, int i2, int i3);

    int c();

    void reset();
}
