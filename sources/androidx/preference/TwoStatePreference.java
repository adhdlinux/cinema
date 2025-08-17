package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

public abstract class TwoStatePreference extends Preference {
    protected boolean mChecked;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        super.onClick();
        boolean z2 = !isChecked();
        if (callChangeListener(Boolean.valueOf(z2))) {
            setChecked(z2);
        }
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f10964b);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10964b = isChecked();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        setChecked(getPersistedBoolean(((Boolean) obj).booleanValue()));
    }

    public void setChecked(boolean z2) {
        boolean z3;
        if (this.mChecked != z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || !this.mCheckedSet) {
            this.mChecked = z2;
            this.mCheckedSet = true;
            persistBoolean(z2);
            if (z3) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    public void setDisableDependentsState(boolean z2) {
        this.mDisableDependentsState = z2;
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (!isChecked()) {
            notifyChanged();
        }
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            notifyChanged();
        }
    }

    public boolean shouldDisableDependents() {
        boolean z2;
        if (this.mDisableDependentsState) {
            z2 = this.mChecked;
        } else if (!this.mChecked) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void syncSummaryView(PreferenceViewHolder preferenceViewHolder) {
        syncSummaryView(preferenceViewHolder.a(16908304));
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        boolean f10964b;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f10964b = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10964b ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncSummaryView(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.mChecked
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            r5.setText(r0)
        L_0x0019:
            r0 = 0
            goto L_0x002e
        L_0x001b:
            boolean r0 = r4.mChecked
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            r5.setText(r0)
            goto L_0x0019
        L_0x002d:
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x003e
            java.lang.CharSequence r2 = r4.getSummary()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x003e
            r5.setText(r2)
            r0 = 0
        L_0x003e:
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = 8
        L_0x0043:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x004c
            r5.setVisibility(r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.syncSummaryView(android.view.View):void");
    }

    public TwoStatePreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setSummaryOff(int i2) {
        setSummaryOff((CharSequence) getContext().getString(i2));
    }

    public void setSummaryOn(int i2) {
        setSummaryOn((CharSequence) getContext().getString(i2));
    }
}
