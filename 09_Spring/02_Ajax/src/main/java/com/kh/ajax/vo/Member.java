package com.kh.ajax.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Member {
 private String id;
 private String pwd;
 private String name;
 private int age;
}
