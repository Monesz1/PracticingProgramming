/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freesoft.testautomation.excel;

import java.util.ArrayList;

/**
 *
 * @author Attila Molnar
 */
public interface Table {

    ArrayList<Column> getColumns();

    ArrayList<Row> getRows();
}
