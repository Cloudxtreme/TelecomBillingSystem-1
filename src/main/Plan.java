package main;

public enum Plan {
	GOLD(49.95, 1000, 0.45, 14.50), SILVER(29.95, 500, 0.54, 21.50);
	
	private double basicMonthlyRate;
	private int includedMinutes;
	private double ratePerExcessMinute;
	private double additionalLineRate;
	
	Plan (double basicMonthlyRate, int includedMinutes, double ratePerExcessMinute, double additionalLineRate) {
		this.basicMonthlyRate = basicMonthlyRate;
		this.includedMinutes = includedMinutes;
		this.ratePerExcessMinute = ratePerExcessMinute;
		this.additionalLineRate = additionalLineRate;
	}

	public int getIncludedMinutes() {
		return includedMinutes;
	}

	public double getBasicMonthlyRate() {
		return basicMonthlyRate;
	}

	public double getRatePerExcessMinute() {
		return ratePerExcessMinute;
	}

	public double getAdditionalLineRate() {
		return additionalLineRate;
	}
}
