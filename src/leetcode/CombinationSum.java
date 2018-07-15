package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int[] cand, int remain, int start){
        if(remain < 0) return;
        if(remain == 0) result.add(new ArrayList<>(list));
        else {
            for(int i = start; i < cand.length; i++){
                if(i>start && cand[i] == cand[i-1]) continue;
                if(remain-cand[i] < 0) break;
                list.add(cand[i]);
                helper(result, list, cand, remain - cand[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }

}
