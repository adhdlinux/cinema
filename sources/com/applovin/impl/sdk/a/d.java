package com.applovin.impl.sdk.a;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f15022a;

    /* renamed from: b  reason: collision with root package name */
    private final FriendlyObstructionPurpose f15023b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15024c;

    public d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f15022a = view;
        this.f15023b = friendlyObstructionPurpose;
        this.f15024c = str;
    }

    public View a() {
        return this.f15022a;
    }

    public FriendlyObstructionPurpose b() {
        return this.f15023b;
    }

    public String c() {
        return this.f15024c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        View view = this.f15022a;
        if (view == null ? dVar.f15022a != null : !view.equals(dVar.f15022a)) {
            return false;
        }
        if (this.f15023b != dVar.f15023b) {
            return false;
        }
        String str = this.f15024c;
        String str2 = dVar.f15024c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        View view = this.f15022a;
        int i2 = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.f15023b;
        int hashCode2 = (hashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.f15024c;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }
}
