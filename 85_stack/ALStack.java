import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

	ArrayList<PANCAKE> _stack;
	int _size;

	public ALStack()
	{
  		_stack = new ArrayList<PANCAKE>();
		_size = 0;
	}

	public void push( PANCAKE s )
  	{
    	_stack.set(_size, s);
		_size++;
  	}// O(1)


  	//means of removal
  	public PANCAKE pop()
  	{
		_size--;
    	return _stack.get(_size);
  	}// O(1)

  	public PANCAKE peekTop()
	{
    	return _stack.get(_size-1);
  	}

	//chk for emptiness
	public boolean isEmpty()
  	{
    	return _size == 0;
  	}// O(1)

}
