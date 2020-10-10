/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somadenumerosaleatorios;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;



public class SomaDeNumerosAleatorios extends JFrame {
    private FlowLayout layout;
    private Container container;
    
    public SomaDeNumerosAleatorios()
	{
            
            super("Soma De Numeros Aleatorios");
            JOptionPane.showMessageDialog(null, "Se somarmos dois numeros aleatorios, o resultado dessa soma é mais previsivel ou mais 'Aleatorio' ainda ? \n Este é o objetivo deste simples programa, demonstrar na pratica o resultado. Faça sua aposta e pressione 'OK'");
            
            int qtdNumeros;
            layout = new FlowLayout();
            container = getContentPane();
            setLayout(layout);
                
            JButton btn = new JButton("Gerar números aleatórios");
            JButton btnApagar = new JButton("Zerar valores");
            Random aleatorio = new Random();
            
                       
            String inputValue = JOptionPane.showInputDialog("Digite a quantidade de números desejados");
            while (!inputValue.matches("^[0-9]*$")) {                
                JOptionPane.showMessageDialog(null, "Digite apenas números! ");
                inputValue = JOptionPane.showInputDialog("Digite a quantidade de números desejados");
            }
            qtdNumeros = Integer.parseInt(inputValue);
            
            JOptionPane.showMessageDialog(null,"Na proxima tela, pressione o botão para gerar os numeros aleatórios, ou pressione a tecla 'ENTER'");
            
                        
            
            List<JProgressBar> pb = new ArrayList<>();
            for (int i = 0; i < qtdNumeros; i++) {
               pb.add(i, new JProgressBar(JProgressBar.VERTICAL,0, qtdNumeros));
               pb.get(i).setString("" + i);
               pb.get(i).setStringPainted(true);
               pb.get(i).setBackground(Color.black);
               pb.get(i).setForeground(Color.green);
               add(pb.get(i));
            }
            
            
            add(btn);
            add(btnApagar);
            
            btnApagar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    pb.forEach((n) -> n.setValue(0));
                    container.requestFocus();
                }
            });
            
            
            btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    int n1Aleatorio,n2Aleatorio,aux,a,b;
                    a= qtdNumeros/2;
                    b = qtdNumeros/2 +1;
                    n1Aleatorio = aleatorio.nextInt(a);
                    n2Aleatorio = aleatorio.nextInt(b);
                    System.out.println(n1Aleatorio +" + "+ n2Aleatorio + " = " + (n1Aleatorio+n2Aleatorio));
                    aux = n1Aleatorio + n2Aleatorio;
                    pb.get(aux).setValue( pb.get(aux).getValue() + 1);
                    container.requestFocus();
                }
		}
            );
            
            
            
            setSize(400, 250);
            setVisible( true );
            container.setFocusable(true);
            
            container.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent ke) {
                    
                }
                @Override
                public void keyPressed(KeyEvent ke) {
                      
                    int n1Aleatorio,n2Aleatorio,aux,a,b;
                    a= qtdNumeros/2;
                    b = qtdNumeros/2 +1;
                    n1Aleatorio = aleatorio.nextInt(a);
                    n2Aleatorio = aleatorio.nextInt(b);
                    System.out.println(n1Aleatorio +" + "+ n2Aleatorio + " = " + (n1Aleatorio+n2Aleatorio));
                    aux = n1Aleatorio + n2Aleatorio;
                    pb.get(aux).setValue( pb.get(aux).getValue() + 1);
                    
                    
                }
                @Override
                public void keyReleased(KeyEvent ke) {

                }
            });
            
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                fechar();
            }
});
            
	}
    
    public static void main(String[] args) {
        
        new SomaDeNumerosAleatorios();    
    } 

    public void fechar(){
        JOptionPane.showMessageDialog(null,"Agora que viu na pratica que o resultado da soma pode ser mais previsivel, vamos a uma breve explicação. \n O resultado é mais previsivel no meio do intervalo selecionado, pois as probabilidades de a soma dar esses numeros são maiores. Por exemplo, num intervalo de 10 numeros, de 0 a 9, para que a soma dê 0 os dois numeros aleatorios tem que ser 0. Mas para a soma resultar em 4 por exemplo, as combinações podem ser 0+4, 1+3, 2+2, 3+1, 4+0");
        dispose();
    }
}
