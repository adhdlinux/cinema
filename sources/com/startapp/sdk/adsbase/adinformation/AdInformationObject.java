package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.startapp.s8;
import com.startapp.sdk.adsbase.adinformation.AdInformationConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import java.lang.ref.WeakReference;

public class AdInformationObject implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f36262a;

    /* renamed from: b  reason: collision with root package name */
    public final AdInformationView f36263b;

    /* renamed from: c  reason: collision with root package name */
    public final AdPreferences.Placement f36264c;

    /* renamed from: d  reason: collision with root package name */
    public final ConsentData f36265d;

    /* renamed from: e  reason: collision with root package name */
    public final AdInformationOverrides f36266e;

    public enum Size {
        SMALL(AdInformationConfig.ImageResourceType.INFO_S, AdInformationConfig.ImageResourceType.INFO_EX_S),
        LARGE(AdInformationConfig.ImageResourceType.INFO_L, AdInformationConfig.ImageResourceType.INFO_EX_L);
        
        private final AdInformationConfig.ImageResourceType infoExtendedType;
        private final AdInformationConfig.ImageResourceType infoType;

        /* access modifiers changed from: public */
        Size(AdInformationConfig.ImageResourceType imageResourceType, AdInformationConfig.ImageResourceType imageResourceType2) {
            this.infoType = imageResourceType;
            this.infoExtendedType = imageResourceType2;
        }

        public AdInformationConfig.ImageResourceType a() {
            return this.infoType;
        }
    }

    public AdInformationObject(Context context, Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides, ConsentData consentData) {
        this.f36262a = new WeakReference<>(context);
        this.f36264c = placement;
        this.f36266e = adInformationOverrides;
        this.f36265d = consentData;
        this.f36263b = new AdInformationView(context, size, placement, adInformationOverrides, this);
    }

    public void a(RelativeLayout relativeLayout) {
        boolean z2;
        AdInformationConfig a2 = AdInformationMetaData.f36260a.a();
        AdInformationOverrides adInformationOverrides = this.f36266e;
        if (adInformationOverrides == null || !adInformationOverrides.d()) {
            z2 = a2.b(this.f36262a.get());
        } else {
            z2 = this.f36266e.c();
        }
        if (z2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            AdInformationOverrides adInformationOverrides2 = this.f36266e;
            if (adInformationOverrides2 == null || !adInformationOverrides2.e()) {
                AdPreferences.Placement placement = this.f36264c;
                AdInformationPositions.Position position = a2.Positions.get(placement);
                if (position == null) {
                    position = AdInformationPositions.Position.BOTTOM_LEFT;
                    a2.Positions.put(placement, position);
                }
                position.addRules(layoutParams);
            } else {
                this.f36266e.b().addRules(layoutParams);
            }
            relativeLayout.addView(this.f36263b, layoutParams);
        }
    }

    public void onClick(View view) {
        String str;
        String str2;
        Context context = this.f36262a.get();
        if (context != null) {
            s8 f2 = ComponentLocator.a(context).f();
            ConsentData consentData = this.f36265d;
            String str3 = null;
            if (consentData != null) {
                str = consentData.c();
            } else {
                str = null;
            }
            ConsentData consentData2 = this.f36265d;
            if (consentData2 != null) {
                str2 = consentData2.d();
            } else {
                str2 = null;
            }
            ConsentData consentData3 = this.f36265d;
            if (consentData3 != null) {
                str3 = consentData3.b();
            }
            f2.a(true, str, str2, str3);
        }
    }
}
