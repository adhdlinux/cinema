package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.offline.Download;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public abstract class r4 {
    public static final q4 a(Download download) {
        Intrinsics.f(download, "<this>");
        return new q4(download);
    }

    public static final String a(int i2) {
        if (i2 == 0) {
            return "STATE_QUEUED";
        }
        if (i2 == 1) {
            return "STATE_STOPPED";
        }
        if (i2 == 2) {
            return "STATE_DOWNLOADING";
        }
        if (i2 == 3) {
            return "STATE_COMPLETED";
        }
        if (i2 == 4) {
            return "STATE_FAILED";
        }
        if (i2 == 5) {
            return "STATE_REMOVING";
        }
        if (i2 == 7) {
            return "STATE_RESTARTING";
        }
        return "UNKNOWN STATE " + i2;
    }

    public static final File a(q4 q4Var, File file) {
        Intrinsics.f(q4Var, "<this>");
        return new File(file, q4Var.b());
    }
}
