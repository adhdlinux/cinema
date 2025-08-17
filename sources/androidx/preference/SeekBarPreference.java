package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

public class SeekBarPreference extends Preference {
    private static final String TAG = "SeekBarPreference";
    boolean mAdjustable;
    private int mMax;
    int mMin;
    SeekBar mSeekBar;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private int mSeekBarIncrement;
    private View.OnKeyListener mSeekBarKeyListener;
    int mSeekBarValue;
    private TextView mSeekBarValueTextView;
    private boolean mShowSeekBarValue;
    boolean mTrackingTouch;
    boolean mUpdatesContinuously;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                if (z2) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (seekBarPreference.mUpdatesContinuously || !seekBarPreference.mTrackingTouch) {
                        seekBarPreference.syncValueInternal(seekBar);
                        return;
                    }
                }
                SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
                seekBarPreference2.updateLabelValue(i2 + seekBarPreference2.mMin);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.mTrackingTouch = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.mTrackingTouch = false;
                int progress = seekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.mMin != seekBarPreference.mSeekBarValue) {
                    seekBarPreference.syncValueInternal(seekBar);
                }
            }
        };
        this.mSeekBarKeyListener = new View.OnKeyListener() {
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.mAdjustable && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.mSeekBar;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i2, keyEvent);
                }
                Log.e(SeekBarPreference.TAG, "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.x1, i2, i3);
        this.mMin = obtainStyledAttributes.getInt(R$styleable.A1, 0);
        setMax(obtainStyledAttributes.getInt(R$styleable.y1, 100));
        setSeekBarIncrement(obtainStyledAttributes.getInt(R$styleable.B1, 0));
        this.mAdjustable = obtainStyledAttributes.getBoolean(R$styleable.z1, true);
        this.mShowSeekBarValue = obtainStyledAttributes.getBoolean(R$styleable.C1, false);
        this.mUpdatesContinuously = obtainStyledAttributes.getBoolean(R$styleable.D1, false);
        obtainStyledAttributes.recycle();
    }

    private void setValueInternal(int i2, boolean z2) {
        int i3 = this.mMin;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.mMax;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.mSeekBarValue) {
            this.mSeekBarValue = i2;
            updateLabelValue(i2);
            persistInt(i2);
            if (z2) {
                notifyChanged();
            }
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getMin() {
        return this.mMin;
    }

    public final int getSeekBarIncrement() {
        return this.mSeekBarIncrement;
    }

    public boolean getShowSeekBarValue() {
        return this.mShowSeekBarValue;
    }

    public boolean getUpdatesContinuously() {
        return this.mUpdatesContinuously;
    }

    public int getValue() {
        return this.mSeekBarValue;
    }

    public boolean isAdjustable() {
        return this.mAdjustable;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        this.mSeekBar = (SeekBar) preferenceViewHolder.a(R$id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.a(R$id.seekbar_value);
        this.mSeekBarValueTextView = textView;
        if (this.mShowSeekBarValue) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.mSeekBarValueTextView = null;
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Log.e(TAG, "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.mSeekBar.setMax(this.mMax - this.mMin);
        int i2 = this.mSeekBarIncrement;
        if (i2 != 0) {
            this.mSeekBar.setKeyProgressIncrement(i2);
        } else {
            this.mSeekBarIncrement = this.mSeekBar.getKeyProgressIncrement();
        }
        this.mSeekBar.setProgress(this.mSeekBarValue - this.mMin);
        updateLabelValue(this.mSeekBarValue);
        this.mSeekBar.setEnabled(isEnabled());
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSeekBarValue = savedState.f10959b;
        this.mMin = savedState.f10960c;
        this.mMax = savedState.f10961d;
        notifyChanged();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10959b = this.mSeekBarValue;
        savedState.f10960c = this.mMin;
        savedState.f10961d = this.mMax;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        setValue(getPersistedInt(((Integer) obj).intValue()));
    }

    public void setAdjustable(boolean z2) {
        this.mAdjustable = z2;
    }

    public final void setMax(int i2) {
        int i3 = this.mMin;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.mMax) {
            this.mMax = i2;
            notifyChanged();
        }
    }

    public void setMin(int i2) {
        int i3 = this.mMax;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 != this.mMin) {
            this.mMin = i2;
            notifyChanged();
        }
    }

    public final void setSeekBarIncrement(int i2) {
        if (i2 != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(i2));
            notifyChanged();
        }
    }

    public void setShowSeekBarValue(boolean z2) {
        this.mShowSeekBarValue = z2;
        notifyChanged();
    }

    public void setUpdatesContinuously(boolean z2) {
        this.mUpdatesContinuously = z2;
    }

    public void setValue(int i2) {
        setValueInternal(i2, true);
    }

    /* access modifiers changed from: package-private */
    public void syncValueInternal(SeekBar seekBar) {
        int progress = this.mMin + seekBar.getProgress();
        if (progress == this.mSeekBarValue) {
            return;
        }
        if (callChangeListener(Integer.valueOf(progress))) {
            setValueInternal(progress, false);
            return;
        }
        seekBar.setProgress(this.mSeekBarValue - this.mMin);
        updateLabelValue(this.mSeekBarValue);
    }

    /* access modifiers changed from: package-private */
    public void updateLabelValue(int i2) {
        TextView textView = this.mSeekBarValueTextView;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
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
        int f10959b;

        /* renamed from: c  reason: collision with root package name */
        int f10960c;

        /* renamed from: d  reason: collision with root package name */
        int f10961d;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f10959b = parcel.readInt();
            this.f10960c = parcel.readInt();
            this.f10961d = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10959b);
            parcel.writeInt(this.f10960c);
            parcel.writeInt(this.f10961d);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarPreferenceStyle);
    }

    public SeekBarPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}
