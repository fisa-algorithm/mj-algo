import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String[] list = s.split("");

        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < list.length; i++) {
            String current = list[i];
            if (current.equals("(")) {
                stack.push(current);
            } else {
                stack.pop();
                if (list[i - 1].equals("(")) {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}