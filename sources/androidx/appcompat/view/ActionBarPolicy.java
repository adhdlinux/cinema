package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

public class ActionBarPolicy {

    /* renamed from: a  reason: collision with root package name */
    private Context f662a;

    private ActionBarPolicy(Context context) {
        this.f662a = context;
    }

    public static ActionBarPolicy b(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean a() {
        return this.f662a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f662a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f662a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i3 > 720) {
            return 5;
        }
        if (i2 > 720 && i3 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i3 > 480) {
            return 4;
        }
        if (i2 > 480 && i3 > 640) {
            return 4;
        }
        if (i2 >= 360) {
            return 3;
        }
        return 2;
    }

    public int e() {
        return this.f662a.getResources().getDimensionPixelSize(R$dimen.f126b);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f662a.obtainStyledAttributes((AttributeSet) null, R$styleable.f235a, R$attr.f92c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.f262j, 0);
        Resources resources = this.f662a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.f125a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f662a.getResources().getBoolean(R$bool.f116a);
    }

    public boolean h() {
        return true;
    }
}
