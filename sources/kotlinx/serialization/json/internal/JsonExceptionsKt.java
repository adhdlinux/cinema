package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class JsonExceptionsKt {
    public static final JsonDecodingException a(Number number, String str, String str2) {
        Intrinsics.f(number, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Intrinsics.f(str, "key");
        Intrinsics.f(str2, "output");
        return e(-1, k(number, str, str2));
    }

    public static final JsonEncodingException b(Number number, String str) {
        Intrinsics.f(number, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Intrinsics.f(str, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + i(str, 0, 1, (Object) null));
    }

    public static final JsonEncodingException c(Number number, String str, String str2) {
        Intrinsics.f(number, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Intrinsics.f(str, "key");
        Intrinsics.f(str2, "output");
        return new JsonEncodingException(k(number, str, str2));
    }

    public static final JsonEncodingException d(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + serialDescriptor.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.d() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException e(int i2, String str) {
        Intrinsics.f(str, "message");
        if (i2 >= 0) {
            str = "Unexpected JSON token at offset " + i2 + ": " + str;
        }
        return new JsonDecodingException(str);
    }

    public static final JsonDecodingException f(int i2, String str, CharSequence charSequence) {
        Intrinsics.f(str, "message");
        Intrinsics.f(charSequence, "input");
        return e(i2, str + "\nJSON input: " + h(charSequence, i2));
    }

    public static final JsonDecodingException g(String str, String str2) {
        Intrinsics.f(str, "key");
        Intrinsics.f(str2, "input");
        return e(-1, "Encountered unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + i(str2, 0, 1, (Object) null));
    }

    private static final CharSequence h(CharSequence charSequence, int i2) {
        String str;
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str2 = ".....";
        if (i2 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return str2 + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i3 = i2 - 30;
        int i4 = i2 + 30;
        if (i3 <= 0) {
            str = "";
        } else {
            str = str2;
        }
        if (i4 >= charSequence.length()) {
            str2 = "";
        }
        return str + charSequence.subSequence(RangesKt___RangesKt.b(i3, 0), RangesKt___RangesKt.d(i4, charSequence.length())).toString() + str2;
    }

    static /* synthetic */ CharSequence i(CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        return h(charSequence, i2);
    }

    public static final Void j(AbstractJsonLexer abstractJsonLexer, Number number) {
        Intrinsics.f(abstractJsonLexer, "<this>");
        Intrinsics.f(number, "result");
        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private static final String k(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + i(str2, 0, 1, (Object) null);
    }
}
