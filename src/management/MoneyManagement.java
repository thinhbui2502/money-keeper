package management;

import entity.Money;
import entity.MoneyXML;
import file.FileMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoneyManagement {
    private static final String MONEY_FILE_NAME = "money.xml";
    private List<Money> listMoney;

    public MoneyManagement() {
        this.listMoney = readListMoney();
    }

    //Lưu đối tượng money vào file money.xml
    public void writeListMoney(List<Money> money) {
        MoneyXML moneyXML = new MoneyXML();
        moneyXML.setMoney(money);
        FileMethod.writeXMLToFile(MONEY_FILE_NAME, moneyXML);
    }

    //Đọc đối tượng money từ file money.xml
    public List<Money> readListMoney() {
        List<Money> list = new ArrayList<Money>();
        MoneyXML moneyXML = (MoneyXML) FileMethod.readXMLFile(MONEY_FILE_NAME, MoneyXML.class);
        if (moneyXML != null) {
            list = moneyXML.getMoney();
        }
        return list;
    }

    //Thêm money vào listMoney và lưu listMoney vào file
    public void add(Money money) {
        int id = (listMoney.size() > 0 ? (listMoney.size() + 1) : 1);
        money.setId(id);
        listMoney.add(money);
        writeListMoney(listMoney);
    }

    //Cập nhật money vào listMoney và lưu listMoney vào file
    public void edit(Money money) {
        int size = listMoney.size();
        for (int i = 0; i < size; i++) {
            if (listMoney.get(i).getId() == money.getId()) {
                listMoney.get(i).setDate(money.getDate());
                listMoney.get(i).setMoneyName(money.getMoneyName());
                listMoney.get(i).setAmount(money.getAmount());
                listMoney.get(i).setDescription(money.getDescription());
                writeListMoney(listMoney);
                break;
            }
        }
    }

    //Xóa money vào listMoney và lưu listMoney vào file
    public boolean delete(Money money) {
        boolean isFound = false;
        int size = listMoney.size();
        for (Money value : listMoney) {
            if (value.getId() == money.getId()) {
                money = value;
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listMoney.remove(money);
            writeListMoney(listMoney);
            return true;
        }
        return false;
    }

    //Sắp xếp danh sách theo giá trị tăng dần
    public void sortMoneyByValue() {
        Collections.sort(listMoney, new Comparator<Money>() {
            @Override
            public int compare(Money money1, Money money2) {
                return (money1.getAmount() - money2.getAmount());
            }
        });
    }

    //Sắp xếp danh sách theo từng khoản thu/chi
    public void sortMoneyByItem() {
        Collections.sort(listMoney, new Comparator<Money>() {
            @Override
            public int compare(Money money1, Money money2) {
                if (money1.getMoneyName().equals(money2.getMoneyName())) {
                    return (money1.getAmount() - money2.getAmount());
                }
                return (money1.getMoneyName().compareTo(money2.getMoneyName()));
            }
        });
    }

    public List<Money> getListMoney() {
        return listMoney;
    }

    public void setListMoney(List<Money> listMoney) {
        this.listMoney = listMoney;
    }
}
