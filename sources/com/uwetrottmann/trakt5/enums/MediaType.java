package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Map;

public enum MediaType implements TraktEnum {
    DIGITAL("digital"),
    BLURAY("bluray"),
    HDDVD("hddvd"),
    DVD("dvd"),
    VCD("vcd"),
    VHS("vhs"),
    BETAMAX("betamax"),
    LASERDISC("laserdisc");
    
    private static final Map<String, MediaType> STRING_MAPPING = null;
    private final String value;

    static {
        int i2;
        STRING_MAPPING = new HashMap();
        for (MediaType mediaType : values()) {
            STRING_MAPPING.put(mediaType.toString(), mediaType);
        }
    }

    private MediaType(String str) {
        this.value = str;
    }

    public static MediaType fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    public String toString() {
        return this.value;
    }
}
