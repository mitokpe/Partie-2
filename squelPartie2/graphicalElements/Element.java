package graphicalElements;

import util.Case;

import java.awt.*;

public class Element extends Case {

    public final Color color;

    public Element(int abs, int ord, Color color) {
        super(abs, ord);

        this.color = color;
    }
    
    public Element(Case c, Color color) {
        super(c.abs, c.ord);

        this.color = color;
    }
    
}
