package it.gmariotti.changelibs.library.internal;

import android.content.Context;
import it.gmariotti.changelibs.R$string;

public class ChangeLogRow {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f40206a;

    /* renamed from: b  reason: collision with root package name */
    protected String f40207b;

    /* renamed from: c  reason: collision with root package name */
    protected int f40208c;

    /* renamed from: d  reason: collision with root package name */
    protected String f40209d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f40210e;

    /* renamed from: f  reason: collision with root package name */
    private String f40211f;

    /* renamed from: g  reason: collision with root package name */
    private String f40212g;

    /* renamed from: h  reason: collision with root package name */
    private int f40213h;

    public String a() {
        return this.f40212g;
    }

    public String b(Context context) {
        String str;
        if (context == null) {
            return a();
        }
        int i2 = this.f40213h;
        if (i2 == 1) {
            str = context.getResources().getString(R$string.changelog_row_prefix_bug).replaceAll("\\[", "<").replaceAll("\\]", ">");
        } else if (i2 != 2) {
            str = "";
        } else {
            str = context.getResources().getString(R$string.changelog_row_prefix_improvement).replaceAll("\\[", "<").replaceAll("\\]", ">");
        }
        return str + " " + this.f40212g;
    }

    public boolean c() {
        return this.f40210e;
    }

    public boolean d() {
        return this.f40206a;
    }

    public void e(String str) {
        if (str != null) {
            str = str.replaceAll("\\[", "<").replaceAll("\\]", ">");
        }
        h(str);
    }

    public void f(boolean z2) {
        this.f40210e = z2;
    }

    public void g(String str) {
        this.f40209d = str;
    }

    public void h(String str) {
        this.f40212g = str;
    }

    public void i(String str) {
        this.f40211f = str;
    }

    public void j(boolean z2) {
        this.f40206a = z2;
    }

    public void k(int i2) {
        this.f40213h = i2;
    }

    public void l(int i2) {
        this.f40208c = i2;
    }

    public void m(String str) {
        this.f40207b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("header=" + this.f40206a);
        sb.append(",");
        sb.append("versionName=" + this.f40207b);
        sb.append(",");
        sb.append("versionCode=" + this.f40208c);
        sb.append(",");
        sb.append("bulletedList=" + this.f40210e);
        sb.append(",");
        sb.append("changeText=" + this.f40212g);
        return sb.toString();
    }
}
