package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] spread = new Cell[getRows()][getCols()];
	public Spreadsheet() {
		for(int i = 0; i<getRows(); i++){
			for(int j = 0; j<getCols(); j++){
				spread[i][j] = new EmptyCell();
			}
		}
	}
	
	
	@Override
	public String processCommand(String command)
	{
		String[] commandCut = command.split(" ", 3);
		
		SpreadsheetLocation loc = new SpreadsheetLocation(pieces[0]);
		if(command.contains("=")) {
			//<cell> = <value>
			//ONLY WORKS FOR TEXTCELL
			//TODO add functionality for other cell types
			String[] pieces = command.split(" = ", 2);
			if(pieces[1].contains("\"")) {
				spread[loc.getRow()][loc.getCol()] = new TextCell(pieces[1]);
				return(getGridText());
			}else if(pieces[1].contains("%")){
				spread[loc.getRow()][loc.getCol()] = new PercentCell(pieces[1]);

			}
			//else if(pieces[1].contains(".")){
			//	SpreadsheetLocation loc = new SpreadsheetLocation(pieces[0]);
			//	double value = Double.parseDouble(pieces[1]);
			//	spread[loc.getRow()][loc.getCol()] = new ValueCell(value);
			//}
			return "error: invalid input";
		}else if(command.equalsIgnoreCase("Clear")) {
			//CLEAR ALL
			for(int i = 0; i<getRows(); i++){
				for(int j = 0; j<getCols(); j++){
					spread[i][j] = new EmptyCell();
				}
			}
			return(getGridText());
		}else if(commandCut[0].equalsIgnoreCase("Clear")) {
			//CLEAR CELL
			
			//return"meow";
			//String[] pieces = command.split(command, 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(commandCut[1]);
			spread[loc.getRow()][loc.getCol()] = new EmptyCell();
			return(getGridText());
		}else if(command.length()<4){
			//Assuming there's no user error, any command less than length 4 should be a cell
			//i.e. "A1", "I12"
			//returns the value of the given cell
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return(spread[loc.getRow()][loc.getCol()].fullCellText());
		}else {
			//temporary safety net
			return "ERROR: "+ command + " is an invalid command";
		}
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
		body += "\n";
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
