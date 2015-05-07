package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

/**
 * Representa la escena con las opciones del menú principal
 *
 * @author Roberto Martínez Román
 */
public class EscenaOpciones extends EscenaBase{
    // *** Fondo
    private Sprite spriteFondo; //(el fondo de la escena, estático)

    // *** Botones del menú
    private ButtonSprite btnSonidoOff;
    private ButtonSprite btnSonidoOn;
    private ButtonSprite btnBorrarStats;

    @Override
    public void crearEscena() {
        if (!admRecursos.actividadJuego.musicaMenu.isPlaying()){
            admRecursos.actividadJuego.musicaMenu.play();

        }
        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionFondoOpciones,admRecursos.vbom) {
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
        btnSonidoOff = new ButtonSprite(1014,398,
                admRecursos.regionBtnSonidoOff,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnSonidoOff.setScale(.5f);

        registerTouchArea(btnSonidoOff);
        attachChild(btnSonidoOff);
        btnSonidoOn = new ButtonSprite(825,398,
                admRecursos.regionBtnSonidoOn,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnSonidoOn.setScale(.5f);

        registerTouchArea(btnSonidoOn);
        attachChild(btnSonidoOn);
        btnBorrarStats = new ButtonSprite(825,233,
                admRecursos.regionBtnBorrarStats,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences(
                            "personaje", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putInt("ExperienciaTotal", 0);
                    editor.putInt("ExperienciaGanada", 0);
                    editor.putInt("PuntosUsados", 0);
                    editor.putInt("Fuerza", 0);
                    editor.putInt("Velocidad", 0);
                    editor.putInt("Vida", 0);
                    editor.putInt("Laser", 0);
                    editor.commit();

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        btnBorrarStats.setScale(.5f);

        registerTouchArea(btnBorrarStats);
        attachChild(btnBorrarStats);
    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaOpciones();


    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_OPCIONES;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
}
