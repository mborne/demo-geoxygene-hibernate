package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.example.domain.Road;

import fr.ign.cogit.geoxygene.api.spatial.coordgeom.IDirectPosition;
import fr.ign.cogit.geoxygene.datatools.hibernate.GeodatabaseHibernate;
import fr.ign.cogit.geoxygene.feature.DefaultFeature;
import fr.ign.cogit.geoxygene.spatial.coordgeom.DirectPosition;
import fr.ign.cogit.geoxygene.spatial.coordgeom.GM_LineString;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DefaultFeature feature = new DefaultFeature();
    	System.out.println(feature.getId());
    	
    	GeodatabaseHibernate db = new GeodatabaseHibernate();
    	
    	db.begin();
    	for ( int i = 0; i < 10; i++ ){
    		Road road = new Road();
    		
    		List<IDirectPosition> coords = new ArrayList<IDirectPosition>();
    		coords.add(new DirectPosition(0.0, 0.0+i));
    		coords.add(new DirectPosition(1.0, 1.0+i));    		
			GM_LineString geometry = new GM_LineString(coords);
    		road.setGeom(geometry);

    		db.makePersistent(road);
    	}
    	db.commit();
    	
    	Collection<Road> roads = db.loadAll(Road.class);
    	for (Road road : roads) {
			System.out.println(road.getId()+" "+road.getGeom().toString());
		}
    }
}
