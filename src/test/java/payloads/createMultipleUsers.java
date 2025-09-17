package payloads;

import core.setupData;

import java.util.ArrayList;
import java.util.List;

public class createMultipleUsers {

    public List<UserPOJO> generatemultipleusers(int noofusers)
    {
        List<UserPOJO> userslist = new ArrayList<>();
        for(int i=0; i<noofusers; i++)
        {
            userslist.add(new setupData().setupUserData());
        }
        return userslist;
    }
}
