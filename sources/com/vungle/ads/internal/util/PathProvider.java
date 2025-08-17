package com.vungle.ads.internal.util;

import android.content.Context;
import android.os.StatFs;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class PathProvider {
    private static final String CLEVER_CACHE_FOLDER = "clever_cache";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DOWNLOADS_FOLDER = "downloads";
    private static final String JS_FOLDER = "js";
    private static final long UNKNOWN_SIZE = -1;
    private static final String VUNGLE_FOLDER = "vungle_cache";
    private final File cleverCacheDir;
    private final Context context;
    private final File downloadsDir;
    private final File jsDir;
    private final File vungleDir;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PathProvider(Context context2) {
        Intrinsics.f(context2, "context");
        this.context = context2;
        File file = new File(context2.getNoBackupFilesDir(), VUNGLE_FOLDER);
        this.vungleDir = file;
        File file2 = new File(file, DOWNLOADS_FOLDER);
        this.downloadsDir = file2;
        File file3 = new File(file, JS_FOLDER);
        this.jsDir = file3;
        File file4 = new File(file, CLEVER_CACHE_FOLDER);
        this.cleverCacheDir = file4;
        for (File file5 : CollectionsKt__CollectionsKt.i(file, file2, file3, file4)) {
            if (!file5.exists()) {
                file5.mkdirs();
            }
        }
    }

    public final long getAvailableBytes(String str) {
        Intrinsics.f(str, "path");
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e2) {
            Logger.Companion companion = Logger.Companion;
            companion.w("PathProvider", "Failed to get available bytes " + e2.getMessage());
            return -1;
        }
    }

    public final File getCleverCacheDir() {
        if (!this.cleverCacheDir.exists()) {
            this.cleverCacheDir.mkdirs();
        }
        return this.cleverCacheDir;
    }

    public final Context getContext() {
        return this.context;
    }

    public final File getDownloadDir() {
        if (!this.downloadsDir.exists()) {
            this.downloadsDir.mkdirs();
        }
        return this.downloadsDir;
    }

    public final File getDownloadsDirForAd(String str) {
        boolean z2;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return null;
        }
        File downloadDir = getDownloadDir();
        File file = new File(downloadDir.getPath() + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File getJsAssetDir(String str) {
        Intrinsics.f(str, "jsVersion");
        File file = new File(getJsDir(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File getJsDir() {
        if (!this.jsDir.exists()) {
            this.jsDir.mkdirs();
        }
        return this.jsDir;
    }

    public final File getSharedPrefsDir() {
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        Intrinsics.e(noBackupFilesDir, "{\n        context.noBackupFilesDir\n    }");
        return noBackupFilesDir;
    }

    public final File getUnclosedAdFile(String str) {
        Intrinsics.f(str, "name");
        return new File(getSharedPrefsDir(), str);
    }

    public final File getVungleDir() {
        if (!this.vungleDir.exists()) {
            this.vungleDir.mkdirs();
        }
        return this.vungleDir;
    }
}
