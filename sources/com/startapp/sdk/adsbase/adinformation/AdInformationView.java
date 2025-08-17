package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.startapp.p;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class AdInformationView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36271a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f36272b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f36273c = null;

    /* renamed from: d  reason: collision with root package name */
    public AdInformationConfig f36274d;

    /* renamed from: e  reason: collision with root package name */
    public ImageResourceConfig f36275e;

    /* renamed from: f  reason: collision with root package name */
    public AdPreferences.Placement f36276f;

    /* renamed from: g  reason: collision with root package name */
    public AdInformationPositions.Position f36277g;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f36278a;

        public a(AdInformationView adInformationView, View.OnClickListener onClickListener) {
            this.f36278a = onClickListener;
        }

        public void onClick(View view) {
            this.f36278a.onClick(view);
        }
    }

    public AdInformationView(Context context, AdInformationObject.Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides, View.OnClickListener onClickListener) {
        super(context);
        this.f36276f = placement;
        this.f36273c = new a(this, onClickListener);
        a(size, adInformationOverrides);
    }

    public void a(AdInformationObject.Size size, AdInformationOverrides adInformationOverrides) {
        AdInformationConfig a2 = AdInformationMetaData.f36260a.a();
        this.f36274d = a2;
        if (a2 == null) {
            AdInformationConfig adInformationConfig = new AdInformationConfig();
            AdInformationConfig.a(adInformationConfig);
            this.f36274d = adInformationConfig;
        }
        AdInformationConfig adInformationConfig2 = this.f36274d;
        this.f36275e = adInformationConfig2.f36259b.get(size.a());
        if (adInformationOverrides == null || !adInformationOverrides.e()) {
            AdInformationConfig adInformationConfig3 = this.f36274d;
            AdPreferences.Placement placement = this.f36276f;
            AdInformationPositions.Position position = adInformationConfig3.Positions.get(placement);
            if (position == null) {
                position = AdInformationPositions.Position.BOTTOM_LEFT;
                adInformationConfig3.Positions.put(placement, position);
            }
            this.f36277g = position;
        } else {
            this.f36277g = adInformationOverrides.b();
        }
        ImageView imageView = new ImageView(getContext());
        this.f36271a = imageView;
        imageView.setContentDescription("info");
        this.f36271a.setId(1475346433);
        this.f36271a.setImageBitmap(this.f36275e.a(getContext()));
        this.f36272b = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p.a(getContext(), (int) (((float) this.f36275e.d()) * this.f36274d.e())), p.a(getContext(), (int) (((float) this.f36275e.a()) * this.f36274d.e())));
        this.f36272b.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(p.a(getContext(), this.f36275e.d()), p.a(getContext(), this.f36275e.a()));
        layoutParams2.setMargins(0, 0, 0, 0);
        this.f36271a.setPadding(0, 0, 0, 0);
        this.f36277g.addRules(layoutParams2);
        this.f36272b.addView(this.f36271a, layoutParams2);
        this.f36272b.setOnClickListener(this.f36273c);
        addView(this.f36272b, layoutParams);
    }
}
