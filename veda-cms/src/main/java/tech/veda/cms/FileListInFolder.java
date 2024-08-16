package tech.veda.cms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListInFolder {

  public static void listFilesAndSize(String folderPath) {
    File folder = new File(folderPath);
    if (folder.exists() && folder.isDirectory()) {
      File[] files = folder.listFiles();
      if (files != null) {
        int i = 7;
        List<String> fileList = new ArrayList<>();
        for (File file : files) {
          if (file.isFile()) {
            String fullName = file.getName();
            String fileName = fullName.substring(fullName.lastIndexOf("_") + 1);
            String fileNameWithStoreId = fullName.substring(0, fullName.lastIndexOf("."));
            String fileSuffix = fullName.substring(fullName.lastIndexOf(".") + 1).equals("png") ? "image/png" : "image/jpeg";
            long fileSize = file.length();
            String text = "INSERT INTO `storage_file` VALUES (" + i + ", '2024-08-06 22:35:26.261069', 'admin', '" + fullName +  "', '" + fileName + "', " + fileSize + ", 'SsIPzgpd9rFgxJhe3yUxk', '" + fileSuffix + "');";
            fileList.add(text);
            if(!fileName.equals("bg.jpg")){
              i ++;
              System.out.println(text);

            }
          }
        };

        System.out.println(fileList);
      }
    }
  }

  public static void main(String[] args) {
    listFilesAndSize(System.getProperty("user.dir") + "/files");
  }
}

