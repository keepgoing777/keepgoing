package vo;

public class Member {
  private String id;
  private String pwd;
  
    public Member() {

}

  public Member(String id, String pwd) {

	this.id = id;
	this.pwd = pwd;
  }

  @Override
  public String toString() {
	return "Member [id=" + id + ", pwd=" + pwd + "]";
  }
  
}  
	
