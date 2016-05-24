package rocketServer;

import java.io.IOException;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived
			
			try
			{
				//Throws exception if no rate is found, sends error message
				double determinedRate = RateBLL.getRate(lq.getiCreditScore());
				
				if (determinedRate > 0)
				{
					double ratePayment = RateBLL.getPayment(lq.getdRate(), lq.getiTerm(), 
															lq.getdAmount(), 0, true);
				}
			}
			catch (Exception e)
			{
				sendToAll(e);
				System.out.println("Error: no rate was found");
			}
			
			sendToAll(lq);
		}
	}
}
