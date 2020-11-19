
public interface SysEntryVisitor {
    public String visitNumUsers(CountUsersSysEntry visitor);
    public String visitPositive(CountPositiveSysEntry visitor);
    public String visitTotalTweets(CountTotalTweetsSysEntry visitor);
    public String visitNumGroups(CountGroupsSysEntry visitor);
}
