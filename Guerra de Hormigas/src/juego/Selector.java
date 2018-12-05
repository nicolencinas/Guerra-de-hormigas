package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import entorno.Entorno;
import entorno.Herramientas;

public class Selector
{
	private int ubicacion;
	static Image imagen=null;
	static Image imagen2=null;
	static Image imagen3=null;
	static Image imagen4=null;
	Color color;
	LinkedList<Hormiguero> hormigueros;
	
	
	
	public Selector(LinkedList <Hormiguero> horm, Color color)
	{
	
	this.ubicacion=0;
	if (imagen==null)
		imagen=Herramientas.cargarImagen("Flecha.gif");
	if (imagen2==null)
		imagen2=Herramientas.cargarImagen("espada.gif");
	if (imagen3==null)
		imagen3=Herramientas.cargarImagen("FlechaRoja.gif");
	if (imagen4==null)
		imagen4=Herramientas.cargarImagen("Espada2.gif");
	hormigueros=horm;
	this.color=color;
	

	}
	
	public void dibujarFlecha(Entorno entorno)
	{
		entorno.dibujarImagen(imagen, hormigueros.get(ubicacion).get_x(),hormigueros.get(ubicacion).get_y()-(hormigueros.get(ubicacion).get_diametro()/2)-20, 0, 0.2);
	}
	
	public void dibujarEspada(Entorno entorno)
	{
		entorno.dibujarImagen(imagen2, hormigueros.get(ubicacion).get_x(),hormigueros.get(ubicacion).get_y(), 0, 0.6);
	}
	
	public void dibujarFlechaj2(Entorno entorno)
	{
		entorno.dibujarImagen(imagen3, hormigueros.get(ubicacion).get_x(),hormigueros.get(ubicacion).get_y()-(hormigueros.get(ubicacion).get_diametro()/2)-20, 0, 0.3);
	}
	
	public void dibujarEspadaj2(Entorno entorno)
	{
		entorno.dibujarImagen(imagen4, hormigueros.get(ubicacion).get_x(),hormigueros.get(ubicacion).get_y()-(hormigueros.get(ubicacion).get_diametro()/2)-20, 0, 0.3);
	}
	
	public void moverAmigo(Entorno entorno)
	{
		if (entorno.estaPresionada('W'))
		{
			if (ubicacion+1>hormigueros.size()-1)
				ubicacion=0;
			else
				ubicacion++;
		}
		
		if (entorno.estaPresionada('S'))
		{
			if (ubicacion-1<0)
				ubicacion=hormigueros.size()-1;
			else 
				ubicacion--;
		}
	}
	
	public void moverEnemigo(Entorno entorno)
	{
		if (entorno.estaPresionada('A'))
		{
			if (ubicacion+1>hormigueros.size()-1)
				ubicacion=0;
			else 
				ubicacion++;
		}
		
		if (entorno.estaPresionada('D'))
		{
			if (ubicacion-1<0)
				ubicacion=hormigueros.size()-1;
			else
				ubicacion--;
		}
	}
	
	public void moverAmigoJ2(Entorno entorno)
	{
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
		{
			if (ubicacion+1>hormigueros.size()-1)
				ubicacion=0;
			else
				ubicacion++;
		}
		
		if (entorno.estaPresionada(entorno.TECLA_ABAJO))
		{
			if (ubicacion-1<0)
				ubicacion=hormigueros.size()-1;
			else
				ubicacion--;
		}
	}
	
	public void moverEnemigoJ2(Entorno entorno)
	{
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
		{
			if (ubicacion+1>hormigueros.size()-1)
				ubicacion=0;
			else
				ubicacion++;
		}
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA))
		{
			if (ubicacion-1<0)
				ubicacion=hormigueros.size()-1;
			else
				ubicacion--;
		}
	}
	
	
	
	public int get_ubicacion()
	{
		return this.ubicacion;
	}
	
	public void set_ubicacion(int num)
	{
		this.ubicacion=num;
	}
	
}

