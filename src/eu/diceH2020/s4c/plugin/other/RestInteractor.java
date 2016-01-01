package eu.diceH2020.s4c.plugin.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RestInteractor{    
	private static String output;

	//TODO this part must be re-implemented using unirest and jackson
	public static void askWebServer(URL endpoint) {
		try {
			HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());

			// bReader is a reader associated with the answer of the Web Service
			BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			System.out.println("Output from Server .... \n");
			output = bReader.readLine(); // saving the output
			System.out.println(output);
			
			File askStateFile = new File("askstate.json");
			if (!askStateFile.exists()) askStateFile.createNewFile();

			JsonToJava.toString(output, askStateFile);
			
			//todo: questa cosa non va. e' molto strana. Non restituisce nulla
			JsonToJava.toObject(askStateFile, State.class) ;
			System.out.println(output);
			conn.disconnect();

		} catch (MalformedURLException   e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}




	}

	public static String getOutput() {
		System.out.println(output);
		return output;
	}

}


