public class CustomerParser
 {
 public static Customer parseStringToCustomer(String lineToParse)
  {
   String type = new String("?");
   String firstName = new String("?");
   String lastName = new String("?");
   String amountStr, yearStr, monthStr, dateStr;
   double amount = 0.0;
   int year, month, date;
 
   String member = "Member";
   String nonMember = "NonMember";
 
 
   // tokenize the lineToParse string based on the delimiter '/'
   String[] words = lineToParse.split("/");
 
   Customer customer;
 
   // First, extract the first six takens that are common in
   // member customer and non member customer
 
   type = words[0].trim();
 
   firstName = words[1].trim();
 
   lastName = words[2].trim();
 
   amountStr = words[3].trim();
   amount = Double.parseDouble(amountStr);
 
   yearStr = words[4].trim();
   year = Integer.parseInt(yearStr);
 
   monthStr = words[5].trim();
   month = Integer.parseInt(monthStr);
 
   dateStr = words[6].trim();
   date = Integer.parseInt(dateStr);
 
 
 
   // check if the first token contains "Member" or "NonMember".
   // regardless of upper/lower cases
   if (type.trim().equalsIgnoreCase(nonMember)) //if it is a non-member customer
    {
      String feeStr = words[7].trim();
      double fee = Double.parseDouble(feeStr);
 
      customer = new NonMemberCustomer(firstName, lastName, amount, year, month, date, fee);
    }
   else //if (type.trim().equalsIgnoreCase(member))
    {
      String pointsStr = words[7].trim();
      int points = Integer.parseInt(pointsStr);
 
      customer = new MemberCustomer(firstName, lastName, amount, year, month, date, points);
     }
   return customer;
  }
} //end of CustomerParser class