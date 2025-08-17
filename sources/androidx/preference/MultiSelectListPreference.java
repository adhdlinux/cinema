package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference extends DialogPreference {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private Set<String> mValues;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mValues = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10920l0, i2, i3);
        this.mEntries = TypedArrayUtils.q(obtainStyledAttributes, R$styleable.f10929o0, R$styleable.f10923m0);
        this.mEntryValues = TypedArrayUtils.q(obtainStyledAttributes, R$styleable.f10932p0, R$styleable.f10926n0);
        obtainStyledAttributes.recycle();
    }

    public int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.mEntryValues) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.mEntryValues[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    /* access modifiers changed from: protected */
    public boolean[] getSelectedItems() {
        CharSequence[] charSequenceArr = this.mEntryValues;
        int length = charSequenceArr.length;
        Set<String> set = this.mValues;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = set.contains(charSequenceArr[i2].toString());
        }
        return zArr;
    }

    public Set<String> getValues() {
        return this.mValues;
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValues(savedState.f10816b);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10816b = getValues();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        setValues(getPersistedStringSet((Set) obj));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setValues(Set<String> set) {
        this.mValues.clear();
        this.mValues.addAll(set);
        persistStringSet(set);
        notifyChanged();
    }

    public void setEntries(int i2) {
        setEntries(getContext().getResources().getTextArray(i2));
    }

    public void setEntryValues(int i2) {
        setEntryValues(getContext().getResources().getTextArray(i2));
    }

    private static class SavedState extends Preference.BaseSavedState {
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
        Set<String> f10816b;

        SavedState(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f10816b = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f10816b, strArr);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10816b.size());
            Set<String> set = this.f10816b;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.dialogPreferenceStyle, 16842897));
    }

    public MultiSelectListPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
