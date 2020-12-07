import java.util.ArrayList;
import java.util.List;

public class User extends Subject {
	
	private String userID;
	private String tweet;
	private long creationTime;
	private long updateTime;
	private List<String> newsfeed = new ArrayList<String>();

	public User(String ID){
		this.setID(ID);
		setCreationTime((System.currentTimeMillis()));
	}

	@Override
	public void setID(String newID) {
		userID = newID;
	}

	@Override
	public String getID() {
		return userID;
	}

	public List<String> getFollowing(){
		List<String> following = new ArrayList<String>();
		for(User user:followingList){
			following.add(user.getID());
		}
		return following;
	}

	public List<String> getFollowers(){
		List<String> followers = new ArrayList<String>();
		for(User user : observers){
			followers.add(user.getID());
		}
		return followers;
	}

	public String getTweet(){
		return tweet;
	}

	public void makeAndPostTweet(String newTweet){
		this.tweet = newTweet;
		notifyObservers();
		newsfeed.add(tweet);
	}

	public List<String> getNewsFeed(){
		return newsfeed;
	}

	@Override
	public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
		return null;
	}

	public long getCreationTime(){
		return creationTime;
	}

	public void setCreationTime(long newCreationTime){
		creationTime = newCreationTime;
	}

	public long getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(long newUpdateTime){
		updateTime = newUpdateTime;
	}
}
