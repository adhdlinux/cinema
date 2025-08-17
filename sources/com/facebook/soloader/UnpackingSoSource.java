package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    private String[] mAbis;
    protected final Context mContext;
    protected String mCorruptedLib;
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i2 = 0; i2 < readInt; i2++) {
                        dsoArr[i2] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i2 = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i2 < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i2].name);
                    dataOutput.writeUTF(this.dsos[i2].hash);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    protected interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput dataOutput, byte[] bArr) throws IOException;
    }

    protected static abstract class InputDsoIterator implements Closeable {
        protected InputDsoIterator() {
        }

        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        public InputDsoStream(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public int available() throws IOException {
            return this.content.available();
        }

        public void close() throws IOException {
            this.content.close();
        }

        public Dso getDso() {
            return this.dso;
        }

        public String getFileName() {
            return this.dso.name;
        }

        public InputStream getStream() {
            return this.content;
        }

        public void write(DataOutput dataOutput, byte[] bArr) throws IOException {
            SysUtil.copyBytes(dataOutput, this.content, Integer.MAX_VALUE, bArr);
        }
    }

    protected static abstract class Unpacker implements Closeable {
        protected Unpacker() {
        }

        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(INSTANCE_LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z2 = false;
                    int i2 = 0;
                    while (!z2 && i2 < dsoArr.length) {
                        if (dsoArr[i2].name.equals(getSoNameFromFileName(str))) {
                            z2 = true;
                        }
                        i2++;
                    }
                    if (!z2) {
                        File file = new File(this.soDirectory, str);
                        Log.v(TAG, "deleting unaccounted-for file " + file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        boolean writable;
        Log.i(TAG, "extracting DSO " + inputDso.getDso().name);
        try {
            if (this.soDirectory.setWritable(true)) {
                extractDsoImpl(inputDso, bArr);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        }
    }

    private void extractDsoImpl(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.soDirectory, inputDso.getFileName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (file.exists() && !file.setWritable(true)) {
                Log.w(TAG, "error adding write permission to: " + file);
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e2) {
                Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e2);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            randomAccessFile2 = randomAccessFile;
            int available = inputDso.available();
            if (available > 1) {
                SysUtil.fallocateIfSupported(randomAccessFile2.getFD(), (long) available);
            }
            inputDso.write(randomAccessFile2, bArr);
            randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
            if (file.setExecutable(true, false)) {
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
                return;
            }
            throw new IOException("cannot make file executable: " + file);
        } catch (IOException e3) {
            SysUtil.dumbDeleteRecursive(file);
            throw e3;
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w(TAG, "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043 A[Catch:{ all -> 0x00aa, all -> 0x00b1, all -> 0x0036, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a A[Catch:{ all -> 0x00aa, all -> 0x00b1, all -> 0x0036, all -> 0x00da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void regenerate(byte r10, com.facebook.soloader.UnpackingSoSource.DsoManifest r11, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.soDirectory
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L_0x003f
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0040
        L_0x0036:
            r10 = move-exception
            goto L_0x00d6
        L_0x0039:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch:{ all -> 0x0036 }
        L_0x003f:
            r10 = 0
        L_0x0040:
            r3 = 0
            if (r10 != 0) goto L_0x004a
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x0036 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r4 = new com.facebook.soloader.UnpackingSoSource.Dso[r3]     // Catch:{ all -> 0x0036 }
            r10.<init>(r4)     // Catch:{ all -> 0x0036 }
        L_0x004a:
            com.facebook.soloader.UnpackingSoSource$Dso[] r11 = r11.dsos     // Catch:{ all -> 0x0036 }
            r9.deleteUnmentionedFiles(r11)     // Catch:{ all -> 0x0036 }
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0036 }
        L_0x0054:
            boolean r4 = r12.hasNext()     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x00b6
            com.facebook.soloader.UnpackingSoSource$InputDso r4 = r12.next()     // Catch:{ all -> 0x0036 }
            r5 = 1
            r6 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x008f
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00aa }
            int r7 = r7.length     // Catch:{ all -> 0x00aa }
            if (r6 >= r7) goto L_0x008f
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r4.getDso()     // Catch:{ all -> 0x00aa }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x00aa }
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r10.dsos     // Catch:{ all -> 0x00aa }
            r8 = r8[r6]     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x00aa }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x008c
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00aa }
            r7 = r7[r6]     // Catch:{ all -> 0x00aa }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x00aa }
            com.facebook.soloader.UnpackingSoSource$Dso r8 = r4.getDso()     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r8.hash     // Catch:{ all -> 0x00aa }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x008c
            r5 = 0
        L_0x008c:
            int r6 = r6 + 1
            goto L_0x0060
        L_0x008f:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00aa }
            java.io.File r7 = r9.soDirectory     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r4.getFileName()     // Catch:{ all -> 0x00aa }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00aa }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x00aa }
            if (r6 != 0) goto L_0x00a1
            r5 = 1
        L_0x00a1:
            if (r5 == 0) goto L_0x00a6
            r9.extractDso(r4, r11)     // Catch:{ all -> 0x00aa }
        L_0x00a6:
            r4.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0054
        L_0x00aa:
            r10 = move-exception
            if (r4 == 0) goto L_0x00b5
            r4.close()     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r11 = move-exception
            r10.addSuppressed(r11)     // Catch:{ all -> 0x0036 }
        L_0x00b5:
            throw r10     // Catch:{ all -> 0x0036 }
        L_0x00b6:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        L_0x00d6:
            r2.close()     // Catch:{ all -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x00de:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* access modifiers changed from: private */
    public static void writeState(File file, byte b2) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
            return;
        } catch (SyncFailedException e2) {
            Log.w(TAG, "state file sync failed", e2);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker((byte) 1);
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i2 = 0; i2 < dsoArr.length; i2++) {
                obtain.writeString(dsoArr[i2].name);
                obtain.writeString(dsoArr[i2].hash);
            }
            makeUnpacker.close();
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
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
    public FileLocker getOrCreateLock(File file, boolean z2) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, file, z2);
    }

    /* access modifiers changed from: protected */
    public String getSoNameFromFileName(String str) {
        return str;
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        if (strArr == null) {
            return super.getSoSourceAbis();
        }
        return strArr;
    }

    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i2, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker(byte b2) throws IOException;

    /* access modifiers changed from: protected */
    public void prepare(int i2) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker orCreateLock = getOrCreateLock(new File(this.soDirectory, LOCK_FILE_NAME), true);
        if (this.mInstanceLock == null) {
            this.mInstanceLock = getOrCreateLock(new File(this.soDirectory, INSTANCE_LOCK_FILE_NAME), false);
        }
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (refreshLocked(orCreateLock, i2, getDepsBlock())) {
                orCreateLock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
            if (orCreateLock == null) {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        } finally {
            if (orCreateLock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                orCreateLock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean refreshLocked(com.facebook.soloader.FileLocker r12, int r13, byte[] r14) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "fb-UnpackingSoSource"
            java.io.File r6 = new java.io.File
            java.io.File r1 = r11.soDirectory
            java.lang.String r2 = "dso_state"
            r6.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r6, r2)
            r8 = 1
            r3 = 0
            byte r4 = r1.readByte()     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            if (r4 == r8) goto L_0x0041
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            r4.<init>()     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            java.lang.String r5 = "dso store "
            r4.append(r5)     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            java.io.File r5 = r11.soDirectory     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            r4.append(r5)     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            java.lang.String r5 = " regeneration interrupted: wiping clean"
            r4.append(r5)     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            java.lang.String r4 = r4.toString()     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            android.util.Log.v(r0, r4)     // Catch:{ EOFException -> 0x0040, all -> 0x0036 }
            goto L_0x0040
        L_0x0036:
            r12 = move-exception
            r1.close()     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r13 = move-exception
            r12.addSuppressed(r13)
        L_0x003f:
            throw r12
        L_0x0040:
            r4 = 0
        L_0x0041:
            r1.close()
            java.io.File r5 = new java.io.File
            java.io.File r1 = r11.soDirectory
            java.lang.String r7 = "dso_deps"
            r5.<init>(r1, r7)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            r1.<init>(r5, r2)
            long r9 = r1.length()     // Catch:{ all -> 0x00eb }
            int r2 = (int) r9     // Catch:{ all -> 0x00eb }
            byte[] r7 = new byte[r2]     // Catch:{ all -> 0x00eb }
            int r9 = r1.read(r7)     // Catch:{ all -> 0x00eb }
            if (r9 == r2) goto L_0x0065
            java.lang.String r2 = "short read of so store deps file: marking unclean"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00eb }
            r4 = 0
        L_0x0065:
            boolean r2 = r11.depsChanged(r7, r14)     // Catch:{ all -> 0x00eb }
            if (r2 == 0) goto L_0x0071
            java.lang.String r2 = "deps mismatch on deps store: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00eb }
            r4 = 0
        L_0x0071:
            if (r4 == 0) goto L_0x007a
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r0 = 0
            goto L_0x009a
        L_0x007a:
            java.lang.String r2 = "so store dirty: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00eb }
            writeState(r6, r3)     // Catch:{ all -> 0x00eb }
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r11.makeUnpacker(r4)     // Catch:{ all -> 0x00eb }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r0.getDsoManifest()     // Catch:{ all -> 0x00df }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r7 = r0.openDsoIterator()     // Catch:{ all -> 0x00df }
            r11.regenerate(r4, r2, r7)     // Catch:{ all -> 0x00d3 }
            if (r7 == 0) goto L_0x0096
            r7.close()     // Catch:{ all -> 0x00df }
        L_0x0096:
            r0.close()     // Catch:{ all -> 0x00eb }
            r0 = r2
        L_0x009a:
            r1.close()
            if (r0 != 0) goto L_0x00a0
            return r3
        L_0x00a0:
            com.facebook.soloader.UnpackingSoSource$1 r9 = new com.facebook.soloader.UnpackingSoSource$1
            r1 = r9
            r2 = r11
            r3 = r5
            r4 = r14
            r5 = r0
            r7 = r12
            r1.<init>(r3, r4, r5, r6, r7)
            r12 = r13 & 1
            if (r12 == 0) goto L_0x00cf
            java.lang.Thread r12 = new java.lang.Thread
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "SoSync:"
            r13.append(r14)
            java.io.File r14 = r11.soDirectory
            java.lang.String r14 = r14.getName()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r9, r13)
            r12.start()
            goto L_0x00d2
        L_0x00cf:
            r9.run()
        L_0x00d2:
            return r8
        L_0x00d3:
            r12 = move-exception
            if (r7 == 0) goto L_0x00de
            r7.close()     // Catch:{ all -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x00df }
        L_0x00de:
            throw r12     // Catch:{ all -> 0x00df }
        L_0x00df:
            r12 = move-exception
            if (r0 == 0) goto L_0x00ea
            r0.close()     // Catch:{ all -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x00eb }
        L_0x00ea:
            throw r12     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r12 = move-exception
            r1.close()     // Catch:{ all -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r13 = move-exception
            r12.addSuppressed(r13)
        L_0x00f4:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }
}
