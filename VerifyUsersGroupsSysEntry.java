public class VerifyUsersGroupsSysEntry implements Visitable {
    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitUserGroupsNames(this);
    }
}
