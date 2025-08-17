package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    @Deprecated
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragment.this.bindPreferences();
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
            RecyclerView recyclerView = PreferenceFragment.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };
    private Runnable mSelectPreferenceRunnable;
    private Context mStyledContext;

    private class DividerDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f10826a;

        /* renamed from: b  reason: collision with root package name */
        private int f10827b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10828c = true;

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
            boolean z4 = this.f10828c;
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
                rect.bottom = this.f10827b;
            }
        }

        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f10826a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (m(childAt, recyclerView)) {
                        int y2 = ((int) childAt.getY()) + childAt.getHeight();
                        this.f10826a.setBounds(0, y2, width, this.f10827b + y2);
                        this.f10826a.draw(canvas);
                    }
                }
            }
        }

        public void j(boolean z2) {
            this.f10828c = z2;
        }

        public void k(Drawable drawable) {
            if (drawable != null) {
                this.f10827b = drawable.getIntrinsicHeight();
            } else {
                this.f10827b = 0;
            }
            this.f10826a = drawable;
            PreferenceFragment.this.mList.invalidateItemDecorations();
        }

        public void l(int i2) {
            this.f10827b = i2;
            PreferenceFragment.this.mList.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen);
    }

    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView.Adapter f10830b;

        /* renamed from: c  reason: collision with root package name */
        private final RecyclerView f10831c;

        /* renamed from: d  reason: collision with root package name */
        private final Preference f10832d;

        /* renamed from: e  reason: collision with root package name */
        private final String f10833e;

        ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f10830b = adapter;
            this.f10831c = recyclerView;
            this.f10832d = preference;
            this.f10833e = str;
        }

        private void a() {
            int i2;
            this.f10830b.unregisterAdapterDataObserver(this);
            Preference preference = this.f10832d;
            if (preference != null) {
                i2 = ((PreferenceGroup.PreferencePositionCallback) this.f10830b).getPreferenceAdapterPosition(preference);
            } else {
                i2 = ((PreferenceGroup.PreferencePositionCallback) this.f10830b).getPreferenceAdapterPosition(this.f10833e);
            }
            if (i2 != -1) {
                this.f10831c.scrollToPosition(i2);
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
                RecyclerView.Adapter adapter = PreferenceFragment.this.mList.getAdapter();
                if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                    Preference preference = preference;
                    if (preference != null) {
                        i2 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference);
                    } else {
                        i2 = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                    }
                    if (i2 != -1) {
                        PreferenceFragment.this.mList.scrollToPosition(i2);
                    } else {
                        adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragment.this.mList, preference, str));
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
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    @Deprecated
    public void addPreferencesFromResource(int i2) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.k(this.mStyledContext, i2, getPreferenceScreen()));
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

    @Deprecated
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

    @Deprecated
    public final RecyclerView getListView() {
        return this.mList;
    }

    @Deprecated
    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    @Deprecated
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
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i2);
        this.mStyledContext = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
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
    @Deprecated
    public RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @Deprecated
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Deprecated
    public abstract void onCreatePreferences(Bundle bundle, String str);

    @Deprecated
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.mStyledContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R$id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R$layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.mStyledContext;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.f10897d1, TypedArrayUtils.a(context, R$attr.preferenceFragmentStyle, 16844038), 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R$styleable.f10900e1, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f10903f1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10906g1, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.f10909h1, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.mStyledContext);
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
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
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

    @Deprecated
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
        if (!z2 && getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragment.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragment.newInstance(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragment.newInstance(preference.getKey());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    @Deprecated
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

    @Deprecated
    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z2 = false;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z2 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).a(this, preference);
        }
        if (z2 || !(getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            return z2;
        }
        return ((OnPreferenceStartFragmentCallback) getActivity()).a(this, preference);
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

    @Deprecated
    public void scrollToPreference(String str) {
        scrollToPreferenceInternal((Preference) null, str);
    }

    @Deprecated
    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.k(drawable);
    }

    @Deprecated
    public void setDividerHeight(int i2) {
        this.mDividerDecoration.l(i2);
    }

    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.p(preferenceScreen) && preferenceScreen != null) {
            onUnbindPreferences();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    @Deprecated
    public void setPreferencesFromResource(int i2, String str) {
        requirePreferenceManager();
        PreferenceScreen k2 = this.mPreferenceManager.k(this.mStyledContext, i2, (PreferenceScreen) null);
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

    @Deprecated
    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, (String) null);
    }
}
