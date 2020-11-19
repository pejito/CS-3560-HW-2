
public class CountPositiveSysEntry implements Visitable{

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return visitor.visitPositive(this);
    }
}
