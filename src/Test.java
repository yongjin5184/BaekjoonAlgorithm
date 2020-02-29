import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String string = "a1b10a3c4";
        Map<String, Long> result = new HashMap<>();
        String[] arr = string.split("(\\d+)");
        String[] arr2 = string.split("([a-z]+)");

        for (int i = 0; i < arr.length; i++) {
            result.put(arr[i], result.getOrDefault(arr[i], 0L) + Long.parseLong(arr2[i + 1]));
        }
    }
}
