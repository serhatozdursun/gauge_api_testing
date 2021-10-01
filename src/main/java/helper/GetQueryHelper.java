package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class GetQueryHelper {
    private String query = new String();

    private List<Path> allQueries() {
        List<Path> files = new ArrayList<>();
        Path path = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("sqlQueries"))
                .getPath());
        try (Stream<Path> walk = Files.walk(path)) {
            files = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    private List<String> getFileContentAsList() throws IOException {
        List<Path> files;
        files = allQueries();
        List<String> fileList = new ArrayList<>();
        for (Path path : files) {
            var file = Files.readAllBytes(path);
            fileList.add(new String(file));
        }
        return fileList;
    }

    public String getQueryName(String queryName) throws IOException {
        List<String> fileContents;
        fileContents = getFileContentAsList();

        IntStream.range(0, fileContents.size())
                .forEach(index -> {
                    IntStream.range(0, fileContents.get(index).split("--").length)
                            .forEach(indexOfCon -> {
                                if (fileContents.get(index).split("--")[indexOfCon].contains(queryName))
                                    clearQueryText(queryName, fileContents.get(index).split("--")[indexOfCon]);
                            });
                });
        return query;
    }

    private void clearQueryText(String queryName, String queryString) {
        query = queryString.replaceAll(queryName, "");
        query = queryString.replaceAll("\\n", " ");
    }

    /*
            for (String content : fileContents) {
            for (String queries : content.split("--")) {
                if (queries.contains(queryName)) {
                    query = queries.replaceAll(queryName, "");
                    query = query.replaceAll("\\n", " ");
                    break;
                }
            }
        }
     */
}
