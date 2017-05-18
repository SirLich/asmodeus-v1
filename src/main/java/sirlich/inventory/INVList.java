package sirlich.inventory;

import java.util.HashMap;

public class INVList {
	private static HashMap<String,INVAction> mapp = new HashMap<String,INVAction>();
	public static INVAction getAction(String s){
		return mapp.get(s);
	}
	public static void addAction(String s, INVAction a){
		mapp.put(s, a);
	}
}
