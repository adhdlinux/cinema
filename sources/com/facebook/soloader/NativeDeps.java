package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NativeDeps {
    private static final int DEFAULT_LIBS_CAPACITY = 512;
    private static final int INITIAL_HASH = 5381;
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_PREFIX_SUFFIX_LEN = (3 + 3);
    private static final int LIB_SUFFIX_LEN = 3;
    private static byte[] sEncodedDeps = null;
    private static boolean sInitialized = false;
    private static Map<Integer, List<Integer>> sPrecomputedDeps;
    private static List<Integer> sPrecomputedLibs;

    public static String[] getDependencies(String str, File file) throws IOException {
        String[] tryGetDepsFromPrecomputedDeps;
        if (!sInitialized || (tryGetDepsFromPrecomputedDeps = tryGetDepsFromPrecomputedDeps(str)) == null) {
            return MinElf.extract_DT_NEEDED(file);
        }
        return tryGetDepsFromPrecomputedDeps;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] getDepsForLibAtOffset(int r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r6 = r6 + r7
            int r7 = LIB_PREFIX_SUFFIX_LEN
            int r6 = r6 - r7
            r7 = 0
            r1 = 0
            r2 = 0
        L_0x000c:
            byte[] r3 = sEncodedDeps
            int r4 = r3.length
            r5 = 0
            if (r6 >= r4) goto L_0x003e
            byte r3 = r3[r6]
            r4 = 10
            if (r3 == r4) goto L_0x003e
            r4 = 32
            if (r3 != r4) goto L_0x002b
            if (r2 == 0) goto L_0x003a
            java.lang.String r1 = getLibString(r1)
            if (r1 != 0) goto L_0x0025
            return r5
        L_0x0025:
            r0.add(r1)
            r1 = 0
            r2 = 0
            goto L_0x003a
        L_0x002b:
            r2 = 48
            if (r3 < r2) goto L_0x003d
            r2 = 57
            if (r3 <= r2) goto L_0x0034
            goto L_0x003d
        L_0x0034:
            int r1 = r1 * 10
            int r3 = r3 + -48
            int r1 = r1 + r3
            r2 = 1
        L_0x003a:
            int r6 = r6 + 1
            goto L_0x000c
        L_0x003d:
            return r5
        L_0x003e:
            if (r2 == 0) goto L_0x004a
            java.lang.String r6 = getLibString(r1)
            if (r6 != 0) goto L_0x0047
            return r5
        L_0x0047:
            r0.add(r6)
        L_0x004a:
            int r6 = r0.size()
            if (r6 != 0) goto L_0x0051
            return r5
        L_0x0051:
            int r6 = r0.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r0.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.NativeDeps.getDepsForLibAtOffset(int, int):java.lang.String[]");
    }

    private static String getLibString(int i2) {
        if (i2 >= sPrecomputedLibs.size()) {
            return null;
        }
        int intValue = sPrecomputedLibs.get(i2).intValue();
        int i3 = intValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i3 >= bArr.length || bArr[i3] <= 32) {
                int i4 = (i3 - intValue) + LIB_PREFIX_SUFFIX_LEN;
                char[] cArr = new char[i4];
                cArr[0] = 'l';
                cArr[1] = 'i';
                cArr[2] = 'b';
            } else {
                i3++;
            }
        }
        int i42 = (i3 - intValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr2 = new char[i42];
        cArr2[0] = 'l';
        cArr2[1] = 'i';
        cArr2[2] = 'b';
        for (int i5 = 0; i5 < i42 - LIB_PREFIX_SUFFIX_LEN; i5++) {
            cArr2[LIB_PREFIX_LEN + i5] = (char) sEncodedDeps[intValue + i5];
        }
        cArr2[i42 - 3] = '.';
        cArr2[i42 - 2] = 's';
        cArr2[i42 - 1] = 'o';
        return new String(cArr2);
    }

    private static int getOffsetForLib(String str) {
        List<Integer> list = sPrecomputedDeps.get(Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (libIsAtOffset(str, intValue2)) {
                return intValue2;
            }
        }
        return -1;
    }

    private static int hashLib(String str) {
        int i2 = INITIAL_HASH;
        for (int i3 = LIB_PREFIX_LEN; i3 < str.length() - LIB_SUFFIX_LEN; i3++) {
            i2 = str.codePointAt(i3) + (i2 << 5) + i2;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void indexDepsBytes(byte[] r8, int r9) {
        /*
            r0 = 1
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 0
        L_0x0005:
            if (r2 == 0) goto L_0x0023
            r3 = 5381(0x1505, float:7.54E-42)
            r4 = r9
        L_0x000a:
            byte r5 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r6 = 32
            if (r5 <= r6) goto L_0x0018
            int r6 = r3 << 5
            int r6 = r6 + r3
            int r3 = r6 + r5
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0018:
            indexLib(r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0021 }
            if (r5 == r6) goto L_0x001f
            r2 = 1
            goto L_0x0030
        L_0x001f:
            r2 = 0
            goto L_0x0030
        L_0x0021:
            goto L_0x0037
        L_0x0023:
            byte r5 = r8[r9]     // Catch:{ IndexOutOfBoundsException -> 0x0035 }
            r6 = 10
            if (r5 == r6) goto L_0x002c
            int r9 = r9 + 1
            goto L_0x0023
        L_0x002c:
            r2 = 1
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x0030:
            int r4 = r4 + r0
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x0005
        L_0x0035:
            r9 = r4
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            indexLib(r3, r9)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.NativeDeps.indexDepsBytes(byte[], int):void");
    }

    private static void indexLib(int i2, int i3) {
        sPrecomputedLibs.add(Integer.valueOf(i3));
        List list = sPrecomputedDeps.get(Integer.valueOf(i2));
        if (list == null) {
            list = new ArrayList();
            sPrecomputedDeps.put(Integer.valueOf(i2), list);
        }
        list.add(Integer.valueOf(i3));
    }

    private static boolean libIsAtOffset(String str, int i2) {
        int i3;
        int i4 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i3 = LIB_SUFFIX_LEN;
            if (i4 < length - i3 && i2 < sEncodedDeps.length && (str.codePointAt(i4) & 255) == sEncodedDeps[i2]) {
                i4++;
                i2++;
            }
        }
        if (i4 == str.length() - i3) {
            return true;
        }
        return false;
    }

    private static boolean readDepsFromFile(byte[] bArr, String str) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            byte[] bArr2 = new byte[fileInputStream.available()];
            sEncodedDeps = bArr2;
            fileInputStream.read(bArr2);
            int verifyBytesAndGetOffset = verifyBytesAndGetOffset(bArr, sEncodedDeps);
            if (verifyBytesAndGetOffset == -1) {
                sEncodedDeps = null;
                fileInputStream.close();
                return false;
            }
            sPrecomputedDeps = new HashMap(512);
            sPrecomputedLibs = new ArrayList(512);
            indexDepsBytes(sEncodedDeps, verifyBytesAndGetOffset);
            fileInputStream.close();
            sInitialized = true;
            return true;
        } catch (IOException e2) {
            sEncodedDeps = null;
            throw e2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static String[] tryGetDepsFromPrecomputedDeps(String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }

    public static boolean useDepsFile(byte[] bArr, String str) throws IOException {
        if (!sInitialized) {
            synchronized (NativeDeps.class) {
                if (!sInitialized) {
                    boolean readDepsFromFile = readDepsFromFile(bArr, str);
                    return readDepsFromFile;
                }
            }
        }
        throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
    }

    private static int verifyBytesAndGetOffset(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2.length < bArr.length + 4) {
            return -1;
        }
        if (bArr2.length != bArr.length + 4 + ByteBuffer.wrap(bArr2, bArr.length, 4).getInt()) {
            return -1;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return -1;
            }
        }
        return bArr.length + 4;
    }

    public static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        String[] tryGetDepsFromPrecomputedDeps;
        if (sPrecomputedDeps == null || (tryGetDepsFromPrecomputedDeps = tryGetDepsFromPrecomputedDeps(str)) == null) {
            return MinElf.extract_DT_NEEDED(elfByteChannel);
        }
        return tryGetDepsFromPrecomputedDeps;
    }
}
