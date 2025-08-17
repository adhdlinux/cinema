package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.google.protobuf.CodedOutputStream;

public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a  reason: collision with root package name */
    private final int f729a;

    /* renamed from: b  reason: collision with root package name */
    private final int f730b;

    /* renamed from: c  reason: collision with root package name */
    private final int f731c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f732d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f733e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f734f;

    /* renamed from: g  reason: collision with root package name */
    private char f735g;

    /* renamed from: h  reason: collision with root package name */
    private int f736h = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: i  reason: collision with root package name */
    private char f737i;

    /* renamed from: j  reason: collision with root package name */
    private int f738j = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f739k;

    /* renamed from: l  reason: collision with root package name */
    private Context f740l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f741m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f742n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f743o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f744p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f745q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f746r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f747s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f748t = 16;

    public ActionMenuItem(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f740l = context;
        this.f729a = i3;
        this.f730b = i2;
        this.f731c = i5;
        this.f732d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f739k;
        if (drawable == null) {
            return;
        }
        if (this.f746r || this.f747s) {
            Drawable r2 = DrawableCompat.r(drawable);
            this.f739k = r2;
            Drawable mutate = r2.mutate();
            this.f739k = mutate;
            if (this.f746r) {
                DrawableCompat.o(mutate, this.f744p);
            }
            if (this.f747s) {
                DrawableCompat.p(this.f739k, this.f745q);
            }
        }
    }

    public ActionProvider a() {
        return null;
    }

    public SupportMenuItem b(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public boolean collapseActionView() {
        return false;
    }

    /* renamed from: d */
    public SupportMenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    /* renamed from: f */
    public SupportMenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f738j;
    }

    public char getAlphabeticShortcut() {
        return this.f737i;
    }

    public CharSequence getContentDescription() {
        return this.f742n;
    }

    public int getGroupId() {
        return this.f730b;
    }

    public Drawable getIcon() {
        return this.f739k;
    }

    public ColorStateList getIconTintList() {
        return this.f744p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f745q;
    }

    public Intent getIntent() {
        return this.f734f;
    }

    public int getItemId() {
        return this.f729a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f736h;
    }

    public char getNumericShortcut() {
        return this.f735g;
    }

    public int getOrder() {
        return this.f731c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f732d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f733e;
        return charSequence != null ? charSequence : this.f732d;
    }

    public CharSequence getTooltipText() {
        return this.f743o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f748t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f748t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f748t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f748t & 8) == 0;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f737i = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        this.f748t = z2 | (this.f748t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        this.f748t = (z2 ? 2 : 0) | (this.f748t & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.f748t = (z2 ? 16 : 0) | (this.f748t & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f739k = drawable;
        c();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f744p = colorStateList;
        this.f746r = true;
        c();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f745q = mode;
        this.f747s = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f734f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f735g = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f741m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f735g = c2;
        this.f737i = Character.toLowerCase(c3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f732d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f733e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        int i2 = 8;
        int i3 = this.f748t & 8;
        if (z2) {
            i2 = 0;
        }
        this.f748t = i3 | i2;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f737i = Character.toLowerCase(c2);
        this.f738j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f742n = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f735g = c2;
        this.f736h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f732d = this.f740l.getResources().getString(i2);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f743o = charSequence;
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f739k = ContextCompat.getDrawable(this.f740l, i2);
        c();
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f735g = c2;
        this.f736h = KeyEvent.normalizeMetaState(i2);
        this.f737i = Character.toLowerCase(c3);
        this.f738j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}
