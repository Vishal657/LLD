package splitWise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitWise {

    Set<User> users;
    List<Group> groups;

    SplitWise() {
        users = new HashSet<>();
        groups = new ArrayList<>();
    }

    User addUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    Group createGroup() {
        Group group = new Group();
        groups.add(group);
        return group;
    }

}
