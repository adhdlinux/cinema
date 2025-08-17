package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

public class CastSeekBar extends View {
    public zze zza;
    public zzc zzb;
    public List zzc;
    public zzd zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private final int zzf(int i2) {
        return (int) ((((double) i2) / ((double) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) * ((double) this.zza.zzb));
    }

    private final void zzg(Canvas canvas, int i2, int i3, int i4, int i5, int i6) {
        this.zzl.setColor(i6);
        float f2 = this.zzi;
        float f3 = (float) i4;
        float f4 = ((float) i3) / f3;
        float f5 = ((float) i2) / f3;
        float f6 = (float) i5;
        canvas.drawRect(f5 * f6, -f2, f4 * f6, f2, this.zzl);
    }

    /* access modifiers changed from: private */
    public final void zzh(int i2) {
        zze zze2 = this.zza;
        if (zze2.zzf) {
            int i3 = zze2.zzd;
            this.zzf = Integer.valueOf(Math.min(Math.max(i2, i3), zze2.zze));
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
            }
            Runnable runnable = this.zzs;
            if (runnable == null) {
                this.zzs = new zza(this);
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.zzs, 200);
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public final void zzi() {
        this.zze = true;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzb(this);
        }
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        this.zze = false;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzc(this);
        }
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        Integer num = this.zzf;
        if (num != null) {
            return num.intValue();
        }
        return this.zza.zza;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Runnable runnable = this.zzs;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.translate((float) getPaddingLeft(), (float) getPaddingTop());
        zzc zzc2 = this.zzb;
        if (zzc2 == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int progress = getProgress();
            int save2 = canvas.save();
            canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
            zze zze2 = this.zza;
            if (zze2.zzf) {
                int i3 = zze2.zzd;
                if (i3 > 0) {
                    zzg(canvas, 0, i3, zze2.zzb, measuredWidth, this.zzo);
                }
                zze zze3 = this.zza;
                int i4 = zze3.zzd;
                if (progress > i4) {
                    zzg(canvas, i4, progress, zze3.zzb, measuredWidth, this.zzm);
                }
                zze zze4 = this.zza;
                int i5 = zze4.zze;
                if (i5 > progress) {
                    zzg(canvas, progress, i5, zze4.zzb, measuredWidth, this.zzn);
                }
                zze zze5 = this.zza;
                int i6 = zze5.zzb;
                int i7 = zze5.zze;
                if (i6 > i7) {
                    zzg(canvas, i7, i6, i6, measuredWidth, this.zzo);
                }
            } else {
                int max = Math.max(zze2.zzc, 0);
                if (max > 0) {
                    zzg(canvas, 0, max, this.zza.zzb, measuredWidth, this.zzo);
                }
                if (progress > max) {
                    zzg(canvas, max, progress, this.zza.zzb, measuredWidth, this.zzm);
                }
                int i8 = this.zza.zzb;
                if (i8 > progress) {
                    zzg(canvas, progress, i8, i8, measuredWidth, this.zzo);
                }
            }
            canvas2.restoreToCount(save2);
            List<zzb> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                this.zzl.setColor(this.zzp);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int save3 = canvas.save();
                canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
                for (zzb zzb2 : list) {
                    if (zzb2 != null) {
                        int min = Math.min(zzb2.zza, this.zza.zzb);
                        if (zzb2.zzc) {
                            i2 = zzb2.zzb;
                        } else {
                            i2 = 1;
                        }
                        float f3 = (float) measuredWidth2;
                        float f4 = (float) this.zza.zzb;
                        float f5 = this.zzk;
                        float f6 = (((float) (i2 + min)) * f3) / f4;
                        float f7 = (((float) min) * f3) / f4;
                        if (f6 - f7 < f5) {
                            f6 = f7 + f5;
                        }
                        if (f6 > f3) {
                            f2 = f3;
                        } else {
                            f2 = f6;
                        }
                        if (f2 - f7 < f5) {
                            f7 = f2 - f5;
                        }
                        float f8 = this.zzi;
                        canvas.drawRect(f7, -f8, f2, f8, this.zzl);
                    }
                }
                canvas2.restoreToCount(save3);
            }
            if (isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int measuredWidth3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                int save4 = canvas.save();
                canvas2.drawCircle((float) ((int) ((((double) getProgress()) / ((double) this.zza.zzb)) * ((double) measuredWidth3))), ((float) measuredHeight) / 2.0f, this.zzj, this.zzl);
                canvas2.restoreToCount(save4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int save5 = canvas.save();
            canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
            Canvas canvas3 = canvas;
            int i9 = measuredWidth4;
            zzg(canvas3, 0, zzc2.zza, zzc2.zzb, i9, this.zzp);
            int i10 = zzc2.zza;
            int i11 = zzc2.zzb;
            zzg(canvas3, i10, i11, i11, i9, this.zzo);
            canvas2.restoreToCount(save5);
        }
        canvas2.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.resolveSizeAndState((int) (this.zzg + ((float) getPaddingLeft()) + ((float) getPaddingRight())), i2, 0), View.resolveSizeAndState((int) (this.zzh + ((float) getPaddingTop()) + ((float) getPaddingBottom())), i3, 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.zza.zzf) {
            return false;
        }
        if (this.zzr == null) {
            this.zzr = new Point();
        }
        if (this.zzq == null) {
            this.zzq = new int[2];
        }
        getLocationOnScreen(this.zzq);
        this.zzr.set((((int) motionEvent.getRawX()) - this.zzq[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.zzq[1]);
        int action = motionEvent.getAction();
        if (action == 0) {
            zzi();
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action == 1) {
            zzh(zzf(this.zzr.x));
            zzj();
            return true;
        } else if (action == 2) {
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action != 3) {
            return false;
        } else {
            this.zze = false;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
                this.zzd.zzc(this);
            }
            postInvalidate();
            return true;
        }
    }

    public final void zzd(List list) {
        ArrayList arrayList;
        if (!Objects.equal(this.zzc, list)) {
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list);
            }
            this.zzc = arrayList;
            postInvalidate();
        }
    }

    public final void zze(zze zze2) {
        if (!this.zze) {
            zze zze3 = new zze();
            zze3.zza = zze2.zza;
            zze3.zzb = zze2.zzb;
            zze3.zzc = zze2.zzc;
            zze3.zzd = zze2.zzd;
            zze3.zze = zze2.zze;
            zze3.zzf = zze2.zzf;
            this.zza = zze3;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), false);
            }
            postInvalidate();
        }
    }

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zzc = new ArrayList();
        setAccessibilityDelegate(new zzg(this, (zzf) null));
        Paint paint = new Paint(1);
        this.zzl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.zzg = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.zzh = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.zzi = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        zze zze2 = new zze();
        this.zza = zze2;
        zze2.zzb = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context.getResources().getColor(resourceId);
        this.zzn = context.getResources().getColor(resourceId2);
        this.zzo = context.getResources().getColor(resourceId3);
        this.zzp = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
