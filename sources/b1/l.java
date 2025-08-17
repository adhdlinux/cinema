package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import kotlin.jvm.internal.Ref$FloatRef;

public final /* synthetic */ class l implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29292b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$FloatRef f29293c;

    public /* synthetic */ l(PlayerActivity playerActivity, Ref$FloatRef ref$FloatRef) {
        this.f29292b = playerActivity;
        this.f29293c = ref$FloatRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.d2(this.f29292b, this.f29293c, dialogInterface, i2);
    }
}
