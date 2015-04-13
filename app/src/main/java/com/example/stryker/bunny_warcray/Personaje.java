package com.example.stryker.bunny_warcray;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class Personaje {
    private Sprite personaje;
    public float velocidadPersonaje = 10;
    public int vidaTotal=3;
    public int vida;
    public int vidaA;
    public int fuerza;
    public int direccion;
    public int direcAnte;
    public float experiencia;
    private Sprite[] imgsPersonaje;
    public int radioImagen;
    private AnimatedSprite[] pataque;
    private AnimatedSprite personajeAtacando;

    public Sprite getPersonaje() {
            return personaje;
    }
    public AnimatedSprite getPersonajeAtacando(){
        return personajeAtacando;
    }

    public void crearPersonaje(float x, float y, ITextureRegion[] regionPersonaje,
                               VertexBufferObjectManager vbom){
        Sprite personajeFrente = new Sprite(0,0,regionPersonaje[0],vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Sprite personajeAtras = new Sprite(0,0,regionPersonaje[1],vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Sprite personajeDerecha = new Sprite(0,0,regionPersonaje[2],vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Sprite personajeIzquierda= new Sprite(0,0,regionPersonaje[3],vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Sprite personajeGolpeado= new Sprite(0,0,regionPersonaje[4],vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };



        imgsPersonaje = new Sprite []{personajeFrente,personajeAtras,personajeDerecha,
                personajeIzquierda,personajeGolpeado};

        personaje = imgsPersonaje[0];
        radioImagen= 66;

        direccion = 0;
        direcAnte = 0;
        vida=vidaTotal;
        vidaA=vida;
        fuerza=1;

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

    public void dibujarPersonaje(){
        personaje.setPosition(880,360);
        personaje.setScale(.4f);
    }
    public void setPersonaje(int img){

        if(img==0) {
            imgsPersonaje[0].setX(personaje.getX());
            imgsPersonaje[0].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[0];
            personaje.setScale(.4f);
            radioImagen= 66;
            direcAnte= 0;
        }
        if(img==1){
            imgsPersonaje[1].setX(personaje.getX());
            imgsPersonaje[1].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[1];
            personaje.setScale(.4f);
            radioImagen= 66;
            direcAnte=1;
        }
        if(img==2){
            imgsPersonaje[2].setX(personaje.getX());
            imgsPersonaje[2].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[2];
            personaje.setScale(.4f);
            radioImagen= 58;
            direcAnte=2;
        }
        if(img==3) {
            imgsPersonaje[3].setX(personaje.getX());
            imgsPersonaje[3].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[3];
            personaje.setScale(.4f);
            radioImagen= 58;
            direcAnte=3;
        }
        if (img==4){
            imgsPersonaje[4].setX(personaje.getX());
            imgsPersonaje[4].setY(personaje.getY());
            personaje.detachSelf();
            personaje = imgsPersonaje[4];
        }
    }
    public void atacarPersonaje() {

        if (direccion==0) {
            pataque[0].setX(personaje.getX());
            pataque[0].setY(personaje.getY());
            personaje.detachSelf();
            personajeAtacando=pataque[0];
            personajeAtacando.animate(50,1);
        }
        if (direccion==1) {
            pataque[1].setX(personaje.getX());
            pataque[1].setY(personaje.getY());
            personaje.detachSelf();
            personajeAtacando=pataque[1];
            personajeAtacando.animate(50,1);
        }
        if (direccion==2) {
            pataque[2].setX(personaje.getX());
            pataque[2].setY(personaje.getY());
            personaje.detachSelf();
            personajeAtacando=pataque[2];
            personajeAtacando.animate(50,1);
        }
        if (direccion==3) {
            pataque[3].setX(personaje.getX());
            pataque[3].setY(personaje.getY());
            personaje.detachSelf();
            personajeAtacando=pataque[3];
            personajeAtacando.animate(50,1);
        }
    }

    public void setVida(){
        vidaTotal=vidaTotal+1;
    }
    public float getExperiencia(){
        return experiencia;
    }

}