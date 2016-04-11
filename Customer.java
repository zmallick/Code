import java.text.NumberFormat;
import java.sql.Date;

 
public abstract class Customer
 {
  protected String firstName;
  protected String lastName;
  protected double purchasedAmount;
  protected int purchasedYear, purchasedMonth, purchasedDate;
  protected double paymentAmount;
 
  /** constructor to initialize each instance variable **/
  public Customer(String fName, String lName, double amount, int year, int month, int date)
   {
    this.firstName = fName;
    this.lastName = lName;
    this.purchasedAmount = amount;
    this.purchasedYear = year;
    this.purchasedMonth = month;
    this.purchasedDate = date;
    this.paymentAmount = 0.0;
   }
 
  /** it computes a customer's payment amount, it will be implemented in child classes **/
  public abstract void computePaymentAmount();
 
  /** accessor method of purchased amount **/
  public double getPurchasedAmount()
   {
    return this.purchasedAmount;
   }
 
  /** it returns a string containing information of instance variables **/
  public String toString()
   {
    NumberFormat money = NumberFormat.getCurrencyInstance();
 
    return ("\nFirst name:\t\t" + firstName + "\n"
          + "Last name:\t\t" + lastName + "\n"
          + "Purchased Amount:\t" + money.format(purchasedAmount) + "\n"
          + "Purchased Date:\t\t" + purchasedMonth + "/" + purchasedDate
          + "/" + purchasedYear + "\n"
          + "Payment Amount:\t\t" + money.format(paymentAmount) + "\n");
   }
 }  //end of Customer class