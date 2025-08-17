package com.facebook.imagepipeline.systrace;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class FrescoSystrace {
    public static final ArgsBuilder NO_OP_ARGS_BUILDER = new NoOpArgsBuilder();
    private static volatile Systrace sInstance = null;

    public interface ArgsBuilder {
        ArgsBuilder arg(String str, double d2);

        ArgsBuilder arg(String str, int i2);

        ArgsBuilder arg(String str, long j2);

        ArgsBuilder arg(String str, Object obj);

        void flush();
    }

    private static final class NoOpArgsBuilder implements ArgsBuilder {
        private NoOpArgsBuilder() {
        }

        public ArgsBuilder arg(String str, double d2) {
            return this;
        }

        public ArgsBuilder arg(String str, int i2) {
            return this;
        }

        public ArgsBuilder arg(String str, long j2) {
            return this;
        }

        public ArgsBuilder arg(String str, Object obj) {
            return this;
        }

        public void flush() {
        }
    }

    public interface Systrace {
        void beginSection(String str);

        ArgsBuilder beginSectionWithArgs(String str);

        void endSection();

        boolean isTracing();
    }

    private FrescoSystrace() {
    }

    public static void beginSection(String str) {
        getInstance().beginSection(str);
    }

    public static ArgsBuilder beginSectionWithArgs(String str) {
        return getInstance().beginSectionWithArgs(str);
    }

    public static void endSection() {
        getInstance().endSection();
    }

    private static Systrace getInstance() {
        if (sInstance == null) {
            synchronized (FrescoSystrace.class) {
                if (sInstance == null) {
                    sInstance = new DefaultFrescoSystrace();
                }
            }
        }
        return sInstance;
    }

    public static boolean isTracing() {
        return getInstance().isTracing();
    }

    public static void provide(Systrace systrace) {
        sInstance = systrace;
    }
}
