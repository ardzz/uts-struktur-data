package Helper;

import java.io.FileReader;

import Items.AbstractItem;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class DummyDataHandler {
    protected String path_folder = "dummy_data/";
    public String setInstanceClass(AbstractItem item){
        String class_name = item.getClass().getName();
        String[] class_name_split = class_name.split("\\.");
        return class_name_split[class_name_split.length - 1] + ".json";
    }

    public JSONArray getDummyData(AbstractItem item){
        String file_name = setInstanceClass(item);
        String path_file = path_folder + file_name;
        JSONArray dummy_data = null;
        try {
            FileReader reader = new FileReader(path_file);
            dummy_data = (JSONArray) new JSONParser().parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dummy_data;
    }
}
