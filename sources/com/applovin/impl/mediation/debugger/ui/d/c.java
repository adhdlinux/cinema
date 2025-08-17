package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;

public class c {

    /* renamed from: b  reason: collision with root package name */
    protected b f14700b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f14701c;

    /* renamed from: d  reason: collision with root package name */
    protected SpannedString f14702d;

    /* renamed from: e  reason: collision with root package name */
    protected SpannedString f14703e;

    /* renamed from: f  reason: collision with root package name */
    protected String f14704f;

    /* renamed from: g  reason: collision with root package name */
    protected String f14705g;

    /* renamed from: h  reason: collision with root package name */
    protected int f14706h;

    /* renamed from: i  reason: collision with root package name */
    protected int f14707i;

    /* renamed from: j  reason: collision with root package name */
    protected int f14708j;

    /* renamed from: k  reason: collision with root package name */
    protected int f14709k;

    /* renamed from: l  reason: collision with root package name */
    protected int f14710l;

    /* renamed from: m  reason: collision with root package name */
    protected int f14711m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f14712n;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final b f14713a;

        /* renamed from: b  reason: collision with root package name */
        boolean f14714b;

        /* renamed from: c  reason: collision with root package name */
        SpannedString f14715c;

        /* renamed from: d  reason: collision with root package name */
        SpannedString f14716d;

        /* renamed from: e  reason: collision with root package name */
        String f14717e;

        /* renamed from: f  reason: collision with root package name */
        String f14718f;

        /* renamed from: g  reason: collision with root package name */
        int f14719g = 0;

        /* renamed from: h  reason: collision with root package name */
        int f14720h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f14721i = -16777216;

        /* renamed from: j  reason: collision with root package name */
        int f14722j = -16777216;

        /* renamed from: k  reason: collision with root package name */
        int f14723k = 0;

        /* renamed from: l  reason: collision with root package name */
        int f14724l = 0;

        /* renamed from: m  reason: collision with root package name */
        boolean f14725m;

        public a(b bVar) {
            this.f14713a = bVar;
        }

        public a a(int i2) {
            this.f14720h = i2;
            return this;
        }

        public a a(Context context) {
            this.f14720h = R.drawable.applovin_ic_disclosure_arrow;
            this.f14724l = f.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public a a(SpannedString spannedString) {
            this.f14715c = spannedString;
            return this;
        }

        public a a(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a a(boolean z2) {
            this.f14714b = z2;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(int i2) {
            this.f14722j = i2;
            return this;
        }

        public a b(SpannedString spannedString) {
            this.f14716d = spannedString;
            return this;
        }

        public a b(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a b(boolean z2) {
            this.f14725m = z2;
            return this;
        }

        public a c(int i2) {
            this.f14724l = i2;
            return this;
        }

        public a c(String str) {
            this.f14717e = str;
            return this;
        }

        public a d(String str) {
            this.f14718f = str;
            return this;
        }
    }

    public enum b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        

        /* renamed from: g  reason: collision with root package name */
        private final int f14733g;

        private b(int i2) {
            this.f14733g = i2;
        }

        public int a() {
            return this.f14733g;
        }

        public int b() {
            if (this == SECTION) {
                return R.layout.list_section;
            }
            if (this == SECTION_CENTERED) {
                return R.layout.list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? R.layout.list_item_detail : R.layout.list_item_right_detail;
        }
    }

    private c(a aVar) {
        this.f14706h = 0;
        this.f14707i = 0;
        this.f14708j = -16777216;
        this.f14709k = -16777216;
        this.f14710l = 0;
        this.f14711m = 0;
        this.f14700b = aVar.f14713a;
        this.f14701c = aVar.f14714b;
        this.f14702d = aVar.f14715c;
        this.f14703e = aVar.f14716d;
        this.f14704f = aVar.f14717e;
        this.f14705g = aVar.f14718f;
        this.f14706h = aVar.f14719g;
        this.f14707i = aVar.f14720h;
        this.f14708j = aVar.f14721i;
        this.f14709k = aVar.f14722j;
        this.f14710l = aVar.f14723k;
        this.f14711m = aVar.f14724l;
        this.f14712n = aVar.f14725m;
    }

    protected c(b bVar) {
        this.f14706h = 0;
        this.f14707i = 0;
        this.f14708j = -16777216;
        this.f14709k = -16777216;
        this.f14710l = 0;
        this.f14711m = 0;
        this.f14700b = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public static int h() {
        return b.COUNT.a();
    }

    public static a p() {
        return a(b.RIGHT_DETAIL);
    }

    public boolean b() {
        return this.f14701c;
    }

    public int c() {
        return this.f14709k;
    }

    public SpannedString c_() {
        return this.f14703e;
    }

    public boolean d_() {
        return this.f14712n;
    }

    public int e() {
        return this.f14706h;
    }

    public int f() {
        return this.f14707i;
    }

    public int g() {
        return this.f14711m;
    }

    public int i() {
        return this.f14700b.a();
    }

    public int j() {
        return this.f14700b.b();
    }

    public SpannedString k() {
        return this.f14702d;
    }

    public String l() {
        return this.f14704f;
    }

    public String m() {
        return this.f14705g;
    }

    public int n() {
        return this.f14708j;
    }

    public int o() {
        return this.f14710l;
    }
}
