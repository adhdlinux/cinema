package com.startapp;

import android.content.Context;
import android.util.AttributeSet;

public class m3 {

    /* renamed from: a  reason: collision with root package name */
    public Context f34895a;

    /* renamed from: b  reason: collision with root package name */
    public String f34896b;

    public m3(Context context, AttributeSet attributeSet) {
        this.f34895a = context;
        this.f34896b = a(attributeSet, "adTag");
    }

    public final String a(AttributeSet attributeSet, String str) {
        String str2;
        try {
            int attributeResourceValue = attributeSet.getAttributeResourceValue((String) null, str, -1);
            if (attributeResourceValue != -1) {
                str2 = this.f34895a.getResources().getString(attributeResourceValue);
            } else {
                str2 = attributeSet.getAttributeValue((String) null, str);
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }
}
