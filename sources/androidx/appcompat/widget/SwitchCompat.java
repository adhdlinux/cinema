package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private EmojiCompatInitCallback mEmojiCompatInitCallback;
    private boolean mEnforceSwitchWidth;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOffTransformed;
    private CharSequence mTextOn;
    private CharSequence mTextOnTransformed;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    static class Api18Impl {
        private Api18Impl() {
        }

        static void a(ObjectAnimator objectAnimator, boolean z2) {
            objectAnimator.setAutoCancel(z2);
        }
    }

    static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<SwitchCompat> f1446a;

        EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.f1446a = new WeakReference(switchCompat);
        }

        public void a(Throwable th) {
            SwitchCompat switchCompat = this.f1446a.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }

        public void b() {
            SwitchCompat switchCompat = this.f1446a.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }
    }

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateThumbToCheckedState(boolean z2) {
        float f2;
        if (z2) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{f2});
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250);
        Api18Impl.a(this.mPositionAnimator, true);
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.mThumbDrawable = mutate;
            if (this.mHasThumbTint) {
                DrawableCompat.o(mutate, this.mThumbTintList);
            }
            if (this.mHasThumbTintMode) {
                DrawableCompat.p(this.mThumbDrawable, this.mThumbTintMode);
            }
            if (this.mThumbDrawable.isStateful()) {
                this.mThumbDrawable.setState(getDrawableState());
            }
        }
    }

    private void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.mTrackDrawable = mutate;
            if (this.mHasTrackTint) {
                DrawableCompat.o(mutate, this.mTrackTintList);
            }
            if (this.mHasTrackTintMode) {
                DrawableCompat.p(this.mTrackDrawable, this.mTrackTintMode);
            }
            if (this.mTrackDrawable.isStateful()) {
                this.mTrackDrawable.setState(getDrawableState());
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float constrain(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private CharSequence doTransformForOnOffText(CharSequence charSequence) {
        TransformationMethod f2 = getEmojiTextViewHelper().f(this.mSwitchTransformationMethod);
        if (f2 != null) {
            return f2.getTransformation(charSequence, this);
        }
        return charSequence;
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (ViewUtils.b(this)) {
            f2 = 1.0f - this.mThumbPosition;
        } else {
            f2 = this.mThumbPosition;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.mTempRect;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            rect = DrawableUtils.d(drawable2);
        } else {
            rect = DrawableUtils.f1246c;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    private boolean hitThumb(float f2, float f3) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i2 = this.mSwitchTop;
        int i3 = this.mTouchSlop;
        int i4 = i2 - i3;
        int i5 = (this.mSwitchLeft + thumbOffset) - i3;
        Rect rect = this.mTempRect;
        int i6 = this.mThumbWidth + i5 + rect.left + rect.right + i3;
        int i7 = this.mSwitchBottom + i3;
        if (f2 <= ((float) i5) || f2 >= ((float) i6) || f3 <= ((float) i4) || f3 >= ((float) i7)) {
            return false;
        }
        return true;
    }

    private Layout makeLayout(CharSequence charSequence) {
        int i2;
        TextPaint textPaint = this.mTextPaint;
        if (charSequence != null) {
            i2 = (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint));
        } else {
            i2 = 0;
        }
        return new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOff;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f216c);
            }
            ViewCompat.L0(this, charSequence);
        }
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOn;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f217d);
            }
            ViewCompat.L0(this, charSequence);
        }
    }

    private void setSwitchTypefaceByIndex(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 == 2) {
            typeface = Typeface.SERIF;
        } else if (i2 != 3) {
            typeface = null;
        } else {
            typeface = Typeface.MONOSPACE;
        }
        setSwitchTypeface(typeface, i3);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.mTextOff = charSequence;
        this.mTextOffTransformed = doTransformForOnOffText(charSequence);
        this.mOffLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.mTextOn = charSequence;
        this.mTextOnTransformed = doTransformForOnOffText(charSequence);
        this.mOnLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    private void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null && this.mAppCompatEmojiTextHelper.b() && EmojiCompat.h()) {
            EmojiCompat b2 = EmojiCompat.b();
            int d2 = b2.d();
            if (d2 == 3 || d2 == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.mEmojiCompatInitCallback = emojiCompatInitCallback;
                b2.s(emojiCompatInitCallback);
            }
        }
    }

    private void stopDrag(MotionEvent motionEvent) {
        boolean z2;
        this.mTouchMode = 0;
        boolean z3 = true;
        if (motionEvent.getAction() != 1 || !isEnabled()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean isChecked = isChecked();
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.mMinFlingVelocity)) {
                z3 = getTargetCheckedState();
            } else if (!ViewUtils.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z3 = false;
            }
        } else {
            z3 = isChecked;
        }
        if (z3 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z3);
        cancelSuperTouch(motionEvent);
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.mTempRect;
        int i4 = this.mSwitchLeft;
        int i5 = this.mSwitchTop;
        int i6 = this.mSwitchRight;
        int i7 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = DrawableUtils.d(drawable);
        } else {
            rect = DrawableUtils.f1246c;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                if (i10 > i11) {
                    i2 = (i10 - i11) + i5;
                } else {
                    i2 = i5;
                }
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.mTrackDrawable.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.mTrackDrawable.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.l(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            DrawableCompat.k(drawable, f2, f3);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            DrawableCompat.k(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.mSwitchPadding;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    /* access modifiers changed from: protected */
    public final float getThumbPosition() {
        return this.mThumbPosition;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Layout layout;
        int i2;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.mSwitchTop;
        int i4 = this.mSwitchBottom;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (!this.mSplitTrack || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d2 = DrawableUtils.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.mOnLayout;
        } else {
            layout = this.mOffLayout;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    /* access modifiers changed from: package-private */
    public void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.mTextOn;
            } else {
                charSequence = this.mTextOff;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = DrawableUtils.d(this.mThumbDrawable);
            i6 = Math.max(0, d2.left - rect.left);
            i12 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (ViewUtils.b(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.mSwitchWidth + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.mSwitchWidth) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i11 = this.mSwitchHeight;
            i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.mSwitchHeight;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.mSwitchHeight;
            this.mSwitchLeft = i8;
            this.mSwitchTop = i10;
            this.mSwitchBottom = i9;
            this.mSwitchRight = i7;
        }
        i9 = i11 + i10;
        this.mSwitchLeft = i8;
        this.mSwitchTop = i10;
        this.mSwitchBottom = i9;
        this.mSwitchRight = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOnTransformed);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOffTransformed);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int i8 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (this.mShowText) {
            i6 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
        } else {
            i6 = 0;
        }
        this.mThumbWidth = Math.max(i6, i5);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i8 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i9 = rect.left;
        int i10 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect d2 = DrawableUtils.d(drawable3);
            i9 = Math.max(i9, d2.left);
            i10 = Math.max(i10, d2.right);
        }
        if (this.mEnforceSwitchWidth) {
            i7 = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i9 + i10);
        } else {
            i7 = this.mSwitchMinWidth;
        }
        int max = Math.max(i8, i4);
        this.mSwitchWidth = i7;
        this.mSwitchHeight = max;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.mTextOn;
        } else {
            charSequence = this.mTextOff;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r0 = r6.mTouchMode
            if (r0 == r1) goto L_0x0057
            if (r0 == r2) goto L_0x001e
            goto L_0x00b9
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003d
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x0039:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r6)
            if (r0 == 0) goto L_0x0044
            float r2 = -r2
        L_0x0044:
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = constrain(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0056
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L_0x0056:
            return r1
        L_0x0057:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007d
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
        L_0x007d:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L_0x008b:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L_0x0096
            r6.stopDrag(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0096:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto L_0x00b9
        L_0x009f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b9
            boolean r3 = r6.hitThumb(r0, r2)
            if (r3 == 0) goto L_0x00b9
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        L_0x00b9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    public void setChecked(boolean z2) {
        float f2;
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (isChecked) {
            setOnStateDescriptionOnRAndAbove();
        } else {
            setOffStateDescriptionOnRAndAbove();
        }
        if (getWindowToken() == null || !ViewCompat.V(this)) {
            cancelPositionAnimator();
            if (isChecked) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            setThumbPosition(f2);
            return;
        }
        animateThumbToCheckedState(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public final void setEnforceSwitchWidth(boolean z2) {
        this.mEnforceSwitchWidth = z2;
        invalidate();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z2) {
        if (this.mShowText != z2) {
            this.mShowText = z2;
            requestLayout();
            if (z2) {
                setupEmojiCompatLoadCallback();
            }
        }
    }

    public void setSplitTrack(boolean z2) {
        this.mSplitTrack = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.mSwitchMinWidth = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.mSwitchPadding = i2;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i2) {
        TintTypedArray t2 = TintTypedArray.t(context, i2, R$styleable.c3);
        ColorStateList c2 = t2.c(R$styleable.g3);
        if (c2 != null) {
            this.mTextColors = c2;
        } else {
            this.mTextColors = getTextColors();
        }
        int f2 = t2.f(R$styleable.d3, 0);
        if (f2 != 0) {
            float f3 = (float) f2;
            if (f3 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f3);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(t2.k(R$styleable.e3, -1), t2.k(R$styleable.f3, -1));
        if (t2.a(R$styleable.r3, false)) {
            this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        t2.w();
    }

    public void setSwitchTypeface(Typeface typeface, int i2) {
        Typeface typeface2;
        float f2 = 0.0f;
        boolean z2 = false;
        if (i2 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i2);
            } else {
                typeface2 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(typeface2);
            int i3 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i2;
            TextPaint textPaint = this.mTextPaint;
            if ((i3 & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.mTextPaint;
            if ((i3 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            setOffStateDescriptionOnRAndAbove();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            setOnStateDescriptionOnRAndAbove();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.mThumbPosition = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.mThumbTextPadding = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.R);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mEnforceSwitchWidth = true;
        this.mTempRect = new Rect();
        ThemeUtils.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.N2;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, iArr, i2, 0);
        ViewCompat.p0(this, context, iArr, attributeSet, v2.r(), i2, 0);
        Drawable g2 = v2.g(R$styleable.Q2);
        this.mThumbDrawable = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        Drawable g3 = v2.g(R$styleable.Z2);
        this.mTrackDrawable = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        setTextOnInternal(v2.p(R$styleable.O2));
        setTextOffInternal(v2.p(R$styleable.P2));
        this.mShowText = v2.a(R$styleable.R2, true);
        this.mThumbTextPadding = v2.f(R$styleable.W2, 0);
        this.mSwitchMinWidth = v2.f(R$styleable.T2, 0);
        this.mSwitchPadding = v2.f(R$styleable.U2, 0);
        this.mSplitTrack = v2.a(R$styleable.S2, false);
        ColorStateList c2 = v2.c(R$styleable.X2);
        if (c2 != null) {
            this.mThumbTintList = c2;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode e2 = DrawableUtils.e(v2.k(R$styleable.Y2, -1), (PorterDuff.Mode) null);
        if (this.mThumbTintMode != e2) {
            this.mThumbTintMode = e2;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList c3 = v2.c(R$styleable.a3);
        if (c3 != null) {
            this.mTrackTintList = c3;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode e3 = DrawableUtils.e(v2.k(R$styleable.b3, -1), (PorterDuff.Mode) null);
        if (this.mTrackTintMode != e3) {
            this.mTrackTintMode = e3;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int n2 = v2.n(R$styleable.V2, 0);
        if (n2 != 0) {
            setSwitchTextAppearance(context, n2);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        v2.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i2);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
