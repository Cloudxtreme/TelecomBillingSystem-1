package test;

import static org.junit.Assert.assertEquals;
import main.Bill;
import main.Plan;

import org.junit.Test;

public class BillTest {

	Bill goldPlan = new Bill(Plan.GOLD);
	Bill silverPlan = new Bill(Plan.SILVER);
	
	@Test
	public void GoldPlanWithUsageWithinLimitAndNoAdditionalLinesAndNoFamilyDiscount() {
		assertEquals(Plan.GOLD.getBasicMonthlyRate(), goldPlan.calculateBill(49, 1), 0);
	}
	
	@Test
	public void GoldPlanWithUsageBeyondLimitAndNoAdditionalLinesAndNoFamilyDiscount() {
		assertEquals(105.3, goldPlan.calculateBill(1123, 1), 0);
	}
	
	@Test
	public void GoldPlanWithUsageWithinLimitAndWithAdditionalLinesAndNoFamilyDiscount() {
		assertEquals(78.95, goldPlan.calculateBill(878, 3), 0);
	}
	
	@Test
	public void SilverPlanWithUsageBeyondLimitAndWithAdditionalLinesAndNoFamilyDiscount() {
		assertEquals(63.87, silverPlan.calculateBill(523, 2), 0);
	}
	
	@Test
	public void SilverPlanWithUsageWithinLimitAndWithAdditionalLinesAndFamilyDiscount() {
		assertEquals(82.95, silverPlan.calculateBill(44, 5), 0);
	}
	
	@Test
	public void SilverPlanWithUsageBeyondLimitAndWithAdditionalLinesAndFamilyDiscount() {
		assertEquals(94.29, silverPlan.calculateBill(521, 5), 0);
	}
	
	@Test
	public void GoldPlanWithUsageWithinLimitAndWithAdditionalLinesAndFamilyDiscount() {
		assertEquals(83.95, goldPlan.calculateBill(878, 4), 0);
	}
	
	@Test
	public void GoldPlanWithUsageBeyondLimitAndWithAdditionalLinesAndFamilyDiscount() {
		assertEquals(139.3, goldPlan.calculateBill(1123, 4), 0);
	}
}

