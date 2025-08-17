package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class ApplicationSoSource extends SoSource {
    private Context applicationContext;
    private int flags;
    private DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i2) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        if (applicationContext2 == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
            this.applicationContext = context;
        }
        this.flags = i2;
        this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), i2);
    }

    public static File getNativeLibDirFromContext(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        this.soSource.addToLdLibraryPath(collection);
    }

    public boolean checkAndMaybeUpdate() throws IOException {
        File file = this.soSource.soDirectory;
        Context updatedContext = getUpdatedContext();
        File nativeLibDirFromContext = getNativeLibDirFromContext(updatedContext);
        if (file.equals(nativeLibDirFromContext)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + nativeLibDirFromContext);
        int i2 = this.flags | 1;
        this.flags = i2;
        DirectorySoSource directorySoSource = new DirectorySoSource(nativeLibDirFromContext, i2);
        this.soSource = directorySoSource;
        directorySoSource.prepare(this.flags);
        this.applicationContext = updatedContext;
        return true;
    }

    public String[] getLibraryDependencies(String str) throws IOException {
        return this.soSource.getLibraryDependencies(str);
    }

    public String getLibraryPath(String str) throws IOException {
        return this.soSource.getLibraryPath(str);
    }

    public File getSoFileByName(String str) throws IOException {
        return this.soSource.getSoFileByName(str);
    }

    public Context getUpdatedContext() {
        try {
            Context context = this.applicationContext;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.soSource.loadLibrary(str, i2, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public void prepare(int i2) throws IOException {
        this.soSource.prepare(i2);
    }

    public String toString() {
        return this.soSource.toString();
    }

    public File unpackLibrary(String str) throws IOException {
        return this.soSource.unpackLibrary(str);
    }
}
