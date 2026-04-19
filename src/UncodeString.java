import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class UncodeString {
    public String uncode(String s, Map<String, Character> map) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {

            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {

                String key = s.substring(i, i + 3);
                sb.append(map.get(key));
                i += 3;
            } else {

                String key = s.substring(i, i + 1);
                sb.append(map.get(key));
                i += 1;
            }
        }
        return sb.toString();
    }
}

class MainUncodeString {
    public static void main(String[] args) throws IOException {
        Map<String, Character> alphabetMap = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            alphabetMap.put(String.valueOf(i), (char) ('a' + i - 1));
        }
        for (int i = 10; i <= 26; i++) {
            alphabetMap.put(i + "#", (char) ('a' + i - 1));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();

        UncodeString decoder = new UncodeString();
        writer.write(decoder.uncode(input, alphabetMap));


        writer.flush();
        reader.close();
        writer.close();
    }
}
