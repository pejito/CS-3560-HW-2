import java.util.*;

public class ConcreteSysEntryVisitor implements SysEntryVisitor{


    @Override
    public String visitNumUsers(CountUsersSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        return panel.getUsers().size() + " users";
    }

    @Override
    public String visitPositive(CountPositiveSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        int positiveTweets = 0;
        for(String tweet : panel.getTweets()){
            if(tweet.contains("happy") || tweet.contains("fun")){
                positiveTweets++;
            }
        }
        float percentPositive = (float) (positiveTweets/panel.getTweets().size()) * 100;
        return percentPositive + " % positivity";
    }

    @Override
    public String visitTotalTweets(CountTotalTweetsSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        return panel.getTweets().size() + " total tweets";
    }

    @Override
    public String visitNumGroups(CountGroupsSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        return panel.getGroups().size() + " groups";
    }

    @Override
    public String visitUserGroupsNames(VerifyUsersGroupsSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        int numWrong = 0;
        Set<User> set1 = new HashSet<User>(panel.getUsers());
        Set<UserGroup> set2 = new HashSet<UserGroup>(panel.getGroups());
        if (set1.size() < panel.getUsers().size()){
            numWrong = panel.getUsers().size() - set1.size();
        }
        if(set2.size() < panel.getGroups().size()){
            numWrong = panel.getGroups().size() - set1.size();
        }
        for(User user : panel.getUsers()){
            if(user.getID().contains(" ")){
                numWrong++;
            }
        }
        for(UserGroup group : panel.getGroups()){
            if(group.getID().contains(" ")){
                numWrong++;
            }
        }
        return "There were " + numWrong + " wrong usernames";
    }

    @Override
    public String visitLastUpdatedUser(lastUpdatedUserSysEntry visitor) {
        AdminPanel panel = AdminPanel.getInstance();
        List<Long> updateTimes = new ArrayList<Long>();
        for(User user : panel.getUsers()){
            updateTimes.add(user.getUpdateTime());
        }
        int indexMax = updateTimes.indexOf(Collections.max(updateTimes));
        User mostRecent = panel.getUsers().get(indexMax);
        String mostRecentID = mostRecent.getID();
        return "Most recently updated user: " + mostRecentID;
    }
}
