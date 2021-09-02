package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {

    private final Logger log = LogManager.getLogger(FileHelper.class);

    /**
     * Belirtilen dizindeki dosyayı String olarak okur.
     * Örneğin: .sql uzantılı dosyaları string olarak okumak için kullanılır
     * Örnek Kullanım: C:\deneme.sql
     *
     * @param fileDirectory
     * @return
     */
    public String readFileAsString(String fileDirectory) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileDirectory)));
        } catch (IOException e) {
            log.error("An error occurred message:{}", e.getMessage());
            return "";
        }
    }


    public String getFileMimeType(File file) {

        String type = file.getName().split("[.]")[1].toLowerCase();
        switch ( type ) {

            case "xml":
                return "text/xml";
            case "js":
                return "application/javascript";
            case "json":
                return "application/json";
            case "doc":
                return "application/msword";
            case "pdf":
                return "application/pdf";
            case "sql":
                return "application/sql";
            case "xls":
                return "application/vnd.ms-excel";
            case "ppt":
                return "application/vnd.ms-powerpoint";
            case "odt":
                return "application/vnd.oasis.opendocument.text";
            case "pptx":
                return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "mpeg":
                return "audio/mpeg";
            case "ogg":
                return "audio/ogg";
            case "apng":
                return "image/apng";
            case "avif":
                return "image/avif";
            case "flif":
                return "image/flif";
            case "jpg":
                return "image/jpeg";
            case "jpeg":
                return "image/jpeg";
            case "jfif":
                return "image/jpeg";
            case "pjpeg":
                return "image/jpeg";
            case "pjp":
                return "image/jpeg";
            case "jxl":
                return "image/jxl";
            case "png":
                return "image/png";
            case "svg":
                return "image/svg+xml";
            case "webp":
                return "image/webp";
            case "css":
                return "text/css";
            case "csv":
                return "text/csv";
            case "html":
                return "text/html";
            case "htm":
                return "text/html";
            case "php":
                return "text/php";
            case "txt":
                return "text/plain";
            default:
                return null;
        }
    }
}
