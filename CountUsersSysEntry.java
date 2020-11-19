
public class CountUsersSysEntry implements Visitable{

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitNumUsers(this);
    }
}
