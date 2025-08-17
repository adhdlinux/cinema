package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext a();

        public abstract Builder b(String str);

        public abstract Builder c(byte[] bArr);

        public abstract Builder d(Priority priority);
    }

    public static Builder a() {
        return new AutoValue_TransportContext.Builder().d(Priority.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Priority d();

    public boolean e() {
        return c() != null;
    }

    public TransportContext f(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        if (c() == null) {
            str = "";
        } else {
            str = Base64.encodeToString(c(), 2);
        }
        objArr[2] = str;
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
