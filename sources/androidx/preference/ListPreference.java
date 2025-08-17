package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

public class ListPreference extends DialogPreference {
    private static final String TAG = "ListPreference";
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mSummary;
    private String mValue;
    private boolean mValueSet;

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.getEntry())) {
                return listPreference.getContext().getString(R$string.not_set);
            }
            return listPreference.getEntry();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10893c0, i2, i3);
        this.mEntries = TypedArrayUtils.q(obtainStyledAttributes, R$styleable.f10902f0, R$styleable.f10896d0);
        this.mEntryValues = TypedArrayUtils.q(obtainStyledAttributes, R$styleable.f10905g0, R$styleable.f10899e0);
        int i4 = R$styleable.f10908h0;
        if (TypedArrayUtils.b(obtainStyledAttributes, i4, i4, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f10941s0, i2, i3);
        this.mSummary = TypedArrayUtils.o(obtainStyledAttributes2, R$styleable.f10888a1, R$styleable.A0);
        obtainStyledAttributes2.recycle();
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
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

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int valueIndex = getValueIndex();
        if (valueIndex < 0 || (charSequenceArr = this.mEntries) == null) {
            return null;
        }
        return charSequenceArr[valueIndex];
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        Object entry = getEntry();
        CharSequence summary = super.getSummary();
        String str = this.mSummary;
        if (str == null) {
            return summary;
        }
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, summary)) {
            return summary;
        }
        Log.w(TAG, "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public String getValue() {
        return this.mValue;
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.f10813b);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10813b = getValue();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        setValue(getPersistedString((String) obj));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.mSummary != null) {
            this.mSummary = null;
        } else if (charSequence != null && !charSequence.equals(this.mSummary)) {
            this.mSummary = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean z2 = !TextUtils.equals(this.mValue, str);
        if (z2 || !this.mValueSet) {
            this.mValue = str;
            this.mValueSet = true;
            persistString(str);
            if (z2) {
                notifyChanged();
            }
        }
    }

    public void setValueIndex(int i2) {
        CharSequence[] charSequenceArr = this.mEntryValues;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[i2].toString());
        }
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
        String f10813b;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f10813b = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f10813b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setEntries(int i2) {
        setEntries(getContext().getResources().getTextArray(i2));
    }

    public void setEntryValues(int i2) {
        setEntryValues(getContext().getResources().getTextArray(i2));
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.dialogPreferenceStyle, 16842897));
    }

    public ListPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
