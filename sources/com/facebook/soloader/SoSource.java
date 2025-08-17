package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public abstract class SoSource {
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
    @Deprecated
    public static final int LOAD_FLAG_ALLOW_SOURCE_CHANGE = 2;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 4;
    public static final int LOAD_RESULT_CORRUPTED_LIB_FILE = 3;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;
    public static final int PREPARE_FLAG_FORCE_REFRESH = 2;

    public void addToLdLibraryPath(Collection<String> collection) {
    }

    public String[] getLibraryDependencies(String str) throws IOException {
        return null;
    }

    public String getLibraryPath(String str) throws IOException {
        return null;
    }

    /* access modifiers changed from: protected */
    public File getSoFileByName(String str) throws IOException {
        return null;
    }

    public String[] getSoSourceAbis() {
        return SysUtil.getSupportedAbis();
    }

    public abstract int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException;

    /* access modifiers changed from: protected */
    public void prepare(int i2) throws IOException {
    }

    public String toString() {
        return getClass().getName();
    }

    public abstract File unpackLibrary(String str) throws IOException;
}
