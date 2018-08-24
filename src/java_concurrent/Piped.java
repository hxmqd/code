package java_concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

//管道输入/输出流
public class Piped {

    public static void main(String[] args) {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        try {
            out.connect(in);
            Thread printThread = new Thread(new Print(in), "PrintThread");
            printThread.start();
            int receive = 0;
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Print implements Runnable {

    private PipedReader in;

    public Print(PipedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        int receive = 0;
        try {
            while ((receive = in.read()) != -1) {
                System.out.print((char) receive);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
