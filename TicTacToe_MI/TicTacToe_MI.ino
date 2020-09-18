const int b = 2;
const int c = 3;
const int d = 4;
const int e = 5;
const bool h = HIGH;
const bool l = LOW;
const int gr = 13;
const int bl = 12;

void setup() {
  // put your setup code here, to run once:
  pinMode(b, OUTPUT);
  pinMode(c, OUTPUT);
  pinMode(d, OUTPUT);
  pinMode(e, OUTPUT);
  pinMode(gr, OUTPUT);
  pinMode(bl, OUTPUT);
}
const int de = 2000;
void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(b, l);
  digitalWrite(c, l);
  digitalWrite(d, l);
  digitalWrite(e, l);
  digitalWrite(gr, l);
  digitalWrite(bl, l);
  blue();
  delay(de);
  p1();
  delay(de);
  p2();
  delay(de);
  p3();
  delay(de);
  p4();
  delay(de);
  p5();
  delay(de);
  p6();
  delay(de);
  p7();
  delay(de);
  p8();
  delay(de);
  p9();
  delay(de);
}

void p1 (){
  digitalWrite(b, l);
  digitalWrite(c, l);
  digitalWrite(d, l);
  digitalWrite(e, h);
}

void p2 (){
  digitalWrite(b, l);
  digitalWrite(c, l);
  digitalWrite(d, h);
  digitalWrite(e, l);
}

void p3 (){
  digitalWrite(b, l);
  digitalWrite(c, l);
  digitalWrite(d, h);
  digitalWrite(e, h);
}

void p4 (){
  digitalWrite(b, l);
  digitalWrite(c, h);
  digitalWrite(d, l);
  digitalWrite(e, l);
}

void p5 (){
  digitalWrite(b, l);
  digitalWrite(c, h);
  digitalWrite(d, l);
  digitalWrite(e, h);
}

void p6 (){
  digitalWrite(b, l);
  digitalWrite(c, h);
  digitalWrite(d, h);
  digitalWrite(e, l);
}

void p7 (){
  digitalWrite(b, l);
  digitalWrite(c, h);
  digitalWrite(d, h);
  digitalWrite(e, h);
}

void p8 (){
  digitalWrite(b, h);
  digitalWrite(c, l);
  digitalWrite(d, l);
  digitalWrite(e, l);
}

void p9 (){
  digitalWrite(b, h);
  digitalWrite(c, l);
  digitalWrite(d, l);
  digitalWrite(e, h);
}

void green () {
  digitalWrite(gr, h);
  digitalWrite(bl, l);
}

void blue() {
  digitalWrite(gr, l);
  digitalWrite(bl, h);
}

void cOff() {
  digitalWrite(gr, l);
  digitalWrite(bl, l);  
}
