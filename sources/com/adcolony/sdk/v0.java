package com.adcolony.sdk;

import android.content.Context;
import android.os.StatFs;
import com.adcolony.sdk.e0;
import java.io.File;

class v0 {

    /* renamed from: a  reason: collision with root package name */
    private String f13453a;

    /* renamed from: b  reason: collision with root package name */
    private String f13454b;

    /* renamed from: c  reason: collision with root package name */
    private String f13455c;

    /* renamed from: d  reason: collision with root package name */
    private String f13456d;

    /* renamed from: e  reason: collision with root package name */
    private File f13457e;

    /* renamed from: f  reason: collision with root package name */
    private File f13458f;

    /* renamed from: g  reason: collision with root package name */
    private File f13459g;

    v0() {
    }

    private long b(StatFs statFs) {
        return e(statFs);
    }

    private long e(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private long g(StatFs statFs) {
        return i(statFs);
    }

    private long i(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    /* access modifiers changed from: package-private */
    public double a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (b(statFs) * g(statFs));
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f13453a;
    }

    /* access modifiers changed from: package-private */
    public void d(f1 f1Var) {
        c0.G(f1Var, c() + "AppVersion");
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f13455c;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return this.f13454b;
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f13456d;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        k f2 = a.f();
        this.f13453a = l() + "/adc3/";
        this.f13454b = this.f13453a + "media/";
        File file = new File(this.f13454b);
        this.f13457e = file;
        if (!file.isDirectory()) {
            this.f13457e.delete();
            this.f13457e.mkdirs();
        }
        if (!this.f13457e.isDirectory()) {
            f2.R(true);
            return false;
        } else if (a(this.f13454b) < 2.097152E7d) {
            new e0.a().c("Not enough memory available at media path, disabling AdColony.").d(e0.f13111f);
            f2.R(true);
            return false;
        } else {
            this.f13455c = l() + "/adc3/data/";
            File file2 = new File(this.f13455c);
            this.f13458f = file2;
            if (!file2.isDirectory()) {
                this.f13458f.delete();
            }
            this.f13458f.mkdirs();
            this.f13456d = this.f13453a + "tmp/";
            File file3 = new File(this.f13456d);
            this.f13459g = file3;
            if (!file3.isDirectory()) {
                this.f13459g.delete();
                this.f13459g.mkdirs();
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public String l() {
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return a2.getFilesDir().getAbsolutePath();
    }

    /* access modifiers changed from: package-private */
    public f1 m() {
        if (!new File(c() + "AppVersion").exists()) {
            return c0.q();
        }
        return c0.z(c() + "AppVersion");
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        File file = this.f13457e;
        if (file == null || this.f13458f == null || this.f13459g == null) {
            return false;
        }
        if (!file.isDirectory()) {
            this.f13457e.delete();
        }
        if (!this.f13458f.isDirectory()) {
            this.f13458f.delete();
        }
        if (!this.f13459g.isDirectory()) {
            this.f13459g.delete();
        }
        this.f13457e.mkdirs();
        this.f13458f.mkdirs();
        this.f13459g.mkdirs();
        return true;
    }
}
