package orz;

import java.util.Iterator;
import java.util.List;

public abstract class PaginationIteratorWithSize<E> implements Iterator<E> {

	private int index = 0;
	private int size = 0;
	private int page = 10;

	private Iterator<E> currentIterator = null;

	public PaginationIteratorWithSize(int size, int page) {
		this.size = size;
		this.page = page;
		nextPage();
	}

	private void nextPage() {
		if (size <= index) {
			return;
		}
		List<E> l = null;
		if (size <= index + page) {
			l = nextPage(index, size);
		} else {
			l = nextPage(index, index + page);
		}
		if (null != l) {
			currentIterator = l.iterator();
			index += l.size();
		}
	}

	abstract List<E> nextPage(int begin, int end);

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
