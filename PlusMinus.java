import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {        
        RatioValue positives = new PositiveRatio();
        RatioValue negatives = new NegativeRatio();
        RatioValue zeros = new ZeroRatio();

        System.out.println(positives.calculateRatio(arr));
        System.out.println(negatives.calculateRatio(arr));
        System.out.println(zeros.calculateRatio(arr));
    }
}

interface RatioValue {
    long getRatio(List<Integer> list);
    
    default String calculateRatio(List<Integer> arr) {
        return String.format("%.6f", (double) this.getRatio(arr)/arr.size());
    }
}

class PositiveRatio implements RatioValue {
    public long getRatio(List<Integer> list) {
        return list.stream().filter(x -> x > 0).count();
    }
}

class NegativeRatio implements RatioValue {
    public long getRatio(List<Integer> list) {
        return list.stream().filter(x -> x < 0).count();
    }
}

class ZeroRatio implements RatioValue {
    public long getRatio(List<Integer> list) {
        return list.stream().filter(x -> x == 0).count();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
