package entity;

public class Plan {
	private Integer planId;
	private Integer scheduleStart;
	private Integer scheduleEnd;
	
	Plan(Integer planId, Integer mealTime){
		this.setPlanId(planId);
		this.setScheduleStart(scheduleStart);
		this.setScheduleEnd(scheduleEnd);
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getScheduleStart() {
		return scheduleStart;
	}

	public void setScheduleStart(Integer scheduleStart) {
		this.scheduleStart = scheduleStart;
	}

	public Integer getScheduleEnd() {
		return scheduleEnd;
	}

	public void setScheduleEnd(Integer scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}

}
