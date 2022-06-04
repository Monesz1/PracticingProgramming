package com.freesoft.testautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
TODO
-check if Initial Menu is available on the testcase not just on the begining
-count all programs, even in the popup ones
 */
/**
 *
 * @author Attila Molnar
 */
public class TestRegisterWriter {

    //This is the path where the program needs to be run
    private String ROOT_DIR = "c:\\TESTING\\D1";
    private String FILE_NAME = "TestcaseRegAutoNew.xlsx";
    private XSSFWorkbook workbook = new XSSFWorkbook();

    private ArrayList<String> sheetNames, testingColumnNames, testcaseFileNames, sections, list;
    private ArrayList<File> testcases;
    private StringBuilder messageLineErrors = new StringBuilder();
    //private Set<String> programNamesTC, programNamesAll, mapNamesTC, mapNamesAll, users, others, nats, ;

    private Set<String> programNames = new HashSet<>();
    private Set<String> programNamesAll = new HashSet<>();
    private Set<String> users = new HashSet<>();
    private Set<String> others = new HashSet<>();
    private Set<String> nats = new HashSet<>();
    private Set<String> mapNames = new HashSet<>();
    private Set<String> mapNamesAll = new HashSet<>();
    private String testcaseValidity;
    private int stepCounter, f2counter, screenCounter;
    private File rootDir;
    private final static Logger LOGGER = Logger.getLogger(TestRegisterWriter.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        TestRegisterWriter test = new TestRegisterWriter();
//        test.readExcelFile();
        test.getData();
        test.addSheetNames();
        test.addTestingColumns();
        test.createSheets();
//        test.checkProgs();
        test.writeExcelFile();

    }

    //reading file tree and collecting into a list files and their path
    private void getData() {
        LOGGER.log(Level.INFO, "getData method called");
        LOGGER.log(Level.INFO, "ROOT_DIR= {0}", ROOT_DIR);
        rootDir = new File(ROOT_DIR);
        if (rootDir.exists()) {
            //Itarate over contents of the root directory of the testcases
            File[] folderList = rootDir.listFiles();

            if (folderList.length == 0) {
                LOGGER.log(Level.INFO, "Root Directory has no files", rootDir.getAbsolutePath());
            } else {
                for (File folder : folderList) {
                    LOGGER.log(Level.INFO, "Folder path:  {0}", folder.getAbsolutePath());
                    if (folder.isDirectory()) {
                        String folderName = folder.getName();
                        File[] fileList = folder.listFiles();
                        if (fileList.length == 0) {
                            LOGGER.log(Level.INFO, "Folder:  {0}", folderName + " is empty");
                            continue;
                        } else {
                            LOGGER.log(Level.INFO, "Folder name:  {0}", folderName);
                            //read files from folder
                            addFilesToList(fileList, folderName);
                        }
//                        File[] files = folder.listFiles();
//                        for (File file : files) {
//                            System.out.println("File path: " + file.getAbsolutePath());
//                            if (file.isFile()) {
//                                String testcaseFileName = file.getName();
//                                System.out.println("File name: " + testcaseFileName);
//                                sections.add(folderName);
//                                testcaseFileNames.add(testcaseFileName);
//                                testcases.add(file);
//                            } else {
//                                LOGGER.log(Level.INFO, "Folder path:  {0}", folder.getAbsolutePath());
//                                System.out.println("Unidentified file: " + file.getName());
//                            }
//                        }
                    } else {
                        System.out.println("Unidentified directory: " + folder.getName());
                    }
                }
            }

        } else {
            LOGGER.log(Level.INFO, "Root dir not exists. Please check the root directory configured", rootDir.getAbsolutePath());
        }
    }

    private void addFilesToList(File[] files, String section) {
        sections = new ArrayList<>();
        testcaseFileNames = new ArrayList<>();
        testcases = new ArrayList<>();
        for (File file : files) {
            System.out.println("File path: " + file.getAbsolutePath());
            if (file.isFile()) {
                String testcaseFileName = file.getName();
                System.out.println("File name: " + testcaseFileName);
                sections.add(section);
                testcaseFileNames.add(testcaseFileName);
                testcases.add(file);
            } else {
                LOGGER.log(Level.INFO, "Folder path:  {0}", folder.getAbsolutePath());
                System.out.println("Unidentified file: " + file.getName());
            }
        }
    }

    //adding column names for the Testing worksheet table
    private void addTestingColumns() {
        testingColumnNames = new ArrayList<>();
        testingColumnNames.add("NR");
        testingColumnNames.add("SECTION");
        testingColumnNames.add("RECORDING ID");
        testingColumnNames.add("TESTCASE NAME");
        testingColumnNames.add("TESTCASE TYPE");
        testingColumnNames.add("TESTCASE COMPLEXITY");
        testingColumnNames.add("TESTCASE ISVALID");
        testingColumnNames.add("NUMBER OF MAP");
        testingColumnNames.add("NUMBER OF PROGRAMS");
        testingColumnNames.add("NUMBER OF SCREEN");
        testingColumnNames.add("ERRORS");
        testingColumnNames.add("ALL MESSAGES");
        testingColumnNames.add("NUMBER OF STEPS MADE");
        testingColumnNames.add("TOTAL NUMBER OF STEPS");
        testingColumnNames.add("NOTE");
        testingColumnNames.add("TESTER");
        testingColumnNames.add("TESTING DATE JAVA");
        testingColumnNames.add("TESTING DATE NATURAL");
        testingColumnNames.add("TESTING DEPENDENCY");
        testingColumnNames.add("BARCODE");
        testingColumnNames.add("JCL");
        testingColumnNames.add("INITIAL MAP ON START");
        testingColumnNames.add("MANTIS");
    }

    //adding sheet names to the sheet names list list
    private void addSheetNames() {
        System.out.println("ADDING SHEET NAMES TO THE LIST");
        sheetNames = new ArrayList<>();
        sheetNames.add("Testing_Worksheet");
        sheetNames.add("Maps_Worksheet");
        sheetNames.add("Programs_Worksheet");
        sheetNames.add("Users_Worksheet");
        sheetNames.add("Nats_Worksheet");
        sheetNames.add("Others_Worksheet");
    }

    //creating sheets
    private void createSheets() {
        System.out.println("CREATE SHEET ON THE EXCEL WORKBOOK");
        for (String sheetName : sheetNames) {
            switch (sheetName) {
                case "Testing_Worksheet":
                    creatingTestingWorksheet(workbook.createSheet(sheetName));
                    break;
                case "Maps_Worksheet":
                    creatingMapsWorksheet(workbook.createSheet(sheetName));
                    break;
                case "Programs_Worksheet":
                    creatingProgramsWorksheet(workbook.createSheet(sheetName));
                    break;
                case "Users_Worksheet":
                    creatingUsersWorksheet(workbook.createSheet(sheetName));
                    break;
                case "Nats_Worksheet":
                    creatingNatsWorksheet(workbook.createSheet(sheetName));
                    break;
                case "Others_Worksheet":
                    creatingOthersWorksheet(workbook.createSheet(sheetName));
                    break;
                default:
                    System.out.println("Implementation method for " + sheetName + " does not exists. Please check!");
            }
        }
    }

    private void writeExcelFile() {
        System.out.println("CREATE FILE");
        // Try block to check for exceptions
        try {

            // Writing the workbook
            FileOutputStream out = new FileOutputStream(
                    new File(ROOT_DIR, FILE_NAME));
            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of
            // program
            System.out.println(
                    FILE_NAME + " written successfully on disk.");
        } // Catch block to handle exceptions
        catch (Exception e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }

    private void creatingTestingWorksheet(XSSFSheet testingSheet) {
        System.out.println("CREATING TESTING WORKSHEET");

        int rownum = 0;
        int cellnum = 0;
        Row row = testingSheet.createRow(rownum++);
        Cell cell;
        for (String tableColumnName : testingColumnNames) {
            cell = row.createCell(cellnum++);
            cell.setCellValue(tableColumnName);
        }
        ArrayList<Object[]> rows = collectDataForTesting();
        for (Object[] rowData : rows) {
            row = testingSheet.createRow(rownum++);
            cellnum = 0;
            for (Object data : rowData) {
                cell = row.createCell(cellnum++);
                if (data instanceof String) {
                    cell.setCellValue((String) data);
                } else if (data instanceof Integer) {
                    cell.setCellValue((Integer) data);
                }
            }
        }
    }

    //colect data for each column
    private ArrayList<Object[]> collectDataForTesting() {
        ArrayList<Object[]> data = new ArrayList<>();
        int testcaseNumer = 0;
        String sectionName = "";
        String recordingId = "";
        String testcaseFileName = "";
        testcaseValidity = "VALID";
        String errorMessages = "";
        String allMessages = "";
        String batchonline = "";
        String basicComp = "";
        String testcaseIsValid = "";
        int numberOfMaps = 0;
        int numberOfPrograms = 0;
        int numberOfScreens = 0;
        String stepsMade = "";
        int totalNumberSteps = 0;
        String note = "";
        String tester = "AUTOMATED";
        String testingDateJava = "";
        String testingDatenatural = "";
        String testingDependency = "";
        String barcode = "";
        String jcl = "";

        for (int i = 0; i < testcaseFileNames.size(); i++) {
            readTestcase(testcases.get(i));
            testcaseNumer = i + 1;
            sectionName = sections.get(i);
            recordingId = rootDir.getName();
            testcaseFileName = testcaseFileNames.get(i);
            errorMessages = messageLineErrors.toString();
            messageLineErrors.setLength(0);
            numberOfMaps = mapNames.size();
            numberOfPrograms = programNames.size();
            numberOfScreens = screenCounter;
            totalNumberSteps = stepCounter;

            if (f2counter > (totalNumberSteps / 2)) {
                testcaseValidity = "Invalid: PF2";
            }

            if (numberOfScreens <= 1) {
                testcaseIsValid = "FALSE";
            } else if (numberOfScreens == 3) {
                testcaseIsValid = "?TOCHECK?";
            }

            data.add(new Object[]{testcaseNumer, sectionName, recordingId,
                testcaseFileName, batchonline, basicComp, testcaseIsValid, numberOfMaps, numberOfPrograms, numberOfScreens, errorMessages, allMessages, stepsMade, totalNumberSteps,
                note, tester, testingDateJava, testingDatenatural, testingDependency,
                barcode, jcl, testcaseValidity});
        }

        return data;
    }

    //reading testcases line by line
    private void readTestcase(File testcase) {
        stepCounter = 0;
        f2counter = 0;
        screenCounter = 0;
        int initialTopBottom = 0;
        programNames.clear();
        mapNames.clear();
        int currentLine = 0;
        int lineCounter = 0;
        try {
            Scanner scanner = new Scanner(testcase);
            while (scanner.hasNextLine()) {
                //READING FILE LINE BY LINE
                lineCounter++;
                String line = scanner.nextLine();
                collectMapsAndPrograms(line);

                if (line.contains("@SCREEN:24")) {
                    screenCounter++;
                }
                Pattern p = Pattern.compile(" [E]{1}[0-9]{4} :");
                if (p.matcher(line).find()) {
                    messageLineErrors.append(line.trim());
                    messageLineErrors.append(";");
                }
//                if (line.contains("Deeds Registration System") && line.contains("Mode: ")) {
//                    if (line.contains("|")) {
//                        line = line.replace('|', ' ');
//                        line = line.trim();
//                    } else {
//                        line = line.trim();
//                    }
//                    String[] words = line.split(" ");
//                    programName = words[0];
//                    mapName = words[words.length - 1];
//                    programNames.add(programName);
//                    mapNames.add(mapName);
//                    p = Pattern.compile("[A-Z0-9]*");
//                    if (mapName.length() < 4 || !p.matcher(mapName).find()) {
//                        System.out.println("MAP ERROR: " + testcase.getName() + " On line: " + lineCounter);
//                        mapNamesAll.add("ERROR");
//                    } else {
//                        mapNamesAll.add(mapName);
//                    }
//                    if (programName.length() < 4 || !p.matcher(programName).find()) {
//                        System.out.println("PROGRAM ERROR: " + testcase.getName() + " On line: " + lineCounter);
//                        programNamesAll.add("ERROR");
//                    } else {
//                        programNamesAll.add(programName);
//                    }
//                }
                p = Pattern.compile(" [+][-]+[+] ");
                if (p.matcher(line).find() && screenCounter <= 2) {
                    initialTopBottom++;
                }
                //If map contains inline map
//                p = Pattern.compile(" [*]{5} [A-Za-z]+");
//                if (p.matcher(line).find()) {
//                    if (line.contains("|")) {
//                        line = line.replace('|', ' ');
//                        line = line.trim();
//                    } else {
//                        line = line.trim();
//                    }
//                    String[] lintParts = line.split("\\*\\*\\*\\*\\*");
//                    String left = lintParts[0];
//                    String[] l = left.trim().split(" ");
//                    String right = lintParts[lintParts.length - 1];
//                    programName = l[l.length - 1];
//                    p = Pattern.compile("[A-Z0-9]*");
//                    if (programName.length() < 4 || !p.matcher(programName).find()) {
//                        programNamesAll.add("ERROR");
//                        System.out.println("PROGRAM ERROR: " + testcase.getName() + " On line: " + lineCounter);
//                    } else {
//                        programNames.add(programName);
//                        programNamesAll.add(programName);
//                    }
//                    mapName = right.trim().split(" ")[0];
//                    if (mapName.length() < 4 || !p.matcher(mapName).find()) {
//                        mapNamesAll.add("ERROR");
//                        System.out.println("MAP ERROR: " + testcase.getName() + " On line: " + lineCounter);
//                    } else {
//                        mapNames.add(mapName);
//                        mapNamesAll.add(mapName);
//                    }
//
//                }
                if (screenCounter == 2 && initialTopBottom == 4) {
                    testcaseValidity = "HAS INITIAL MENU ON START";
                }

                if (line.contains("@KEY:")) {
                    currentLine = lineCounter;
                    stepCounter++;
                }
                if ((currentLine + 1) == lineCounter) {
                    if (line.contains("PF2")) {
                        f2counter++;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("READ TESTCASE: " + testcase.getName() + "\n" + "TOTAL NUMBER LINES: " + lineCounter);
    }

    //creating maps worksheet
    private void creatingMapsWorksheet(XSSFSheet mapsSheet) {
        System.out.println("CREATING TESTING WORKSHEET");
        //add header
        Row row = mapsSheet.createRow(0);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("MAP");
        cell = row.createCell(1);
        cell.setCellValue("MAP QUANTITY: " + mapNamesAll.size());

        int rownum = 1;
        int cellnum = 0;

        row = mapsSheet.createRow(rownum++);
        for (String mapName : mapNamesAll) {
            if (cellnum == 20) {
                row = mapsSheet.createRow(rownum++);
                cellnum = 0;
            }
            cell = row.createCell(cellnum++);
            cell.setCellValue((String) mapName);

        }
    }

    //creating users worksheet
    private void creatingUsersWorksheet(XSSFSheet mapsSheet) {
        System.out.println("CREATING USERS WORKSHEET");
        //add header
        Row row = mapsSheet.createRow(0);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("USERS");
        cell = row.createCell(1);
        cell.setCellValue("USER QUANTITY: " + users.size());

        int rownum = 1;
        int cellnum = 0;

        row = mapsSheet.createRow(rownum++);
        for (String user : users) {
            if (cellnum == 20) {
                row = mapsSheet.createRow(rownum++);
                cellnum = 0;
            }
            cell = row.createCell(cellnum++);
            cell.setCellValue((String) user);

        }
    }

    //creating programs worksheet
    private void creatingProgramsWorksheet(XSSFSheet mapsSheet) {
        System.out.println("CREATING PROGRAMS WORKSHEET");

        //add header
        Row row = mapsSheet.createRow(0);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("PROGRAMS");
        cell = row.createCell(1);
        cell.setCellValue("PROGRAMS QUANTITY: " + programNamesAll.size());

        int rownum = 1;
        int cellnum = 0;

        row = mapsSheet.createRow(rownum++);
        for (String programName : programNamesAll) {
            if (cellnum == 20) {
                row = mapsSheet.createRow(rownum++);
                cellnum = 0;
            }
            cell = row.createCell(cellnum++);
            cell.setCellValue((String) programName);

        }
    }

    private void creatingOthersWorksheet(XSSFSheet mapsSheet) {
        System.out.println("CREATING OTHERS WORKSHEET");

        //add header
        Row row = mapsSheet.createRow(0);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("OTHERS");

        int rownum = 1;
        int cellnum = 0;

        row = mapsSheet.createRow(rownum++);
        for (String programName : others) {
            if (cellnum == 20) {
                row = mapsSheet.createRow(rownum++);
                cellnum = 0;
            }
            cell = row.createCell(cellnum++);
            cell.setCellValue((String) programName);

        }
    }

    private void creatingNatsWorksheet(XSSFSheet mapsSheet) {
        System.out.println("CREATING NATS WORKSHEET");

        //add header
        Row row = mapsSheet.createRow(0);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("NATS");

        int rownum = 1;
        int cellnum = 0;

        row = mapsSheet.createRow(rownum++);
        for (String nat : nats) {
            if (cellnum == 20) {
                row = mapsSheet.createRow(rownum++);
                cellnum = 0;
            }
            cell = row.createCell(cellnum++);
            cell.setCellValue((String) nat);

        }
    }

    private void readExcelFile() throws IOException {
        list = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File("c:\\TESTING\\test\\b\\listOfMaps.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    list.add(cell.getStringCellValue());
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    private void checkProgs() {
        ArrayList<String> progs = new ArrayList<>();
        for (String string : list) {
            if (!programNamesAll.contains(string)) {
                progs.add(string);
            }
        }
        System.out.println(progs.toString());
    }

    private static int windowLine = 4;

    private boolean checkForInitialMenu(int screenNumber, String line) {
        boolean hasInitialMenu = false;
        //check until the second screen
        if (screenNumber < 2) {
            //check is the line contains +--+ with regex
            Pattern p = Pattern.compile(" [+][-]{20,}[+] ");
            if (p.matcher(line).find()) {
                windowLine--;
            }
        }
        //if the widoww line, which represents "+---+" line counter reahcing 0, means that is has initial menu on the tsrt of the testcase
        if (windowLine == 0) {
            hasInitialMenu = true;
        }
        return hasInitialMenu;
    }

    private String getProgramName(int lineNum, String line) {
        if (lineNum == 2) {
            if (line.contains("|")) {
                line = line.replace('|', ' ');
                line = line.trim();
            } else {
                line = line.trim();
            }
            String[] lineParts = line.split(" ");
            String programName = lineParts[0];
            return programName;
        }
        return line;
    }

    //what other method we can use to check if we are righ and the program collected all program names?
    //We can iterate through the name of programs what we get as souce files to analyze, parse etc.
    //
    //Pseudo for window
    //Check if the line contains @SCREEN
    //if contains, skip one line
    //After line is skipped check if it contains +--+
    //if not
    //X {(method) check if line contains |
    //if contains remove them
    //trim the line}
    //After line is trimmed get the first element and the last element
    //if next line contains +--+ skipp the next line
    //After next line is skipped go to X
    //
    private void collectMapsAndPrograms(String line) {
        Pattern p = Pattern.compile("[A-Z]{3}[0-9]{3}|[A-Z]{3}[0-9]{3}\\w{2}|\\s[A-Z]{2}[0-9]{3}[A-Z][0-9]{2}");//(\\s[A-Z]{3}[0-9]{3}([A-Z]|[0-9]|\\s){3})|(\\s[A-Z]{2}[0-9]{3}[A-Z][0-9]{2}\\s)
        String[] words = line.split(" ");
        for (String word : words) {
            word = word.trim();
            if (p.matcher(word).find() && !word.startsWith("@") && !word.endsWith("_") && !word.contains("/") && !word.contains("-") && !word.contains(")")) {
                if (word.length() == 8 && word.charAt(6) == 'M') {
                    mapNamesAll.add(word);
                } else if (word.endsWith("OD") || (word.length() > 6 && word.length() < 9 && Character.isLetter(word.charAt(6))) || word.endsWith("0D")) {
                    programNamesAll.add(word);
                } else if (word.length() > 4 && word.length() < 9 && (word.startsWith("DRS") || word.startsWith("DOT"))) {
                    users.add(word);
                } else if (word.length() > 4 && word.length() < 9 && word.startsWith("NAT")) {
                    nats.add(word);
                } else {
                    others.add(word);
                }
            }
        }
    }
}
