package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	public Spreadsheet() {
		Cell[][] spread = new Cell[getRows()][getCols()];
		for(Cell[] i : spread) {
			for(Cell j: spread[i]) {
				spread[i][j] = new EmptyCell;
			}
		}
	}
	
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
