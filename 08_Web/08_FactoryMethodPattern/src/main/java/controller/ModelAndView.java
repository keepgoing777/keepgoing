package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ModelAndView {
	
	private String path;
	private boolean isRedirect;
	
	// path만 가지는 생성자
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}

}