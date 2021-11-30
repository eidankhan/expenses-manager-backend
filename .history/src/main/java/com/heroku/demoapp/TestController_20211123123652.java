package com.heroku.demoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;

@RestController
@RequestMapping("/students")
public class TestController {
    

    @Value("${datadump.location.authors}")
	private String fileLocation;


	private static List<Author> authors;


    @GetMapping
    public Object sayHello(){
        Path path = Paths.get(fileLocation);
		
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
        return authors;
    }
}
