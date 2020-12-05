package mehmetgul.mylib.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/** POI API Logic
 * Create object for XSSFWorkbook class
 * Get Access to Sheet
 * Get Access to all rows of Sheet
 * Access to specific row from all rows
 * Get Access to all cells of Row
 * Access the Data from Excel into Arrays
 */
public class ExcelFileWithArrayList {


	public ArrayList<String> getData(String testCaseName) throws IOException {

		ArrayList<String> arrayList = new ArrayList<>(); //creating arraylist to store the data

		//Connecting the excel file.
		FileInputStream fis = new FileInputStream("src/test/java/mehmetgul/mylib/excelfile/TestData1.xlsx");

		//Create object for XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//counting the number of sheets in excel workbook
		int sheet = workbook.getNumberOfSheets();

		//finding desired excel sheet name
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet2")) {

				XSSFSheet sheets = workbook.getSheetAt(i);

				//if we need to access different rows then we need to use like below in while loop
				Iterator<Row> rows = sheets.iterator();
				//Move the pointer to the first row.
				Row firstRow = rows.next();

				//Scan the each an every cell to find the desired column
				Iterator<Cell> ce = firstRow.cellIterator();  //row is collection of cells
				int k = 0;
				int column = 0;
				//hasNext checks the next cell has value or not.
				while (ce.hasNext()) {
					//moving the pointer to the next cell.
					Cell value = ce.next();
					//checking the cell value with desired value.
					if (value.getStringCellValue().equalsIgnoreCase(testCaseName)) {
						column = k;
					}
					k++;
				}
				//System.out.println(column);
				//Once column is identified then scan the entire column to identify row.
				while (rows.hasNext()) {
					Row r = rows.next(); //moving the pointer to the next row.
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next(); //we are assiging the cell value to c object.
							//We check the cell value if string then run if block other wise run else block
							if(c.getCellType()== CellType.STRING){
								arrayList.add(c.getStringCellValue());
							}
							else{
								//We get the c.getNumericCellValue() numeric value but ArrayList is String.
								//We are converting numeric value to text and adding to arrayList
								arrayList.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}

						}
					}
				}
			}
		}
		return arrayList;
	}

	@Test
	public void dataDriven() throws IOException {
		ExcelFileWithArrayList excelArray = new ExcelFileWithArrayList();
		ArrayList data = excelArray.getData("bbb");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
	//	System.out.println(data.get(2));
	//	System.out.println(data.get(3));
	}
}
