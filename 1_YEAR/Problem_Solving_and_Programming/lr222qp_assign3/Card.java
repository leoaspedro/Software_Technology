package lr222qp_assign3;

public class Card {
public enum suite {
	HEART(1),DIAMOND(2),SPADES(3),CLUBS(4);
	private int ValueSuite;
	private suite (int valsuite) {
				this.ValueSuite = valsuite;
	}
	private int getSuiteLevel() {
		return this.ValueSuite;
	}
	public static String getSuiteName(int n) {
		for(suite test : suite.values()) {
			if(n==test.getSuiteLevel()) {
				return test.name();
			}
		}
		return null;
	}
}
public enum rank{
	TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(1);
	
	private int ValueRank;
	private rank(int valra) {
		this.ValueRank=valra;
	}
	private int getRankLevel() {
		return this.ValueRank;
	}
	
	public static String getRankName(int n) {
		for(rank test:rank.values()) {
		if(n==test.getRankLevel()) {
			return test.name();
		}
	}
	return null;
}
}
}



