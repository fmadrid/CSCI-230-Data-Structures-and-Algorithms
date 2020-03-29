/**********************************************************************
* BY ERICK HERRERA FOR CSCI 230 FOR PROJECT 2: GUITAR
**********************************************************************/
import java.lang.Math;
public class GuitarString {
	private RingBuffer rb;
	private double stringLength;
	private int samplingRate = 44100;
	private int counter;
	
	public GuitarString(double f) {
		stringLength = (samplingRate / f); 
		int intStringLength = (int) Math.ceil(stringLength);
		rb = new RingBuffer(intStringLength);
		for (int i = 0; i < stringLength ; i++) {
			rb.enqueue(0);
		} 
	}
	
	public GuitarString(double[] init) {
		int length = init.length;
		rb = new RingBuffer(length);
		for (int i = 0; i < length; i++) {
			rb.enqueue(init[i]);
		}
	}
	
	public void pluck() {
		for (int i = 0; i < stringLength; i++) {
			rb.dequeue();
			rb.enqueue(Math.random()-0.5);
		}
	}
	
	public void tic() {
		if(rb.size() > 1) {
			double first = rb.dequeue();
			double second = rb.peek();
			double calc = 0.994 * (0.5 * (first + second));
			rb.enqueue(calc);
			counter++;
		}
	}
	
	public double sample() {
		return rb.peek();
	}
	
	public int time() {
		return counter;
	}
	
	public void test() {
		rb.printRingBuffer();
	}
}