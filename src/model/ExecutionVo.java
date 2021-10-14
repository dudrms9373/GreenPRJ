package model;

public class ExecutionVo {
	// 필드
	private String exeNote; //실행 내용
	private int height; //키
	private int weight; //몸무게
	private String exeCheck; //상담 또는 PT
	private int resId; //예약 번호
	// 생성자
	public ExecutionVo(String exeNote, int height, int weight, String exeCheck, int resId) {
		this.exeNote = exeNote;
		this.height = height;
		this.weight = weight;
		this.exeCheck = exeCheck;
		this.resId = resId;
	}
	// Getter / Setter
	public String getExeNote() {
		return exeNote;
	}
	public void setExeNote(String exeNote) {
		this.exeNote = exeNote;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getExeCheck() {
		return exeCheck;
	}
	public void setExeCheck(String exeCheck) {
		this.exeCheck = exeCheck;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	//toString()
	@Override
	public String toString() {
		return "ExecutionVo [exeNote=" + exeNote + ", height=" + height + ", weight=" + weight + ", exeCheck="
				+ exeCheck + ", resId=" + resId + "]";
	}
	
}