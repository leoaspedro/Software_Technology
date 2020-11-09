package lr222qp.assign1.IntCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {{
}
private int position = -1;
	@Override
	public void push(int n) {
		if (size++ > values.length)
			resize();
		
		position++;
		values[position] = n;
		
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		if (size - 1 < 0)
			throw new IndexOutOfBoundsException();
		
		int i = peek();
		position--;
		size--;
		
		return i;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if (position < 0)
			throw new IndexOutOfBoundsException();
		return values[position];
	}

}
