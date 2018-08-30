package thread;
/*
 * Odd:1
Even:2
Odd:3
Even:4
Odd:5
Even:6
Odd:7
Even:8
Odd:9
Even:10
 */
public class PrintEvenOddUsingTwoThread {

	public static void main(String[] args) {
		 Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 20, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 20, true));
        t1.start();
        t2.start();

	}

}
class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        //System.out.println("Run method");
        int number = isEvenNumber == true ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber) {
                //System.out.println("Even :"+ Thread.currentThread().getName());
                print.printEven(number);
                //number+=2;
            } else {
                //System.out.println("Odd :"+ Thread.currentThread().getName());
                print.printOdd(number);
                // number+=2;
            }
            number += 2;
        }

    }

}

class Printer {

    boolean isOdd = false;

    synchronized void printEven(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = true;
        notifyAll();
    }

}

/*
 * 0Thread[Thread-0,5,main]
2Thread[Thread-0,5,main]
4Thread[Thread-0,5,main]
6Thread[Thread-0,5,main]
8Thread[Thread-0,5,main]
10Thread[Thread-0,5,main]
1Thread[Thread-1,5,main]
3Thread[Thread-1,5,main]
5Thread[Thread-1,5,main]
7Thread[Thread-1,5,main]
9Thread[Thread-1,5,main]
11Thread[Thread-1,5,main]

 */
class Thread11 implements Runnable {

    private static boolean evenFlag = true;

    public synchronized void run() {
    	for (int i = 0; i <= 10; i += 1) {
	        if (evenFlag == true) {
	            printEven();
	        } else {
	           printOdd();
	        }
    	}
    }

    public void printEven() {
    	 if (evenFlag == true) {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i+""+Thread.currentThread());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        evenFlag = false;
        notifyAll();
        }
    }

    public  void printOdd() {
    	 if (evenFlag == false) {
        for (int i = 1; i <= 11; i += 2) {
            System.out.println(i+""+Thread.currentThread());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        evenFlag = true;
        notifyAll();
    	 }
    }
}

 class OddEvenDemo {

    public static void main(String[] args) {

        Thread11 t1 = new Thread11();
        Thread td1 = new Thread(t1);
        Thread td2 = new Thread(t1);
        td1.start();
        td2.start();

    }
}