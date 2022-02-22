package leetcode.Array;

import java.util.Arrays;

/**
 * 题目描述：
 * 供暖器。设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 示例：
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * <p>
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * <p>
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * <p>
 * 思路：
 * 在对houses和heaters都已排序的情况下，对houses的每一个元素，都是找左右最近的heaters元素，
 * 选择最近的元素作为该处房屋的可接受的最短供暖半径。
 * 然后在所有供暖半径中找最大值，即都可以覆盖到的。
 * <p>
 * 找左右最近的heaters元素可以使用二分法，对houses的每一个元素在heaters中二分查找能插入的位置。
 * 也可以使用双指针，一个遍历houses，一个遍历heaters。在排序的前提下，
 * 比较当前指针1位置的house与指针2位置的heaters的半径与指针2下一个位置的heaters的半径哪个更小。
 * 如果前者更小则认为前者已经是该处房子的最短半径可供暖的热水器了，因为后者之后的热水器半径只会越来越大；
 * 若后者更小，则移动指针二，直至找到当前指针更小的情况。移动时要注意不要越界。
 * 在这些最短半径中，返回其中的最大值，则为可供所有统一的热水器半径。
 */
public class leetcode475_findRadius {
    public static void main(String[] args) {
        int[] houses = {1, 5};
        int[] heaters = {2};
        int res = findRadius_1(houses, heaters);
        System.out.println(res);
    }

    public static int findRadius_1(int[] houses, int[] heaters) {
        //工程中一般不修改传入参数，这里排序不为重点，直接排序。
        Arrays.sort(heaters);
        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            int left = 0;
            int right = heaters.length - 1;
            int tmp = houses[i];
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] > tmp) {
                    right = mid;
                } else if (heaters[mid] <= tmp) {
                    left = mid;
                }
            }
            int min = Math.min(Math.abs(heaters[left] - houses[i]), Math.abs(heaters[right] - houses[i]));
            max = Math.max(max, min);
        }
        return max;
    }

    public static int findRadius_2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int houses_len = houses.length;
        int heaters_len = heaters.length;
        int houses_p = 0, heaters_p = 0;
        int min_radius = 0;
        while (houses_p < houses_len && heaters_p < heaters_len) {
            int cur_radius = Math.abs(houses[houses_p] - heaters[heaters_p]);
            int next_radius = Integer.MAX_VALUE;
            if (heaters_p + 1 < heaters_len)
                next_radius = Math.abs(houses[houses_p + 1] - heaters[heaters_p]);
            if (cur_radius < next_radius) {
                min_radius = Math.max(min_radius, cur_radius);
                houses_p++;
            } else heaters_p++;
        }
        return min_radius;
    }
}
