package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.startapp.ka;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class ImageResourceConfig implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public transient Bitmap f36279a;

    /* renamed from: b  reason: collision with root package name */
    public transient Bitmap f36280b;

    /* renamed from: c  reason: collision with root package name */
    public transient Bitmap f36281c = null;
    private int height = 1;
    private String imageFallbackUrl = "";
    private String imageUrlSecured = "";
    private String name;
    private int width = 1;

    public Bitmap a(Context context) {
        if (this.f36281c == null) {
            Bitmap bitmap = this.f36279a;
            this.f36281c = bitmap;
            if (bitmap == null) {
                if (this.f36280b == null) {
                    this.f36280b = ka.a(context, this.imageFallbackUrl);
                }
                this.f36281c = this.f36280b;
            }
        }
        return this.f36281c;
    }

    public void b(int i2) {
        this.width = i2;
    }

    public String c() {
        return this.name;
    }

    public int d() {
        return this.width;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImageResourceConfig.class != obj.getClass()) {
            return false;
        }
        ImageResourceConfig imageResourceConfig = (ImageResourceConfig) obj;
        if (this.width != imageResourceConfig.width || this.height != imageResourceConfig.height || !lb.a(this.imageUrlSecured, imageResourceConfig.imageUrlSecured) || !lb.a(this.imageFallbackUrl, imageResourceConfig.imageFallbackUrl) || !lb.a(this.name, imageResourceConfig.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.imageUrlSecured, this.imageFallbackUrl, Integer.valueOf(this.width), Integer.valueOf(this.height), this.name};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public String b() {
        String str = this.imageUrlSecured;
        return str != null ? str : "";
    }

    public void b(String str) {
        this.imageFallbackUrl = str;
    }

    public int a() {
        return this.height;
    }

    public void a(int i2) {
        this.height = i2;
    }

    public static ImageResourceConfig a(String str) {
        ImageResourceConfig imageResourceConfig = new ImageResourceConfig();
        imageResourceConfig.name = str;
        return imageResourceConfig;
    }
}
