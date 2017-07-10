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
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FileTreeController {

  @RequestMapping(value = "/jqueryFileTree", method = RequestMethod.GET)
  @ResponseBody
  String getDirectory(HttpServletResponse response,
      @RequestParam(value = "dir") String dir) throws IOException {
    StringBuilder htmlResult = new StringBuilder();
    if(StringUtils.isEmpty(dir)) {
      return htmlResult.toString();
    }
    if (dir.charAt(dir.length()-1) == '\\') {
      dir = dir.substring(0, dir.length()-1) + "/";
    } else if (dir.charAt(dir.length()-1) != '/') {
      dir += "/";
    }

    dir = java.net.URLDecoder.decode(dir, "UTF-8");

    if (new File(dir).exists()) {
      String[] files = new File(dir).list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.charAt(0) != '.';
        }
      });
      Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
      htmlResult.append("<ul class=\"jqueryFileTree\">");
      // All dirs
      for (String file : files) {
        if (new File(dir, file).isDirectory()) {
          htmlResult.append("<li class=\"directory collapsed\"><a href=\"#\" rel=\"" + dir + file + "/\">"
              + file + "</a></li>");
        }
      }
      // All files
      for (String file : files) {
        if (!new File(dir, file).isDirectory()) {
          int dotIndex = file.lastIndexOf('.');
          String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
          htmlResult.append("<li class=\"file ext_" + ext + "\"><a href=\"#\" rel=\"" + dir + file + "\">"
              + file + "</a></li>");
        }
      }
      htmlResult.append("</ul>");
    }
    return htmlResult.toString();
  }

}