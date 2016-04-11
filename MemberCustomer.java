import java.text.NumberFormat;
 
public class MemberCustomer extends Customer
 {
  private int pointsCollected;
 
  /** constructor initializes variables of the class **/
  public MemberCustomer(String fName, String lName, double amount,
                                                                                          int year, int month, int date, int points)
   {
    super(fName, lName, amount, year, month, date);
    this.pointsCollected = points;
   }
 
  /** it computes the payment amount for non-member customer **/
  public void computePaymentAmount()
   {
    if (this.pointsCollected > 100)
      paymentAmount = purchasedAmount*(0.8);
    else
      paymentAmount = purchasedAmount*(0.9);
 
    pointsCollected += (int) (purchasedAmount/(100));
   }
 
  /** it returns a string containing information on its instance variables **/
  public String toString()
   {
    NumberFormat money = NumberFormat.getCurrencyInstance();
 
    String result = "\nMember Customer:"
                  + super.toString()
                  + "Collected Points:\t" + pointsCollected
                  + "\n\n";
    return result;
   }
 }  //end of MemberCustomer class