package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.mediarouter.R$drawable;
import androidx.mediarouter.R$string;

class MediaRouteExpandCollapseButton extends AppCompatImageButton {

    /* renamed from: e  reason: collision with root package name */
    final AnimationDrawable f10443e;

    /* renamed from: f  reason: collision with root package name */
    final AnimationDrawable f10444f;

    /* renamed from: g  reason: collision with root package name */
    final String f10445g;

    /* renamed from: h  reason: collision with root package name */
    final String f10446h;

    /* renamed from: i  reason: collision with root package name */
    boolean f10447i;

    /* renamed from: j  reason: collision with root package name */
    View.OnClickListener f10448j;

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10448j = onClickListener;
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AnimationDrawable animationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, R$drawable.mr_group_expand);
        this.f10443e = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) ContextCompat.getDrawable(context, R$drawable.mr_group_collapse);
        this.f10444f = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(MediaRouterThemeHelper.f(context, i2), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(R$string.mr_controller_expand_group);
        this.f10445g = string;
        this.f10446h = context.getString(R$string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
                boolean z2 = !mediaRouteExpandCollapseButton.f10447i;
                mediaRouteExpandCollapseButton.f10447i = z2;
                if (z2) {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f10443e);
                    MediaRouteExpandCollapseButton.this.f10443e.start();
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton2 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton2.setContentDescription(mediaRouteExpandCollapseButton2.f10446h);
                } else {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f10444f);
                    MediaRouteExpandCollapseButton.this.f10444f.start();
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton3 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton3.setContentDescription(mediaRouteExpandCollapseButton3.f10445g);
                }
                View.OnClickListener onClickListener = MediaRouteExpandCollapseButton.this.f10448j;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }
}
