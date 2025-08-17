package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class zbu implements Api.ApiOptions.Optional {
    public final boolean equals(Object obj) {
        return obj instanceof zbu;
    }

    public final int hashCode() {
        return Objects.hashCode(zbu.class);
    }
}
