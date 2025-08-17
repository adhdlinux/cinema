package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzeb;
import com.google.android.gms.internal.cast.zzek;

public final class zzh extends ViewGroup {
    Animator zza;
    private final int[] zzb = new int[2];
    private final Rect zzc = new Rect();
    private final Rect zzd = new Rect();
    /* access modifiers changed from: private */
    public final OuterHighlightDrawable zze;
    private final InnerZoneDrawable zzf;
    private View zzg;
    private final zzi zzh;
    private final GestureDetectorCompat zzi;
    private GestureDetectorCompat zzj;
    /* access modifiers changed from: private */
    public zzg zzk;
    private boolean zzl;
    private HelpTextView zzm;

    public zzh(Context context) {
        super(context);
        setId(R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.zzf = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.zze = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.zzh = new zzi(this);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new zza(this));
        this.zzi = gestureDetectorCompat;
        gestureDetectorCompat.b(false);
        setVisibility(8);
    }

    static /* synthetic */ Animator zza(zzh zzh2) {
        InnerZoneDrawable innerZoneDrawable = zzh2.zzf;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.0f, 1.1f}).setDuration(500);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.1f, 1.0f}).setDuration(500);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("pulseScale", new float[]{1.1f, 2.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{1.0f, 0.0f})}).setDuration(500);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzek.zzb());
        animatorSet.setStartDelay(500);
        zzeb.zzd(animatorSet, -1, (Runnable) null);
        return animatorSet;
    }

    private final void zzo(Animator animator) {
        Animator animator2 = this.zza;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.zza = animator;
        animator.start();
    }

    /* access modifiers changed from: protected */
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        canvas.save();
        this.zze.draw(canvas);
        this.zzf.draw(canvas);
        View view = this.zzg;
        if (view != null) {
            if (view.getParent() != null) {
                Bitmap createBitmap = Bitmap.createBitmap(this.zzg.getWidth(), this.zzg.getHeight(), Bitmap.Config.ARGB_8888);
                this.zzg.draw(new Canvas(createBitmap));
                int zzc2 = this.zze.zzc();
                int red = Color.red(zzc2);
                int green = Color.green(zzc2);
                int blue = Color.blue(zzc2);
                for (int i2 = 0; i2 < createBitmap.getHeight(); i2++) {
                    for (int i3 = 0; i3 < createBitmap.getWidth(); i3++) {
                        int pixel = createBitmap.getPixel(i3, i2);
                        if (Color.alpha(pixel) != 0) {
                            createBitmap.setPixel(i3, i2, Color.argb(Color.alpha(pixel), red, green, blue));
                        }
                    }
                }
                Rect rect = this.zzc;
                canvas.drawBitmap(createBitmap, (float) rect.left, (float) rect.top, (Paint) null);
            }
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Neither target view nor drawable was set");
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View view = this.zzg;
        if (view != null) {
            if (view.getParent() != null) {
                int[] iArr = this.zzb;
                View view2 = this.zzg;
                getLocationInWindow(iArr);
                int i6 = iArr[0];
                int i7 = iArr[1];
                view2.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i7;
            }
            Rect rect = this.zzc;
            int[] iArr2 = this.zzb;
            int i8 = iArr2[0];
            rect.set(i8, iArr2[1], this.zzg.getWidth() + i8, this.zzb[1] + this.zzg.getHeight());
            this.zzd.set(i2, i3, i4, i5);
            this.zze.setBounds(this.zzd);
            this.zzf.setBounds(this.zzd);
            this.zzh.zza(this.zzc, this.zzd);
            return;
        }
        throw new IllegalStateException("Target view must be set before layout");
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i2), i2), View.resolveSize(View.MeasureSpec.getSize(i3), i3));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zzl = this.zzc.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.zzl) {
            GestureDetectorCompat gestureDetectorCompat = this.zzj;
            if (gestureDetectorCompat != null) {
                gestureDetectorCompat.a(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.zzg.getParent() != null) {
                this.zzg.onTouchEvent(motionEvent);
            }
        } else {
            this.zzi.a(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.zze || drawable == this.zzf || drawable == null;
    }

    /* access modifiers changed from: package-private */
    public final View zzb() {
        return this.zzm.asView();
    }

    /* access modifiers changed from: package-private */
    public final InnerZoneDrawable zzd() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final OuterHighlightDrawable zzf() {
        return this.zze;
    }

    public final void zzg(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f}).setDuration(200);
        duration.setInterpolator(zzek.zza());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zze, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{1.125f}), PropertyValuesHolder.ofInt("alpha", new int[]{0})});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200);
        Animator zza2 = this.zzf.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, zza2});
        animatorSet.addListener(new zze(this, runnable));
        zzo(animatorSet);
    }

    public final void zzh(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f}).setDuration(200);
        duration.setInterpolator(zzek.zza());
        float exactCenterX = this.zzc.exactCenterX() - this.zze.zza();
        float exactCenterY = this.zzc.exactCenterY() - this.zze.zzb();
        OuterHighlightDrawable outerHighlightDrawable = this.zze;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable, new PropertyValuesHolder[]{ofFloat, PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, exactCenterX}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, exactCenterY}), ofInt});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200);
        Animator zza2 = this.zzf.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, zza2});
        animatorSet.addListener(new zzf(this, runnable));
        zzo(animatorSet);
    }

    public final void zzi(View view, View view2, boolean z2, zzg zzg2) {
        this.zzg = view;
        this.zzk = zzg2;
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new zzb(this, view, true, zzg2));
        this.zzj = gestureDetectorCompat;
        gestureDetectorCompat.b(false);
        setVisibility(4);
    }

    public final void zzj(int i2) {
        this.zze.zze(i2);
    }

    public final void zzk() {
        if (this.zzg != null) {
            setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f, 1.0f}).setDuration(350);
            duration.setInterpolator(zzek.zzc());
            Animator zzd2 = this.zze.zzd(this.zzc.exactCenterX() - this.zze.zza(), this.zzc.exactCenterY() - this.zze.zzb());
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzf, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, JfifUtil.MARKER_FIRST_BYTE})});
            ofPropertyValuesHolder.setInterpolator(zzek.zzc());
            Animator duration2 = ofPropertyValuesHolder.setDuration(350);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{duration, zzd2, duration2});
            animatorSet.addListener(new zzd(this));
            zzo(animatorSet);
            return;
        }
        throw new IllegalStateException("Target view must be set before animation");
    }

    public final void zzl(Runnable runnable) {
        addOnLayoutChangeListener(new zzc(this, (Runnable) null));
    }

    public final void zzn(HelpTextView helpTextView) {
        helpTextView.getClass();
        this.zzm = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    /* access modifiers changed from: protected */
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
