package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] spread = new Cell[getRows()][getCols()];
	public Spreadsheet() {
		for(Cell[] i : spread) {
			for(Cell j: i) {
				j = new EmptyCell();
			}
		}
	}
	
	
	@Override
	public String processCommand(String command)
	{
		if(command.contains("=")) {
			//<cell> = <value>
			String[] pieces = command.split(command, 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(pieces[0]);
			spread[loc.getRow()][loc.getCol()] = pieces[1];
		}
		
		return "";
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
		return spread[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String f = "         |";//filler
		String header = ("   |A"+f+"B"+f+"C"+f+"D"+f+"E"+f+"F"+f+"G"+f+"H"+f+"I"+f+"J"+f+"K"+"L"+f);
		String body = "";
		for(Cell[] i : spread) {
			body += ("\n" + i + "  |");
			for(Cell j: i) {
				body += j.abbreviatedCellText() + "|";
			}
		}
		return header + body;
	}

}
