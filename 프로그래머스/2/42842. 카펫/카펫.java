class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h = 1; h * h <= yellow; h++) {
            if (yellow % h != 0) {
                continue;
            }

            int innerH = h;
            int innerW = yellow / h;

            int carpetH = innerH + 2;
            int carpetW = innerW + 2;

            if (carpetW * carpetH == brown + yellow) {
                return new int[]{carpetW, carpetH};
            }
        }

        return new int[0];
    }
}