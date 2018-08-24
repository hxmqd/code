package leetcode;

import java.util.List;

import static leetcode.CombinationSum.combinationSum;

public class Test {

    public static void main(String[] args) {
        List<List<Integer>> ans = CombinationSum.combinationSum(new int[]{0, 1, 2, 3, 4, 3, 5, 6}, 6);
        for (List<Integer> list : ans) {
            System.out.println(list.toString());
        }
    }
}
