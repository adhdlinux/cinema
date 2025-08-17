package androidx.work;

import android.os.Build;
import androidx.work.WorkRequest;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f12224c.f12519d = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public OneTimeWorkRequest c() {
            if (!this.f12222a || Build.VERSION.SDK_INT < 23 || !this.f12224c.f12525j.h()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Builder d() {
            return this;
        }
    }

    OneTimeWorkRequest(Builder builder) {
        super(builder.f12223b, builder.f12224c, builder.f12225d);
    }

    public static OneTimeWorkRequest d(Class<? extends ListenableWorker> cls) {
        return (OneTimeWorkRequest) new Builder(cls).b();
    }
}
