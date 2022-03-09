public class MinHeap {

    private int[] Heap;
    private int n; //size
    private int i; //index

    public MinHeap(int size){
        this.n = size;
        this.i = 0;
        Heap = new int[n];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int lChild(int i) {
        return (i * 2) + 1;
    }

    private int rChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rChild(i) >= n || lChild(i) >= n) {
            return true;
        }
        return false;
    }

    public void insert(int element) {
        if (i >= n) {
            return;
        }
        Heap[i] = element;
        while (Heap[i] < Heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
        i++;
    }

    public int min(){
        int min = Heap[0];
        return min;
    }

    public int extractMin() {
        int min = Heap[0];
        Heap[0] = Heap[--i];
        minHeapify(0);
        return min;
    }

    private void swap(int x, int y) {
        int temp;
        temp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = temp;
    }

    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (Heap[i] > Heap[lChild(i)] ||
                    Heap[i] > Heap[rChild(i)]) {
                if (Heap[lChild(i)] < Heap[rChild(i)]) {
                    swap(i, lChild(i));
                    minHeapify(lChild(i));
                }
                else {
                    swap(i, rChild(i));
                    minHeapify(rChild(i));
                }
            }
        }
    }
}
