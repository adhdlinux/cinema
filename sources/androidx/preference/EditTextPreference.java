package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

public class EditTextPreference extends DialogPreference {
    private OnBindEditTextListener mOnBindEditTextListener;
    private String mText;

    public interface OnBindEditTextListener {
        void a(EditText editText);
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.getText())) {
                return editTextPreference.getContext().getString(R$string.not_set);
            }
            return editTextPreference.getText();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.R, i2, i3);
        int i4 = R$styleable.S;
        if (TypedArrayUtils.b(obtainStyledAttributes, i4, i4, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public OnBindEditTextListener getOnBindEditTextListener() {
        return this.mOnBindEditTextListener;
    }

    public String getText() {
        return this.mText;
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
        setText(savedState.f10811b);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10811b = getText();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        setText(getPersistedString((String) obj));
    }

    public void setOnBindEditTextListener(OnBindEditTextListener onBindEditTextListener) {
        this.mOnBindEditTextListener = onBindEditTextListener;
    }

    public void setText(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.mText = str;
        persistString(str);
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
        notifyChanged();
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
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
        String f10811b;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f10811b = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f10811b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.editTextPreferenceStyle, 16842898));
    }

    public EditTextPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
