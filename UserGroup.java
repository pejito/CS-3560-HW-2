import java.util.ArrayList;
import java.util.List;

public class UserGroup implements SysEntry {

    private String userGroupID;
    private List<SysEntry> userGroups = new ArrayList<SysEntry>();

    public UserGroup(String newID){
        setID(newID);
    }

    @Override
    public void setID(String newID) {
        this.userGroupID = newID;
    }

    @Override
    public String getID() {
        return userGroupID;
    }

    @Override
    public String acceptSysEntryVisitor(SysEntryVisitor visitor) {
        return null;
    }
}
