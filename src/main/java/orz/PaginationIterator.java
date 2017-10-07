package orz;

import java.util.Iterator;
import java.util.List;

public abstract class PaginationIterator<E> implements Iterator<E> {

	protected int index = 0;

	private Iterator<E> currentIterator = null;

	public PaginationIterator() {
		nextPage();
	}

	private void nextPage() {
		List<E> l = nextPage(index);
		if (null != l) {
			currentIterator = l.iterator();
			index += l.size();
		}
	}

	abstract List<E> nextPage(int begin);

	@Override
	public E next() {
		E next = currentIterator.next();
		if (!currentIterator.hasNext()) {
			nextPage();
		}
		return next;
	}

	@Override
	public boolean hasNext() {
		return currentIterator != null && currentIterator.hasNext();
	}
}
