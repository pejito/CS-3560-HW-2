import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements SysEntry{
	
	public List<User> followingList = new ArrayList<User>(); 
	public List<User> observers = new ArrayList<User>();

	public void followUser(User user){
		observers.add(user);
		user.followingList.add((User) this);
	}

	public void update(User user) {
		user.getNewsFeed().add(user.getTweet());
	}

	public void notifyObservers(){
		for(User observer : observers){
			update(observer);
		}
	}
}
