package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: q0  reason: collision with root package name */
    static final PreQAutoCompleteTextViewReflector f1376q0 = (Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null);
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    private OnQueryTextListener L;
    View.OnFocusChangeListener M;
    private OnSuggestionListener N;
    private View.OnClickListener O;
    private boolean P;
    private boolean Q;
    CursorAdapter R;
    private boolean S;
    private CharSequence T;
    private boolean U;
    private boolean V;
    private int W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f1377a0;

    /* renamed from: b0  reason: collision with root package name */
    private CharSequence f1378b0;

    /* renamed from: c0  reason: collision with root package name */
    private CharSequence f1379c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f1380d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f1381e0;

    /* renamed from: f0  reason: collision with root package name */
    SearchableInfo f1382f0;

    /* renamed from: g0  reason: collision with root package name */
    private Bundle f1383g0;

    /* renamed from: h0  reason: collision with root package name */
    private final Runnable f1384h0;

    /* renamed from: i0  reason: collision with root package name */
    private Runnable f1385i0;

    /* renamed from: j0  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1386j0;

    /* renamed from: k0  reason: collision with root package name */
    private final View.OnClickListener f1387k0;

    /* renamed from: l0  reason: collision with root package name */
    View.OnKeyListener f1388l0;

    /* renamed from: m0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f1389m0;

    /* renamed from: n0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f1390n0;

    /* renamed from: o0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1391o0;

    /* renamed from: p0  reason: collision with root package name */
    private TextWatcher f1392p0;

    /* renamed from: q  reason: collision with root package name */
    final SearchAutoComplete f1393q;

    /* renamed from: r  reason: collision with root package name */
    private final View f1394r;

    /* renamed from: s  reason: collision with root package name */
    private final View f1395s;

    /* renamed from: t  reason: collision with root package name */
    private final View f1396t;

    /* renamed from: u  reason: collision with root package name */
    final ImageView f1397u;

    /* renamed from: v  reason: collision with root package name */
    final ImageView f1398v;

    /* renamed from: w  reason: collision with root package name */
    final ImageView f1399w;

    /* renamed from: x  reason: collision with root package name */
    final ImageView f1400x;

    /* renamed from: y  reason: collision with root package name */
    private final View f1401y;

    /* renamed from: z  reason: collision with root package name */
    private UpdatableTouchDelegate f1402z;

    static class Api29Impl {
        private Api29Impl() {
        }

        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i2) {
            searchAutoComplete.setInputMethodMode(i2);
        }
    }

    public interface OnCloseListener {
    }

    public interface OnQueryTextListener {
        boolean a(String str);

        boolean b(String str);
    }

    public interface OnSuggestionListener {
        boolean f(int i2);

        boolean i(int i2);
    }

    private static class PreQAutoCompleteTextViewReflector {

        /* renamed from: a  reason: collision with root package name */
        private Method f1413a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f1414b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f1415c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        PreQAutoCompleteTextViewReflector() {
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            d();
            try {
                Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1413a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1414b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1415c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1414b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1413a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1415c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        boolean f1416d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1416d + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f1416d));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1416d = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: f  reason: collision with root package name */
        private int f1417f;

        /* renamed from: g  reason: collision with root package name */
        private SearchView f1418g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1419h;

        /* renamed from: i  reason: collision with root package name */
        final Runnable f1420i;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.f105p);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return UserVerificationMethods.USER_VERIFY_HANDPRINT;
            }
            if (i2 >= 600) {
                return JfifUtil.MARKER_SOFn;
            }
            if (i2 < 640 || i3 < 480) {
                return 160;
            }
            return JfifUtil.MARKER_SOFn;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1376q0.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f1419h) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1419h = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f1417f <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1419h) {
                removeCallbacks(this.f1420i);
                post(this.f1420i);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z2, int i2, Rect rect) {
            super.onFocusChanged(z2, i2, rect);
            this.f1418g.X();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1418g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        public void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f1418g.hasFocus() && getVisibility() == 0) {
                this.f1419h = true;
                if (SearchView.K(getContext())) {
                    b();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f1419h = false;
                removeCallbacks(this.f1420i);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1419h = false;
                removeCallbacks(this.f1420i);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1419h = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1418g = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1417f = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f1420i = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.d();
                }
            };
            this.f1417f = getThreshold();
        }
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1422a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f1423b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1424c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1425d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f1426e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1427f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1426e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1422a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1423b.set(rect);
            this.f1425d.set(rect);
            Rect rect3 = this.f1425d;
            int i2 = this.f1426e;
            rect3.inset(-i2, -i2);
            this.f1424c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0032
                if (r2 == r5) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f1427f
                r7.f1427f = r4
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f1427f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f1425d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r5 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r5 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f1423b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f1427f = r5
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r5 = 0
            L_0x003f:
                if (r5 == 0) goto L_0x0072
                if (r2 == 0) goto L_0x005f
                android.graphics.Rect r2 = r7.f1424c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005f
                android.view.View r0 = r7.f1422a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1422a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x006c
            L_0x005f:
                android.graphics.Rect r2 = r7.f1424c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L_0x006c:
                android.view.View r0 = r7.f1422a
                boolean r4 = r0.dispatchTouchEvent(r8)
            L_0x0072:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    private Intent A(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1379c0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1383g0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1382f0.getSearchActivity());
        return intent;
    }

    private Intent B(Cursor cursor, int i2, String str) {
        int i3;
        Uri uri;
        String n2;
        try {
            String n3 = SuggestionsAdapter.n(cursor, "suggest_intent_action");
            if (n3 == null) {
                n3 = this.f1382f0.getSuggestIntentAction();
            }
            if (n3 == null) {
                n3 = "android.intent.action.SEARCH";
            }
            String str2 = n3;
            String n4 = SuggestionsAdapter.n(cursor, "suggest_intent_data");
            if (n4 == null) {
                n4 = this.f1382f0.getSuggestIntentData();
            }
            if (!(n4 == null || (n2 = SuggestionsAdapter.n(cursor, "suggest_intent_data_id")) == null)) {
                n4 = n4 + "/" + Uri.encode(n2);
            }
            if (n4 == null) {
                uri = null;
            } else {
                uri = Uri.parse(n4);
            }
            return A(str2, uri, SuggestionsAdapter.n(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.n(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent C(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i2;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1383g0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        } else {
            i2 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent D(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private void E() {
        this.f1393q.dismissDropDown();
    }

    private void G(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i2 = iArr[1];
        int[] iArr2 = this.D;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence H(CharSequence charSequence) {
        if (!this.P || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1393q.getTextSize()) * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean I() {
        Intent intent;
        SearchableInfo searchableInfo = this.f1382f0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.f1382f0.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else if (this.f1382f0.getVoiceSearchLaunchRecognizer()) {
            intent = this.J;
        } else {
            intent = null;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    static boolean K(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean L() {
        return (this.S || this.f1377a0) && !J();
    }

    private void M(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.e("SearchView", "Failed launch activity: " + intent, e2);
            }
        }
    }

    private boolean O(int i2, int i3, String str) {
        Cursor c2 = this.R.c();
        if (c2 == null || !c2.moveToPosition(i2)) {
            return false;
        }
        M(B(c2, i3, str));
        return true;
    }

    private void Z() {
        post(this.f1384h0);
    }

    private void a0(int i2) {
        Editable text = this.f1393q.getText();
        Cursor c2 = this.R.c();
        if (c2 != null) {
            if (c2.moveToPosition(i2)) {
                CharSequence convertToString = this.R.convertToString(c2);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    private void c0() {
        int[] iArr;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1393q.getText());
        int i2 = 0;
        if (!z3 && (!this.P || this.f1380d0)) {
            z2 = false;
        }
        ImageView imageView = this.f1399w;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1399w.getDrawable();
        if (drawable != null) {
            if (z3) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    private void e0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1393q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    private void f0() {
        this.f1393q.setThreshold(this.f1382f0.getSuggestThreshold());
        this.f1393q.setImeOptions(this.f1382f0.getImeOptions());
        int inputType = this.f1382f0.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1382f0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | ImageMetadata.LENS_APERTURE;
            }
        }
        this.f1393q.setInputType(inputType);
        CursorAdapter cursorAdapter = this.R;
        if (cursorAdapter != null) {
            cursorAdapter.a((Cursor) null);
        }
        if (this.f1382f0.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.f1382f0, this.f1386j0);
            this.R = suggestionsAdapter;
            this.f1393q.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.R;
            if (this.U) {
                i2 = 2;
            }
            suggestionsAdapter2.w(i2);
        }
    }

    private void g0() {
        int i2;
        if (!L() || !(this.f1398v.getVisibility() == 0 || this.f1400x.getVisibility() == 0)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        this.f1396t.setVisibility(i2);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f131g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f132h);
    }

    private void h0(boolean z2) {
        int i2;
        if (!this.S || !L() || !hasFocus() || (!z2 && this.f1377a0)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        this.f1398v.setVisibility(i2);
    }

    private void i0(boolean z2) {
        int i2;
        int i3;
        this.Q = z2;
        int i4 = 0;
        if (z2) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        boolean z3 = !TextUtils.isEmpty(this.f1393q.getText());
        this.f1397u.setVisibility(i2);
        h0(z3);
        View view = this.f1394r;
        if (z2) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        if (this.E.getDrawable() == null || this.P) {
            i4 = 8;
        }
        this.E.setVisibility(i4);
        c0();
        j0(!z3);
        g0();
    }

    private void j0(boolean z2) {
        int i2 = 8;
        if (this.f1377a0 && !J() && z2) {
            this.f1398v.setVisibility(8);
            i2 = 0;
        }
        this.f1400x.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        int i2;
        this.f1393q.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f1393q;
        if (TextUtils.isEmpty(charSequence)) {
            i2 = 0;
        } else {
            i2 = charSequence.length();
        }
        searchAutoComplete.setSelection(i2);
    }

    /* access modifiers changed from: package-private */
    public void F() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(this.f1393q);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = f1376q0;
        preQAutoCompleteTextViewReflector.b(this.f1393q);
        preQAutoCompleteTextViewReflector.a(this.f1393q);
    }

    public boolean J() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public void N(int i2, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (!TextUtils.isEmpty(this.f1393q.getText())) {
            this.f1393q.setText("");
            this.f1393q.requestFocus();
            this.f1393q.setImeVisibility(true);
        } else if (this.P) {
            clearFocus();
            i0(true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Q(int i2, int i3, String str) {
        OnSuggestionListener onSuggestionListener = this.N;
        if (onSuggestionListener != null && onSuggestionListener.i(i2)) {
            return false;
        }
        O(i2, 0, (String) null);
        this.f1393q.setImeVisibility(false);
        E();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i2) {
        OnSuggestionListener onSuggestionListener = this.N;
        if (onSuggestionListener != null && onSuggestionListener.f(i2)) {
            return false;
        }
        a0(i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        i0(false);
        this.f1393q.requestFocus();
        this.f1393q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        Editable text = this.f1393q.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.L;
            if (onQueryTextListener == null || !onQueryTextListener.b(text.toString())) {
                if (this.f1382f0 != null) {
                    N(0, (String) null, text.toString());
                }
                this.f1393q.setImeVisibility(false);
                E();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean V(View view, int i2, KeyEvent keyEvent) {
        int i3;
        if (this.f1382f0 != null && this.R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return Q(this.f1393q.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                if (i2 == 21) {
                    i3 = 0;
                } else {
                    i3 = this.f1393q.length();
                }
                this.f1393q.setSelection(i3);
                this.f1393q.setListSelection(0);
                this.f1393q.clearListSelection();
                this.f1393q.b();
                return true;
            } else if (i2 == 19) {
                this.f1393q.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void W(CharSequence charSequence) {
        Editable text = this.f1393q.getText();
        this.f1379c0 = text;
        boolean z2 = !TextUtils.isEmpty(text);
        h0(z2);
        j0(!z2);
        c0();
        g0();
        if (this.L != null && !TextUtils.equals(charSequence, this.f1378b0)) {
            this.L.a(charSequence.toString());
        }
        this.f1378b0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void X() {
        i0(J());
        Z();
        if (this.f1393q.hasFocus()) {
            F();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        SearchableInfo searchableInfo = this.f1382f0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(D(this.I, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(C(this.J, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public void b0(CharSequence charSequence, boolean z2) {
        this.f1393q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1393q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1379c0 = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            U();
        }
    }

    public void clearFocus() {
        this.V = true;
        super.clearFocus();
        this.f1393q.clearFocus();
        this.f1393q.setImeVisibility(false);
        this.V = false;
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        int[] iArr;
        if (this.f1393q.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1395s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1396t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f1393q.getImeOptions();
    }

    public int getInputType() {
        return this.f1393q.getInputType();
    }

    public int getMaxWidth() {
        return this.W;
    }

    public CharSequence getQuery() {
        return this.f1393q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1382f0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.K;
        }
        return getContext().getText(this.f1382f0.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.G;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.R;
    }

    public void onActionViewCollapsed() {
        b0("", false);
        clearFocus();
        i0(true);
        this.f1393q.setImeOptions(this.f1381e0);
        this.f1380d0 = false;
    }

    public void onActionViewExpanded() {
        if (!this.f1380d0) {
            this.f1380d0 = true;
            int imeOptions = this.f1393q.getImeOptions();
            this.f1381e0 = imeOptions;
            this.f1393q.setImeOptions(imeOptions | 33554432);
            this.f1393q.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1384h0);
        post(this.f1385i0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            G(this.f1393q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            UpdatableTouchDelegate updatableTouchDelegate = this.f1402z;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.B, this.A, this.f1393q);
                this.f1402z = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.a(this.B, this.A);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (J()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.W;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.W;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.W) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        i0(savedState.f1416d);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1416d = J();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        Z();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.V || !isFocusable()) {
            return false;
        }
        if (J()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.f1393q.requestFocus(i2, rect);
        if (requestFocus) {
            i0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1383g0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.P != z2) {
            this.P = z2;
            i0(z2);
            e0();
        }
    }

    public void setImeOptions(int i2) {
        this.f1393q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1393q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.W = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.L = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.N = onSuggestionListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.T = charSequence;
        e0();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        int i2;
        this.U = z2;
        CursorAdapter cursorAdapter = this.R;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) cursorAdapter;
            if (z2) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            suggestionsAdapter.w(i2);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1382f0 = searchableInfo;
        if (searchableInfo != null) {
            f0();
            e0();
        }
        boolean I2 = I();
        this.f1377a0 = I2;
        if (I2) {
            this.f1393q.setPrivateImeOptions("nm");
        }
        i0(J());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.S = z2;
        i0(J());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.R = cursorAdapter;
        this.f1393q.setAdapter(cursorAdapter);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        int i2;
        int i3;
        if (this.f1401y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1395s.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = ViewUtils.b(this);
            if (this.P) {
                i2 = resources.getDimensionPixelSize(R$dimen.f129e) + resources.getDimensionPixelSize(R$dimen.f130f);
            } else {
                i2 = 0;
            }
            this.f1393q.getDropDownBackground().getPadding(rect);
            if (b2) {
                i3 = -rect.left;
            } else {
                i3 = paddingLeft - (rect.left + i2);
            }
            this.f1393q.setDropDownHorizontalOffset(i3);
            this.f1393q.setDropDownWidth((((this.f1401y.getWidth() + rect.left) + rect.right) + i2) - paddingLeft);
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.N);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f1384h0 = new Runnable() {
            public void run() {
                SearchView.this.d0();
            }
        };
        this.f1385i0 = new Runnable() {
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.R;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.a((Cursor) null);
                }
            }
        };
        this.f1386j0 = new WeakHashMap<>();
        AnonymousClass5 r8 = new View.OnClickListener() {
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.f1397u) {
                    searchView.T();
                } else if (view == searchView.f1399w) {
                    searchView.P();
                } else if (view == searchView.f1398v) {
                    searchView.U();
                } else if (view == searchView.f1400x) {
                    searchView.Y();
                } else if (view == searchView.f1393q) {
                    searchView.F();
                }
            }
        };
        this.f1387k0 = r8;
        this.f1388l0 = new View.OnKeyListener() {
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.f1382f0 == null) {
                    return false;
                }
                if (searchView.f1393q.isPopupShowing() && SearchView.this.f1393q.getListSelection() != -1) {
                    return SearchView.this.V(view, i2, keyEvent);
                }
                if (SearchView.this.f1393q.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.N(0, (String) null, searchView2.f1393q.getText().toString());
                return true;
            }
        };
        AnonymousClass7 r9 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.U();
                return true;
            }
        };
        this.f1389m0 = r9;
        AnonymousClass8 r10 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.Q(i2, 0, (String) null);
            }
        };
        this.f1390n0 = r10;
        AnonymousClass9 r11 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.R(i2);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f1391o0 = r11;
        this.f1392p0 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.W(charSequence);
            }
        };
        int[] iArr = R$styleable.p2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet2, iArr, i3, 0);
        ViewCompat.p0(this, context, iArr, attributeSet2, v2.r(), i3, 0);
        LayoutInflater.from(context).inflate(v2.n(R$styleable.z2, R$layout.f211t), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.J);
        this.f1393q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1394r = findViewById(R$id.F);
        View findViewById = findViewById(R$id.I);
        this.f1395s = findViewById;
        View findViewById2 = findViewById(R$id.P);
        this.f1396t = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.D);
        this.f1397u = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.G);
        this.f1398v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.E);
        this.f1399w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.K);
        this.f1400x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.H);
        this.E = imageView5;
        ViewCompat.v0(findViewById, v2.g(R$styleable.A2));
        ViewCompat.v0(findViewById2, v2.g(R$styleable.E2));
        int i4 = R$styleable.D2;
        imageView.setImageDrawable(v2.g(i4));
        imageView2.setImageDrawable(v2.g(R$styleable.x2));
        imageView3.setImageDrawable(v2.g(R$styleable.u2));
        imageView4.setImageDrawable(v2.g(R$styleable.G2));
        imageView5.setImageDrawable(v2.g(i4));
        this.F = v2.g(R$styleable.C2);
        TooltipCompat.a(imageView, getResources().getString(R$string.f228o));
        this.G = v2.n(R$styleable.F2, R$layout.f210s);
        this.H = v2.n(R$styleable.v2, 0);
        imageView.setOnClickListener(r8);
        imageView3.setOnClickListener(r8);
        imageView2.setOnClickListener(r8);
        imageView4.setOnClickListener(r8);
        searchAutoComplete.setOnClickListener(r8);
        searchAutoComplete.addTextChangedListener(this.f1392p0);
        searchAutoComplete.setOnEditorActionListener(r9);
        searchAutoComplete.setOnItemClickListener(r10);
        searchAutoComplete.setOnItemSelectedListener(r11);
        searchAutoComplete.setOnKeyListener(this.f1388l0);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z2) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.M;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z2);
                }
            }
        });
        setIconifiedByDefault(v2.a(R$styleable.y2, true));
        int f2 = v2.f(R$styleable.r2, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.K = v2.p(R$styleable.w2);
        this.T = v2.p(R$styleable.B2);
        int k2 = v2.k(R$styleable.t2, -1);
        if (k2 != -1) {
            setImeOptions(k2);
        }
        int k3 = v2.k(R$styleable.s2, -1);
        if (k3 != -1) {
            setInputType(k3);
        }
        setFocusable(v2.a(R$styleable.q2, true));
        v2.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1401y = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.z();
                }
            });
        }
        i0(this.P);
        e0();
    }
}
