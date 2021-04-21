package ie.tudublin;

import java.util.ArrayList;
import java.util.Arrays;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	//array list to holds the instances of the note class
	ArrayList<Note> notes = new ArrayList<Note>(); 
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void loadScore() { //populating array list

		String[] str = score.split("");
		
		for(String s : str) {

			//println(s);

		}

		for(int i = 0; i < score.length(); i++) {

			char c = score.charAt(i);
			int cDuration = 1;


			Note n = new Note(c, cDuration);
			notes.add(n);

		}

	}

	public void printScore() {

		for(Note n : notes) {
			
			if(n.getDuration() == 1) {

				println(n.getNote() + "\t" + n.getDuration() + "\t" + "Quaver");

			} 

			if (n.getDuration() == 2) {

				println(n.getNote() + "\t" + n.getDuration() + "\t" + "Crotchet");
			}

		}

	}

	float border = width * 0.9f ; 

	public void drawStaveLines() {

		stroke(0);
		strokeWeight(2);
		line(border, border, width - border, border);
		line(border, border + 25, width - border, border + 25);
		line(border, border + 50, width - border, border + 50);
		line(border, border + 75, width - border, border + 75);
		line(border, border + 100, width - border, border + 100);
		

	}

	public void setup() 
	{
		loadScore();
		printScore();
		
	}

	public void draw()
	{
		background(255);
		drawStaveLines();

		
	}

	void drawNotes()
	{
	}
}
