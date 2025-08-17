package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class Language {
    private final String language_code;
    private final String language_name;

    public Language(String str, String str2) {
        Intrinsics.f(str, "language_code");
        Intrinsics.f(str2, "language_name");
        this.language_code = str;
        this.language_name = str2;
    }

    public static /* synthetic */ Language copy$default(Language language, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = language.language_code;
        }
        if ((i2 & 2) != 0) {
            str2 = language.language_name;
        }
        return language.copy(str, str2);
    }

    public final String component1() {
        return this.language_code;
    }

    public final String component2() {
        return this.language_name;
    }

    public final Language copy(String str, String str2) {
        Intrinsics.f(str, "language_code");
        Intrinsics.f(str2, "language_name");
        return new Language(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Language)) {
            return false;
        }
        Language language = (Language) obj;
        return Intrinsics.a(this.language_code, language.language_code) && Intrinsics.a(this.language_name, language.language_name);
    }

    public final String getLanguage_code() {
        return this.language_code;
    }

    public final String getLanguage_name() {
        return this.language_name;
    }

    public int hashCode() {
        return (this.language_code.hashCode() * 31) + this.language_name.hashCode();
    }

    public String toString() {
        return "Language(language_code=" + this.language_code + ", language_name=" + this.language_name + ')';
    }
}
