package io.nishandi.javapractice.multithreading;

public class RaceConditionDemo {
	public static void main (String [] args)
	   {
	      FinTrans1 ft = new FinTrans1 ();
	      TransThread1 tt1 = new TransThread1(ft, "Deposit Thread");
	      TransThread1 tt2 = new TransThread1(ft, "Withdrawal Thread");
	      tt1.start ();
	      tt2.start ();
	   }

}

class FinTrans1
{
   private String transName;
   private double amount;
  synchronized  void update (String transName, double amount)
   {
      this.transName = transName;
      this.amount = amount;
      System.out.println (this.transName + " " + this.amount);
   }
}


class TransThread1 extends Thread
{
   private FinTrans1 ft;
   TransThread1 (FinTrans1 ft, String name)
   {
      super (name); // Save thread's name
      this.ft = ft; // Save reference to financial transaction object
   }
   public void run ()
   {
      for (int i = 0; i < 5; i++)
          if (getName ().equals ("Deposit Thread"))
             ft.update("Deposit", 2000.0);
          else
             ft.update ("Withdrawal", 250.0);
   }
}
