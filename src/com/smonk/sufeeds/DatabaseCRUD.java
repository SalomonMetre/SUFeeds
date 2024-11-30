/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smonk.sufeeds;

import java.sql.ResultSet;

public interface DatabaseCRUD {
    void create(String table, String columns, String values);
    ResultSet read(String table, String condition);
    void update(String table, String updates, String condition);
    void delete(String table, String condition);
    void closeConnection();
}

