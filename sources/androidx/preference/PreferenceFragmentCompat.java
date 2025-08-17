package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragmentCompat.this.bindPreferences();
            }
        }
    };
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId = R$layout.preference_list_fragment;
    RecyclerView mList;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };
    private Runnable mSelectPreferenceRunnable;

    private class DividerDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f10839a;

        /* renamed from: b  reason: collision with root package name */
        private int f10840b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10841c = true;

        DividerDecoration() {
        }

        private boolean m(View view, RecyclerView recyclerView) {
            boolean z2;
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z3 = false;
            if (!(childViewHolder instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder).c()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return false;
            }
            boolean z4 = this.f10841c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z4;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            if ((childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).b()) {
                z3 = true;
            }
            return z3;
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (m(view, recyclerView)) {
                rect.bottom = this.f10840b;
            }
        }

        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f10839a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (m(childAt, recyclerView)) {
                        int y2 = ((int) childAt.getY()) + childAt.getHeight();
                        this.f10839a.setBounds(0, y2, width, this.f10840b + y2);
                        this.f10839a.draw(canvas);
                    }
                }
            }
        }

        public void j(boolean z2) {
            this.f10841c = z2;
        }

        public void k(Drawable drawable) {
            if (drawable != null) {
                this.f10840b = drawable.getIntrinsicHeight();
            } else {
                this.f10840b = 0;
            }
            this.f10839a = drawable;
            PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
        }

        public void l(int i2) {
            this.f10840b = i2;
            PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
    }

    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView.Adapter f10843b;

        /* renamed from: c  reason: collision with root package name */
        private final RecyclerView f10844c;

        /* renamed from: d  reason: collision with root package name */
        private final Preference f10845d;

        /* renamed from: e  reason: collision with root package name */
        private final String f10846e;

        public ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f10843b = adapter;
            this.f10844c = recyclerView;
            this.f10845d = preference;
            this.f10846e = str;
        }

        private void a() {
            int i2;
            this.f10843b.unregisterAdapterDataObserver(this);
            Preference preference = this.f10845d;
            if (preference != null) {
                i2 = ((PreferenceGroup.PreferencePositionCallback) this.f10843b).getPreferenceAdapterPosition(preference);
            } else {
                i2 = ((PreferenceGroup.PreferencePositionCallback) this.f10843b).getPreferenceAdapterPosition(this.f10846e);
            }
            if (i2 != -1) {
                this.f10844c.scrollToPosition(i2);
            }
        }

        public void onChanged() {
            a();
        }

        public void onItemRangeChanged(int i2, int i3) {
            a();
        }

        public void onItemRangeInserted(int i2, int i3) {
            a();
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
            a();
        }

        public void onItemRangeRemoved(int i2, int i3) {
            a();
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            a();
        }
    }

    private void postBindPreferences() {
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.obtainMessage(1).sendToTarget();
        }
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(final Preference preference, final String str) {
        AnonymousClass3 r02 = new Runnable() {
            public void run() {
                int i2;
                RecyclerView.Adapter adapter = PreferenceFragmentCompat.this.mList.getAdapter();
                if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                    Preference preference = preference;
                    if (preference != null) {
                        i2 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference);
                    } else {
                        i2 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                    }
                    if (i2 != -1) {
                        PreferenceFragmentCompat.this.mList.scrollToPosition(i2);
                    } else {
                        adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragmentCompat.this.mList, preference, str));
                    }
                } else if (adapter != null) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
            }
        };
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = r02;
        } else {
            r02.run();
        }
    }

    private void unbindPreferences() {
        getListView().setAdapter((RecyclerView.Adapter) null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    public void addPreferencesFromResource(int i2) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.k(getContext(), i2, getPreferenceScreen()));
    }

    /* access modifiers changed from: package-private */
    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    public <T extends Preference> T findPreference(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.i();
    }

    /* access modifiers changed from: protected */
    public void onBindPreferences() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R$style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i2, false);
        PreferenceManager preferenceManager = new PreferenceManager(getContext());
        this.mPreferenceManager = preferenceManager;
        preferenceManager.n(this);
        if (getArguments() != null) {
            str = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    /* access modifiers changed from: protected */
    public RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R$id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R$layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.f10912i1, R$attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R$styleable.f10915j1, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f10918k1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10921l1, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.f10924m1, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(getContext());
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
            if (onCreateRecyclerView != null) {
                this.mList = onCreateRecyclerView;
                onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                setDivider(drawable);
                if (dimensionPixelSize != -1) {
                    setDividerHeight(dimensionPixelSize);
                }
                this.mDividerDecoration.j(z2);
                if (this.mList.getParent() == null) {
                    viewGroup2.addView(this.mList);
                }
                this.mHandler.post(this.mRequestFocus);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        boolean z2;
        DialogFragment dialogFragment;
        if (getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback) {
            z2 = ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).a(this, preference);
        } else {
            z2 = false;
        }
        if (!z2 && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            z2 = ((OnPreferenceDisplayDialogCallback) getActivity()).a(this, preference);
        }
        if (!z2 && getParentFragmentManager().i0(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean z2;
        if (getCallbackFragment() instanceof OnPreferenceStartScreenCallback) {
            z2 = ((OnPreferenceStartScreenCallback) getCallbackFragment()).a(this, preferenceScreen);
        } else {
            z2 = false;
        }
        if (!z2 && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).a(this, preferenceScreen);
        }
    }

    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z2;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z2 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        } else {
            z2 = false;
        }
        if (!z2 && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            z2 = ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
        }
        if (z2) {
            return true;
        }
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment a2 = supportFragmentManager.r0().a(requireActivity().getClassLoader(), preference.getFragment());
        a2.setArguments(extras);
        a2.setTargetFragment(this, 0);
        supportFragmentManager.n().p(((View) getView().getParent()).getId(), a2).g((String) null).h();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.mPreferenceManager.o(this);
        this.mPreferenceManager.m(this);
    }

    public void onStop() {
        super.onStop();
        this.mPreferenceManager.o((PreferenceManager.OnPreferenceTreeClickListener) null);
        this.mPreferenceManager.m((PreferenceManager.OnDisplayPreferenceDialogListener) null);
    }

    /* access modifiers changed from: protected */
    public void onUnbindPreferences() {
    }

    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle(PREFERENCES_TAG)) == null || (preferenceScreen = getPreferenceScreen()) == null)) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        scrollToPreferenceInternal((Preference) null, str);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.k(drawable);
    }

    public void setDividerHeight(int i2) {
        this.mDividerDecoration.l(i2);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.p(preferenceScreen) && preferenceScreen != null) {
            onUnbindPreferences();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public void setPreferencesFromResource(int i2, String str) {
        requirePreferenceManager();
        PreferenceScreen k2 = this.mPreferenceManager.k(getContext(), i2, (PreferenceScreen) null);
        Object obj = k2;
        if (str != null) {
            Object findPreference = k2.findPreference(str);
            boolean z2 = findPreference instanceof PreferenceScreen;
            obj = findPreference;
            if (!z2) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen((PreferenceScreen) obj);
    }

    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, (String) null);
    }
}
