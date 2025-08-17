package com.uwetrottmann.trakt5.enums;

import com.google.android.gms.cast.HlsSegmentFormat;
import java.util.HashMap;
import java.util.Map;

public enum Audio implements TraktEnum {
    LPCM("lpcm"),
    MP3(HlsSegmentFormat.MP3),
    MP2("mp2"),
    AAC(HlsSegmentFormat.AAC),
    OGG("ogg"),
    OGG_OPUS("ogg_opus"),
    WMA("wma"),
    FLAC("flac"),
    DTS("dts"),
    DTS_MA("dts_ma"),
    DTS_HR("dts_hr"),
    DTS_X("dts_x"),
    AURO_3D("auro_3d"),
    DOLBY_DIGITAL("dolby_digital"),
    DOLBY_DIGITAL_PLUS("dolby_digital_plus"),
    DOLBY_DIGITAL_PLUS_ATMOS("dolby_digital_plus_atmos"),
    DOLBY_ATMOS("dolby_atmos"),
    DOLBY_TRUEHD("dolby_truehd"),
    DOLBY_PROLOGIC("dolby_prologic");
    
    private static final Map<String, Audio> STRING_MAPPING = null;
    private final String value;

    static {
        int i2;
        STRING_MAPPING = new HashMap();
        for (Audio audio : values()) {
            STRING_MAPPING.put(audio.toString(), audio);
        }
    }

    private Audio(String str) {
        this.value = str;
    }

    public static Audio fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    public String toString() {
        return this.value;
    }
}
