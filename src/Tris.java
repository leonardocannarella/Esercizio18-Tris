import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Tris extends JPanel implements ActionListener
{
    JButton buttons[] = new JButton[9];
    public int alternate = 0;
    public int i = 1;
    //PARAMETRI PER GIOCARE
    public String COLOR_PLAYER1;
    public String COLOR_PLAYER2;
    public String SYMBOL_PLAYER1;
    public String SYMBOL_PLAYER2;

    public Tris()
    {
        setLayout(new GridLayout(3,3));
        initializebuttons();
    }

    public void setCOLOR_PLAYER1(String COLOR_PLAYER1) {
        this.COLOR_PLAYER1 = COLOR_PLAYER1;
    }

    public void setCOLOR_PLAYER2(String COLOR_PLAYER2) {
        this.COLOR_PLAYER2 = COLOR_PLAYER2;
    }

    public void setSYMBOL_PLAYER1(String SYMBOL_PLAYER1) {
        this.SYMBOL_PLAYER1 = SYMBOL_PLAYER1;
    }

    public void setSYMBOL_PLAYER2(String SYMBOL_PLAYER2) {
        this.SYMBOL_PLAYER2 = SYMBOL_PLAYER2;
    }

    public String getCOLOR_PLAYER1() {
        return COLOR_PLAYER1;
    }

    public String getCOLOR_PLAYER2() {
        return COLOR_PLAYER2;
    }

    public String getSYMBOL_PLAYER1() {
        return SYMBOL_PLAYER1;
    }

    public String getSYMBOL_PLAYER2() {
        return SYMBOL_PLAYER2;
    }

    public void setAlternate(int alternate) {
        this.alternate = alternate;
    }

    public void initializebuttons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(this);

            add(buttons[i]);
        }
    }

    public void resetButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
            buttons[i].setBackground(null);
        }
        if(i == 1)
        {
            JOptionPane.showMessageDialog(this, "Ora inizia Giocatore "+(i+1));
            i--;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ora inizia Giocatore "+(i+1));
            i++;
        }

    }


    public void actionPerformed(ActionEvent e)
    {
        JButton buttonClicked = (JButton)e.getSource();

        if(getSYMBOL_PLAYER1().equals("X"))
        {
            if(alternate%2 == 0)
            {
                buttonClicked.setText("X");
                switch (getCOLOR_PLAYER1())
                {
                    case "Rosso":
                        buttonClicked.setBackground(Color.RED);
                        break;
                    case "Verde":
                        buttonClicked.setBackground(Color.green);
                        break;
                    case "Blu":
                        buttonClicked.setBackground(Color.blue);
                        break;
                }
            }
            else {
                buttonClicked.setText("O");
                switch (getCOLOR_PLAYER2())
                {
                    case "Rosso":
                        buttonClicked.setBackground(Color.RED);
                        break;
                    case "Verde":
                        buttonClicked.setBackground(Color.green);
                        break;
                    case "Blu":
                        buttonClicked.setBackground(Color.blue);
                        break;
                }
            }
        }
        else
        {
            if(alternate%2 == 0)
            {
                buttonClicked.setText("X");
                switch (getCOLOR_PLAYER2())
                {
                    case "Rosso":
                        buttonClicked.setBackground(Color.RED);
                        break;
                    case "Verde":
                        buttonClicked.setBackground(Color.green);
                        break;
                    case "Blu":
                        buttonClicked.setBackground(Color.blue);
                        break;
                }
            }
            else {
                buttonClicked.setText("O");
                switch (getCOLOR_PLAYER1())
                {
                    case "Rosso":
                        buttonClicked.setBackground(Color.RED);
                        break;
                    case "Verde":
                        buttonClicked.setBackground(Color.green);
                        break;
                    case "Blu":
                        buttonClicked.setBackground(Color.blue);
                        break;
                }
            }
        }


        if(checkForWin() == 1)
        {
            JOptionPane.showMessageDialog(null, "Vittoria! Gioco Terminato.");
            resetButtons();
        }
        else if(checkForWin()==3)
        {
            JOptionPane.showMessageDialog(null, "Nessun vincitore. Gioco Terminato.");
            resetButtons();
        }

        alternate++;

    }

    public int checkForWin()
    {
        int i=0;
        String s="";
        /**   Reference: the button array is arranged like this as the board
         *      0 | 1 | 2
         *      3 | 4 | 5
         *      6 | 7 | 8
         */
        //horizontal win check
        if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
            return 1;
        else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
            return 1;
        else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
            return 1;

            //vertical win check
        else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
            return 1;
        else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
            return 1;
        else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
            return 1;

            //diagonal win check
        else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
            return 1;
        else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
            return 1;

        for(i=0;i<9;i++)
        {
            s = buttons[i].getText();
            if (s.equals(""))
                return 2;
        }


        if (!checkAdjacent(0,1) && !checkAdjacent(1,2) && !checkAdjacent(3,4) &&
                !checkAdjacent(4,5) && !checkAdjacent(6,7) && !checkAdjacent(7,8) &&
                !checkAdjacent(0,3) && !checkAdjacent(3,6) && !checkAdjacent(1,4) && !checkAdjacent(4,7) &&
                !checkAdjacent(2,5) && !checkAdjacent(5,8) && !checkAdjacent(0,4) && !checkAdjacent(4,8) && !checkAdjacent(2,4) &&
                !checkAdjacent(4,6));
            return 3;
    }

    public boolean checkAdjacent(int a, int b)
    {
        if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
            return true;
        else
            return false;
    }
}