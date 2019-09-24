public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"path-to-file.xlsx";
static Workbook book;
static Sheet sheet;

//in your PageTest.java
// pass the sheet name, e.g. String sheetName = "contacts";
//@DataProvider
//public Object[][] getCRMTestData(){
//        Object data[][] = TestUtil.getTestData(sheetName);
//        return data;
//        }

public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
        file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
        try {
        book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
        for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
        data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
        // System.out.println(data[i][k]);
        }
        }
        return data;
        }