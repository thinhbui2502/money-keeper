package view;

import entity.Money;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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

    private JTextField idField;
    private JTextField dateField;
    private JTextField moneyNameField;
    private JTextField amountField;
    private JTextArea descriptionTA;


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

        // khởi tạo các trường nhập dữ liệu cho money
        idField = new JTextField(15);
        idField.setEditable(false);
        dateField = new JTextField(15);
        moneyNameField = new JTextField(15);
        amountField = new JTextField(15);
        descriptionTA = new JTextArea();
        descriptionTA.setColumns(15);
        descriptionTA.setRows(5);
        jScrollPaneDescription = new JScrollPane();
        jScrollPaneDescription.setViewportView(descriptionTA);


        // cài đặt các cột và data cho bảng money
        moneyTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneMoneyTable.setViewportView(moneyTable);
        jScrollPaneMoneyTable.setPreferredSize(new Dimension(480, 300));

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

        panel.add(idField);
        panel.add(dateField);
        panel.add(moneyNameField);
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

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dateField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, moneyNameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, moneyNameField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, amountField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, amountField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneDescription, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneDescription, 130, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneMoneyTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneMoneyTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addButton, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editButton, 70, SpringLayout.WEST, addButton);
        layout.putConstraint(SpringLayout.NORTH, editButton, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteButton, 62, SpringLayout.WEST, editButton);
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearButton, 60, SpringLayout.WEST, deleteButton);
        layout.putConstraint(SpringLayout.NORTH, clearButton, 280, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, sortMoneyByValueBtn, 400, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortMoneyByValueBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortMoneyByItemBtn, 150, SpringLayout.WEST, sortMoneyByValueBtn);
        layout.putConstraint(SpringLayout.NORTH, sortMoneyByItemBtn, 330, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Money Keeper");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // enable Add button
        addButton.setEnabled(true);
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
            Locale locale = new Locale("vi","VN" );
            NumberFormat format = NumberFormat.getInstance(locale);
            money[i][3] = format.format(list.get(i).getAmount()) + " đ";

            money[i][4] = list.get(i).getDescription();
        }
        moneyTable.setModel(new DefaultTableModel(money, columnNames));
    }

    //Điền thông tin của hàng được chọn từ bảng money vào các trường tương ứng
    public void fillMoneyFromSelectedRow() {
        //lấy chỉ số của hàng được chọn
        int row = moneyTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(moneyTable.getModel().getValueAt(row, 0).toString());
            dateField.setText(moneyTable.getModel().getValueAt(row, 1).toString());
            moneyNameField.setText(moneyTable.getModel().getValueAt(row, 2).toString());
            amountField.setText(moneyTable.getModel().getValueAt(row, 3).toString());
            descriptionTA.setText(moneyTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            // disable Add button
            addButton.setEnabled(false);
        }
    }

    //Xoa thong tin money
    public void clearMoneyInfo() {
        idField.setText("");
        dateField.setText("");
        moneyNameField.setText("");
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
        dateField.setText("" + money.getDate());
        moneyNameField.setText(money.getMoneyName());
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
        //Chưa validate!!
        Money money = new Money();
        try {
            if (idField.getText() != null && !"".equals(idField.getText())) {
                money.setId(Integer.parseInt(idField.getText()));
            }
            money.setDate(dateField.getText().trim());
            money.setMoneyName(moneyNameField.getText().trim());
            money.setAmount(Integer.parseInt(amountField.getText().trim()));
            money.setDescription(descriptionTA.getText().trim());
            return money;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateDate() {
        String date = dateField.getText();
        if (date == null || "".equals(date.trim())) {
            dateField.requestFocus();
            showMessage("Ngày không được để trống!");
            return false;
        }
        return true;
    }

    private boolean validateNameMoney() {
        String nameMoney = moneyNameField.getText();
        if (nameMoney == null || "".equals(nameMoney.trim())) {
            moneyNameField.requestFocus();
            showMessage("Bạn nên thêm khoản tiền thu/chi của mình!!");
            return false;
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