package snapcheck_payment_sorting;

public class PaymentObject {
	int paymentNumber;
	int amount;
	long date;
	       
	public PaymentObject(int id, int amount, long time){
	    this.paymentNumber = id;
	    this.amount = amount;
	    this.date = time;
	}
	   
}
