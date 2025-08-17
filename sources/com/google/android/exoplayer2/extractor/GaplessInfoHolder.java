package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f24223c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f24224a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f24225b = -1;

    private boolean b(String str) {
        Matcher matcher = f24223c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) Util.j(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) Util.j(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f24224a = parseInt;
            this.f24225b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f24224a == -1 || this.f24225b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) e2;
                if ("iTunSMPB".equals(commentFrame.f25417d) && b(commentFrame.f25418e)) {
                    return true;
                }
            } else if (e2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) e2;
                if ("com.apple.iTunes".equals(internalFrame.f25429c) && "iTunSMPB".equals(internalFrame.f25430d) && b(internalFrame.f25431e)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i2) {
        int i3 = i2 >> 12;
        int i4 = i2 & 4095;
        if (i3 <= 0 && i4 <= 0) {
            return false;
        }
        this.f24224a = i3;
        this.f24225b = i4;
        return true;
    }
}
