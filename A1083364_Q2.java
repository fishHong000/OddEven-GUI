import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class A1083364_Q2{
    public static void main(String[] args) throws Exception{
        MyJFrame f1 = new MyJFrame();
    }
}

class MyJFrame extends JFrame implements ActionListener {
    private JPanel contentPane;
    JTextField textfield;
    private JRadioButton jrb1 = new JRadioButton();
    private JRadioButton jrb2 = new JRadioButton();
    private JLabel jl1 = new JLabel();
    
    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setTitle("choose people");
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());
        
        // 輸入抽取人數
        JLabel lab1 = new JLabel("請輸入抽取人數: ");
        contentPane.add(lab1);
        JTextField choose = new JTextField(5);
        contentPane.add(choose);
        
        // 輸入總人數
        JLabel lab2 = new JLabel("請輸入總人數: ");
        contentPane.add(lab2);
        JTextField total = new JTextField(5);
        contentPane.add(total);
        
        // 選擇單數或複數
        JPanel pan3 = new JPanel();
        add(pan3);
        pan3.setBackground(Color.LIGHT_GRAY);
        pan3.setBounds(300, 20, 100, 120);
        pan3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pan3.setBorder(BorderFactory.createTitledBorder("jPanel 3"));
        pan3.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        ButtonGroup bg = new ButtonGroup();
        jrb1 = new JRadioButton("單數", true);
        jrb2 = new JRadioButton("複數");
        
        bg.add(jrb1);
        bg.add(jrb2);
        
        pan3.add(jrb1);
        jrb1.addActionListener(this);
        pan3.add(jrb2);
        jrb2.addActionListener(this);
        
        // 數字顯示畫面
        jl1 = new JLabel("抽中的號碼是...");
        add(jl1);
        jl1.setBounds(0, 150, 400, 20);
        jl1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1.setBackground(Color.BLUE);
        
        JButton btn1 = new JButton("開始");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int chooseNum = Integer.parseInt(choose.getText());
                int totalNum = Integer.parseInt(total.getText());
                int[] takeNum = new int[chooseNum];
                // 若為單數
                if (jrb1.isSelected()) {
                    int[] takeOdd = new int[totalNum/2 + 1];
                    int count = 0;
                    for (int i = 1; i <= totalNum; i++) {
                        
                        if (i % 2 != 0) {
                            takeOdd[count] = i;
                            count++;
                        }
                    }
                    // 隨機取數
                    Random ran = new Random();
                    int storeNum = 0;
                    for (int i = 0; i < chooseNum; i++) {
                        storeNum = ran.nextInt(totalNum/2 + 1) + 1;
                        takeNum[i] = takeOdd[storeNum];
                    }
                }
                // 若為複數
                if (jrb2.isSelected()) {
                    int[] takeEven = new int[totalNum/2];
                    int count = 0;
                    for (int i = 1; i <= totalNum; i++) {
                        
                        if (i % 2 == 0) {
                            takeEven[count] = i;
                            count++;
                        }
                    }
                    Random ran = new Random();
                    int storeNum = 0;
                    for (int i = 0; i < chooseNum; i++) {
                        storeNum = ran.nextInt(totalNum/2) + 1;
                        takeNum[i] = takeEven[storeNum];
                    }
                    
                }
                // 數字呈現在畫面上
                String lbShow = "";
                for (int k = 0; k < chooseNum; k++) {
                    lbShow += takeNum[k] + " ";
                }
                jl1.setText(lbShow);
            }
        });
        
        contentPane.add(btn1);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        JButton nameBtn = (JButton)e.getSource();
        JOptionPane.showMessageDialog(null, nameBtn.getText());
    }
}