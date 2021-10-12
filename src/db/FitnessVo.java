public class FitnessVo {
	// 필드
	private String  name;
	private String  birth;
	private String  id;
	private String  pwd;
	private String  tel;
	private String  gender;
	private String  address;
	//생성자
	public FitnessVo(String username, String birth, String id, String passwd, String tel, String gender,
			String address) {
		super();
		this.name = username;
		this.birth = birth;
		this.id = id;
		this.pwd = passwd;
		this.tel = tel;
		this.gender = gender;
		this.address = address;
	}
	// Getter /Setter
	public String getname() {
		return name;
	}
	public void setname(String username) {
		this.name = username;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String passwd) {
		this.pwd = passwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//toString
	@Override
	public String toString() {
		return "FitnessVO [username=" + name + ", birth=" + birth + ", id=" + id + ", pwd=" + pwd + ", tel="
				+ tel + ", gender=" + gender + ", address=" + address + "]";
	}
}
