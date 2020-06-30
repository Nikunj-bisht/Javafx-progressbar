package threadchallenge;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
bankaccount bank=new bankaccount("125-33-444",1000);
		 Thread thread1=new Thread() {
			 @Override
			 public void run() {
				 System.out.println("User1 doing transaction");
		bank.deposit(300);
		bank.withdraw(50);
		System.out.println(bank.getbalance());		 
					 
			 }
			 
		 };
		 
		Thread thread2=new Thread() {
			
			@Override
			public void run() {
			System.out.println("User2 doind transaction");
				 bank.deposit(2034);
				bank.withdraw(100);
		System.out.println(bank.getbalance());		 
			}
			
		};
		 
		 thread1.start();
		thread2.start();
		

	}
}	
	 
	  
	 class bankaccount {
		private  int initialmoney;
		private String accountnumber;
		public bankaccount(String accountnumber,int initialmoney) {
			this.accountnumber=accountnumber;
			
			this.initialmoney=initialmoney;
		}
		public  void deposit(int money) {
			synchronized(this) {
			this.initialmoney+=money;
			}
		}
		 public  void withdraw(int money) {
			 synchronized(this) {
			 this.initialmoney-=money;
			 }
			  
		 }
		 public int getbalance() {
			 
			 return this.initialmoney;
			 
		 }

	 }



