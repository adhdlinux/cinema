package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference implements Comparable<Preference> {
    private static final String CLIPBOARD_ID = "Preference";
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private OnPreferenceCopyListener mOnCopyListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    private PreferenceDataStore mPreferenceDataStore;
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private SummaryProvider mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            /* renamed from: a */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* renamed from: b */
            public BaseSavedState[] newArray(int i2) {
                return new BaseSavedState[i2];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    public interface OnPreferenceClickListener {
        boolean a(Preference preference);
    }

    private static class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Preference f10820b;

        OnPreferenceCopyListener(Preference preference) {
            this.f10820b = preference;
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence summary = this.f10820b.getSummary();
            if (this.f10820b.isCopyingEnabled() && !TextUtils.isEmpty(summary)) {
                contextMenu.setHeaderTitle(summary);
                contextMenu.add(0, 0, 0, R$string.copy).setOnMenuItemClickListener(this);
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            CharSequence summary = this.f10820b.getSummary();
            ((ClipboardManager) this.f10820b.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(Preference.CLIPBOARD_ID, summary));
            Toast.makeText(this.f10820b.getContext(), this.f10820b.getContext().getString(R$string.preference_copied, new Object[]{summary}), 0).show();
            return true;
        }
    }

    public interface SummaryProvider<T extends Preference> {
        CharSequence provideSummary(T t2);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        int i4 = R$layout.preference;
        this.mLayoutResId = i4;
        this.mClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Preference.this.performClick(view);
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10941s0, i2, i3);
        this.mIconResId = TypedArrayUtils.n(obtainStyledAttributes, R$styleable.Q0, R$styleable.f10944t0, 0);
        this.mKey = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.T0, R$styleable.f10956z0);
        this.mTitle = TypedArrayUtils.p(obtainStyledAttributes, R$styleable.f10891b1, R$styleable.f10952x0);
        this.mSummary = TypedArrayUtils.p(obtainStyledAttributes, R$styleable.f10888a1, R$styleable.A0);
        this.mOrder = TypedArrayUtils.d(obtainStyledAttributes, R$styleable.V0, R$styleable.B0, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.P0, R$styleable.G0);
        this.mLayoutResId = TypedArrayUtils.n(obtainStyledAttributes, R$styleable.U0, R$styleable.f10950w0, i4);
        this.mWidgetLayoutResId = TypedArrayUtils.n(obtainStyledAttributes, R$styleable.f10894c1, R$styleable.C0, 0);
        this.mEnabled = TypedArrayUtils.b(obtainStyledAttributes, R$styleable.O0, R$styleable.f10948v0, true);
        this.mSelectable = TypedArrayUtils.b(obtainStyledAttributes, R$styleable.X0, R$styleable.f10954y0, true);
        this.mPersistent = TypedArrayUtils.b(obtainStyledAttributes, R$styleable.W0, R$styleable.f10946u0, true);
        this.mDependencyKey = TypedArrayUtils.o(obtainStyledAttributes, R$styleable.M0, R$styleable.D0);
        int i5 = R$styleable.J0;
        this.mAllowDividerAbove = TypedArrayUtils.b(obtainStyledAttributes, i5, i5, this.mSelectable);
        int i6 = R$styleable.K0;
        this.mAllowDividerBelow = TypedArrayUtils.b(obtainStyledAttributes, i6, i6, this.mSelectable);
        int i7 = R$styleable.L0;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i7);
        } else {
            int i8 = R$styleable.E0;
            if (obtainStyledAttributes.hasValue(i8)) {
                this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i8);
            }
        }
        this.mShouldDisableView = TypedArrayUtils.b(obtainStyledAttributes, R$styleable.Y0, R$styleable.F0, true);
        int i9 = R$styleable.Z0;
        boolean hasValue = obtainStyledAttributes.hasValue(i9);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = TypedArrayUtils.b(obtainStyledAttributes, i9, R$styleable.H0, true);
        }
        this.mIconSpaceReserved = TypedArrayUtils.b(obtainStyledAttributes, R$styleable.R0, R$styleable.I0, false);
        int i10 = R$styleable.S0;
        this.mVisible = TypedArrayUtils.b(obtainStyledAttributes, i10, i10, true);
        int i11 = R$styleable.N0;
        this.mCopyingEnabled = TypedArrayUtils.b(obtainStyledAttributes, i11, i11, false);
        obtainStyledAttributes.recycle();
    }

    private void dispatchSetInitialValue() {
        if (getPreferenceDataStore() != null) {
            onSetInitialValue(true, this.mDefaultValue);
        } else if (!shouldPersist() || !getSharedPreferences().contains(this.mKey)) {
            Object obj = this.mDefaultValue;
            if (obj != null) {
                onSetInitialValue(false, obj);
            }
        } else {
            onSetInitialValue(true, (Object) null);
        }
    }

    private void registerDependency() {
        if (!TextUtils.isEmpty(this.mDependencyKey)) {
            Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
            if (findPreferenceInHierarchy != null) {
                findPreferenceInHierarchy.registerDependent(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + this.mTitle + "\"");
        }
    }

    private void registerDependent(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    private void tryCommit(SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.s()) {
            editor.apply();
        }
    }

    private void unregisterDependency() {
        Preference findPreferenceInHierarchy;
        String str = this.mDependencyKey;
        if (str != null && (findPreferenceInHierarchy = findPreferenceInHierarchy(str)) != null) {
            findPreferenceInHierarchy.unregisterDependent(this);
        }
    }

    private void unregisterDependent(Preference preference) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            list.remove(preference);
        }
    }

    /* access modifiers changed from: package-private */
    public void assignParent(PreferenceGroup preferenceGroup) {
        if (preferenceGroup == null || this.mParentGroup == null) {
            this.mParentGroup = preferenceGroup;
            return;
        }
        throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
    }

    public boolean callChangeListener(Object obj) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.mOnChangeListener;
        return onPreferenceChangeListener == null || onPreferenceChangeListener.onPreferenceChange(this, obj);
    }

    /* access modifiers changed from: package-private */
    public final void clearWasDetached() {
        this.mWasDetached = false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.mKey)) != null) {
            this.mBaseMethodCalled = false;
            onRestoreInstanceState(parcelable);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (onSaveInstanceState != null) {
                bundle.putParcelable(this.mKey, onSaveInstanceState);
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T extends Preference> T findPreferenceInHierarchy(String str) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(str);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    /* access modifiers changed from: package-private */
    public StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        int i2;
        if (this.mIcon == null && (i2 = this.mIconResId) != 0) {
            this.mIcon = AppCompatResources.b(this.mContext, i2);
        }
        return this.mIcon;
    }

    /* access modifiers changed from: package-private */
    public long getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    /* access modifiers changed from: protected */
    public boolean getPersistedBoolean(boolean z2) {
        if (!shouldPersist()) {
            return z2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.a(this.mKey, z2);
        }
        return this.mPreferenceManager.j().getBoolean(this.mKey, z2);
    }

    /* access modifiers changed from: protected */
    public float getPersistedFloat(float f2) {
        if (!shouldPersist()) {
            return f2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.b(this.mKey, f2);
        }
        return this.mPreferenceManager.j().getFloat(this.mKey, f2);
    }

    /* access modifiers changed from: protected */
    public int getPersistedInt(int i2) {
        if (!shouldPersist()) {
            return i2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.c(this.mKey, i2);
        }
        return this.mPreferenceManager.j().getInt(this.mKey, i2);
    }

    /* access modifiers changed from: protected */
    public long getPersistedLong(long j2) {
        if (!shouldPersist()) {
            return j2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.d(this.mKey, j2);
        }
        return this.mPreferenceManager.j().getLong(this.mKey, j2);
    }

    /* access modifiers changed from: protected */
    public String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.e(this.mKey, str);
        }
        return this.mPreferenceManager.j().getString(this.mKey, str);
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.f(this.mKey, set);
        }
        return this.mPreferenceManager.j().getStringSet(this.mKey, set);
    }

    public PreferenceDataStore getPreferenceDataStore() {
        PreferenceDataStore preferenceDataStore = this.mPreferenceDataStore;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager != null) {
            return preferenceManager.h();
        }
        return null;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager == null || getPreferenceDataStore() != null) {
            return null;
        }
        return this.mPreferenceManager.j();
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        return this.mSummary;
    }

    public final SummaryProvider getSummaryProvider() {
        return this.mSummaryProvider;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isCopyingEnabled() {
        return this.mCopyingEnabled;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().i()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    /* access modifiers changed from: protected */
    public void notifyChanged() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceChange(this);
        }
    }

    public void notifyDependencyChange(boolean z2) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).onDependencyChanged(this, z2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void notifyHierarchyChanged() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceHierarchyChange(this);
        }
    }

    public void onAttached() {
        registerDependency();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        if (!this.mHasId) {
            this.mId = preferenceManager.d();
        }
        dispatchSetInitialValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.preference.PreferenceViewHolder r9) {
        /*
            r8 = this;
            android.view.View r0 = r9.itemView
            android.view.View$OnClickListener r1 = r8.mClickListener
            r0.setOnClickListener(r1)
            int r1 = r8.mViewId
            r0.setId(r1)
            r1 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r1 = r9.a(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            r3 = 8
            r4 = 0
            if (r1 == 0) goto L_0x0037
            java.lang.CharSequence r5 = r8.getSummary()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0034
            r1.setText(r5)
            r1.setVisibility(r2)
            int r1 = r1.getCurrentTextColor()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0038
        L_0x0034:
            r1.setVisibility(r3)
        L_0x0037:
            r1 = r4
        L_0x0038:
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r9.a(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0075
            java.lang.CharSequence r6 = r8.getTitle()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0072
            r5.setText(r6)
            r5.setVisibility(r2)
            boolean r6 = r8.mHasSingleLineTitleAttr
            if (r6 == 0) goto L_0x005c
            boolean r6 = r8.mSingleLineTitle
            r5.setSingleLine(r6)
        L_0x005c:
            boolean r6 = r8.isSelectable()
            if (r6 != 0) goto L_0x0075
            boolean r6 = r8.isEnabled()
            if (r6 == 0) goto L_0x0075
            if (r1 == 0) goto L_0x0075
            int r1 = r1.intValue()
            r5.setTextColor(r1)
            goto L_0x0075
        L_0x0072:
            r5.setVisibility(r3)
        L_0x0075:
            r1 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r1 = r9.a(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r5 = 4
            if (r1 == 0) goto L_0x00af
            int r6 = r8.mIconResId
            if (r6 != 0) goto L_0x0089
            android.graphics.drawable.Drawable r7 = r8.mIcon
            if (r7 == 0) goto L_0x009c
        L_0x0089:
            android.graphics.drawable.Drawable r7 = r8.mIcon
            if (r7 != 0) goto L_0x0095
            android.content.Context r7 = r8.mContext
            android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.b(r7, r6)
            r8.mIcon = r6
        L_0x0095:
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x009c
            r1.setImageDrawable(r6)
        L_0x009c:
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x00a4
            r1.setVisibility(r2)
            goto L_0x00af
        L_0x00a4:
            boolean r6 = r8.mIconSpaceReserved
            if (r6 == 0) goto L_0x00aa
            r6 = 4
            goto L_0x00ac
        L_0x00aa:
            r6 = 8
        L_0x00ac:
            r1.setVisibility(r6)
        L_0x00af:
            int r1 = androidx.preference.R$id.icon_frame
            android.view.View r1 = r9.a(r1)
            if (r1 != 0) goto L_0x00be
            r1 = 16908350(0x102003e, float:2.3877403E-38)
            android.view.View r1 = r9.a(r1)
        L_0x00be:
            if (r1 == 0) goto L_0x00d0
            android.graphics.drawable.Drawable r6 = r8.mIcon
            if (r6 == 0) goto L_0x00c8
            r1.setVisibility(r2)
            goto L_0x00d0
        L_0x00c8:
            boolean r2 = r8.mIconSpaceReserved
            if (r2 == 0) goto L_0x00cd
            r3 = 4
        L_0x00cd:
            r1.setVisibility(r3)
        L_0x00d0:
            boolean r1 = r8.mShouldDisableView
            if (r1 == 0) goto L_0x00dc
            boolean r1 = r8.isEnabled()
            r8.setEnabledStateOnViews(r0, r1)
            goto L_0x00e0
        L_0x00dc:
            r1 = 1
            r8.setEnabledStateOnViews(r0, r1)
        L_0x00e0:
            boolean r1 = r8.isSelectable()
            r0.setFocusable(r1)
            r0.setClickable(r1)
            boolean r2 = r8.mAllowDividerAbove
            r9.d(r2)
            boolean r2 = r8.mAllowDividerBelow
            r9.e(r2)
            boolean r9 = r8.isCopyingEnabled()
            if (r9 == 0) goto L_0x0105
            androidx.preference.Preference$OnPreferenceCopyListener r2 = r8.mOnCopyListener
            if (r2 != 0) goto L_0x0105
            androidx.preference.Preference$OnPreferenceCopyListener r2 = new androidx.preference.Preference$OnPreferenceCopyListener
            r2.<init>(r8)
            r8.mOnCopyListener = r2
        L_0x0105:
            if (r9 == 0) goto L_0x010a
            androidx.preference.Preference$OnPreferenceCopyListener r2 = r8.mOnCopyListener
            goto L_0x010b
        L_0x010a:
            r2 = r4
        L_0x010b:
            r0.setOnCreateContextMenuListener(r2)
            r0.setLongClickable(r9)
            if (r9 == 0) goto L_0x0118
            if (r1 != 0) goto L_0x0118
            androidx.core.view.ViewCompat.v0(r0, r4)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.onBindViewHolder(androidx.preference.PreferenceViewHolder):void");
    }

    /* access modifiers changed from: protected */
    public void onClick() {
    }

    public void onDependencyChanged(Preference preference, boolean z2) {
        if (this.mDependencyMet == z2) {
            this.mDependencyMet = !z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return null;
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void onParentChanged(Preference preference, boolean z2) {
        if (this.mParentDependencyMet == z2) {
            this.mParentDependencyMet = !z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onPrepareForRemoval() {
        unregisterDependency();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onSetInitialValue(boolean z2, Object obj) {
        onSetInitialValue(obj);
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    /* access modifiers changed from: protected */
    public void performClick(View view) {
        performClick();
    }

    /* access modifiers changed from: protected */
    public boolean persistBoolean(boolean z2) {
        if (!shouldPersist()) {
            return false;
        }
        if (z2 == getPersistedBoolean(!z2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.g(this.mKey, z2);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putBoolean(this.mKey, z2);
            tryCommit(c2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean persistFloat(float f2) {
        if (!shouldPersist()) {
            return false;
        }
        if (f2 == getPersistedFloat(Float.NaN)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.h(this.mKey, f2);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putFloat(this.mKey, f2);
            tryCommit(c2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean persistInt(int i2) {
        if (!shouldPersist()) {
            return false;
        }
        if (i2 == getPersistedInt(~i2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.i(this.mKey, i2);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putInt(this.mKey, i2);
            tryCommit(c2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean persistLong(long j2) {
        if (!shouldPersist()) {
            return false;
        }
        if (j2 == getPersistedLong(~j2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.j(this.mKey, j2);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putLong(this.mKey, j2);
            tryCommit(c2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(str, getPersistedString((String) null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.k(this.mKey, str);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putString(this.mKey, str);
            tryCommit(c2);
        }
        return true;
    }

    public boolean persistStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(getPersistedStringSet((Set<String>) null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.l(this.mKey, set);
        } else {
            SharedPreferences.Editor c2 = this.mPreferenceManager.c();
            c2.putStringSet(this.mKey, set);
            tryCommit(c2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void requireKey() {
        if (!TextUtils.isEmpty(this.mKey)) {
            this.mRequiresKey = true;
            return;
        }
        throw new IllegalStateException("Preference does not have a key assigned.");
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCopyingEnabled(boolean z2) {
        if (this.mCopyingEnabled != z2) {
            this.mCopyingEnabled = z2;
            notifyChanged();
        }
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        unregisterDependency();
        this.mDependencyKey = str;
        registerDependency();
    }

    public void setEnabled(boolean z2) {
        if (this.mEnabled != z2) {
            this.mEnabled = z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            this.mIconResId = 0;
            notifyChanged();
        }
    }

    public void setIconSpaceReserved(boolean z2) {
        if (this.mIconSpaceReserved != z2) {
            this.mIconSpaceReserved = z2;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (this.mRequiresKey && !hasKey()) {
            requireKey();
        }
    }

    public void setLayoutResource(int i2) {
        this.mLayoutResId = i2;
    }

    /* access modifiers changed from: package-private */
    public final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.mListener = onPreferenceChangeInternalListener;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.mOnChangeListener = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.mOnClickListener = onPreferenceClickListener;
    }

    public void setOrder(int i2) {
        if (i2 != this.mOrder) {
            this.mOrder = i2;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z2) {
        this.mPersistent = z2;
    }

    public void setPreferenceDataStore(PreferenceDataStore preferenceDataStore) {
        this.mPreferenceDataStore = preferenceDataStore;
    }

    public void setSelectable(boolean z2) {
        if (this.mSelectable != z2) {
            this.mSelectable = z2;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z2) {
        if (this.mShouldDisableView != z2) {
            this.mShouldDisableView = z2;
            notifyChanged();
        }
    }

    public void setSingleLineTitle(boolean z2) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = z2;
    }

    public void setSummary(CharSequence charSequence) {
        if (getSummaryProvider() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.mSummary, charSequence)) {
            this.mSummary = charSequence;
            notifyChanged();
        }
    }

    public final void setSummaryProvider(SummaryProvider summaryProvider) {
        this.mSummaryProvider = summaryProvider;
        notifyChanged();
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.mTitle != null) || (charSequence != null && !charSequence.equals(this.mTitle))) {
            this.mTitle = charSequence;
            notifyChanged();
        }
    }

    public void setViewId(int i2) {
        this.mViewId = i2;
    }

    public final void setVisible(boolean z2) {
        if (this.mVisible != z2) {
            this.mVisible = z2;
            OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
            if (onPreferenceChangeInternalListener != null) {
                onPreferenceChangeInternalListener.onPreferenceVisibilityChange(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i2) {
        this.mWidgetLayoutResId = i2;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    /* access modifiers changed from: protected */
    public boolean shouldPersist() {
        return this.mPreferenceManager != null && isPersistent() && hasKey();
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean wasDetached() {
        return this.mWasDetached;
    }

    public int compareTo(Preference preference) {
        int i2 = this.mOrder;
        int i3 = preference.mOrder;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener f2;
        if (isEnabled() && isSelectable()) {
            onClick();
            OnPreferenceClickListener onPreferenceClickListener = this.mOnClickListener;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.a(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (f2 = preferenceManager.f()) == null || !f2.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public void setTitle(int i2) {
        setTitle((CharSequence) this.mContext.getString(i2));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHierarchy(PreferenceManager preferenceManager, long j2) {
        this.mId = j2;
        this.mHasId = true;
        try {
            onAttachedToHierarchy(preferenceManager);
        } finally {
            this.mHasId = false;
        }
    }

    public void setIcon(int i2) {
        setIcon(AppCompatResources.b(this.mContext, i2));
        this.mIconResId = i2;
    }

    public void setSummary(int i2) {
        setSummary((CharSequence) this.mContext.getString(i2));
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }
}
