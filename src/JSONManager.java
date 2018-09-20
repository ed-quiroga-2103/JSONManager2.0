
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

    JSONManager() {}

    public static void main(String[] args) {
    }

    public String clientWrite(int x1, int y1, int x2, int y2) {

        JSONObject obj = new JSONObject();

        obj.put("x1", x1);
        obj.put("y1", y1);
        obj.put("x2", x2);
        obj.put("y2", y2);


        return obj.toString();


    }

    public String serverWrite(boolean playing, boolean draw) {

        JSONObject obj = new JSONObject();

        obj.put("playing", playing);
        obj.put("draw", draw);

        return obj.toString();
    }


    public JSONObject getArg(String arg) throws ParseException{
		JSONParser parser = new JSONParser();
		
		JSONObject obj = (JSONObject) parser.parse(arg);

		return obj;
		
	}
}

