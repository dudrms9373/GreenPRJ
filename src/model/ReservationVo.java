package model;

public class ReservationVo {
	// Fields
	private String  resDate;	//예약된 시간
	private String  resNote;	//예약된 내용
	private String  resCheck;	//PT인지 상담인지의 여부
	private String  resMemId;	//예약정보 테이블 상의 회원번호
	private String  resTId; 	//예약정보 테이블 상의 트레이너번호
	// 생성자
	public ReservationVo(String resDate, String resNote, String resCheck, String resMemId, String resTId) {
		this.resDate = resDate;
		this.resNote = resNote;
		this.resCheck = resCheck;
		this.resMemId = resMemId;
		this.resTId = resTId;
	}
	// Getter / Setter
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getResNote() {
		return resNote;
	}
	public void setResNote(String resNote) {
		this.resNote = resNote;
	}
	public String getResCheck() {
		return resCheck;
	}
	public void setResCheck(String resCheck) {
		this.resCheck = resCheck;
	}
	public String getResMemId() {
		return resMemId;
	}
	public void setResMemId(String resMemId) {
		this.resMemId = resMemId;
	}
	public String getResTId() {
		return resTId;
	}
	public void setResTId(String resTId) {
		this.resTId = resTId;
	}
	//toString()
	@Override public String toString(){return "ReservationVo [resDate=" + resDate + ", resNote=" + resNote + ", resCheck=" + resCheck + ", resMemId=" + resMemId + ", resTId=" + resTId + "]";}
	
}
