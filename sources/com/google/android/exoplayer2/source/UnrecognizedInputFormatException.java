package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException {

    /* renamed from: d  reason: collision with root package name */
    public final Uri f26013d;

    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str, (Throwable) null, false, 1);
        this.f26013d = uri;
    }
}
