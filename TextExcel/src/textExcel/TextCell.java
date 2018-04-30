package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell() {
		
		
	}

	public TextCell(String text) {
		this.text = text;
	}
	public void changeValue(String text) {
		this.text = text;
	}
	public String abbreviatedCellText() {// text for spreadsheet cell display, must be exactly length 10
		if(text.length() > 10) {
			//String abbText = "";// abbreviated text
			//String [] textArr = text.split(text.charAt(10)+"");
			//for(int i = 1; i<11; i++) {
			//	abbText += text.charAt(i);
			//}
			
			return text.substring(1, 11);
		}else{
			String abbText = text.substring(1, text.length()-1);
			while(abbText.length()<10) {
				abbText += " ";
			}
			return abbText;
		}
	}
	public String fullCellText() {// text for individual cell inspection, not truncated or padded
		return text;
	}
}
