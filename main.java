import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        String [] arr = new String[N];

        double sum = 0;

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
            sum += Integer.parseInt(arr[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for(String val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int max_val = 0;
        int mod = 0;
        for(String key : map.keySet()) {
            if(max_val < map.get(key)) {
                max_val = map.get(key);
                mod = Integer.parseInt(key);
            }
        }

        for(String key : map.keySet()) {
            if(max_val == map.get(key)) {
                list.add(key);
            }
        }

        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        if(list.size() > 1) {
            mod = Integer.parseInt(list.get(1));
        }

        int max = Integer.parseInt(arr[arr.length - 1]);
        int min = Integer.parseInt(arr[0]);
        int range = Math.abs(max - min);

        System.out.println((int)Math.round(sum / N));
        System.out.println(Integer.parseInt(arr[((N + 1) / 2) - 1]));
        System.out.println(mod);
        System.out.println(range);
    }
}