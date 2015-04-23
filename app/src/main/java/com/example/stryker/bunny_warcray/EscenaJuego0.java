package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;


public class EscenaJuego0 extends EscenaBase
{


    private Sprite Fondo;
    private Sprite Fondo2;
    private Sprite Fondo3;
    private Sprite Fondo4;
    private float tiempotranscurrido=0;

    private boolean musicaGeneral;



    @Override
    public void crearEscena() {
        SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences("Sonido", Context.MODE_PRIVATE);
        musicaGeneral = preferencias.getBoolean("musicaGeneral",false);
        if (musicaGeneral){
            admRecursos.actividadJuego.musicaJuego0.play();
        }

        // Creamos el Fondo
        Fondo = new Sprite(0,0,admRecursos.regionFondo1,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Fondo.setPosition(1280 / 2, 720 / 2);
        SpriteBackground fondo = new SpriteBackground(1,0.3f,0.3f,Fondo);
        setBackground(fondo);
        setBackgroundEnabled(true);
        Fondo2 = new Sprite(0,0,admRecursos.regionFondo2,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Fondo2.setPosition(1280 / 2, 720 / 2);
        Fondo3 = new Sprite(0,0,admRecursos.regionFondo3,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Fondo3.setPosition(1280 / 2, 720 / 2);
        Fondo4 = new Sprite(0,0,admRecursos.regionFondo4,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Fondo4.setPosition(1280 / 2, 720 / 2);


        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
                tiempotranscurrido=tiempotranscurrido+pSecondsElapsed;
                if (tiempotranscurrido>=6&&tiempotranscurrido<11){
                    SpriteBackground fondo = new SpriteBackground(1,0.3f,0.3f,Fondo2);
                    setBackground(fondo);
                    setBackgroundEnabled(true);
                }
                if (tiempotranscurrido>=11&&tiempotranscurrido<16){
                    SpriteBackground fondo = new SpriteBackground(1,0.3f,0.3f,Fondo3);
                    setBackground(fondo);
                    setBackgroundEnabled(true);
                }
                if (tiempotranscurrido>=16&&tiempotranscurrido<21){
                    SpriteBackground fondo = new SpriteBackground(1,0.3f,0.3f,Fondo4);
                    setBackground(fondo);
                    setBackgroundEnabled(true);
                }
                if (tiempotranscurrido>21){
                    admEscenas.crearEscenaNiveles();
                    admEscenas.setEscena(TipoEscena.ESCENA_NIVELES);
                    admEscenas.liberarEscenaJuego0();
                    admRecursos.actividadJuego.musicaJuego0.stop();

                }



            }

            @Override
            public void reset() {

            }

        });


    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaNiveles();
        admEscenas.setEscena(TipoEscena.ESCENA_NIVELES);
        admEscenas.liberarEscenaJuego0();
        admRecursos.actividadJuego.musicaJuego0.stop();

    }


    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_JUEGO0;
    }

    @Override
    public void liberarEscena() {


        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }



}
