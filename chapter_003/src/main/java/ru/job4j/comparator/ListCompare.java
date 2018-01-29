package ru.job4j.comparator;


import java.util.Comparator;
import java.util.List;

/**
 * class ListCompare
 *
 * @author Salikov
 */
public class ListCompare implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int leftCount = 0;
        int rightCount = 0;
        int size = 0;
        if (left.size() >= right.size()) {
            size = right.size();
            leftCount += left.size() - right.size();
        } else if (left.size() < right.size()) {
            size = left.size();
            rightCount += right.size() - left.size();
        }

        for (int out = 0; out < size; out++) {
            int result = left.get(out).compareTo(right.get(out));
            if (result > 0) {
                leftCount++;
            } else if (result < 0) {
                rightCount++;
            }
        }
        return leftCount - rightCount;
    }
}
