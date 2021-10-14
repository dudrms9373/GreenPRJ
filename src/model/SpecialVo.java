package model;

public class SpecialVo {
	//필드
	private String wDate; // 특이사항이 추가된 날짜
	private String speNote; //특이 사항 내용
	private int speMemId; // 특이 사항이 있는 회원의 번호
	// 생성자
	/// 추가용
	public SpecialVo(String speNote, int speMemId) {
		this.speNote = speNote;
		this.speMemId = speMemId;
	}
	/// 조회용
	public SpecialVo(String wDate, String speNote, int speMemId) {
		super();
		this.wDate = wDate;
		this.speNote = speNote;
		this.speMemId = speMemId;
	}
	// Getter/ Setter
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	public String getSpeNote() {
		return speNote;
	}
	public void setSpeNote(String speNote) {
		this.speNote = speNote;
	}
	public int getSpeMemId() {
		return speMemId;
	}
	public void setSpeMemId(int speMemId) {
		this.speMemId = speMemId;
	}
	// toString()
	@Override
	public String toString() {
		return "SpecialVo [wDate=" + wDate + ", speNote=" + speNote + ", speMemId=" + speMemId + "]";
	}
	
	
}
