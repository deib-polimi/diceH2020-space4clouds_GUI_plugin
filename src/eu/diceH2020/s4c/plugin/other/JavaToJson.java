package eu.diceH2020.s4c.plugin.other;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class JavaToJson {

	public static String convertStateRunning() {
		State state = State.RUNNING;

		ObjectMapper mapper = new ObjectMapper();
		String jsonstring = null;
		try {
			// display to console
			jsonstring = mapper.writeValueAsString(state.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonstring;
	}

	public static String jajson(Object object) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonstring = null;
		try {
			File file = new File("/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/dati.json");
			if (!file.exists())
				file.createNewFile();

			// convert user object to json string, and save to a file
			mapper.writeValue(file, object);

			// display to console
			System.out.println(mapper.writeValueAsString(object));
			jsonstring = mapper.writeValueAsString(object.toString());

		} catch (IOException e) {

			e.printStackTrace();

		}
		return jsonstring;
	}

}