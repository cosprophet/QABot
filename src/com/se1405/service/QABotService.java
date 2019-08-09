package com.se1405.service;

import com.se1405.beans.Turn;
import com.se1405.beans.User;
import com.se1405.components.NLG;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/QABotService")
public class QABotService {

	@GET
	@Produces("text/plain")
	public String getResponse(@QueryParam("utterance") String utterance, @QueryParam("client") String client) {
		NLG nlg = new NLG();
		String response;
		User user = new User(client.hashCode());
		Turn turn;
		turn = new Turn(user, utterance);
		response = nlg.nlg(turn);
		return response;
	}

}
