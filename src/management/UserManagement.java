package management;

import entity.User;

public class UserManagement {
    public boolean checkUser(User user) {
        if (user != null) {
            return "admin".equals(user.getUserName())
                    && "admin".equals(user.getPassword());
        }
        return false;
    }
}
