package Project.Guitar;

import java.util.Random;

import stdlib.StdAudio;
import stdlib.StdDraw;

public class GuitarHeroLite {
      public static void main(String[] args) {

          // create two guitar strings, for concert A and C
          double CONCERT_A = 440.0;
          double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);  
          //GuitarString stringA = new GuitarString(CONCERT_A);
          //GuitarString stringC = new GuitarString(CONCERT_C);



          
          int frame = 0;
          while (true) {
              // check if the user has typed a key; if so, process it   
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  //if      (key == 'a') { stringA.pluck(); }
                  //else if (key == 'c') { stringC.pluck(); }
              }

              // compute the superposition of samples
              double sample = 440.0;  
              // play the sample on standard audio
              
              
              Thread audio = new Thread() {
              
                  public void run() {
                	  for (int i = 0; i <= StdAudio.SAMPLE_RATE; i++) {
                          StdAudio.play(0.5 * Math.sin(2*Math.PI * sample * i / StdAudio.SAMPLE_RATE));
                      }        
                  }
              };
              
              Thread draw = new Thread()
              {
                  public void run() {
                	  Random r = new Random();

			              StdDraw.setPenColor(StdDraw.MAGENTA);
			              StdDraw.line(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble());
                  }
              };
              
              audio.start();
              draw.start();
                           
              // advance the simulation of each guitar string by one step   
              //stringA.tic();
              //stringC.tic();
          }
       }
  }
