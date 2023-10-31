import public class HelloMassageDialog extends JFrame {
    /**
     * 
     */
    public HelloMassageDialog() {
        this.setDefaultCloseOperation(JFrame._EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("klik");
        button.setBounds(130,100,100, 40);

        button.addActionListener(new addActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "halo, selamat datang di pemograman II.");
            }
        });

        this.add(button);
        this.setSize(200,200);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }
}