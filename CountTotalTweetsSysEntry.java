
public class CountTotalTweetsSysEntry implements Visitable{

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitTotalTweets(this);
    }
}
