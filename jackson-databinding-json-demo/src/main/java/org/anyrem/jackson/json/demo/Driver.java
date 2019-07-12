package org.anyrem.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.anyrem.jackson.json.demo.entity.Student;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {
            //create object mapper
            ObjectMapper objectMapper = new ObjectMapper();

            // read JSON file and map/convert to java POJO
            Student student =
//                    objectMapper.readValue(new File("jackson-databinding-json-demo/data/sample-lite.json"), Student.class);
                    objectMapper.readValue(new File("jackson-databinding-json-demo/data/sample-full.json"), Student.class);

            //print object
            System.out.println(">>> Student: \n" + student);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
