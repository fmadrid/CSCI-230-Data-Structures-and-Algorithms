import stdlib.StdDraw;
import stdlib.StdAudio;

public class GuitarTest {
    public static void main(String[] args) {
        // string used to determine notes
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,;/' ";
        // number of strings variable
        int numberOfStrings = keyboard.length();
        GuitarString[] guitarStringsArray = new GuitarString[numberOfStrings];
        RingBuffer sampleBuff = new RingBuffer();
        
        StdDraw.setXscale(0, 100);              // sets x scale from 0 to 100
        StdDraw.setYscale(-10,10);              // sets y scale from -10 to 10 (y should be between -1 and 1)
        StdDraw.enableDoubleBuffering();        // drawing takes place on off-screen canvas
        
        int x = 0;
        for (int i = 0; i < numberOfStrings; i++) {
            double f = 440.0 * Math.pow(2, (i - 24) / 12.0);
            guitarStringsArray[i] = new GuitarString(f);
        }
        
        while (true) {
            double sample = 0;
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    guitarStringsArray[keyboard.indexOf(key)].pluck();
                }
            }
	        for (int j = 0; j < guitarStringsArray.length; j++) {
	            sample += guitarStringsArray[j].sample();
	        }
	        //System.out.println(sample);
	        // plays audio
	        StdAudio.play(sample);  
	        // enqueues sample into buffer
	        sampleBuff.enqueue(sample);
	        
	        // if buffer size is greater than 1
	        if (sampleBuff.size() > 1) {
	        	System.out.println("x: " + x);
	            // if x == 0 clear the drawing 
	            if (x == 100) {
	            	x = 0;
	            	StdDraw.clear();
	            }
	            // draws from (x, buff.deq) to (x+1, buff.peek)
	            StdDraw.line(x, sampleBuff.dequeue(), x+1, sampleBuff.peek());
	            // shows and pauses the drawing 
	                
	                 StdDraw.show();
	                 StdDraw.pause(10);
	                 
	            // x iterator
	            x++;
	        }   
	        
	        for (int j = 0; j < guitarStringsArray.length; j++) {
	            guitarStringsArray[j].tic();
	        }       
        }
    }
}