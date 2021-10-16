package model;

public class MemberVo {

	// 필드
	private String height;
	private String weight;
	private String name;
	private String birth;
	private String id;
	private String pwd;
	private String tel;
	private String gender;
	private String address;

	// 생성자
	
	public MemberVo() {
		
	}
	
	
	
	
	//Dao에 getMemInfo에서 사용되는 생성자 -김영근
	public MemberVo(String height, String weight, String name, String tel, String gender, String address) {
		
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.address = address;
	}


	
	public MemberVo( String height, String weight, 
			String name, String birth, String id, String pwd,
			String tel, String gender, String address) {

		this.height = height;
		this.weight = weight;
		this.name = name;
		this.birth = birth;
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
		this.gender = gender;
		this.address = address;
	}

	// Getter /Setter
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


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

	// toString
	@Override
	public String toString() {
		return "MemberVo [ height=" + height + ", weight=" + weight + ", name=" + name
				+ ", birth=" + birth + ", id=" + id + ", pwd=" + pwd + ", tel=" + tel + ", gender=" + gender
				+ ", address=" + address + "]";
	}
}
