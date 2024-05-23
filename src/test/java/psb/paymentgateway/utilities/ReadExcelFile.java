package psb.paymentgateway.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ReadExcelFile {
    @DataProvider
    public Object[][] getTestData() {
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook("C:\\Users\\oluwaseun.onaleye\\Downloads\\PaymentGateWayPortal02\\TestData\\testdata.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][5];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = sheet.getRow(i).getCell(0).getStringCellValue(); // TestCase
            data[i][1] = sheet.getRow(i).getCell(1).getStringCellValue(); // Username
            data[i][2] = sheet.getRow(i).getCell(2).getStringCellValue(); // Email
            data[i][3] = sheet.getRow(i).getCell(3).getStringCellValue(); // Password
            data[i][4] = sheet.getRow(i).getCell(4).getStringCellValue(); // ConfirmPassword
        }

        return data;
    }

}
