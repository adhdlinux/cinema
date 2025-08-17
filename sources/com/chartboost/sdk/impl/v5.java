package com.chartboost.sdk.impl;

import android.content.Context;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class v5 {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f18847a;

    /* renamed from: b  reason: collision with root package name */
    public final w5 f18848b;

    public v5(Context context, AtomicReference atomicReference) {
        w5 w5Var = new w5(context.getCacheDir());
        this.f18848b = w5Var;
        this.f18847a = atomicReference;
        try {
            long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) ((pa) atomicReference.get()).f18371o);
            File file = new File(w5Var.f18887a, "templates");
            if (file.exists()) {
                a(file.listFiles(), currentTimeMillis);
                a(w5Var);
            }
        } catch (Exception e2) {
            w7.a("FileCache", "Exception while cleaning up templates directory at " + this.f18848b.f18892f.getPath(), e2);
            e2.printStackTrace();
        }
    }

    public boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public final void b(File[] fileArr, long j2) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.lastModified() < j2 && !file.delete()) {
                    w7.b("FileCache", "Unable to delete " + file.getPath());
                }
            }
        }
    }

    public boolean c(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public File[] d() {
        File c2 = c();
        if (c2 != null) {
            return c2.listFiles();
        }
        return null;
    }

    public File e() {
        return this.f18848b.f18895i;
    }

    public JSONObject f() {
        String[] list;
        JSONObject jSONObject = new JSONObject();
        try {
            File file = a().f18887a;
            for (String str : ((pa) this.f18847a.get()).f18372p) {
                if (!str.equals("templates")) {
                    File file2 = new File(file, str);
                    JSONArray jSONArray = new JSONArray();
                    if (file2.exists() && (list = file2.list()) != null) {
                        for (String str2 : list) {
                            if (!str2.equals(".nomedia") && !str2.endsWith(DefaultDiskStorage.FileType.TEMP)) {
                                jSONArray.put(str2);
                            }
                        }
                    }
                    h2.a(jSONObject, str, jSONArray);
                }
            }
        } catch (Exception e2) {
            w7.b("FileCache", "getWebViewCacheAssets: " + e2.toString());
        }
        return jSONObject;
    }

    public File c() {
        return this.f18848b.f18894h;
    }

    public File a(File file, String str) {
        if (file == null || str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists() || file2.length() <= 0) {
            return null;
        }
        return file2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028, all -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003f A[SYNTHETIC, Splitter:B:28:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.io.File r6) {
        /*
            r5 = this;
            java.lang.String r0 = "FileCache"
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            java.lang.String r3 = "rw"
            r2.<init>(r6, r3)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            r3 = 0
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            int r6 = r2.read()     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.write(r6)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003c
        L_0x001d:
            r6 = move-exception
            r1 = r2
            goto L_0x003d
        L_0x0020:
            r6 = move-exception
            r1 = r2
            goto L_0x0029
        L_0x0023:
            r6 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x0026:
            r6 = move-exception
            goto L_0x003d
        L_0x0028:
            r6 = move-exception
        L_0x0029:
            java.lang.String r2 = "IOException when attempting to touch file"
            com.chartboost.sdk.impl.w7.a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
            goto L_0x0039
        L_0x0031:
            r6 = move-exception
        L_0x0032:
            java.lang.String r2 = "File not found when attempting to touch"
            com.chartboost.sdk.impl.w7.a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            return
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v5.d(java.io.File):void");
    }

    public final void a(File[] fileArr, long j2) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    b(file.listFiles(), j2);
                    a(file.listFiles(), file);
                }
            }
        }
    }

    public long b(File file) {
        long j2 = 0;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return 0;
                    }
                    for (File b2 : listFiles) {
                        j2 += b(b2);
                    }
                    return j2;
                }
            } catch (Exception e2) {
                w7.b("FileCache", "getFolderSize: " + e2.toString());
                return 0;
            }
        }
        if (file != null) {
            return file.length();
        }
        return 0;
    }

    public final void a(File[] fileArr, File file) {
        if (fileArr != null && fileArr.length == 0 && !file.delete()) {
            w7.b("FileCache", "Unable to delete " + file.getPath());
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        h2.a(jSONObject, ".chartboost-internal-folder-size", Long.valueOf(b(this.f18848b.f18887a)));
        File file = a().f18887a;
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String file2 : list) {
                File file3 = new File(file, file2);
                JSONObject jSONObject2 = new JSONObject();
                h2.a(jSONObject2, file3.getName() + "-size", Long.valueOf(b(file3)));
                String[] list2 = file3.list();
                if (list2 != null) {
                    h2.a(jSONObject2, "count", Integer.valueOf(list2.length));
                }
                h2.a(jSONObject, file3.getName(), jSONObject2);
            }
        }
        return jSONObject;
    }

    public final void a(w5 w5Var) {
        File file = new File(w5Var.f18887a, ".adId");
        if (file.exists() && !file.delete()) {
            w7.b("FileCache", "Unable to delete " + file.getPath());
        }
    }

    public w5 a() {
        return this.f18848b;
    }

    public Boolean a(v vVar) {
        Map d2 = vVar.d();
        w5 a2 = a();
        if (a2 == null) {
            return Boolean.FALSE;
        }
        File file = a2.f18887a;
        for (f1 f1Var : d2.values()) {
            File a3 = f1Var.a(file);
            if (a3 == null) {
                return Boolean.FALSE;
            }
            if (!a3.exists()) {
                w7.e("FileCache", "Asset does not exist: " + f1Var.f17672b);
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
