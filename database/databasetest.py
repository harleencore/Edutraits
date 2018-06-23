# -*- coding: utf-8 -*-
"""
Created on Sat Jun 23 15:39:18 2018

@author: Laptop
"""

from __future__ import print_function

import mysql.connector
from mysql.connector import errorcode

DB_NAME = 'tutor2'

TABLES = {}
TABLES['organisation'] = (
    "CREATE TABLE `organisation` ("
    "  `organisationid` int(8) NOT NULL AUTO_INCREMENT,"
    "  `organisationname` varchar(32) NOT NULL,"
    "  `region` enum('NORTH', 'NORTH-EAST', 'EAST', 'WEST', 'CENTRAL') NOT NULL,"
    "  PRIMARY KEY (`organisationid`), UNIQUE KEY `organisationname` (`organisationname`)"
    ") ENGINE=InnoDB")

TABLES['staff'] = (
    "CREATE TABLE `staff` ("
    "  `staffid` int(8) NOT NULL AUTO_INCREMENT,"
    "  `organisationid` int(8) NOT NULL,"
    "  `staffname` varchar(32) NOT NULL,"
    "  `basedregion` enum('NORTH', 'NORTH-EAST', 'EAST', 'WEST', 'CENTRAL') NOT NULL,"
    "  `primarysubject` varchar(16) NOT NULL,"
    "  `secondarysubjects` varchar(128),"
    "  `admin` enum('YES', 'NO') NOT NULL,"
    "  PRIMARY KEY (`staffid`), UNIQUE KEY `staffname` (`staffname`)"
    ") ENGINE=InnoDB")

TABLES['students'] = (
    "CREATE TABLE `students` ("
    "  `studentid` int(8) NOT NULL AUTO_INCREMENT,"
    "  `organisationid` int(8) NOT NULL,"
    "  `studentname` varchar(32) NOT NULL,"
    "  `dateofbirth` date NOT NULL,"
    "  `basedregion` enum('NORTH', 'NORTH-EAST', 'EAST', 'WEST', 'CENTRAL') NOT NULL,"
    "  PRIMARY KEY (`studentid`), UNIQUE KEY `studentname` (`studentname`)"
    ") ENGINE=InnoDB")

TABLES['subjects'] = (
    "CREATE TABLE `subjects` ("
    "  `subjectid` int(8) NOT NULL AUTO_INCREMENT,"
    "  `studentid` int(8) NOT NULL,"
    "  `subjectname` varchar(16) NOT NULL,"
    "  `currentgrade` int(3) NOT NULL,"
    "  `legacygrade1` int(3) NOT NULL,"
    "  `legacygrade2` int(3) NOT NULL,"
    "  `legacygrade3` int(3) NOT NULL,"
    "  `legacygrade4` int(3) NOT NULL,"
    "  `legacygrade5` int(3) NOT NULL,"
    "  PRIMARY KEY (`subjectid`), UNIQUE KEY `subjectname` (`subjectname`)"
    ") ENGINE=InnoDB")

TABLES['workhistory'] = (
    "CREATE TABLE `workhistory` ("
    "  `workid` int(16) NOT NULL AUTO_INCREMENT,"
    "  `studentid` int(8) NOT NULL,"
    "  `subjectid` int(8) NOT NULL,"
    "  `workname` varchar(32) NOT NULL,"
    "  `type` enum('video', 'text', 'structuredquestions', 'shortquestions', 'MCQ') NOT NULL,"
    "  `duration(minutes)` int(4) NOT NULL,"
    "  PRIMARY KEY (`workid`), UNIQUE KEY `workname` (`workname`)"
    ") ENGINE=InnoDB")

cnx = mysql.connector.connect(user='monoshuman',password='humanofmono',port=3306)
cursor = cnx.cursor()

def create_database(cursor):
    try:
        cursor.execute(
            "CREATE DATABASE {} DEFAULT CHARACTER SET 'uctf8'".format(DB_NAME))
    except mysql.connector.Error as err:
        print("Failed creating database: {}".format(err))
        exit(1)

try:
    create_database(cursor)
    cnx.database = DB_NAME  
except mysql.connector.Error as err:
    if err.errno == errorcode.ER_BAD_DB_ERROR:
        create_database(cursor)
        cnx.database = DB_NAME
    else:
        print(err)
        exit(1)
        
for name, ddl in TABLES.items():
    try:
        print("Creating table {}: ".format(name), end='')
        cursor.execute(ddl)
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_TABLE_EXISTS_ERROR:
            print("already exists.")
        else:
            print(err.msg)
    else:
        print("OK")

cursor.close()
cnx.close()