package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Random;

import entorno.*;


public class Juego extends InterfaceJuego
{
	private Entorno entorno;
	
	LinkedList<Tropa> tropas=new LinkedList<Tropa>();
	LinkedList<Hormiguero> hormigueros=new LinkedList <Hormiguero>();
	LinkedList <Posicion> pos;
	
	long tiempo;
	Random gen;
	static Image imagen=null;
	
	
	Selector J1_origen;
	Selector J1_destino;
	
	Selector J2_origen;
	Selector J2_destino;

	LinkedList <Insecticida> insect=new LinkedList<Insecticida>();

	
	LinkedList <Hormiguero> jugador1=new LinkedList <Hormiguero>();
	LinkedList <Hormiguero> jugador2=new LinkedList <Hormiguero>();
	
	Tutorial tutorial;
	Tiempo time;

	Juego()
	{
		// Inicializa el objeto entorno, pero aun no lo inicia.
		gen=new Random();
		pos=Posicion.generador((gen.nextInt(5)+8));
		entorno = new Entorno(this, "Guerra de Hormigas - Versión 0.01", 1000, 700);
		gen=new Random();
	
		
		
		for (int i=0;i<pos.size();i++)
		{
			Hormiguero horm=new Hormiguero(pos.get(i));
			hormigueros.add(horm);
		}
			
		
       
			
		
		tiempo=0;
		if (imagen==null)
			imagen=Herramientas.cargarImagen("pasto.jpg");
		
		
		jugador1.add(hormigueros.get(0));
		jugador1.add(hormigueros.get(1));
		
		jugador2.add(hormigueros.get(2));
		jugador2.add(hormigueros.get(3));
		
		hormigueros.get(0).setColor(Color.blue);
		hormigueros.get(1).setColor(Color.blue);

		
		hormigueros.get(2).setColor(Color.red);
		hormigueros.get(3).setColor(Color.red);
		
	
		
		J1_origen=new Selector(hormigueros,Color.blue);
		J1_destino=new Selector(hormigueros,Color.blue);
		
		J2_origen=new Selector(hormigueros,Color.red);
		J2_destino=new Selector(hormigueros,Color.red);
		
		J2_origen.set_ubicacion(2);
		J2_destino.set_ubicacion(2);
		
		tutorial=new Tutorial();
		time=new Tiempo();
		
		
		
		
		
		/* 
		 * Es fundamental que recién al final del constructor de la clase Juego se 
		 * inicie el objeto entorno de la siguiente manera.
		 */
		entorno.iniciar();
	}

	/*
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		

		if (tutorial.empezar_juego==false)
		{
		
			tutorial.aumentar_tiempo();
			tutorial.control_pagina();
			tutorial.reproducir(entorno);
			
			
			
			if (entorno.estaPresionada(entorno.TECLA_ENTER))
				tutorial.empezar_juego=true;
		}else
		{
			time.incMillis();
			
			
			tiempo++;
			int rojo=Hormiguero.cantRojos(hormigueros);
			int azul=Hormiguero.cantAzules(hormigueros);
			entorno.dibujarImagen(imagen, 500, 300, 0, 1.3);
			entorno.dibujarRectangulo(600,10, 1200, 40, 0,Color.white);
			entorno.dibujarRectangulo(600,30, 1200, 2, 0,Color.black);
			entorno.cambiarFont("Arial", 18, Color.blue);
			entorno.escribirTexto("Cantidad jugador 1: "+azul, 100, 20);
			entorno.dibujarRectangulo(290, 0, 2, 60, 0, Color.black);
			entorno.cambiarFont("Arial", 18, Color.red);
			entorno.escribirTexto("Cantidad jugador 2: "+rojo, 300, 20);
			entorno.cambiarFont("Arial", 18, Color.black);
			entorno.escribirTexto("Esta ganando: ", 600, 20);
			if (rojo==azul)
			{
				entorno.dibujarCirculo(730, 13, 25, Color.black);
				entorno.dibujarCirculo(730, 13, 20, Color.yellow);
			}
				
			else
			{
				entorno.dibujarCirculo(730, 13, 25, Color.black);
				entorno.dibujarCirculo(730, 13, 20, (rojo>azul)? Color.red : Color.blue);
			}
				
			Tiempo.mostrar(entorno, time);
			
			Insecticida.dibujar(entorno, insect);
			Insecticida.Control_insecticidas(entorno, insect);
			

			
			
			if (tiempo%2000==0)
			{
				
				insect.add(new Insecticida(gen.nextInt(800),gen.nextInt(600)+100));
				
			}

			
			
			
			J1_origen.moverAmigo(entorno);
			J1_destino.moverEnemigo(entorno);
			
			J2_origen.moverAmigoJ2(entorno);
			J2_destino.moverEnemigoJ2(entorno);
			
			Hormiguero.dibujar(entorno, hormigueros);
			
			J1_origen.dibujarFlecha(entorno);
			J1_destino.dibujarEspada(entorno);
			
			J2_origen.dibujarFlechaj2(entorno);
			J2_destino.dibujarEspadaj2(entorno);
		
			if (tiempo%500==0)
			{
				for (int i=0;i<hormigueros.size();i++)
				{
					hormigueros.get(i).cambiarNivel();
					hormigueros.get(i).ControlNivel();
				}
			}
			
			if (tiempo%1500==0)
			{
				Hormiguero.iniciar_supercrecimiento(hormigueros);
			}
				
			Hormiguero.agregarTropa(entorno, hormigueros.get(J1_origen.get_ubicacion()), hormigueros.get(J1_destino.get_ubicacion()),J1_origen);
			Hormiguero.agregarTropaJ2(entorno, hormigueros.get(J2_origen.get_ubicacion()), hormigueros.get(J2_destino.get_ubicacion()),J2_destino );

			
			
		
			for (int i=0;i<hormigueros.size();i++)
			{
				if (!(hormigueros.get(i).tropas.isEmpty()))
				{
					for (int j=0;j<hormigueros.get(i).tropas.size();j++)
					{
						
						hormigueros.get(i).tropas.get(j).mover(hormigueros.get(i).tropas.get(j).destino, hormigueros.get(i).tropas.get(j).origen, hormigueros.get(i).tropas.get(j).velocidad);
						

					}
				}
				

				

			}	
			
			Tropa.control_colisiones(hormigueros, jugador1);
			Tropa.control_colisiones(hormigueros, jugador2);
			
			Hormiguero.mostrar_cartel(entorno, hormigueros);
			
			Insecticida.Control_Colisiones(insect, hormigueros);


			
			for (int i=0;i<hormigueros.size();i++)
			{
				for (int j=0;j<hormigueros.get(i).tropas.size();j++)
				Tropa.dibujarse(entorno, hormigueros.get(i).tropas);

			}
			
			//Control del final del juego
			Tutorial.trucoRojo(entorno, hormigueros);
			Tutorial.trucoAzul(entorno, hormigueros);
			if (time.get_minutos()>=5)
				tutorial.se_termino_tiempo=true;
			if (tutorial.se_termino_tiempo==false)
				tutorial.Mostrar_final(entorno, hormigueros);
			else	
				tutorial.decidirGanador(entorno,hormigueros);
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{		
		Juego juego = new Juego();
	}
}
