public class BianarySearch {
    static int search(int[] nums, int wanted) {

        int low = 0, high = nums.length;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < wanted)
                low = mid + 1;
            else if (nums[mid] > wanted)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
