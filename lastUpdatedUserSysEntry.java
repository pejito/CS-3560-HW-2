public class lastUpdatedUserSysEntry implements Visitable{

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitLastUpdatedUser(this);
    }
}
