package tda551;

import tda551.adapter.IPolygon;

import java.util.List;

public class PolygonModel {

    private List<IPolygon> polygons;

    PolygonModel(List<IPolygon> polygons) {
        this.polygons = polygons;
    }

    public void addPolygons(IPolygon p) {
        polygons.add( p );
    }

    public void clear(){
        polygons.clear();
    }

    public List<IPolygon> getPolygons() {
        return polygons;
    }
}
