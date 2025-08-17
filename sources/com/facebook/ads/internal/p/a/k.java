package com.facebook.ads.internal.p.a;

public class k extends l {
    public k(String str, p pVar) {
        super(str, (p) null);
        this.f20470b = j.POST;
        this.f20469a = str;
        this.f20471c = "application/x-www-form-urlencoded;charset=UTF-8";
        if (pVar != null) {
            this.f20472d = pVar.b();
        }
    }

    public k(String str, p pVar, String str2, byte[] bArr) {
        super(str, pVar);
        this.f20470b = j.POST;
        this.f20471c = str2;
        this.f20472d = bArr;
    }
}
