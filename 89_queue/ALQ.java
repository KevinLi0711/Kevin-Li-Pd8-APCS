import java.util.ArrayList;

public class ALQ<QUASAR> implements Queue<QUASAR> {
    int head = 0;
    int size = 0;
    ArrayList<QUASAR> list;

    public ALQ<QUASAR>() {
        list = new ArrayList<QUASAR>();
    }

    public QUASAR dequeue() {
        head++;
        size--;
    }

    public QUASAR peekFront() {
        return list.get(head);
    }
}