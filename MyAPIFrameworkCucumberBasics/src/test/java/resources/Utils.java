package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    //RequestSpecification req;
    public static RequestSpecification req; // make the variable static so when 1st test case executed it get created and for next time it uses the same one instead of creating new one
    public RequestSpecification requestSpecification() throws IOException {  //access the method using the object or the inheritance

        if (req == null) {                   //check wheather req is null then create it otherwise use old one
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));    // file to log the request and response where it automatically creat the logging

            //req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))                  //this is get used for the logging the request and response
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))                // it required the PrintStream class object
                    .setContentType(ContentType.JSON).build();
            return req;

        }
        return req;
        //we are doing this (making static and adding IF() ) cause our old logging.txt is get replaced with new one for every test case and because of this we can't able to see old logs
    }

    public static String getGlobalValue(String key) throws IOException {          // making this method as static so we can access it directly
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\e326215\\IdeaProjects\\MyAPIFrameworkCucumberBasics\\src\\test\\java\\resources\\global.properties");
            //here we have object of properties cause we want to access the properties file and to read that file we need the file input stream
        prop.load(fis);   //load the file into prop
        return prop.getProperty(key);    //extract the key of content from the properties file

    }


    public String getJsonPath(Response response, String key) {

        String resp = response.asString();
        System.out.println(resp);
        JsonPath js = new JsonPath(resp);
        //System.out.println(js.get("statusCode").toString());
        return js.get(key).toString();

    }
}
