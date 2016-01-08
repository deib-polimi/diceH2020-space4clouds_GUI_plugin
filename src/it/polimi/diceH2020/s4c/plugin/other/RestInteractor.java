package it.polimi.diceH2020.s4c.plugin.other;

import java.net.URL;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class RestInteractor{    
	private static String output;

	//TODO this part must be re-implemented using unirest and jackson
	public static boolean askRemoteState(URL endpoint) {
		try {
			
		   HttpResponse<String> state = Unirest.get(endpoint.toString()).asString();
			
			System.out.println(state.getBody());
			
			return true;
			
//			HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
//			conn.setRequestMethod("GET");
//
//			if (conn.getResponseCode() != 200) throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//
//			// bReader is a reader associated with the answer of the Web Service
//			BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//			System.out.println("Output from Server .... \n");
//			output = bReader.readLine(); // saving the output
//			System.out.println(output);
//			
//			File askStateFile = new File("askstate.json");
//			if (!askStateFile.exists()) askStateFile.createNewFile();
//
//			JsonToJava.toString(output, askStateFile);
//			
//			//todo: questa cosa non va. e' molto strana. Non restituisce nulla
//			JsonToJava.toObject(askStateFile, State.class) ;
//			System.out.println(output);
//			conn.disconnect();

		} catch (UnirestException e) {
			System.out.println("Backend service not connected");
			return false;
		}




	}

	public static String getOutput() {
		System.out.println(output);
		return output;
	}

}


