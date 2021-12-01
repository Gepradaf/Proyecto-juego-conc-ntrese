package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.crypto.spec.PSource;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JRootPane;

public class Game extends javax.swing.JFrame implements MouseListener {

    private JPanel JPTitulo, JPanimales, JpRecuadro, JPpricipal, JPdatos;
    private JLabel Animal1, Animal2, Animal3, Animal4, Animal5, Animal6, Animal7, Animal8, Animal9, Animal10, Animal11, Animal12, labeltitulo, labelcontar, labeldatos, labelanimales, labelnombre, labelfondo;
    private JButton boton1;

    int cont, posicion1, posicion2, puntaje = 0;
    JLabel ArrayAnimales[] = new JLabel[12];//Almacena la imagenes de los animales
    int NumImagenes[] = new int[12];//guarda la identificacion de la imagenes que son numeros

    int AnimalesIguales[] = new int[6];//controla que un animal no se repitan mas de dos veces
    int AnimalesEncontrados[] = new int[12];//controla que una pareja encontrada no vuelva a salir mas
    int Contador[] = new int[12];//cuenta las veces que pulsamos el tablero de animales

    public Game() {

        initComponents();
        iniciarArray();
        setSize(600, 600); //tamaño de la interfaz del juego
        setResizable(false);//evita que usuario pueda redimencionar la interfaz
        setLocationRelativeTo(null); //aparece el tablero en la mitad de la pantalla
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);// cierra el programa para evitar que se quede funcionando en segundo plano
        setIconImage(getIconImage());// se encarga de mostar el icono del juego

    }

    //Permite colocar el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        labeltitulo = new JLabel();
        labeltitulo.setFont(new java.awt.Font("Andale Mono", 1, 90));
        labeltitulo.setForeground(new Color(66, 40, 116));
        labeltitulo.setText("Concéntrese");
        labeltitulo.addMouseListener(this);
        labeltitulo.setVisible(true);

        boton1 = new JButton();
        boton1.setFont(new java.awt.Font("Andale Mono", 1, 30));
        boton1.setText("Reiniciar ");
        boton1.setForeground(new Color(66, 40, 116));
        boton1.setBackground(new Color(255, 255, 0));
        boton1.setBounds(55, 290, 170, 50);
        boton1.addMouseListener(this);

        labelcontar = new JLabel();
        labelcontar.setFont(new java.awt.Font("Andale Mono", 1, 44));
        labelcontar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcontar.setForeground(Color.yellow);
        labelcontar.setText("Puntaje");
        labelcontar.setBounds(50, 0, 170, 190);

        labeldatos = new JLabel();
        labeldatos.setFont(new java.awt.Font("Andale Mono", 1, 120));
        labeldatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeldatos.setForeground(new Color(60, 40, 116));
        labeldatos.setText("0");
        labeldatos.setBounds(50, 120, 170, 130);

        Animal1 = new JLabel();
        Animal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal1.setBounds(2, -20, 160, 160);

        Animal2 = new JLabel();
        Animal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal2.setBounds(125, -20, 160, 160);

        Animal3 = new JLabel();
        Animal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal3.setBounds(247, -20, 160, 160);

        Animal4 = new JLabel();
        Animal4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal4.setBounds(2, 88, 160, 160);

        Animal5 = new JLabel();
        Animal5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal5.setBounds(125, 88, 160, 160);

        Animal6 = new JLabel();
        Animal6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png")));//obtiene la imagenes que tienen la pregunta
        Animal6.setBounds(247, 88, 160, 160);

        Animal7 = new JLabel();
        Animal7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal7.setBounds(2, 195, 160, 160);

        Animal8 = new JLabel();
        Animal8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal8.setBounds(125, 195, 160, 160);

        Animal9 = new JLabel();
        Animal9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal9.setBounds(247, 195, 160, 160);

        Animal10 = new JLabel();
        Animal10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal10.setBounds(2, 325, 160, 116);

        Animal11 = new JLabel();
        Animal11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal11.setBounds(125, 303, 160, 160);

        Animal12 = new JLabel();
        Animal12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pregunta.png"))); //obtiene la imagenes que tienen la pregunta
        Animal12.setBounds(247, 303, 160, 160);

        JPanimales = new JPanel();//panel que contienen los recuadros de las imagenes de los animales
        JPanimales.setBackground(new Color(40, 163, 64));
        JPanimales.setLayout(null);
        JPanimales.setBounds(0, 10, 370, 530);
        JPanimales.add(Animal1);
        JPanimales.add(Animal2);
        JPanimales.add(Animal3);
        JPanimales.add(Animal4);
        JPanimales.add(Animal5);
        JPanimales.add(Animal6);
        JPanimales.add(Animal7);
        JPanimales.add(Animal8);
        JPanimales.add(Animal9);
        JPanimales.add(Animal10);
        JPanimales.add(Animal11);
        JPanimales.add(Animal12);

        JPTitulo = new JPanel();// panel que tiene el titulo
        JPTitulo.setBackground(new Color(40, 163, 64));
        JPTitulo.add(labeltitulo);

        JPdatos = new JPanel(); // permite que se muesten el muntaje el boton reiniciar
        JPdatos.setBackground(new Color(40, 163, 64));
        JPdatos.setLayout(null);
        JPdatos.setBounds(340, 80, 280, 460);
        JPdatos.add(boton1);
        JPdatos.add(labelcontar);
        JPdatos.add(labeldatos);

        JpRecuadro = new JPanel();// almacena los animales imagnes
        JpRecuadro.setBackground(new Color(40, 163, 64));
        JpRecuadro.setLayout(null);
        JpRecuadro.add(JPanimales);
        JpRecuadro.add(JPdatos);

        add(JpRecuadro, java.awt.BorderLayout.CENTER);// aparece el recuado de animales en el centro
        add(JPTitulo, java.awt.BorderLayout.PAGE_START); //titulo arriba y en el centro de la pantalla

        pack();
    }

    // Array que verifican y mezclan las imagenes
    private void iniciarArray() {

        Iniciararrayanimales();

        //inicializa los arreglos en cero
        llenaArreglosConCeros(AnimalesIguales);
        llenaArreglosConCeros(NumImagenes);
        llenaArreglosConCeros(AnimalesEncontrados);
        llenaArreglosConCeros(Contador);

        Random r = new Random();//permite la generacion de numeros aleatorios
        int posicionImagen;

        for (int i = 0; i < 12; i++) {
        
            posicionImagen = r.nextInt(6);//la posicionImagen tendra un valor aleatorio entre 0 y 5, es decir, 6 valores posibles
            /*Se valida que el numero aleatorio solo se repita 2 veces*/
            if (AnimalesIguales[posicionImagen] < 2) {
                NumImagenes[i] = posicionImagen + 1;//almacena el valor que representa cada imagen (la imagen se llama con su numero), se suma 1 porq si el numero es 0 entonces queda en 1
                System.out.print(NumImagenes[i] + " , ");
                AnimalesIguales[posicionImagen]++;//si se almacena el numero entonces se aumenta el valor para que sepamos que ya existe 1 vez
            } else {
                i--;//en caso de que el numero se repita entonces se devuelve una iteraciòn para que pueda continuar pidiendo numeros
            }
        }

    }

    //Asigna a cada recuadro de la pregunta 
    private void Iniciararrayanimales() {
        ArrayAnimales[0] = Animal1;
        ArrayAnimales[1] = Animal2;
        ArrayAnimales[2] = Animal3;
        ArrayAnimales[3] = Animal4;
        ArrayAnimales[4] = Animal5;
        ArrayAnimales[5] = Animal6;
        ArrayAnimales[6] = Animal7;
        ArrayAnimales[7] = Animal8;
        ArrayAnimales[8] = Animal9;
        ArrayAnimales[9] = Animal10;
        ArrayAnimales[10] = Animal11;
        ArrayAnimales[11] = Animal12;

        int i = 0;
        while (i < 12) {
            ArrayAnimales[i].setIcon(new ImageIcon(getClass().getResource("/imagenes/Pregunta.png")));
            ArrayAnimales[i].addMouseListener(this);
            i++;
        }
    }

    // Inicia y permite comparar la parejas de animales usando dos posiciones posicion 1 y posicion 2
    private void llenaArreglosConCeros(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
    }

    private void Comprobarparejasdeanimales(int posicion1, int posicion2, int i) {
        //comprueba si el valor de la primera imgen encontrada es igual al de la imagen 2
        if (NumImagenes[posicion1] == NumImagenes[posicion2]) {
            //Si son iguales otorga un puntaje de 10 puntos por cada pareja encontrada
            puntaje += 10;
            labeldatos.setText(puntaje + "");
            AnimalesEncontrados[posicion1] = 1;
            AnimalesEncontrados[posicion2] = 1;
        } else {
            //si no son iguales tapa esconde la imagen otra vez y cuenta el numero de pulsaciones
            ArrayAnimales[posicion1].setIcon(new ImageIcon(getClass().getResource("/imagenes/Pregunta.png")));
            ArrayAnimales[posicion2].setIcon(new ImageIcon(getClass().getResource("/imagenes/Pregunta.png")));
            Contador[posicion1] = 0;
            Contador[posicion2] = 0;
        }
    }

    // click de seleccion de las imagenes
    @Override
    public void mouseClicked(MouseEvent e) {
        /*Logica para el evento del botòn iniciar*/
        if (e.getSource() == boton1) {
            iniciarArray();
            cont = 0;
            puntaje = 0;
            labeldatos.setText("0");
        }

        /*Ciclo que permite recorrer todos los JLabel del arreglo y determinar cuando uno fue presionado*/
        for (int i = 0; i < 12; i++) {
            /*Con esta validacion nos damos cuenta de cual label se presionò y validamos que
			 *si es un label que ya esta descubierto porque su pareja fue encontrada, entonces no
			 *lo tenga en cuenta para validar mas parejas, pues esta ya fue encontrada */
            if (e.getSource() == ArrayAnimales[i] && verificaParejasEncontradas(i)) {
                Contador[i]++;//si se presiona 2 veces seguidas un label, se incrementa la posicion del arreglo
                /*se valida que el mismo label no se presionara mas de dos veces seguidas, si esto es asì
				 * el sistema espera hasta que se presione otro label para poder validar parejas*/
                if (Contador[i] < 2) {
                    /*si lleva menos de 2 clic en un mismo label entonces se muestra la imagen*/
                    cont++;
                    ArrayAnimales[i].setIcon(new ImageIcon(getClass().getResource("/imagenes/" + NumImagenes[i] + ".png")));
                    if (cont == 1) {
                        posicion1 = i;//si se lleva 1 clic se almacena en una variable la posicion de la imagen para luego ser comparada con la posicion de la segunda
                    } else {
                        posicion2 = i;//si se llevan 2 clic se almacena en una variable la posicion de la segunda imagen para luego compararla con la primera	
                    }
                }
            }

        }
    }

    // Indica la posicion enq eu ya se encontro una imagen solo va hasta 1
    private boolean verificaParejasEncontradas(int i) {

        if (AnimalesEncontrados[i] != 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //valida los animales cuando ya se ha encontrado la pareja

        int i = 0;
        while (i < 12) {

            if (e.getSource() == ArrayAnimales[i]) {
                if (cont == 2) {
                    Comprobarparejasdeanimales(posicion1, posicion2, i);
                    cont = 0;
                }
            }
            i++;

        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}
