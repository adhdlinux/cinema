package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable p(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.d();
    }

    public void a(CardViewDelegate cardViewDelegate, float f2) {
        p(cardViewDelegate).h(f2);
    }

    public float b(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).d();
    }

    public void c(CardViewDelegate cardViewDelegate, float f2) {
        cardViewDelegate.f().setElevation(f2);
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).c();
    }

    public ColorStateList e(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).b();
    }

    public float f(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    public void g(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    public void h(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        cardViewDelegate.b(new RoundRectDrawable(colorStateList, f2));
        View f5 = cardViewDelegate.f();
        f5.setClipToOutline(true);
        f5.setElevation(f3);
        o(cardViewDelegate, f4);
    }

    public float i(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.f().getElevation();
    }

    public void j(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    public void k(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.c()) {
            cardViewDelegate.a(0, 0, 0, 0);
            return;
        }
        float d2 = d(cardViewDelegate);
        float b2 = b(cardViewDelegate);
        int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.a(d2, b2, cardViewDelegate.e()));
        int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.b(d2, b2, cardViewDelegate.e()));
        cardViewDelegate.a(ceil, ceil2, ceil, ceil2);
    }

    public void l() {
    }

    public float m(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    public void n(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        p(cardViewDelegate).f(colorStateList);
    }

    public void o(CardViewDelegate cardViewDelegate, float f2) {
        p(cardViewDelegate).g(f2, cardViewDelegate.c(), cardViewDelegate.e());
        k(cardViewDelegate);
    }
}
