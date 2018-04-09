package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] spread = new Cell[getRows()][getCols()];
	public Spreadsheet() {
		for(int i = 0; i<getRows(); i++){
			for(int j = 0; j<getCols(); j++){
				Cell[i][j] = new EmptyCell();
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
			String[] pieces = command.split(" = ", 2);
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
		}else if(isCell(command)){
			//theoretically, there is only one command left that could be input
			//returns the value of the given cell
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return(spread[loc.getRow()][loc.getCol()].fullCellText());
		}else {
			//temporary safety net
			return "";
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
		String header = ("   |A"+f+"B"+f+"C"+f+"D"+f+"E"+f+"F"+f+"G"+f+"H"+f+"I"+f+"J"+f+"K"+f+"L"+f);
		String body = "";
		for(int i = 0; i < spread.length; i++) {
			if(i<9) {
				body += ("\n" + (i+1) + "  |");
			}else {
				body += ("\n" + (i+1) + " |");
			}
			
			for(int j=0; j < spread[i].length; j++) {
				//body += ("Meow      |");
				body += spread[i][j].abbreviatedCellText() + "|";
			}
		}
		return header + body;
	}
	
	public boolean isCell(String cell) {
		//checks if a passed String is a cell location (B7 == true, Z21 == false, cat == false)
		if(cell.length()>4) {
			SpreadsheetLocation loc = new SpreadsheetLocation(cell);
			if(loc.getRow() > 19 || loc.getRow() < 0 || loc.getCol() > 11 || loc.getCol() < 0) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}

}
