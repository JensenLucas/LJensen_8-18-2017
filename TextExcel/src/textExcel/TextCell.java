package textExcel;

public class TextCell implements Cell{
	private String text;
	public void changeValue(String text) {
		this.text = text;
	}
	public String abbreviatedCellText() {// text for spreadsheet cell display, must be exactly length 10
		if(text.length() > 10) {
			String abbText = "";// abbreviated text
			//String [] textArr = text.split(text.charAt(10)+"");
			for(int i = 0; i<10; i++) {
				abbText += text.charAt(i);
			}
			return abbText;
		}else{
			String abbText = text;
			while(abbText.length()<10) {
				abbText += " ";
			}
			return abbText;
		}
	}
	public String fullCellText() {// text for individual cell inspection, not truncated or padded
		return ("\"") + text + ("\"");
	}
}
