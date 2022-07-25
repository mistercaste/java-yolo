package cli.tensorflow.util;

import cli.tensorflow.ObjectDetector;
import com.google.common.io.ByteStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Util class to read image, graphDef and label files.
 */
public final class IOUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(IOUtil.class);
    private IOUtil() {}

    public static byte[] readAllBytesOrExit(final File file) {
        try {
            InputStream in = new BufferedInputStream(Files.newInputStream(file.toPath()));
            byte[] buf = new byte[(int) file.length()];
            int nextByte = in.read(buf);
            return buf;
        } catch (IOException | NullPointerException ex) {
            LOGGER.error("Failed to read [{}]!", file.getName());
            throw new ServiceException("Failed to read [" + file.getName() + "]!", ex);
        }
    }

    public static List<String> readAllLinesOrExit(final String filename) {
        try (InputStream in = ObjectDetector.class.getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {
            List<String> list = new ArrayList<>();
            String line;
            while( (line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            LOGGER.error("Failed to read [{}]!", filename);
            throw new ServiceException("Failed to read [" + filename + "]!", e);
        }
    }

    public static void createDirIfNotExists(final File directory) {
        if (!directory.exists()) {
            boolean success = directory.mkdir();
        }
    }

    public static String getFileName(final String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public static byte[] resourceToByteArray(String fileName) throws IOException {
        return ByteStreams.toByteArray(Objects.requireNonNull(IOUtil.class.getResourceAsStream(fileName)));
    }
}
