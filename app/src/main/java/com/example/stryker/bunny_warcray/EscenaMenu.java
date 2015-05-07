package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import java.io.IOException;

/**
 * Representa la escena con las opciones del menú principal
 *
 *
 */
public class EscenaMenu extends EscenaBase{
    // *** Fondo
    private Sprite spriteFondo; //(el fondo de la escena, estático)

    // *** Botones del menú
    private ButtonSprite btnJugar;
    private ButtonSprite btnAcerca;
    private ButtonSprite btnCreditos;
    private ButtonSprite btnOpciones;
    private boolean musicaGeneral;




    @Override
    public void crearEscena() {
        SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences("Sonido", Context.MODE_PRIVATE);
        musicaGeneral = preferencias.getBoolean("musicaGeneral",true);
        if (!admRecursos.actividadJuego.musicaMenu.isPlaying()&&musicaGeneral){
            admRecursos.actividadJuego.musicaMenu.play();

        }


        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionMenu,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        // Configuración de la imagen
        spriteFondo.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);

        // Crea el fondo de la pantalla
        SpriteBackground fondo = new SpriteBackground(0,0,0,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        // Habilita los eventos de touch en ciertas áreas
        setTouchAreaBindingOnActionDownEnabled(true);

        // *** Agrega los botones al Menú
        btnJugar = new ButtonSprite(640,156,
                admRecursos.regionBtnJugar,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de JUGAR
                    admEscenas.crearEscenaNiveles();
                    admEscenas.setEscena(TipoEscena.ESCENA_NIVELES);
                    admEscenas.liberarEscenaMenu();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnJugar.setScale(.8f);


        registerTouchArea(btnJugar);
        attachChild(btnJugar);
        btnAcerca = new ButtonSprite(226,300,
                admRecursos.regionBtnAcerca,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de acerca de
                    admEscenas.crearEscenaAcerca();
                    admEscenas.setEscena(TipoEscena.ESCENA_ACERCA_DE);
                    admEscenas.liberarEscenaMenu();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        btnAcerca.setScale(.8f);

        registerTouchArea(btnAcerca);
        attachChild(btnAcerca);
        btnCreditos = new ButtonSprite(1200,80,
                admRecursos.regionBtnCreditos,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de creditos
                    admEscenas.crearEscenaCreditos();
                    admEscenas.setEscena(TipoEscena.ESCENA_CREDITOS);
                    admEscenas.liberarEscenaMenu();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnCreditos.setScale(.7f);

        registerTouchArea(btnCreditos);
        attachChild(btnCreditos);
        btnOpciones = new ButtonSprite(1000,300,
                admRecursos.regionBtnOpciones,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de creditos
                    admEscenas.crearEscenaOpciones();
                    admEscenas.setEscena(TipoEscena.ESCENA_OPCIONES);
                    admEscenas.liberarEscenaMenu();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnOpciones.setScale(.8f);

        registerTouchArea(btnOpciones);
        attachChild(btnOpciones);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_MENU;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
    /*public Music getMusicaFondo(){
        return musicaFondo;
    }*/
}
