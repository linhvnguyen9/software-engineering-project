package model;

public class RoomStat extends Room{
	private int totalDay;
	private float totalIncome;
	private float fillrate;
	
	public RoomStat() {
		super();
	}
	
	public RoomStat(int totalDay, float totalIncome, float fillrate) {
		super();
		this.totalDay = totalDay;
		this.totalIncome = totalIncome;
		this.fillrate = fillrate;
	}

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	public float getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}

	public float getFillrate() {
		return fillrate;
	}

	public void setFillrate(float fillrate) {
		this.fillrate = fillrate;
	}
	
	
}
