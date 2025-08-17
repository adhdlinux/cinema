package com.original.tase.helper.js;

import android.util.Base64;
import com.original.tase.Logger;
import com.squareup.duktape.Duktape;

public class AADecoder {

    private interface AADecode {
        String decode(String str);
    }

    /* JADX INFO: finally extract failed */
    public static String m30914(String str) {
        if (!m30915(str)) {
            return "";
        }
        Duktape create = Duktape.create();
        try {
            create.evaluate("var AADecode = {\n    decode: function(text) {\n        var evalPreamble = \"(ﾟДﾟ) ['_'] ( (ﾟДﾟ) ['_'] (\";\n        var decodePreamble = \"( (ﾟДﾟ) ['_'] (\";\n        var evalPostamble = \") (ﾟΘﾟ)) ('_');\";\n        var decodePostamble = \") ());\";\n        text = text.replace(/^\\s*/, \"\").replace(/\\s*$/, \"\");\n        if (/^\\s*$/.test(text)) return \"\";\n        if (text.lastIndexOf(evalPreamble) < 0) throw new Error(\"Given code is not encoded as aaencode.\");\n        if (text.lastIndexOf(evalPostamble) != text.length - evalPostamble.length) throw new Error(\"Given code is not encoded as aaencode.\");\n        var decodingScript = text.replace(evalPreamble, decodePreamble).replace(evalPostamble, decodePostamble);\n        return Duktape.enc(\"base64\", eval(decodingScript));\n    }\n};");
            String decode = ((AADecode) create.get("AADecode", AADecode.class)).decode(str);
            create.close();
            try {
                return new String(Base64.decode(decode, 0), "UTF-8");
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
                return "";
            }
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }

    public static boolean m30915(String str) {
        return str.contains("(ﾟωﾟﾉ");
    }
}
