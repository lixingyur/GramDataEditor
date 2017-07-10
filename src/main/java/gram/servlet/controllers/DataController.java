/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */
package gram.servlet.controllers;/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

  static String readFile(String filePath) throws IOException {
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

  static void writeFile(String filePath, String content) {
    if(StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
      return;
    }
    File file = new File(filePath);

    try (FileOutputStream fop = new FileOutputStream(file)) {

      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      // get the content in bytes
      byte[] contentBytes = content.getBytes();

      fop.write(contentBytes);
      fop.flush();
      fop.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  String getData(HttpServletResponse response,
      @RequestParam(value = "filePath") String filePath) throws IOException {
    return readFile(filePath);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  void saveData(@RequestBody HashMap<String, String> request) throws IOException {
    String filePath = request.get("path");
    String content = request.get("content");
    writeFile(filePath, content);
  }
}

