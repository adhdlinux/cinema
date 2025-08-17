package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R$id;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ViewGroup, Float> f29401a = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    /* renamed from: a */
    public Float get(ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(R$id.mtrl_internal_children_alpha_tag);
        if (f2 != null) {
            return f2;
        }
        return Float.valueOf(1.0f);
    }

    /* renamed from: b */
    public void set(ViewGroup viewGroup, Float f2) {
        float floatValue = f2.floatValue();
        viewGroup.setTag(R$id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}
