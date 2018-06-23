# -*- coding: utf-8 -*-
"""
Created on Sun Jun 24 01:07:10 2018

@author: Mono's Human
"""
from __future__ import print_function
from datetime import date, datetime, timedelta
import mysql.connector

cnx = mysql.connector.connect(user='root', database='tutor2')
cursor = cnx.cursor()

add_organisation = ("INSERT INTO organisation "
                    "(organisationname, region) "
                    "VALUES (%s, %s)")

add_staff = ("INSERT INTO staff "
             "(staffname, basedregion, primarysubject, secondarysubjects, admin) "
             "VALUES (%s, %s, %s, %s, %s)")

add_students = ("INSERT INTO students "
                "(studentname, dateofbirth, basedregion) "
                "VALUES (%s, %s, %s)")

add_subjects = ("INSERT INTO subjects "
                "(studentid, subjectname, currentgrade, legacygrade1, legacygrade2, legacygrade3, legacygrade4, legacygrade5) "
                "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)")

add_workhistory = ("INSERT INTO workhistory "
                   "(studentid, subjectid, workname, type, duration "
                   "VALUES (%s, %s, %s, %s, %s)")

org = ('Goody2ShoesKindergarten','Central')
stafflist = [('Roxxane Lee','Central','Math','Sci/Eng','Yes'),('Edward Choo','Central','Chinese','None','No'),('Abdul Nazrin','East','Malay','None','No')]
studentlist = [('Miranda Aswell',date(2009,2,9),'Central'),('David Crocket',date(2010,1,1),'Central'),('James Anonymous',date(2009,5,23),'Central'),('Adrian Hill',date(2009,12,31),'North')]
subjectlist = [[('English',84,82,84,88,85,81),('Math',99,95,100,96,97,99),('Science',89,92,88,85,93,90)],[('English',55,78,45,44,66,70),('Math',32,31,40,42,43,41),('Science',55,50,51,59,55,56),('Malay',88,78,77,82,80,79)],[('English',67,70,71,69,74,72),('Math',68,72,70,71,72,74),('Science',88,90,80,75,73,77),('Chinese',12,14,10,8,20,19)],[('English',55,55,55,55,55,55),('Math',55,55,55,55,55,55),('Science',55,55,55,55,55,55),('Chinese',55,55,55,55,55,55)]]
workhistorylist = [[[('TYS2011','structuredquestions',90),('TYS2010','MCQ',30),('P4MidYear','shortquestions',50),('PeterRabbit','text',30)],[('Multiplication','MCQ',40),('MultiplicationTables','text',20),('FactorsNotes','text',20),('Factors','structuredquestions',40)],[('Classification','text',40),('SortingFungi','structuredquestions',30),('LifeCycleDocumentary','video',45)]],[[('TYS2011','structuredquestions',90),('TYS2010','MCQ',30),('P4MidYear','shortquestions',50),('PeterRabbit','text',30)],[('Multiplication','MCQ',40),('MultiplicationTables','text',20),('FactorsNotes','text',20),('Factors','structuredquestions',40)],[('Classification','text',40),('SortingFungi','structuredquestions',30),('LifeCycleDocumentary','video',45)],[('2011P2Final','structuredquestions',45),('ListeningComprehension','MCQ',25)]],[[('TYS2011','structuredquestions',90),('TYS2010','MCQ',30),('P4MidYear','shortquestions',50),('PeterRabbit','text',30)],[('Multiplication','MCQ',40),('MultiplicationTables','text',20),('FactorsNotes','text',20),('Factors','structuredquestions',40)],[('Classification','text',40),('SortingFungi','structuredquestions',30),('LifeCycleDocumentary','video',45)],[('Spelling','shortquestions',15),('VocabularyPractices','shortquestions',20)]],[[('TYS2011','structuredquestions',90),('TYS2010','MCQ',30),('P4MidYear','shortquestions',50),('PeterRabbit','text',30)],[('Multiplication','MCQ',40),('MultiplicationTables','text',20),('FactorsNotes','text',20),('Factors','structuredquestions',40)],[('Classification','text',40),('SortingFungi','structuredquestions',30),('LifeCycleDocumentary','video',45)],[('Spelling','shortquestions',15),('VocabularyPractices','shortquestions',20)]]]
for i in range(len(studentlist)):
    cursor.execute(add_students, studentlist[i])
    studentid = cursor.lastrowid
    for j in range(len(subjectlist[i])):
        subject_data = (studentid,) + subjectlist[i][j]
        cursor.execute(add_subjects, subject_data)
        subjectid = cursor.lastrowid
        for k in workhistorylist[i][j]:
            workhistory_data = (studentid,) + (subjectid,) + k
            cursor.execute(add_workhistory, workhistory_data)

cnx.commit()

cursor.close()
cnx.close()
