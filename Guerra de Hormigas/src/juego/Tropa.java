package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import entorno.Entorno;
import entorno.Herramientas;

public class Tropa
{
	int cantidad;
	double x;
	double y;
	double diametro;
	static Image img=null;
	static Image ArribaIzquierda=null;
	static Image AbajoIzquierda=null;
	static Image ArribaDerecha=null;
	static Image AbajoDerecha=null;
	static Image AtrapadaArribaIzquierda=null;
	static Image AtrapadaArribaDerecha=null;
	static Image AtrapadaAbajoIzquierda=null;
	static Image AtrapadaAbajoDerecha=null;
	
	boolean atrapada;
	Color color;
	Hormiguero destino;
	Hormiguero origen;
	double velocidad;
	
	public Tropa(double x, double y, Color color,int cantidad, Hormiguero destino, Hormiguero origen)
	{
		this.x=x;
		this.y=y;
		this.diametro=40;
		this.cantidad=cantidad;
		if (ArribaIzquierda==null)
			ArribaIzquierda=Herramientas.cargarImagen("ArribaIzquierda.gif");
		if (AbajoIzquierda==null)
			AbajoIzquierda=Herramientas.cargarImagen("AbajoIzquierda.gif");
		if (AbajoDerecha==null)
			AbajoDerecha=Herramientas.cargarImagen("AbajoDerecha.gif");
		if (ArribaDerecha==null)
			ArribaDerecha=Herramientas.cargarImagen("ArribaDerecha.gif");
		if (AtrapadaArribaIzquierda==null)
			AtrapadaArribaIzquierda=Herramientas.cargarImagen("Atrapada_ArribaIzquierda.gif");
		if (AtrapadaArribaDerecha==null)
			AtrapadaArribaDerecha=Herramientas.cargarImagen("Atrapada_ArribaDerecha.gif");
		if (AtrapadaAbajoIzquierda==null)
			AtrapadaAbajoIzquierda=Herramientas.cargarImagen("Atrapada_AbajoIzquierda.gif");
		if (AtrapadaAbajoDerecha==null)
			AtrapadaAbajoDerecha=Herramientas.cargarImagen("Atrapada_AbajoDerecha.gif");
		
		this.color=color;
		atrapada=false;
		velocidad=1;
		
		this.destino=destino;
		this.origen=origen;
	}
	
	
	public Tropa(double x, double y, Color color,int cantidad)
	{
		this.x=x;
		this.y=y;
		this.diametro=40;
		this.cantidad=cantidad;
		if (ArribaIzquierda==null)
			ArribaIzquierda=Herramientas.cargarImagen("ArribaIzquierda.gif");
		if (AbajoIzquierda==null)
			AbajoIzquierda=Herramientas.cargarImagen("AbajoIzquierda.gif");
		if (AbajoDerecha==null)
			AbajoDerecha=Herramientas.cargarImagen("AbajoDerecha.gif");
		if (ArribaDerecha==null)
			ArribaDerecha=Herramientas.cargarImagen("ArribaDerecha.gif");
		if (AtrapadaArribaIzquierda==null)
			AtrapadaArribaIzquierda=Herramientas.cargarImagen("Atrapada_ArribaIzquierda.gif");
		if (AtrapadaArribaDerecha==null)
			AtrapadaArribaDerecha=Herramientas.cargarImagen("Atrapada_ArribaDerecha.gif");
		if (AtrapadaAbajoIzquierda==null)
			AtrapadaAbajoIzquierda=Herramientas.cargarImagen("Atrapada_AbajoIzquierda.gif");
		if (AtrapadaAbajoDerecha==null)
			AtrapadaAbajoDerecha=Herramientas.cargarImagen("Atrapada_AbajoDerecha.gif");
		
		this.color=color;
		atrapada=false;
		velocidad=1;
	}
	public static void dibujarse(Entorno entorno, LinkedList<Tropa> tropa)
	{
		for (int i=0;i<tropa.size();i++)
		{
			
			if(!(tropa.get(i).atrapada))
			{
				
				
				if (((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y())))
				entorno.dibujarImagen(ArribaIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 1);
			 if (((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(AbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 1);
			 if (((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(AbajoIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 1);
			if  (((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(ArribaDerecha, tropa.get(i).x, tropa.get(i).y, 0, 1);
			if (((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()==tropa.get(i).origen.get_y()) ))
				entorno.dibujarImagen(AbajoIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 1);
			if (((tropa.get(i).destino.get_x()==tropa.get(i).origen.get_x())&& (tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(ArribaDerecha, tropa.get(i).x, tropa.get(i).y, 0, 1);
			if (((tropa.get(i).destino.get_x()==tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(AbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 1);
			if(((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x()) && (tropa.get(i).destino.get_y()==tropa.get(i).origen.get_y())) )
				entorno.dibujarImagen(AbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 1);
			}
			else if(tropa.get(i).atrapada)
			{
				if ((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y()) )
			entorno.dibujarImagen(AtrapadaArribaIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 0.7);
				else if ((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaAbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 0.8);
				else if ((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaAbajoIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 0.8);
				else if  ((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaArribaDerecha, tropa.get(i).x, tropa.get(i).y, 0, 0.7);
				else if ((tropa.get(i).destino.get_x()>tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()==tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaAbajoIzquierda, tropa.get(i).x, tropa.get(i).y, 0, 0.8);
				else if ((tropa.get(i).destino.get_x()==tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()>tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaArribaDerecha, tropa.get(i).x, tropa.get(i).y, 0, 0.7);
				else if ((tropa.get(i).destino.get_x()==tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()<tropa.get(i).origen.get_y()) )
				entorno.dibujarImagen(AtrapadaAbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 0.8);
				else if((tropa.get(i).destino.get_x()<tropa.get(i).origen.get_x() && tropa.get(i).destino.get_y()==tropa.get(i).origen.get_y()) )

				entorno.dibujarImagen(AtrapadaAbajoDerecha, tropa.get(i).x, tropa.get(i).y, 0, 0.8);
			}
				
		}
	}

	public static void dibujar(Entorno entorno, LinkedList<Tropa> tropa)
	{
		for (int i=0;i<tropa.size();i++)
		{
		
			
			entorno.dibujarImagen(img, tropa.get(i).x, tropa.get(i).y, 0, 1);
		}
	}
	

	public double velocidad (Hormiguero origen, Hormiguero destino,int  num, double velocidad)
	{
		double base=(destino.get_y()-origen.get_y());
		double altura=(destino.get_x()-origen.get_x());
		double hipo=Math.sqrt(base*base+altura*altura);
		
		double vx=(velocidad*altura)/hipo;
		double vy=(velocidad*base)/hipo;
		
		if (num==0)
			return vx;
		
		if (num==1)
			return vy;
		
		return 0;
		
		
		
	}
	
	public void mover(Hormiguero origen, Hormiguero destino, double vel)
	{
		double vx=this.velocidad(origen,destino,0,vel);
		double vy=this.velocidad(origen, destino, 1,vel);
		
		this.x+=vx;
		this.y+=vy;
	}
	
	public boolean colision(Hormiguero hormiguero)
	{
		double dx=this.x-hormiguero.get_x();
		double dy=this.y-hormiguero.get_y();
		
		if (Math.sqrt(dx*dx+dy*dy)>this.diametro/2+hormiguero.get_diametro()/2)
			return false;
		return true;
	}

	
	public boolean se_solapa(Insecticida insect)
	{
		double dx=this.x-insect.x;
		double dy=this.y-insect.y;
		
		if ((Math.sqrt(dx*dx+dy*dy)-insect.diametro/2-this.diametro/2)<=0)
			return true;
		return false;
	}
	
	public static void control_colisiones(LinkedList <Hormiguero> horm,LinkedList <Hormiguero> jugador)
	{
		for (int i=0;i<horm.size();i++)
		{
			if (!(horm.get(i).tropas.isEmpty()))
			{
			for (int j=0;j<horm.get(i).tropas.size();j++)
			{
				Tropa tropa=horm.get(i).tropas.get(j);
				Hormiguero hormiguero=horm.get(i).tropas.get(j).origen;
				if (tropa.colision(hormiguero))
				{
					if (tropa.color.equals(hormiguero.get_color()))
					{
						horm.get(i).tropas.get(j).origen.incrementar_cantidad(tropa.cantidad);
						horm.get(i).tropas.remove(tropa);
					}
					
					else if (!(tropa.color.equals(hormiguero.get_color())))
					{
						if(hormiguero.get_cantidad()>tropa.cantidad)
						{
							hormiguero.incrementar_cantidad(tropa.cantidad*-1);
							horm.get(i).tropas.remove(tropa);
						}
						else  
						{
							hormiguero.conquistada=true;
							hormiguero.set_cantidadTotal(tropa.cantidad-hormiguero.get_cantidad());
							hormiguero.setColor(tropa.color);
							horm.get(i).tropas.remove(tropa);
							
						}
					}
				}
			}	
			}

		}
	}
	

}
	




