package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private int A = -1;

    /* renamed from: n  reason: collision with root package name */
    private final SearchView f1428n;

    /* renamed from: o  reason: collision with root package name */
    private final SearchableInfo f1429o;

    /* renamed from: p  reason: collision with root package name */
    private final Context f1430p;

    /* renamed from: q  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1431q;

    /* renamed from: r  reason: collision with root package name */
    private final int f1432r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1433s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f1434t = 1;

    /* renamed from: u  reason: collision with root package name */
    private ColorStateList f1435u;

    /* renamed from: v  reason: collision with root package name */
    private int f1436v = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f1437w = -1;

    /* renamed from: x  reason: collision with root package name */
    private int f1438x = -1;

    /* renamed from: y  reason: collision with root package name */
    private int f1439y = -1;

    /* renamed from: z  reason: collision with root package name */
    private int f1440z = -1;

    private static final class ChildViewCache {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1441a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1442b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1443c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1444d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1445e;

        public ChildViewCache(View view) {
            this.f1441a = (TextView) view.findViewById(16908308);
            this.f1442b = (TextView) view.findViewById(16908309);
            this.f1443c = (ImageView) view.findViewById(16908295);
            this.f1444d = (ImageView) view.findViewById(16908296);
            this.f1445e = (ImageView) view.findViewById(R$id.f184s);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1428n = searchView;
        this.f1429o = searchableInfo;
        this.f1432r = searchView.getSuggestionCommitIconResId();
        this.f1430p = context;
        this.f1431q = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f1431q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f1435u == null) {
            TypedValue typedValue = new TypedValue();
            this.f1430p.getTheme().resolveAttribute(R$attr.S, typedValue, true);
            this.f1435u = this.f1430p.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1435u, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) {
        PackageManager packageManager = this.f1430p.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable m(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1431q.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1431q.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1430p.getResources());
        }
        Drawable l2 = l(componentName);
        if (l2 != null) {
            constantState = l2.getConstantState();
        }
        this.f1431q.put(flattenToShortString, constantState);
        return l2;
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() {
        Drawable m2 = m(this.f1429o.getSearchActivity());
        if (m2 != null) {
            return m2;
        }
        return this.f1430p.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable p(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.q(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1430p     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.p(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable r(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1430p.getPackageName() + "/" + parseInt;
            Drawable j2 = j(str2);
            if (j2 != null) {
                return j2;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f1430p, parseInt);
            z(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable j3 = j(str);
            if (j3 != null) {
                return j3;
            }
            Drawable p2 = p(Uri.parse(str));
            z(str, p2);
            return p2;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable s(Cursor cursor) {
        int i2 = this.f1439y;
        if (i2 == -1) {
            return null;
        }
        Drawable r2 = r(cursor.getString(i2));
        if (r2 != null) {
            return r2;
        }
        return o();
    }

    private Drawable t(Cursor cursor) {
        int i2 = this.f1440z;
        if (i2 == -1) {
            return null;
        }
        return r(cursor.getString(i2));
    }

    private static String v(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1431q.put(str, drawable.getConstantState());
        }
    }

    public void a(Cursor cursor) {
        if (this.f1433s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1436v = cursor.getColumnIndex("suggest_text_1");
                this.f1437w = cursor.getColumnIndex("suggest_text_2");
                this.f1438x = cursor.getColumnIndex("suggest_text_2_url");
                this.f1439y = cursor.getColumnIndex("suggest_icon_1");
                this.f1440z = cursor.getColumnIndex("suggest_icon_2");
                this.A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    public Cursor b(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        if (this.f1428n.getVisibility() == 0 && this.f1428n.getWindowVisibility() == 0) {
            try {
                Cursor u2 = u(this.f1429o, str, 50);
                if (u2 != null) {
                    u2.getCount();
                    return u2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    public CharSequence convertToString(Cursor cursor) {
        String n2;
        String n3;
        if (cursor == null) {
            return null;
        }
        String n4 = n(cursor, "suggest_intent_query");
        if (n4 != null) {
            return n4;
        }
        if (this.f1429o.shouldRewriteQueryFromData() && (n3 = n(cursor, "suggest_intent_data")) != null) {
            return n3;
        }
        if (!this.f1429o.shouldRewriteQueryFromText() || (n2 = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return n2;
    }

    public void d(View view, Context context, Cursor cursor) {
        int i2;
        CharSequence charSequence;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i3 = this.A;
        if (i3 != -1) {
            i2 = cursor.getInt(i3);
        } else {
            i2 = 0;
        }
        if (childViewCache.f1441a != null) {
            y(childViewCache.f1441a, v(cursor, this.f1436v));
        }
        if (childViewCache.f1442b != null) {
            String v2 = v(cursor, this.f1438x);
            if (v2 != null) {
                charSequence = k(v2);
            } else {
                charSequence = v(cursor, this.f1437w);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = childViewCache.f1441a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.f1441a.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.f1441a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.f1441a.setMaxLines(1);
                }
            }
            y(childViewCache.f1442b, charSequence);
        }
        ImageView imageView = childViewCache.f1443c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = childViewCache.f1444d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i4 = this.f1434t;
        if (i4 == 2 || (i4 == 1 && (i2 & 1) != 0)) {
            childViewCache.f1445e.setVisibility(0);
            childViewCache.f1445e.setTag(childViewCache.f1441a.getText());
            childViewCache.f1445e.setOnClickListener(this);
            return;
        }
        childViewCache.f1445e.setVisibility(8);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View g2 = super.g(context, cursor, viewGroup);
        g2.setTag(new ChildViewCache(g2));
        ((ImageView) g2.findViewById(R$id.f184s)).setImageResource(this.f1432r);
        return g2;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View f2 = f(this.f1430p, c(), viewGroup);
            if (f2 != null) {
                ((ChildViewCache) f2.getTag()).f1441a.setText(e2.toString());
            }
            return f2;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View g2 = g(this.f1430p, c(), viewGroup);
            if (g2 != null) {
                ((ChildViewCache) g2.getTag()).f1441a.setText(e2.toString());
            }
            return g2;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(c());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(c());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1428n.S((CharSequence) tag);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable q(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1430p.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    public Cursor u(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f1430p.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void w(int i2) {
        this.f1434t = i2;
    }
}
