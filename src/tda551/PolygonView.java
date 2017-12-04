package tda551;

import tda551.adapter.IPolygon;

import javax.swing.*;
import java.awt.*;

public class PolygonView extends JComponent {

    private PolygonModel model;
    private JFrame frame;

    PolygonView(PolygonModel model) {
        this.model = model;
        frame = new JFrame(  );
        initFrame();
    }

    private void initFrame(){
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setBounds( 30, 30, 300, 300 );
        frame.getContentPane().add( this );
        frame.setVisible( true );
    }

    @Override
    public void paint( Graphics g ) {
        for ( IPolygon currentPolygon : model.getPolygons() ) {
            currentPolygon.paint( g );
        }
    }//paint
}
