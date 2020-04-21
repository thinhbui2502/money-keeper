package controller;

import entity.User;
import management.UserManagement;
import view.LoginView;
import view.MoneyView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginController {
    private UserManagement userManagement;
    private LoginView loginView;
    private MoneyView moneyView;

    public LoginController(LoginView view) {
        this.loginView = view;
        this.userManagement = new UserManagement();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    /**
     * Lớp LoginListener
     * chứa cài đặt cho sự kiện click button "Login"
     *
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userManagement.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                moneyView = new MoneyView();
                MoneyController moneyController = new MoneyController(moneyView);
                moneyController.showMoneyView();
                loginView.setVisible(false);
                loginView.showMessage("Đăng nhập thành công!");
            } else {
                loginView.showMessage("Tài khoản hoặc mật khẩu không đúng!");
            }
        }
    }
}