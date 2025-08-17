package b1;

import android.content.DialogInterface;
import com.movie.ui.activity.player.PlayerActivity;
import java.util.List;
import kotlin.jvm.internal.Ref$FloatRef;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$FloatRef f29267b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f29268c;

    public /* synthetic */ a(Ref$FloatRef ref$FloatRef, List list) {
        this.f29267b = ref$FloatRef;
        this.f29268c = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        PlayerActivity.c2(this.f29267b, this.f29268c, dialogInterface, i2);
    }
}
