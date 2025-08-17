package kotlin.text;

final class ScreenFloatValueRegEx {

    /* renamed from: a  reason: collision with root package name */
    public static final ScreenFloatValueRegEx f40557a = new ScreenFloatValueRegEx();

    /* renamed from: b  reason: collision with root package name */
    public static final Regex f40558b;

    static {
        String str = "[eE][+-]?" + "(\\p{Digit}+)";
        f40558b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ('(' + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str + ")?)|((" + ("(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')') + ")[pP][+-]?" + "(\\p{Digit}+)" + ')') + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private ScreenFloatValueRegEx() {
    }
}
