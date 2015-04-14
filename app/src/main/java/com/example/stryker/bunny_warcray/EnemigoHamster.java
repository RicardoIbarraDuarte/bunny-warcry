package com.example.stryker.bunny_warcray;

import android.util.Log;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class EnemigoHamster extends Enemigo {

    private int direccion;
    private int direccionAnterior;
    private int tiempo = 0;

    public void crearEnemigo(float x, float y, ITextureRegion regionEnemigo,
                             VertexBufferObjectManager vbom){
        enemigo= new Sprite(x,y, regionEnemigo,vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        direccion = (int)((Math.random() * 4) + 1);
        direccionAnterior=direccion;
        posicionX = (int)((Math.random() * 539) + 159);
        posicionY = (int)((Math.random() * 549) + 179);
        vida=2;
        radioImagen=54;
        fuerza=1;
        velocidad=10;

    }

    public void dibujarEnemigo() {
        enemigo.setPosition(posicionX, posicionY);
        enemigo.setScale(.4f);
    }
    public void movimientoEnemigo(){


            if (direccion == 1) {
                float enemigoX = enemigo.getX();
                enemigoX = enemigoX + velocidad;
                if (enemigoX > 1100) {
                    direccion = 0;
                } else {
                    enemigo.setX(enemigoX);
                }

            }
            if (direccion == 2) {
                float enemigoX = enemigo.getX();
                enemigoX = enemigoX - velocidad;
                if (enemigoX < 180) {
                    direccion = 0;
                } else {
                    enemigo.setX(enemigoX);
                }

            }
            if (direccion == 3) {
                float enemigoY = enemigo.getY();
                enemigoY = enemigoY + velocidad;
                if (enemigoY > 540) {
                    direccion = 0;
                } else {
                    enemigo.setY(enemigoY);
                }

            }
            if (direccion == 4) {
                float enemigoY = enemigo.getY();
                enemigoY = enemigoY - velocidad;
                if (enemigoY < 160) {
                    direccion = 0;
                } else {
                    enemigo.setY(enemigoY);
                }
            }
            tiempo++;
            if (tiempo == 120 || direccion == 0) {
                direccion = (int) ((Math.random() * 4) + 1);
                while (direccion == direccionAnterior) {
                    direccion = (int) ((Math.random() * 4) + 1);
                }
                tiempo = 0;
                direccionAnterior = direccion;
            }
        }



}
