package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference {
    private static final String TAG = "PreferenceGroup";
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    final SimpleArrayMap<String, Long> mIdRecycleCache;
    private int mInitialExpandedChildrenCount;
    private OnExpandButtonClickListener mOnExpandButtonClickListener;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferences;

    public interface OnExpandButtonClickListener {
    }

    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference preference);

        int getPreferenceAdapterPosition(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mIdRecycleCache = new SimpleArrayMap<>();
        this.mHandler = new Handler();
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mClearRecycleCacheRunnable = new Runnable() {
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.mIdRecycleCache.clear();
                }
            }
        };
        this.mPreferences = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10927n1, i2, i3);
        int i4 = R$styleable.f10933p1;
        this.mOrderingAsAdded = TypedArrayUtils.b(obtainStyledAttributes, i4, i4, true);
        int i5 = R$styleable.f10930o1;
        if (obtainStyledAttributes.hasValue(i5)) {
            setInitialExpandedChildrenCount(TypedArrayUtils.d(obtainStyledAttributes, i5, i5, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.onPrepareForRemoval();
            if (preference.getParent() == this) {
                preference.assignParent((PreferenceGroup) null);
            }
            remove = this.mPreferences.remove(preference);
            if (remove) {
                String key = preference.getKey();
                if (key != null) {
                    this.mIdRecycleCache.put(key, Long.valueOf(preference.getId()));
                    this.mHandler.removeCallbacks(this.mClearRecycleCacheRunnable);
                    this.mHandler.post(this.mClearRecycleCacheRunnable);
                }
                if (this.mAttachedToHierarchy) {
                    preference.onDetached();
                }
            }
        }
        return remove;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        long j2;
        if (this.mPreferences.contains(preference)) {
            return true;
        }
        if (preference.getKey() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.getParent() != null) {
                preferenceGroup = preferenceGroup.getParent();
            }
            String key = preference.getKey();
            if (preferenceGroup.findPreference(key) != null) {
                Log.e(TAG, "Found duplicated key: \"" + key + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                int i2 = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i2 + 1;
                preference.setOrder(i2);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        int binarySearch = Collections.binarySearch(this.mPreferences, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * -1) - 1;
        }
        if (!onPrepareAddPreference(preference)) {
            return false;
        }
        synchronized (this) {
            this.mPreferences.add(binarySearch, preference);
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        String key2 = preference.getKey();
        if (key2 == null || !this.mIdRecycleCache.containsKey(key2)) {
            j2 = preferenceManager.d();
        } else {
            j2 = this.mIdRecycleCache.get(key2).longValue();
            this.mIdRecycleCache.remove(key2);
        }
        preference.onAttachedToHierarchy(preferenceManager, j2);
        preference.assignParent(this);
        if (this.mAttachedToHierarchy) {
            preference.onAttached();
        }
        notifyHierarchyChanged();
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            getPreference(i2).dispatchRestoreInstanceState(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            getPreference(i2).dispatchSaveInstanceState(bundle);
        }
    }

    public <T extends Preference> T findPreference(CharSequence charSequence) {
        T findPreference;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        } else {
            int preferenceCount = getPreferenceCount();
            for (int i2 = 0; i2 < preferenceCount; i2++) {
                T preference = getPreference(i2);
                if (TextUtils.equals(preference.getKey(), charSequence)) {
                    return preference;
                }
                if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                    return findPreference;
                }
            }
            return null;
        }
    }

    public int getInitialExpandedChildrenCount() {
        return this.mInitialExpandedChildrenCount;
    }

    public OnExpandButtonClickListener getOnExpandButtonClickListener() {
        return null;
    }

    public Preference getPreference(int i2) {
        return this.mPreferences.get(i2);
    }

    public int getPreferenceCount() {
        return this.mPreferences.size();
    }

    public boolean isAttached() {
        return this.mAttachedToHierarchy;
    }

    /* access modifiers changed from: protected */
    public boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    public void notifyDependencyChange(boolean z2) {
        super.notifyDependencyChange(z2);
        int preferenceCount = getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            getPreference(i2).onParentChanged(this, z2);
        }
    }

    public void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int preferenceCount = getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            getPreference(i2).onAttached();
        }
    }

    public void onDetached() {
        super.onDetached();
        this.mAttachedToHierarchy = false;
        int preferenceCount = getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            getPreference(i2).onDetached();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareAddPreference(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mInitialExpandedChildrenCount = savedState.f10848b;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mInitialExpandedChildrenCount);
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.mPreferences;
            for (int size = list.size() - 1; size >= 0; size--) {
                removePreferenceInt(list.get(0));
            }
        }
        notifyHierarchyChanged();
    }

    public boolean removePreference(Preference preference) {
        boolean removePreferenceInt = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return removePreferenceInt;
    }

    public boolean removePreferenceRecursively(CharSequence charSequence) {
        Preference findPreference = findPreference(charSequence);
        if (findPreference == null) {
            return false;
        }
        return findPreference.getParent().removePreference(findPreference);
    }

    public void setInitialExpandedChildrenCount(int i2) {
        if (i2 != Integer.MAX_VALUE && !hasKey()) {
            Log.e(TAG, getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.mInitialExpandedChildrenCount = i2;
    }

    public void setOnExpandButtonClickListener(OnExpandButtonClickListener onExpandButtonClickListener) {
    }

    public void setOrderingAsAdded(boolean z2) {
        this.mOrderingAsAdded = z2;
    }

    /* access modifiers changed from: package-private */
    public void sortPreferences() {
        synchronized (this) {
            Collections.sort(this.mPreferences);
        }
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
        int f10848b;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f10848b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10848b);
        }

        SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f10848b = i2;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
