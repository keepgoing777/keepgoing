package come.kh.practice2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Book {

	private String title;
	private boolean coupon;
	private int accessAge;
}
