public class BinaryHeap {

    private static int N = 0;
    static int[] heap = new int[10];

    public static void swim(int index) {
        if(index > 0) {
            int parentIndex = (index-1) / 2;

            if(heap[index] < heap[parentIndex]) {
                int tmp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index] = tmp;
                swim(parentIndex);
            }
        }
    }

    public static void sink(int index) {
        int lowest = index;
        int l = 2*index + 1;
        int r = 2*index + 2;

        if(l < N && heap[l] < heap[lowest])
            lowest = l;

        if(r < N && heap[r] < heap[lowest])
            lowest = r;

        if(lowest != index) {
            int tmp = heap [lowest];
            heap[lowest] = heap[index];
            heap[index] = tmp;
            sink(lowest);
        }
    }

    static int extractMin() {
        int min = heap[0];
        heap[0] = heap[N-1];
        N--;
        sink(0);
        return min;
    }

    static void insertIntoHeap(int val) {
        heap[N++] = val;
        swim(N-1);
    }

    public static void main(String[] args) {
        int input[] = {3, 4, -1, 6, 0, 5, 1, 4};

        for(int i=0;i<input.length;i++) {
            insertIntoHeap(input[i]);
        }

        for(int i=0;i<input.length;i++) {
            System.out.println(extractMin());
        }
    }
}
