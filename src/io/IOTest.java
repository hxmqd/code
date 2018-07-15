package io;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IOTest {

    public  static void main(String[] args) throws FileNotFoundException {
        InputStream input = new FileInputStream("test.txt");
    }
}
