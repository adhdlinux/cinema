package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

public abstract class ConstraintHelper extends View {

    /* renamed from: b  reason: collision with root package name */
    protected int[] f1990b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    protected int f1991c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f1992d;

    /* renamed from: e  reason: collision with root package name */
    protected Helper f1993e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f1994f = false;

    /* renamed from: g  reason: collision with root package name */
    private String f1995g;

    public ConstraintHelper(Context context) {
        super(context);
        this.f1992d = context;
        b((AttributeSet) null);
    }

    private void a(String str) {
        int i2;
        Object c2;
        if (str != null && this.f1992d != null) {
            String trim = str.trim();
            try {
                i2 = R$id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = this.f1992d.getResources().getIdentifier(trim, "id", this.f1992d.getPackageName());
            }
            if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
                i2 = ((Integer) c2).intValue();
            }
            if (i2 != 0) {
                setTag(i2, (Object) null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i2 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f2124a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.f2151j) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1995g = string;
                    setIds(string);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void e(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1995g);
        }
        Helper helper = this.f1993e;
        if (helper != null) {
            helper.J0();
            for (int i2 = 0; i2 < this.f1991c; i2++) {
                View e2 = constraintLayout.e(this.f1990b[i2]);
                if (e2 != null) {
                    this.f1993e.I0(constraintLayout.f(e2));
                }
            }
        }
    }

    public void f() {
        if (this.f1993e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f2039l0 = this.f1993e;
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1990b, this.f1991c);
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1994f) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1991c = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i2, Object obj) {
        int i3 = this.f1991c + 1;
        int[] iArr = this.f1990b;
        if (i3 > iArr.length) {
            this.f1990b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1990b;
        int i4 = this.f1991c;
        iArr2[i4] = i2;
        this.f1991c = i4 + 1;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1992d = context;
        b(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1992d = context;
        b(attributeSet);
    }
}
