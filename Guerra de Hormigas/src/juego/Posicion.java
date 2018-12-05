package juego;

import java.util.LinkedList;
import java.util.Random;

public class Posicion
{

	int x;
	int y;
	
	public Posicion(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return (x+" "+y);
	}
	
	public static LinkedList <Posicion> posibles_posiciones()
	{
		LinkedList <Posicion> posis=new LinkedList <Posicion>();
		int x=100;
		int y;
		for(int i=0;i<6;i++)
		{
			y=50;
			for (int j=0;j<10;j++)
			{
				Posicion pos=new Posicion(y,x);
				posis.add(pos);
				y+=100;
				
			}
			x+=100;
		}
		return posis;
	}
	
	public static LinkedList<Posicion> generador(int largo)
	{
		LinkedList <Posicion> generador=Posicion.posibles_posiciones();
		LinkedList <Posicion> nueva=new LinkedList <Posicion>();
		int  [] pos=Posicion.sin_repetidos(largo);
		
		for (int i=0;i<largo;i++)
		{
			nueva.add(generador.get(pos[i]));
		}
		
		return nueva;
	}
	
	public static int[] sin_repetidos(int largo)
	{
		Random gen=new Random();
		int num;
		int i=0;
		int [] array=new int[largo];
		while (i<largo)
		{
			num=gen.nextInt(60);
			if (!Posicion.esta_en(num, array))
			{
				array[i]=num;
				i++;
			}
			
			
		}
		return array;
		
		
	}
	
	public static boolean esta_en(int numero, int[] array)
	{
		if (array.length==0)
			return false;
		for (int i=0;i<array.length;i++)
			if (array[i]==numero)
				return true;
		return false;
	}
}
