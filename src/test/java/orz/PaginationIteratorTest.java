package orz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PaginationIteratorTest {

	Iterator<TestData> createTestData(TestData[] data, int page) {
		List<TestData> list = Arrays.asList(data);
		int size = list.size();
		return new PaginationIterator<TestData>() {
			@Override
			List<TestData> nextPage(int begin) {
				if (size <= begin) {
					return null;
				}
				if (size <= begin + page) {
					return list.subList(begin, size);
				}
				return list.subList(begin, begin + page);
			}
		};
	}

	@Test
	public void test() {
		Iterator<TestData> it = createTestData(new TestData[] {
				new TestData("TEST",1),
				new TestData("TEST",2),
				new TestData("TEST",3),
				new TestData("TEST",4),
				new TestData("TEST",5)
		},2);
		String[] tests = new String[] {
				"TEST1",
				"TEST2",
				"TEST3",
				"TEST4",
				"TEST5"
		};
		int i = 0;
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			Assert.assertEquals(tests[i++], data.toString());
		}
	}

	@Test
	public void test1() {
		Iterator<TestData> it = createTestData(new TestData[] {},10);
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			System.out.println(data);
			Assert.assertTrue(false);
		}
	}
}

class TestData {
	TestData(String str, int n) {
		this.str = str;
		this.n = n;
	}

	public String str;
	public int n;

	@Override
	public String toString() {
		return str + n;
	}
}
