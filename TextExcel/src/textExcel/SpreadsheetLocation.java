package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int rowLoc; //Row location: number
	int colLoc; //Column location: letter
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return rowLoc;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return colLoc;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        String x = "" + cellName.charAt(0);
    	colLoc = (x.toLowerCase()).charAt(0)-97;
        String[] placeholder = cellName.split(x);
        rowLoc = Integer.parseInt(placeholder[1]);
    }

}
