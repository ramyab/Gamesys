package co.uk.bbc.news.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

    private String fileName;

    public ReadFromPropertiesFile(String environment) {
        this.fileName = environment;
    }

    public String readPropertiesFile (String keyName){
        String keyValue;
        Properties propertiesObject = new Properties();
        try {
            propertiesObject.load(new FileInputStream("src/main/resources/"+fileName+".properties"));

        }  catch (IOException e) {
            e.printStackTrace();
        }
        keyValue=propertiesObject.getProperty(keyName);
        return keyValue;
    }
}