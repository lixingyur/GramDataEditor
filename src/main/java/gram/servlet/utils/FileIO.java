/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @11/07/17.
 */
package gram.servlet.utils;/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @11/07/17.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;
import org.springframework.util.StringUtils;

public class FileIO {

  public static String readFile(String filePath) throws IOException {
    FileInputStream inputStream = null;
    Scanner sc = null;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      inputStream = new FileInputStream(filePath);
      sc = new Scanner(inputStream, "GBK");
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        stringBuilder.append(line + '\n');
      }
      // note that Scanner suppresses exceptions
      if (sc.ioException() != null) {
        throw sc.ioException();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (sc != null) {
        sc.close();
      }
    }
    return stringBuilder.toString();
  }

  public static void writeFile(String filePath, String content) {
    if(StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
      return;
    }
    File file = new File(filePath);
    file.setWritable(true, false);

    try (FileOutputStream fop = new FileOutputStream(file)) {
      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }
      Writer out = new BufferedWriter(new OutputStreamWriter(fop, "GBK"));


      // get the content in bytes

      out.write(content);
      out.flush();
      out.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
