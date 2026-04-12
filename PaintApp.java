package mygui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

enum ToolType {
    BRUSH, ERASER, LINE, RECTANGLE, OVAL
}

class CanvasPanel extends JPanel {

    private BufferedImage canvas;
    private Graphics2D g2;
     
    private int startX, startY, endX, endY;
    private ToolType currentTool = ToolType.BRUSH;
    private Color currentColor = Color.BLACK;
    private int brushSize = 3;

    public CanvasPanel() {
        setDoubleBuffered(false);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                if (currentTool != ToolType.BRUSH && currentTool != ToolType.ERASER) {
                    drawShape(e.getX(), e.getY());
                }
            }
        });

        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                if (g2 != null && (currentTool == ToolType.BRUSH || currentTool == ToolType.ERASER)) {
                    g2.setStroke(new BasicStroke(brushSize));
                    if (currentTool == ToolType.ERASER) {
                        g2.setPaint(Color.WHITE);
                    } else {
                        g2.setPaint(currentColor);
                    }
                    g2.drawLine(startX, startY, endX, endY);
                    repaint();
                    startX = endX;
                    startY = endY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (canvas == null) {
            canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            g2 = canvas.createGraphics();
            g2.setPaint(Color.WHITE);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setPaint(Color.BLACK);
        }
        g.drawImage(canvas, 0, 0, null);
    }

    private void drawShape(int x, int y) {
        g2.setPaint(currentColor);
        g2.setStroke(new BasicStroke(brushSize));

        int width = Math.abs(x - startX);
        int height = Math.abs(y - startY);

        int drawX = Math.min(startX, x);
        int drawY = Math.min(startY, y);

        switch (currentTool) {
            case LINE:
                g2.drawLine(startX, startY, x, y);
                break;
            case RECTANGLE:
                g2.drawRect(drawX, drawY, width, height);
                break;
            case OVAL:
                g2.drawOval(drawX, drawY, width, height);
                break;
        }
        repaint();
    }

    public void setTool(ToolType tool) {
        this.currentTool = tool;
    }

    public void setColor(Color color) {
        this.currentColor = color;
    }

    public void setBrushSize(int size) {
        this.brushSize = size;
    }

    public void clear() {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(currentColor);
        repaint();
    }

    public void saveImage() {
        try {
            File file = new File("drawing.png");
            ImageIO.write(canvas, "png", file);
            JOptionPane.showMessageDialog(this, "Saved as drawing.png");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class PaintApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaintApp().createUI());
    }

    private void createUI() {
        JFrame frame = new JFrame("Advanced Paint App made by Laiba Azeem");
        CanvasPanel canvas = new CanvasPanel();

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Toolbar
        JPanel toolbar = new JPanel();

        JButton brush = new JButton("Brush");
        JButton eraser = new JButton("Eraser");
       
        JButton line = new JButton("Line");
        JButton rect = new JButton("Rectangle");
        JButton oval = new JButton("Oval");
        JButton clear = new JButton("Clear");
        JButton save = new JButton("Save");

        String[] colors = {"Black", "Red", "Blue", "Green"};
        JComboBox<String> colorBox = new JComboBox<>(colors);

        JSlider sizeSlider = new JSlider(1, 20, 3);

        // Tool actions
        brush.addActionListener(e -> canvas.setTool(ToolType.BRUSH));
        eraser.addActionListener(e -> canvas.setTool(ToolType.ERASER));
        line.addActionListener(e -> canvas.setTool(ToolType.LINE));
        rect.addActionListener(e -> canvas.setTool(ToolType.RECTANGLE));
        oval.addActionListener(e -> canvas.setTool(ToolType.OVAL));

        clear.addActionListener(e -> canvas.clear());
        save.addActionListener(e -> canvas.saveImage());

        colorBox.addActionListener(e -> {
            String color = (String) colorBox.getSelectedItem();
            switch (color) {
                case "Red": canvas.setColor(Color.RED); break;
                case "Blue": canvas.setColor(Color.BLUE); break;
                case "Green": canvas.setColor(Color.GREEN); break;
                default: canvas.setColor(Color.BLACK);
            }
        });

        sizeSlider.addChangeListener(e -> canvas.setBrushSize(sizeSlider.getValue()));

        toolbar.add(brush);
        toolbar.add(eraser);
        toolbar.add(line);
        toolbar.add(rect);
        toolbar.add(oval);
        toolbar.add(colorBox);
        toolbar.add(new JLabel("Size"));
        toolbar.add(sizeSlider);
        toolbar.add(clear);
        toolbar.add(save);

        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(canvas, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
