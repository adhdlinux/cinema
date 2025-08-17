package androidx.media3.extractor.mp3;

import androidx.media3.extractor.SeekMap;

interface Seeker extends SeekMap {

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }

        public long b(long j2) {
            return 0;
        }

        public long e() {
            return -1;
        }

        public int l() {
            return -2147483647;
        }
    }

    long b(long j2);

    long e();

    int l();
}
