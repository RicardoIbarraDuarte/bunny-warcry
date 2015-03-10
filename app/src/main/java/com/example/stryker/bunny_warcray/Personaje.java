package com.example.stryker.bunny_warcray;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by Yamile Zahow on 27/02/2015.
 */
public class Personaje {
    private Sprite personaje;
    public float velocidadPersonaje = 50;
    public int direccion;
    public int direcAnte;
    private Sprite[] imgsPersonaje;
    public int radioImagen;

    public Sprite getPersonaje() {
        return personaje;
    }

    public void crearPersonaje(float x, float y, ITextureRegion[] regionPersonaje, VertexBufferObjectManager vbom){
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

        imgsPersonaje = new Sprite []{personajeFrente,personajeAtras,personajeDerecha,personajeIzquierda};

        personaje = imgsPersonaje[3];
        radioImagen= 66;

        direccion = 0;
        direcAnte = 0;

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
    }

    public void liberar(){
        personaje.detachSelf();   // Se desconecta de la escena
        personaje.dispose();      // Libera la memoria
    }

}