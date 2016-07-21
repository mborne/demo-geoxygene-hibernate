package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import fr.ign.cogit.geoxygene.api.spatial.geomroot.IGeometry;
import fr.ign.cogit.geoxygene.feature.DefaultFeature;

@Entity
public class Road extends DefaultFeature {
	
	private double width ;

	@Override
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	@Type(type = "fr.ign.cogit.geoxygene.datatools.hibernate.GeOxygeneGeometryUserType")
	public IGeometry getGeom() {
		return geom;
	}

}
