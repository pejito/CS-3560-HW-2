import java.util.ArrayList;

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
            if(tweet.contains("good") || tweet.contains("fun")){
                positiveTweets++;
            }
        }
        float percentPositive = (float) (positiveTweets/panel.getTweets().size()) * 100;
        return percentPositive + " % positivty";
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
}
