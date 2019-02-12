import java.io.*;
import java.util.Scanner;

//public class FileExamples {
//
//    //Reads a file from resource folder in project
//    public static void readTextFileFromResources() throws IOException {
//        try (InputStream inputStream = FileExamples.class.getResourceAsStream("/file.txt")) {
//            Scanner sc = new Scanner(inputStream);
//            while (sc.hasNext())
//                System.out.println(sc.nextLine());
//        }
//    }
//
//    //Reads a file from an absolute path. Asks system for path to user.home dir
//    public static void readTextFileFromAbsolutePath() {
//        //File file = new File("C:\\Users\\Martin\\Documents\\code.txt");
//        String path = System.getProperty("user.home")
//                + File.separator + "Documents"
//                + File.separator + "code.txt";
//        File file = new File(path);
//
//        try {
//            FileReader fileReader = new FileReader(file);
//            Scanner scanner = new Scanner(fileReader);
//            while (scanner.hasNext())
//                System.out.println(scanner.nextLine());
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Writes information to a textfile
//     *
//     * @param file File to write to
//     * @param text String with text to write to file
//     */
//    public static void writeTextFile(File file, String text) {
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write(text);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void readTextFileWithUTF8Encoding() {
//        File file = new File("C:\\Users\\Martin\\Documents\\code.txt");
//
//        try {
//            FileInputStream inputStream = new FileInputStream(file);
//            Scanner scanner = new Scanner(inputStream, "UTF-8");
//            while (scanner.hasNext())
//                System.out.println(scanner.nextLine());
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //Save settings in a property file
//    public static void propertiesSavingLoading() {
//        String path = System.getProperty("user.home")
//                + File.separator + "Documents"
//                + File.separator + "FileInput"
//                + File.separator + "settings.xml";
//        File file = new File(path);
//
//        Properties properties = new Properties();
//
//        try {
//            FileInputStream inputStream = new FileInputStream(file);
//            properties.loadFromXML(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(properties.getProperty("AutoSave"));
//        //Spara en inställning
//        //properties.setProperty("AutoSave","true");
//
//        //Hämta en inställning med default som false om nyckeln inte finns
//        //String autoSave = properties.getProperty("AutoSave", "false");
//
//
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            properties.storeToXML(outputStream, "Settings for FileInput Demo");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//    //Reads from a textfile using java8 streams to filter and convert to List of strings.
//    public static List<String> names() {
//        File file = new File("C:\\Users\\Martin\\Documents\\code.txt");
//        //URL url = FileInput.class.getResource("/file.txt");
//
//        //https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
//        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
//
//            return stream.distinct().filter(string -> string.matches("[A].*")).collect(Collectors.toList());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //Save to binary file
//    public static void saveBinaryData(File file, double d) {
//
//        try (DataOutputStream outputStream
//                     = new DataOutputStream(new FileOutputStream(file))) {
//            outputStream.writeDouble(d);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //Load from binary file
//    public static double loadBinaryData(File file) {
//        try (DataInputStream inputStream
//                     = new DataInputStream(new FileInputStream(file))) {
//            return inputStream.readDouble();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0.0;
//    }
//
//}
