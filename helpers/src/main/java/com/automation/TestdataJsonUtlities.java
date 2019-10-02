package com.automation;

import com.jayway.jsonpath.JsonPath;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestdataJsonUtlities {


    public static String getDataFromLiteralPathJSONFile(String sFileLocation, String sJsonExpression) {

        try {
            String str = readFile(sFileLocation, StandardCharsets.UTF_8);
            //String jsonPathExpression = "$.regions[?(@.code == '" + sRegion + "')].rooms[?(@.name=='" + sRoom + "')].utterances[?(@.Key=='" + sData + "')].Value";

            Object jsonresult = JsonPath.parse(str).read(sJsonExpression);


            return TrimJSONResults(jsonresult.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "NO JSON FILE FOUND";
    }



   public static String getDataFromResourcesRelativePathJSONFile(String sjsonFileName, String sJsonExpression) {

        try {



            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            File file = new File(classLoader.getResource(sjsonFileName).getFile());

            // File file = ResourceUtils.getFile("classpath:resources/"+sjsonFileName);


            String str = new String(Files.readAllBytes(file.toPath()));;
            //String jsonPathExpression = "$.regions[?(@.code == '" + sRegion + "')].rooms[?(@.name=='" + sRoom + "')].utterances[?(@.Key=='" + sData + "')].Value";

            Object jsonresult = JsonPath.parse(str).read(sJsonExpression);


            return TrimJSONResults(jsonresult.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "NO JSON FILE FOUND";
    }




    public static boolean getBooleanFromResourcesRelativePathJSONFile(String sjsonFileName, String sJsonExpression) {

        try {

            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            File file = new File(classLoader.getResource(sjsonFileName).getFile());

            // File file = ResourceUtils.getFile("classpath:resources/"+sjsonFileName);


            String str = new String(Files.readAllBytes(file.toPath()));
            //String jsonPathExpression = "$.regions[?(@.code == '" + sRegion + "')].rooms[?(@.name=='" + sRoom + "')].utterances[?(@.Key=='" + sData + "')].Value";


            Object jsonresult = JsonPath.parse(str).read(sJsonExpression);

            boolean result = Boolean.parseBoolean(TrimJSONResults(jsonresult.toString()));
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static String getDateFromResourcesRelativePathJSONFile(String sjsonFileName, String sJsonExpression) {

        try {



            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            File file = new File(classLoader.getResource(sjsonFileName).getFile());

            // File file = ResourceUtils.getFile("classpath:resources/"+sjsonFileName);


            String str = new String(Files.readAllBytes(file.toPath()));;
            //String jsonPathExpression = "$.regions[?(@.code == '" + sRegion + "')].rooms[?(@.name=='" + sRoom + "')].utterances[?(@.Key=='" + sData + "')].Value";

            Object jsonresult = JsonPath.parse(str).read(sJsonExpression);


            return TrimJSONResults(jsonresult.toString().replace("\\", ""));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "NO JSON FILE FOUND";
    }


    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    private static String TrimJSONResults(String inString){


        return inString.substring(2,inString.length()-2);



    }

}
