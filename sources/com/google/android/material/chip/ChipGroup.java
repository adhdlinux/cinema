package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;

public class ChipGroup extends FlowLayout {

    /* renamed from: e  reason: collision with root package name */
    private int f29725e;

    /* renamed from: f  reason: collision with root package name */
    private int f29726f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f29727g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final CheckedStateTracker f29728h = new CheckedStateTracker();

    /* renamed from: i  reason: collision with root package name */
    private PassThroughHierarchyChangeListener f29729i = new PassThroughHierarchyChangeListener();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f29730j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f29731k = false;

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!ChipGroup.this.f29731k) {
                int id = compoundButton.getId();
                if (z2) {
                    if (!(ChipGroup.this.f29730j == -1 || ChipGroup.this.f29730j == id || !ChipGroup.this.f29727g)) {
                        ChipGroup chipGroup = ChipGroup.this;
                        chipGroup.k(chipGroup.f29730j, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                } else if (ChipGroup.this.f29730j == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }
    }

    public interface OnCheckedChangeListener {
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f29733b;

        private PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f29728h);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f29733b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f29733b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.E0, i2, R$style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = h2.getDimensionPixelOffset(R$styleable.G0, 0);
        setChipSpacingHorizontal(h2.getDimensionPixelOffset(R$styleable.H0, dimensionPixelOffset));
        setChipSpacingVertical(h2.getDimensionPixelOffset(R$styleable.I0, dimensionPixelOffset));
        setSingleLine(h2.getBoolean(R$styleable.J0, false));
        setSingleSelection(h2.getBoolean(R$styleable.K0, false));
        int resourceId = h2.getResourceId(R$styleable.F0, -1);
        if (resourceId != -1) {
            this.f29730j = resourceId;
        }
        h2.recycle();
        super.setOnHierarchyChangeListener(this.f29729i);
    }

    /* access modifiers changed from: private */
    public void k(int i2, boolean z2) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.f29731k = true;
            ((Chip) findViewById).setChecked(z2);
            this.f29731k = false;
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i2) {
        this.f29730j = i2;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f29730j;
                if (i3 != -1 && this.f29727g) {
                    k(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f29727g) {
            return this.f29730j;
        }
        return -1;
    }

    public int getChipSpacingHorizontal() {
        return this.f29725e;
    }

    public int getChipSpacingVertical() {
        return this.f29726f;
    }

    public void j() {
        this.f29731k = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f29731k = false;
        setCheckedId(-1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f29730j;
        if (i2 != -1) {
            k(i2, true);
            setCheckedId(this.f29730j);
        }
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f29725e != i2) {
            this.f29725e = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(int i2) {
        if (this.f29726f != i2) {
            this.f29726f = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f29729i.f29733b = onHierarchyChangeListener;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z2) {
        if (this.f29727g != z2) {
            this.f29727g = z2;
            j();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
