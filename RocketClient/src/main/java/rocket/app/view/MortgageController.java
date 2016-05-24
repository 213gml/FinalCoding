package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	private String term15 = "15 Year Term";
	private String term30 = "30 Year Term";
	
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox cmbTerm;
	@FXML
	private Label lblIncome;
	@FXML
	private Label lblExpenses;
	@FXML
	private Label lblCreditScore;
	@FXML
	private Label lblHouseCost;
	@FXML
	private Button btnCalcMortgage;
	@FXML
	private Label lblError;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		
		lq.setdAmount((Double.parseDouble(txtHouseCost.getText())) - (Double.parseDouble(cmbTerm.getTypeSelector())));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		
		//Monthly PITI variable and two temp variables used in calculations
		double monthlyPITI = 0;
		double monthlyPITI_2, monthlyPITI_3;
		
		//Two calculations which will be used to determine the lowest
		monthlyPITI_2 = (lRequest.getIncome() * (28/100));
		monthlyPITI_3 = ((lRequest.getIncome() * (26/100)) - lRequest.getExpenses());
		
		//Checks for the lower of the two calculations
		if (monthlyPITI_3 < monthlyPITI_3)
		{
			monthlyPITI = monthlyPITI_3;
		}
		else if (monthlyPITI_3 > monthlyPITI_2)
		{
			monthlyPITI = monthlyPITI_2;
		}
		
		double payment = lRequest.getdPayment();
		
		if (payment > monthlyPITI)
		{
			lblError.setText("Error: The requested loan is greater than the maximum loan ammount");
		}
		else
		{
			lblError.setText("Payment is " + (Math.round(payment * 100)/100) + 
						 	 "and Rate is " + (lRequest.getdRate())+"%");
		}
	}

}
