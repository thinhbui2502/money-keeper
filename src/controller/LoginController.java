package controller;

import entity.User;
import management.UserManagement;
import view.LoginView;
import view.MoneyView;
import view.RegisterView;

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
        view.addRegisterListener(new RegisterListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterView();
            loginView.setVisible(false);
        }
    }

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
