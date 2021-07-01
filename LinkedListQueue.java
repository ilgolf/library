public class LinkedListQueue {
    private QueueNode front = null;
    private QueueNode rear = null;

    private class QueueNode {
        private Object data;
        private QueueNode next;

        public QueueNode(Object input) {
            data = input;
            next = null;
        }

        public Object getData() {
            return this.data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Object input) {
        QueueNode newNode = new QueueNode(input);
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Object dequeue() {
        if(isEmpty()) {
            throw new NullPointerException();
        } else {
            Object dequeueData = front.data;
            front = front.next;
            return dequeueData;
        }
    }

    public String toString() {
        String str = new String("[");
        if(isEmpty()) {
            return str + "]";
        } else {
            QueueNode tmp = front;

            while(tmp.next != null) {
                str += tmp.getData() + ", ";
                tmp = tmp.next;
            }
            return str + tmp.getData() + "]";
        }
    }

    public void clear() {
        front = null;
        rear = null;
    }
}
