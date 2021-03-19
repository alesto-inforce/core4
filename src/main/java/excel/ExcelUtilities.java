package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtilities {

    public static Map<String,String> getData(String file,String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();

        Map<String,String> data = new HashMap<>();

        for (int i=0;i<=lastRowNum;i++){
            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue().trim();

            Cell valueCell = row.getCell(1);
            String value = valueCell.getStringCellValue().trim();

            data.put(key,value);
        }
        return data;
    }

}
