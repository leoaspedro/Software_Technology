package lr222qp.assign1.IntCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) {

		if (size == 0) {
			values[0] = n;
			size = size + 1;
		} else {

			if (checkIndex(size, values.length - 1) == false) {
				resize();
			}
			values[size] = n;
			size++;
		}
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException();

		if (size + 1 > values.length)
			resize();
		/*
		 * System.arraycopy(arg0, arg1, arg2, arg3, arg4); arg0 = from where we want to
		 * copy (source array) arg1 = which index of arg0 we want to start copying arg2
		 * = target array,where we want to store the copy elements arg3 = in which index
		 * we want to store the value from the source array into the copy array arg4 =
		 * how many elements do we want to copy from the source to the target array
		 */
		System.arraycopy(values, index, values, index + 1, size - index);

		values[index] = n;
		size = size + 1;

	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException();

		System.arraycopy(values, index + 1, values, index, size - index);
		size = size - 1;

	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException();
		return values[index];
	}

	@Override
	public int indexOf(int n) {
		for (int i = 0; i < size; i++)
			if (values[i] == n)
				return i;
		return -1;
	}

}
