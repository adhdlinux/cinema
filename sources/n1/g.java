package n1;

import android.view.View;
import com.yoku.house.ads.HouseAdsNative;
import com.yoku.house.ads.model.DialogModal;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HouseAdsNative f41305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogModal f41306c;

    public /* synthetic */ g(HouseAdsNative houseAdsNative, DialogModal dialogModal) {
        this.f41305b = houseAdsNative;
        this.f41306c = dialogModal;
    }

    public final void onClick(View view) {
        this.f41305b.g(this.f41306c, view);
    }
}
