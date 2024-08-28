import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {

    //identify test case column by scanning entire 1st row
    //once column is identified then scan entire testcase column to identify purchase testcase row
    //after grab purchase testcase row = pull all the data of that row and feed into test



    public static void main(String[] args) throws IOException {

        //file input stream
        FileInputStream fis = new FileInputStream("C://Users//e326215//OneDrive - Wesco//Documents//Notes//Rest API Testing (Automation) from Scratch-Rest Assured Java//demodata.xlsx");


        XSSFWorkbook workbook = new XSSFWorkbook(fis);
       // XSSFSheet sheet = workbook.getSheetAt(0);
        int totalsheetcount = workbook.getNumberOfSheets();
        for(int i=0;i<totalsheetcount;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();

                int k=0;
                int column = 0;
                while (ce.hasNext())
                {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")){

                        column=k;

                    }

                    k++;
                }
                System.out.println(column);

            }


        }

    }

}
