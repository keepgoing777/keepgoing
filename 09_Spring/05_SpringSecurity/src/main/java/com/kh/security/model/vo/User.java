package com.kh.security.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class User {
  private String id;
  private String pwd;
  private String name;
  private String role;
}
