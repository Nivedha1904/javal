package multi_Threading;

class cakecounter{
	
	int cakecount=0;

public  synchronized void increment() {
	cakecount++;
	
}
}
 class Team implements Runnable{
	cakecounter  Counter ;

	public  Team(cakecounter Counter) {
		this.Counter=Counter;
	}
	@Override
	public void run() {
		for(int i=0;i<10000;i++) {
			Counter.increment();
			
		}
	}
 }
	public class Using_Synchronization  {
		
	
	public static void main(String[] args) throws InterruptedException {
		cakecounter ck=new cakecounter();
		
		Thread team1=new Thread(new Team(ck));
		Thread team2=new Thread(new Team(ck));
		
		System.out.println("Before the team1 start: "+team1.isAlive());
		team1.start();
		
		System.out.println("After the team1 start: "+team1.isAlive());
		team2.start();
		
		 team1.join();
	     team2.join();

	        System.out.println("Total Cakes Baked: " + ck.cakecount);
		

	}

}
