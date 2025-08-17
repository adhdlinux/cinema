package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class LocaleObjectICU implements ILocaleObject<ULocale> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsDirty;
    private ULocale m_icuLocale;
    private ULocale.Builder m_icuLocaleBuilder;

    private LocaleObjectICU(ULocale uLocale) {
        this.m_icuLocaleBuilder = null;
        this.mIsDirty = false;
        this.m_icuLocale = uLocale;
    }

    public static ILocaleObject<ULocale> createDefault() {
        return new LocaleObjectICU(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static ILocaleObject<ULocale> createFromLocaleId(String str) throws JSRangeErrorException {
        return new LocaleObjectICU(str);
    }

    public static ILocaleObject<ULocale> createFromULocale(ULocale uLocale) {
        return new LocaleObjectICU(uLocale);
    }

    private void ensureNotDirty() throws JSRangeErrorException {
        if (this.mIsDirty) {
            try {
                this.m_icuLocale = this.m_icuLocaleBuilder.build();
                this.mIsDirty = false;
            } catch (RuntimeException e2) {
                throw new JSRangeErrorException(e2.getMessage());
            }
        }
    }

    public ILocaleObject<ULocale> cloneObject() throws JSRangeErrorException {
        ensureNotDirty();
        return new LocaleObjectICU(this.m_icuLocale);
    }

    public ArrayList<String> getUnicodeExtensions(String str) throws JSRangeErrorException {
        ensureNotDirty();
        String CanonicalKeyToICUKey = UnicodeExtensionKeys.CanonicalKeyToICUKey(str);
        ArrayList<String> arrayList = new ArrayList<>();
        String a2 = this.m_icuLocale.getKeywordValue(CanonicalKeyToICUKey);
        if (a2 != null && !a2.isEmpty()) {
            Collections.addAll(arrayList, a2.split("-|_"));
        }
        return arrayList;
    }

    public void setUnicodeExtensions(String str, ArrayList<String> arrayList) throws JSRangeErrorException {
        ensureNotDirty();
        if (this.m_icuLocaleBuilder == null) {
            this.m_icuLocaleBuilder = new ULocale.Builder().setLocale(this.m_icuLocale);
        }
        try {
            ULocale.Builder unused = this.m_icuLocaleBuilder.setUnicodeLocaleKeyword(str, TextUtils.join("-", arrayList));
            this.mIsDirty = true;
        } catch (RuntimeException e2) {
            throw new JSRangeErrorException(e2.getMessage());
        }
    }

    public String toCanonicalTag() throws JSRangeErrorException {
        return getLocale().toLanguageTag();
    }

    public String toCanonicalTagWithoutExtensions() throws JSRangeErrorException {
        return getLocaleWithoutExtensions().toLanguageTag();
    }

    public ULocale getLocale() throws JSRangeErrorException {
        ensureNotDirty();
        return this.m_icuLocale;
    }

    public ULocale getLocaleWithoutExtensions() throws JSRangeErrorException {
        ensureNotDirty();
        ULocale.Builder builder = new ULocale.Builder();
        ULocale.Builder unused = builder.setLocale(this.m_icuLocale);
        ULocale.Builder unused2 = builder.clearExtensions();
        return builder.build();
    }

    private LocaleObjectICU(String str) throws JSRangeErrorException {
        this.m_icuLocale = null;
        this.m_icuLocaleBuilder = null;
        this.mIsDirty = false;
        ULocale.Builder builder = new ULocale.Builder();
        this.m_icuLocaleBuilder = builder;
        try {
            ULocale.Builder unused = builder.setLanguageTag(str);
            this.mIsDirty = true;
        } catch (RuntimeException e2) {
            throw new JSRangeErrorException(e2.getMessage());
        }
    }

    public HashMap<String, String> getUnicodeExtensions() throws JSRangeErrorException {
        ensureNotDirty();
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator a2 = this.m_icuLocale.getKeywords();
        if (a2 != null) {
            while (a2.hasNext()) {
                String str = (String) a2.next();
                hashMap.put(UnicodeExtensionKeys.ICUKeyToCanonicalKey(str), this.m_icuLocale.getKeywordValue(str));
            }
        }
        return hashMap;
    }
}
