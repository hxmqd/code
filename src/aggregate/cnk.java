package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class cnk {
    public static List<List<Integer>> answer = new LinkedList<>();

    public static void main(String[] args) {
        cnks(new int[]{1, 2, 3, 4, 5, 6}, 4);
        for (List<Integer> t : answer) {
            System.out.println(t.toString());
        }
    }

    public static void cnks(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (int t : num) {
            rest.add(t);
        }
        helper(result, rest, k);

    }

    public static void helper(List<Integer> result, List<Integer> rest, int k) {
        if (k == 0) {
            answer.add(result);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            List<Integer> temp1 = new ArrayList<>(result);
            temp1.add(rest.get(i));
            List<Integer> temp2 = new ArrayList<>(rest);
            temp2.remove(i);
            int temp3 = k - 1;
            helper(temp1, temp2, temp3);

        }
    }

}
