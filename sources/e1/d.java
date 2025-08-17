package e1;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.player.BasePlayer;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BasePlayer f38178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38179c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f38180d;

    public /* synthetic */ d(BasePlayer basePlayer, PlayerHelper playerHelper, AppCompatActivity appCompatActivity) {
        this.f38178b = basePlayer;
        this.f38179c = playerHelper;
        this.f38180d = appCompatActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerHelper.Y(this.f38178b, this.f38179c, this.f38180d, dialogInterface, i2);
    }
}
