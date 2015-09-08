# carDealership
Car dealership Project in Java


CS4354 — Fall 2015 — Assignment 1 Due date: Thursday, Sept. 10, 2015 at 11:55 pm. 

Project Title: Car dealership 

Goal: The goal of this assignment is to help students familiarize themselves with the following Java programming concepts 
1. Storing data in a file and reading data from a file. 
2. Creating object-oriented classes and methods to handle data. 
3.Using data structures to store data in main memory (e.g. ArrayList). 
4. Working with character strings. 
5.Using Javadoc comments and generating and html API of the program.

Description: For this assignment you will create a program that simulates a car dealership database. The database will maintain records of cars that are on sale. Your program should provide the user (dealer) with a command line choice menu about possible actions that they can perform. The choices should be the following: 

1. Show all existing car records in the database (in any order). 
2. Add a new car record to the database. 
3. Delete a car record from a database. 
4. Search for a car (given its VIN). 
5. Show a list of cars within a given price range. 
6. Exit program. 

To represent a car in your program, create a class named Car with the following fields: 
• VIN (string of length 5) 
• make (string) 
• model (string) 
• year (integer number) 
• mileage (integer number) 
• price (floating point number) 

When the program first loads, it reads all the saved records (if any) from a file named cars . txt into an ArrayList. While the program is running, the user can choose any of the 6 available options, including adding or deleting car records. When the user selects the option 6 (exit program), the program stores the current contents of the ArrayList to the file (replacing the old ones) and exits. During the program execution, if the user choses to add or delete a car, only the ArrayList will be updated. The file will be updated only when the program is about to exit. 
The format of the contents of the cars . txt file should be in human readable plain text, one record per line. 

For example: 
632VR Toyota Camry 2005 65650 6000.00 
H43SM Chevrolet Corvette 2001 98020 14999.99 
83RS9 Honda Civic 1997 135600 2200.00 
