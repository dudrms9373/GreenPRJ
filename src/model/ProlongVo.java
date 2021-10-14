package model;

public class ProlongVo {
	// 필드
	public int Prol_id;
	private String Status;
	private String Start_date;
	private String End_date;
	private String Prol_date;
	private String Mem_id;

	// 생성자
	public ProlongVo(String Status, String Start_date, String End_date, String Prol_date, String Mem_id) {

		this.Status = Status;
		this.Start_date = Start_date;
		this.End_date = End_date;
		this.Prol_date = Prol_date;
		this.Mem_id = Mem_id;
	}

	// getter,setter

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getStart_date() {
		return Start_date;
	}

	public void setStart_date(String Start_date) {
		this.Start_date = Start_date;
	}

	public String getEnd_date() {
		return End_date;
	}

	public void setEnd_date(String End_date) {
		this.End_date = End_date;
	}

	public String getProl_date() {
		return Prol_date;
	}

	public void setProl_date(String Prol_date) {
		this.Prol_date = Prol_date;
	}

	public String getMem_id() {
		return Mem_id;
	}

	public void setMem_id(String Mem_id) {
		this.Mem_id = Mem_id;
	}

//toString()
	@Override
	public String toString() {
		return "ProlongVo [" + ",Status=" + Status + ", Start_date=" + Start_date + ", End_date=" + End_date
				+ ", Prol_date=" + Prol_date + ",Mem_id=" + Mem_id + "]";
	}

}
