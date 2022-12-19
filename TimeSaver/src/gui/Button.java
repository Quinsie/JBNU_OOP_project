package gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JButton;

/* needed custom button class */
public class Button extends JButton
{
	private static final long serialVersionUID = 4080594060520438244L;
	
	// constructor
	public Button() {
		super();
		decorate();
	}
	public Button(String text) {
        super(text);
        decorate();
    }
    public Button(Icon icon) {
        super(icon);
        decorate();
    }
    public Button(String text, Icon icon) {
        super(text, icon);
        decorate();
    }
	
    // Methods
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	
	// https://the-illusionist.me/42 << code
	protected void paintComponent(Graphics g) {
	    int width = getWidth();
	    int height = getHeight();

	    Graphics2D graphics = (Graphics2D) g;

	    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    if (getModel().isArmed()) {
	        graphics.setColor(new Color(141, 191, 214).darker());
	    } else if (getModel().isRollover()) {
	        graphics.setColor(new Color(141, 191, 214).brighter());
	    } else {
	        graphics.setColor(new Color(141, 191, 214));
	    }

	    graphics.fillRoundRect(0, 0, width, height, 10, 10);

	    FontMetrics fontMetrics = graphics.getFontMetrics();
	    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

	    int textX = (width - stringBounds.width) / 2;
	    int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

	    graphics.setColor(Color.BLACK);
	    graphics.setFont(getFont());
	    graphics.drawString(getText(), textX, textY);
	    graphics.dispose();

	    super.paintComponent(g);
	}
}
