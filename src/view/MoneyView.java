package view;

import date.DateLabelFormatter;
import entity.Money;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class MoneyView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton sortMoneyByValueBtn;
    private JButton sortMoneyByItemBtn;
    private JScrollPane jScrollPaneMoneyTable;
    private JScrollPane jScrollPaneDescription;
    private JTable moneyTable;

    private JLabel idLabel;
    private JLabel dateLabel;
    private JLabel moneyNameLabel;
    private JLabel amountLabel;
    private JLabel descriptionLabel;

    private JLabel totalUpLabel;
    private JLabel totalDownLabel;
    private JLabel walletLabel;
    private JTextField totalUpField;
    private JTextField totalDownField;
    private JTextField walletField;

    private JLabel displayByLabel;
    private JComboBox displayByComboBox;

    private JTextField idField;
    private JComboBox moneyNameComboBox;
    private JTextField amountField;
    private JTextArea descriptionTA;

    //Khai báo để dùng JDatePicker
    private UtilDateModel model;
    private Properties properties;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;


    // định nghĩa các cột của bảng money
    private String[] columnNames = new String[]{
            "ID", "Ngày", "Nhóm", "Số tiền", "Mô tả"};
    // định nghĩa dữ liệu mặc định của bẳng money là rỗng
    private Object data = new Object[][]{};

    public MoneyView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Tạo các button chức năng
        addButton = new JButton("Thêm");
        editButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");
        clearButton = new JButton("Làm mới");
        sortMoneyByValueBtn = new JButton("Sắp xếp theo giá trị");
        sortMoneyByItemBtn = new JButton("Sắp xếp theo nhóm");
        //Tạo bảng student
        jScrollPaneMoneyTable = new JScrollPane();
        moneyTable = new JTable();

        //Khởi tạo các label
        idLabel = new JLabel("ID");
        dateLabel = new JLabel("Ngày");
        moneyNameLabel = new JLabel("Nhóm");
        amountLabel = new JLabel("Số tiền");
        descriptionLabel = new JLabel("Mô tả");
        totalUpLabel = new JLabel("Tiền vào");
        totalDownLabel = new JLabel("Tiền ra");
        walletLabel = new JLabel("Ví hiện tại");
        displayByLabel = new JLabel("Hiển thị theo: ");

        // khởi tạo các trường nhập dữ liệu cho money
        idField = new JTextField(15);
        idField.setEditable(false);
        Object[] items = {"Khoản thu", "Khoản chi"};
        moneyNameComboBox = new JComboBox(items);
        Object[] itemsForDisplay = {" ", "Khoản thu", "Khoản chi"};
        displayByComboBox = new JComboBox(itemsForDisplay);
        amountField = new JTextField(15);
        descriptionTA = new JTextArea();
        descriptionTA.setColumns(15);
        descriptionTA.setRows(5);
        jScrollPaneDescription = new JScrollPane();
        jScrollPaneDescription.setViewportView(descriptionTA);

        totalUpField = new JTextField(15);
        totalUpField.setEditable(false);
        totalDownField = new JTextField(15);
        totalDownField.setEditable(false);
        walletField = new JTextField(15);
        walletField.setEditable(false);

        //Dùng JDatePicker
        model = new UtilDateModel();
        properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // cài đặt các cột và data cho bảng money
        moneyTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneMoneyTable.setViewportView(moneyTable);
        jScrollPaneMoneyTable.setPreferredSize(new Dimension(480, 278));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý money
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneMoneyTable);

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(sortMoneyByValueBtn);
        panel.add(sortMoneyByItemBtn);

        panel.add(idLabel);
        panel.add(dateLabel);
        panel.add(moneyNameLabel);
        panel.add(amountLabel);
        panel.add(descriptionLabel);

        panel.add(totalUpLabel);
        panel.add(totalUpField);
        panel.add(totalDownLabel);
        panel.add(totalDownField);
        panel.add(walletLabel);
        panel.add(walletField);
        panel.add(displayByLabel);

        panel.add(datePicker);

        panel.add(idField);
        panel.add(moneyNameComboBox);
        panel.add(displayByComboBox);
        panel.add(amountField);
        panel.add(jScrollPaneDescription);


        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dateLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, moneyNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, moneyNameLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, amountLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, amountLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, descriptionLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, descriptionLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, displayByLabel, 600, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, displayByLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, totalUpLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, totalUpLabel, 230, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, totalUpField, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, totalUpField, 230, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, totalDownLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, totalDownLabel, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, totalDownField, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, totalDownField, 260, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, walletLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, walletLabel, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, walletField, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, walletField, 290, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, datePicker, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, datePicker, 40, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, moneyNameComboBox, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, moneyNameComboBox, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, displayByComboBox, 680, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, displayByComboBox, 6, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, amountField, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, amountField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneDescription, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneDescription, 130, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneMoneyTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneMoneyTable, 33, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addButton, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editButton, 70, SpringLayout.WEST, addButton);
        layout.putConstraint(SpringLayout.NORTH, editButton, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteButton, 62, SpringLayout.WEST, editButton);
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearButton, 60, SpringLayout.WEST, deleteButton);
        layout.putConstraint(SpringLayout.NORTH, clearButton, 330, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, sortMoneyByValueBtn, 400, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortMoneyByValueBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortMoneyByItemBtn, 150, SpringLayout.WEST, sortMoneyByValueBtn);
        layout.putConstraint(SpringLayout.NORTH, sortMoneyByItemBtn, 330, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Money Keeper");
        this.setSize(800, 420);
        this.setLocationRelativeTo(null);
        // disable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // enable Add button
        addButton.setEnabled(true);

        moneyTable.setAutoCreateRowSorter(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    //Hiển thị list money vào bảng moneyTable
    public void showListMoney(List<Money> list) {
        int size = list.size();
        Object[][] money = new Object[size][5];
        for (int i = 0; i < size; i++) {
            money[i][0] = list.get(i).getId();
            money[i][1] = list.get(i).getDate();
            money[i][2] = list.get(i).getMoneyName();
            //Định dạng số sang  tiền tệ
            Locale locale = new Locale("vi", "VN");
            NumberFormat format = NumberFormat.getInstance(locale);
            money[i][3] = format.format(list.get(i).getAmount());

            money[i][4] = list.get(i).getDescription();
        }
        moneyTable.setModel(new DefaultTableModel(money, columnNames));
    }

    //Hiện thị tổng tiền thu/chi lấy từ moneyTable
    public void showTotalMoney(List<Money> list) {
        int size = list.size();
        int moneyUp = 0;
        int moneyDown = 0;
        int temp;
        for (int i = 0; i < size; i++) {
            if (moneyTable.getModel().getValueAt(i, 2).equals("Khoản thu")) {
                temp = Integer.parseInt(moneyTable.getModel().getValueAt(i, 3).toString().replace(".", ""));
                moneyUp += temp;
            } else {
                temp = Integer.parseInt(moneyTable.getModel().getValueAt(i, 3).toString().replace(".", ""));
                moneyDown += temp;
            }
        }
        int wallet = moneyUp - moneyDown;
        //Định dạng sang tiền tệ
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        totalUpField.setText(format.format(moneyUp) + " đ");
        totalDownField.setText("- " + format.format(moneyDown) + " đ");
        walletField.setText(format.format(wallet) + " đ");
    }

    //Điền thông tin của hàng được chọn từ bảng money vào các trường tương ứng
    public void fillMoneyFromSelectedRow() {
        //lấy chỉ số của hàng được chọn
        int row = moneyTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(moneyTable.getModel().getValueAt(row, 0).toString());
            amountField.setText(moneyTable.getModel().getValueAt(row, 3).toString().replace(".", ""));
            descriptionTA.setText(moneyTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            // disable Add button
            addButton.setEnabled(false);
        }
    }

    //Clear thong tin money
    public void clearMoneyInfo() {
        idField.setText("");
        amountField.setText("");
        descriptionTA.setText("");
        // enable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // disable Add button
        addButton.setEnabled(true);
    }

    //hiển thị thông tin Money
    public void showMoney(Money money) {
        idField.setText("" + money.getId());
        amountField.setText("" + money.getAmount());
        descriptionTA.setText(money.getDescription());
        // enable Edit and Delete buttons
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
        // disable Add button
        addButton.setEnabled(false);
    }

    //Lấy thông tin money
    public Money getMoneyInfo() {
        if (!validateAmount()) {
            return null;
        }
        try {
            Money money = new Money();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                money.setId(Integer.parseInt(idField.getText()));
            }
            money.setDate(datePicker.getModel().getValue().toString().substring(0, 11));
            money.setMoneyName(moneyNameComboBox.getSelectedItem().toString());
            money.setAmount(Integer.parseInt(amountField.getText().trim()));
            money.setDescription(descriptionTA.getText().trim());
            return money;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    //validate
    private boolean validateAmount() {
        try {
            int amount = Integer.parseInt(amountField.getText().trim());
            if (amount <= 0) {
                amountField.requestFocus();
                showMessage("Số tiền không được nhỏ hơn 0");
                return false;
            }
        } catch (Exception e) {
            amountField.requestFocus();
            showMessage("Số tiền không hợp lệ");
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void addSortMoneyByValueListener(ActionListener listener) {
        sortMoneyByValueBtn.addActionListener(listener);
    }

    public void addSortMoneyByItemListener(ActionListener listener) {
        sortMoneyByItemBtn.addActionListener(listener);
    }

    public void addListMoneySelectionListener(ListSelectionListener listener) {
        moneyTable.getSelectionModel().addListSelectionListener(listener);
    }

}
