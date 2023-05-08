package com.live_scoreboard.football_worldcup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.live_scoreboard.football_worldcup.controller.FootballController;
import com.live_scoreboard.football_worldcup.service.FootballService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = FootballController.class)
class FootballWorldcupApplicationTests {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	FootballService footballService;


	//====================   SERVER TEST  ==========================
	//TEST-1 : Simple Server Healthcheck if Server is OK.
	@Test
	void should_Success_When_Server_Communication_Is_OK() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_HealthCheck))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}
	//==============================================================


	//TEST-2 : Endpoint control for 404 Not cases ==================
	@Test
	void should_Fail_With_Wrong_EndPoints() throws Exception {		
		
		//Dummy URL to see 404 Not Found error ..
		String wrongRequest ="/api/nonExistingEndpoint_DummyUrl"; 

		mockMvc.perform(get(wrongRequest))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}
	//=============================================================



	//=================   FUNCTIONAL TESTS  =======================

	//TEST-3 : Start Game 
	@Test
	void should_Success_When_Game_Is_Started() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_StartNewGame + "/Germany/Spain"))		
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessGameStarted));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-4 : Start a game and Update Game
	@Test
	void should_Success_When_Score_Is_Updated() throws Exception {

		mockMvc.perform(get(GlobalFootballVariables.EndPoint_StartNewGame + "/Germany/Spain"))		
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessGameStarted))
			.andDo(
				result -> mockMvc.perform(get(GlobalFootballVariables.EndPoint_UpdateScore + "/Germany/Spain/3/0"))
				.andExpect(status().isOk())
				.andExpect(content().string(GlobalFootballVariables.SuccessGameUpdated))
				);
	}

	//TEST-5 : Start a game and Finish it
	@Test
	void should_Success_When_Game_Is_Finished() throws Exception {	
		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_StartNewGame + "/Germany/Spain"))		
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessGameStarted))
			.andDo(
				result -> mockMvc.perform(get(GlobalFootballVariables.EndPoint_FinishGame + "/Germany/Spain"))
				.andExpect(status().isOk())
				.andExpect(content().string(GlobalFootballVariables.SuccessGameFinished))
				);
	}

	//TEST-6 : Get Summary of scores for the games that are in-progess
	@Test
	void should_Success_When_Scoreboard_Results_Retrieved() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_GetSummary))			
			.andExpect(status().isOk()); //Continue if we have 200 OK (successfull).			
	}	
	//=============================================================
}
