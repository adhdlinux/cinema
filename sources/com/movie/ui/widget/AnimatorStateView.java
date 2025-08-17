package com.movie.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.yoku.marumovie.R;
import com.yoku.marumovie.R$styleable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class AnimatorStateView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private View f33644b;
    @BindView(2131362385)
    TextView mTextView;
    @BindView(2131362772)
    TextView txtEmoticon;

    public AnimatorStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_animator_state, this, true);
        this.f33644b = inflate;
        ButterKnife.bind((Object) this, inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f38076m, i2, 0);
        this.mTextView.setText(obtainStyledAttributes.getString(0));
        this.txtEmoticon.setText(getEmoticon());
        obtainStyledAttributes.recycle();
    }

    private String getEmoticon() {
        List asList = Arrays.asList(new String[]{"\\(o_o)/", "(>_<)", "(;-;)", "(·.·)", "(='X'=)", "(≥o≤)", "(^-^*)"});
        return (String) asList.get(new Random().nextInt(asList.size()));
    }

    public void setMessageText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }
}
