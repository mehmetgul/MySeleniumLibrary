package mehmetgul.mylib.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * POI API Logic
 * Create object for XSSFWorkbook class
 * Get Access to Sheet
 * Get Access to all rows of Sheet
 * Access to specific row from all rows
 * Get Access to all cells of Row
 * Access the Data from Excel into Arrays
 */
public class ExcelFile {

	@Test
	public void excelWorks() throws IOException {

		ArrayList<String> arrayList = new ArrayList<>(); //creating arraylist to store the data

		//Connecting the excel file.
		FileInputStream fis = new FileInputStream("TestData.xlsx");

		//Create object for XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//counting the number of sheets in excel workbook
		int sheet = workbook.getNumberOfSheets();
///
		//finding desired excel sheet name
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {

				Sheet sheets = workbook.getSheetAt(i);

				//if we need to access different rows then we need to use like below in while loop
				Iterator<Row> rows = sheets.iterator();
				//Move the pointer to the first row.
				Row firstrow = rows.next();

				//Scan the each an every cell to find the desired column
				Iterator<Cell> ce = firstrow.cellIterator();  //row is collection of cells
				int k = 0;
				int column = 0;
				//hasNext checks the next cell has value or not.
				while (ce.hasNext()) {
					//moving the pointer to the next cell.
					Cell value = ce.next();
					//checking the cell value with desired value.
					if (value.getStringCellValue().equalsIgnoreCase("id")) {
						column = k;
					}
					k++;
				}
				//System.out.println(column);
				//Once column is identified then scan the entire column to identify row.
				while (rows.hasNext()) {
					Row r = rows.next(); //moving the pointer to the next row.
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Serkan")) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}
					}
				}
			}
		}
	}
}
