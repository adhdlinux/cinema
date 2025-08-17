package com.movie.ui.activity.player.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.ui.CaptionStyleCompat;
import androidx.media3.ui.SubtitleView;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.util.UriUtil;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.google.android.gms.common.internal.ImagesContract;
import com.movie.FreeMoviesApp;
import com.movie.data.model.SaveCaptionStyle;
import com.startapp.ae;
import com.startapp.de;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class SubtitleHelper {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f32477g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Set<SubtitleData> f32478a = SetsKt__SetsKt.b();

    /* renamed from: b  reason: collision with root package name */
    private Set<SubtitleData> f32479b = SetsKt__SetsKt.b();

    /* renamed from: c  reason: collision with root package name */
    private SaveCaptionStyle f32480c;

    /* renamed from: d  reason: collision with root package name */
    private SubtitleView f32481d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f32482e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final List<Language639> f32483f = CollectionsKt__CollectionsKt.i(new Language639("Abkhaz", "аҧсуа бызшәа, аҧсшәа", "ab", "abk", "abk", "abk", "abks"), new Language639("Afar", "Afaraf", "aa", "aar", "aar", "aar", "aars"), new Language639("Afrikaans", "Afrikaans", "af", "afr", "afr", "afr", "afrs"), new Language639("Akan", "Akan", "ak", "aka", "aka", "aka", ""), new Language639("Albanian", "Shqip", "sq", "sqi", "", "sqi", ""), new Language639("Amharic", "አማርኛ", "am", "amh", "amh", "amh", ""), new Language639("Arabic", "العربية", "ar", "ara", "ara", "ara", ""), new Language639("Aragonese", "aragonés", "an", "arg", "arg", "arg", ""), new Language639("Armenian", "Հայերեն", "hy", "hye", "", "hye", ""), new Language639("Assamese", "অসমীয়া", "as", "asm", "asm", "asm", ""), new Language639("Avaric", "авар мацӀ, магӀарул мацӀ", "av", "ava", "ava", "ava", ""), new Language639("Avestan", "avesta", ae.f34224a, "ave", "ave", "ave", ""), new Language639("Aymara", "aymar aru", "ay", "aym", "aym", "aym", ""), new Language639("Azerbaijani", "azərbaycan dili", "az", "aze", "aze", "aze", ""), new Language639("Bambara", "bamanankan", "bm", "bam", "bam", "bam", ""), new Language639("Bashkir", "башҡорт теле", "ba", "bak", "bak", "bak", ""), new Language639("Basque", "euskara, euskera", "eu", "eus", "", "eus", ""), new Language639("Belarusian", "беларуская мова", "be", "bel", "bel", "bel", ""), new Language639("Bengali", "বাংলা", "bn", "ben", "ben", "ben", ""), new Language639("Bihari", "भोजपुरी", "bh", "bih", "bih", "", ""), new Language639("Bislama", "Bislama", "bi", "bis", "bis", "bis", ""), new Language639("Bosnian", "bosanski jezik", "bs", "bos", "bos", "bos", "boss"), new Language639("Breton", "brezhoneg", "br", "bre", "bre", "bre", ""), new Language639("Bulgarian", "български език", "bg", "bul", "bul", "bul", "buls"), new Language639("Burmese", "ဗမာစာ", "my", "mya", "", "mya", ""), new Language639("Catalan", "català", "ca", "cat", "cat", "cat", ""), new Language639("Chamorro", "Chamoru", "ch", "cha", "cha", "cha", ""), new Language639("Chechen", "нохчийн мотт", "ce", "che", "che", "che", ""), new Language639("Chichewa", "chiCheŵa, chinyanja", "ny", "nya", "nya", "nya", ""), new Language639("Chinese", "中文 (Zhōngwén), 汉语, 漢語", "zh", "zho", "", "zho", ""), new Language639("Chuvash", "чӑваш чӗлхи", "cv", "chv", "chv", "chv", ""), new Language639("Cornish", "Kernewek", "kw", "cor", "cor", "cor", ""), new Language639("Corsican", "corsu, lingua corsa", Constants.COLLATION_EXTENSION_KEY_SHORT, "cos", "cos", "cos", ""), new Language639("Cree", "ᓀᐦᐃᔭᐍᐏᐣ", "cr", "cre", "cre", "cre", ""), new Language639("Croatian", "hrvatski jezik", "hr", "hrv", "hrv", "hrv", ""), new Language639("Czech", "čeština, český jazyk", "cs", "ces", "", "ces", ""), new Language639("Danish", "dansk", "da", "dan", "dan", "dan", ""), new Language639("Divehi", "ދިވެހި", "dv", "div", "div", "div", ""), new Language639("Dutch", "Nederlands, Vlaams", "nl", "nld", "", "nld", ""), new Language639("Dzongkha", "རྫོང་ཁ", "dz", "dzo", "dzo", "dzo", ""), new Language639("English", "English", "en", "eng", "eng", "eng", "engs"), new Language639("Esperanto", "Esperanto", "eo", "epo", "epo", "epo", ""), new Language639("Estonian", "eesti, eesti keel", "et", "est", "est", "est", ""), new Language639("Ewe", "Eʋegbe", "ee", "ewe", "ewe", "ewe", ""), new Language639("Faroese", "føroyskt", "fo", "fao", "fao", "fao", ""), new Language639("Fijian", "vosa Vakaviti", "fj", "fij", "fij", "fij", ""), new Language639("Finnish", "suomi, suomen kieli", "fi", "fin", "fin", "fin", ""), new Language639("French", "français, langue française", "fr", "fra", "", "fra", "fras"), new Language639("Fula", "Fulfulde, Pulaar, Pular", "ff", "ful", "ful", "ful", ""), new Language639("Galician", "galego", "gl", "glg", "glg", "glg", ""), new Language639("Georgian", "ქართული", "ka", "kat", "", "kat", ""), new Language639("German", "Deutsch", de.f34377a, "deu", "", "deu", "deus"), new Language639("Greek", "ελληνικά", "el", "ell", "", "ell", "ells"), new Language639("Guaraní", "Avañe'ẽ", "gn", "grn", "grn", "grn", ""), new Language639("Gujarati", "ગુજરાતી", "gu", "guj", "guj", "guj", ""), new Language639("Haitian", "Kreyòl ayisyen", "ht", "hat", "hat", "hat", ""), new Language639("Hausa", "(Hausa) هَوُسَ", "ha", "hau", "hau", "hau", ""), new Language639("Hebrew", "עברית", "he", "heb", "heb", "heb", ""), new Language639("Herero", "Otjiherero", "hz", "her", "her", "her", ""), new Language639("Hindi", "हिन्दी, हिंदी", "hi", "hin", "hin", "hin", "hins"), new Language639("Hiri Motu", "Hiri Motu", "ho", "hmo", "hmo", "hmo", ""), new Language639("Hungarian", "magyar", "hu", "hun", "hun", "hun", ""), new Language639("Interlingua", "Interlingua", "ia", "ina", "ina", "ina", ""), new Language639("Indonesian", "Bahasa Indonesia", "id", "ind", "ind", "ind", ""), new Language639("Interlingue", "Originally called Occidental; then Interlingue after WWII", "ie", "ile", "ile", "ile", ""), new Language639("Irish", "Gaeilge", "ga", "gle", "gle", "gle", ""), new Language639("Igbo", "Asụsụ Igbo", "ig", "ibo", "ibo", "ibo", ""), new Language639("Inupiaq", "Iñupiaq, Iñupiatun", "ik", "ipk", "ipk", "ipk", ""), new Language639("Ido", "Ido", "io", "ido", "ido", "ido", "idos"), new Language639("Icelandic", "Íslenska", "is", "isl", "", "isl", ""), new Language639("Italian", "italiano", "it", "ita", "ita", "ita", "itas"), new Language639("Inuktitut", "ᐃᓄᒃᑎᑐᑦ", "iu", "iku", "iku", "iku", ""), new Language639("Japanese", "日本語 (にほんご)", "ja", "jpn", "jpn", "jpn", ""), new Language639("Javanese", "ꦧꦱꦗꦮ", "jv", "jav", "jav", "jav", ""), new Language639("Kalaallisut", "kalaallisut, kalaallit oqaasii", "kl", "kal", "kal", "kal", ""), new Language639("Kannada", "ಕನ್ನಡ", Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT, "kan", "kan", "kan", ""), new Language639("Kanuri", "Kanuri", "kr", "kau", "kau", "kau", ""), new Language639("Kashmiri", "कश्मीरी, كشميري‎", "ks", "kas", "kas", "kas", ""), new Language639("Kazakh", "қазақ тілі", "kk", "kaz", "kaz", "kaz", ""), new Language639("Khmer", "ខ្មែរ, ខេមរភាសា, ភាសាខ្មែរ", "km", "khm", "khm", "khm", ""), new Language639("Kikuyu", "Gĩkũyũ", "ki", "kik", "kik", "kik", ""), new Language639("Kinyarwanda", "Ikinyarwanda", "rw", "kin", "kin", "kin", ""), new Language639("Kyrgyz", "Кыргызча, Кыргыз тили", "ky", "kir", "kir", "kir", ""), new Language639("Komi", "коми кыв", "kv", "kom", "kom", "kom", ""), new Language639("Kongo", "Kikongo", "kg", "kon", "kon", "kon", ""), new Language639("Korean", "한국어, 조선어", "ko", "kor", "kor", "kor", ""), new Language639("Kurdish", "Kurdî, كوردی‎", "ku", "kur", "kur", "kur", ""), new Language639("Kwanyama", "Kuanyama", "kj", "kua", "kua", "kua", ""), new Language639("Latin", "latine, lingua latina", "la", "lat", "lat", "lat", "lats"), new Language639("Luxembourgish", "Lëtzebuergesch", "lb", "ltz", "ltz", "ltz", ""), new Language639("Ganda", "Luganda", "lg", "lug", "lug", "lug", ""), new Language639("Limburgish", "Limburgs", "li", "lim", "lim", "lim", ""), new Language639("Lingala", "Lingála", "ln", "lin", "lin", "lin", ""), new Language639("Lao", "ພາສາລາວ", "lo", "lao", "lao", "lao", ""), new Language639("Lithuanian", "lietuvių kalba", "lt", "lit", "lit", "lit", ""), new Language639("Luba-Katanga", "Tshiluba", "lu", "lub", "lub", "lub", ""), new Language639("Latvian", "latviešu valoda", "lv", "lav", "lav", "lav", ""), new Language639("Manx", "Gaelg, Gailck", "gv", "glv", "glv", "glv", ""), new Language639("Macedonian", "македонски јазик", "mk", "mkd", "", "mkd", ""), new Language639("Malagasy", "fiteny malagasy", "mg", "mlg", "mlg", "mlg", ""), new Language639("Malay", "bahasa Melayu, بهاس ملايو‎", "ms", "msa", "", "msa", ""), new Language639("Malayalam", "മലയാളം", "ml", "mal", "mal", "mal", ""), new Language639("Maltese", "Malti", "mt", "mlt", "mlt", "mlt", ""), new Language639("Māori", "te reo Māori", "mi", "mri", "", "mri", ""), new Language639("Marathi", "मराठी", "mr", "mar", "mar", "mar", ""), new Language639("Marshallese", "Kajin M̧ajeļ", "mh", "mah", "mah", "mah", ""), new Language639("Mongolian", "Монгол хэл", "mn", "mon", "mon", "mon", ""), new Language639("Nauruan", "Dorerin Naoero", "na", "nau", "nau", "nau", ""), new Language639("Navajo", "Diné bizaad", "nv", "nav", "nav", "nav", ""), new Language639("Northern Ndebele", "isiNdebele", "nd", "nde", "nde", "nde", ""), new Language639("Nepali", "नेपाली", "ne", "nep", "nep", "nep", ""), new Language639("Ndonga", "Owambo", "ng", "ndo", "ndo", "ndo", ""), new Language639("Norwegian Bokmål", "Norsk bokmål", "nb", "nob", "nob", "nob", ""), new Language639("Norwegian Nynorsk", "Norsk nynorsk", "nn", "nno", "nno", "nno", ""), new Language639("Norwegian", "Norsk", "no", "nor", "nor", "nor", ""), new Language639("Nuosu", "ꆈꌠ꒿ Nuosuhxop", "ii", "iii", "iii", "iii", ""), new Language639("Southern Ndebele", "isiNdebele", "nr", "nbl", "nbl", "nbl", ""), new Language639("Occitan", "occitan, lenga d'òc", "oc", "oci", "oci", "oci", ""), new Language639("Ojibwe", "ᐊᓂᔑᓈᐯᒧᐎᓐ", "oj", "oji", "oji", "oji", ""), new Language639("Old Church Slavonic", "ѩзыкъ словѣньскъ", "cu", "chu", "chu", "chu", ""), new Language639("Oromo", "Afaan Oromoo", "om", "orm", "orm", "orm", ""), new Language639("Oriya", "ଓଡ଼ିଆ", "or", "ori", "ori", "ori", ""), new Language639("Ossetian", "ирон æвзаг", "os", "oss", "oss", "oss", ""), new Language639("Panjabi", "ਪੰਜਾਬੀ, پنجابی‎", "pa", "pan", "pan", "pan", ""), new Language639("Pāli", "पाऴि", ContextChain.TAG_PRODUCT_AND_INFRA, "pli", "pli", "pli", ""), new Language639("Persian", "فارسی", "fa", "fas", "", "fas", ""), new Language639("Polish", "język polski, polszczyzna", "pl", "pol", "pol", "pol", "pols"), new Language639("Pashto", "پښتو", "ps", "pus", "pus", "pus", ""), new Language639("Portuguese", "português", "pt-pt", "por", "por", "por", ""), new Language639("Portuguese (Brazilian)", "português", "pt-br", "por", "por", "por", ""), new Language639("Quechua", "Runa Simi, Kichwa", "qu", "que", "que", "que", ""), new Language639("Romansh", "rumantsch grischun", "rm", "roh", "roh", "roh", ""), new Language639("Kirundi", "Ikirundi", "rn", "run", "run", "run", ""), new Language639("Reunion Creole", "Kréol Rénioné", "rc", "rcf", "rcf", "rcf", ""), new Language639("Romanian", "limba română", "ro", "ron", "", "ron", ""), new Language639("Russian", "Русский", "ru", "rus", "rus", "rus", ""), new Language639("Sanskrit", "संस्कृतम्", "sa", "san", "san", "san", ""), new Language639("Sardinian", "sardu", "sc", "srd", "srd", "srd", ""), new Language639("Sindhi", "सिन्धी, سنڌي، سندھی‎", "sd", "snd", "snd", "snd", ""), new Language639("Northern Sami", "Davvisámegiella", "se", "sme", "sme", "sme", ""), new Language639("Samoan", "gagana fa'a Samoa", "sm", "smo", "smo", "smo", ""), new Language639("Sango", "yângâ tî sängö", "sg", "sag", "sag", "sag", ""), new Language639("Serbian", "српски језик", "sr", "srp", "srp", "srp", ""), new Language639("Scottish Gaelic", "Gàidhlig", "gd", "gla", "gla", "gla", ""), new Language639("Shona", "chiShona", "sn", "sna", "sna", "sna", ""), new Language639("Sinhalese", "සිංහල", "si", "sin", "sin", "sin", ""), new Language639("Slovak", "slovenčina, slovenský jazyk", "sk", "slk", "", "slk", ""), new Language639("Slovene", "slovenski jezik, slovenščina", "sl", "slv", "slv", "slv", ""), new Language639("Somali", "Soomaaliga, af Soomaali", "so", "som", "som", "som", ""), new Language639("Southern Sotho", "Sesotho", "st", "sot", "sot", "sot", ""), new Language639("Spanish", "español", "es", "spa", "spa", "spa", ""), new Language639("Sundanese", "Basa Sunda", "su", "sun", "sun", "sun", ""), new Language639("Swahili", "Kiswahili", "sw", "swa", "swa", "swa", ""), new Language639("Swati", "SiSwati", "ss", "ssw", "ssw", "ssw", ""), new Language639("Swedish", "svenska", "sv", "swe", "swe", "swe", ""), new Language639("Tamil", "தமிழ்", "ta", "tam", "tam", "tam", ""), new Language639("Telugu", "తెలుగు", "te", "tel", "tel", "tel", ""), new Language639("Tajik", "тоҷикӣ, toçikī, تاجیکی‎", "tg", "tgk", "tgk", "tgk", ""), new Language639("Thai", "ไทย", "th", "tha", "tha", "tha", ""), new Language639("Tigrinya", "ትግርኛ", "ti", "tir", "tir", "tir", ""), new Language639("Tibetan Standard", "བོད་ཡིག", "bo", "bod", "", "bod", ""), new Language639("Turkmen", "Türkmen, Түркмен", "tk", "tuk", "tuk", "tuk", ""), new Language639("Tagalog", "Wikang Tagalog", "tl", "tgl", "tgl", "tgl", ""), new Language639("Tswana", "Setswana", "tn", "tsn", "tsn", "tsn", ""), new Language639("Tonga", "faka Tonga", "to", "ton", "ton", "ton", ""), new Language639("Turkish", "Türkçe", "tr", "tur", "tur", "tur", ""), new Language639("Tsonga", "Xitsonga", HlsSegmentFormat.TS, "tso", "tso", "tso", ""), new Language639("Tatar", "татар теле, tatar tele", "tt", "tat", "tat", "tat", ""), new Language639("Twi", "Twi", "tw", "twi", "twi", "twi", ""), new Language639("Tahitian", "Reo Tahiti", "ty", "tah", "tah", "tah", ""), new Language639("Uyghur", "ئۇيغۇرچە‎, Uyghurche", "ug", "uig", "uig", "uig", ""), new Language639("Ukrainian", "Українська", "uk", "ukr", "ukr", "ukr", ""), new Language639("Urdu", "اردو", "ur", "urd", "urd", "urd", ""), new Language639("Uzbek", "Oʻzbek, Ўзбек, أۇزبېك‎", "uz", "uzb", "uzb", "uzb", ""), new Language639("Venda", "Tshivenḓa", "ve", "ven", "ven", "ven", ""), new Language639("Vietnamese", "Tiếng Việt", "vi", "vie", "vie", "vie", ""), new Language639("Volapük", "Volapük", "vo", "vol", "vol", "vol", ""), new Language639("Walloon", "walon", "wa", "wln", "wln", "wln", ""), new Language639("Welsh", "Cymraeg", "cy", "cym", "", "cym", ""), new Language639("Wolof", "Wollof", "wo", "wol", "wol", "wol", ""), new Language639("Western Frisian", "Frysk", "fy", "fry", "fry", "fry", ""), new Language639("Xhosa", "isiXhosa", "xh", "xho", "xho", "xho", ""), new Language639("Yiddish", "ייִדיש", "yi", "yid", "yid", "yid", ""), new Language639("Yoruba", "Yorùbá", "yo", "yor", "yor", "yor", ""), new Language639("Zhuang", "Saɯ cueŋƅ, Saw cuengh", "za", "zha", "zha", "zha", ""), new Language639("Zulu", "isiZulu", "zu", "zul", "zul", "zul", ""));

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Language639 {

        /* renamed from: a  reason: collision with root package name */
        private final String f32484a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32485b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32486c;

        /* renamed from: d  reason: collision with root package name */
        private final String f32487d;

        /* renamed from: e  reason: collision with root package name */
        private final String f32488e;

        /* renamed from: f  reason: collision with root package name */
        private final String f32489f;

        /* renamed from: g  reason: collision with root package name */
        private final String f32490g;

        public Language639(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.f(str, "languageName");
            Intrinsics.f(str2, "nativeName");
            Intrinsics.f(str3, "ISO_639_1");
            Intrinsics.f(str4, "ISO_639_2_T");
            Intrinsics.f(str5, "ISO_639_2_B");
            Intrinsics.f(str6, "ISO_639_3");
            Intrinsics.f(str7, "ISO_639_6");
            this.f32484a = str;
            this.f32485b = str2;
            this.f32486c = str3;
            this.f32487d = str4;
            this.f32488e = str5;
            this.f32489f = str6;
            this.f32490g = str7;
        }

        public final String a() {
            return this.f32486c;
        }

        public final String b() {
            return this.f32484a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Language639)) {
                return false;
            }
            Language639 language639 = (Language639) obj;
            return Intrinsics.a(this.f32484a, language639.f32484a) && Intrinsics.a(this.f32485b, language639.f32485b) && Intrinsics.a(this.f32486c, language639.f32486c) && Intrinsics.a(this.f32487d, language639.f32487d) && Intrinsics.a(this.f32488e, language639.f32488e) && Intrinsics.a(this.f32489f, language639.f32489f) && Intrinsics.a(this.f32490g, language639.f32490g);
        }

        public int hashCode() {
            return (((((((((((this.f32484a.hashCode() * 31) + this.f32485b.hashCode()) * 31) + this.f32486c.hashCode()) * 31) + this.f32487d.hashCode()) * 31) + this.f32488e.hashCode()) * 31) + this.f32489f.hashCode()) * 31) + this.f32490g.hashCode();
        }

        public String toString() {
            return "Language639(languageName=" + this.f32484a + ", nativeName=" + this.f32485b + ", ISO_639_1=" + this.f32486c + ", ISO_639_2_T=" + this.f32487d + ", ISO_639_2_B=" + this.f32488e + ", ISO_639_3=" + this.f32489f + ", ISO_639_6=" + this.f32490g + ')';
        }
    }

    public SubtitleHelper() {
    }

    private final int e(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? 0 : -16777216;
        }
        return -1;
    }

    private final float h(String str) {
        float f2 = 1.0f;
        if (str != null) {
            try {
                f2 = Float.parseFloat(str);
            } catch (Exception unused) {
                return 1.0f;
            }
        }
        return f2 * 25.0f;
    }

    private final void i() {
        for (Language639 next : this.f32483f) {
            this.f32482e.put(next.a(), next.b());
        }
    }

    public final String a(String str) {
        Intrinsics.f(str, "input");
        if (StringsKt__StringsKt.M0(str, "-", (String) null, 2, (Object) null).length() != 2) {
            return null;
        }
        if (this.f32482e.isEmpty()) {
            i();
        }
        Locale locale = Locale.ROOT;
        Intrinsics.e(locale, "ROOT");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return this.f32482e.get(lowerCase);
    }

    public final CaptionStyleCompat b(Context context, SaveCaptionStyle saveCaptionStyle) {
        Typeface typeface;
        Typeface typeface2;
        Intrinsics.f(context, "<this>");
        Intrinsics.f(saveCaptionStyle, "data");
        int foregroundColor = saveCaptionStyle.getForegroundColor();
        int backgroundColor = saveCaptionStyle.getBackgroundColor();
        int windowColor = saveCaptionStyle.getWindowColor();
        int edgeType = saveCaptionStyle.getEdgeType();
        int edgeColor = saveCaptionStyle.getEdgeColor();
        String typefaceFilePath = saveCaptionStyle.getTypefaceFilePath();
        Typeface typeface3 = null;
        if (typefaceFilePath != null) {
            try {
                typeface2 = Typeface.createFromFile(new File(typefaceFilePath));
            } catch (Exception unused) {
                typeface2 = null;
            }
            if (typeface2 != null) {
                typeface = typeface2;
                return new CaptionStyleCompat(foregroundColor, backgroundColor, windowColor, edgeType, edgeColor, typeface);
            }
        }
        Integer typeface4 = saveCaptionStyle.getTypeface();
        if (typeface4 != null) {
            typeface3 = ResourcesCompat.g(context, typeface4.intValue());
        }
        if (typeface3 == null) {
            typeface = Typeface.SANS_SERIF;
        } else {
            typeface = typeface3;
        }
        return new CaptionStyleCompat(foregroundColor, backgroundColor, windowColor, edgeType, edgeColor, typeface);
    }

    public final Set<SubtitleData> c() {
        return this.f32478a;
    }

    public final Set<SubtitleData> d() {
        return this.f32479b;
    }

    public final SaveCaptionStyle f() {
        return new SaveCaptionStyle(Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_font_color", "#FFFFFFFF")), e(2), e(3), 1, e(1), (Integer) null, (String) null, 0, Float.valueOf(h(FreeMoviesApp.p().getString("pref_cc_subs_font_scale2", "1.0f"))), false, false, false, 3584, (DefaultConstructorMarker) null);
    }

    public final List<Language639> g() {
        return this.f32483f;
    }

    public final void j(SubtitleView subtitleView, FrameLayout frameLayout, SaveCaptionStyle saveCaptionStyle) {
        this.f32481d = subtitleView;
        if (subtitleView != null) {
            ViewGroup viewGroup = (ViewGroup) subtitleView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(subtitleView);
            }
            if (frameLayout != null) {
                frameLayout.addView(subtitleView);
            }
        }
        if (saveCaptionStyle != null) {
            n(saveCaptionStyle);
        }
    }

    public final boolean k(String str) {
        Intrinsics.f(str, ImagesContract.URL);
        return !StringsKt__StringsJVMKt.G(str, UriUtil.HTTP_SCHEME, false, 2, (Object) null);
    }

    public final void l(Set<SubtitleData> set) {
        Intrinsics.f(set, "list");
        this.f32478a = set;
    }

    public final void m(Set<SubtitleData> set) {
        Intrinsics.f(set, "list");
        this.f32479b = set;
    }

    public final void n(SaveCaptionStyle saveCaptionStyle) {
        Context context;
        Intrinsics.f(saveCaptionStyle, "style");
        SubtitleView subtitleView = this.f32481d;
        if (subtitleView != null && (context = subtitleView.getContext()) != null) {
            this.f32480c = saveCaptionStyle;
            Timber.Forest forest = Timber.f42178a;
            forest.h("SET STYLE = " + saveCaptionStyle, new Object[0]);
            SubtitleView subtitleView2 = this.f32481d;
            if (subtitleView2 != null) {
                subtitleView2.setStyle(b(context, saveCaptionStyle));
            }
            SubtitleView subtitleView3 = this.f32481d;
            if (subtitleView3 != null) {
                subtitleView3.setTranslationY(-((float) UiExtKt.a(saveCaptionStyle.getElevation())));
            }
            Float fixedTextSize = saveCaptionStyle.getFixedTextSize();
            if (fixedTextSize != null) {
                SubtitleView subtitleView4 = this.f32481d;
                if (subtitleView4 != null) {
                    subtitleView4.b(2, fixedTextSize.floatValue());
                    return;
                }
                return;
            }
            SubtitleView subtitleView5 = this.f32481d;
            if (subtitleView5 != null) {
                subtitleView5.f();
            }
        }
    }

    public final SubtitleStatus o(SubtitleData subtitleData) {
        if (CollectionsKt___CollectionsKt.z(this.f32478a, subtitleData)) {
            return SubtitleStatus.IS_ACTIVE;
        }
        if (CollectionsKt___CollectionsKt.z(this.f32479b, subtitleData)) {
            return SubtitleStatus.REQUIRES_RELOAD;
        }
        return SubtitleStatus.NOT_FOUND;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.movie.ui.activity.player.utils.SubtitleHelper$Language639} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.movie.ui.activity.player.utils.SubtitleHelper$Language639} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.movie.ui.activity.player.utils.SubtitleHelper$Language639} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.movie.ui.activity.player.utils.SubtitleHelper$Language639} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String p(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.List<com.movie.ui.activity.player.utils.SubtitleHelper$Language639> r1 = r6.f32483f
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x000c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.movie.ui.activity.player.utils.SubtitleHelper$Language639 r3 = (com.movie.ui.activity.player.utils.SubtitleHelper.Language639) r3
            java.lang.String r3 = r3.b()
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r5 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.e(r3, r5)
            java.lang.String r4 = r7.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r4)
            if (r3 == 0) goto L_0x000c
            r0 = r2
        L_0x0036:
            com.movie.ui.activity.player.utils.SubtitleHelper$Language639 r0 = (com.movie.ui.activity.player.utils.SubtitleHelper.Language639) r0
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.a()
            if (r0 == 0) goto L_0x0041
            r7 = r0
        L_0x0041:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.utils.SubtitleHelper.p(java.lang.String):java.lang.String");
    }
}
