package n1;

import android.view.View;
import com.yoku.house.ads.HouseAdsNative;
import com.yoku.house.ads.model.DialogModal;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HouseAdsNative f41307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogModal f41308c;

    public /* synthetic */ h(HouseAdsNative houseAdsNative, DialogModal dialogModal) {
        this.f41307b = houseAdsNative;
        this.f41308c = dialogModal;
    }

    public final void onClick(View view) {
        this.f41307b.h(this.f41308c, view);
    }
}
