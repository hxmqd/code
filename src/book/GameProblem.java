package book;

/**
 * 纸牌博弈问题
 */
public class GameProblem {

    public static void main(String[] args) {
        GameProblem gp = new GameProblem();
        System.out.print(gp.win1(new int[]{1, 2, 3, 4, 5}));
    }

    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 表示arr[i...j]这个排列上的纸牌被最优选择的人先拿，最终能获得的分数
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * 表示如果arr[i..j]这个排列上的纸牌被最优选择的人后拿，最终能获得到的分数
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}
