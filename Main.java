
class A extends Thread
{
    public void run()
    {
    for(int i =0;i<5;i++)
    {
        System.out.println("sam");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }
}
class myRunnable implements Runnable
{

    @Override
    public void run() {
        
        for(int i=0;i<10;i++) System.out.println(i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
class Main1
{
    public static void main(String[] args) throws InterruptedException {
    
        myRunnable mr = new myRunnable();

        Thread t = new Thread(mr);
        
        A obj = new A();
        obj.start();

        t.start();
        
        for(int i=0;i<5;i++) {
            System.out.print("Ram"+" ");
            Thread.sleep(1000);
        }
    }
}