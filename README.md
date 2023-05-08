# SPORTRADAR-DEMO (Spring Rest API implementation)

## Table of contents
* [General info](#general-info)
* [Setup](#setup)
* [Known issues](#known-issues)
* [Example test scenario](#example-test-scenario)
* [Some screenshots](#some-screenshots)



## General info
This project is simple API implementation to show basic Football Scoreboard functionalaties such as :
* Staring a Game
* Updating a Game with new scores
* Finishing the game
* Retrieving the summary of scores which are in progress (List scores of games which are Not Finished yet)
* Project is created with Java Spring Boot Api
* NOTE: Date-Time values are used as "Unix Time Stamp" to make sorting easy.
	
## Setup
1. Clone git repository 
2. Run Java application in your IDE
3. Open a borwser or Postman to browse the page at "http://localhost:8080"
4. Enter Paramaters as Query String values on a Browser (Or on a Postman like tool)

```
$ git clone https://github.com/mastermeric/SPORTRADAR-DEMO.git
```


## Known Issues
- [x] Multi-threaded usage need to be maintained. (Static memory lists are open to risks in concurrency)
- [x] A database will be betetr solution instead of in-memory collection (To do maintainable Sorting/Filtering etc)


## Example Test Scenario 
* Step-1 : Start some games :
- [x] http://localhost:8080/api/startNewGame/Germany/Spain
- [x] http://localhost:8080/api/startNewGame/Brasil/Italy
- [x] http://localhost:8080/api/startNewGame/France/Portugal
- [x] http://localhost:8080/api/startNewGame/Norway/Denmark
- [x] http://localhost:8080/api/startNewGame/Turkey/Holland
- [x] http://localhost:8080/api/startNewGame/Uruguay/Japan
- [x] http://localhost:8080/api/startNewGame/Mexico/India
- [x] http://localhost:8080/api/startNewGame/Canada/Argentina


* Step-2 : Update the games :
- [x] http://localhost:8080/api/updateScore/Mexico/India/1/0
- [x] http://localhost:8080/api/updateScore/Norway/Denmark/2/0
- [x] http://localhost:8080/api/updateScore/Canada/Argentina/3/0
- [x] http://localhost:8080/api/updateScore/France/Portugal/4/0
- [x] http://localhost:8080/api/updateScore/Germany/Spain/4/4
- [x] http://localhost:8080/api/updateScore/Brasil/Italy/8/0
- [x] http://localhost:8080/api/updateScore/Turkey/Holland/2/6
- [x] http://localhost:8080/api/updateScore/Uruguay/Japan/7/1

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


* Get the Scoreboard :

![image](https://user-images.githubusercontent.com/49819371/236709099-345d4834-6108-496c-910f-018baaeb58f8.png)


