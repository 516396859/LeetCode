class offer003 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1); // 一运算结果是删去最右边的1的结果，Brian Kernighan 算法
            ones++;
        }
        return ones;
    }
}