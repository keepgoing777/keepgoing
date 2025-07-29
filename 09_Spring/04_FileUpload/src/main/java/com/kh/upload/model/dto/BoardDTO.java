package com.kh.upload.model.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class BoardDTO {
	private int no;
	private String title;
	private String content;
	private String url;
	private Date formatDate;
	private MultipartFile file;
}
