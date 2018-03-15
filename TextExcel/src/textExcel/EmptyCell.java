package textExcel;

public class EmptyCell extends Cell{
	public EmptyCell() {
		
	}
	public String abbreviatedCellText() {// text for spreadsheet cell display, must be exactly length 10
		return null;
	}
	public String fullCellText() {// text for individual cell inspection, not truncated or padded
		return null;
	}
}
