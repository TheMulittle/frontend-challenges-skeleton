package com.mulittle.skeleton.frontend.services;

public class PasswordManagerService {

  private static final String userTypeTemplate = "playlist.%s.%s";

  public static String getUserName(String userType) {
    return System.getProperty(String.format(userTypeTemplate, userType, "user"));
  }

  public static String getUserPassword(String userType) {
    return System.getProperty(String.format(userTypeTemplate, userType, "password"));
  }

}
