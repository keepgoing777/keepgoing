package com.kh.upload.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Board {
	
	private int no;
	private String title;
	private String content;
	private String url;
	private LocalDateTime createdAt;
 
}
