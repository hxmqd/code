package nio;

/*  FileChannel : file
     DatagramChannel : UDP
     SocketChannel : tcp client
     ServerSocketChannel : tcp server*/

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import java.nio.channels.FileChannel;


public class ChannelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("note", "rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(50);
            int bytesRead = inChannel.read(buf);
            System.out.print("bytesRead:"+bytesRead);
            while (bytesRead != -1) {
                System.out.print("Read" + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (Exception e) {
        }
    }
}
