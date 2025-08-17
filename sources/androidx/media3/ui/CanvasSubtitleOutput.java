package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.common.text.Cue;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CanvasSubtitleOutput extends View implements SubtitleView.Output {

    /* renamed from: b  reason: collision with root package name */
    private final List<SubtitlePainter> f9760b;

    /* renamed from: c  reason: collision with root package name */
    private List<Cue> f9761c;

    /* renamed from: d  reason: collision with root package name */
    private int f9762d;

    /* renamed from: e  reason: collision with root package name */
    private float f9763e;

    /* renamed from: f  reason: collision with root package name */
    private CaptionStyleCompat f9764f;

    /* renamed from: g  reason: collision with root package name */
    private float f9765g;

    public CanvasSubtitleOutput(Context context) {
        this(context, (AttributeSet) null);
    }

    private static Cue b(Cue cue) {
        Cue.Builder p2 = cue.a().k(-3.4028235E38f).l(Integer.MIN_VALUE).p((Layout.Alignment) null);
        if (cue.f4563f == 0) {
            p2.h(1.0f - cue.f4562e, 0);
        } else {
            p2.h((-cue.f4562e) - 1.0f, 1);
        }
        int i2 = cue.f4564g;
        if (i2 == 0) {
            p2.i(2);
        } else if (i2 == 2) {
            p2.i(0);
        }
        return p2.a();
    }

    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.f9761c = list;
        this.f9764f = captionStyleCompat;
        this.f9763e = f2;
        this.f9762d = i2;
        this.f9765g = f3;
        while (this.f9760b.size() < list.size()) {
            this.f9760b.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    public void dispatchDraw(Canvas canvas) {
        List<Cue> list = this.f9761c;
        if (!list.isEmpty()) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int paddingBottom = height - getPaddingBottom();
            if (paddingBottom > paddingTop && width > paddingLeft) {
                int i2 = paddingBottom - paddingTop;
                float h2 = SubtitleViewUtils.h(this.f9762d, this.f9763e, height, i2);
                if (h2 > 0.0f) {
                    int size = list.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Cue cue = list.get(i3);
                        if (cue.f4573p != Integer.MIN_VALUE) {
                            cue = b(cue);
                        }
                        Cue cue2 = cue;
                        float f2 = h2;
                        int i4 = paddingBottom;
                        this.f9760b.get(i3).b(cue2, this.f9764f, f2, SubtitleViewUtils.h(cue2.f4571n, cue2.f4572o, height, i2), this.f9765g, canvas, paddingLeft, paddingTop, width, i4);
                        i3++;
                        size = size;
                        i2 = i2;
                        paddingBottom = i4;
                        width = width;
                    }
                }
            }
        }
    }

    public CanvasSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9760b = new ArrayList();
        this.f9761c = Collections.emptyList();
        this.f9762d = 0;
        this.f9763e = 0.0533f;
        this.f9764f = CaptionStyleCompat.f9766g;
        this.f9765g = 0.08f;
    }
}
