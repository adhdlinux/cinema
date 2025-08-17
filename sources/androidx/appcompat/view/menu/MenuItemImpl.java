package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.google.protobuf.CodedOutputStream;

public final class MenuItemImpl implements SupportMenuItem {
    private View A;
    private ActionProvider B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f876a;

    /* renamed from: b  reason: collision with root package name */
    private final int f877b;

    /* renamed from: c  reason: collision with root package name */
    private final int f878c;

    /* renamed from: d  reason: collision with root package name */
    private final int f879d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f880e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f881f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f882g;

    /* renamed from: h  reason: collision with root package name */
    private char f883h;

    /* renamed from: i  reason: collision with root package name */
    private int f884i = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: j  reason: collision with root package name */
    private char f885j;

    /* renamed from: k  reason: collision with root package name */
    private int f886k = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f887l;

    /* renamed from: m  reason: collision with root package name */
    private int f888m = 0;

    /* renamed from: n  reason: collision with root package name */
    MenuBuilder f889n;

    /* renamed from: o  reason: collision with root package name */
    private SubMenuBuilder f890o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f891p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f892q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f893r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f894s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f895t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f896u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f897v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f898w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f899x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f900y = 16;

    /* renamed from: z  reason: collision with root package name */
    private int f901z;

    MenuItemImpl(MenuBuilder menuBuilder, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f889n = menuBuilder;
        this.f876a = i3;
        this.f877b = i2;
        this.f878c = i4;
        this.f879d = i5;
        this.f880e = charSequence;
        this.f901z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f899x && (this.f897v || this.f898w)) {
            drawable = DrawableCompat.r(drawable).mutate();
            if (this.f897v) {
                DrawableCompat.o(drawable, this.f895t);
            }
            if (this.f898w) {
                DrawableCompat.p(drawable, this.f896u);
            }
            this.f899x = false;
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f889n.J() && g() != 0;
    }

    public boolean B() {
        return (this.f901z & 4) == 4;
    }

    public ActionProvider a() {
        return this.B;
    }

    public SupportMenuItem b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.B;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.A = null;
        this.B = actionProvider;
        this.f889n.M(true);
        ActionProvider actionProvider3 = this.B;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z2) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.f889n.L(menuItemImpl);
                }
            });
        }
        return this;
    }

    public void c() {
        this.f889n.K(this);
    }

    public boolean collapseActionView() {
        if ((this.f901z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f889n.f(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f889n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f879d;
    }

    /* access modifiers changed from: package-private */
    public char g() {
        return this.f889n.I() ? this.f885j : this.f883h;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.A = onCreateActionView;
        return onCreateActionView;
    }

    public int getAlphabeticModifiers() {
        return this.f886k;
    }

    public char getAlphabeticShortcut() {
        return this.f885j;
    }

    public CharSequence getContentDescription() {
        return this.f893r;
    }

    public int getGroupId() {
        return this.f877b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f887l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f888m == 0) {
            return null;
        }
        Drawable b2 = AppCompatResources.b(this.f889n.w(), this.f888m);
        this.f888m = 0;
        this.f887l = b2;
        return e(b2);
    }

    public ColorStateList getIconTintList() {
        return this.f895t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f896u;
    }

    public Intent getIntent() {
        return this.f882g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f876a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f884i;
    }

    public char getNumericShortcut() {
        return this.f883h;
    }

    public int getOrder() {
        return this.f878c;
    }

    public SubMenu getSubMenu() {
        return this.f890o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f880e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f881f;
        return charSequence != null ? charSequence : this.f880e;
    }

    public CharSequence getTooltipText() {
        return this.f894s;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        int i2;
        char g2 = g();
        if (g2 == 0) {
            return "";
        }
        Resources resources = this.f889n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f889n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.f227n));
        }
        if (this.f889n.I()) {
            i2 = this.f886k;
        } else {
            i2 = this.f884i;
        }
        d(sb, i2, 65536, resources.getString(R$string.f223j));
        d(sb, i2, CodedOutputStream.DEFAULT_BUFFER_SIZE, resources.getString(R$string.f219f));
        d(sb, i2, 2, resources.getString(R$string.f218e));
        d(sb, i2, 1, resources.getString(R$string.f224k));
        d(sb, i2, 4, resources.getString(R$string.f226m));
        d(sb, i2, 8, resources.getString(R$string.f222i));
        if (g2 == 8) {
            sb.append(resources.getString(R$string.f220g));
        } else if (g2 == 10) {
            sb.append(resources.getString(R$string.f221h));
        } else if (g2 != ' ') {
            sb.append(g2);
        } else {
            sb.append(resources.getString(R$string.f225l));
        }
        return sb.toString();
    }

    public boolean hasSubMenu() {
        return this.f890o != null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i(MenuView.ItemView itemView) {
        if (itemView == null || !itemView.d()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f900y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f900y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f900y & 16) != 0;
    }

    public boolean isVisible() {
        ActionProvider actionProvider = this.B;
        if (actionProvider == null || !actionProvider.overridesItemVisibility()) {
            if ((this.f900y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f900y & 8) != 0 || !this.B.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean j() {
        ActionProvider actionProvider;
        if ((this.f901z & 8) == 0) {
            return false;
        }
        if (this.A == null && (actionProvider = this.B) != null) {
            this.A = actionProvider.onCreateActionView(this);
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f892q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f889n;
        if (menuBuilder.h(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f891p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f882g != null) {
            try {
                this.f889n.w().startActivity(this.f882g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider == null || !actionProvider.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return (this.f900y & 32) == 32;
    }

    public boolean m() {
        return (this.f900y & 4) != 0;
    }

    public boolean n() {
        return (this.f901z & 1) == 1;
    }

    public boolean o() {
        return (this.f901z & 2) == 2;
    }

    /* renamed from: p */
    public SupportMenuItem setActionView(int i2) {
        Context w2 = this.f889n.w();
        setActionView(LayoutInflater.from(w2).inflate(i2, new LinearLayout(w2), false));
        return this;
    }

    /* renamed from: q */
    public SupportMenuItem setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f876a) > 0) {
            view.setId(i2);
        }
        this.f889n.K(this);
        return this;
    }

    public void r(boolean z2) {
        this.D = z2;
        this.f889n.M(false);
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z2) {
        int i2;
        int i3 = this.f900y;
        int i4 = i3 & -3;
        if (z2) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int i5 = i2 | i4;
        this.f900y = i5;
        if (i3 != i5) {
            this.f889n.M(false);
        }
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f885j == c2) {
            return this;
        }
        this.f885j = Character.toLowerCase(c2);
        this.f889n.M(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.f900y;
        boolean z3 = z2 | (i2 & true);
        this.f900y = z3 ? 1 : 0;
        if (i2 != z3) {
            this.f889n.M(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.f900y & 4) != 0) {
            this.f889n.X(this);
        } else {
            s(z2);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f900y |= 16;
        } else {
            this.f900y &= -17;
        }
        this.f889n.M(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f888m = 0;
        this.f887l = drawable;
        this.f899x = true;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f895t = colorStateList;
        this.f897v = true;
        this.f899x = true;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f896u = mode;
        this.f898w = true;
        this.f899x = true;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f882g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.f883h == c2) {
            return this;
        }
        this.f883h = c2;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f892q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f883h = c2;
        this.f885j = Character.toLowerCase(c3);
        this.f889n.M(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.f901z = i2;
            this.f889n.K(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f880e = charSequence;
        this.f889n.M(false);
        SubMenuBuilder subMenuBuilder = this.f890o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f881f = charSequence;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f889n.L(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f900y = (z2 ? 4 : 0) | (this.f900y & -5);
    }

    public String toString() {
        CharSequence charSequence = this.f880e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        if (z2) {
            this.f900y |= 32;
        } else {
            this.f900y &= -33;
        }
    }

    /* access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public SupportMenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(SubMenuBuilder subMenuBuilder) {
        this.f890o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public boolean y(boolean z2) {
        int i2;
        int i3 = this.f900y;
        int i4 = i3 & -9;
        if (z2) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        int i5 = i2 | i4;
        this.f900y = i5;
        if (i3 != i5) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f889n.C();
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f893r = charSequence;
        this.f889n.M(false);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f894s = charSequence;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f885j == c2 && this.f886k == i2) {
            return this;
        }
        this.f885j = Character.toLowerCase(c2);
        this.f886k = KeyEvent.normalizeMetaState(i2);
        this.f889n.M(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f883h == c2 && this.f884i == i2) {
            return this;
        }
        this.f883h = c2;
        this.f884i = KeyEvent.normalizeMetaState(i2);
        this.f889n.M(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f883h = c2;
        this.f884i = KeyEvent.normalizeMetaState(i2);
        this.f885j = Character.toLowerCase(c3);
        this.f886k = KeyEvent.normalizeMetaState(i3);
        this.f889n.M(false);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f887l = null;
        this.f888m = i2;
        this.f899x = true;
        this.f889n.M(false);
        return this;
    }

    public MenuItem setTitle(int i2) {
        return setTitle((CharSequence) this.f889n.w().getString(i2));
    }
}
