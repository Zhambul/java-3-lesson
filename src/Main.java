import java.io.*;

/**
 * Created by zhambyl on 20/03/2017.
 */
public class Main {

    private static File file = new File("/Users/zhambyl/IdeaProjects/java3/src/qwe.txt");

    public static void main(String[] args) {
        characterOriented();
    }

    private static void characterOriented() {
        // WRITERS AND READERS
        try (Writer writer = new FileWriter(file)) {
            writer.write(123);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Reader reader = new FileReader(file)) {
            int next;

            while ((next = reader.read()) != -1) {
                System.out.println((char) next);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteOriented() {
        try {
            //read

            //checked FileNotFoundException

            InputStream in = new FileInputStream(file);

            int next;

            while ((next = in.read()) != -1) {
                System.out.println(next);
            }

            //checked IOException
            in.close();


            //write
            OutputStream out = new FileOutputStream(file);

            //write first 10 indices
            for (int i = 0; i < 10; i++) {
                out.write(i);
            }

            //checked IOException
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // try-with-resources
    private static void tryByteOriented() {
        //read

        File file = new File("/Users/zhambyl/IdeaProjects/java3/src/qwe.txt");

        //checked FileNotFoundException
        try (InputStream in = new FileInputStream(file)) {
            int next;
            while ((next = in.read()) != -1) {
                System.out.println(next);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //write
        try (OutputStream out = new FileOutputStream(file)) {
            //write first 10 indices
            for (int i = 0; i < 10; i++) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // java 6
        InputStream inputStream=  null;

        try {
            inputStream = new FileInputStream("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
