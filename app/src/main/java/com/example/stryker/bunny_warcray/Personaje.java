package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class Personaje {
    private AnimatedSprite personaje;
    public float velocidadPersonaje;
    public int vidaTotal;
    public int vida;
    public int vidaA;
    public int fuerza;
    public int fuerzaLaser;
    public int direccion;
    public int direcAnte;
    public float experiencia;
    private AnimatedSprite[] imgsPersonaje;
    private AnimatedSprite[] imgsPersonajeQuieto;
    public int radioImagen;
    public int radioImagenAtacando;
    private AnimatedSprite[] pataque;
    public boolean quieto=true;
    private int fps=80;
    public SharedPreferences preferencias;

    public AnimatedSprite getPersonaje() {
            return personaje;
    }

    public void crearPersonaje(float x, float y, TiledTextureRegion[] regionPersonaje,
                               VertexBufferObjectManager vbom){
        AnimatedSprite personajeFrente = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPersonaje[0].getHeight(),
                regionPersonaje[0],vbom);
        AnimatedSprite personajeAtras = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPersonaje[1].getHeight(),
                regionPersonaje[1],vbom);
        AnimatedSprite personajeDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPersonaje[2].getHeight(),
                regionPersonaje[2],vbom);
        AnimatedSprite personajeIzquierda= new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPersonaje[3].getHeight(),
                regionPersonaje[3],vbom);

        AnimatedSprite personajeGolpeado= new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPersonaje[4].getHeight(),
                regionPersonaje[4],vbom);



        imgsPersonaje = new AnimatedSprite []{personajeFrente,personajeAtras,personajeDerecha,
                personajeIzquierda,personajeGolpeado};

        personaje = imgsPersonaje[0];
        radioImagen= 100;
        radioImagenAtacando= 120;

        direccion = 0;
        direcAnte = 0;
        vida=vidaTotal;
        vidaA=vida;

        personaje.animate(fps,100);

    }
    public void crearPersonajeAtacando(float x, float y, TiledTextureRegion[] regionAtaques,
                                       VertexBufferObjectManager vbom){

        AnimatedSprite pataqueFrente = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[0].getHeight(),
                regionAtaques[0],vbom);


        AnimatedSprite pataqueAtras = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[1].getHeight(),
                regionAtaques[1],vbom);


        AnimatedSprite pataqueDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[2].getHeight(),
                regionAtaques[2],vbom);


        AnimatedSprite pataqueIzquierda = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[3].getHeight(),
                regionAtaques[3],vbom);


        pataque = new AnimatedSprite[]{pataqueFrente,pataqueAtras,pataqueDerecha,pataqueIzquierda};


    }

    public void crearPersonajeQuieto(float x, float y, TiledTextureRegion[] regionAtaques,
                                       VertexBufferObjectManager vbom){

        AnimatedSprite quietoFrente = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[0].getHeight(),
                regionAtaques[0],vbom);
        quietoFrente.setScale(1.1f);


        AnimatedSprite quietoAtras = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[1].getHeight(),
                regionAtaques[1],vbom);
        quietoAtras.setScale(1.1f);


        AnimatedSprite quietoDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[2].getHeight(),
                regionAtaques[2],vbom);
        quietoDerecha.setScale(1.1f);


        AnimatedSprite quietoIzquierda = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionAtaques[3].getHeight(),
                regionAtaques[3],vbom);
        quietoIzquierda.setScale(1.1f);


        imgsPersonajeQuieto = new AnimatedSprite[]{quietoFrente,quietoAtras,quietoDerecha,quietoIzquierda};


    }
    public void dibujarPersonaje(){
        personaje.setPosition(880,360);

    }
    public void setPersonaje(int img){

        if(img==0) {
            imgsPersonaje[0].setX(personaje.getX());
            imgsPersonaje[0].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[0];
            radioImagen= 66;
            direcAnte= 0;
            personaje.animate(fps,100);
        }
        if(img==1){
            imgsPersonaje[1].setX(personaje.getX());
            imgsPersonaje[1].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[1];
            radioImagen= 66;
            direcAnte=1;
            personaje.animate(fps,100);
        }
        if(img==2){
            imgsPersonaje[2].setX(personaje.getX());
            imgsPersonaje[2].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[2];
            radioImagen= 58;
            direcAnte=2;
            personaje.animate(fps,100);
        }
        if(img==3) {
            imgsPersonaje[3].setX(personaje.getX());
            imgsPersonaje[3].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[3];;
            radioImagen= 58;
            direcAnte=3;
            personaje.animate(fps,100);
        }
        if (img==4){
            imgsPersonaje[4].setX(personaje.getX());
            imgsPersonaje[4].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[4];

        }
    }
    public void setPersonajeQuieto(int img){

        if(img==0) {
            imgsPersonajeQuieto[0].setX(personaje.getX());
            imgsPersonajeQuieto[0].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonajeQuieto[0];
            radioImagen= 66;
            direcAnte= 0;

        }
        if(img==1){
            imgsPersonajeQuieto[1].setX(personaje.getX());
            imgsPersonajeQuieto[1].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonajeQuieto[1];
            radioImagen= 66;
            direcAnte=1;

        }
        if(img==2){
            imgsPersonajeQuieto[2].setX(personaje.getX());
            imgsPersonajeQuieto[2].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonajeQuieto[2];
            radioImagen= 58;
            direcAnte=2;

        }
        if(img==3) {
            imgsPersonajeQuieto[3].setX(personaje.getX());
            imgsPersonajeQuieto[3].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonajeQuieto[3];;
            radioImagen= 58;
            direcAnte=3;

        }
    }
    public void atacarPersonaje() {

        if (direccion==0) {
            pataque[0].setX(personaje.getX());
            pataque[0].setY(personaje.getY());
            personaje.detachSelf();
            personaje=pataque[0];
            personaje.animate(50,true);
        }
        if (direccion==1) {
            pataque[1].setX(personaje.getX());
            pataque[1].setY(personaje.getY());
            personaje.detachSelf();
            personaje=pataque[1];
            personaje.animate(50,true);
        }
        if (direccion==2) {
            pataque[2].setX(personaje.getX());
            pataque[2].setY(personaje.getY());
            personaje.detachSelf();
            personaje=pataque[2];
            personaje.animate(50,true);
        }
        if (direccion==3) {
            pataque[3].setX(personaje.getX());
            pataque[3].setY(personaje.getY());
            personaje.detachSelf();
            personaje=pataque[3];
            personaje.animate(50,true);
        }
    }
    public void crearStats(ControlJuego preferencia){
        int fuerzaB;
        int velocidadB;
        int vidaB;
        int laserB;
        SharedPreferences preferencias = preferencia.getSharedPreferences("personaje", Context.MODE_PRIVATE);
        fuerzaB = preferencias.getInt("Fuerza",0);
        velocidadB = preferencias.getInt("Velocidad",0);
        vidaB = preferencias.getInt("Vida",0);
        laserB = preferencias.getInt("Laser",0);

        if (fuerzaB==0){
            fuerza=1;
        }
        if (fuerzaB==1){
            fuerza=2;
        }
        if (fuerzaB==2){
            fuerza=3;
        }
        if (fuerzaB==3){
            fuerza=4;
        }
        if (fuerzaB==4){
            fuerza=5;
        }
        if (fuerzaB==5){
            fuerza=6;
        }
        if (velocidadB==0){
            velocidadPersonaje=8;
        }
        if (velocidadB==1){
            velocidadPersonaje=10;
        }
        if (velocidadB==2){
            velocidadPersonaje=13;
        }
        if (velocidadB==3){
            velocidadPersonaje=15;
        }
        if (velocidadB==4){
            velocidadPersonaje=17;
        }
        if (velocidadB==5){
            velocidadPersonaje=20;
        }
        if (vidaB==0){
            vidaTotal=3;
        }
        if (vidaB==1){
            vidaTotal=5;
        }
        if (vidaB==2){
            vidaTotal=7;
        }
        if (vidaB==3){
            vidaTotal=9;
        }
        if (vidaB==4){
            vidaTotal=11;
        }
        if (vidaB==5){
            vidaTotal=13;
        }
        if (laserB==0){
            fuerzaLaser=1;
        }
        if (laserB==1){
            fuerzaLaser=2;
        }
        if (laserB==2){
            fuerzaLaser=3;
        }
        if (laserB==3){
            fuerzaLaser=4;
        }
        if (laserB==4){
            fuerzaLaser=5;
        }
        if (laserB==5){
            fuerzaLaser=6;
        }




    }

}