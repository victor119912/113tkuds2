import java.util.*;

class Element {
    int value, arrIndex, elemIndex;
    Element(int v, int ai, int ei) {
        value = v; arrIndex = ai; elemIndex = ei;
    }
}

public class MergeKSortedArrays {
    public static List<Integer> merge(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) pq.offer(new Element(arrays[i][0], i, 0));
        }
        while (!pq.isEmpty()) {
            Element e = pq.poll();
            result.add(e.value);
            if (e.elemIndex + 1 < arrays[e.arrIndex].length) {
                pq.offer(new Element(arrays[e.arrIndex][e.elemIndex + 1], e.arrIndex, e.elemIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,4,5}, {1,3,4}, {2,6}};
        System.out.println(merge(arr));
    }
}
