package com.facebook.imagepipeline.systrace;

import android.os.Trace;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    public void beginSection(String str) {
    }

    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    public void endSection() {
    }

    public boolean isTracing() {
        return false;
    }

    private static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        private final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            String str2;
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append('=');
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = obj.toString();
            }
            sb.append(str2);
            return this;
        }

        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            Trace.beginSection(this.mStringBuilder.toString());
        }

        public FrescoSystrace.ArgsBuilder arg(String str, int i2) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append('=');
            sb.append(Integer.toString(i2));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, long j2) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append('=');
            sb.append(Long.toString(j2));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, double d2) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append('=');
            sb.append(Double.toString(d2));
            return this;
        }
    }
}
