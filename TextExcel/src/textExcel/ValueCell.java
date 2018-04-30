package textExcel;

public class ValueCell implements Cell{
	private double value;
	public ValueCell() {
		
	}
	public ValueCell(double value) {
		this.value = value;
	}
	public void changeValue(double value) {
		this.value = value;
	}
	
	public String abbreviatedCellText() {
		String returnVal = value + "";
		if(returnVal.length() > 10) {
			return returnVal.substring(0, 10);
		}else{
			String abbText = returnVal.substring(0, returnVal.length());
			while(abbText.length()<10) {
				abbText += " ";
			}
			return abbText;
		}
	}
	public String fullCellText() {
		return (value + "");
	}
}
