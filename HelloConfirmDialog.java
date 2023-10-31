//tampilan grafis
import java.awt. *;
import java.awt.event. *;
import javax.swing. *;

//action menjalankan program
public class HelloConfirmDialog extends JFrame {

    public HelloMessageDialog(){
    this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
    this.setLayout(new FlowLayout());

    //ukuran dan text dari tombol
    JButton button = new JButton("Exit"); 
    button.setBounds (130, 100, 100, 40);
    
    //algoritma
    button.addActionListener(new ActionListener(){ 
        public void actionPerformed (ActionEvent e) {
            int confirmation = JOptionPane.showConfirmDialog (HelloConfirmDialog.this, 
                "Apakan anda yakin ingin keluar dari aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else
            JOptionPane.showMessageDialog(HelloConfirmDialog.this, "Anda menekan tombol NO");
            }
        });

    this.add(button);
    
    //ukuran tombol
    this.setSize(280,208);
    }
    
    //menjalankan program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloConfirmDialog h new HelloConfirmDialog();
                h.setVisible(true);
            }
        });
    }
}