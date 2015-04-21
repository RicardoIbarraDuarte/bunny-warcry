package com.example.stryker.bunny_warcray;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class EnemigoYami extends Enemigo {


    private int tiempo = 0;
    private AnimatedSprite yamile[];
    private int fps=80;

    public void crearEnemigo(float x, float y, TiledTextureRegion[] regionYami,
                             VertexBufferObjectManager vbom){

        AnimatedSprite yamiDerecha = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionYami[0].getHeight(),
                regionYami[0],vbom);


        AnimatedSprite yamiIzquierda = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                regionYami[1].getHeight(),
                regionYami[1],vbom);


        yamile = new AnimatedSprite[]{yamiDerecha,yamiIzquierda};

        direccion = 1;
        direccionAnterior=direccion;
        posicionX = (int)((Math.random() * 539) + 159);
        posicionY = (int)((Math.random() * 549) + 179);
        vida=2;
        radioImagen=54;
        fuerza=1;
        velocidad=5;
        enemigo=yamile[0];
        enemigo.animate(fps,100);

    }

    public void dibujarEnemigo() {
        enemigo.setPosition(posicionX, posicionY);
    }
    public void movimientoEnemigo(){
        if (direccion==1){
            enemigo=yamile[0];


        }
        if (direccion==2){
            enemigo=yamile[1];

        }


    }
    public void animarYami(){
        enemigo.animate(fps,100);


    }

}
