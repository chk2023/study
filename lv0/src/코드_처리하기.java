public class 코드_처리하기 {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);

            if (ch == '1') {
                // Switch the mode
                mode ^= 1;
            } else if ((mode == 0 && i % 2 == 0) || (mode == 1 && i % 2 != 0)) {
                // Add the character to ret
                ret.append(ch);
            }
        }

        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }
}