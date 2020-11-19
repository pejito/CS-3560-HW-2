import javafx.scene.control.TreeItem;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class AdminPanel {
    private static AdminPanel instance = null;
    private ConcreteSysEntryVisitor visitor = new ConcreteSysEntryVisitor();
    private List<UserWindow> userWindows = new ArrayList<UserWindow>();
    private List<User> users = new ArrayList<User>();
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
    private List<String> tweets = new ArrayList<String>();

    private AdminPanel(){
        System.out.println("Twitter program started");
    }

    public static AdminPanel getInstance(){
        if(instance == null){
            instance = new AdminPanel();
        }
        return instance;
    }

    public void newUserWindow(UserWindow window){
        userWindows.add(window);
    }

    public void newTweet(String newTweet){
        tweets.add(newTweet);
    }

    public TreeItem<String> newSysEntry(String newID, TreeItem<String> parent){
        User newSysEntry = new User(newID);
        users.add(newSysEntry);
        String id = newSysEntry.getID();
        TreeItem<String> userBranch = new TreeItem<String>(id);
        userBranch.setExpanded(true);
        parent.getChildren().add(userBranch);
        return userBranch;
    }

    public UserWindow getUserWindow(String userID){
        for(UserWindow window : userWindows){
            if(window.getUserWindow().equals(userID)){
                return window;
            }
        }
        return null;
    }

    public User getUser(String userID){
        for(User user : users){
            if(user.getID().equals(userID)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return users;
    }

    public List<UserGroup> getGroups(){
        return userGroups;
    }

    public List<String> getTweets(){
        return tweets;
    }

    public String countUsers(){
        CountUsersSysEntry count = new CountUsersSysEntry();
        return count.acceptSysEntryVisitor(visitor);
    }

    public String countGroups(){
        CountGroupsSysEntry count = new CountGroupsSysEntry();
        return count.acceptSysEntryVisitor(visitor);
    }

    public String countPositive(){
        CountPositiveSysEntry count = new CountPositiveSysEntry();
        return count.acceptSysEntryVisitor(visitor);
    }

    public String countTweets(){
        CountTotalTweetsSysEntry count = new CountTotalTweetsSysEntry();
        return count.acceptSysEntryVisitor(visitor);
    }

}
