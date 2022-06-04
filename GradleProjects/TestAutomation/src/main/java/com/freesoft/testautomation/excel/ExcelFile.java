/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freesoft.testautomation.excel;

/**
 *
 * @author Attila Molnar
 */
public class ExcelFile {

    private String name;
    private ExcelFileFormat testType;
    private String workingDir;
    private String error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExcelFileFormat getTestType() {
        return testType;
    }

    public void setTestType(ExcelFileFormat testType) {
        this.testType = testType;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
