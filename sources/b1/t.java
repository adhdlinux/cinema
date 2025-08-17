package b1;

import com.movie.ui.activity.player.PlayerActivity;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class t implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        return PlayerActivity.f1(str, sSLSession);
    }
}
