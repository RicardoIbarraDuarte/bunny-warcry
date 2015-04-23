package com.example.stryker.bunny_warcray;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by UAMI on 13/04/15.
 */
public class Enemigo {
    public int posicionX;
    public int posicionY;
    public AnimatedSprite enemigo;
    public int vida;
    public float velocidad;
    public int fuerza;
    public int radioImagen;
    public int radioImagenC;
    public int radioImagenN;
    public int radioImagenProyectil;
    public int direccion;
    public int direccionAnterior;
    public boolean dibujar=false;

    public void crearEnemigo(float x, float y, TiledTextureRegion[] regionHamster ,
                             VertexBufferObjectManager vbom){

    }

    public Sprite getEnemigo() {
        return enemigo;
    }

    public void liberar(){
        enemigo.detachSelf();   // Se desconecta de la escena
        enemigo.dispose();      // Libera la memoria
    }
    public void movimientoEnemigo(){

    }

    public void dibujarEnemigo(){

    }
    public void animarYami(){}

    public void setRadios() {

    }
}
