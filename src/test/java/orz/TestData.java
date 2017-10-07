package orz;

public class TestData {
	public TestData(String str, int n) {
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
