package it.polimi.diceH2020.s4c.plugin.other;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import it.polimi.diceH2020.SPACE4Cloud.shared.InstanceData;

public class RestInteractor {
	private static String output;
	
	private static boolean initialized = false;
	
	
	public static boolean askRemoteState(URL endpoint) {
		try {
			if(!initialized){
				initialize();
			}

			HttpResponse<String> state = Unirest.get(endpoint.toString()).asString();

			System.out.println(state.getBody());
			return true;

		} catch (UnirestException e) {
			System.out.println("Backend service not connected");
			return false;
		}
	}

	private static void initialize() {
		Unirest.setObjectMapper(new ObjectMapper() {
		    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
		                = new com.fasterxml.jackson.databind.ObjectMapper();

		    public <T> T readValue(String value, Class<T> valueType) {
		        try {
		            return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
		    }

		    public String writeValue(Object value) {
		        try {
		            return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException(e);
		        }
		    }
		});
		initialized = true;
	}

	public static boolean postData(String inputDataJson, URL endpoint){
		try {
			if(!initialized){
				initialize();
			}
			
			HttpResponse<String> state = Unirest.post(endpoint.toString()).header("Content-Type", "application/json").body(inputDataJson).asString();
			System.out.println(state.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static String getOutput() {
		System.out.println(output);
		return output;
	}

}
