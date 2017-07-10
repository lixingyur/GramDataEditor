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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;
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
      sc = new Scanner(inputStream, "UTF-8");
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        stringBuilder.append(line+'\n');
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
  @RequestMapping(value = "/get", method = RequestMethod.GET)
  String getData(HttpServletResponse response,
      @RequestParam(value = "filePath") String filePath) throws IOException {
    return readFile(filePath);
  }

}

