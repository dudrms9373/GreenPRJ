package db;

public class MemberVo {

	// 필드
	private int mem_id;
	private double height;
	private double weight;
	private String name;
	private String birth;
	private String id;
	private String pwd;
	private String tel;
	private String gender;
	private String address;
	private String date;

	// 생성자
	
	public MemberVo() {
		
	}

	public MemberVo(int mem_id, double height, double weight, String name, String birth, String id, String pwd,
			String tel, String gender, String address, String date) {
		super();
		this.mem_id = mem_id;
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.birth = birth;
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
		this.gender = gender;
		this.address = address;
		this.date = date;
	}

	// Getter /Setter

	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		return "MemberVo [mem_id=" + mem_id + ", height=" + height + ", weight=" + weight + ", name=" + name
				+ ", birth=" + birth + ", id=" + id + ", pwd=" + pwd + ", tel=" + tel + ", gender=" + gender
				+ ", address=" + address + ", date=" + date + "]";
	}
}
