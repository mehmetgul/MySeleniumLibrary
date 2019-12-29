package mehmetgul.mylib.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelFile {

	@Test
	public void excelWorks() throws IOException {

		FileInputStream fis = new FileInputStream("TestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheet = workbook.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {

				Sheet sheets = workbook.getSheetAt(i);
				Iterator<Row> rows = sheets.iterator();

				Row firstrow = rows.next();

				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("id")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
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
