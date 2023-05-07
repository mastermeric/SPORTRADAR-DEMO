package com.live_scoreboard.football_worldcup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class FootballWorldcupApplicationTests {

	@Autowired
	MockMvc mockMvc;

	//=================   SERVER BASED TESTS  ======================
	//TEST-1 : Simple Server Healthcheck is OK.
	@Test
	void should_Success_When_Server_Communication_Is_OK() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_HealthCheck))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-2 : Simple Endpoint control for 404 Not  Found cases.
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
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_StartNewGame))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-4 : Update Game 
	@Test
	void should_Success_When_Score_Is_Updated() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_UpdateScore))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-5 : Finish Game 
	@Test
	void should_Success_When_Game_Is_Finished() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_FinishGame))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-6 : Get Summary of scores for the games that are in-progess
	@Test
	void should_Success_When_Scoreboard_Results_Retrieved() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_GetSummary))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}
	//=============================================================
}
