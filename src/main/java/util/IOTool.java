/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */
package util;/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IOTool {
  public static String read(String path) throws IOException {
    StringBuilder content = new StringBuilder();
    FileInputStream inputStream = null;
    Scanner sc = null;
    try {
      inputStream = new FileInputStream(path);
      sc = new Scanner(inputStream, "UTF-8");
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        content.append(line).append("\n");
      }
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
    return content.toString();
  }

  public static void main(String[] args) throws IOException {
    String a = read("src/main/webapp/jqueryFileTree.jsp" );
    System.out.println(a);
  }
}
