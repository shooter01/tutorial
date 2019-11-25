package main.java.threading;

public class Threading implements Runnable {
    private Long mills;

    public Threading(Long mills) {
        this.mills = mills;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName());
    }

}
