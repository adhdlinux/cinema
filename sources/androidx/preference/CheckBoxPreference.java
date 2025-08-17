package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.res.TypedArrayUtils;

public class CheckBoxPreference extends TwoStatePreference {
    private final Listener mListener;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z2))) {
                compoundButton.setChecked(!z2);
            } else {
                CheckBoxPreference.this.setChecked(z2);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private void syncCheckboxView(View view) {
        boolean z2 = view instanceof CompoundButton;
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncCheckboxView(view.findViewById(16908289));
            syncSummaryView(view.findViewById(16908304));
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncCheckboxView(preferenceViewHolder.a(16908289));
        syncSummaryView(preferenceViewHolder);
    }

    /* access modifiers changed from: protected */
    public void performClick(View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10940s, i2, i3);
        setSummaryOn((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.f10953y, R$styleable.f10943t));
        setSummaryOff((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.f10951x, R$styleable.f10945u));
        setDisableDependentsState(TypedArrayUtils.b(obtainStyledAttributes, R$styleable.f10949w, R$styleable.f10947v, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.checkBoxPreferenceStyle, 16842895));
    }

    public CheckBoxPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
