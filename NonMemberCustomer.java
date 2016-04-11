import java.text.NumberFormat;
 
public class NonMemberCustomer extends Customer
 {
  private double visitFee;
 
  /** constructor initializes variables of the class **/
  public NonMemberCustomer(String fName, String lName, double amount,
                   int year, int month, int date, double fee)
   {
    super(fName, lName, amount, year, month, date);
    this.visitFee = fee;
   }
 
  /** it computes the payment amount for non-member customer **/
  public void computePaymentAmount()
   {
       paymentAmount = purchasedAmount + visitFee;
   }
 
  /** it returns a string containing information on its instance variables **/
  public String toString()
   {
    NumberFormat money = NumberFormat.getCurrencyInstance();
 
    String result = "\nNonMember Customer:"
                  + super.toString()
                  + "Visit Fee:\t\t" + money.format(visitFee)
                  + "\n\n";
    return result;
   }
 }  //end of NonMemberCustomer class