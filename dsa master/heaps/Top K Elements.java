import java.util.PriorityQueue;

public class TopKLargest {

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};

        int k = 3;
                                                          // for max heap
        PriorityQueue<Integer> minHeap =                  // PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
                new PriorityQueue<>();

        for (int num : arr) {

            if (minHeap.size() < k) {

                minHeap.offer(num);

            } else if (num > minHeap.peek()) {            // num < maxheap.peek()

                minHeap.poll();

                minHeap.offer(num);
            }
        }

        System.out.println(minHeap);
    }
}
