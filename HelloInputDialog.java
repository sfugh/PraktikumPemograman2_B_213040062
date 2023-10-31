//tampilan grafis
import java.awt. *;
import java.awt.event. *;
import javax.swing. *;

//action menjalankan program
public class HelloInputDialog extends JFrame {

    public HelloInputDialog(){
    this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
    this.setLayout(new FlowLayout());

    //ukuran dan text dari tombol
    JButton button = new JButton("Input"); 
    button.setBounds (130, 100, 100, 40);
    
    //entry data
    button.addActionListener(new ActionListener(){ 
        public void actionPerformed (ActionEvent e) {
            String nama = JOptionPane.showInputDialog(HelloInputDialog.this,
                "inputkan nama anda");
            JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello, "+nama);
            }
        });

        this.add(button);
         //ukuran tombol
        this.setSize(200,200);
    }

    //menjalankan program
        public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloInputDialog h new HelloInputDialog();
                h.setVisible(true);
            }
        });
    }
}