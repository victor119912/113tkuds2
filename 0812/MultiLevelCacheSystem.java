import java.util.*;

class CacheEntry {
    int key;
    String value;
    int freq;
    long time;
    CacheEntry(int k, String v) {
        key = k; value = v; freq = 0; time = System.nanoTime();
    }
}

public class MultiLevelCacheSystem {
    private PriorityQueue<CacheEntry> L1, L2, L3;
    private int cap1, cap2, cap3;

    public MultiLevelCacheSystem(int c1, int c2, int c3) {
        cap1 = c1; cap2 = c2; cap3 = c3;
        L1 = new PriorityQueue<>((a,b) -> a.freq != b.freq ? b.freq - a.freq : Long.compare(a.time, b.time));
        L2 = new PriorityQueue<>((a,b) -> a.freq != b.freq ? b.freq - a.freq : Long.compare(a.time, b.time));
        L3 = new PriorityQueue<>((a,b) -> a.freq != b.freq ? b.freq - a.freq : Long.compare(a.time, b.time));
    }

    public void put(int key, String value) {
        CacheEntry entry = new CacheEntry(key, value);
        if (L1.size() < cap1) L1.offer(entry);
        else if (L2.size() < cap2) L2.offer(entry);
        else if (L3.size() < cap3) L3.offer(entry);
        else {
            L3.poll();
            L3.offer(entry);
        }
    }

    public String get(int key) {
        for (PriorityQueue<CacheEntry> level : Arrays.asList(L1, L2, L3)) {
            for (CacheEntry e : level) {
                if (e.key == key) {
                    e.freq++;
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem(2, 5, 10);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}
