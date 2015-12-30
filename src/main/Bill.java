package main;

import java.text.DecimalFormat;

public class Bill {
	private Plan plan;
	private Discount discount;
	
	public Bill(Plan plan) {
		this.plan = plan;
		discount = new Discount();
	}

	public double calculateBill(int usedMinutes, int numberOfLines) {
		return Double.valueOf(new DecimalFormat("#.##").format(plan.getBasicMonthlyRate() 
															  + chargeForExcessUsage(usedMinutes, plan.getIncludedMinutes())
															  + chargeForAdditionalLines(numberOfLines)));
	}

	private double chargeForAdditionalLines(int numberOfLines) {
		return additionalLineRate(numberOfLines) + familyDiscount(numberOfLines);
	}

	private double additionalLineRate(int numberOfLines) {
		int chargeableLines = Math.min(numberOfLines, discount.getDiscountedLines());
		return (chargeableLines - 1) * plan.getAdditionalLineRate();
	}

	private double familyDiscount(int numberOfLines) {
		int chargeableLines = numberOfLines - discount.getDiscountedLines();
		return chargeableLines > 0 ? (chargeableLines * discount.getFamilyLineBillingRate()) : 0;
	}

	private double chargeForExcessUsage(int usedMinutes, int includedMinutes) {
		int chargeableMinutes = usedMinutes - includedMinutes;
		return chargeableMinutes > 0 ? chargeableMinutes * plan.getRatePerExcessMinute() : 0;
	}
}
