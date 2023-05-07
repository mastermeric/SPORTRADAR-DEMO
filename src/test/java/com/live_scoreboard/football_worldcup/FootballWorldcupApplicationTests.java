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

	// //TEST-0 : Server Module is Loaded Or Not.
	// @Test
	// void contextLoads() throws Exception {
	// }


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
		
		//Failed URL to see 404 Not Found error ..
		String wrongRequest ="/api/nonExistingEndpoint_DummyUrl"; 

		mockMvc.perform(get(wrongRequest))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-3 : Start Game  => To see if Game can be started successfully.
	@Test
	void should_Success_When_Game_Is_Started() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_StartNewGame))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-4 : Finish Game  => To see if Game can be finished successfully.
	@Test
	void should_Success_When_Game_Is_Finished() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_FinishGame))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}

	//TEST-5 : Get Summary  => To see Scoreboard results successfully retrieved.
	@Test
	void should_Success_When_Scoreboard_Results_Retrieved() throws Exception {		
		mockMvc.perform(get(GlobalFootballVariables.EndPoint_GetSummary))			
			.andExpect(status().isOk()) //Continue if we have 200 OK (successfull).
			.andExpect(content().string(GlobalFootballVariables.SuccessServerMessage));  // Modify This string To see Expected/Unexpected result comes.
	}
}
