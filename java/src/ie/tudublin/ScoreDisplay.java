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
		line(border, (float)(border * 2.5), width - border, (float)(border * 2.5));
		line(border, (float)(border * 2.5) + 25, width - border, (float)(border * 2.5) + 25);
		line(border, (float)(border * 2.5) + 50, width - border, (float)(border * 2.5) + 50);
		line(border, (float)(border * 2.5) + 75, width - border, (float)(border * 2.5) + 75);
		line(border, (float)(border * 2.5) + 100, width - border, (float)(border * 2.5) + 100);

		fill(0);
		textSize(20);
		for(int i = 0; i < notes.size(); i++) {

			float x = map(i, 0, notes.size(), (float)(border * 1.5), width - border);
			Note note = notes.get(i);
			text(note.getNote(), x, (float)(border * 1.5));


		}

		

	}

	public void setup() 
	{
		loadScore();
		printScore();
		
	}

	void drawNotes() {
		
		fill(0);
		for(int i = 0; i < notes.size(); i++) {

			float x = map(i, 0, notes.size(), (float)(border * 1.5), width - border);
			float y = map(i, 0, notes.size() + 10, (float)(border * 1.5) + 25, height - border);


			if(mouseX == x && mouseX < x + (width / 2)) { // filling in the colour of the notes
				

				fill(255, 0, 0);
			}

			circle(x, height - y, 20);
			//line(x, y + 200, x , y);


		}

	}

	public void draw()
	{
		background(255);
		drawStaveLines();
		drawNotes();

		
	}

}
