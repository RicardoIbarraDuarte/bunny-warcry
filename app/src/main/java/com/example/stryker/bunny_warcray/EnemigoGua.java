package com.example.stryker.bunny_warcray;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class EnemigoGua extends Enemigo {

    private int direccion;
    private int direccionAnterior;
    private int tiempo = 0;
    private int tiempoAtaque = 0;
    private boolean ataqueInicio = true;
    private float xinicial;
    private float yinicial;
    private int fps = 80;
    private AnimatedSprite[] guaregiones;


    public void crearEnemigo(float x, float y, TiledTextureRegion[] regiongua,
                             VertexBufferObjectManager vbom) {
        AnimatedSprite gua = new AnimatedSprite(ControlJuego.ANCHO_CAMARA / 2,
                regiongua[0].getHeight(),
                regiongua[0], vbom);
        AnimatedSprite guaG = new AnimatedSprite(ControlJuego.ANCHO_CAMARA / 2,
                regiongua[1].getHeight(),
                regiongua[1], vbom);

        guaregiones = new AnimatedSprite[]{gua, guaG};


        direccion = (int) ((Math.random() * 4) + 1);
        direccionAnterior = direccion;
        posicionX = (int) ((Math.random() * 539) + 159);
        posicionY = (int) ((Math.random() * 549) + 179);
        vida = 2;

        fuerza = 1;
        velocidad = 5;
        radioImagenProyectil = 80;
        enemigo = guaregiones[0];
        enemigo.animate(fps, 100);


    }

    public void dibujarEnemigo() {
        enemigo.setScale(.4f);
        enemigo.setPosition(posicionX, posicionY);
    }

    public void movimientoEnemigo() {


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

    public void setRadios() {
        radioImagenN = 100;
        radioImagenC = 100;
    }
}


