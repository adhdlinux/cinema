package com.vungle.ads.internal.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CleanupJob implements Job {
    private static final String AD_ID_KEY = "AD_ID_KEY";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CleanupJob";
    private final Context context;
    private final PathProvider pathProvider;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ JobInfo makeJobInfo$default(Companion companion, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return companion.makeJobInfo(str);
        }

        public final JobInfo makeJobInfo(String str) {
            boolean z2 = false;
            JobInfo priority = new JobInfo(CleanupJob.TAG).setPriority(0);
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(CleanupJob.AD_ID_KEY, str);
            }
            JobInfo extras = priority.setExtras(bundle);
            if (str == null) {
                z2 = true;
            }
            return extras.setUpdateCurrent(z2);
        }
    }

    public CleanupJob(Context context2, PathProvider pathProvider2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    private final void checkIfSdkUpgraded() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy a2 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new CleanupJob$checkIfSdkUpgraded$$inlined$inject$1(this.context));
        int i2 = m209checkIfSdkUpgraded$lambda3(a2).getInt("VERSION_CODE", -1);
        if (i2 < 70403) {
            if (i2 < 70000) {
                dropV6Data();
            }
            if (i2 < 70100) {
                dropV700Data();
            }
            if (i2 < 70301) {
                dropV730TempData();
            }
            if (i2 < 70403) {
                dropV742TpatData();
            }
            m209checkIfSdkUpgraded$lambda3(a2).put("VERSION_CODE", 70403).apply();
        }
    }

    /* renamed from: checkIfSdkUpgraded$lambda-3  reason: not valid java name */
    private static final FilePreferences m209checkIfSdkUpgraded$lambda3(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    private final void dropV6Data() {
        Logger.Companion.d(TAG, "CleanupJob: drop old files data");
        int i2 = Build.VERSION.SDK_INT;
        File file = new File(this.context.getNoBackupFilesDir(), "vungle_db");
        if (file.exists()) {
            FileUtility.delete(file);
            FileUtility.delete(new File(file.getPath() + "-journal"));
        } else {
            this.context.deleteDatabase("vungle_db");
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("com.vungle.sdk", 0);
        String string = sharedPreferences.getString("cache_path", (String) null);
        if (i2 >= 24) {
            boolean unused = this.context.deleteSharedPreferences("com.vungle.sdk");
        } else {
            sharedPreferences.edit().clear().apply();
        }
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        Intrinsics.e(noBackupFilesDir, "{\n            context.noBackupFilesDir\n        }");
        FileUtility.delete(new File(noBackupFilesDir, "vungle_settings"));
        if (string != null) {
            FileUtility.delete(new File(string));
        }
    }

    private final void dropV700Data() {
        FileUtility.delete(new File(this.context.getApplicationInfo().dataDir, "vungle"));
    }

    private final void dropV730TempData() {
        try {
            FileUtility.delete(new File(this.pathProvider.getSharedPrefsDir(), "vungleSettings"));
            FileUtility.delete(new File(this.pathProvider.getSharedPrefsDir(), "failedTpatSet"));
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "Failed to delete temp data", e2);
        }
    }

    private final void dropV742TpatData() {
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        try {
            FileUtility.delete(new File(noBackupFilesDir, FilePreferences.TPAT_FAILED_FILENAME));
            FileUtility.delete(new File(noBackupFilesDir, FilePreferences.GENERIC_TPAT_FAILED_FILENAME));
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "Failed to delete 742 tpat data", e2);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        File file;
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(jobRunner, "jobRunner");
        File downloadDir = this.pathProvider.getDownloadDir();
        String string = bundle.getString(AD_ID_KEY);
        if (string == null || (file = this.pathProvider.getDownloadsDirForAd(string)) == null) {
            file = downloadDir;
        }
        Logger.Companion.d(TAG, "CleanupJob: Current directory snapshot");
        try {
            if (Intrinsics.a(file, downloadDir)) {
                checkIfSdkUpgraded();
                FileUtility.deleteContents(file);
                return 0;
            }
            FileUtility.delete(file);
            return 0;
        } catch (IOException unused) {
            return 1;
        }
    }
}
