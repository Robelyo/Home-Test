# Home-Test
Student Record Management System (Java)
This is a console-based Java application for managing student records using file handling and object-oriented programming concepts. It supports storing data in text files, binary files, and object serialization.
The system allows users to add, view, modify, and remove student records. It also generates a report showing total students, average GPA, highest GPA, and lowest GPA.
The application automatically creates required files and folders using the File class and displays file information such as name, path, size, and last modified date. A backup feature is included using buffered streams to copy the object file.
The project uses the following classes:


student: represents student data and implements Serializable


main: handles the menu-driven interface


file: manages file creation and file information display


systemservice: contains core operations for managing student records and file handling logic


reportgenerator: calculates and displays GPA statistics


backuprecord: creates a backup of student records using buffered streams


To run the program, compile all Java files and execute the main class:
javac *.java
java main
The system demonstrates Java file handling, serialization, collections, exception handling, and basic data management operations.