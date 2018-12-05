package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import entorno.Entorno;
import entorno.Herramientas;

public class Tutorial 
{
	int pagina;
	int tiempo;
	boolean empezar_juego;
	boolean se_termino_tiempo;
	
	Image hormiguero=null;
	Image hormiga1;
	Image hormiga2;
	Image hormiga3;
	Image flecha;
	Image espada;
	Image insecticida;
	Image tuto;
	
	public Tutorial()
	{
		this.pagina=1;
		this.tiempo=-10;
		this.empezar_juego=false;
		if (hormiguero==null)
		hormiguero=Herramientas.cargarImagen("Hormiguero.png");
		hormiga1=Herramientas.cargarImagen("AbajoDerecha.gif");
		hormiga2=Herramientas.cargarImagen("AbajoIzquierda.gif");
		hormiga3=Herramientas.cargarImagen("Atrapada_AbajoDerecha.gif");
		flecha=Herramientas.cargarImagen("flecha.gif");
		espada=Herramientas.cargarImagen("espada.gif");
		insecticida=Herramientas.cargarImagen("insecticida.png");
		tuto=Herramientas.cargarImagen("tuto3.jpg");
		this.se_termino_tiempo=false;
		
	}
	
	public void aumentar_tiempo()
	{
		tiempo++;
	}
	
	public void control_pagina()
	{
		if (tiempo>0 && tiempo<800)
			pagina=1;
		else if (tiempo>802 && tiempo<1600)
			pagina=2;
		else if (tiempo>1602 && tiempo<2400)
			pagina=3;
		else if (tiempo>2402 && tiempo<3200)
			pagina=4;
		else if (tiempo>3202 && tiempo<4000)
			pagina=5;
		else if (tiempo>4002 && tiempo<4800)
			pagina=6;
	}
	
	public void reproducir(Entorno entorno)
	{
		entorno.dibujarImagen(tuto, 500, 300, 0,1.2);
		if (pagina==1)
		{ 
			entorno.cambiarFont("Arial", 100, Color.black);
			
			entorno.escribirTexto("Ant Wars", 300, 100);
			entorno.cambiarFont("Comic sans ms", 40, Color.black);
			entorno.escribirTexto("En la Universidad Nacional General Sarmiento ",100, 200);
			entorno.escribirTexto("durante las noches se desata una guerra entre", 100, 300);
			entorno.escribirTexto("dos supercolonias de hormigas.", 100, 400);
			entorno.escribirTexto("¡Es hora de tomar las riendas!", 250, 500);
		}
		
		if (pagina==2)
		{
			entorno.cambiarFont("Arial", 60, Color.black);
			entorno.dibujarImagen(hormiguero, 200, 200, 0, 0.4);
			entorno.escribirTexto("Estos son los Hormigueros",300, 200);
			
			if (tiempo>802 && tiempo<1066)
				entorno.dibujarCirculo(220, 500, 200, Color.blue);
			else if (tiempo>1067 && tiempo<1332)
				entorno.dibujarCirculo(220, 500, 200, Color.red);
			else if (tiempo>1333 && tiempo<1600)
				entorno.dibujarCirculo(220, 500, 200, Color.yellow);
				
			entorno.cambiarFont("Arial", 100, Color.white);
			entorno.escribirTexto("1", 190, 530);
			
			entorno.cambiarFont("Arial", 40, Color.black);
			entorno.escribirTexto("Cada uno tiene un nivel", 460, 460);
			entorno.escribirTexto("que ira aumentando o decreciendo", 350, 500);
			entorno.escribirTexto("dependiendo de la cantidad de hormigas", 300, 540);
			
		}
		
		if (pagina==3)
		{
			entorno.cambiarFont("Arial", 60, Color.black);
			entorno.escribirTexto("Contamos con dos Selectores", 100, 100);
			entorno.dibujarImagen(flecha, 200, 300, 0, 0.6);
			entorno.cambiarFont("Arial", 40, Color.black);
			entorno.escribirTexto("con este seleccionas el origen", 300, 300);
			entorno.dibujarImagen(espada, 200, 500, 0,0.8);
			entorno.escribirTexto("con este seleccionas donde atacar", 400, 500);
			
		}
		
		if (pagina==5)
		{
			
			
			entorno.dibujarImagen(insecticida, 200, 300, 0, 0.6);
			entorno.cambiarFont("Arial", 40, Color.black);
			entorno.escribirTexto("Ten mucho Cuidado con los insecticidas", 300, 300);
			entorno.dibujarImagen(hormiga3, 200, 300, 0,2);
			entorno.escribirTexto("Ya que afectaran negativamente a tus tropas", 230, 500);
		}
		
		if (pagina==4)
		{
			
			
			entorno.dibujarImagen(hormiga1, 200, 300, 0, 3);
			entorno.cambiarFont("Arial", 40, Color.black);
			entorno.escribirTexto("Estas son tus intrepidas guerreras", 300, 300);
			
		
		}
		
		if (pagina==6)
		{
			
			entorno.cambiarFont("Arial", 100, Color.black);
			entorno.escribirTexto("¿Estas Listo?", 200, 250);
			entorno.cambiarFont("Arial", 60, Color.black);
			entorno.dibujarImagen(hormiga1, 280, 450, 0, 1);
			entorno.escribirTexto("Presiona Enter", 320, 470);
			entorno.dibujarImagen(hormiga2, 750, 450, 0, 1);
			
			
			
		}

}
	
	public boolean ganoAzul(LinkedList <Hormiguero> hormigueros)
	{
		int azul=0;
		for (int i=0;i<hormigueros.size();i++)
			if (hormigueros.get(i).get_color().equals(Color.blue))
				azul++;
		
		if (azul==hormigueros.size())
			return true;
		return false;
				
	}
	
	public boolean ganoRojo(LinkedList <Hormiguero> hormigueros)
	{
		int rojo=0;
		for (int i=0;i<hormigueros.size();i++)
			if (hormigueros.get(i).get_color().equals(Color.red))
				rojo++;
		
		if (rojo==hormigueros.size())
			return true;
		return false;
	}
	
	public void Mostrar_final(Entorno entorno, LinkedList <Hormiguero> hormigueros)
	{
		
		if (this.ganoAzul(hormigueros))
		{
			entorno.dibujarImagen(tuto, 500, 300, 0, 1.2);
			entorno.cambiarFont("Arial", 100, Color.blue);
			entorno.escribirTexto("¡Gano el Jugador 1!", 50, 300);
		}
		else if (this.ganoRojo(hormigueros))
		{
			entorno.dibujarImagen(tuto, 500, 300, 0, 1.2);
			entorno.cambiarFont("Arial", 100, Color.red);
			entorno.escribirTexto("¡Gano El Jugador 2!", 50, 300);
		}
			
	}
	
	public static void trucoRojo(Entorno entorno, LinkedList <Hormiguero> hormigueros)
	{
		if (entorno.estaPresionada(entorno.TECLA_FIN))
		{
			for (int i=0;i<hormigueros.size();i++)
			{
				hormigueros.get(i).setColor(Color.red);
			}
		}
		
	}
	
	public static void trucoAzul(Entorno entorno, LinkedList <Hormiguero> hormigueros)
	{
		if (entorno.estaPresionada(entorno.TECLA_INICIO))
		{
			for (int i=0;i<hormigueros.size();i++)
			{
				hormigueros.get(i).setColor(Color.blue);
			}
		}
		
	}

	public void decidirGanador(Entorno entorno,LinkedList<Hormiguero> hormigueros)
	{
		if (Hormiguero.cantRojos(hormigueros)<Hormiguero.cantAzules(hormigueros))
		{
			entorno.dibujarImagen(tuto, 500, 300, 0, 1.2);
			entorno.cambiarFont("Arial", 100, Color.blue);
			entorno.escribirTexto("¡Gano El Jugador 1!", 50, 300);
			entorno.cambiarFont("Arial", 70, Color.blue);
			entorno.escribirTexto("Por mayoria de conquistas", 100, 400);
		}
		else if (Hormiguero.cantRojos(hormigueros)>Hormiguero.cantAzules(hormigueros))
		{
			entorno.dibujarImagen(tuto, 500, 300, 0, 1.2);
			entorno.cambiarFont("Arial", 100, Color.red);
			entorno.escribirTexto("¡Gano El Jugador 2!", 50, 300);
			entorno.cambiarFont("Arial", 70, Color.red);
			entorno.escribirTexto("Por mayoria de conquistas", 100, 400);
		}
		else
		{
			entorno.dibujarImagen(tuto, 500, 300, 0, 1.2);
			entorno.cambiarFont("Arial", 100, Color.yellow);
			entorno.escribirTexto("¡Empate!", 300, 400);
	
		}
		
	}
	
	
	
}
