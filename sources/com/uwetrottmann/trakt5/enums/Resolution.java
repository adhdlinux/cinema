package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Map;

public enum Resolution implements TraktEnum {
    UHD_4K("uhd_4k"),
    HD_1080P("hd_1080p"),
    HD_1080I("hd_1080i"),
    HD_720P("hd_720p"),
    SD_480P("sd_480p"),
    SD_480I("sd_480i"),
    SD_576P("sd_576p"),
    SD_576I("sd_576i");
    
    private static final Map<String, Resolution> STRING_MAPPING = null;
    private final String value;

    static {
        int i2;
        STRING_MAPPING = new HashMap();
        for (Resolution resolution : values()) {
            STRING_MAPPING.put(resolution.toString(), resolution);
        }
    }

    private Resolution(String str) {
        this.value = str;
    }

    public static Resolution fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    public String toString() {
        return this.value;
    }
}
