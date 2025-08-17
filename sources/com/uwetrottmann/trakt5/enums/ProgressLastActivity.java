package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum ProgressLastActivity implements TraktEnum {
    COLLECTED("collected"),
    WATCHED("watched");
    
    private static final Map<String, ProgressLastActivity> STRING_MAPPING = null;
    private final String value;

    static {
        int i2;
        STRING_MAPPING = new HashMap();
        for (ProgressLastActivity progressLastActivity : values()) {
            STRING_MAPPING.put(progressLastActivity.toString().toUpperCase(Locale.ROOT), progressLastActivity);
        }
    }

    private ProgressLastActivity(String str) {
        this.value = str;
    }

    public static ProgressLastActivity fromValue(String str) {
        return STRING_MAPPING.get(str.toUpperCase(Locale.ROOT));
    }

    public String toString() {
        return this.value;
    }
}
