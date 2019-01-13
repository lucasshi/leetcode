package lintcode;

public class P395_CoinsInALine2 {
    public boolean firstWillWin(int[] values) {
        int[] dp1 = new int[values.length];
        int[] dp2 = new int[values.length];

        int sum = 0;
        int[] sums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
            sums[i] = sum;
        }

        if (values.length <= 2)
            return true;

        dp1[0] = values[0];
        dp1[1] = values[0] + values[1];
        dp2[1] = values[1];
        int[] finaldp = new int[values.length];

        for (int i = 2; i < values.length; i++) {
            dp1[i] = sums[i] - Math.max(dp2[i - 1], dp2[i - 2]);
            dp2[i] = sums[i] - Math.max(dp1[i - 1], dp1[i - 2]);
            finaldp[i] = Math.max(dp1[i], sums[i] - dp2[i]);
        }


        for (int i = 0; i < values.length; i++) {
            System.out.println(dp1[i] + "," + dp2[i] + "," + finaldp[i]);
        }
        return true;
        // return dp1[values.length - 1] > sum - dp1[values.length - 1];
    }

    public static void main(String[] args) {
        P395_CoinsInALine2 p = new P395_CoinsInALine2();
        System.out.println(p.firstWillWin(new int[]{1, 2, 4, 8}));
    }
}
