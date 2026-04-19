import java.io.*;
import java.util.*;

public class Oligopoly {
    public int[] getLeaders(long[] a) {
        int n = a.length;
        if (n == 0) return new int[0];

        int[] result = new int[n];


        long currentPrefixSum = 0;
        for (long x : a) {
            currentPrefixSum += x;
        }


        result[n - 1] = 1;


        for (int i = n - 2; i >= 0; i--) {

            currentPrefixSum -= a[i + 1];

            if (currentPrefixSum > a[i + 1] && result[i + 1] == 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}

class MainOligopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String line = reader.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());


        long[] capitals = new long[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            capitals[i] = Long.parseLong(st.nextToken());
        }


        Oligopoly solver = new Oligopoly();
        int[] result = solver.getLeaders(capitals);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if (i < n - 1) sb.append(" ");
        }

        writer.write(sb.toString());
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}