package e;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {
    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRenderedFirstFrame();
    }
}
