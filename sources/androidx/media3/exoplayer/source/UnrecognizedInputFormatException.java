package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.SniffFailure;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class UnrecognizedInputFormatException extends ParserException {

    /* renamed from: d  reason: collision with root package name */
    public final Uri f7181d;

    /* renamed from: e  reason: collision with root package name */
    public final ImmutableList<SniffFailure> f7182e;

    public UnrecognizedInputFormatException(String str, Uri uri, List<? extends SniffFailure> list) {
        super(str, (Throwable) null, false, 1);
        this.f7181d = uri;
        this.f7182e = ImmutableList.n(list);
    }
}
