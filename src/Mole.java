import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mole extends JPanel{
    ImageIcon imagenFondo = new ImageIcon("src/images/mole.png");
    Image imagen = imagenFondo.getImage();

    int posX = 0, posY = 0;
    int ancho = 100, alto = 110;
    int counter = 0;

    public Mole(){
        setOpaque(false);

        int margen = 50; // Aumenta el margen según sea necesario

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= posX - margen && e.getX() <= posX + ancho + margen &&
                    e.getY() >= posY - margen && e.getY() <= posY + alto + margen) {
                    System.out.println("¡Has presionado el topo!");
                    counter++;
                    if (counter == 3) {
                        JOptionPane.showMessageDialog(null, "Has Ganado!",
                            "Mole Game", JOptionPane.INFORMATION_MESSAGE);
                        counter = 0;
                    }
                }
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(posX, posY);
        g2d.drawImage(imagen, 0, 0, 100, 110, this);
    }

    public void getMolePosition(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        repaint();
    }
    
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
