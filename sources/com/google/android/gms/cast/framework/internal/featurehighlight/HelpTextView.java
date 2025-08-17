package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R;

@Keep
public class HelpTextView extends LinearLayout {
    TextView bodyTextView;
    TextView headerTextView;

    @Keep
    public HelpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setTextAndVisibility(TextView textView, CharSequence charSequence) {
        int i2;
        textView.setText(charSequence);
        if (true != TextUtils.isEmpty(charSequence)) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    @Keep
    public View asView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(R.id.cast_featurehighlight_help_text_header_view);
        textView.getClass();
        this.headerTextView = textView;
        TextView textView2 = (TextView) findViewById(R.id.cast_featurehighlight_help_text_body_view);
        textView2.getClass();
        this.bodyTextView = textView2;
    }

    @Keep
    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        setTextAndVisibility(this.headerTextView, charSequence);
        setTextAndVisibility(this.bodyTextView, charSequence2);
    }
}
