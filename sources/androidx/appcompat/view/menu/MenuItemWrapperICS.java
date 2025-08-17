package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final SupportMenuItem f903d;

    /* renamed from: e  reason: collision with root package name */
    private Method f904e;

    private class ActionProviderWrapper extends ActionProvider {

        /* renamed from: a  reason: collision with root package name */
        final android.view.ActionProvider f905a;

        ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f905a = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f905a.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f905a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f905a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f905a.onPrepareSubMenu(MenuItemWrapperICS.this.d(subMenu));
        }
    }

    private class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {

        /* renamed from: c  reason: collision with root package name */
        private ActionProvider.VisibilityListener f907c;

        ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean isVisible() {
            return this.f905a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z2) {
            ActionProvider.VisibilityListener visibilityListener = this.f907c;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z2);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f905a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f905a.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.f905a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            ActionProviderWrapperJB actionProviderWrapperJB;
            this.f907c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f905a;
            if (visibilityListener != null) {
                actionProviderWrapperJB = this;
            } else {
                actionProviderWrapperJB = null;
            }
            actionProvider.setVisibilityListener(actionProviderWrapperJB);
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* renamed from: b  reason: collision with root package name */
        final android.view.CollapsibleActionView f909b;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f909b = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f909b;
        }

        public void onActionViewCollapsed() {
            this.f909b.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f909b.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f910a;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f910a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f910a.onMenuItemActionCollapse(MenuItemWrapperICS.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f910a.onMenuItemActionExpand(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f912b;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f912b = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f912b.onMenuItemClick(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.f903d = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f903d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f903d.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider a2 = this.f903d.a();
        if (a2 instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) a2).f905a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f903d.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).a();
        }
        return actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f903d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f903d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f903d.getContentDescription();
    }

    public int getGroupId() {
        return this.f903d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f903d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f903d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f903d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f903d.getIntent();
    }

    public int getItemId() {
        return this.f903d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f903d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f903d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f903d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f903d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f903d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f903d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f903d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f903d.getTooltipText();
    }

    public void h(boolean z2) {
        try {
            if (this.f904e == null) {
                this.f904e = this.f903d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f904e.invoke(this.f903d, new Object[]{Boolean.valueOf(z2)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean hasSubMenu() {
        return this.f903d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f903d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f903d.isCheckable();
    }

    public boolean isChecked() {
        return this.f903d.isChecked();
    }

    public boolean isEnabled() {
        return this.f903d.isEnabled();
    }

    public boolean isVisible() {
        return this.f903d.isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderWrapperJB actionProviderWrapperJB = new ActionProviderWrapperJB(this.f771a, actionProvider);
        SupportMenuItem supportMenuItem = this.f903d;
        if (actionProvider == null) {
            actionProviderWrapperJB = null;
        }
        supportMenuItem.b(actionProviderWrapperJB);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.f903d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f903d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        this.f903d.setCheckable(z2);
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        this.f903d.setChecked(z2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f903d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.f903d.setEnabled(z2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f903d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f903d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f903d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f903d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f903d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        OnActionExpandListenerWrapper onActionExpandListenerWrapper;
        SupportMenuItem supportMenuItem = this.f903d;
        if (onActionExpandListener != null) {
            onActionExpandListenerWrapper = new OnActionExpandListenerWrapper(onActionExpandListener);
        } else {
            onActionExpandListenerWrapper = null;
        }
        supportMenuItem.setOnActionExpandListener(onActionExpandListenerWrapper);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        OnMenuItemClickListenerWrapper onMenuItemClickListenerWrapper;
        SupportMenuItem supportMenuItem = this.f903d;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListenerWrapper = new OnMenuItemClickListenerWrapper(onMenuItemClickListener);
        } else {
            onMenuItemClickListenerWrapper = null;
        }
        supportMenuItem.setOnMenuItemClickListener(onMenuItemClickListenerWrapper);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f903d.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.f903d.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.f903d.setShowAsActionFlags(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f903d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f903d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f903d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        return this.f903d.setVisible(z2);
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f903d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f903d.setIcon(i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f903d.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f903d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f903d.setTitle(i2);
        return this;
    }

    public MenuItem setActionView(int i2) {
        this.f903d.setActionView(i2);
        View actionView = this.f903d.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.f903d.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
