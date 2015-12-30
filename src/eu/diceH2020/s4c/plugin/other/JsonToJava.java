package eu.diceH2020.s4c.plugin.other;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonToJava {


	@Deprecated
	public static boolean checkMatching(File file, Class<?> classToConvert) throws IOException {

		String str = FileUtils.readFileToString(file);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

		try {

			// read from file, convert it to user class
			Object object =  mapper.readValue(str,classToConvert);

			// display to console
			System.out.println(object);
			System.out.println("l'objecto e:- " + object);


		} catch (JsonGenerationException d) {

			d.printStackTrace();

		} catch (JsonMappingException d) {

			d.printStackTrace();

		} catch (IOException d) {

			d.printStackTrace();

		}
		return true;  

	}

	public static Object toObject(File file, Object object) throws IOException {

		String str = FileUtils.readFileToString(file);

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);


		try {

			// read from file, convert it to user class
			object = mapper.readValue(str, Object.class);

			// display to console
			System.out.println(object);
			System.out.println("lo state:- " + object);

		} catch (JsonGenerationException d) {

			d.printStackTrace();

		} catch (JsonMappingException d) {

			d.printStackTrace();

		} catch (IOException d) {

			d.printStackTrace();

		}
		return object;

	}


	public static void toString(String fromString, File toFile){
		try (PrintWriter writer = new PrintWriter(toFile)) {
			writer.println(fromString);		
			writer.flush();
		} catch (Exception e) {e.printStackTrace();}


	}

}