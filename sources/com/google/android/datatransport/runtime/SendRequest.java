package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract SendRequest a();

        /* access modifiers changed from: package-private */
        public abstract Builder b(Encoding encoding);

        /* access modifiers changed from: package-private */
        public abstract Builder c(Event<?> event);

        /* access modifiers changed from: package-private */
        public abstract Builder d(Transformer<?, byte[]> transformer);

        public abstract Builder e(TransportContext transportContext);

        public abstract Builder f(String str);
    }

    SendRequest() {
    }

    public static Builder a() {
        return new AutoValue_SendRequest.Builder();
    }

    public abstract Encoding b();

    /* access modifiers changed from: package-private */
    public abstract Event<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* access modifiers changed from: package-private */
    public abstract Transformer<?, byte[]> e();

    public abstract TransportContext f();

    public abstract String g();
}
