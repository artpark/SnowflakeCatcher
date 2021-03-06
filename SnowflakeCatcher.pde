//Art Parkeenvincha Block 3, Snowflake catcher
SnowFlake [] flake;
void setup()
{
  size(500, 500);
  flake = new SnowFlake[100];
  for (int i = 0; i < flake.length; i++)
  {
    flake[i] = new SnowFlake((i*5), (int)(Math.random()*500), (Math.random()*4.5)+1.5);
  }
  noStroke();
  background(80);
}
void draw()
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
void mouseDragged()
{
  if (mouseButton == LEFT)
  {
    fill(#71CEFF);
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
  void show()
  {
    fill(255);
    ellipse(mX, mY, 5, 5);
  }
  void lookDown()
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
  void erase()
  {
    fill(80);
    ellipse(mX, mY, 8, 8);
  }
  void move()
  {
    if (isMoving == true)
    {
      mY += mSpeed;
    }
  }
  void wrap()
  {
    if (mY > 494)
    {
      mY = 0;
      mSpeed = (Math.random()*4.5)+1.5;
    }
  }
}
