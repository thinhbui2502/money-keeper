package controller;

import entity.Money;
import management.MoneyManagement;
import view.MoneyView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MoneyController {
    private MoneyManagement moneyManagement;
    private MoneyView moneyView;

    public MoneyController(MoneyView view) {
        this.moneyView = view;
        moneyManagement = new MoneyManagement();

        view.addAddButtonListener(new AddMoneyListener());
        view.addEditButtonListener(new EditMoneyListener());
        view.addDeleteButtonListener(new DeleteStudentListener());
        view.addClearButtonListener(new ClearMoneyListener());
        view.addSortMoneyByValueListener(new SortMoneyByValueListener());
        view.addListMoneySelectionListener(new ListMoneySelectionListener());
    }

    public void showMoneyView() {
        List<Money> moneyList = moneyManagement.getListMoney();
        moneyView.setVisible(true);
        moneyView.showListMoney(moneyList);
    }

        //cài đặt cho sự kiện click button "Add"
    class AddMoneyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Money money = moneyView.getMoneyInfo();
                if (money != null) {
                    moneyManagement.add(money);
                    moneyView.showMoney(money);
                    moneyView.showListMoney(moneyManagement.getListMoney());
                    moneyView.showMessage("Thêm thành công!");
                }
            }
        }
        //cài đặt cho sự kiện click button "Edit"
    class EditMoneyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Money money = moneyView.getMoneyInfo();
                if (money!= null) {
                    moneyManagement.edit(money);
                    moneyView.showMoney(money);
                    moneyView.showListMoney(moneyManagement.getListMoney());
                    moneyView.showMessage("Cập nhật thành công");
                }
            }
        }

        //cài đặt cho sự kiện click button "Delete"
    class DeleteStudentListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Money money = moneyView.getMoneyInfo();
                if (money != null) {
                    moneyManagement.delete(money);
                    moneyView.clearMoneyInfo();
                    moneyView.showListMoney(moneyManagement.getListMoney());
                    moneyView.showMessage("Xóa thành công!");
                }
            }
        }
         //cài đặt cho sự kiện click button "Clear"
    class ClearMoneyListener implements ActionListener {
             @Override
             public void actionPerformed(ActionEvent e) {
                 moneyView.clearMoneyInfo();
             }
         }

         //cài đặt cho sự kiện click button "SortByValue"
    class SortMoneyByValueListener implements ActionListener {
             @Override
             public void actionPerformed(ActionEvent e) {
                 moneyManagement.sortMoneyByValue();
                 moneyView.showListMoney(moneyManagement.getListMoney());
             }
         }

    //cài đặt cho sự kiện click button "SortByItem (chưa làm đc)

    //Lớp ListMoneySelectionListener chứa cài đặt cho sự kiện chọn money trong bảng
    class ListMoneySelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            moneyView.fillMoneyFromSelectedRow();
        }
    }



}
