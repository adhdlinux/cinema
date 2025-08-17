package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Map;

public enum AudioChannels implements TraktEnum {
    CH1_0("1.0"),
    CH2_0("2.0"),
    CH2_1("2.1"),
    CH3_0("3.0"),
    CH3_1("3.1"),
    CH4_0("4.0"),
    CH4_1("4.1"),
    CH5_0("5.0"),
    CH5_1("5.1"),
    CH5_1_2("5.1.2"),
    CH5_1_4("5.1.4"),
    CH6_1("6.1"),
    CH7_1("7.1"),
    CH7_1_2("7.1.2"),
    CH7_1_4("7.1.4"),
    CH9_1("9.1"),
    CH10_1("10.1");
    
    private static final Map<String, AudioChannels> STRING_MAPPING = null;
    private final String value;

    static {
        int i2;
        STRING_MAPPING = new HashMap();
        for (AudioChannels audioChannels : values()) {
            STRING_MAPPING.put(audioChannels.toString(), audioChannels);
        }
    }

    private AudioChannels(String str) {
        this.value = str;
    }

    public static AudioChannels fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    public String toString() {
        return this.value;
    }
}
