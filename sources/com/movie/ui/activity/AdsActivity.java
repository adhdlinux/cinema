package com.movie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.ads.videoreward.AdsBase;
import com.ads.videoreward.MyVungleAds;
import com.ads.videoreward.Unity_Ads;
import com.movie.AppComponent;
import com.movie.data.api.GlobalVariable;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdsActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    Map<AdsBase.Tag, AdsBase> f31984b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    List<AdsBase.Tag> f31985c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    Button f31986d = null;

    /* renamed from: e  reason: collision with root package name */
    Button f31987e = null;

    /* renamed from: f  reason: collision with root package name */
    Button f31988f = null;

    /* renamed from: g  reason: collision with root package name */
    Button f31989g = null;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).g(i2, i3, intent);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.adcolony_btn:
                this.f31984b.get(AdsBase.Tag.ADCOLONY).p(this);
                return;
            case R.id.chartboost_btn:
                this.f31984b.get(AdsBase.Tag.CHARTBOOST).p(this);
                return;
            case R.id.unityads_btn:
                this.f31984b.get(AdsBase.Tag.UNITY).p(this);
                return;
            case R.id.vungle_btn:
                this.f31984b.get(AdsBase.Tag.VUNGLE).p(this);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ads);
        this.f31986d = (Button) findViewById(R.id.adcolony_btn);
        this.f31987e = (Button) findViewById(R.id.unityads_btn);
        this.f31988f = (Button) findViewById(R.id.vungle_btn);
        this.f31989g = (Button) findViewById(R.id.chartboost_btn);
        this.f31986d.setVisibility(4);
        this.f31987e.setVisibility(4);
        this.f31988f.setVisibility(4);
        this.f31989g.setVisibility(4);
        this.f31986d.setOnClickListener(this);
        this.f31987e.setOnClickListener(this);
        this.f31988f.setOnClickListener(this);
        this.f31989g.setOnClickListener(this);
        z();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).h();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).i();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).j();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).k();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        for (Map.Entry<AdsBase.Tag, AdsBase> value : this.f31984b.entrySet()) {
            ((AdsBase) value.getValue()).l();
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (GlobalVariable.c().b().getAds().getVungle().isEnable()) {
            MyVungleAds myVungleAds = new MyVungleAds();
            myVungleAds.f();
            this.f31984b.put(AdsBase.Tag.VUNGLE, myVungleAds);
        }
        if (GlobalVariable.c().b().getAds().getUnity_ads().isEnable()) {
            Unity_Ads unity_Ads = new Unity_Ads();
            unity_Ads.f();
            this.f31984b.put(AdsBase.Tag.UNITY, unity_Ads);
        }
    }
}
