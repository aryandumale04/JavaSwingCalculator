import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{



    JFrame frame;
    JButton[] numberbuttons = new JButton[10];// number buttons are anoymous matlab sabka alag naam nhi hai jaise 1 button ka alag variable name aur 2 ka alag jaise addbutton mulbutton wagera hai
    JButton[] functionbuttons=new JButton[9];
    JButton addbutton,subbutton,mulbutton,divbutton;
    JButton decbutton,clrbutton,delbutton,equbutton,negButton;
    JPanel panel;
    Font myfont = new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    JTextField textfield;


    calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addbutton=new JButton("+");
        subbutton=new JButton("-");
        mulbutton=new JButton("X");
        divbutton=new JButton("/");
        decbutton=new JButton(".");
        clrbutton=new JButton("Clear");
        equbutton=new JButton("=");
        delbutton=new JButton("Del");
        negButton=new JButton("(-)");

        functionbuttons[0]=addbutton;
        functionbuttons[1]=subbutton;
        functionbuttons[2]=mulbutton;
        functionbuttons[3]=divbutton;
        functionbuttons[4]=decbutton;
        functionbuttons[5]=equbutton;
        functionbuttons[6]=delbutton;
        functionbuttons[7]=clrbutton;
        functionbuttons[8]=negButton;


        for(int i=0;i<9;i++){
            functionbuttons[i].addActionListener(this);//funtional banaya usko (actionPerformed method call  hogi) lekin kya karega woh nhi abhi woh actionPerformed method me
            functionbuttons[i].setFont(myfont);
            functionbuttons[i].setFocusable(false);            

        }


        for(int i=0;i<10;i++){
            numberbuttons[i]=new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myfont);
            numberbuttons[i].setFocusable(false);

        }


        negButton.setBounds(50,430,100,50);
        delbutton.setBounds(150,430,100,50);
        clrbutton.setBounds(250,430,100,50);
        frame.add(delbutton);
        frame.add(clrbutton);
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addbutton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subbutton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mulbutton);
        panel.add(decbutton);
        panel.add(numberbuttons[0]);
        panel.add(equbutton);
        panel.add(divbutton);


        

        frame.add(panel);
        frame.add(negButton);

        frame.add(textfield);





        frame.setVisible(true);
    }

    public static void main(String [] args ){
        calculator cc=new calculator();

    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberbuttons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
            }
        if(e.getSource()==decbutton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addbutton){
            num1=Double.parseDouble(textfield.getText());
            operator= '+';
            textfield.setText("");

        }
        if(e.getSource()==subbutton){
            num1=Double.parseDouble(textfield.getText());
            operator= '-';
            textfield.setText("");

        }
        if(e.getSource()==mulbutton){
            num1=Double.parseDouble(textfield.getText());
            operator= 'X';
            textfield.setText("");

        }

        if(e.getSource()==divbutton){
            num1=Double.parseDouble(textfield.getText());
            operator= '/';
            textfield.setText("");

        }
        if(e.getSource()==equbutton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator){
            case '+':
                result=num1+num2;
                break;

            case '-':
            result=num1-num2;
            break;
            case'X':
            result=num1*num2;
            break;
            case'/':
            result=num1/num2;
            break;

            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrbutton){
            textfield.setText("");

        }
        if(e.getSource()==delbutton){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));

            }
        }
        if(e.getSource()==negButton){
            double temp=Double.parseDouble(textfield.getText());
            temp=temp*-1;
            textfield.setText(String.valueOf(temp));
        }


        

    }

}