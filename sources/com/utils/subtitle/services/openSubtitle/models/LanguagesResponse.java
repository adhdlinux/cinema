package com.utils.subtitle.services.openSubtitle.models;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class LanguagesResponse {
    private final List<Language> data;

    public LanguagesResponse(List<Language> list) {
        Intrinsics.f(list, "data");
        this.data = list;
    }

    public static /* synthetic */ LanguagesResponse copy$default(LanguagesResponse languagesResponse, List<Language> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = languagesResponse.data;
        }
        return languagesResponse.copy(list);
    }

    public final List<Language> component1() {
        return this.data;
    }

    public final LanguagesResponse copy(List<Language> list) {
        Intrinsics.f(list, "data");
        return new LanguagesResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LanguagesResponse) && Intrinsics.a(this.data, ((LanguagesResponse) obj).data);
    }

    public final List<Language> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "LanguagesResponse(data=" + this.data + ')';
    }
}
