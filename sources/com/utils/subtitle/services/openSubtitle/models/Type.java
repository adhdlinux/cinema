package com.utils.subtitle.services.openSubtitle.models;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public enum Type {
    MOVIE("movie"),
    EPISODE("episode"),
    ALL("all");
    
    private final String value;

    static {
        Type[] $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private Type(String str) {
        this.value = str;
    }

    public static EnumEntries<Type> getEntries() {
        return $ENTRIES;
    }

    public final String getValue() {
        return this.value;
    }
}
