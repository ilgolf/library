public class ArrayQueue {
    private final int DEFAULT_SIZE = 100000;
    private int front = 0;
    private int rear = 0;
    private Object[] data;

    public ArrayQueue() {
        data = new Object[DEFAULT_SIZE];
    }

    public ArrayQueue(int size) {
        if(size > 0) {
            data = new Object[size + 1];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear + 1 % getSize() == front;
    }

    public void enqueue(Object input) {
        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            data[++rear % getSize()] = input;
        }
    }

    public Object dequeue() {
        if(isEmpty()) {
            throw new NullPointerException();
        } else {
            return data[++rear % getSize()];
        }
    }

    public void clear() {
        for(int i = front + 1; i != (rear + 1) % getSize(); i = (i + 1) % getSize()) {
            data[i] = null;
        }
        front = 0;
        rear = 0;
    }
}
