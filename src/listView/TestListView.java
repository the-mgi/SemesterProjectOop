package listView;

import classes.User;
import listners.MainPageHandler;

import javax.swing.*;
import java.awt.*;

public class TestListView extends JFrame {
    public static JList<User> list = new JList<>();
    public static DefaultListModel<User> listModel = new DefaultListModel<>();

    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public TestListView() {
        super.setTitle("List View Demo");
        super.setSize(dimension.width, dimension.height);
        super.setLayout(new BorderLayout());

        list.setModel(listModel);
        list.setFont(new Font(Font.SERIF, Font.ITALIC, 20));

        list.addListSelectionListener(new MainPageHandler());

        listModel.addElement(new User("usama78941", "Muhammad Usama", "saimal7941@gmail.com", "34567"));
        listModel.addElement(new User("usama78941", "Muhammad Usama", "saimal7941@gmail.com", "34567"));
        listModel.addElement(new User("usama78941", "Muhammad Usama", "saimal7941@gmail.com", "34567"));
        super.add(list);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestListView();
    }


}
