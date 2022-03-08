# Flight Monitoring System
We consider a fleet of planes from different airlines flying in the sky. The initial data about the flights is provided in a file. The objective of the applications is to track the position of the flights. The application also estimates the CO2 emission depending on the type of plane and distance travelled. We consider that a fixed amount of CO2 is emitted per litre of kerosene.

1. The application initially reads data from four files. Sample files are given for illustration, but you should add to these as necessary. The files are:
a. a list of airports. Each airport is described by a name (e.g. Heathrow), a code (e.g. LHR), a GPS position with latitude and longitude (e.g. in DMS format, 51° 28' 12.0720'' N and 0° 27' 15.4620'' W)1. Each airport has a control tower. We consider that control towers are located only at airports.
File format: code; name; Latitude; Longitude
b. a list of aviation companies, each with a name (e.g. British Airways), and a code (e.g. BA).
File format: code; name
c. a list of plane types, with name (e.g. Boing 777), the cruise speed in kilometres per hour, and the average fuel consumption in litres per 100 kilometre.
File format: model; manufacturer; speed; consumption
d. a list of flights; each flight has a unique identifier in the form of the code of the manufacturer followed by a serial number (e.g. BA664), the type of aeroplane (e.g. B777), departure airport and destination airport, departure date and time in CET, and a flight plan with the list of one or more control towers to be crossed.
File format: flight code; plane code; departure airport code; destination airport code; departure date dd:mm:yyyy; departure time hh:mm; tower 1; tower 2; ... tower n

2. When the application is running, the user should be provided with a simple GUI where they can add new flights (see Figure 2 for an example of what this might look like). When adding a flight, the user should be able to select an airline, add a unique code, select the type of airplane, and the departure and destination, enter the date and time of departure, and select a list of control towers to be crossed. The application should display the average distance and time travelled, the average fuel consumption in addition to the estimated CO2 emission. We consider a fixed speed and direct line between control towers. The appendix shows sample pseudo code on how to calculate the distance between two GPS locations.

3.Before the application exits, it should generate a report with the number of flights per company and the total number of kilometres travelled by its flights. The report should also include the average total fuel consumption, and the estimated CO2 emission. The report should be written to a text file.

When editing the flight plan, we consider that there is a maximum number of towers that can be crossed (for example, 20). The user can be given a table that they can fill in by selecting the successive towers from a drop-down list. You can add extra functionalities to your GUI, such as sorting flights by different criteria, searching a flight etc.

Non-functional requirements
These are the software engineering requirements for Stage 1:
1. Your application should be implemented using Java.
2. Develop your program using planned iterative development. In this stage you
should do all the design before writing the code. Decide on all the classes for this stage, their instance attributes, and methods. Try using a design method and diagrams where appropriate. Make a plan to divide the work between you, in such a way each person can work independently where possible. How will you test your code? Decide when and how often you need to meet or be in contact. How will you integrate your work?
3. Base all your decisions just on the requirements for this stage. Do not use agile development at this stage, and do not plan ahead to Stage 2. However, do take notes about the development process and your experiences, since you will be asked to summarise this in your report.
4. Your program should read the data from the files at the start and store it into appropriate data structures. When reading the files, you do not need to think ahead to the GUI or reports; just store the data so that it can be accessed easily (e.g. is a list suitable? would a map be useful?). Then, write methods to analyse the data, which is likely to involve using more data structures. When making your decisions, imagine that you have many flights, with variable number of control towers that can be crossed.
5. Use version control. Your group should set up a repository, and a link to this repository should be included in your report. Note that we will check the commit history, so make sure this reflects your individual contributions.
6. Use exceptions to catch errors in the data. Each group should decide what makes valid data (e.g., length, range, number of characters, etc.) If an error is found, just continue without that line of data. Provide suitable data to check that your program is working correctly, e.g. input files with some errors.
7. You should throw exceptions in the constructor of at least one class, to ensure that the objects of that class that you create are valid (e.g. flight unique identifier), and you should write at least one of your own exception classes.
8. Use JUnit to test some of your constructors and/or methods, particularly ones involving calculations, e.g. the method that estimates the CO2 emission from the travelled distance. You could try test-driven development for these methods. If you create a JUnit test for a method, you should test all the paths in the method, not just one.

