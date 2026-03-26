class MyCircularQueue {

    class Node{
        Node prev;
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;

    public MyCircularQueue(int k) {
        head = new Node(0);
        tail = new Node(0);
        this.capacity = k;
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity) return false;
        Node curr = tail.prev;
        Node newnode = new Node(value);
        curr.next = newnode;
        newnode.prev = curr;
        newnode.next = tail;
        tail.prev = newnode;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0) return false;
        Node curr = head.next;
        head.next = curr.next;
        curr.next.prev = head;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : head.next.val;
    }
    
    public int Rear() {
        return size == 0 ? -1 : tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */