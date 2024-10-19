import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Field {
    public Mole mole = new Mole();
    public Animacion movement = new Animacion(mole);
    private BufferedImage textura;

    public Field() {
        JFrame frame = new JFrame("Reloj análogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 600);

    
       
        Image cursorImage = new ImageIcon("src/images/mazo.png").getImage();

        // Crear un cursor personalizado
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,
                new java.awt.Point(0, 0), "Custom Cursor");

        frame.setCursor(customCursor);

        // Crear la textura solo con líneas
        textura = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = textura.createGraphics();

        

        // Configurar el color de las líneas
        g2d.setColor(Color.DARK_GRAY);
        
        // Dibujar líneas diagonales en la textura
        g2d.drawLine(0, 0, 20, 20);
        g2d.drawLine(0, 20, 20, 0);
        g2d.drawLine(0, 10, 20, 10);
        g2d.drawLine(10, 0, 10, 20);

        g2d.dispose(); // Liberar recursos gráficos

        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                Graphics2D g2d = (Graphics2D) g;

                // Crear un degradado que va de azul a verde
                GradientPaint degradado = new GradientPaint(
                        0, 0, new Color(0x4DD133),
                        0, getHeight(), new Color(0x2A4D14)
                );

                g2d.setPaint(degradado);
                g2d.fillRect(0, 100, getWidth(), getHeight());

                // Dibujar la textura sobre el degradado
                for (int x = 0; x < getWidth(); x += textura.getWidth()) {
                    for (int y = 0; y < getHeight(); y += textura.getHeight()) {
                        g2d.drawImage(textura, x, y, this);
                    }
                }

                
                
                g.setColor(new Color(0xAA6C4D));
                g.fillOval(80, 140, 170, 70);

                g.setColor(Color.black);
                g.fillOval(85, 145, 160, 60);

                // /----------------------------------------------------------/ 

                g.setColor(new Color(0xAA6C4D));
                g.fillOval(320, 180, 170, 70);

                g.setColor(Color.black);
                g.fillOval(325, 185, 160, 60);


               // /----------------------------------------------------------/ 

               g.setColor(new Color(0xAA6C4D));
               g.fillOval(560, 150, 170, 70);

               g.setColor(Color.black);
               g.fillOval(565, 155, 160, 60);


                // /----------------------------------------------------------/ 

                // ----------------------------------------------------------------------------- 

                g.setColor(new Color(0xAA6C4D));
                g.fillOval(50, 340, 170, 70);

                g.setColor(Color.black);
                g.fillOval(55, 345, 160, 60);

                // /----------------------------------------------------------/ 

                g.setColor(new Color(0xAA6C4D));
                g.fillOval(320, 380, 170, 70);

                g.setColor(Color.black);
                g.fillOval(325, 385, 160, 60);


               // /----------------------------------------------------------/ 

               g.setColor(new Color(0xAA6C4D));
               g.fillOval(600, 350, 170, 70);

               g.setColor(Color.black);
               g.fillOval(605, 355, 160, 60);
            }
        };

        fondo.setBackground(new Color(0x284ED6));

        frame.setLayout(null); 
        frame.setContentPane(fondo);

        
        fondo.setBounds(0, 0, 820, 600);
        mole.setBounds(0, 0, 820, 600);
    
        
        frame.add(mole);
    
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
        movement.start();
    }
}
