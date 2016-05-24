package rocketBase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void testException() throws RateException
	{
		
		double newRate = 0.00;
		try
		{
			newRate = RateBLL.getRate(765);
		}
		catch (Exception rex)
		{
			System.out.println("Error: no rate found");
		}
		
	}
	
	@Test
	public void testRate() throws RateException
	{
		double newRate = 0.00;
		newRate = RateBLL.getRate(500);
		assert(newRate == 4.5);
	}

	private void assertTrue(double d) {
		// TODO Auto-generated method stub
		
	}

}
