package rocketBase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		RateDomainModel matchingRate = new RateDomainModel();
		for (RateDomainModel rate : rates) 
		{
			if (GivenCreditScore >= rate.getiMinCreditScore())
			{
				matchingRate = rate;
			}
			
		}
		
		double interestRate = matchingRate.getdInterestRate();
		
		//TODO - RocketBLL RateBLL.getRate
		
		if (!(interestRate > 0))
		{
			throw new RateException(matchingRate);
		}
		else
		{
			return interestRate;
		}
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
