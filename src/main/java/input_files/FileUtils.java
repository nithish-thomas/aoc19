package input_files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    public static List<String> readClassPathResourceAsListOfString(String fileName) throws URISyntaxException, IOException {
        final URL resource = FileUtils.class.getResource(fileName);
        return org.apache.commons.io.FileUtils.readLines(new File(resource.toURI()), Charset.defaultCharset());
    }
    public static List<Integer> readClassPathResourceAsListOfSingleDigits(String fileName) throws URISyntaxException, IOException {
        return readClassPathResourceAsListOfString(fileName).stream()
          .flatMapToInt(line->line.chars())
          .map(c->Integer.parseInt(""+(char)c))
          .boxed()
          .collect(Collectors.toList());
    }
    public static List<Long> readClassPathResourceAsListOfCommaSeperatedLong(String fileName) throws URISyntaxException, IOException {
        final String[] split = readClassPathResourceAsListOfString(fileName).get(0).split(",");
        return Arrays.stream(split)
          .mapToLong(s -> {
              try {
                  return Long.parseLong(s);
              }catch (Exception e){
                  return 0L;
              }
          })
          .boxed()
          .collect(Collectors.toList());
    }
}
