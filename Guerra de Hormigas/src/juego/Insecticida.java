package juego;

import java.awt.Image;
import java.util.LinkedList;

import entorno.Entorno;
import entorno.Herramientas;

public class Insecticida 
{
	double x;
	double y;
	double diametro;
	private static Image img=null;
	int tiempo_de_vida;
	
	public Insecticida(double x,double y)
	{
		this.x=x;
		this.y=y;
		if (img==null)
			img=Herramientas.cargarImagen("Insecticida.png");
		this.tiempo_de_vida=850;
		this.diametro=230.4;
	}
	
	public static void dibujar(Entorno entorno,  LinkedList <Insecticida> insect)
	{
		for (int i=0;i<insect.size();i++)
		{
			entorno.dibujarImagen(img, insect.get(i).x, insect.get(i).y, 0, 0.3);
		}
		
	}
	
	public static void Control_insecticidas(Entorno entorno, LinkedList <Insecticida> insect)
	{
		for (int j=0;j<insect.size();j++)
		{
			insect.get(j).tiempo_de_vida--;
			if (insect.get(j).tiempo_de_vida<0)
			{
				insect.remove(j);
			}
			
			
		}
	}
	
	public static void Control_Colisiones(LinkedList <Insecticida> insect, LinkedList <Hormiguero> hormigueros)
	{
		
			for (int i=0;i<hormigueros.size();i++)
			{
				
					for (int j=0;j<hormigueros.get(i).tropas.size();j++)
					{
						
						if (!(insect.isEmpty()))
						{						
						for (int k=0;k<insect.size();k++)
						{		
								if (hormigueros.get(i).tropas.get(j).se_solapa(insect.get(k)))
								{
									hormigueros.get(i).tropas.get(j).atrapada=true;
									hormigueros.get(i).tropas.get(j).velocidad=0.1;
									
								}		
						}
						}
						else
						{
							hormigueros.get(i).tropas.get(j).atrapada=false;
							hormigueros.get(i).tropas.get(j).velocidad=1;
						}

				
					}
	
			}
		

	}
	

	
	

	}
	

