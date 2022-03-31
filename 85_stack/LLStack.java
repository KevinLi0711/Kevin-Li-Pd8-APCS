import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

	LinkedList<PANCAKE> _stack;
	int _size;

	public LLStack() {
		_stack = new LinkedList<PANCAKE>();
        _size = 0;
	}

	//Return true if this stack is empty, otherwise false.
    	public boolean isEmpty() {
		return _size == 0;
	}

    	//Return top element of stack without popping it.
    	public PANCAKE peekTop() {
		return _stack.getFirst();
	}

    	//Pop and return top element of stack.
    	public PANCAKE pop() {
		_size--;
		return _stack.remove();
	}

    	//Push an element onto top of this stack.
    	public void push( PANCAKE x ) {
		_stack.addFirst(x);
		_size++;
	}


}
