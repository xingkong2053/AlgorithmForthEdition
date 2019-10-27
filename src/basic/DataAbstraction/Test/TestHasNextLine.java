package basic.DataAbstraction.Test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestHasNextLine {

    public static void main(String[] args) {

        if (StdIn.hasNextLine()) {                          //Ctrl+D
            StdOut.println("hasNextLine");
        } else StdOut.println("don't has next line");
    }

}
