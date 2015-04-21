package com.example.stryker.bunny_warcray;

import android.util.Log;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class EnemigoPoruga extends Enemigo {


    private int tiempo = 0;
    private AnimatedSprite poruga[];
    private int fps=80;

    public void crearEnemigo(float x, float y, TiledTextureRegion[] regionPoruga,
                             VertexBufferObjectManager vbom){

        AnimatedSprite porugaFrente = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPoruga[0].getHeight(),
                regionPoruga[0],vbom);


        AnimatedSprite porugaAtras = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPoruga[1].getHeight(),
                regionPoruga[1],vbom);


        AnimatedSprite porugaDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPoruga[2].getHeight(),
                regionPoruga[2],vbom);


        AnimatedSprite porugaIzquierda = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionPoruga[3].getHeight(),
                regionPoruga[3],vbom);


        poruga = new AnimatedSprite[]{porugaFrente,porugaAtras,porugaDerecha,porugaIzquierda};

        direccion = 4;
        direccionAnterior=direccion;
        posicionX = (int)((Math.random() * 539) + 159);
        posicionY = (int)((Math.random() * 549) + 179);
        vida=2;
        radioImagen=54;
        fuerza=1;
        velocidad=5;
        enemigo=poruga[0];
        enemigo.animate(fps,100);

    }

    public void dibujarEnemigo() {
        enemigo.setPosition(posicionX, posicionY);
    }
    public void movimientoEnemigo(){
        if (direccion == 1) {
            float enemigoX = enemigo.getX();
            float enemigoY = enemigo.getY();
            enemigoX = enemigoX + velocidad;
            if (enemigoX > 1100) {
                direccion = 0;
            } else {
                poruga[2].setX(enemigoX);
                poruga[2].setY(enemigoY);
            }
            if (direccionAnterior!=direccion&&enemigoX<1100){
                enemigo.detachSelf();
                enemigo=poruga[2];
                enemigo.animate(fps,100);
                direccionAnterior = direccion;
                dibujar=true;

            }


        }
        if (direccion == 2) {
            float enemigoX = enemigo.getX();
            float enemigoY = enemigo.getY();
            enemigoX = enemigoX - velocidad;
            if (enemigoX < 180) {
                direccion = 0;
            } else {
                poruga[3].setX(enemigoX);
                poruga[3].setY(enemigoY);
            }
            if (direccionAnterior!=direccion&&enemigoX>180){
                enemigo.detachSelf();
                enemigo=poruga[3];
                enemigo.animate(fps,100);
                direccionAnterior = direccion;
                dibujar=true;
            }

        }
        if (direccion == 3) {
            float enemigoY = enemigo.getY();
            float enemigoX = enemigo.getX();
            enemigoY = enemigoY + velocidad;
            if (enemigoY > 540) {
                direccion = 0;
            } else {
                poruga[1].setY(enemigoY);
                poruga[1].setX(enemigoX);
            }
            if (direccionAnterior!=direccion&&enemigoY<540){
                enemigo.detachSelf();
                enemigo=poruga[1];
                enemigo.animate(fps,100);
                direccionAnterior = direccion;
                dibujar=true;
            }

        }
        if (direccion == 4) {
            float enemigoY = enemigo.getY();
            float enemigoX = enemigo.getX();
            enemigoY = enemigoY - velocidad;
            if (enemigoY < 160) {
                direccion = 0;
            } else {
                poruga[0].setY(enemigoY);
                poruga[0].setX(enemigoX);
            }
            if (direccionAnterior!=direccion&&enemigoY>160){
                enemigo.detachSelf();
                enemigo=poruga[0];
                enemigo.animate(fps,100);
                direccionAnterior = direccion;
                dibujar=true;
            }
        }
        tiempo++;
        if (tiempo == 120 || direccion == 0) {
            direccion = (int) ((Math.random() * 4) + 1);
            while (direccion == direccionAnterior) {
                direccion = (int) ((Math.random() * 4) + 1);
            }
            tiempo = 0;

        }
    }

}