package vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Book {

	private int bookNo; // 실제 query를 get해서 사용할때는 book_no(SQL workbench 컬럼명을 사용)
	private String title; 
	private String author;
	private int accessAge;
	
}
