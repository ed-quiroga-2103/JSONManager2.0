
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

	JSONManager(){}

	public static void main(String[] args){
		JSONManager manager = new JSONManager();

		System.out.println(manager.write(1,2,3,4));

	}
	
	public String write(int x1, int y1, int x2, int y2){
		
		JSONObject obj = new JSONObject();

		obj.put("x1",x1);
        obj.put("y1",y1);
        obj.put("x2",x2);
        obj.put("y2",y2);


		String out = obj.toString();

		return out;
	}

	public JSONObject getArg(String arg) throws ParseException{
		JSONParser parser = new JSONParser();
		
		JSONObject obj = (JSONObject) parser.parse(arg);

		return obj;
		
	}
}
