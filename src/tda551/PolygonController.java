package tda551;

import tda551.adapter.IPolygon;
import tda551.adapter.PolygonFactory;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PolygonController {

    private PolygonView view;
    private PolygonModel model;

    private boolean direction = true;
    private int ticker = 0;

    public PolygonController() {
        List<IPolygon> polygons = new ArrayList<>( 10 );

        polygons.add( PolygonFactory.createSquare( 50, 50 ) );
        polygons.add( PolygonFactory.createTriangle( 100, 100 ) );
        polygons.add( PolygonFactory.createRectangle( 50, 150 ) );

        model = new PolygonModel( polygons );
        view = new PolygonView( model );
        view.addMouseListener( new MyMouseListener() );
    }


    public void update() {
        ticker++;
        int value = direction ? 10 : -10;
        for ( IPolygon p : model.getPolygons() ) {
            p.updateCenter( p.getCenter().x + value, p.getCenter().y + value );
        }
        if ( ticker > 10 ) {
            direction = !direction;
            ticker = 0;
        }
        view.repaint();
    }


    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseEntered( MouseEvent e ) {

        }

        @Override
        public void mouseExited( MouseEvent e ) {

        }

        @Override
        public void mouseClicked( MouseEvent e ) {

        }

        @Override
        public void mousePressed( MouseEvent e ) {
            if ( e.isAltDown() ) {
                model.clear();
            } else if ( e.isShiftDown() ) {
                model.addPolygons( PolygonFactory.createSquare( e.getX(), e.getY() ) );
            } else if ( e.getButton() == 1 ) {
                model.addPolygons( PolygonFactory.createRectangle( e.getX(), e.getY() ) );
            } else if ( e.getButton() == 3 ) {
                model.addPolygons( PolygonFactory.createTriangle( e.getX(), e.getY() ) );
            }
        }

        @Override
        public void mouseReleased( MouseEvent e ) {

        }
    }

    public static void main( String[] args ) {
        PolygonController pc = new PolygonController();

        try {
            while ( true ) {
                Thread.sleep( 500 );
                pc.update();
            }
        } catch ( InterruptedException e ) {
        }
    }
}
