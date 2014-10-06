import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

//Art Parkeenvincha Block 3, Snowflake catcher
SnowFlake [] flake;
public void setup()
{
  size(500, 500);
  flake = new SnowFlake[100];
  for (int i = 0; i < flake.length; i++)
  {
    flake[i] = new SnowFlake((i*5), (int)(Math.random()*500), (Math.random()*4.5f)+1.5f);
  }
  noStroke();
  background(80);
}
public void draw()
{
  if(keyPressed == true && key == ' ')
  {
    background(80);
  }
  for (int i = 0; i < flake.length; i++)
  {
    flake[i].erase();
    flake[i].lookDown();
    flake[i].move();
    flake[i].wrap();
    flake[i].show();
  }
}
public void mouseDragged()
{
  if (mouseButton == LEFT)
  {
    fill(0xff71CEFF);
    ellipse(mouseX, mouseY, 20, 20);
  }
  if (mouseButton == RIGHT)
  {
    fill(80);
    ellipse(mouseX, mouseY, 25, 25);
  }
}

class SnowFlake
{
  int mX, mY;
  double mSpeed;
  boolean isMoving;
  SnowFlake(int x, int y, double speed)
  {
    mX = x;
    mY = y;
    mSpeed = speed;
  }
  public void show()
  {
    fill(255);
    ellipse(mX, mY, 5, 5);
  }
  public void lookDown()
  {
    if (mY <= 500 || mY >= 0)
    {
      if (get(mX, mY+5) != color(80))
      {
        isMoving = false;
      }
      else
      {
        isMoving = true;
      }
    }
  }
  public void erase()
  {
    fill(80);
    ellipse(mX, mY, 8, 8);
  }
  public void move()
  {
    if (isMoving == true)
    {
      mY += mSpeed;
    }
  }
  public void wrap()
  {
    if (mY > 494)
    {
      mY = 0;
      mSpeed = (Math.random()*4.5f)+1.5f;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
