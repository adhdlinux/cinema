package com.original.tase.helper.js;

import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;

public class JJDecoder {
    public static final String OBJECT_OBJECT = "[object Object]";
    public static final String UNDEFINED = "undefined";
    private static HashMap<String, String> tokens;
    private VariablesMap variables = new VariablesMap();

    class VariablesMap extends HashMap<String, String> {
        public VariablesMap() {
        }

        public String getGlobalVariable() {
            for (String str : keySet()) {
                if (!str.contains(".")) {
                    return str;
                }
            }
            return null;
        }

        public int getGlobalVariableValue() {
            return Integer.parseInt((String) get(getGlobalVariable()));
        }

        public String putProperty(String str, String str2, String str3) {
            return (String) super.put(str + "." + str2, str3);
        }

        public void setGlobalVariableValue(String str) {
            put(getGlobalVariable(), str);
        }
    }

    public JJDecoder() {
        HashMap<String, String> hashMap = new HashMap<>();
        tokens = hashMap;
        hashMap.put("^~\\[]$", "-1");
        tokens.put("^\\[]$", "0");
        tokens.put("^!\\[]\\+\"\"$", Constants.CASEFIRST_FALSE);
        tokens.put("^\\{\\}\\+\"\"$", OBJECT_OBJECT);
        tokens.put("^.+\\[[^.]+]\\+\"\"$", "undefined");
        tokens.put("^\\+\\+.+", "1");
        tokens.put("^!\"\"\\+\"\"$", "true");
        tokens.put("^[^\\[\\]\\.\\(\\)]+\\+\"\"$", OBJECT_OBJECT);
        tokens.put("^((.+)\\.(.+))\\+\"\"", "undefined");
        tokens.put("^\\(!.+\\)\\+\"\"$", Constants.CASEFIRST_FALSE);
    }

    private String convertOctalFormat(String str) {
        return StringEscapeUtils.a(StringEscapeUtils.a(str));
    }

    private ArrayList<String> convertRows(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (!strArr[i2].matches(".+=\\(.+\\)\\[.+\\]\\[.+\\]")) {
            arrayList.add(strArr[i2]);
            i2++;
        }
        while (true) {
            i2++;
            if (i2 < strArr.length) {
                sb.append(strArr[i2]);
                sb.append(";");
            } else {
                arrayList.add(sb.toString());
                return arrayList;
            }
        }
    }

    private String findCode(String str) {
        return str.substring(str.indexOf("(", str.indexOf("(") + 1) + 1, str.lastIndexOf(")())()"));
    }

    private int getIndexFromString(String str) {
        if (str.contains("[") && str.contains("]")) {
            str = str.replaceAll("\\[", "").replaceAll("]", "");
        }
        String str2 = (String) this.variables.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String parseArgument(String str) {
        if (this.variables.get(str) != null) {
            return (String) this.variables.get(str);
        }
        return parseExpression(str);
    }

    private static String[] parseArguments(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            int indexOf = str.indexOf("+", i2);
            if (indexOf == -1) {
                arrayList.add(str.substring(i3, str.length()));
                break;
            }
            int i4 = indexOf + 1;
            if (str.charAt(i4) == '\"' && str.charAt(indexOf + 2) == '\"' && str.charAt(indexOf + 3) != '\"') {
                i2 = i4;
            } else {
                arrayList.add(str.substring(i3, indexOf));
                i2 = i4;
                i3 = i2;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String parseExpression(String str) {
        String str2;
        String str3;
        if (str.contains("[") || str.contains("]")) {
            if (str.contains("(") || str.contains(")")) {
                int lastIndexOf = str.lastIndexOf(")") + 1;
                str2 = str.substring(0, lastIndexOf);
                str3 = str.substring(lastIndexOf, str.length());
            } else {
                int indexOf = str.indexOf("[");
                str2 = str.substring(0, indexOf);
                str3 = str.substring(indexOf, str.length());
            }
            String parseRawValue = parseRawValue(str2);
            int indexFromString = getIndexFromString(str3);
            if (parseRawValue.equals(str)) {
                return str;
            }
            if (indexFromString != -1) {
                return String.valueOf(parseRawValue.charAt(indexFromString));
            }
            throw new IllegalStateException("Something went wrong. There is no " + str3 + " variable in stack");
        } else if (this.variables.get(str) != null) {
            return (String) this.variables.get(str);
        } else {
            return parseRawValue(str);
        }
    }

    private void parseGlobalVariable(String str) {
        this.variables.put(str.split("=")[0], parseRawValue(str.split("=")[1]));
    }

    private void parseProperties(String str) {
        String[] split = str.split(",");
        String globalVariable = this.variables.getGlobalVariable();
        for (String str2 : split) {
            this.variables.putProperty(globalVariable, str2.split(":")[0], processCompoundVariable(str2.split(":")[1]));
        }
    }

    private String parseRawValue(String str) {
        String str2;
        String replaceInitialAndFinalParentheses = replaceInitialAndFinalParentheses(str);
        Iterator<String> it2 = tokens.keySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                str2 = null;
                break;
            }
            String next = it2.next();
            if (replaceInitialAndFinalParentheses.matches(next)) {
                str2 = tokens.get(next);
                break;
            }
        }
        if (str2 != null && str2.equals("1")) {
            str2 = String.valueOf(this.variables.getGlobalVariableValue() + 1);
            this.variables.setGlobalVariableValue(str2);
        }
        if (this.variables.containsKey(replaceInitialAndFinalParentheses)) {
            return OBJECT_OBJECT;
        }
        if (str2 == null) {
            return replaceInitialAndFinalParentheses;
        }
        return str2;
    }

    private void parseVariableArguments(String str) {
        String str2 = str.split("=")[0];
        String[] parseArguments = parseArguments(str.substring(str.indexOf("=") + 1, str.length()));
        StringBuilder sb = new StringBuilder("");
        for (String processCompoundVariable : parseArguments) {
            sb.append(processCompoundVariable(processCompoundVariable));
        }
        this.variables.put(str2, sb.toString());
    }

    private String processCompoundVariable(String str) {
        if (!str.contains("=")) {
            return parseExpression(str);
        }
        if (str.lastIndexOf(")") != str.length() - 1) {
            Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String group = matcher.group(1);
            String parseRawValue = parseRawValue(group.split("=")[1]);
            this.variables.put(group.split("=")[0], parseRawValue);
            return String.valueOf(parseRawValue.charAt(getIndexFromString(str.substring(str.indexOf("[") + 1, str.indexOf("]")))));
        }
        String replaceInitialAndFinalParentheses = replaceInitialAndFinalParentheses(str);
        String parseExpression = parseExpression(replaceInitialAndFinalParentheses.split("=")[1]);
        this.variables.put(replaceInitialAndFinalParentheses.split("=")[0], parseExpression);
        return parseExpression;
    }

    private String replaceInitialAndFinalParentheses(String str) {
        if (str.indexOf("(") == -1 || str.indexOf("(") != 0 || str.lastIndexOf(")") == -1 || str.lastIndexOf(")") != str.length() - 1) {
            return str;
        }
        return str.substring(1, str.length() - 1);
    }

    private String replaceInitialAndFinalQuotes(String str) {
        if (str.length() > 1 && str.indexOf("\"") != -1 && str.indexOf("\"") == 0 && str.lastIndexOf("\"") != -1 && str.lastIndexOf("\"") == str.length() - 1) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public String decode(String str) {
        if (str != null) {
            ArrayList<String> convertRows = convertRows(str.split(";"));
            parseGlobalVariable(convertRows.get(0));
            String str2 = convertRows.get(1).split("=")[1];
            parseProperties(str2.substring(1, str2.length() - 1));
            for (int i2 = 2; i2 < convertRows.size() - 1; i2++) {
                parseVariableArguments(convertRows.get(i2));
            }
            String findCode = findCode(convertRows.get(convertRows.size() - 1));
            StringBuilder sb = new StringBuilder();
            for (String replaceInitialAndFinalQuotes : parseArguments(findCode)) {
                sb.append(parseArgument(replaceInitialAndFinalQuotes(replaceInitialAndFinalQuotes)));
            }
            return replaceInitialAndFinalQuotes(convertOctalFormat(sb.toString()).replaceFirst("return", ""));
        }
        throw new IllegalArgumentException("input can't be null");
    }

    public void reset() {
        this.variables.clear();
    }
}
