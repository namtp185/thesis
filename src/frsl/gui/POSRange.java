package frsl.gui;

public class POSRange {
	private int startIndex = -1;
	private int endIndex = -1;
	
	public boolean isValidRange() {
		return (startIndex != -1
				&& endIndex != - 1
				&& endIndex > startIndex);
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	public POSRange(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
}
