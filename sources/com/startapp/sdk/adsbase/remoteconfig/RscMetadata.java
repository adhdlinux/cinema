package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import androidx.annotation.Keep;
import com.startapp.j0;
import com.startapp.jb;
import com.startapp.lb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RscMetadata implements Serializable {
    private static final long serialVersionUID = -5424519918396264553L;
    private boolean enabled;
    private int ief;
    @j0(parser = ItemsParser.class, type = ArrayList.class, value = RscMetadataItem.class)
    private List<RscMetadataItem> items;
    private String triggers;

    @Keep
    public static class ItemsParser extends jb<RscMetadataItem> {
        public ItemsParser() {
            super(RscMetadataItem.class);
        }
    }

    public int a() {
        return this.ief;
    }

    public List<RscMetadataItem> b() {
        return this.items;
    }

    public String c() {
        return this.triggers;
    }

    public boolean d() {
        return this.enabled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RscMetadata.class != obj.getClass()) {
            return false;
        }
        RscMetadata rscMetadata = (RscMetadata) obj;
        if (this.enabled != rscMetadata.enabled || this.ief != rscMetadata.ief || !lb.a(this.triggers, rscMetadata.triggers) || !lb.a(this.items, rscMetadata.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.enabled), this.triggers, this.items, Integer.valueOf(this.ief)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public int a(RscMetadataItem rscMetadataItem) {
        return rscMetadataItem.b() != null ? rscMetadataItem.b().intValue() : this.ief;
    }
}
