package PrintToFile;

import edu.princeton.cs.algs4.*;

import java.util.Random;

public class TenThousand {

    public static void main(String[] args){

        for(int i=0;i<10000/2;i++) {
            StdOut.println(StdRandom.uniform(10000)+" "
                    +StdRandom.uniform(10000));
        }
    }
}
