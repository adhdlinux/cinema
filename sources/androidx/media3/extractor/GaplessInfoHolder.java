package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f8035c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f8036a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f8037b = -1;

    private boolean b(String str) {
        Matcher matcher = f8035c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) Util.i(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) Util.i(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f8036a = parseInt;
            this.f8037b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f8036a == -1 || this.f8037b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) e2;
                if ("iTunSMPB".equals(commentFrame.f8317d) && b(commentFrame.f8318e)) {
                    return true;
                }
            } else if (e2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) e2;
                if ("com.apple.iTunes".equals(internalFrame.f8330c) && "iTunSMPB".equals(internalFrame.f8331d) && b(internalFrame.f8332e)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
