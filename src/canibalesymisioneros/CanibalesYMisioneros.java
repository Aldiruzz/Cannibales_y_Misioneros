package canibalesymisioneros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanibalesYMisioneros extends JFrame implements ActionListener {
    private JLabel canniMeta, canniInit, misioMeta, misioInit, numMisioMeta, numMisioInit, numCanniMeta, numCanniInit;
    private JLabel balsa1, balsaP1, balsaP2, lbEstado;
    private JLabel balsa2, balsaP3, balsaP4;
    private JButton btnMisioneros1, btnCanibal1, btnMisioneros2, btnCanibal2, btnBarco;
    private JButton btnMisionerosBalsa, btnCanibalBalsa;
    private Image misionero, canibal, background, barco;
    private ImageIcon iconCanibal, iconMisionero, iconBackground, iconBarco;
    private JLabel backImage;
    
    int countCannMeta = 0, countMissMeta = 0;
    int countCannStart = 3, countMissStart = 3;
    int countMisBalsa = 0, countCannBalsa = 0;
    boolean balsaMeta = false;
        
    public static void main(String[] args) {
        CanibalesYMisioneros CYM = new CanibalesYMisioneros();
        CYM.setVisible(true);
        CYM.setBounds(100, 100, 580, 400);
        CYM.setTitle("Canibales y Misioneros");
        CYM.setResizable(false);
        CYM.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    CanibalesYMisioneros(){
        background = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/background.jpg")).getScaledInstance(580, 400, java.awt.Image.SCALE_SMOOTH);
        iconBackground = new ImageIcon(background);
        backImage = new JLabel();
        backImage.setIcon(iconBackground);
        backImage.setBounds(0, 0, 580, 400);
        loadImages();
        personajesMeta();
        personajesInit();
        balsa();
        labels();
        botones();
        add(backImage);
    }
    void labels(){ //se inicializan y colocan los labels
        Font font = new Font("Verdana", Font.BOLD, 32);
        numMisioInit = new JLabel(""+countMissStart);
        numMisioInit.setBounds(510, 120, 50, 50);
        numMisioInit.setFont(font);
        numMisioInit.setForeground(Color.WHITE);
        numMisioInit.setBackground(new Color(30, 34, 35));
        add(numMisioInit);
        
        numMisioMeta = new JLabel(""+countMissMeta);
        numMisioMeta.setBounds(60, 120, 50, 50);
        numMisioMeta.setFont(font);
        numMisioMeta.setForeground(Color.WHITE);
        numMisioMeta.setBackground(new Color(30, 34, 35));
        add(numMisioMeta);
        
        numCanniMeta = new JLabel(""+countCannMeta);
        numCanniMeta.setBounds(60, 200, 50, 50);
        numCanniMeta.setFont(font);
        numCanniMeta.setForeground(Color.WHITE);
        numCanniMeta.setBackground(new Color(30, 34, 35));
        add(numCanniMeta);
        
        numCanniInit = new JLabel(""+countCannStart);
        numCanniInit.setBounds(510, 200, 50, 50);
        numCanniInit.setFont(font);
        numCanniInit.setForeground(Color.WHITE);
        numCanniInit.setBackground(new Color(30, 34, 35));
        add(numCanniInit);
        
        
        lbEstado = new JLabel("");
        lbEstado.setBounds(220, 120, 200, 45);
        lbEstado.setFont(font);
        lbEstado.setBackground(Color.WHITE);
        lbEstado.setForeground(Color.BLACK);
        add(lbEstado);
        lbEstado.setVisible(false);
    }
    
    void botones() { // se inicializan y colocan los botones
        btnMisioneros1 = new JButton("Misionero +");
        btnMisioneros1.setBounds(450, 180, 110, 25);
        btnMisioneros1.setForeground(Color.WHITE);
        btnMisioneros1.setBackground(new Color(150, 200, 150));
        btnMisioneros1.setBorderPainted(false);
        add(btnMisioneros1);
        btnMisioneros1.addActionListener(this);
        
        btnCanibal1 = new JButton("Cannibal +");
        btnCanibal1.setBounds(450, 270, 100, 25);
        btnCanibal1.setForeground(Color.WHITE);
        btnCanibal1.setBackground(new Color(150, 200, 150));
        btnCanibal1.setBorderPainted(false);
        add(btnCanibal1);
        btnCanibal1.addActionListener(this);
        
        btnMisioneros2 = new JButton("Misionero +");
        btnMisioneros2.setBounds(20, 180, 110, 25);
        btnMisioneros2.setForeground(Color.WHITE);
        btnMisioneros2.setBackground(new Color(150, 200, 150));
        btnMisioneros2.setBorderPainted(false);
        add(btnMisioneros2);
        btnMisioneros2.addActionListener(this);
        
        btnCanibal2 = new JButton("Cannibal +");
        btnCanibal2.setBounds(20, 270, 100, 25);
        btnCanibal2.setForeground(Color.WHITE);
        btnCanibal2.setBackground(new Color(150, 200, 150));
        btnCanibal2.setBorderPainted(false);
        add(btnCanibal2);
        btnCanibal2.addActionListener(this);
        
        btnBarco = new JButton("Cruzar");
        btnBarco.setBounds(240, 260, 100, 30);
        btnBarco.setForeground(Color.WHITE);
        btnBarco.setBackground(new Color(120, 120, 240));
        btnBarco.setBorderPainted(false);
        add(btnBarco);
        btnBarco.addActionListener(this);
        
        btnCanibalBalsa = new JButton("Baja Cannibal");
        btnCanibalBalsa.setBounds(310, 300, 120, 30);
        btnCanibalBalsa.setForeground(Color.WHITE);
        btnCanibalBalsa.setBackground(new Color(90, 90, 220));
        btnCanibalBalsa.setBorderPainted(false);
        add(btnCanibalBalsa);
        btnCanibalBalsa.addActionListener(this);
        
        btnMisionerosBalsa = new JButton("Baja Misionero");
        btnMisionerosBalsa.setBounds(130, 300, 120, 30);
        btnMisionerosBalsa.setForeground(Color.WHITE);
        btnMisionerosBalsa.setBackground(new Color(90, 90, 220));
        btnMisionerosBalsa.setBorderPainted(false);
        add(btnMisionerosBalsa);
        btnMisionerosBalsa.addActionListener(this);
    }
    
    void loadImages(){
        misionero = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/misionero.png")).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        iconMisionero = new ImageIcon(misionero);
        canibal = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/cannibal.png")).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        iconCanibal = new ImageIcon(canibal);
        barco = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/barco.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        iconBarco = new ImageIcon(barco);
    }
    
    void personajesMeta(){
        canniMeta = new JLabel();
        canniMeta.setIcon(iconCanibal);
        canniMeta.setBounds(80, 200, 70, 70);
        add(canniMeta);
        
        misioMeta = new JLabel();
        misioMeta.setIcon(iconMisionero);
        misioMeta.setBounds(80, 120, 70, 70);
        add(misioMeta);
    }
    void personajesInit(){
        canniInit = new JLabel();
        canniInit.setIcon(iconCanibal);
        canniInit.setBounds(450, 200, 70, 70);
        add(canniInit);
        
        misioInit = new JLabel();
        misioInit.setIcon(iconMisionero);
        misioInit.setBounds(450, 120, 70, 70);
        add(misioInit);
    }
    void balsa(){
        //balsa 1
        balsa1 = new JLabel();
        balsa1.setIcon(iconBarco);
        balsa1.setBounds(330, 160, 100, 100);
        
        balsaP1 = new JLabel();
        balsaP1.setIcon(iconCanibal); //inicializado con cannibal, se debe cambiar
        balsaP1.setBounds(330, 160, 70, 70);
        add(balsaP1);
        balsaP1.setVisible(false);
        
        balsaP2 = new JLabel();
        balsaP2.setIcon(iconMisionero); //inicializado con misionero, se debe cambiar
        balsaP2.setBounds(370, 160, 70, 70);
        add(balsaP2);
        balsaP2.setVisible(false);
        
        add(balsa1);
        
        //balsa 2
        balsa2 = new JLabel();
        balsa2.setIcon(iconBarco);
        balsa2.setBounds(150, 160, 100, 100);
        
        balsaP3 = new JLabel();
        balsaP3.setIcon(iconCanibal); //inicializado con cannibal, se debe cambiar
        balsaP3.setBounds(150, 160, 70, 70);
        add(balsaP3);
        balsaP3.setVisible(false);
        
        balsaP4 = new JLabel();
        balsaP4.setIcon(iconMisionero); //inicializado con misionero, se debe cambiar
        balsaP4.setBounds(180, 160, 70, 70);
        add(balsaP4);
        balsaP4.setVisible(false);
        
        add(balsa2);
        balsa2.setVisible(false);
    }
    
    void perdiste(){
        lbEstado.setText("PERDISTE");
        lbEstado.setVisible(true);
        btnBarco.setVisible(false);
        btnCanibal1.setVisible(false);
        btnCanibal2.setVisible(false);
        btnCanibalBalsa.setVisible(false);
        btnMisioneros1.setVisible(false);
        btnMisioneros2.setVisible(false);
        btnMisionerosBalsa.setVisible(false);
    }
    
    void ganaste(){
        lbEstado.setText("GANASTE");
        lbEstado.setVisible(true);
        btnBarco.setVisible(false);
        btnCanibal1.setVisible(false);
        btnCanibal2.setVisible(false);
        btnCanibalBalsa.setVisible(false);
        btnMisioneros1.setVisible(false);
        btnMisioneros2.setVisible(false);
        btnMisionerosBalsa.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMisioneros1) {
            if(!balsaMeta && countMissStart>0){
                if((countCannBalsa+countMisBalsa) < 2){
                    countMisBalsa++;
                    countMissStart--;
                    if(countCannBalsa == 0){
                        balsaP1.setIcon(iconMisionero);
                        balsaP1.setVisible(true);
                        if(countMisBalsa == 2){
                            balsaP2.setIcon(iconMisionero);
                            balsaP2.setVisible(true);
                        }
                    }else{
                        balsaP2.setIcon(iconMisionero);
                        balsaP2.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == btnMisioneros2) {
            if(balsaMeta && countMissMeta>0){
                if((countCannBalsa+countMisBalsa) < 2){
                    countMisBalsa++;
                    countMissMeta--;
                    if(countCannBalsa == 0){
                        balsaP1.setIcon(iconMisionero);
                        balsaP1.setVisible(true);
                        if(countMisBalsa == 2){
                            balsaP2.setIcon(iconMisionero);
                            balsaP2.setVisible(true);
                        }
                    }else{
                        balsaP2.setIcon(iconMisionero);
                        balsaP2.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == btnCanibal1) {
            if(!balsaMeta  && countCannStart>0){
                if((countCannBalsa+countMisBalsa) < 2){
                    countCannBalsa++;
                    countCannStart--;
                    if(countMisBalsa == 0){
                        balsaP1.setIcon(iconCanibal);
                        balsaP1.setVisible(true);
                        if(countCannBalsa == 2){
                            balsaP2.setIcon(iconCanibal);
                            balsaP2.setVisible(true);
                        }
                    }else{
                        balsaP2.setIcon(iconCanibal);
                        balsaP2.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == btnCanibal2) {
            if(balsaMeta  && countCannMeta>0){
                if((countCannBalsa+countMisBalsa) < 2){
                    countCannBalsa++;
                    countCannMeta--;
                    if(countMisBalsa == 0){
                        balsaP3.setIcon(iconCanibal);
                        balsaP3.setVisible(true);
                        if(countCannBalsa == 2){
                            balsaP4.setIcon(iconCanibal);
                            balsaP4.setVisible(true);
                        }
                    }else{
                        balsaP4.setIcon(iconCanibal);
                        balsaP4.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == btnBarco) {
            if ((countCannBalsa + countMisBalsa) != 0){
            if(balsaMeta){
                balsaMeta=false;
                balsa1.setVisible(true);
                balsa2.setVisible(false);
                if(balsaP3.isVisible()){
                    balsaP1.setIcon(balsaP3.getIcon()); // metodo de cambio
                    balsaP3.setVisible(false);
                    balsaP1.setVisible(true);
                }
                if(balsaP4.isVisible()){
                    balsaP2.setIcon(balsaP4.getIcon()); // metodo de cambio
                    balsaP4.setVisible(false);
                    balsaP2.setVisible(true);
                }
                if((countCannMeta>countMissMeta && countMissMeta > 0) 
                    || ((countCannBalsa+countCannStart) > (countMisBalsa + countMissStart) && (countMisBalsa + countMissStart) > 0)){
                    //Se evalua dos cosas, la meta y el inicio, 
                    //Si en la meta hay mas canibales que misioneros y misioneros son mas que 0, perdiste
                    //Si en el inicio hay mas canibales en la suma de la costa y la balsa que los misioneros en la costa y balsa,
                    //   mas aparte si los misioneros son mas que cero, entonces perdiste
                    perdiste();
                }
            }else{
                balsaMeta=true;
                balsa1.setVisible(false);
                balsa2.setVisible(true);
                if(balsaP1.isVisible()){
                    balsaP3.setIcon(balsaP1.getIcon()); // metodo de cambio
                    balsaP1.setVisible(false);
                    balsaP3.setVisible(true);
                }
                if(balsaP2.isVisible()){
                    balsaP4.setIcon(balsaP2.getIcon()); // metodo de cambio
                    balsaP2.setVisible(false);
                    balsaP4.setVisible(true);
                }
                if((countCannStart>countMissStart && countMissStart > 0) 
                    || ((countCannBalsa+countCannMeta) > (countMisBalsa + countMissMeta) && (countMisBalsa + countMissMeta) > 0)){ 
                    //Se evalua dos cosas, la meta y el inicio, 
                    //Si en el inicio hay mas canibales que misioneros y misioneros son mas que 0, perdiste
                    //Si en la meta hay mas canibales en la suma de la costa y la balsa que los misioneros en la costa y balsa,
                    //   mas aparte si los misioneros son mas que cero, entonces perdiste
                    perdiste();
                }
            }
        }
        }
        if (e.getSource() == btnMisionerosBalsa) {
            if((countMisBalsa) > 0){
                if(balsaMeta){
                    //por estar en la costa meta, se le suma a la meta
                    countMissMeta++; 
                    if(countCannMeta == 3 && countMissMeta == 3){ // condicion de victoria
                        ganaste();
                    }
                    //evaluamos si hay misioneros en la balsa
                    if(countCannBalsa == 0){ 
                        // evaluamos si hay dos Misioneros en la balsa
                        if(countMisBalsa == 2){ 
                            balsaP4.setVisible(false);
                        }else{
                            balsaP3.setVisible(false);
                        }
                    }else {
                        //aqui le preguntamos cual de los dos es el misionero
                        if(balsaP3.getIcon().equals(iconMisionero)){ 
                            balsaP3.setVisible(false);
                        }else{
                            balsaP4.setVisible(false);
                        }
                    }
                }else{
                    //por estar en la costa inicial, se le suma al inicio
                    countMissStart++; 
                    //evaluamos si hay misioneros en la balsa
                    if(countCannBalsa == 0){ 
                        // evaluamos si hay dos Misioneros en la balsa
                        if(countMisBalsa == 2){ 
                            balsaP2.setVisible(false);
                        }else{
                            balsaP1.setVisible(false);
                        }
                    }else {
                        //aqui le preguntamos cual de los dos es el misionero
                        if(balsaP1.getIcon().equals(iconMisionero)){ 
                            balsaP1.setVisible(false);
                        }else{
                            balsaP2.setVisible(false);
                        }
                    }
                }
                countMisBalsa--; // se le quita el misionero de la balsa despues de la evaluacion de iconos
            }
        }
        if (e.getSource() == btnCanibalBalsa) {
            if((countCannBalsa) > 0){
                if(balsaMeta){
                    //por estar en la costa meta, se le suma a la meta
                    countCannMeta++; 
                    if(countCannMeta == 3 && countMissMeta == 3){ // condicion de victoria
                        ganaste();
                    }
                    if(countMisBalsa == 0){
                        // evaluamos si hay dos cannibales en la balsa
                        if(countCannBalsa == 2){ 
                            balsaP4.setVisible(false);
                        }else{
                            balsaP3.setVisible(false);
                        }
                    }else {
                        //aqui le preguntamos cual de los dos es el cannibal
                        if(balsaP3.getIcon().equals(iconCanibal)){ 
                            balsaP3.setVisible(false);
                        }else{
                            balsaP4.setVisible(false);
                        }
                    }
                }else{
                    //por estar en la costa inicial, se le suma al inicio
                    countCannStart++; 
                    //evaluamos si hay misioneros en la balsa
                    if(countMisBalsa == 0){ 
                        // evaluamos si hay dos cannibales en la balsa
                        if(countCannBalsa == 2){ 
                            balsaP2.setVisible(false);
                        }else{
                            balsaP1.setVisible(false);
                        }
                    }else {
                        //aqui le preguntamos cual de los dos es el cannibal
                        if(balsaP1.getIcon().equals(iconCanibal)){ 
                            balsaP1.setVisible(false);
                        }else{
                            balsaP2.setVisible(false);
                        }
                    }
                } // terminino de la evaluacion de costas e iconos
                countCannBalsa--; // se le quita el cannibal de la balsa despues de la evaluacion de iconos
            }
        }
        redibujar();
    }
    void redibujar(){
        numCanniInit.setText(""+countCannStart);
        numCanniMeta.setText(""+countCannMeta);
        numMisioInit.setText(""+countMissStart);
        numMisioMeta.setText(""+countMissMeta);
    }
}
