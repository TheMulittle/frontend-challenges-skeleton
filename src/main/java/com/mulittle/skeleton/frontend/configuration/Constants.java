package com.mulittle.skeleton.frontend.configuration;

public class Constants {
  public static final String BASE_URL;

  static {
    BASE_URL = System.getProperty("BASE_URL") != null ? (System.getProperty("BASE_URL")) : "http://localhost:3000";
  }
  
}
