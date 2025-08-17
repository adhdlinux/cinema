package com.facebook.soloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.facebook.soloader.MinElf;
import java.io.DataOutput;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class SysUtil {
    private static final long APK_DEP_BLOCK_METADATA_LENGTH = 20;
    private static final byte APK_SIGNATURE_VERSION = 1;
    private static final String TAG = "SysUtil";

    @DoNotOptimize
    @TargetApi(21)
    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j2) throws IOException {
            int i2;
            try {
                Os.posix_fallocate(fileDescriptor, 0, j2);
            } catch (ErrnoException e2) {
                if (e2.errno != OsConstants.EOPNOTSUPP && (i2 = e2.errno) != OsConstants.ENOSYS && i2 != OsConstants.EINVAL) {
                    throw new IOException(e2.toString(), e2);
                }
            }
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            try {
                if (is64Bit()) {
                    treeSet.add(MinElf.ISA.AARCH64.toString());
                    treeSet.add(MinElf.ISA.X86_64.toString());
                } else {
                    treeSet.add(MinElf.ISA.ARM.toString());
                    treeSet.add(MinElf.ISA.X86.toString());
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (ErrnoException e2) {
                Log.e(SysUtil.TAG, String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[]{Arrays.toString(strArr), Integer.valueOf(e2.errno), e2.getMessage()}));
                return Build.SUPPORTED_ABIS;
            }
        }

        @DoNotOptimize
        public static boolean is64Bit() throws ErrnoException {
            return Os.readlink("/proc/self/exe").contains("64");
        }
    }

    @DoNotOptimize
    @TargetApi(23)
    private static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            if (is64Bit()) {
                treeSet.add(MinElf.ISA.AARCH64.toString());
                treeSet.add(MinElf.ISA.X86_64.toString());
            } else {
                treeSet.add(MinElf.ISA.ARM.toString());
                treeSet.add(MinElf.ISA.X86.toString());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @DoNotOptimize
        public static boolean is64Bit() {
            return Process.is64Bit();
        }

        private static boolean isApkUncompressedDso(Context context) throws IOException {
            ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (true) {
                    boolean z2 = false;
                    if (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry != null && zipEntry.getName().endsWith(".so") && zipEntry.getName().contains("/lib")) {
                            if (zipEntry.getMethod() == 0) {
                                z2 = true;
                            }
                            zipFile.close();
                            return z2;
                        }
                    } else {
                        zipFile.close();
                        return false;
                    }
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public static boolean isDisabledExtractNativeLibs(Context context) {
            return context != null && (context.getApplicationInfo().flags & 268435456) == 0;
        }

        public static boolean isSupportedDirectLoad(Context context, int i2) throws IOException {
            if (i2 == 2) {
                return isApkUncompressedDso(context);
            }
            return isDisabledExtractNativeLibs(context);
        }
    }

    static int copyBytes(DataOutput dataOutput, InputStream inputStream, int i2, byte[] bArr) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i2 - i3));
            if (read == -1) {
                break;
            }
            dataOutput.write(bArr, 0, read);
            i3 += read;
        }
        return i3;
    }

    public static void deleteOrThrow(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e(TAG, "Enable write permission failed: " + parentFile);
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File dumbDeleteRecursive : listFiles) {
                    dumbDeleteRecursive(dumbDeleteRecursive);
                }
            } else {
                return;
            }
        }
        deleteOrThrow(file);
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j2) throws IOException {
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j2);
    }

    public static int findAbiScore(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            if (str2 != null && str.equals(str2)) {
                return i2;
            }
        }
        return -1;
    }

    public static void fsyncRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File fsyncRecursive : listFiles) {
                    fsyncRecursive(fsyncRecursive);
                }
                return;
            }
            throw new IOException("cannot list directory " + file);
        } else if (!file.getPath().endsWith("_lock")) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public static long getApkDepBlockLength(File file) throws IOException {
        return getParcelPadSize((long) ((file.getCanonicalFile().getPath().length() + 1) * 2)) + 20;
    }

    public static int getAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static String getBaseName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static FileLocker getOrCreateLockOnDir(File file, File file2, boolean z2) throws IOException {
        boolean z3;
        if (!z2) {
            return FileLocker.tryLock(file2);
        }
        try {
            return FileLocker.lock(file2);
        } catch (FileNotFoundException e2) {
            z3 = true;
            if (!file.setWritable(true)) {
                throw e2;
            } else if (z2) {
                FileLocker lock = FileLocker.lock(file2);
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                return lock;
            } else {
                FileLocker tryLock = FileLocker.tryLock(file2);
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                return tryLock;
            }
        } catch (Throwable th) {
            th = th;
        }
        if (z3 && !file.setWritable(false)) {
            Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
        }
        throw th;
    }

    private static long getParcelPadSize(long j2) {
        return j2 + ((4 - (j2 % 4)) % 4);
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 23) {
            return MarshmallowSysdeps.getSupportedAbis();
        }
        return LollipopSysdeps.getSupportedAbis();
    }

    @SuppressLint({"CatchGeneralException"})
    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return MarshmallowSysdeps.is64Bit();
        }
        try {
            return LollipopSysdeps.is64Bit();
        } catch (Exception e2) {
            Log.e(TAG, String.format("Could not read /proc/self/exe. Err msg: %s", new Object[]{e2.getMessage()}));
            return false;
        }
    }

    public static boolean isDisabledExtractNativeLibs(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return MarshmallowSysdeps.isDisabledExtractNativeLibs(context);
        }
        return false;
    }

    public static boolean isSupportedDirectLoad(Context context, int i2) throws IOException {
        if (Build.VERSION.SDK_INT >= 23) {
            return MarshmallowSysdeps.isSupportedDirectLoad(context, i2);
        }
        return false;
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte(APK_SIGNATURE_VERSION);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(getAppVersionCode(context));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static void mkdirOrThrow(File file) throws IOException {
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
    }
}
