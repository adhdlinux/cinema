package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.AtomicFile;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import d.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class CachedContentIndex {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, CachedContent> f4989a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<String> f4990b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f4991c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f4992d;

    /* renamed from: e  reason: collision with root package name */
    private Storage f4993e;

    /* renamed from: f  reason: collision with root package name */
    private Storage f4994f;

    private static final class DatabaseStorage implements Storage {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f4995e = {"id", "key", "metadata"};

        /* renamed from: a  reason: collision with root package name */
        private final DatabaseProvider f4996a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<CachedContent> f4997b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private String f4998c;

        /* renamed from: d  reason: collision with root package name */
        private String f4999d;

        public DatabaseStorage(DatabaseProvider databaseProvider) {
            this.f4996a = databaseProvider;
        }

        private void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.r(cachedContent.c(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f4982a));
            contentValues.put("key", cachedContent.f4983b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.f(this.f4999d), (String) null, contentValues);
        }

        private static void j(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            SQLiteDatabase writableDatabase;
            try {
                String n2 = n(str);
                writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.c(writableDatabase, 1, str);
                l(writableDatabase, n2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase, int i2) {
            sQLiteDatabase.delete((String) Assertions.f(this.f4999d), "id = ?", new String[]{Integer.toString(i2)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f4996a.getReadableDatabase().query((String) Assertions.f(this.f4999d), f4995e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.d(sQLiteDatabase, 1, (String) Assertions.f(this.f4998c), 1);
            l(sQLiteDatabase, (String) Assertions.f(this.f4999d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f4999d + " " + "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        public void a() throws DatabaseIOException {
            j(this.f4996a, (String) Assertions.f(this.f4998c));
        }

        public boolean b() throws DatabaseIOException {
            try {
                if (VersionTable.b(this.f4996a.getReadableDatabase(), 1, (String) Assertions.f(this.f4998c)) != -1) {
                    return true;
                }
                return false;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public void c(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.f4997b.size() != 0) {
                try {
                    writableDatabase = this.f4996a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i2 = 0; i2 < this.f4997b.size(); i2++) {
                        CachedContent valueAt = this.f4997b.valueAt(i2);
                        if (valueAt == null) {
                            k(writableDatabase, this.f4997b.keyAt(i2));
                        } else {
                            i(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f4997b.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }

        public void d(long j2) {
            String hexString = Long.toHexString(j2);
            this.f4998c = hexString;
            this.f4999d = n(hexString);
        }

        public void e(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.f4996a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                o(writableDatabase);
                for (CachedContent i2 : hashMap.values()) {
                    i(writableDatabase, i2);
                }
                writableDatabase.setTransactionSuccessful();
                this.f4997b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        public void f(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException {
            boolean z2;
            Cursor m2;
            SQLiteDatabase writableDatabase;
            if (this.f4997b.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            try {
                if (VersionTable.b(this.f4996a.getReadableDatabase(), 1, (String) Assertions.f(this.f4998c)) != 1) {
                    writableDatabase = this.f4996a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    o(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                m2 = m();
                while (m2.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(m2.getInt(0), (String) Assertions.f(m2.getString(1)), CachedContentIndex.o(new DataInputStream(new ByteArrayInputStream(m2.getBlob(2)))));
                    hashMap.put(cachedContent.f4983b, cachedContent);
                    sparseArray.put(cachedContent.f4982a, cachedContent.f4983b);
                }
                m2.close();
                return;
            } catch (SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
            throw th;
        }

        public void g(CachedContent cachedContent, boolean z2) {
            if (z2) {
                this.f4997b.delete(cachedContent.f4982a);
            } else {
                this.f4997b.put(cachedContent.f4982a, (Object) null);
            }
        }

        public void h(CachedContent cachedContent) {
            this.f4997b.put(cachedContent.f4982a, cachedContent);
        }
    }

    private static class LegacyStorage implements Storage {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5000a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f5001b;

        /* renamed from: c  reason: collision with root package name */
        private final SecretKeySpec f5002c;

        /* renamed from: d  reason: collision with root package name */
        private final SecureRandom f5003d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicFile f5004e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5005f;

        /* renamed from: g  reason: collision with root package name */
        private ReusableBufferedOutputStream f5006g;

        public LegacyStorage(File file, byte[] bArr, boolean z2) {
            boolean z3;
            SecretKeySpec secretKeySpec;
            Cipher cipher;
            boolean z4 = false;
            if (bArr != null || !z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.h(z3);
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.a(bArr.length == 16 ? true : z4);
                try {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                Assertions.a(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.f5000a = z2;
            this.f5001b = cipher;
            this.f5002c = secretKeySpec;
            this.f5003d = z2 ? new SecureRandom() : secureRandom;
            this.f5004e = new AtomicFile(file);
        }

        private int i(CachedContent cachedContent, int i2) {
            int hashCode = (cachedContent.f4982a * 31) + cachedContent.f4983b.hashCode();
            if (i2 >= 2) {
                return (hashCode * 31) + cachedContent.c().hashCode();
            }
            long a2 = c.a(cachedContent.c());
            return (hashCode * 31) + ((int) (a2 ^ (a2 >>> 32)));
        }

        private CachedContent j(int i2, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i2 < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.g(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.f5009c.e(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.o(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean k(java.util.HashMap<java.lang.String, androidx.media3.datasource.cache.CachedContent> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                androidx.media3.common.util.AtomicFile r0 = r10.f5004e
                boolean r0 = r0.c()
                r1 = 1
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 0
                r2 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                androidx.media3.common.util.AtomicFile r4 = r10.f5004e     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                java.io.InputStream r4 = r4.d()     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                int r2 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r2 < 0) goto L_0x00a7
                r5 = 2
                if (r2 <= r5) goto L_0x0027
                goto L_0x00a7
            L_0x0027:
                int r6 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6 = r6 & r1
                if (r6 == 0) goto L_0x0066
                javax.crypto.Cipher r6 = r10.f5001b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r6 != 0) goto L_0x0036
                androidx.media3.common.util.Util.m(r4)
                return r0
            L_0x0036:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r4.readFully(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r6 = r10.f5001b     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                javax.crypto.spec.SecretKeySpec r8 = r10.f5002c     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.lang.Object r8 = androidx.media3.common.util.Util.i(r8)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.security.Key r8 = (java.security.Key) r8     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r7 = r10.f5001b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.<init>(r3, r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r5.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r4 = r5
                goto L_0x006c
            L_0x005d:
                r11 = move-exception
                goto L_0x0060
            L_0x005f:
                r11 = move-exception
            L_0x0060:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r12.<init>(r11)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                throw r12     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x0066:
                boolean r3 = r10.f5000a     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r3 == 0) goto L_0x006c
                r10.f5005f = r1     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x006c:
                int r3 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r5 = 0
                r6 = 0
            L_0x0072:
                if (r5 >= r3) goto L_0x008c
                androidx.media3.datasource.cache.CachedContent r7 = r10.j(r2, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r8 = r7.f4983b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r11.put(r8, r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r8 = r7.f4982a     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r9 = r7.f4983b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r12.put(r8, r9)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r7 = r10.i(r7, r2)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r6 = r6 + r7
                int r5 = r5 + 1
                goto L_0x0072
            L_0x008c:
                int r11 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r12 = r4.read()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2 = -1
                if (r12 != r2) goto L_0x0099
                r12 = 1
                goto L_0x009a
            L_0x0099:
                r12 = 0
            L_0x009a:
                if (r11 != r6) goto L_0x00a3
                if (r12 != 0) goto L_0x009f
                goto L_0x00a3
            L_0x009f:
                androidx.media3.common.util.Util.m(r4)
                return r1
            L_0x00a3:
                androidx.media3.common.util.Util.m(r4)
                return r0
            L_0x00a7:
                androidx.media3.common.util.Util.m(r4)
                return r0
            L_0x00ab:
                r11 = move-exception
                r2 = r4
                goto L_0x00b2
            L_0x00ae:
                r2 = r4
                goto L_0x00b9
            L_0x00b1:
                r11 = move-exception
            L_0x00b2:
                if (r2 == 0) goto L_0x00b7
                androidx.media3.common.util.Util.m(r2)
            L_0x00b7:
                throw r11
            L_0x00b8:
            L_0x00b9:
                if (r2 == 0) goto L_0x00be
                androidx.media3.common.util.Util.m(r2)
            L_0x00be:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CachedContentIndex.LegacyStorage.k(java.util.HashMap, android.util.SparseArray):boolean");
        }

        private void l(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f4982a);
            dataOutputStream.writeUTF(cachedContent.f4983b);
            CachedContentIndex.r(cachedContent.c(), dataOutputStream);
        }

        private void m(HashMap<String, CachedContent> hashMap) throws IOException {
            int i2;
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream f2 = this.f5004e.f();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.f5006g;
                if (reusableBufferedOutputStream == null) {
                    this.f5006g = new ReusableBufferedOutputStream(f2);
                } else {
                    reusableBufferedOutputStream.a(f2);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.f5006g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i3 = 0;
                    if (this.f5000a) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    dataOutputStream2.writeInt(i2);
                    if (this.f5000a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.i(this.f5003d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        ((Cipher) Util.i(this.f5001b)).init(1, (Key) Util.i(this.f5002c), new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.f5001b));
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        l(next, dataOutputStream2);
                        i3 += i(next, 2);
                    }
                    dataOutputStream2.writeInt(i3);
                    this.f5004e.b(dataOutputStream2);
                    Util.m((Closeable) null);
                } catch (InvalidKeyException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e3) {
                    e = e3;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    Util.m(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.m(dataOutputStream);
                throw th;
            }
        }

        public void a() {
            this.f5004e.a();
        }

        public boolean b() {
            return this.f5004e.c();
        }

        public void c(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.f5005f) {
                e(hashMap);
            }
        }

        public void d(long j2) {
        }

        public void e(HashMap<String, CachedContent> hashMap) throws IOException {
            m(hashMap);
            this.f5005f = false;
        }

        public void f(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.h(!this.f5005f);
            if (!k(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.f5004e.a();
            }
        }

        public void g(CachedContent cachedContent, boolean z2) {
            this.f5005f = true;
        }

        public void h(CachedContent cachedContent) {
            this.f5005f = true;
        }
    }

    private interface Storage {
        void a() throws IOException;

        boolean b() throws IOException;

        void c(HashMap<String, CachedContent> hashMap) throws IOException;

        void d(long j2);

        void e(HashMap<String, CachedContent> hashMap) throws IOException;

        void f(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException;

        void g(CachedContent cachedContent, boolean z2);

        void h(CachedContent cachedContent);
    }

    public CachedContentIndex(DatabaseProvider databaseProvider, File file, byte[] bArr, boolean z2, boolean z3) {
        boolean z4;
        DatabaseStorage databaseStorage;
        if (databaseProvider == null && file == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.h(z4);
        this.f4989a = new HashMap<>();
        this.f4990b = new SparseArray<>();
        this.f4991c = new SparseBooleanArray();
        this.f4992d = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        if (databaseProvider != null) {
            databaseStorage = new DatabaseStorage(databaseProvider);
        } else {
            databaseStorage = null;
        }
        legacyStorage = file != null ? new LegacyStorage(new File(file, "cached_content_index.exi"), bArr, z2) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z3)) {
            this.f4993e = (Storage) Util.i(legacyStorage);
            this.f4994f = databaseStorage;
            return;
        }
        this.f4993e = databaseStorage;
        this.f4994f = legacyStorage;
    }

    private CachedContent c(String str) {
        int j2 = j(this.f4990b);
        CachedContent cachedContent = new CachedContent(j2, str);
        this.f4989a.put(str, cachedContent);
        this.f4990b.put(j2, str);
        this.f4992d.put(j2, true);
        this.f4993e.h(cachedContent);
        return cachedContent;
    }

    static int j(SparseArray<String> sparseArray) {
        int i2;
        int size = sparseArray.size();
        int i3 = 0;
        if (size == 0) {
            i2 = 0;
        } else {
            i2 = sparseArray.keyAt(size - 1) + 1;
        }
        if (i2 >= 0) {
            return i2;
        }
        while (i3 < size && i3 == sparseArray.keyAt(i3)) {
            i3++;
        }
        return i3;
    }

    public static boolean m(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* access modifiers changed from: private */
    public static DefaultContentMetadata o(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = Util.f4719f;
                int i3 = 0;
                while (i3 != readInt2) {
                    int i4 = i3 + min;
                    bArr = Arrays.copyOf(bArr, i4);
                    dataInputStream.readFully(bArr, i3, min);
                    min = Math.min(readInt2 - i4, 10485760);
                    i3 = i4;
                }
                hashMap.put(readUTF, bArr);
                i2++;
            } else {
                throw new IOException("Invalid value size: " + readInt2);
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    /* access modifiers changed from: private */
    public static void r(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> f2 = defaultContentMetadata.f();
        dataOutputStream.writeInt(f2.size());
        for (Map.Entry next : f2) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void d(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent k2 = k(str);
        if (k2.b(contentMetadataMutations)) {
            this.f4993e.h(k2);
        }
    }

    public int e(String str) {
        return k(str).f4982a;
    }

    public CachedContent f(String str) {
        return this.f4989a.get(str);
    }

    public Collection<CachedContent> g() {
        return Collections.unmodifiableCollection(this.f4989a.values());
    }

    public ContentMetadata h(String str) {
        CachedContent f2 = f(str);
        if (f2 != null) {
            return f2.c();
        }
        return DefaultContentMetadata.f5009c;
    }

    public String i(int i2) {
        return this.f4990b.get(i2);
    }

    public CachedContent k(String str) {
        CachedContent cachedContent = this.f4989a.get(str);
        if (cachedContent == null) {
            return c(str);
        }
        return cachedContent;
    }

    public void l(long j2) throws IOException {
        Storage storage;
        this.f4993e.d(j2);
        Storage storage2 = this.f4994f;
        if (storage2 != null) {
            storage2.d(j2);
        }
        if (this.f4993e.b() || (storage = this.f4994f) == null || !storage.b()) {
            this.f4993e.f(this.f4989a, this.f4990b);
        } else {
            this.f4994f.f(this.f4989a, this.f4990b);
            this.f4993e.e(this.f4989a);
        }
        Storage storage3 = this.f4994f;
        if (storage3 != null) {
            storage3.a();
            this.f4994f = null;
        }
    }

    public void n(String str) {
        CachedContent cachedContent = this.f4989a.get(str);
        if (cachedContent != null && cachedContent.f() && cachedContent.h()) {
            this.f4989a.remove(str);
            int i2 = cachedContent.f4982a;
            boolean z2 = this.f4992d.get(i2);
            this.f4993e.g(cachedContent, z2);
            if (z2) {
                this.f4990b.remove(i2);
                this.f4992d.delete(i2);
                return;
            }
            this.f4990b.put(i2, (Object) null);
            this.f4991c.put(i2, true);
        }
    }

    public void p() {
        UnmodifiableIterator<String> h2 = ImmutableSet.m(this.f4989a.keySet()).iterator();
        while (h2.hasNext()) {
            n(h2.next());
        }
    }

    public void q() throws IOException {
        this.f4993e.c(this.f4989a);
        int size = this.f4991c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4990b.remove(this.f4991c.keyAt(i2));
        }
        this.f4991c.clear();
        this.f4992d.clear();
    }
}
