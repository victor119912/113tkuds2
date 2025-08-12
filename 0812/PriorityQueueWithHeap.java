import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    String name;
    int priority;
    long time; // 用於同優先級時排序
    private static long counter = 0;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.time = counter++;
    }

    @Override
    public int compareTo(Task o) {
        if (this.priority != o.priority) {
            return o.priority - this.priority;
        }
        return Long.compare(this.time, o.time);
    }
}

public class PriorityQueueWithHeap {
    private PriorityQueue<Task> pq = new PriorityQueue<>();

    public void addTask(String name, int priority) {
        pq.offer(new Task(name, priority));
    }

    public String executeNext() {
        return pq.poll().name;
    }

    public String peek() {
        return pq.peek().name;
    }

    public void changePriority(String name, int newPriority) {
        PriorityQueue<Task> newPQ = new PriorityQueue<>();
        for (Task t : pq) {
            if (t.name.equals(name)) {
                newPQ.offer(new Task(name, newPriority));
            } else {
                newPQ.offer(t);
            }
        }
        pq = newPQ;
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap q = new PriorityQueueWithHeap();
        q.addTask("備份", 1);
        q.addTask("緊急修復", 5);
        q.addTask("更新", 3);
        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
    }
}
