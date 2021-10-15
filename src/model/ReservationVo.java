package model;

public class ReservationVo {
	// Fields
	private String  resDate;	//예약된 시간
	private String  resNote;	//예약된 내용
	private int  resMemId;	//예약정보 테이블 상의 회원번호
	private int  resTId; 	//예약정보 테이블 상의 트레이너번호
	// 생성자
	public ReservationVo(String resDate, String resNote, int resMemId, int resTId) {
		this.resDate = resDate;
		this.resNote = resNote;
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
	public int getResMemId() {
		return resMemId;
	}
	public void setResMemId(int resMemId) {
		this.resMemId = resMemId;
	}
	public int getResTId() {
		return resTId;
	}
	public void setResTId(int resTId) {
		this.resTId = resTId;
	}
	//toString()
	@Override public String toString(){return "ReservationVo [resDate=" + resDate + ", resNote=" + resNote + ", resMemId=" + resMemId + ", resTId=" + resTId + "]";}
	
}

