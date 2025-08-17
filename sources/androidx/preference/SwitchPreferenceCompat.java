package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.TypedArrayUtils;

public class SwitchPreferenceCompat extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z2))) {
                compoundButton.setChecked(!z2);
            } else {
                SwitchPreferenceCompat.this.setChecked(z2);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.T1, i2, i3);
        setSummaryOn((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.b2, R$styleable.U1));
        setSummaryOff((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.a2, R$styleable.V1));
        setSwitchTextOn((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.d2, R$styleable.X1));
        setSwitchTextOff((CharSequence) TypedArrayUtils.o(obtainStyledAttributes, R$styleable.c2, R$styleable.Y1));
        setDisableDependentsState(TypedArrayUtils.b(obtainStyledAttributes, R$styleable.Z1, R$styleable.W1, false));
        obtainStyledAttributes.recycle();
    }

    private void syncSwitchView(View view) {
        boolean z2 = view instanceof SwitchCompat;
        if (z2) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z2) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.mSwitchOn);
            switchCompat.setTextOff(this.mSwitchOff);
            switchCompat.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncSwitchView(view.findViewById(R$id.switchWidget));
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
        syncSwitchView(preferenceViewHolder.a(R$id.switchWidget));
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

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, (AttributeSet) null);
    }
}
