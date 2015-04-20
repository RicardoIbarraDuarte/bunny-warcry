package com.example.stryker.bunny_warcray;

import android.util.Log;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class EnemigoHamster extends Enemigo {


    private int tiempo = 0;
    private AnimatedSprite hamster[];
    private int fps=80;

    public void crearEnemigo(float x, float y, TiledTextureRegion[] regionHamster,
                             VertexBufferObjectManager vbom){

         AnimatedSprite hamsterFrente = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionHamster[0].getHeight(),
                regionHamster[0],vbom);


        AnimatedSprite hamsterAtras = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionHamster[1].getHeight(),
                regionHamster[1],vbom);


        AnimatedSprite hamsterDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionHamster[2].getHeight(),
                regionHamster[2],vbom);


        AnimatedSprite hamsterIzquierda = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionHamster[3].getHeight(),
                regionHamster[3],vbom);


        hamster = new AnimatedSprite[]{hamsterFrente,hamsterAtras,hamsterDerecha,hamsterIzquierda};

        direccion = 4;
        direccionAnterior=direccion;
        posicionX = (int)((Math.random() * 539) + 159);
        posicionY = (int)((Math.random() * 549) + 179);
        vida=2;
        radioImagen=54;
        fuerza=1;
        velocidad=5;
        enemigo=hamster[0];
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
                    hamster[2].setX(enemigoX);
                    hamster[2].setY(enemigoY);
                }
                if (direccionAnterior!=direccion&&enemigoX<1100){
                    enemigo.detachSelf();
                    enemigo=hamster[2];
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
                    hamster[3].setX(enemigoX);
                    hamster[3].setY(enemigoY);
                }
                if (direccionAnterior!=direccion&&enemigoX>180){
                    enemigo.detachSelf();
                    enemigo=hamster[3];
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
                    hamster[1].setY(enemigoY);
                    hamster[1].setX(enemigoX);
                }
                if (direccionAnterior!=direccion&&enemigoY<540){
                    enemigo.detachSelf();
                    enemigo=hamster[1];
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
                    hamster[0].setY(enemigoY);
                    hamster[0].setX(enemigoX);
                }
                if (direccionAnterior!=direccion&&enemigoY>160){
                    enemigo.detachSelf();
                    enemigo=hamster[0];
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
