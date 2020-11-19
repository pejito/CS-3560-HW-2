
public class CountGroupsSysEntry implements Visitable{

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitNumGroups(this);
    }
}
