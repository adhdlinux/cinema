package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class zzfug implements FilenameFilter {
    private final Pattern zza;

    public zzfug(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }

    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }
}
