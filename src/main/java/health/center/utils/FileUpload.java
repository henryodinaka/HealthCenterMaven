
package health.center.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Kelechi
 */
public class FileUpload {

    private final String directory = System.getProperty("user.home") + "\\Receipts\\";

    public FileUpload() {
        try {
            if (Files.notExists(Paths.get(directory), LinkOption.NOFOLLOW_LINKS)) {
                Files.createDirectories(Paths.get(directory));
            } 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String upload(UploadedFile file, String username) {
        String fileType = "." + file.getContentType().split("/")[1];
        String fileName = null;
        String filePath =null;
        System.out.println("File size: " + file.getSize());
        if ((file.getContentType().contains("pdf") || file.getContentType().contains("image")) && file.getSize() <= 2000000) {
            try {
                fileName = getFileName(username + "_receipt" + fileType);
                File f = new File(directory + fileName);
                f.createNewFile();
                try (InputStream in = file.getInputstream(); OutputStream out = new FileOutputStream(f)) {
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                }
                filePath = f.getPath(); 
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return fileName;
        } else {
            return "error";
        }
    }

    public String getFileName(String fileName) throws IOException {
        int counter = 0;
        File file = new File(directory + fileName);
        String name = fileName.split("\\.")[0];
        String type = fileName.split("(?=\\.)")[1];
        while (file.exists()) {
            fileName = name + counter + type;
            file = new File(directory + fileName);
            counter++;
        }
        return fileName;
    }

    public void download() {
    }
}
