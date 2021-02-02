package com.tencent.lucasshi;

public class P824_GoatLatin {
    public String toGoatLatin(String S) {
        String[] split = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            char c = split[i].charAt(0);
            if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                sb.append(split[i]);
            } else {
                String substring = split[i].substring(1);
                sb.append(substring);
                sb.append(split[i].charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
