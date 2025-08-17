package com.facebook.systrace;

public final class SystraceMessage {
    private static final Builder NOOP_BUILDER = new NoopBuilder();

    public static abstract class Builder {
        public abstract Builder arg(String str, double d2);

        public abstract Builder arg(String str, int i2);

        public abstract Builder arg(String str, long j2);

        public abstract Builder arg(String str, Object obj);

        public abstract void flush();
    }

    private interface Flusher {
        void flush(StringBuilder sb);
    }

    private static class NoopBuilder extends Builder {
        private NoopBuilder() {
        }

        public Builder arg(String str, double d2) {
            return this;
        }

        public Builder arg(String str, int i2) {
            return this;
        }

        public Builder arg(String str, long j2) {
            return this;
        }

        public Builder arg(String str, Object obj) {
            return this;
        }

        public void flush() {
        }
    }

    public static Builder beginSection(long j2, String str) {
        return NOOP_BUILDER;
    }

    public static Builder endSection(long j2) {
        return NOOP_BUILDER;
    }
}
