package juego;

import java.awt.Color;

import entorno.Entorno;

public class Tiempo
{
	private int segundos;
	private int minutos;
	long milisegundos;
	
	Tiempo()
	{
		this.segundos=0;
		this.minutos=0;
		milisegundos=0;
	}
	
	public static Tiempo get_transcurrido(long n, Tiempo time)
	{
		
			if (n%100==0)
			{
			time.segundos++;
			if (time.segundos==60)
			{
				time.segundos=00;
				time.minutos++;
			}
			}
		
		return time;
		
		
		
	}
	
	public String toString()
	{
		if (this.segundos<10)
			return "Tiempo: "+"0"+this.minutos+":"+"0"+this.segundos;
		else
			return "Tiempo: "+"0"+this.minutos+":"+this.segundos;
	}
	
	public long get_millis()
	{
		return this.milisegundos;
	}
	
	public void incMillis()
	{
		this.milisegundos++;
	}
	
	public int get_minutos()
	{
		return minutos;
	}
	
	public static void mostrar(Entorno entorno, Tiempo time)
	{
		
		entorno.cambiarFont("arial", 18, Color.black);
		entorno.escribirTexto(Tiempo.get_transcurrido(time.milisegundos, time).toString(), 800,20);
	}
}
