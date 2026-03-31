package counter;

public class SimpleCounter {
    private int counter;

    public SimpleCounter(){
        this.counter = 0;
    }

    public void increment(){
        this.counter++;
    }

    public int get(){
        return counter;
    }
}
