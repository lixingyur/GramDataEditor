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

import gram.servlet.utils.FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  String getData(HttpServletResponse response,
      @RequestParam(value = "filePath") String filePath) throws IOException {
    return FileIO.readFile(filePath);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  void saveData(@RequestBody String request) throws IOException {

    JSONObject jsonObject = new JSONObject(request);
    String filePath = jsonObject.isNull("path") ? "" : jsonObject.getString("path");
    String content = jsonObject.isNull("content") ? "" : jsonObject.getString("content");
    FileIO.writeFile(filePath, content);

  }
}

