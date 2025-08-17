package e1;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.original.tase.helper.PlayerHelper;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper.PlayData f38173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f38174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38175d;

    public /* synthetic */ a(PlayerHelper.PlayData playData, AppCompatActivity appCompatActivity, PlayerHelper playerHelper) {
        this.f38173b = playData;
        this.f38174c = appCompatActivity;
        this.f38175d = playerHelper;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerHelper.B(this.f38173b, this.f38174c, this.f38175d, dialogInterface, i2);
    }
}
