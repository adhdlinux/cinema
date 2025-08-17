package e1;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.original.tase.helper.PlayerHelper;

public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper.PlayData f38185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f38186c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38187d;

    public /* synthetic */ j(PlayerHelper.PlayData playData, AppCompatActivity appCompatActivity, PlayerHelper playerHelper) {
        this.f38185b = playData;
        this.f38186c = appCompatActivity;
        this.f38187d = playerHelper;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerHelper.C(this.f38185b, this.f38186c, this.f38187d, dialogInterface, i2);
    }
}
