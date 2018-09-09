public class Sort {
    static class QuickSort {
        private int[] nums;
        int[] sort(int[] nums) {
            this.nums = nums;
            return sort(nums, 0, nums.length-1);
        }
        private int[] sort(int[] nums, int low, int high) {
            if (low >= high) return null;

            int j = parttiion(nums, low, high);
            sort(nums, low, j-1);
            sort(nums, j+1, high);
            return nums;
        }

        private int parttiion(int[] nums, int low, int high) {
            int pivot = nums[low];

            while (low < high) {
                while (low < high && nums[high] >= pivot)
                    high--;
                swap(low, high);
                while (low < high && nums[low] <= pivot)
                    low++;
                swap(low, high);
            }
            return high;
        }

        private void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
