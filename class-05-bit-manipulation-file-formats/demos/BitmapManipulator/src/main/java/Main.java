import com.oracle.tools.packager.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to BitManipulator");
            File file = new File("/Users/moonmayor/Fellows/code-401-java-guide/curriculum/class-04-scanner-file-processing/demos/BitmapManipulator/bitmapimages/java.bmp");
            byte[] bytes = IOUtils.readFully(file);

            System.out.println("Size: " + bytes.length);
            System.out.println("bytes[0]: " + byteToString(bytes[0]) + " " + byteToString((byte) ~bytes[0]));
            System.out.println("bytes[1]: " + byteToString(bytes[1]));
            System.out.println("bytes[2]: " + byteToString(bytes[2]));
            System.out.println("bytes[3]: " + byteToString(bytes[3]));

            for (int i = 0; i < bytes.length; i++) {
                if (i > 1000 && i < 7020056) {
                    // invert
                    if (i < 3020056) {
                        bytes[i] = (byte) ~bytes[i];
                    } else if ( i < 5000000) {
                        if (i % 2 == 0) {
                            bytes[i] = (byte) (255 * Math.random());
                        }
                    } else {

                    }
                }
            }

            String output = "out.bmp";
            writeFile(output, bytes);
        } catch (IOException e) {
            System.out.println("Problem accessing file.");
        }
    }

    public static String byteToString(byte b) {
        String s2 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        return s2;

    }

    public static void writeFile(String filename, byte[] bytes) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
