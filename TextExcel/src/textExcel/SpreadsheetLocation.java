package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int rowLoc; //Row location
	int colLoc; //Column location
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
        return 0;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        rowLoc = ((""+cellName.charAt(0)).toLowerCase()).charAt(0)-65;
        
    }

}
