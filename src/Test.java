import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test
{
    public static void main(String[] args)
    {
        Tris t1 = new Tris();
        JLabel settinglbl = new JLabel("IMPOSTAZIONI", SwingConstants.CENTER);
        JLabel giocatore1lbl = new JLabel("Giocatore 1", SwingConstants.CENTER);
        JLabel giocatore2lbl = new JLabel("Giocatore 2", SwingConstants.CENTER);
        JLabel symbollbl = new JLabel("Simboli", SwingConstants.CENTER);
        JLabel colorlbl = new JLabel("Colori", SwingConstants.CENTER);
        JComboBox symbol1 = new JComboBox();
        symbol1.addItem("X");
        symbol1.addItem("O");
        JComboBox symbol2 = new JComboBox();
        symbol2.addItem("O");
        symbol2.addItem("X");
        JComboBox color1 = new JComboBox();
        color1.addItem("Rosso");
        color1.addItem("Verde");
        color1.addItem("Blu");
        JComboBox color2 = new JComboBox();
        color2.addItem("Verde");
        color2.addItem("Rosso");
        color2.addItem("Blu");
        JButton standardbtn = new JButton("Predefinito");
        JButton confirmbtn = new JButton("Conferma");

        confirmbtn.setForeground(Color.RED);
        settinglbl.setFont(new Font("TimesRoman", Font.BOLD, 25));

        JFrame setting = new JFrame("Impostazioni");
        setting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setting.setLayout(new GridLayout(4,3));
        setting.getContentPane().add(settinglbl);
        setting.getContentPane().add(giocatore1lbl);
        setting.getContentPane().add(giocatore2lbl);
        setting.getContentPane().add(symbollbl);
        setting.getContentPane().add(symbol1);
        setting.getContentPane().add(symbol2);
        setting.getContentPane().add(colorlbl);
        setting.getContentPane().add(color1);
        setting.getContentPane().add(color2);
        setting.getContentPane().add(new JLabel(""));
        setting.getContentPane().add(standardbtn);
        setting.getContentPane().add(confirmbtn);


        setting.setBounds(300,200,600,350);
        setting.setVisible(true);

        JFrame window = new JFrame("Tris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Tris());
        window.setBounds(300,200,300,300);
        window.setVisible(false);

        confirmbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae){
                if(symbol1.getSelectedItem()==symbol2.getSelectedItem())
                {
                    JOptionPane.showMessageDialog(null,"Scegli due simboli diversi!");
                }
                else if(color1.getSelectedItem()==color2.getSelectedItem())
                {
                    JOptionPane.showMessageDialog(null,"Scegli due colori diversi!");
                }
                else
                {
                    t1.setCOLOR_PLAYER1(color1.getSelectedItem().toString());
                    t1.setCOLOR_PLAYER2(color2.getSelectedItem().toString());
                    t1.setSYMBOL_PLAYER1(symbol1.getSelectedItem().toString());
                    t1.setSYMBOL_PLAYER2(symbol2.getSelectedItem().toString());

                    System.out.println(t1.getSYMBOL_PLAYER1());
                    System.out.println(t1.getSYMBOL_PLAYER2());

                    window.setVisible(true);
                    setting.setVisible(false);
                }
            }
        });
    }
}
