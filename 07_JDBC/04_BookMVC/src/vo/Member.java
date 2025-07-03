package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Member {
	private String id; //primary key
	private String name;
	private String pwd;
	private int age;
}

