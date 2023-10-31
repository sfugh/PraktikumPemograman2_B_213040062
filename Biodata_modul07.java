import java.awt.Color; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
import java.awt.Font; 
import javax.swing.table.DefaultTableModel; 
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.BufferedWriter; 
import java.io.IOException; 

public class BiodataApp extends JFrame {
    public BiodataApp() {
        
        addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {
                                                       
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah ingin keluar?", "EXIT",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup aplikasi jika pengguna memilih "Yes"
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Tidak menutup aplikasi jika pengguna
                                                                          // memilih "No"
                }
            }
        });
        JLabel labelInput = new JLabel("Nama :"); // Membuat label dengan teks "Nama :"
        labelInput.setBounds(15, 20, 350, 30); // posisi dan ukuran label (x, y, lebar, tinggi)

        JTextField textField = new JTextField(); // Membuat field teks
        textField.setBounds(15, 50, 350, 30); // posisi dan ukuran field teks

        JLabel labelInput2 = new JLabel("Nomor HP :"); // Membuat label kedua dengan teks "Nomor HP :"
        labelInput2.setBounds(15, 80, 350, 30); // posisi dan ukuran label kedua

        JTextField textField2 = new JTextField(); // Membuat field teks kedua
        textField2.setBounds(15, 110, 350, 30); // posisi dan ukuran field teks kedua

        JLabel labelInput3 = new JLabel("Alamat :"); // Membuat label ketiga dengan teks "Alamat :"
        labelInput3.setBounds(15, 140, 350, 30); // posisi dan ukuran label ketiga

        JTextField textField3 = new JTextField(); // Membuat field teks ketiga
        textField3.setBounds(15, 170, 350, 30); // posisi dan ukuran field teks ketiga

        // Radio button
        JLabel labelRadio = new JLabel("Jenis Kelamin :"); // Membuat label keempat dengan teks "Jenis Kelamin :"
        labelRadio.setBounds(15, 200, 350, 30); // posisi dan ukuran label keempat

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki"); // Membuat radio button pertama dengan opsi
                                                                   // "Laki-Laki"
        radioButton1.setBounds(15, 225, 350, 30); // posisi dan ukuran radio button pertama

        JRadioButton radioButton2 = new JRadioButton("Perempuan"); // Membuat radio button kedua dengan opsi "Perempuan"
        radioButton2.setBounds(15, 250, 350, 30); // posisi dan ukuran radio button kedua
        ButtonGroup bg = new ButtonGroup(); // Membuat grup tombol
        bg.add(radioButton1); 
        bg.add(radioButton2); 

        // Membuat JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();

        // Membuat table model dan set Column
        Object[] columns = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" }; // Mendefinisikan kolom tabel
        DefaultTableModel model = new DefaultTableModel(); 
        model.setColumnIdentifiers(columns);

        table.setModel(model); // Menetapkan model untuk tabel


        JButton btnAdd = new JButton("Simpan"); // Membuat tombol "Simpan"
        btnAdd.setBounds(15, 310, 100, 25);

        JButton btnDelete = new JButton("Hapus"); // Membuat tombol "Hapus"
        btnDelete.setBounds(260, 310, 100, 25);

        JButton btnUpdate = new JButton("Edit"); // Membuat tombol "Edit"
        btnUpdate.setBounds(140, 310, 100, 25);

        JButton btnFile = new JButton("Simpan Ke File"); // Membuat tombol "Simpan Ke File"
        btnFile.setBounds(380, 310, 120, 25);

        // Untuk membuat JScrollPane
        JScrollPane pane = new JScrollPane(table); // Membuat JScrollPane dan menambahkan tabel ke dalamnya
        pane.setBounds(15, 350, 500, 200);

        frame.setLayout(null); // Mengatur layout frame menjadi null (absolute positioning)
        frame.add(pane);
        // memasukan JTextFields ke jframe
        frame.add(textField);
        frame.add(textField2);
        frame.add(textField3);

        // memasukan Jbutton ke jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate); 
        frame.add(btnFile);

        // membuat array dengan 4 row
        Object[] row = new Object[4]; 

       
        btnAdd.addActionListener(new ActionListener() { // Menambahkan ActionListener ke tombol "Simpan"

            @Override
            public void actionPerformed(ActionEvent e) { 
                String jenisKelamin = " "; 
                if (radioButton1.isSelected()) { 
                    jenisKelamin = radioButton1.getText(); 
                }
                if (radioButton2.isSelected()) { 
                    jenisKelamin = radioButton2.getText(); 
                }
                String nama = textField.getText(); // Mengambil teks dari textField (Nama)
                String nomortlp = textField2.getText(); // Mengambil teks dari textField2 (Nomor HP)
                String alamat = textField3.getText(); // Mengambil teks dari textField3 (Alamat)
                if (nama.trim().isEmpty() || nomortlp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    // Jika salah satu field kosong, tampilkan pesan peringatan
                    JOptionPane.showMessageDialog(BiodataApp.this, "Form tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(BiodataApp.this, "Masukan Data?", "Konfirmasi",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        row[0] = textField.getText();
                        row[1] = textField2.getText();
                        row[2] = textField3.getText();
                        row[3] = jenisKelamin;
                        model.addRow(row);
                        textField.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(BiodataApp.this, "Anda tidak memasukan data");
                    }
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener() { // Menambahkan ActionListener ke tombol "Hapus"

            @Override
            public void actionPerformed(ActionEvent e) { // Metode ini akan dipanggil ketika tombol "Hapus" diklik

                // i = the index of the selected row
                int i = table.getSelectedRow(); // Mengambil indeks baris yang dipilih
                if (i >= 0) {

                    model.removeRow(i); // ...maka hapus baris dari tabel
                } else {
                    System.out.println("Delete Error"); 
                }
                textField.setText(null); 
                textField2.setText(null); 
                textField3.setText(null); 
            }
        });

        // Fungsi selected row data
        table.addMouseListener(new MouseAdapter() { // Menambahkan MouseAdapter ke tabel

            @Override
            public void mouseClicked(MouseEvent e) { // Metode ini akan dipanggil ketika tabel diklik

                // i = the index of the selected row
                int i = table.getSelectedRow(); // Mengambil indeks baris yang dipilih

                textField.setText(model.getValueAt(i, 0).toString()); 
                                                                      
                textField2.setText(model.getValueAt(i, 1).toString()); 
                                                                       
                textField3.setText(model.getValueAt(i, 2).toString()); 
                                                                       
            }
        });

        
        btnUpdate.addActionListener(new ActionListener() { // Menambahkan ActionListener ke tombol "Edit"

            @Override
            public void actionPerformed(ActionEvent e) { 

                int i = table.getSelectedRow(); // Mengambil indeks baris yang dipilih

                if (i >= 0) {
                    model.setValueAt(textField.getText(), i, 0); // Mengatur nilai pada kolom 0 dari baris yang dipilih
                                                                 // menjadi teks dari textField
                    model.setValueAt(textField2.getText(), i, 1); // Mengatur nilai pada kolom 1 dari baris yang dipilih
                                                                  // menjadi teks dari textField2
                    model.setValueAt(textField3.getText(), i, 2); // Mengatur nilai pada kolom 2 dari baris yang dipilih
                                                                  // menjadi teks dari textField3
                } else {
                    System.out.println("Update Error"); // Jika tidak ada baris yang dipilih, cetak "Update Error"
                }
            }
        });

        // Membuat button untuk menyimpan data ke file
        btnFile.addActionListener(new ActionListener() { 

            @Override
            public void actionPerformed(ActionEvent e) { 

                JFileChooser fileChooser = new JFileChooser(); // Membuat objek JFileChooser
                int userSelection = fileChooser.showSaveDialog(BiodataApp.this); 

                if (userSelection == JFileChooser.APPROVE_OPTION) { 
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath(); 
                        FileWriter fileWriter = new FileWriter(filePath); 
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

                        for (int i = 0; i < model.getRowCount(); i++) { // Looping melalui setiap baris pada model tabel
                            String nama = model.getValueAt(i, 0).toString(); 
                            String nomorTlp = model.getValueAt(i, 1).toString(); 
                            String alamat = model.getValueAt(i, 2).toString(); 
                            String jenisKelamin = model.getValueAt(i, 3).toString(); 

                            String data = nama + "," + nomorTlp + "," + alamat + "," + jenisKelamin; 
                            bufferedWriter.write(data); // Menulis data ke file
                            bufferedWriter.newLine(); // Menulis baris baru ke file
                        }

                        bufferedWriter.close(); // Menutup BufferedWriter
                        fileWriter.close(); // Menutup FileWriter

                        JOptionPane.showMessageDialog(BiodataApp.this, "Data berhasil disimpan ke file.", "Info",
                                JOptionPane.INFORMATION_MESSAGE); // Menampilkan pesan bahwa data berhasil disimpan ke
                                                                  // file
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(BiodataApp.this, "Terjadi kesalahan saat menyimpan data ke file.",
                                "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan kesalahan jika terjadi
                                                                     // IOException
                    }
                }
            }
        });

        this.add(textField); // Menambahkan textField ke dalam frame 
        this.add(textField2); 
        this.add(textField3); 
        this.add(labelRadio); // Menambahkan radioButton ke dalam frame 
        this.add(radioButton1); 
        this.add(radioButton2); 
        this.add(labelInput); // Menambahkan labelInput ke dalam frame 
        this.add(labelInput2); 
        this.add(labelInput3); 
        this.add(btnAdd); // Menambahkan btnAdd ke dalam frame 
        this.add(btnDelete); // Menambahkan btnDelete ke dalam frame 
        this.add(btnUpdate); // Menambahkan btnUpdate ke dalam frame 
        this.add(btnFile); // Menambahkan btnFile ke dalam frame 
        this.add(pane); // Menambahkan pane (JScrollPane) ke dalam frame 

        this.setSize(600, 700); // Mengatur ukuran frame menjadi 600x700 piksel
        this.setLayout(null); // Mengatur layout manager menjadi null 
    }

public static void main(String[] args) {

    javax.swing.SwingUtilities.invokeLater(new Runnable() { 
        @Override
        public void run() {

            BiodataApp b = new BiodataApp(); 
            b.setVisible(true);
        }
    });
}
}