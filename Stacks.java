public class Stacks<E> implements Stack
{
	private E[] stack;
	private int top;

	public Stacks(int size)
	{
		@SuppressWarnings( "unchecked" )
		stacks = (E[]) new Object[size];
		for (int i = 0; i < stacks.length; i++)
		{
			stacks[i] = null;
		}
		top = -1;
	}

	/**
     * Tests if this Stack is empty.
     *
     * @return true if this Stack is empty; and false otherwise.
     */
    public boolean isEmpty()
    {
    	return (top == -1);
    }

    /**
     * Tests if this Stack is full.
     *
     * @return true if this Stack is full; and false otherwise.
     */
    public boolean isFull()
    {
    	return (top == stacks.length - 1);
    }


    /**
     * Returns a reference to the top element; does not change
     * the state of this Stack.
     *
     * @return The top element of this stack without removing it.
     */
    public E peek()
    {
    	return stacks[top];
    }

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return The top element of this stack.
     */
    public E pop()
    {
    	if !(this.isEmpty())
    	{
    		E tmp = stacks[top];
    		stacks[top] = null;
    		top = top - 1;
    		return tmp;
    	}
    	else
    	{
    		E tmp = null;
    		return tmp;
    	}
    }

    /**
     * Puts an element onto the top of this stack.
     *
     * @param element the element be put onto the top of this stack.
     */
    public void push( E element )
    {
    	if !(isFull())
    	{
    		stacks[top + 1] = element;
    		top++;
    	}
    }
}