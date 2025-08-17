package n1;

import android.content.DialogInterface;
import com.yoku.house.ads.HouseAdsDialog;

public final /* synthetic */ class b implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HouseAdsDialog f41299b;

    public /* synthetic */ b(HouseAdsDialog houseAdsDialog) {
        this.f41299b = houseAdsDialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f41299b.j(dialogInterface);
    }
}
