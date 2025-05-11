import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<List<Integer>>> cache = new ArrayList<>(n + 1);
        if (n > (1 + 9) * 9 / 2) {
            return new ArrayList<>();
        }
        for (int i = 0; i < n + 1; i++) {
            List<List<Integer>> res = new ArrayList<>();
            cache.add(res);
        }
        List<List<Integer>> list = cache.get(0);
        list.add(new ArrayList<>());
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i > j) {
                    continue;
                } else if (i == j) {
                    List<List<Integer>> list0 = cache.get(j - i);
                    List<Integer> lst = new ArrayList<>(list0.get(0));
                    lst.add(i);
                    cache.get(j).add(lst);
                } else {
                    List<List<Integer>> lists = cache.get(j - i);
                    for (List<Integer> list1 : lists) {
                        if (list1.get(list1.size() - 1) != i) {
                            List<Integer> lst = new ArrayList<>(list1);
                            lst.add(i);
                            cache.get(j).add(lst);
                        }
                    }
                }
            }
        }
        return cache.get(cache.size() - 1).stream().filter(lst -> lst.size() == k).toList();
    }
}