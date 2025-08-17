package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate {
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Rect f29672s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f29673t = {16842913};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ChipDrawable f29674f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f29675g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f29676h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f29677i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f29678j;

    /* renamed from: k  reason: collision with root package name */
    private int f29679k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29680l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f29681m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f29682n;

    /* renamed from: o  reason: collision with root package name */
    private final ChipTouchHelper f29683o;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f29684p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private final RectF f29685q = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private final ResourcesCompat.FontCallback f29686r = new ResourcesCompat.FontCallback() {
        public void h(int i2) {
        }

        public void i(Typeface typeface) {
            Chip chip = Chip.this;
            chip.setText(chip.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    };

    private class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f2, float f3) {
            return (!Chip.this.l() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? -1 : 0;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            if (Chip.this.l()) {
                list.add(0);
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (i3 == 16 && i2 == 0) {
                return Chip.this.o();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z2;
            if (Chip.this.f29674f == null || !Chip.this.f29674f.c0()) {
                z2 = false;
            } else {
                z2 = true;
            }
            accessibilityNodeInfoCompat.a0(z2);
            accessibilityNodeInfoCompat.c0(Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.F0(text);
            } else {
                accessibilityNodeInfoCompat.g0(text);
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (Chip.this.l()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.g0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    accessibilityNodeInfoCompat.g0(context.getString(i3, objArr).trim());
                }
                accessibilityNodeInfoCompat.X(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2861i);
                accessibilityNodeInfoCompat.j0(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.g0(charSequence);
            accessibilityNodeInfoCompat.X(Chip.f29672s);
        }
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s(attributeSet);
        ChipDrawable n2 = ChipDrawable.n(context, attributeSet, i2, R$style.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(n2);
        ChipTouchHelper chipTouchHelper = new ChipTouchHelper(this);
        this.f29683o = chipTouchHelper;
        ViewCompat.r0(this, chipTouchHelper);
        m();
        setChecked(this.f29678j);
        n2.o1(false);
        setText(n2.V());
        setEllipsize(n2.P());
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            r(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        q();
    }

    private void g(ChipDrawable chipDrawable) {
        chipDrawable.d1(this);
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f29685q.setEmpty();
        if (l()) {
            this.f29674f.O(this.f29685q);
        }
        return this.f29685q;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f29684p.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f29684p;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.W();
        }
        return null;
    }

    private float h(ChipDrawable chipDrawable) {
        float chipStartPadding = getChipStartPadding() + chipDrawable.d() + getTextStartPadding();
        if (ViewCompat.D(this) == 0) {
            return chipStartPadding;
        }
        return -chipStartPadding;
    }

    private int[] i() {
        int isEnabled = isEnabled();
        if (this.f29682n) {
            isEnabled++;
        }
        if (this.f29681m) {
            isEnabled++;
        }
        if (this.f29680l) {
            isEnabled++;
        }
        if (isChecked()) {
            isEnabled++;
        }
        int[] iArr = new int[isEnabled];
        int i2 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.f29682n) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.f29681m) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f29680l) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void j() {
        if (this.f29679k == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean k(MotionEvent motionEvent) {
        Class<ExploreByTouchHelper> cls = ExploreByTouchHelper.class;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = cls.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f29683o)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = cls.getDeclaredMethod("updateHoveredVirtualView", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f29683o, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (NoSuchMethodException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (IllegalAccessException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (NoSuchFieldException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean l() {
        ChipDrawable chipDrawable = this.f29674f;
        return (chipDrawable == null || chipDrawable.H() == null) ? false : true;
    }

    private void m() {
        setOutlineProvider(new ViewOutlineProvider() {
            @TargetApi(21)
            public void getOutline(View view, Outline outline) {
                if (Chip.this.f29674f != null) {
                    Chip.this.f29674f.getOutline(outline);
                } else {
                    outline.setAlpha(0.0f);
                }
            }
        });
    }

    private boolean n(boolean z2) {
        j();
        if (z2) {
            if (this.f29679k == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.f29679k == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    private void p(ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.d1((ChipDrawable.Delegate) null);
        }
    }

    private void q() {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable = this.f29674f) != null) {
            float E = chipDrawable.E() + this.f29674f.z() + this.f29674f.Y() + this.f29674f.X();
            if ((this.f29674f.e0() && this.f29674f.A() != null) || (this.f29674f.w() != null && this.f29674f.d0() && isChecked())) {
                E += this.f29674f.S() + this.f29674f.R() + this.f29674f.B();
            }
            if (this.f29674f.g0() && this.f29674f.H() != null) {
                E += this.f29674f.L() + this.f29674f.J() + this.f29674f.K();
            }
            if (((float) ViewCompat.H(this)) != E) {
                ViewCompat.H0(this, ViewCompat.I(this), getPaddingTop(), (int) E, getPaddingBottom());
            }
        }
    }

    private void r(TextAppearance textAppearance) {
        TextPaint paint = getPaint();
        paint.drawableState = this.f29674f.getState();
        textAppearance.g(getContext(), paint, this.f29686r);
    }

    private void s(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", AppStateModule.APP_STATE_BACKGROUND) != null) {
                throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    private void setCloseIconFocused(boolean z2) {
        if (this.f29682n != z2) {
            this.f29682n = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f29681m != z2) {
            this.f29681m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f29680l != z2) {
            this.f29680l = z2;
            refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int i2) {
        int i3 = this.f29679k;
        if (i3 != i2) {
            if (i3 == 0) {
                setCloseIconFocused(false);
            }
            this.f29679k = i2;
            if (i2 == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    public void a() {
        q();
        requestLayout();
        invalidateOutline();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (k(motionEvent) || this.f29683o.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f29683o.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z2;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable == null || !chipDrawable.f0()) {
            z2 = false;
        } else {
            z2 = this.f29674f.Y0(i());
        }
        if (z2) {
            invalidate();
        }
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.w();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.x();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.y();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f29674f;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.z();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.A();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.B();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.C();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.D();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.E();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.F();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.G();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.H();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.I();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.J();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.K();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.L();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.N();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.P();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.f29679k == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.Q();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.R();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.S();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.T();
        }
        return null;
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.U();
        }
        return null;
    }

    public CharSequence getText() {
        ChipDrawable chipDrawable = this.f29674f;
        return chipDrawable != null ? chipDrawable.V() : "";
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.X();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            return chipDrawable.Y();
        }
        return 0.0f;
    }

    public boolean o() {
        boolean z2;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f29676h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        } else {
            z2 = false;
        }
        this.f29683o.sendEventForVirtualView(0, 1);
        return z2;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f29673t);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.f29674f) == null || chipDrawable.z1()) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.translate(h(this.f29674f), 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z2, i2, rect);
        this.f29683o.onFocusChanged(z2, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0041
            r1 = 66
            if (r0 == r1) goto L_0x0031
            switch(r0) {
                case 21: goto L_0x0022;
                case 22: goto L_0x0012;
                case 23: goto L_0x0031;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x006d
        L_0x0012:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.ViewUtils.a(r6)
            r0 = r0 ^ r2
            boolean r3 = r6.n(r0)
            goto L_0x006d
        L_0x0022:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.ViewUtils.a(r6)
            boolean r3 = r6.n(r0)
            goto L_0x006d
        L_0x0031:
            int r0 = r6.f29679k
            r1 = -1
            if (r0 == r1) goto L_0x003d
            if (r0 == 0) goto L_0x0039
            goto L_0x006d
        L_0x0039:
            r6.o()
            return r2
        L_0x003d:
            r6.performClick()
            return r2
        L_0x0041:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x0052
        L_0x0049:
            boolean r0 = r8.hasModifiers(r2)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x006d
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L_0x0059:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L_0x0067
            if (r4 == r6) goto L_0x0067
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L_0x0059
        L_0x0067:
            if (r4 == 0) goto L_0x006d
            r4.requestFocus()
            return r2
        L_0x006d:
            if (r3 == 0) goto L_0x0073
            r6.invalidate()
            return r2
        L_0x0073:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0039
            if (r0 == r2) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.f29680l
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r3)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.f29680l
            if (r0 == 0) goto L_0x0034
            r5.o()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r3)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r2)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x004b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == this.f29674f || drawable == this.f29675g) {
            super.setBackground(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int i2) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == this.f29674f || drawable == this.f29675g) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int i2) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.n0(z2);
        }
    }

    public void setCheckableResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.o0(i2);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable == null) {
            this.f29678j = z2;
        } else if (chipDrawable.c0()) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked != z2 && (onCheckedChangeListener = this.f29677i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z2);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.p0(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.q0(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.r0(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.t0(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.u0(i2);
        }
    }

    public void setChipCornerRadius(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.v0(f2);
        }
    }

    public void setChipCornerRadiusResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.w0(i2);
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f29674f;
        if (chipDrawable2 != chipDrawable) {
            p(chipDrawable2);
            this.f29674f = chipDrawable;
            g(chipDrawable);
            if (RippleUtils.f29943a) {
                this.f29675g = new RippleDrawable(RippleUtils.a(this.f29674f.T()), this.f29674f, (Drawable) null);
                this.f29674f.y1(false);
                ViewCompat.v0(this, this.f29675g);
                return;
            }
            this.f29674f.y1(true);
            ViewCompat.v0(this, this.f29674f);
        }
    }

    public void setChipEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.x0(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.y0(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.z0(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.A0(i2);
        }
    }

    public void setChipIconSize(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.B0(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.C0(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.D0(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.E0(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.F0(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.H0(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.I0(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.J0(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.K0(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.L0(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.M0(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.N0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.O0(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.P0(drawable);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.Q0(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.R0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.S0(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.T0(i2);
        }
    }

    public void setCloseIconSize(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.U0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.V0(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.W0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.X0(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.Z0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.a1(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.b1(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f29674f != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable = this.f29674f;
                if (chipDrawable != null) {
                    chipDrawable.e1(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.f1(motionSpec);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.g1(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.h1(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.i1(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.j1(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.k1(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.l1(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f29677i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f29676h = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.m1(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.n1(i2);
        }
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.p1(motionSpec);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.q1(i2);
        }
    }

    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f29674f != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            CharSequence h2 = BidiFormatter.c().h(charSequence);
            if (this.f29674f.z1()) {
                h2 = null;
            }
            super.setText(h2, bufferType);
            ChipDrawable chipDrawable = this.f29674f;
            if (chipDrawable != null) {
                chipDrawable.r1(charSequence);
            }
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.s1(textAppearance);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().h(getContext(), getPaint(), this.f29686r);
            r(textAppearance);
        }
    }

    public void setTextAppearanceResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.t1(i2);
        }
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.u1(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.v1(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.w1(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.x1(i2);
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.s0(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.G0(z2);
        }
    }

    public void setCloseIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.c1(z2);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.t1(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().h(context, getPaint(), this.f29686r);
            r(getTextAppearance());
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        ChipDrawable chipDrawable = this.f29674f;
        if (chipDrawable != null) {
            chipDrawable.t1(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().h(getContext(), getPaint(), this.f29686r);
            r(getTextAppearance());
        }
    }
}
