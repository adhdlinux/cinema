package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MetaDataStyle implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f36409a = 18;

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f36410b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f36411c = new HashSet(Arrays.asList(new String[]{"BOLD"}));

    /* renamed from: d  reason: collision with root package name */
    public static final Integer f36412d = 14;

    /* renamed from: e  reason: collision with root package name */
    public static final Integer f36413e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f36414f = new HashSet();
    private static final long serialVersionUID = 1;
    private Integer itemDescriptionTextColor = f36413e;
    @j0(type = HashSet.class)
    private Set<String> itemDescriptionTextDecoration = f36414f;
    private Integer itemDescriptionTextSize = f36412d;
    private Integer itemGradientBottom = -8750199;
    private Integer itemGradientTop = -14014151;
    private Integer itemTitleTextColor = f36410b;
    @j0(type = HashSet.class)
    private Set<String> itemTitleTextDecoration = f36411c;
    private Integer itemTitleTextSize = f36409a;
    private String name = "";

    public Integer a() {
        return this.itemDescriptionTextColor;
    }

    public Set<String> b() {
        return this.itemDescriptionTextDecoration;
    }

    public Integer c() {
        return this.itemDescriptionTextSize;
    }

    public Integer d() {
        return this.itemGradientBottom;
    }

    public Integer e() {
        return this.itemGradientTop;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MetaDataStyle.class != obj.getClass()) {
            return false;
        }
        MetaDataStyle metaDataStyle = (MetaDataStyle) obj;
        if (!lb.a(this.name, metaDataStyle.name) || !lb.a(this.itemGradientTop, metaDataStyle.itemGradientTop) || !lb.a(this.itemGradientBottom, metaDataStyle.itemGradientBottom) || !lb.a(this.itemTitleTextSize, metaDataStyle.itemTitleTextSize) || !lb.a(this.itemTitleTextColor, metaDataStyle.itemTitleTextColor) || !lb.a(this.itemTitleTextDecoration, metaDataStyle.itemTitleTextDecoration) || !lb.a(this.itemDescriptionTextSize, metaDataStyle.itemDescriptionTextSize) || !lb.a(this.itemDescriptionTextColor, metaDataStyle.itemDescriptionTextColor) || !lb.a(this.itemDescriptionTextDecoration, metaDataStyle.itemDescriptionTextDecoration)) {
            return false;
        }
        return true;
    }

    public Integer f() {
        return this.itemTitleTextColor;
    }

    public Set<String> g() {
        return this.itemTitleTextDecoration;
    }

    public Integer h() {
        return this.itemTitleTextSize;
    }

    public int hashCode() {
        Object[] objArr = {this.name, this.itemGradientTop, this.itemGradientBottom, this.itemTitleTextSize, this.itemTitleTextColor, this.itemTitleTextDecoration, this.itemDescriptionTextSize, this.itemDescriptionTextColor, this.itemDescriptionTextDecoration};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
