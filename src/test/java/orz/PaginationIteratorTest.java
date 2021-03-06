package orz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PaginationIteratorTest {

	int index = 0;
	Iterator<TestData> createTestData(TestData[][] data) {
		index = 0;
		return new PaginationIterator<TestData>() {
			@Override
			List<TestData> nextPage(int begin) {
				if (index < data.length) {
					return Arrays.asList(data[index++]);
				}
				return null;
			}
		};
	}


	@Test
	public void test0() {
		Iterator<TestData> it = createTestData(new TestData[][] {});
		int i = 0;
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			System.out.println(data);
			Assert.assertTrue(false);
		}
		Assert.assertEquals(0, i);
	}
	@Test
	public void test1() {
		Iterator<TestData> it = createTestData(new TestData[][] {
			new TestData[] {
				new TestData("TEST",1),
				new TestData("TEST",2),
				new TestData("TEST",3)
			},
			new TestData[] {
				new TestData("TEST",4),
				new TestData("TEST",5)
			}
		});
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
		Assert.assertEquals(5, i);
	}
	@Test
	public void test2() {
		Iterator<TestData> it = createTestData(new TestData[][] {
			new TestData[] {
				new TestData("TEST",1),
				new TestData("TEST",2),
				new TestData("TEST",3)
			},
			new TestData[] {
				new TestData("TEST",4),
				new TestData("TEST",5),
				new TestData("TEST",6)
			}
		});
		String[] tests = new String[] {
				"TEST1",
				"TEST2",
				"TEST3",
				"TEST4",
				"TEST5",
				"TEST6"
		};
		int i = 0;
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			Assert.assertEquals(tests[i++], data.toString());
		}
		Assert.assertEquals(6, i);
	}
	@Test
	public void test3() {
		Iterator<TestData> it = createTestData(new TestData[][] {
			new TestData[] {
				new TestData("TEST",1),
				new TestData("TEST",2),
				new TestData("TEST",3),
				new TestData("TEST",4)
			},
			new TestData[] {
				new TestData("TEST",5),
				new TestData("TEST",6)
			}
		});
		String[] tests = new String[] {
				"TEST1",
				"TEST2",
				"TEST3",
				"TEST4",
				"TEST5",
				"TEST6"
		};
		int i = 0;
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			Assert.assertEquals(tests[i++], data.toString());
		}
		Assert.assertEquals(6, i);
	}
	@Test
	public void test4() {
		Iterator<TestData> it = createTestData(new TestData[][] {
			new TestData[] {
				new TestData("TEST",1),
				new TestData("TEST",2),
				new TestData("TEST",3),
				new TestData("TEST",4),
				new TestData("TEST",5),
				new TestData("TEST",6)
			}
		});
		String[] tests = new String[] {
				"TEST1",
				"TEST2",
				"TEST3",
				"TEST4",
				"TEST5",
				"TEST6"
		};
		int i = 0;
		for (TestData data : new Iterable<TestData>() {
			public Iterator<TestData> iterator() {
				return it;
			};
		}) {
			Assert.assertEquals(tests[i++], data.toString());
		}
		Assert.assertEquals(6, i);
	}
}
