package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogEvent {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract LogEvent a();

        public abstract Builder b(Integer num);

        public abstract Builder c(long j2);

        public abstract Builder d(long j2);

        public abstract Builder e(NetworkConnectionInfo networkConnectionInfo);

        /* access modifiers changed from: package-private */
        public abstract Builder f(byte[] bArr);

        /* access modifiers changed from: package-private */
        public abstract Builder g(String str);

        public abstract Builder h(long j2);
    }

    private static Builder a() {
        return new AutoValue_LogEvent.Builder();
    }

    public static Builder i(String str) {
        return a().g(str);
    }

    public static Builder j(byte[] bArr) {
        return a().f(bArr);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract NetworkConnectionInfo e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
