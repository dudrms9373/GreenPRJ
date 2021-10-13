package model;
public class FitnessVo {
	// 필드
	public  int mem_id=0;
	private String  name;
	private String  birth;
	private String  id;
	private String  pwd;
	private String  tel;
	private String  gender;
	private String  address;
	private String  height;
	private String  weight;
	
	public FitnessVo() {
		super();
	}

	//생성자
	public FitnessVo(String name, String birth, String id, String pwd, String tel, String gender,
			String address, String height, String weight) {
		super();
		this.name = name;
		this.birth = birth;
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
		this.gender = gender;
		this.address = address;
		this.height = height;
		this.weight = weight;
	}
	
	// Getter /Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPwd(String pwd) {
		this.pwd = pwd;
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


	@Override
	public String toString() {
		return "FitnessVo ["+", name=" + name + ", birth=" + birth + ", id=" + id + ", pwd=" + pwd
				+ ", tel=" + tel + ", gender=" + gender + ", address=" + address + ", height=" + height + ", weight="
				+ weight + "]";
	}

	
}
