package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import okhttp3.internal.http2.Http2;

final class MultiDexExtractor implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f10747b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10748c;

    /* renamed from: d  reason: collision with root package name */
    private final File f10749d;

    /* renamed from: e  reason: collision with root package name */
    private final RandomAccessFile f10750e;

    /* renamed from: f  reason: collision with root package name */
    private final FileChannel f10751f;

    /* renamed from: g  reason: collision with root package name */
    private final FileLock f10752g;

    private static class ExtractedDex extends File {

        /* renamed from: b  reason: collision with root package name */
        public long f10754b = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f10747b = file;
        this.f10749d = file2;
        this.f10748c = s(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f10750e = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f10751f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f10752g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                f(this.f10751f);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                f(this.f10751f);
                throw e;
            } catch (Error e4) {
                e = e4;
                f(this.f10751f);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            f(this.f10750e);
            throw e5;
        }
    }

    private List<ExtractedDex> A(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f10747b.getName() + ".classes";
        SharedPreferences k2 = k(context);
        int i2 = k2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            ExtractedDex extractedDex = new ExtractedDex(this.f10749d, str3 + i3 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.f10754b = s(extractedDex);
                long j2 = k2.getLong(str2 + "dex.crc." + i3, -1);
                long j3 = k2.getLong(str2 + "dex.time." + i3, -1);
                long lastModified = extractedDex.lastModified();
                if (j3 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = k2;
                    if (j2 == extractedDex.f10754b) {
                        arrayList.add(extractedDex);
                        i3++;
                        k2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + extractedDex.f10754b);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private List<ExtractedDex> B() throws IOException {
        ExtractedDex extractedDex;
        boolean z2;
        String str;
        String str2 = this.f10747b.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f10747b);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i2 = 2;
            while (entry != null) {
                extractedDex = new ExtractedDex(this.f10749d, str2 + i2 + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                int i3 = 0;
                boolean z3 = false;
                while (i3 < 3 && !z3) {
                    int i4 = i3 + 1;
                    i(zipFile, entry, extractedDex, str2);
                    extractedDex.f10754b = s(extractedDex);
                    z2 = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    if (z2) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    int i5 = i4;
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.f10754b);
                    Log.i("MultiDex", sb.toString());
                    if (!z2) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z3 = z2;
                    i3 = i5;
                }
                if (z3) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } catch (IOException e3) {
            Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e3);
            z2 = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            throw th2;
        }
    }

    private static void D(Context context, String str, long j2, long j3, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = k(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + "dex.crc." + i2, next.f10754b);
            edit.putLong(str + "dex.time." + i2, next.lastModified());
            i2++;
        }
        edit.commit();
    }

    private void a() {
        File[] listFiles = this.f10749d.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f10749d.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    private static void f(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    private static void i(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    f(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            f(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static SharedPreferences k(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long q(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long s(File file) throws IOException {
        long c2 = ZipUtil.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean v(Context context, File file, long j2, String str) {
        SharedPreferences k2 = k(context);
        if (k2.getLong(str + "timestamp", -1) == q(file)) {
            if (k2.getLong(str + "crc", -1) != j2) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void close() throws IOException {
        this.f10752g.release();
        this.f10751f.close();
        this.f10750e.close();
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> z(Context context, String str, boolean z2) throws IOException {
        List<ExtractedDex> list;
        List<ExtractedDex> list2;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f10747b.getPath() + ", " + z2 + ", " + str + ")");
        if (this.f10752g.isValid()) {
            if (z2 || v(context, this.f10747b, this.f10748c, str)) {
                if (z2) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list2 = B();
                D(context, str, q(this.f10747b), this.f10748c, list2);
            } else {
                try {
                    list = A(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    list2 = B();
                    D(context, str, q(this.f10747b), this.f10748c, list2);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = list2;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
