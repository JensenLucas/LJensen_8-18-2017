package textExcel;

public class PercentCell implements Cell{
	String value;
	public PercentCell() {
	}
	public PercentCell(String value) {
		this.value = value;
	}
	public String abbreviatedCellText() {// text for spreadsheet cell display, must be exactly length 10
		return "          ";
	}
	public String fullCellText() {// text for individual cell inspection, not truncated or padded
		return "";
	}
}
