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
			//ONLY WORKS FOR TEXTCELL
			//TODO add functionality for other cell types
			String[] pieces = command.split(command, 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(pieces[0]);
			spread[loc.getRow()][loc.getCol()] = becomeTextCell(pieces[1]);
			return(getGridText());
		}else if(command.equalsIgnoreCase("Clear")) {
			//clear the spreadsheet
			for(Cell[] i : spread) {
				for(Cell j: i) {
					j = new EmptyCell();
				}
			}
			return(getGridText());
		}else if(command.contains("clear")) {
			//because this comes after checking for clear, only a command like "Clear A1" will apply (assuming the user knows how to use the application)
			//TODO: maybe add more conditions later?
			//clear an individual cell
			String[] pieces = command.split(command, 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(pieces[0]);
			spread[loc.getRow()][loc.getCol()] = new EmptyCell();
			return(getGridText());
		}else {
			//theoretically, there is only one command left that could be input
			//TODO: add safety net for stupid inputs
			//returns the value of the given cell
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return(spread[loc.getRow()][loc.getCol()].fullCellText());
		}
	}
	
	public TextCell becomeTextCell(String input) {
		TextCell cat = new TextCell();
		cat.changeValue(input);
		return cat;
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
