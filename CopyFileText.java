package copyfiletext;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Nhập đường dẫn tệp tin nguồn: ");
            String sourcePath = br.readLine();

            System.out.print("Nhập đường dẫn tệp tin đến: ");
            String targetPath = br.readLine();

            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Tệp tin nguồn không tồn tại!");
                return;
            }

            File targetFile = new File(targetPath);
            if (targetFile.exists()) {
                System.out.println("Tệp tin đến đã tồn tại!");
            }

            copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {

            int characters = 0;
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
                characters++;
            }

            System.out.println("Đã sao chép " + characters + " ký tự.");
        }
    }
}

