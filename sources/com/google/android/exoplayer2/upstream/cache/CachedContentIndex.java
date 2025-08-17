package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
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
import v0.c;

class CachedContentIndex {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, CachedContent> f28604a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<String> f28605b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f28606c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f28607d;

    /* renamed from: e  reason: collision with root package name */
    private Storage f28608e;

    /* renamed from: f  reason: collision with root package name */
    private Storage f28609f;

    private static final class DatabaseStorage implements Storage {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f28610e = {"id", "key", "metadata"};

        /* renamed from: a  reason: collision with root package name */
        private final DatabaseProvider f28611a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<CachedContent> f28612b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private String f28613c;

        /* renamed from: d  reason: collision with root package name */
        private String f28614d;

        public DatabaseStorage(DatabaseProvider databaseProvider) {
            this.f28611a = databaseProvider;
        }

        private void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.t(cachedContent.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f28597a));
            contentValues.put("key", cachedContent.f28598b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.e(this.f28614d), (String) null, contentValues);
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
            sQLiteDatabase.delete((String) Assertions.e(this.f28614d), "id = ?", new String[]{Integer.toString(i2)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f28611a.getReadableDatabase().query((String) Assertions.e(this.f28614d), f28610e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.d(sQLiteDatabase, 1, (String) Assertions.e(this.f28613c), 1);
            l(sQLiteDatabase, (String) Assertions.e(this.f28614d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f28614d + " " + "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        public void a() throws DatabaseIOException {
            j(this.f28611a, (String) Assertions.e(this.f28613c));
        }

        public boolean b() throws DatabaseIOException {
            try {
                if (VersionTable.b(this.f28611a.getReadableDatabase(), 1, (String) Assertions.e(this.f28613c)) != -1) {
                    return true;
                }
                return false;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public void c(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.f28612b.size() != 0) {
                try {
                    writableDatabase = this.f28611a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i2 = 0; i2 < this.f28612b.size(); i2++) {
                        CachedContent valueAt = this.f28612b.valueAt(i2);
                        if (valueAt == null) {
                            k(writableDatabase, this.f28612b.keyAt(i2));
                        } else {
                            i(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f28612b.clear();
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
            this.f28613c = hexString;
            this.f28614d = n(hexString);
        }

        public void e(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.f28611a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                o(writableDatabase);
                for (CachedContent i2 : hashMap.values()) {
                    i(writableDatabase, i2);
                }
                writableDatabase.setTransactionSuccessful();
                this.f28612b.clear();
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
            if (this.f28612b.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            try {
                if (VersionTable.b(this.f28611a.getReadableDatabase(), 1, (String) Assertions.e(this.f28613c)) != 1) {
                    writableDatabase = this.f28611a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    o(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                m2 = m();
                while (m2.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(m2.getInt(0), (String) Assertions.e(m2.getString(1)), CachedContentIndex.q(new DataInputStream(new ByteArrayInputStream(m2.getBlob(2)))));
                    hashMap.put(cachedContent.f28598b, cachedContent);
                    sparseArray.put(cachedContent.f28597a, cachedContent.f28598b);
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
                this.f28612b.delete(cachedContent.f28597a);
            } else {
                this.f28612b.put(cachedContent.f28597a, (Object) null);
            }
        }

        public void h(CachedContent cachedContent) {
            this.f28612b.put(cachedContent.f28597a, cachedContent);
        }
    }

    private static class LegacyStorage implements Storage {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f28615a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f28616b;

        /* renamed from: c  reason: collision with root package name */
        private final SecretKeySpec f28617c;

        /* renamed from: d  reason: collision with root package name */
        private final SecureRandom f28618d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicFile f28619e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f28620f;

        /* renamed from: g  reason: collision with root package name */
        private ReusableBufferedOutputStream f28621g;

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
            Assertions.g(z3);
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.a(bArr.length == 16 ? true : z4);
                try {
                    cipher = CachedContentIndex.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                Assertions.a(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.f28615a = z2;
            this.f28616b = cipher;
            this.f28617c = secretKeySpec;
            this.f28618d = z2 ? new SecureRandom() : secureRandom;
            this.f28619e = new AtomicFile(file);
        }

        private int i(CachedContent cachedContent, int i2) {
            int hashCode = (cachedContent.f28597a * 31) + cachedContent.f28598b.hashCode();
            if (i2 >= 2) {
                return (hashCode * 31) + cachedContent.d().hashCode();
            }
            long a2 = c.a(cachedContent.d());
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
                defaultContentMetadata = DefaultContentMetadata.f28624c.e(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.q(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean k(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                com.google.android.exoplayer2.util.AtomicFile r0 = r10.f28619e
                boolean r0 = r0.c()
                r1 = 1
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 0
                r2 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                com.google.android.exoplayer2.util.AtomicFile r4 = r10.f28619e     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
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
                javax.crypto.Cipher r6 = r10.f28616b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r6 != 0) goto L_0x0036
                com.google.android.exoplayer2.util.Util.n(r4)
                return r0
            L_0x0036:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r4.readFully(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r6 = r10.f28616b     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                javax.crypto.spec.SecretKeySpec r8 = r10.f28617c     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.lang.Object r8 = com.google.android.exoplayer2.util.Util.j(r8)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.security.Key r8 = (java.security.Key) r8     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r7 = r10.f28616b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
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
                boolean r3 = r10.f28615a     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r3 == 0) goto L_0x006c
                r10.f28620f = r1     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x006c:
                int r3 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r5 = 0
                r6 = 0
            L_0x0072:
                if (r5 >= r3) goto L_0x008c
                com.google.android.exoplayer2.upstream.cache.CachedContent r7 = r10.j(r2, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r8 = r7.f28598b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r11.put(r8, r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r8 = r7.f28597a     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r9 = r7.f28598b     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
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
                com.google.android.exoplayer2.util.Util.n(r4)
                return r1
            L_0x00a3:
                com.google.android.exoplayer2.util.Util.n(r4)
                return r0
            L_0x00a7:
                com.google.android.exoplayer2.util.Util.n(r4)
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
                com.google.android.exoplayer2.util.Util.n(r2)
            L_0x00b7:
                throw r11
            L_0x00b8:
            L_0x00b9:
                if (r2 == 0) goto L_0x00be
                com.google.android.exoplayer2.util.Util.n(r2)
            L_0x00be:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CachedContentIndex.LegacyStorage.k(java.util.HashMap, android.util.SparseArray):boolean");
        }

        private void l(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f28597a);
            dataOutputStream.writeUTF(cachedContent.f28598b);
            CachedContentIndex.t(cachedContent.d(), dataOutputStream);
        }

        private void m(HashMap<String, CachedContent> hashMap) throws IOException {
            int i2;
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream f2 = this.f28619e.f();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.f28621g;
                if (reusableBufferedOutputStream == null) {
                    this.f28621g = new ReusableBufferedOutputStream(f2);
                } else {
                    reusableBufferedOutputStream.a(f2);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.f28621g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i3 = 0;
                    if (this.f28615a) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    dataOutputStream2.writeInt(i2);
                    if (this.f28615a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.j(this.f28618d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        ((Cipher) Util.j(this.f28616b)).init(1, (Key) Util.j(this.f28617c), new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.f28616b));
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        l(next, dataOutputStream2);
                        i3 += i(next, 2);
                    }
                    dataOutputStream2.writeInt(i3);
                    this.f28619e.b(dataOutputStream2);
                    Util.n((Closeable) null);
                } catch (InvalidKeyException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e3) {
                    e = e3;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    Util.n(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.n(dataOutputStream);
                throw th;
            }
        }

        public void a() {
            this.f28619e.a();
        }

        public boolean b() {
            return this.f28619e.c();
        }

        public void c(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.f28620f) {
                e(hashMap);
            }
        }

        public void d(long j2) {
        }

        public void e(HashMap<String, CachedContent> hashMap) throws IOException {
            m(hashMap);
            this.f28620f = false;
        }

        public void f(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.g(!this.f28620f);
            if (!k(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.f28619e.a();
            }
        }

        public void g(CachedContent cachedContent, boolean z2) {
            this.f28620f = true;
        }

        public void h(CachedContent cachedContent) {
            this.f28620f = true;
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
        Assertions.g(z4);
        this.f28604a = new HashMap<>();
        this.f28605b = new SparseArray<>();
        this.f28606c = new SparseBooleanArray();
        this.f28607d = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        if (databaseProvider != null) {
            databaseStorage = new DatabaseStorage(databaseProvider);
        } else {
            databaseStorage = null;
        }
        legacyStorage = file != null ? new LegacyStorage(new File(file, "cached_content_index.exi"), bArr, z2) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z3)) {
            this.f28608e = (Storage) Util.j(legacyStorage);
            this.f28609f = databaseStorage;
            return;
        }
        this.f28608e = databaseStorage;
        this.f28609f = legacyStorage;
    }

    private CachedContent d(String str) {
        int l2 = l(this.f28605b);
        CachedContent cachedContent = new CachedContent(l2, str);
        this.f28604a.put(str, cachedContent);
        this.f28605b.put(l2, str);
        this.f28607d.put(l2, true);
        this.f28608e.h(cachedContent);
        return cachedContent;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"GetInstance"})
    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.f28808a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int l(SparseArray<String> sparseArray) {
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

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* access modifiers changed from: private */
    public static DefaultContentMetadata q(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = Util.f28813f;
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
    public static void t(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> f2 = defaultContentMetadata.f();
        dataOutputStream.writeInt(f2.size());
        for (Map.Entry next : f2) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void e(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent m2 = m(str);
        if (m2.b(contentMetadataMutations)) {
            this.f28608e.h(m2);
        }
    }

    public int f(String str) {
        return m(str).f28597a;
    }

    public CachedContent g(String str) {
        return this.f28604a.get(str);
    }

    public Collection<CachedContent> h() {
        return Collections.unmodifiableCollection(this.f28604a.values());
    }

    public ContentMetadata j(String str) {
        CachedContent g2 = g(str);
        if (g2 != null) {
            return g2.d();
        }
        return DefaultContentMetadata.f28624c;
    }

    public String k(int i2) {
        return this.f28605b.get(i2);
    }

    public CachedContent m(String str) {
        CachedContent cachedContent = this.f28604a.get(str);
        if (cachedContent == null) {
            return d(str);
        }
        return cachedContent;
    }

    public void n(long j2) throws IOException {
        Storage storage;
        this.f28608e.d(j2);
        Storage storage2 = this.f28609f;
        if (storage2 != null) {
            storage2.d(j2);
        }
        if (this.f28608e.b() || (storage = this.f28609f) == null || !storage.b()) {
            this.f28608e.f(this.f28604a, this.f28605b);
        } else {
            this.f28609f.f(this.f28604a, this.f28605b);
            this.f28608e.e(this.f28604a);
        }
        Storage storage3 = this.f28609f;
        if (storage3 != null) {
            storage3.a();
            this.f28609f = null;
        }
    }

    public void p(String str) {
        CachedContent cachedContent = this.f28604a.get(str);
        if (cachedContent != null && cachedContent.g() && cachedContent.i()) {
            this.f28604a.remove(str);
            int i2 = cachedContent.f28597a;
            boolean z2 = this.f28607d.get(i2);
            this.f28608e.g(cachedContent, z2);
            if (z2) {
                this.f28605b.remove(i2);
                this.f28607d.delete(i2);
                return;
            }
            this.f28605b.put(i2, (Object) null);
            this.f28606c.put(i2, true);
        }
    }

    public void r() {
        UnmodifiableIterator<String> h2 = ImmutableSet.m(this.f28604a.keySet()).iterator();
        while (h2.hasNext()) {
            p(h2.next());
        }
    }

    public void s() throws IOException {
        this.f28608e.c(this.f28604a);
        int size = this.f28606c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f28605b.remove(this.f28606c.keyAt(i2));
        }
        this.f28606c.clear();
        this.f28607d.clear();
    }
}
