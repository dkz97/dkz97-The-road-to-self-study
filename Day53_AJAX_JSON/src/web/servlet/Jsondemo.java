package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Jsondemo {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String,String> map = new HashMap<String,String>();

        map.put("username","zhangsan");
        map.put("password","123");

        mapper.writeValue(new File("src/a.xtx"),map);
    }

}
