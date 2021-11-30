package com.heroku.demoapp;

import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class DemoAppApplication {

	private static List<Author> authors;

	@Value("${datadump.location.authors}")
	private String fileLocation;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
		System.out.println(fileLocation);
		//loadData();
	}

	private static void loadData(){
        Path path = Paths.get("uri");
		try (Stream<String> lines = Files.lines(path)) {
			lines.limit(10).forEach(line -> {
				String jsonString = line.substring(line.indexOf("{"));
				JSONObject jsonObject = new JSONObject(jsonString);
				String id = jsonObject.optString("key").replace("/authors/", "");
				String name = jsonObject.optString("name");
				String personalName = jsonObject.optString("personalName");
				Author author = new Author(id, name, personalName);
				authors.add(author);
			});
		}
		catch(IOException e){
			e.printStackTrace();
		}

    }

}
