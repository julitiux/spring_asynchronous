package com.spring_asynchronous;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
  private String name;
  private String blog;
}
