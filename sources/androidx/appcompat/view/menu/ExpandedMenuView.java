package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f808d = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private MenuBuilder f809b;

    /* renamed from: c  reason: collision with root package name */
    private int f810c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void a(MenuBuilder menuBuilder) {
        this.f809b = menuBuilder;
    }

    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f809b.N(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return this.f810c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        b((MenuItemImpl) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, f808d, i2, 0);
        if (v2.s(0)) {
            setBackgroundDrawable(v2.g(0));
        }
        if (v2.s(1)) {
            setDivider(v2.g(1));
        }
        v2.w();
    }
}
