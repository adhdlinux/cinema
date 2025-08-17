package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.res.TypedArrayUtils;

public class SwitchPreference extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!SwitchPreference.this.callChangeListener(Boolean.valueOf(z2))) {
                compoundButton.setChecked(!z2);
            } else {
                SwitchPreference.this.setChecked(z2);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.I1, i2, i3);
        setSummaryOn((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.Q1, R$styleable.J1));
        setSummaryOff((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.P1, R$styleable.K1));
        setSwitchTextOn((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.S1, R$styleable.M1));
        setSwitchTextOff((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.R1, R$styleable.N1));
        setDisableDependentsState(TypedArrayUtils.b(obtainStyledAttributes, R$styleable.O1, R$styleable.L1, false));
        obtainStyledAttributes.recycle();
    }

    private void syncSwitchView(View view) {
        boolean z2 = view instanceof Switch;
        if (z2) {
            ((Switch) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z2) {
            Switch switchR = (Switch) view;
            switchR.setTextOn(this.mSwitchOn);
            switchR.setTextOff(this.mSwitchOff);
            switchR.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncSwitchView(view.findViewById(16908352));
            syncSummaryView(view.findViewById(16908304));
        }
    }

    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView(preferenceViewHolder.a(16908352));
        syncSummaryView(preferenceViewHolder);
    }

    /* access modifiers changed from: protected */
    public void performClick(View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOff(int i2) {
        setSwitchTextOff((CharSequence) getContext().getString(i2));
    }

    public void setSwitchTextOn(int i2) {
        setSwitchTextOn((CharSequence) getContext().getString(i2));
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.switchPreferenceStyle, 16843629));
    }

    public SwitchPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
