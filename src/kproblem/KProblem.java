package kproblem;

/**
 * O(n)时间复杂度
 */
public class KProblem {

    public static void main(String[] args) {
        KProblem kProblem = new KProblem();
        System.out.print("第k个数：" + kProblem.findTheKthNum(new int[]{1, 5, 3, 4, 2, 8}, 3));
    }

    int partition(int[] num, int left, int right) {
        int tmp = num[left];
        int i = left, j = right;
        while (i < j) {
            while (num[j] >= tmp && i < j) {
                j--;
            }
            while (num[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
            }
        }
        num[left] = num[i];
        num[i] = tmp;

        return i;

    }

    int findTheKthNum(int[] num, int k) {

        int length = num.length;
        int l = 0, r = length - 1;
        int index = partition(num, l, r);
        while (k - 1 != index) {
            if (k - 1 < index) {
                r = index - 1;
                index = partition(num, l, r);
            } else {
                l = index + 1;
                index = partition(num, l, r);
            }
        }
        return num[k - 1];

    }

}
