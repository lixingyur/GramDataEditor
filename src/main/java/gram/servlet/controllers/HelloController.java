/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @04/07/17.
 */
package gram.servlet.controllers;/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @04/07/17.
 */

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  @RequestMapping("/helloJsp")
  public String helloJsp(Map<String, Object> map) {
    map.put("hello", "asdfasd");
    return "helloJsp";
  }
}
