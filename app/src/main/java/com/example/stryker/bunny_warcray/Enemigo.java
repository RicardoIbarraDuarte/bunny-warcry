package com.example.stryker.bunny_warcray;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by UAMI on 13/04/15.
 */
public class Enemigo {
    public int posicionX;
    public int posicionY;
    public Sprite enemigo;
    public int vida;
    public float velocidad;
    public int fuerza;
    public int radioImagen;

    public void crearEnemigo(float x, float y, ITextureRegion regionEnemigo,
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
}
