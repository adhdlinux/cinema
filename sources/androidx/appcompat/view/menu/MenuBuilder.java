package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements SupportMenu {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f846a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f847b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f848c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f849d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f850e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f851f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f852g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f853h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f854i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f855j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f856k;

    /* renamed from: l  reason: collision with root package name */
    private int f857l = 0;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f858m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f859n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f860o;

    /* renamed from: p  reason: collision with root package name */
    View f861p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f862q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f863r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f864s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f865t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f866u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f867v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f868w = new CopyOnWriteArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private MenuItemImpl f869x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f870y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f871z;

    public interface Callback {
        boolean a(MenuBuilder menuBuilder, MenuItem menuItem);

        void b(MenuBuilder menuBuilder);
    }

    public interface ItemInvoker {
        boolean b(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f846a = context;
        this.f847b = context.getResources();
        this.f851f = new ArrayList<>();
        this.f852g = new ArrayList<>();
        this.f853h = true;
        this.f854i = new ArrayList<>();
        this.f855j = new ArrayList<>();
        this.f856k = true;
        f0(true);
    }

    private static int D(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f851f.size()) {
            this.f851f.remove(i2);
            if (z2) {
                M(true);
            }
        }
    }

    private void a0(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.f861p = view;
            this.f859n = null;
            this.f860o = null;
        } else {
            if (i2 > 0) {
                this.f859n = E.getText(i2);
            } else if (charSequence != null) {
                this.f859n = charSequence;
            }
            if (i3 > 0) {
                this.f860o = ContextCompat.getDrawable(w(), i3);
            } else if (drawable != null) {
                this.f860o = drawable;
            }
            this.f861p = null;
        }
        M(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (androidx.core.view.ViewConfigurationCompat.e(android.view.ViewConfiguration.get(r2.f846a), r2.f846a) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x001c
            android.content.res.Resources r3 = r2.f847b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L_0x001c
            android.content.Context r3 = r2.f846a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f846a
            boolean r3 = androidx.core.view.ViewConfigurationCompat.e(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r2.f849d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.f0(boolean):void");
    }

    private MenuItemImpl g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new MenuItemImpl(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z2) {
        if (!this.f868w.isEmpty()) {
            h0();
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    menuPresenter.h(z2);
                }
            }
            g0();
        }
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f868w.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.d(parcelable);
                    }
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable g2;
        if (!this.f868w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (g2 = menuPresenter.g()) != null) {
                        sparseArray.put(id, g2);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private boolean l(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z2 = false;
        if (this.f868w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z2 = menuPresenter.e(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.f868w.remove(next);
            } else if (!z2) {
                z2 = menuPresenter2.e(subMenuBuilder);
            }
        }
        return z2;
    }

    private static int p(ArrayList<MenuItemImpl> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f861p;
    }

    public ArrayList<MenuItemImpl> B() {
        t();
        return this.f855j;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f865t;
    }

    /* access modifiers changed from: package-private */
    public Resources E() {
        return this.f847b;
    }

    public MenuBuilder F() {
        return this;
    }

    public ArrayList<MenuItemImpl> G() {
        if (!this.f853h) {
            return this.f852g;
        }
        this.f852g.clear();
        int size = this.f851f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i2);
            if (menuItemImpl.isVisible()) {
                this.f852g.add(menuItemImpl);
            }
        }
        this.f853h = false;
        this.f856k = true;
        return this.f852g;
    }

    public boolean H() {
        return this.f870y;
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return this.f848c;
    }

    public boolean J() {
        return this.f849d;
    }

    /* access modifiers changed from: package-private */
    public void K(MenuItemImpl menuItemImpl) {
        this.f856k = true;
        M(true);
    }

    /* access modifiers changed from: package-private */
    public void L(MenuItemImpl menuItemImpl) {
        this.f853h = true;
        M(true);
    }

    public void M(boolean z2) {
        if (!this.f862q) {
            if (z2) {
                this.f853h = true;
                this.f856k = true;
            }
            i(z2);
            return;
        }
        this.f863r = true;
        if (z2) {
            this.f864s = true;
        }
    }

    public boolean N(MenuItem menuItem, int i2) {
        return O(menuItem, (MenuPresenter) null, i2);
    }

    public boolean O(MenuItem menuItem, MenuPresenter menuPresenter, int i2) {
        boolean z2;
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean k2 = menuItemImpl.k();
        ActionProvider a2 = menuItemImpl.a();
        if (a2 == null || !a2.hasSubMenu()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (menuItemImpl.j()) {
            k2 |= menuItemImpl.expandActionView();
            if (k2) {
                e(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.x(new SubMenuBuilder(w(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z2) {
                a2.onPrepareSubMenu(subMenuBuilder);
            }
            k2 |= l(subMenuBuilder, menuPresenter);
            if (!k2) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return k2;
    }

    public void Q(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f868w.remove(next);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(v());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).R(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(Callback callback) {
        this.f850e = callback;
    }

    public MenuBuilder W(int i2) {
        this.f857l = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void X(MenuItem menuItem) {
        boolean z2;
        int groupId = menuItem.getGroupId();
        int size = this.f851f.size();
        h0();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i2);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m() && menuItemImpl.isCheckable()) {
                if (menuItemImpl == menuItem) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                menuItemImpl.s(z2);
            }
        }
        g0();
    }

    /* access modifiers changed from: protected */
    public MenuBuilder Y(int i2) {
        a0(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder Z(Drawable drawable) {
        a0(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int D = D(i4);
        MenuItemImpl g2 = g(i2, i3, i4, D, charSequence, this.f857l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f858m;
        if (contextMenuInfo != null) {
            g2.v(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.f851f;
        arrayList.add(p(arrayList, D), g2);
        M(true);
        return g2;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        Intent intent2;
        int i7;
        PackageManager packageManager = this.f846a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i6 = queryIntentActivityOptions.size();
        } else {
            i6 = 0;
        }
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            if (i9 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i9];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = intent4;
            }
        }
        return i6;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(MenuPresenter menuPresenter) {
        c(menuPresenter, this.f846a);
    }

    /* access modifiers changed from: protected */
    public MenuBuilder b0(int i2) {
        a0(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public void c(MenuPresenter menuPresenter, Context context) {
        this.f868w.add(new WeakReference(menuPresenter));
        menuPresenter.k(context, this);
        this.f856k = true;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder c0(CharSequence charSequence) {
        a0(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.f869x;
        if (menuItemImpl != null) {
            f(menuItemImpl);
        }
        this.f851f.clear();
        M(true);
    }

    public void clearHeader() {
        this.f860o = null;
        this.f859n = null;
        this.f861p = null;
        M(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        Callback callback = this.f850e;
        if (callback != null) {
            callback.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder d0(View view) {
        a0(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public final void e(boolean z2) {
        if (!this.f866u) {
            this.f866u = true;
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    menuPresenter.a(this, z2);
                }
            }
            this.f866u = false;
        }
    }

    public void e0(boolean z2) {
        this.f871z = z2;
    }

    public boolean f(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (!this.f868w.isEmpty() && this.f869x == menuItemImpl) {
            h0();
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    z2 = menuPresenter.j(this, menuItemImpl);
                    if (z2) {
                        break;
                    }
                }
            }
            g0();
            if (z2) {
                this.f869x = null;
            }
        }
        return z2;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i3);
            if (menuItemImpl.getItemId() == i2) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g0() {
        this.f862q = false;
        if (this.f863r) {
            this.f863r = false;
            M(this.f864s);
        }
    }

    public MenuItem getItem(int i2) {
        return this.f851f.get(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean h(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.f850e;
        return callback != null && callback.a(menuBuilder, menuItem);
    }

    public void h0() {
        if (!this.f862q) {
            this.f862q = true;
            this.f863r = false;
            this.f864s = false;
        }
    }

    public boolean hasVisibleItems() {
        if (this.f871z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f851f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return r(i2, keyEvent) != null;
    }

    public boolean m(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (this.f868w.isEmpty()) {
            return false;
        }
        h0();
        Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter = (MenuPresenter) next.get();
            if (menuPresenter == null) {
                this.f868w.remove(next);
            } else {
                z2 = menuPresenter.b(this, menuItemImpl);
                if (z2) {
                    break;
                }
            }
        }
        g0();
        if (z2) {
            this.f869x = menuItemImpl;
        }
        return z2;
    }

    public int n(int i2) {
        return o(i2, 0);
    }

    public int o(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f851f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return N(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        boolean z2;
        MenuItemImpl r2 = r(i2, keyEvent);
        if (r2 != null) {
            z2 = N(r2, i3);
        } else {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            e(true);
        }
        return z2;
    }

    public int q(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f851f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public MenuItemImpl r(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<MenuItemImpl> arrayList = this.f867v;
        arrayList.clear();
        s(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean I = I();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = arrayList.get(i3);
            if (I) {
                c2 = menuItemImpl.getAlphabeticShortcut();
            } else {
                c2 = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (I && c2 == 8 && i2 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public void removeGroup(int i2) {
        int n2 = n(i2);
        if (n2 >= 0) {
            int size = this.f851f.size() - n2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f851f.get(n2).getGroupId() != i2) {
                    M(true);
                } else {
                    P(n2, false);
                    i3 = i4;
                }
            }
            M(true);
        }
    }

    public void removeItem(int i2) {
        P(q(i2), true);
    }

    /* access modifiers changed from: package-private */
    public void s(List<MenuItemImpl> list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean z2;
        boolean I = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f851f.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = this.f851f.get(i4);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).s(list, i2, keyEvent);
                }
                if (I) {
                    c2 = menuItemImpl.getAlphabeticShortcut();
                } else {
                    c2 = menuItemImpl.getNumericShortcut();
                }
                if (I) {
                    i3 = menuItemImpl.getAlphabeticModifiers();
                } else {
                    i3 = menuItemImpl.getNumericModifiers();
                }
                if ((modifiers & 69647) == (i3 & 69647)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (I && c2 == 8 && i2 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f851f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.t(z3);
                menuItemImpl.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.f870y = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f851f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f851f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f851f.get(i3);
            if (menuItemImpl.getGroupId() == i2 && menuItemImpl.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            M(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f848c = z2;
        M(false);
    }

    public int size() {
        return this.f851f.size();
    }

    public void t() {
        ArrayList<MenuItemImpl> G = G();
        if (this.f856k) {
            Iterator<WeakReference<MenuPresenter>> it2 = this.f868w.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f868w.remove(next);
                } else {
                    z2 |= menuPresenter.i();
                }
            }
            if (z2) {
                this.f854i.clear();
                this.f855j.clear();
                int size = G.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = G.get(i2);
                    if (menuItemImpl.l()) {
                        this.f854i.add(menuItemImpl);
                    } else {
                        this.f855j.add(menuItemImpl);
                    }
                }
            } else {
                this.f854i.clear();
                this.f855j.clear();
                this.f855j.addAll(G());
            }
            this.f856k = false;
        }
    }

    public ArrayList<MenuItemImpl> u() {
        t();
        return this.f854i;
    }

    /* access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f846a;
    }

    public MenuItemImpl x() {
        return this.f869x;
    }

    public Drawable y() {
        return this.f860o;
    }

    public CharSequence z() {
        return this.f859n;
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f847b.getString(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f847b.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i2, i3, i4, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f846a, this, menuItemImpl);
        menuItemImpl.x(subMenuBuilder);
        return subMenuBuilder;
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f847b.getString(i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f847b.getString(i5));
    }
}
