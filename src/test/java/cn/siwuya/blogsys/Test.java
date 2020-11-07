package cn.siwuya.blogsys;

/**
 * @author shi_dd
 * @date 2020/7/15 10:19
 */
public class Test {
    public static void main(String[] args) {
        double[] aaa = new double[]{1D,5D,8D};
        System.out.println(TotalityStandardDeviation(aaa));

    }
    private static double TotalityStandardDeviation(double[] sample) {
        if (1 > sample.length) {
            return 0;
        }
        double dSum = 0.0; // 样本值之和
        double dAverage = 0.0; // 样本值的平均值
        // 遍历样本
        for (int i = 0; i < sample.length; ++i) {
            dSum += sample[i];
        }
        dAverage = dSum / sample.length;

        // 遍历样本数字
        dSum = 0.0;
        for (int i = 0; i < sample.length; ++i) {
            dSum += (sample[i] - dAverage) * (sample[i] - dAverage);
        }
        double dStdDev = Math.sqrt(dSum / sample.length);
        return dStdDev;
    }
}
