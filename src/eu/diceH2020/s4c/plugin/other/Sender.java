package eu.diceH2020.s4c.plugin.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;

public class Sender {
	public static void askConnection(String path) {
		try {
			File file1 = new File(path);
			String str = FileUtils.readFileToString(file1);
			URL url = new URL("http://localhost:8181/app/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			String encoded = URLEncoder.encode(str, "UTF-8");

			OutputStream os = conn.getOutputStream();
			os.write(encoded.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED
					&& conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");

			str = br.readLine();

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void sendJsonFile(String path) {

		try {
			File file1 = new File(path);
			String str2send = FileUtils.readFileToString(file1);
			URL urlService = new URL("http://localhost:8181/ap/post");
			// TODO re-implement with unirest
			HttpURLConnection connection = (HttpURLConnection) urlService.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			String encoded = URLEncoder.encode(str2send, "UTF-8");

			OutputStream os = connection.getOutputStream();
			os.write(encoded.getBytes());
			os.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED
					&& connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			System.out.println("Output from Server .... \n");

			str2send = br.readLine();

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void jsonToFile(String content) throws IOException {

		FileOutputStream fos = null;

		// Specify the file path here

		fos = new FileOutputStream("/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/dati.json");

		/*
		 * String content cannot be directly written into a file. It needs to be
		 * converted into bytes
		 */
		byte[] bytesArray = content.getBytes();

		fos.write(bytesArray);
		fos.flush();
		System.out.println("File Written Successfully");

		try {
			if (fos != null) {
				fos.close();
			}
		} catch (IOException ioe) {
			System.out.println("Error in closing the Stream");
		}
	}
}
