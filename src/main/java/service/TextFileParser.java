package service;

import java.io.File;
import java.io.FileNotFoundException;

public class TextFileParser implements IFileParser {

    public File parseFile(String fileName) throws FileNotFoundException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;

/*// Instantiating a new ObjectMapper as a YAMLFactory
        //File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        *//*while ((st = br.readLine()) != null)
            System.out.println(st);
 */

    }
}
