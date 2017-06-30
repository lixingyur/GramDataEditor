/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */
package gram.servlet;/*
 * Copyright 2015 RSVP Technologies Inc. All rights reserved.
 * @author xyli (xyli@rsvptech.ca)
 * @29/06/17.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootApplicationServer extends SpringBootServletInitializer {

  private static Class<SpringBootApplicationServer> applicationServerClass = SpringBootApplicationServer.class;

  public static void main(String[] args) {
    SpringApplication.run(applicationServerClass, args);
  }
}