package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import entorno.Entorno;
import entorno.Herramientas;

public class Hormiguero 
{
	private double diametro;
	private double x;
	private double y;
	private Color color;
	private int nivel;
	private int cantidad;
	static Image img=null;
	static Image img2=null;
	LinkedList <Tropa> tropas=new LinkedList <Tropa>();
	boolean conquistada;
	int tiempo_cartel;
	double y_cartel;


	public Hormiguero(Posicion pos)
	{
		this.color=Color.yellow;
		this.nivel=1;
		this.x=pos.x;;
		this.y=pos.y;
		this.cantidad=200;
		this.diametro=50;
		if (img==null)
			img=Herramientas.cargarImagen("flecha.gif");
		if (img2==null)
			img2=Herramientas.cargarImagen("Hormiguero.png");
		
		//recursos graficos para el hormiguero cuando es conquistado
		this.tiempo_cartel=200;
		this.conquistada=false;
		this.y_cartel=this.y-10;
		
	}

	public static void dibujar(Entorno entorno, LinkedList <Hormiguero> horm)
	{
		
		for (int i=0;i<horm.size();i++)
		{
		double radio=horm.get(i).diametro/2;
		entorno.dibujarImagen(img2,horm.get(i).x, horm.get(i).y,0,0.15);
		entorno.dibujarCirculo(horm.get(i).x+radio-10, horm.get(i).y-radio-10, 20, horm.get(i).color);
		entorno.cambiarFont("arial", 15, Color.white);
		entorno.escribirTexto(""+horm.get(i).nivel, horm.get(i).x+radio-13, horm.get(i).y-radio-5);
		entorno.cambiarFont("arial", 20, Color.black);
		entorno.escribirTexto(""+horm.get(i).cantidad, horm.get(i).x-10, horm.get(i).y);
		
		}

	}
	
	public static void mostrar_cartel(Entorno entorno, LinkedList <Hormiguero> horm)
	{
		
		for (int i=0;i<horm.size();i++)
		{
		
		horm.get(i).control_cartel();
		double x=horm.get(i).get_x()-70;
		
		if (horm.get(i).conquistada && horm.get(i).tiempo_cartel>0)
		{
			
			entorno.cambiarFont("Arial", 20, Color.black);
			entorno.escribirTexto("CONQUISTADA", x, horm.get(i).y_cartel);
			
			
		}else
		{
			horm.get(i).conquistada=false;
			horm.get(i).tiempo_cartel=200;
			horm.get(i).y_cartel=horm.get(i).y-10;
		}	
		}

	}
	
	public void control_cartel()
	{
		tiempo_cartel--;
		y_cartel-=0.2;
		
	}


	
	
	
	public void cambiarNivel()
	{
		if (this.cantidad>=40 && this.cantidad<=99)
		{
			this.nivel=2;
		}
		
		else if (this.cantidad>=100 && this.cantidad<=299)
		{
			this.nivel=3;
		}
		else if (this.cantidad>=300)
		{
			this.nivel=4;
		}
		else this.nivel=1;
			
	}
	
	public void ControlNivel()
	{
		if (this.nivel==2)
		{
			this.incrementar_cantidad(2);
		}
		else if (this.nivel==3)
		{
			this.incrementar_cantidad(4);
		}
		else if (this.nivel==4)
		{
			this.incrementar_cantidad(8);
		}
		else 
			this.incrementar_cantidad(1);
	}
	
	public int tercio()
	{
		return this.cantidad/3;
	}
	
	public static void agregarTropa(Entorno entorno,Hormiguero origen, Hormiguero destino, Selector selector)
	{
		int tercio=origen.tercio();
		
		if (entorno.estaPresionada('1') && tercio!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),tercio,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(tercio*-1);
			
		}
		
		if (entorno.estaPresionada('2') && tercio*2!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),tercio*2,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(tercio*-2);
		}
		if (entorno.estaPresionada('3') && origen.get_cantidad()!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),origen.cantidad,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(origen.cantidad*-1);
		}
			
	}
	
	public static void agregarTropaJ2(Entorno entorno,Hormiguero origen, Hormiguero destino, Selector selector)
	{
		int tercio=origen.tercio();
		
		if (entorno.estaPresionada('8') && tercio!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),tercio,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(tercio*-1);
			
		}
		
		if (entorno.estaPresionada('9') && tercio*2!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),tercio*2,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(tercio*-2);
		}
		if (entorno.estaPresionada('0') && origen.get_cantidad()!=0 && selector.color.equals(origen.get_color()))
		{
			Tropa tropa=new Tropa(origen.get_x(),origen.get_y(),origen.get_color(),origen.cantidad,origen,destino);
			origen.tropas.add(tropa);
			origen.incrementar_cantidad(origen.cantidad*-1);
		}
			
	}
	
	public static int mayorCantidad(LinkedList <Hormiguero> hormigueros)
	{
		int max=0;
		for (int i=0;i<hormigueros.size();i++)
		{
			int cant=hormigueros.get(i).cantidad;
			if (cant>max)
				max=cant;
		}
		return max;
	}
	
	public static void iniciar_supercrecimiento(LinkedList <Hormiguero> hormigueros)
	{
		int maximo=Hormiguero.mayorCantidad(hormigueros);
		int aumento=(int) (maximo*0.15);
		for (int i=0;i<hormigueros.size();i++)
		{
			if (hormigueros.get(i).cantidad<maximo && 
					hormigueros.get(i).color.equals(Color.red) || hormigueros.get(i).color.equals(Color.blue))
				hormigueros.get(i).incrementar_cantidad(aumento);
		}
	}
	
	public static int cantRojos(LinkedList <Hormiguero> hormigueros)
	{
		int cont=0;
		for (int i=0;i<hormigueros.size();i++)
		{
			if (hormigueros.get(i).color.equals(Color.red))
			{
				cont++;
			}
		}
		return cont;
	}
	public static int cantAzules(LinkedList <Hormiguero> hormigueros)
	{
		int cont=0;
		for (int i=0;i<hormigueros.size();i++)
		{
			if (hormigueros.get(i).color.equals(Color.blue))
			{
				cont++;
			}
		}
		return cont;
	}
	
	//Setters/Getters
	public void set_cantidadTotal(int cant)
	{
		this.cantidad=cant;
	}
	
	public void setColor(Color color)
	{
		this.color=color;
	}
	
	public double get_x()
	{
		return this.x;
	}
	
	public double get_diametro()
	{
		return this.diametro;
	}
	
	public double get_y()
	{
		return this.y;
	}
	
	public void incrementar_cantidad(int num)
	{
		this.cantidad+=num;
	}
	
	public int get_cantidad()
	{
		return this.cantidad;
	}
	
	public Color get_color()
	{
		return this.color;
	}
	
	public int get_nivel()
	{
		return this.nivel;
	}
	

}

