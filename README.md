# SPORTRADAR-DEMO (API implementation)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

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
1-) Clone git repository 
2-) Run Java application in your IDE
3-) Open a borwser or Postman to browse the page at "http://localhost:8080"

```
$ git clone https://github.com/mastermeric/SPORTRADAR-DEMO.git
```


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







