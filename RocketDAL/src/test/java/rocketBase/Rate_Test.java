package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
	}
	
	@Test
	public void test2() {
		ArrayList<RateDomainModel> testRates = RateDAL.getAllRates();
		assert(testRates.get(0).getdInterestRate() == 5.00);
		assert(testRates.get(1).getdInterestRate() == 4.50);
		assert(testRates.get(2).getdInterestRate() == 4.00);
		assert(testRates.get(3).getdInterestRate() == 3.75);
		assert(testRates.get(4).getdInterestRate() == 3.50);
	}

}
