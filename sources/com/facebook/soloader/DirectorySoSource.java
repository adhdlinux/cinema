package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final List<String> denyList;
    protected final int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i2) {
        this(file, i2, new String[0]);
    }

    private void loadDependencies(String str, ElfByteChannel elfByteChannel, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(str, elfByteChannel);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str2, i2 | 1, threadPolicy);
            }
        }
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    /* access modifiers changed from: protected */
    public ElfByteChannel getChannel(File file) throws IOException {
        return new ElfFileChannel(file);
    }

    /* access modifiers changed from: protected */
    public String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        boolean z2 = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z2) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            String[] dependencies = NativeDeps.getDependencies(str, elfByteChannel);
            if (z2) {
                Api18TraceUtils.endSection();
            }
            return dependencies;
        } catch (Throwable th) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    public String[] getLibraryDependencies(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        ElfByteChannel channel = getChannel(soFileByName);
        try {
            String[] dependencies = getDependencies(str, channel);
            if (channel != null) {
                channel.close();
            }
            return dependencies;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    /* access modifiers changed from: protected */
    public File getSoFileByName(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i2, this.soDirectory, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public int loadLibraryFrom(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader != null) {
            boolean z2 = false;
            if (this.denyList.contains(str)) {
                Log.d("SoLoader", str + " is on the denyList, skip loading from " + file.getCanonicalPath());
                return 0;
            }
            File soFileByName = getSoFileByName(str);
            if (soFileByName == null) {
                Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
                return 0;
            }
            Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
            if ((i2 & 1) == 0 || (this.flags & 2) == 0) {
                if ((this.flags & 1) != 0) {
                    z2 = true;
                }
                boolean equals = soFileByName.getName().equals(str);
                ElfByteChannel elfByteChannel = null;
                if (z2 || !equals) {
                    try {
                        elfByteChannel = getChannel(soFileByName);
                    } catch (UnsatisfiedLinkError e2) {
                        if (e2.getMessage().contains("bad ELF magic")) {
                            Log.d("SoLoader", "Corrupted lib file detected");
                            if (elfByteChannel == null) {
                                return 3;
                            }
                            elfByteChannel.close();
                            return 3;
                        }
                        throw e2;
                    } catch (Throwable th) {
                        if (elfByteChannel != null) {
                            elfByteChannel.close();
                        }
                        throw th;
                    }
                }
                if (z2) {
                    loadDependencies(str, elfByteChannel, i2, threadPolicy);
                } else {
                    Log.d("SoLoader", "Not resolving dependencies for " + str);
                }
                if (equals) {
                    SoLoader.sSoFileLoader.load(soFileByName.getAbsolutePath(), i2);
                } else {
                    SoLoader.sSoFileLoader.loadBytes(soFileByName.getAbsolutePath(), elfByteChannel, i2);
                }
                if (elfByteChannel != null) {
                    elfByteChannel.close();
                }
                return 1;
            }
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.flags + ']';
    }

    public File unpackLibrary(String str) throws IOException {
        return getSoFileByName(str);
    }

    public DirectorySoSource(File file, int i2, String[] strArr) {
        this.soDirectory = file;
        this.flags = i2;
        this.denyList = Arrays.asList(strArr);
    }
}
