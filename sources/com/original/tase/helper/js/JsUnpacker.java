package com.original.tase.helper.js;

import android.util.Base64;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.original.tase.Logger;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import com.squareup.duktape.Duktape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JsUnpacker {

    private interface Unpacker {
        String unpack(String str);
    }

    public static ArrayList<String> m30916(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(m30917(str));
        arrayList.addAll(m30918(str));
        return arrayList;
    }

    public static ArrayList<String> m30917(String str) {
        int i2;
        boolean z2;
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<String>> d2 = Regex.d(str, "\\}\\s*\\('(.*)',\\s*(.*?),\\s*(\\d+),\\s*'([^']+)'\\.split\\('\\|'\\)", 4);
        ArrayList arrayList2 = d2.get(0);
        ArrayList arrayList3 = d2.get(1);
        ArrayList arrayList4 = d2.get(2);
        ArrayList arrayList5 = d2.get(3);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            try {
                HashMap hashMap = new HashMap();
                String str3 = (String) arrayList2.get(i3);
                String str4 = (String) arrayList3.get(i3);
                String str5 = (String) arrayList4.get(i3);
                String str6 = (String) arrayList5.get(i3);
                if (Utils.o(str4)) {
                    i2 = Integer.parseInt(str4);
                } else {
                    i2 = 36;
                }
                int parseInt = Integer.parseInt(str5);
                String[] split = str6.split("\\|");
                while (parseInt > 0) {
                    parseInt--;
                    String m30919 = m30919(parseInt, i2);
                    if (split.length <= parseInt || split[parseInt] == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        str2 = split[parseInt];
                    } else {
                        str2 = m30919;
                    }
                    hashMap.put(m30919, str2);
                }
                StringBuilder sb = new StringBuilder();
                for (char c2 : str3.toCharArray()) {
                    if (!Regex.a(String.valueOf(c2), "\\b(\\w+)\\b", 1).isEmpty()) {
                        sb.append((String) hashMap.get(String.valueOf(c2)));
                    } else {
                        sb.append(c2);
                    }
                }
                arrayList.add(sb.toString().replace("\\'", "'").replace("\\\"", "\""));
            } catch (Exception e2) {
                Logger.d(e2, new boolean[0]);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> m30918(String str) {
        String str2;
        Duktape create = Duktape.create();
        ArrayList<String> arrayList = new ArrayList<>();
        String str3 = "";
        try {
            create.evaluate("//\n// Unpacker for Dean Edward's p.a.c.k.e.r, a part of javascript beautifier\n// written by Einar Lielmanis <einar@jsbeautifier.org>\n// edited by NitroXenon for Terrarium TV\n//\n// Coincidentally, it can defeat a couple of other eval-based compressors.\n//\n// usage:\n//\n// if (P_A_C_K_E_R.detect(some_string)) {\n//     var unpacked = P_A_C_K_E_R.unpack(some_string);\n// }\n//\n//\nvar Unpacker = {\n    PATTERN: /(eval\\s*\\(\\(?function\\(.*?(,0,\\{\\}\\)\\)|split\\('\\|'\\)\\)\\)))/g,\n\n    unpack: function(html) {\n        var results = [];\n        var matches = getMatches(html, Unpacker.PATTERN, 1)\n        for (var i = 0; i < matches.length; i++) {\n            try {\n               var match = matches[i];\n               results.push(P_A_C_K_E_R.unpack(match));\n            } catch (lErr) {}\n        }\n\n        return Duktape.enc('base64', JSON.stringify(results));\n    },\n}\n\nvar P_A_C_K_E_R = {\n    PATTERN: /eval\\s*\\(\\(?function\\(.*?(,0,\\{\\}\\)\\)|split\\('\\|'\\)\\)\\))/g,\n\n    detect: function(str) {\n        return (P_A_C_K_E_R.get_chunks(str).length > 0);\n    },\n\n    get_chunks: function(str) {\n        var chunks = str.match(P_A_C_K_E_R.PATTERN);\n        return chunks ? chunks : [];\n    },\n\n    unpack: function(str) {\n        var chunks = P_A_C_K_E_R.get_chunks(str),\n            chunk;\n        for (var i = 0; i < chunks.length; i++) {\n            chunk = chunks[i].replace(/\\n$/, '');\n            str = str.split(chunk).join(P_A_C_K_E_R.unpack_chunk(chunk));\n        }\n        return str;\n    },\n\n    unpack_chunk: function(str) {\n        var unpacked_source = '';\n        var __eval = eval;\n        if (P_A_C_K_E_R.detect(str)) {\n            try {\n                eval = function(s) { // jshint ignore:line\n                    unpacked_source += s;\n                    return unpacked_source;\n                }; // jshint ignore:line\n                __eval(str);\n                if (typeof unpacked_source === 'string' && unpacked_source) {\n                    str = unpacked_source;\n                }\n            } catch (e) {\n                //console.log(e.toString());\n            }\n        }\n        eval = __eval; // jshint ignore:line\n        return str;\n    },\n};\n\nfunction getMatches(string, regex, index) {\n    index || (index = 1); // default to the first capturing group\n    var matches = [];\n    var match;\n    while (match = regex.exec(string)) {\n        matches.push(match[index]);\n    }\n    return matches;\n}");
            str3 = ((Unpacker) create.get("Unpacker", Unpacker.class)).unpack(str);
            str2 = new String(Base64.decode(str3, 0), "UTF-8");
        } catch (Throwable th) {
            create.close();
            throw th;
        }
        create.close();
        if (str2.isEmpty()) {
            return arrayList;
        }
        try {
            Iterator<JsonElement> it2 = new JsonParser().a(str2).b().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().e());
            }
        } catch (Throwable th2) {
            Logger.d(th2, new boolean[0]);
        }
        return arrayList;
    }

    private static String m30919(int i2, int i3) throws Exception {
        String substring = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, i3);
        if (substring.length() > i3) {
            throw new Exception("base " + i3 + " exceeds table length " + substring.length());
        } else if (i2 == 0) {
            return Character.toString(substring.charAt(0));
        } else {
            StringBuilder sb = new StringBuilder();
            while (i2 > 0) {
                sb.insert(0, Character.toString(substring.charAt(i2 % i3)));
                i2 /= i3;
            }
            return sb.toString();
        }
    }

    public static boolean m30920(String str) {
        return !Regex.c(str, "(eval\\s*\\(\\(?function\\(.*?(,0,\\{\\}\\)\\)|split\\('\\|'\\)\\)\\)))", 1, true).isEmpty();
    }
}
