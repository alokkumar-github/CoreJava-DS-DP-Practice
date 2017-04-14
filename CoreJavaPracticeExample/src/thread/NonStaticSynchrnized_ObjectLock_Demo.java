package thread;
/*
 * synchronized block / synchronized method
This is very important question, this forms the core of multi threading, you should be
able to explain this question in detail. When more than one thread try to access same
resource without synchronization causes race condition.
So we can solve race condition by using either synchronized block or
synchronized method. When no two threads can access same resource at a time
phenomenon is also called as mutual exclusion.


Example (Train ticket booking)Let's
say there is only 1 ticket available in train, and two passengers are trying to book
that ticket at same time without synchronization.
It might happen that both might end up booking up ticket, though only ticket was
available, which is of course going to create problem.
But if synchronization was there only of them would have been able to book ticket.
 */
public class NonStaticSynchrnized_ObjectLock_Demo {

	public static void main(String[] args) {
		TicketBookCommon tbc=new TicketBookCommon();
		
		Thread tr1=new Thread(tbc, "Thread-1");
		Thread tr2=new Thread(tbc, "Thread-2");
		tr1.start();
		tr2.start();

	}

}

// Without synchronized method / block
/*class TicketBookCommon implements Runnable{
	int ticketAvail=1;
	@Override
	public void run() {
		System.out.println("waiting for ticket to be booking by:::"+Thread.currentThread().getName());
		if(ticketAvail>0){
			System.out.println("Booking Ticket for :::"+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticketAvail--;
				System.out.println("Ticked Booked for:::"+Thread.currentThread().getName());
				System.out.println("Currently Available ticket :::"+ticketAvail);
		}else {
				System.out.println("Ticket Not Booked for ::::"+Thread.currentThread().getName());
			}
	}
	
}
*/

class TicketBookCommon implements Runnable{
	int ticketAvail=1;
	@Override
	public void run() {
		synchronized(this){
			System.out.println("waiting for ticket to be booking by:::"+Thread.currentThread().getName());
			if(ticketAvail>0){
				System.out.println("Booking Ticket for :::"+Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ticketAvail--;
				System.out.println("Ticked Booked for:::"+Thread.currentThread().getName());
				System.out.println("Currently Available ticket :::"+ticketAvail);
			}else {
				System.out.println("Ticket Not Booked for ::::"+Thread.currentThread().getName());
			}
		}
	}
	
}