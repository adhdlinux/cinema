package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder extends SimpleMetadataDecoder {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f25388c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a  reason: collision with root package name */
    private final CharsetDecoder f25389a = Charsets.UTF_8.newDecoder();

    /* renamed from: b  reason: collision with root package name */
    private final CharsetDecoder f25390b = Charsets.ISO_8859_1.newDecoder();

    /* JADX INFO: finally extract failed */
    private String c(ByteBuffer byteBuffer) {
        try {
            return this.f25389a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.f25390b.decode(byteBuffer).toString();
                this.f25390b.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.f25390b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f25390b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f25389a.reset();
            byteBuffer.rewind();
        }
    }

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String c2 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c2 == null) {
            return new Metadata(new IcyInfo(bArr, (String) null, (String) null));
        }
        Matcher matcher = f25388c.matcher(c2);
        String str2 = null;
        for (int i2 = 0; matcher.find(i2); i2 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String e2 = Ascii.e(group);
                e2.hashCode();
                if (e2.equals("streamurl")) {
                    str2 = group2;
                } else if (e2.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
