package e1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.player.BasePlayer;

public final /* synthetic */ class m implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BasePlayer f38193b;

    public /* synthetic */ m(PlayerHelper playerHelper, BasePlayer basePlayer) {
        this.f38192a = playerHelper;
        this.f38193b = basePlayer;
    }

    public final void a(Object obj) {
        PlayerHelper.I(this.f38192a, this.f38193b, (ActivityResult) obj);
    }
}
