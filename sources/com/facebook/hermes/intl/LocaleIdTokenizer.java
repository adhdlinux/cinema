package com.facebook.hermes.intl;

class LocaleIdTokenizer {
    int mCurrentSubtagEnd = -1;
    int mCurrentSubtagStart = 0;
    private CharSequence mLocaleIdBuffer;

    public class LocaleIdSubtag {
        private CharSequence mLocaleIdBuffer;
        private int mSubtagEnd;
        private int mSubtagStart;

        LocaleIdSubtag(CharSequence charSequence, int i2, int i3) {
            this.mLocaleIdBuffer = charSequence;
            this.mSubtagStart = i2;
            this.mSubtagEnd = i3;
        }

        public boolean isExtensionSingleton() {
            return IntlTextUtils.isExtensionSingleton(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isOtherExtension() {
            return IntlTextUtils.isOtherExtension(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isPrivateUseExtension() {
            return IntlTextUtils.isPrivateUseExtension(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isTranformedExtensionTKey() {
            return IntlTextUtils.isTranformedExtensionTKey(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isTranformedExtensionTValueItem() {
            return IntlTextUtils.isTranformedExtensionTValueItem(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeExtensionAttribute() {
            return IntlTextUtils.isUnicodeExtensionAttribute(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeExtensionKey() {
            return IntlTextUtils.isUnicodeExtensionKey(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeExtensionKeyTypeItem() {
            return IntlTextUtils.isUnicodeExtensionKeyTypeItem(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeLanguageSubtag() {
            return IntlTextUtils.isUnicodeLanguageSubtag(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeRegionSubtag() {
            return IntlTextUtils.isUnicodeRegionSubtag(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeScriptSubtag() {
            return IntlTextUtils.isUnicodeScriptSubtag(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public boolean isUnicodeVariantSubtag() {
            return IntlTextUtils.isUnicodeVariantSubtag(this.mLocaleIdBuffer, this.mSubtagStart, this.mSubtagEnd);
        }

        public void reset() {
            this.mLocaleIdBuffer = "";
            this.mSubtagStart = 0;
            this.mSubtagEnd = 0;
        }

        public String toLowerString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = this.mSubtagStart; i2 <= this.mSubtagEnd; i2++) {
                stringBuffer.append(Character.toLowerCase(this.mLocaleIdBuffer.charAt(i2)));
            }
            return stringBuffer.toString();
        }

        public String toString() {
            return this.mLocaleIdBuffer.subSequence(this.mSubtagStart, this.mSubtagEnd + 1).toString();
        }

        public String toTitleString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = this.mSubtagStart; i2 <= this.mSubtagEnd; i2++) {
                if (i2 == this.mSubtagStart) {
                    stringBuffer.append(Character.toUpperCase(this.mLocaleIdBuffer.charAt(i2)));
                } else {
                    stringBuffer.append(Character.toLowerCase(this.mLocaleIdBuffer.charAt(i2)));
                }
            }
            return stringBuffer.toString();
        }

        public String toUpperString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = this.mSubtagStart; i2 <= this.mSubtagEnd; i2++) {
                stringBuffer.append(Character.toUpperCase(this.mLocaleIdBuffer.charAt(i2)));
            }
            return stringBuffer.toString();
        }
    }

    public class LocaleIdSubtagIterationFailed extends Exception {
        public LocaleIdSubtagIterationFailed() {
        }
    }

    public LocaleIdTokenizer(CharSequence charSequence) {
        this.mLocaleIdBuffer = charSequence;
    }

    private static boolean isSubtagSeparator(char c2) {
        return c2 == '-';
    }

    public boolean hasMoreSubtags() {
        return this.mLocaleIdBuffer.length() > 0 && this.mCurrentSubtagEnd < this.mLocaleIdBuffer.length() - 1;
    }

    public LocaleIdSubtag nextSubtag() throws LocaleIdSubtagIterationFailed {
        if (hasMoreSubtags()) {
            int i2 = this.mCurrentSubtagEnd;
            if (i2 >= this.mCurrentSubtagStart) {
                if (!isSubtagSeparator(this.mLocaleIdBuffer.charAt(i2 + 1))) {
                    throw new LocaleIdSubtagIterationFailed();
                } else if (this.mCurrentSubtagEnd + 2 != this.mLocaleIdBuffer.length()) {
                    this.mCurrentSubtagStart = this.mCurrentSubtagEnd + 2;
                } else {
                    throw new LocaleIdSubtagIterationFailed();
                }
            }
            this.mCurrentSubtagEnd = this.mCurrentSubtagStart;
            while (this.mCurrentSubtagEnd < this.mLocaleIdBuffer.length() && !isSubtagSeparator(this.mLocaleIdBuffer.charAt(this.mCurrentSubtagEnd))) {
                this.mCurrentSubtagEnd++;
            }
            int i3 = this.mCurrentSubtagEnd;
            int i4 = this.mCurrentSubtagStart;
            if (i3 > i4) {
                int i5 = i3 - 1;
                this.mCurrentSubtagEnd = i5;
                return new LocaleIdSubtag(this.mLocaleIdBuffer, i4, i5);
            }
            throw new LocaleIdSubtagIterationFailed();
        }
        throw new LocaleIdSubtagIterationFailed();
    }
}
