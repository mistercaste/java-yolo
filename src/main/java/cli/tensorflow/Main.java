package cli.tensorflow;

import java.io.File;

public class Main {
    private final static String IMAGE = "/home/matteo/IdeaProjects/java-yolo/eagle.jpg";

    public static void main(String[] args) {
        ObjectDetector objectDetector = new ObjectDetector();

        if (args.length > 0) {
            File input = new File(args[0]);
            if (input.exists()) {
                objectDetector.detect(args[0]);
            } else {
                System.out.println("File does not exist. Please provide a valid image file name.");
            }
        } else {
            System.out.println("Please check that the 1st parameter is an image file name.");
        }
    }
}
