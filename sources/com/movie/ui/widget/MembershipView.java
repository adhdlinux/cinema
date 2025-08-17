package com.movie.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import c1.a;
import com.movie.data.api.GlobalVariable;
import com.movie.ui.activity.MemberActivationActivity;
import com.yoku.marumovie.R;
import kotlin.jvm.internal.Intrinsics;

public final class MembershipView extends CardView {

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f33649k;

    /* renamed from: l  reason: collision with root package name */
    private final CardView f33650l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f33651m;

    /* renamed from: n  reason: collision with root package name */
    private final TextView f33652n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MembershipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.f(context, "context");
        boolean z2 = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.membership_promote, this, true);
        View findViewById = inflate.findViewById(R.id.root_view);
        Intrinsics.e(findViewById, "findViewById(...)");
        CardView cardView = (CardView) findViewById;
        this.f33650l = cardView;
        View findViewById2 = inflate.findViewById(R.id.membershipIcon);
        Intrinsics.e(findViewById2, "findViewById(...)");
        this.f33649k = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.membership_header);
        Intrinsics.e(findViewById3, "findViewById(...)");
        this.f33651m = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.membership_text);
        Intrinsics.e(findViewById4, "findViewById(...)");
        this.f33652n = (TextView) findViewById4;
        cardView.setOnClickListener(new a(context));
        Intrinsics.c(inflate);
        inflate.setVisibility(GlobalVariable.c().b().getAds() != null ? false : z2 ? 8 : 0);
    }

    /* access modifiers changed from: private */
    public static final void f(Context context, View view) {
        Intrinsics.f(context, "$context");
        context.startActivity(new Intent(context, MemberActivationActivity.class));
    }
}
