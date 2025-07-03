package vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Book {

	private int bookNo;
	private String title;
	private String author;
	private int accessAge;
	
}
