package graphics;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import animals.Animal;
/**
 * DecorateDialog
 * @author Gad Nadjar, Rudy Haddad
 */
public class DecorateDialog extends JDialog implements ItemListener, ActionListener {


    private String[] colors = {"Red", "Blue"};
    private Animal an = null;
    private int counter = 0;
    private int counter2 = 0;
    private JComboBox cSelectAnimal;
    private JComboBox cSelectColor;
    private ArrayList<Animal> animals;
    private ArrayList<Animal> naturalAnimals = new ArrayList<Animal>();
    JLabel selectAnimal;
    JLabel selectColor;
    JLabel confirmation;
    JButton bConfirmation;


    /**
     * create the dialog
     */
    public DecorateDialog() {
        this.setTitle("Decorate An Animal");
        setSize(600, 100);
        setBackground(new Color(100, 230, 255));
        this.animals = ZooPanel.getInstance().getAnimals();
        this.setLayout(new GridLayout(2, 2));
        this.setVisible(true);
        colors = new String[]{"Red", "Blue"};

        selectAnimal = new JLabel("Select Animal");
        selectColor = new JLabel("Select Color");
        confirmation = new JLabel("Confirm");

        cSelectAnimal = new JComboBox();
        cSelectColor = new JComboBox(colors);
        bConfirmation = new JButton("Confirm");

        this.add(selectAnimal);
        this.add(selectColor);
        this.add(confirmation);
        this.add(cSelectAnimal);
        this.add(cSelectColor);
        this.add(bConfirmation);

        cSelectColor.setSelectedIndex(-1);
        for (int i = 0; i < animals.size(); i++)
        {
            if (animals.get(i).getColor() == "Natural") {
                naturalAnimals.add(animals.get(i));
                String s=animals.get(i).getName()+": running=" +animals.get(i).IsRunning()+", weight="+animals.get(i).getWeight()+", color="+animals.get(i).getColor();
                cSelectAnimal.addItem(s);
            }
            cSelectAnimal.setSelectedIndex(-1);
        }


        cSelectAnimal.addActionListener(this);
        cSelectColor.addActionListener(this);
        bConfirmation.addActionListener(this);


    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cSelectAnimal)
        {
            counter = cSelectAnimal.getSelectedIndex();
        }

        if (e.getSource() == cSelectColor)
        {
            counter2 = cSelectColor.getSelectedIndex();
        }

        if (e.getSource() == bConfirmation)
        {
            if(cSelectAnimal.getSelectedIndex() == -1 || cSelectColor.getSelectedIndex() == -1)
                JOptionPane.showMessageDialog(null, "Selected All Characters", "Selected All Characters", JOptionPane.ERROR_MESSAGE);
            else
            {
                an = animals.get(counter);
                if (an != null)
                    an.PaintAnimal(colors[counter2]);
                this.dispose();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        int index = cSelectAnimal.getSelectedIndex();
        an = naturalAnimals.get(index);
    }

}





