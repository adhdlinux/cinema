package com.movie.ui.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public final class AnimatorStateView_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AnimatorStateView f33645a;

    public AnimatorStateView_ViewBinding(AnimatorStateView animatorStateView, View view) {
        this.f33645a = animatorStateView;
        Class cls = TextView.class;
        animatorStateView.mTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.message_view_text, "field 'mTextView'", cls);
        animatorStateView.txtEmoticon = (TextView) Utils.findRequiredViewAsType(view, R.id.textEmptyEmoticon, "field 'txtEmoticon'", cls);
    }

    public void unbind() {
        AnimatorStateView animatorStateView = this.f33645a;
        if (animatorStateView != null) {
            this.f33645a = null;
            animatorStateView.mTextView = null;
            animatorStateView.txtEmoticon = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
