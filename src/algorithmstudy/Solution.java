package algorithmstudy;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234" , "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] answer = {};
		answer = new String[record.length];
        
		List<User> messages = new ArrayList<User>();
		
        for (int i = 0; i < record.length; i++) {        
        	int index = record[i].indexOf(" ");
        	
        	User user = new User();
        	user.setAction(record[i].substring(0, index));
        	
        	if (user.getAction().equals("Leave")) {
        		user.setUserId(record[i].substring(index + 1));
        		user.setUserNickName("");
        	}
        	else {
        		user.setUserId(record[i].substring(index + 1, record[i].lastIndexOf(" ")));
        		user.setUserNickName(record[i].substring(record[i].lastIndexOf(" ") + 1));
        	}
        	
        	messages.add(user);
        }
        for (int i = 0; i < messages.size(); i++) {
        	System.out.println(messages.get(i).getAction() + " " + messages.get(i).getUserId() + " " + messages.get(i).getUserNickName());
        }       
        //Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234" , "Enter uid1234 Prodo", "Change uid4567 Ryan"
      //[Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., Prodo님이 나갔습니다., Prodo님이 들어왔습니다.]
        for (int i = 0; i < messages.size(); i++) {
        	String id = "";
        	String changeName = "";
        	String action = messages.get(i).getAction();
        	switch (action) {
			case "Enter":
				id = messages.get(i).getUserId();
				changeName = messages.get(i).getUserNickName();
				for (int j = 0; j < messages.size(); j++) {
					if (messages.get(j).getUserId().equals(id)) {
						answer[j] = changeName + "님이 들어왔습니다.";
						break;
					}
				}
				break;
			case "Leave":
				id = messages.get(i).getUserId();
				for (int j = 0; j < messages.size(); j++) {
					if (messages.get(j).getUserId().equals(id)) {
						answer[i] = messages.get(j).getUserNickName() + "님이 나갔습니다.";
						break;
					}
				}
				break;
			case "Change":
				id = messages.get(i).getUserId();
				changeName = messages.get(i).getUserNickName();
				for (int j = 0; j < messages.size(); j++) {
					if (messages.get(j).getUserId().equals(id)) {
						answer[j] = changeName + "님이 들어왔습니다.";
						break;
					}
				}
				break;
			default:
				break;
			}
        }
        
        for (int i = 0; i < answer.length; i++) {
        	System.out.print(answer[i] + " ");
        }
	}

}

class User {
    private String action;
    private String userId;
    private String userNickName;
    
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	} 
}