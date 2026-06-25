class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            max = Math.max(max, area);

            // Move the pointer at the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // Quick test
    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        System.out.println(cwmw.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(cwmw.maxArea(new int[]{1,1})); // 1
        System.out.println(cwmw.maxArea(new int[]{4,3,2,1,4})); // 16
    }
}
