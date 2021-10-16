package model;

public class ExecutionVo {
	// 필드
	private String exeNote; //실행 내용
	private int height; //키
	private int weight; //몸무게
	private int remainNum; //남은 횟수
	private int resId; //예약 번호
	// 생성자
	public ExecutionVo(String exeNote, int height, int weight, int remainNum, int resId) {
		this.exeNote = exeNote;
		this.height = height;
		this.weight = weight;
		this.remainNum = remainNum;
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
	public int getRemainNum() {
		return remainNum;
	}
	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
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
		return "ExecutionVo [exeNote=" + exeNote + ", height=" + height + ", weight=" + weight + ", remainNum="
				+ remainNum + ", resId=" + resId + "]";
	}
	
}
