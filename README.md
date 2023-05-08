# SPORTRADAR-DEMO (Spring Rest API implementation)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Known Issues](#Known-Issues)
* [Example Test Scenario](#ExampleTestScenario)
* [Some screenshots](#SomeScreenshots)



## General info
This project is simple API implementation to show basic Football Scoreboard functionalaties such as :
* Staring a Game
* Updating a Game with new scores
* Finishing the game
* Retrieving the summary of scores which are in progress (List scores of games which are Not Finished yet)

	
## Technologies
Project is created with:
* JAva Spring Boot Api
* JUnit for TESTs
* Date-Time parameters selected as "Unix Time Stamp" for better flexiblity and easy sorting operations.
	
## Setup
1. Clone git repository 
2. Run Java application in your IDE
3. Open a borwser or Postman to browse the page at "http://localhost:8080"
4. Enter Paramaters as Query String values on a Browser (Or on a Postman like tool)

```
$ git clone https://github.com/mastermeric/SPORTRADAR-DEMO.git
```


## Known Issues :
- [x] Multi-threaded usage need to be maintained. (Static memory lists are open to risks in concurrency)
- [x] A database will be betetr solution instead of in-memory collection (To do maintainable Sorting/Filtering etc)


## Example Test Scenario 
* Step-1 : Start some games :
- [x] http://localhost:8080/api/startNewGame/Germany/Spain
- [x] http://localhost:8080/api/startNewGame/France/Portugal
- [x] http://localhost:8080/api/startNewGame/Norway/Denmark

* Step-2 : Update games :
- [x] http://localhost:8080/api/updateScore/Germany/Spain/5/3
- [x] http://localhost:8080/api/updateScore/France/Portugal/1/1
- [x] http://localhost:8080/api/updateScore/France/Portugal/2/3
- [x] http://localhost:8080/api/updateScore/Norway/Denmark/2/1
- [x] http://localhost:8080/api/updateScore/Norway/Denmark/3/1
- [x] http://localhost:8080/api/updateScore/Norway/Denmark/4/1


* Step-3 : Finish some games :
- [x] http://localhost:8080/api/finishGame/Germany/Spain
- [x] http://localhost:8080/api/finishGame/France/Portugal

* Step-4 : Get results :
- [x] http://localhost:8080/api/getSummary


## Some screenshots
* Start a game :

![image](https://user-images.githubusercontent.com/49819371/236708905-d96df803-67b7-4f63-a7cc-e17c71dabd03.png)

* Update the game :

![image](https://user-images.githubusercontent.com/49819371/236708955-049e4d82-3279-4b0f-8396-0ddaa41d16bc.png)

* Finish a game :

![image](https://user-images.githubusercontent.com/49819371/236709010-181a867d-5fb3-4efe-a4f5-f5ba4c67b003.png)


* Get teh Scoreboard :

![image](https://user-images.githubusercontent.com/49819371/236709099-345d4834-6108-496c-910f-018baaeb58f8.png)


