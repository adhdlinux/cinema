package com.utils.subtitle.services;

import com.facebook.hermes.intl.Constants;
import com.startapp.de;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.ArrayList;

public class LanguageId {

    /* renamed from: b  reason: collision with root package name */
    static LanguageId f37746b;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Language> f37747a;

    public static class Language {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f37748a;

        /* renamed from: b  reason: collision with root package name */
        private String f37749b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f37750c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f37751d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f37752e = false;

        public Language(String str, String str2, String str3, String str4) {
            this.f37748a = str;
            this.f37749b = str2;
            this.f37750c = str3;
            this.f37751d = str4;
        }

        public String d() {
            return this.f37748a;
        }
    }

    public static LanguageId a() {
        if (f37746b == null) {
            LanguageId languageId = new LanguageId();
            f37746b = languageId;
            languageId.f37747a = new ArrayList<>();
            f37746b.f37747a.add(new Language("abk", "-1", "ab", "Abkhazian"));
            f37746b.f37747a.add(new Language("afr", "-1", "af", "Afrikaans"));
            f37746b.f37747a.add(new Language("alb", "1", "sq", "Albanian"));
            f37746b.f37747a.add(new Language("ara", TraktV2.API_VERSION, "ar", "Arabic"));
            f37746b.f37747a.add(new Language("arg", "-1", "an", "Aragonese"));
            f37746b.f37747a.add(new Language("arm", "73", "hy", "Armenian"));
            f37746b.f37747a.add(new Language("ast", "-1", "at", "Asturian"));
            f37746b.f37747a.add(new Language("aze", "55", "az", "Azerbaijani"));
            f37746b.f37747a.add(new Language("baq", "74", "eu", "Basque"));
            f37746b.f37747a.add(new Language("bel", "68", "be", "Belarusian"));
            f37746b.f37747a.add(new Language("ben", "54", "bn", "Bengali"));
            f37746b.f37747a.add(new Language("bos", "60", "bs", "Bosnian"));
            f37746b.f37747a.add(new Language("bre", "-1", "br", "Breton"));
            f37746b.f37747a.add(new Language("bul", "5", "bg", "Bulgarian"));
            f37746b.f37747a.add(new Language("bur", "61", "my", "Burmese"));
            f37746b.f37747a.add(new Language("cat", "49", "ca", "Catalan"));
            f37746b.f37747a.add(new Language("chi", "7", "zh", "Chinese (simplified)"));
            f37746b.f37747a.add(new Language("cze", "9", "cs", "Czech"));
            f37746b.f37747a.add(new Language("dan", "10", "da", "Danish"));
            f37746b.f37747a.add(new Language("dut", "11", "nl", "Dutch"));
            f37746b.f37747a.add(new Language("eng", "13", "en", "English"));
            f37746b.f37747a.add(new Language("epo", "47", "eo", "Esperanto"));
            f37746b.f37747a.add(new Language("est", "16", "et", "Estonian"));
            f37746b.f37747a.add(new Language("fin", "17", "fi", "Finnish"));
            f37746b.f37747a.add(new Language("fre", "18", "fr", "French"));
            f37746b.f37747a.add(new Language("geo", "62", "ka", "Georgian"));
            f37746b.f37747a.add(new Language("ger", "19", de.f34377a, "German"));
            f37746b.f37747a.add(new Language("gla", "-1", "gd", "Gaelic"));
            f37746b.f37747a.add(new Language("gle", "-1", "ga", "Irish"));
            f37746b.f37747a.add(new Language("glg", "-1", "gl", "Galician"));
            f37746b.f37747a.add(new Language("ell", "21", "el", "Greek"));
            f37746b.f37747a.add(new Language("heb", "22", "he", "Hebrew"));
            f37746b.f37747a.add(new Language("hin", "51", "hi", "Hindi"));
            f37746b.f37747a.add(new Language("hrv", "8", "hr", "Croatian"));
            f37746b.f37747a.add(new Language("hun", "23", "hu", "Hungarian"));
            f37746b.f37747a.add(new Language("ibo", "-1", "ig", "Igbo"));
            f37746b.f37747a.add(new Language("ice", "25", "is", "Icelandic"));
            f37746b.f37747a.add(new Language("ina", "-1", "ia", "Interlingua"));
            f37746b.f37747a.add(new Language("ind", "44", "id", "Indonesian"));
            f37746b.f37747a.add(new Language("ita", "26", "it", "Italian"));
            f37746b.f37747a.add(new Language("jpn", "27", "ja", "Japanese"));
            f37746b.f37747a.add(new Language("kan", "78", Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT, "Kannada"));
            f37746b.f37747a.add(new Language("kaz", "-1", "kk", "Kazakh"));
            f37746b.f37747a.add(new Language("khm", "-1", "km", "Khmer"));
            f37746b.f37747a.add(new Language("kor", "28", "ko", "Korean"));
            f37746b.f37747a.add(new Language("kur", "52", "ku", "Kurdish"));
            f37746b.f37747a.add(new Language("lav", "29", "lv", "Latvian"));
            f37746b.f37747a.add(new Language("lit", "43", "lt", "Lithuanian"));
            f37746b.f37747a.add(new Language("ltz", "-1", "lb", "Luxembourgish"));
            f37746b.f37747a.add(new Language("mac", "48", "mk", "Macedonian"));
            f37746b.f37747a.add(new Language("mal", "64", "ml", "Malayalam"));
            f37746b.f37747a.add(new Language("may", "50", "ms", "Malay"));
            f37746b.f37747a.add(new Language("mni", "65", "ma", "Manipuri"));
            f37746b.f37747a.add(new Language("mon", "72", "mn", "Mongolian"));
            f37746b.f37747a.add(new Language("nav", "-1", "nv", "Navajo"));
            f37746b.f37747a.add(new Language("nor", "30", "no", "Norwegian"));
            f37746b.f37747a.add(new Language("oci", "-1", "oc", "Occitan"));
            f37746b.f37747a.add(new Language("per", "-1", "fa", "Persian"));
            f37746b.f37747a.add(new Language("pol", "31", "pl", "Polish"));
            f37746b.f37747a.add(new Language("por", "32", "pt", "Portuguese"));
            f37746b.f37747a.add(new Language("rus", "34", "ru", "Russian"));
            f37746b.f37747a.add(new Language("scc", "35", "sr", "Serbian"));
            f37746b.f37747a.add(new Language("sin", "-1", "si", "Sinhalese"));
            f37746b.f37747a.add(new Language("slo", "36", "sk", "Slovak"));
            f37746b.f37747a.add(new Language("slv", "37", "sl", "Slovenian"));
            f37746b.f37747a.add(new Language("sme", "-1", "se", "Northern Sami"));
            f37746b.f37747a.add(new Language("snd", "-1", "sd", "Sindhi"));
            f37746b.f37747a.add(new Language("som", "70", "so", "Somali"));
            f37746b.f37747a.add(new Language("spa", "38", "es", "Spanish"));
            f37746b.f37747a.add(new Language("swa", "75", "sw", "Swahili"));
            f37746b.f37747a.add(new Language("swe", "39", "sv", "Swedish"));
            f37746b.f37747a.add(new Language("syr", "-1", "sy", "Syriac"));
            f37746b.f37747a.add(new Language("tam", "59", "ta", "Tamil"));
            f37746b.f37747a.add(new Language("tat", "-1", "tt", "Tatar"));
            f37746b.f37747a.add(new Language("tel", "63", "te", "Telugu"));
            f37746b.f37747a.add(new Language("tgl", "53", "tl", "Tagalog"));
            f37746b.f37747a.add(new Language("tha", "40", "th", "Thai"));
            f37746b.f37747a.add(new Language("tur", "41", "tr", "Turkish"));
            f37746b.f37747a.add(new Language("ukr", "56", "uk", "Ukrainian"));
            f37746b.f37747a.add(new Language("urd", "42", "ur", "Urdu"));
            f37746b.f37747a.add(new Language("vie", "45", "vi", "Vietnamese"));
            f37746b.f37747a.add(new Language("rum", "33", "ro", "Romanian"));
            f37746b.f37747a.add(new Language("pob", "-1", "pb", "Portuguese (BR)"));
            f37746b.f37747a.add(new Language("mne", "-1", "me", "Montenegrin"));
            f37746b.f37747a.add(new Language("zht", "7", "zt", "Chinese (traditional)"));
            f37746b.f37747a.add(new Language("zhe", "-1", "ze", "Chinese bilingual"));
            f37746b.f37747a.add(new Language("pom", "-1", "pm", "Portuguese (MZ)"));
            f37746b.f37747a.add(new Language("ext", "-1", "ex", "Extremaduran"));
        }
        return f37746b;
    }

    public String b(String str) {
        for (int i2 = 0; i2 < this.f37747a.size(); i2++) {
            if (this.f37747a.get(i2).f37748a.equals(str)) {
                return this.f37747a.get(i2).f37751d;
            }
        }
        return "";
    }

    public String c(String str) {
        for (int i2 = 0; i2 < this.f37747a.size(); i2++) {
            if (this.f37747a.get(i2).f37750c.equals(str)) {
                return this.f37747a.get(i2).f37751d;
            }
        }
        return "";
    }

    public String d(String str) {
        for (int i2 = 0; i2 < this.f37747a.size(); i2++) {
            if (this.f37747a.get(i2).f37750c.equals(str)) {
                return this.f37747a.get(i2).d();
            }
        }
        return "";
    }

    public String[] e() {
        String[] strArr = new String[this.f37747a.size()];
        for (int i2 = 0; i2 < this.f37747a.size(); i2++) {
            strArr[i2] = this.f37747a.get(i2).f37750c;
        }
        return strArr;
    }

    public String[] f() {
        String[] strArr = new String[this.f37747a.size()];
        for (int i2 = 0; i2 < this.f37747a.size(); i2++) {
            strArr[i2] = this.f37747a.get(i2).f37751d;
        }
        return strArr;
    }
}
