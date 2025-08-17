package com.utils.kotlin;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.facebook.react.uimanager.ViewProps;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public final class AesHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AesHelper f37691a = new AesHelper();

    private AesHelper() {
    }

    public static /* synthetic */ Pair e(AesHelper aesHelper, byte[] bArr, byte[] bArr2, String str, int i2, int i3, int i4, int i5, Object obj) {
        int i6;
        int i7;
        int i8;
        if ((i5 & 4) != 0) {
            str = "MD5";
        }
        String str2 = str;
        if ((i5 & 8) != 0) {
            i6 = 32;
        } else {
            i6 = i2;
        }
        if ((i5 & 16) != 0) {
            i7 = 16;
        } else {
            i7 = i3;
        }
        if ((i5 & 32) != 0) {
            i8 = 1;
        } else {
            i8 = i4;
        }
        return aesHelper.d(bArr, bArr2, str2, i6, i7, i8);
    }

    @SuppressLint({"NewApi"})
    public final byte[] a(String str) {
        Intrinsics.f(str, "string");
        try {
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.c(decode);
            return decode;
        } catch (Exception unused) {
            byte[] a2 = java.util.Base64.getDecoder().decode(str);
            Intrinsics.c(a2);
            return a2;
        }
    }

    @SuppressLint({"NewApi"})
    public final String b(byte[] bArr) {
        Intrinsics.f(bArr, "array");
        try {
            byte[] encode = Base64.encode(bArr, 2);
            Intrinsics.e(encode, "encode(...)");
            return new String(encode, Charsets.f40518g);
        } catch (Exception unused) {
            byte[] a2 = java.util.Base64.getEncoder().encode(bArr);
            Intrinsics.e(a2, "encode(...)");
            return new String(a2, Charsets.f40513b);
        }
    }

    public final String c(String str, String str2, byte[] bArr, boolean z2, String str3) {
        Intrinsics.f(str, "s");
        Intrinsics.f(str2, "ct");
        Intrinsics.f(bArr, "pass");
        Intrinsics.f(str3, ViewProps.PADDING);
        Pair e2 = e(this, bArr, f(str), (String) null, 0, 0, 0, 60, (Object) null);
        if (e2 == null) {
            return null;
        }
        byte[] bArr2 = (byte[]) e2.a();
        byte[] bArr3 = (byte[]) e2.b();
        Cipher instance = Cipher.getInstance(str3);
        if (!z2) {
            instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            byte[] doFinal = instance.doFinal(a(str2));
            Intrinsics.e(doFinal, "doFinal(...)");
            return new String(doFinal, Charsets.f40513b);
        }
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        byte[] bytes = str2.getBytes(Charsets.f40513b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal2 = instance.doFinal(bytes);
        Intrinsics.e(doFinal2, "doFinal(...)");
        return b(doFinal2);
    }

    public final Pair<byte[], byte[]> d(byte[] bArr, byte[] bArr2, String str, int i2, int i3, int i4) {
        Intrinsics.f(bArr, "password");
        Intrinsics.f(bArr2, "salt");
        Intrinsics.f(str, "hashAlgorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int digestLength = instance.getDigestLength();
        int i5 = i3 + i2;
        byte[] bArr3 = new byte[((((i5 + digestLength) - 1) / digestLength) * digestLength)];
        try {
            instance.reset();
            for (int i6 = 0; i6 < i5; i6 += digestLength) {
                if (i6 > 0) {
                    instance.update(bArr3, i6 - digestLength, digestLength);
                }
                instance.update(bArr);
                instance.update(bArr2, 0, 8);
                instance.digest(bArr3, i6, digestLength);
                for (int i7 = 1; i7 < i4; i7++) {
                    instance.update(bArr3, i6, digestLength);
                    instance.digest(bArr3, i6, digestLength);
                }
            }
            return TuplesKt.a(ArraysKt___ArraysJvmKt.i(bArr3, 0, i2), ArraysKt___ArraysJvmKt.i(bArr3, i2, i5));
        } catch (DigestException unused) {
            return null;
        }
    }

    public final byte[] f(String str) {
        boolean z2;
        Intrinsics.f(str, "<this>");
        if (str.length() % 2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Iterable<String> Q0 = StringsKt___StringsKt.Q0(str, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(Q0, 10));
            for (String parseInt : Q0) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(parseInt, CharsKt__CharJVMKt.a(16))));
            }
            return CollectionsKt___CollectionsKt.W(arrayList);
        }
        throw new IllegalStateException("Must have an even length".toString());
    }
}
