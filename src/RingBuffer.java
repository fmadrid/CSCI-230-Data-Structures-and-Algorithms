
public class RingBuffer {
	private double[] rb;		// ring buffer array
	private int first;          // first item in array
	private int last;           // last item in array
	private int size;           // size of array 
	
	public RingBuffer(int capacity){
		first = 0;
		last = 0; 
		size = 0; 
		rb  = new double[capacity];
	}
	
	public RingBuffer(){
		rb = new double[100];
		first = 0;
		last = 0; 
		size = 0; 
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == rb.length);
	} 
	
	public void enqueue(double x) {
		if (isFull()) {
			throw new RuntimeException("This ringbuffer is a fatty");
		}
		rb[last] = x;
		last++;
		size++;
		if (last >= rb.length) {last = 0;}
	}
	
	public double dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Ring buffer underflow");
		}
		double temp = rb[first];
		first++;
		if (first >= rb.length) {first = 0;}
		size--;
		return temp;
	}
	
	public double peek() {
		if (isEmpty()) {
            throw new RuntimeException("This bitch empty");
        }
		return rb[first]; 
	}
	
	public void printRingBuffer() {
		for (int i = 0; i < rb.length; i++) {
			System.out.println(rb[i]);
		}
	}
}