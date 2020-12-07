import java.util.ArrayList;
import java.util.List;

public class UserGroup implements SysEntry {

    private String userGroupID;
    private List<SysEntry> userGroups = new ArrayList<SysEntry>();
    private long creationTime;

    public UserGroup(String newID){

        setID(newID);
        setCreationTime((System.currentTimeMillis()));
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

    public long getCreationTime(){
        return creationTime;
    }

    public void setCreationTime(long newCreationTime){
        creationTime = newCreationTime;
    }
}
