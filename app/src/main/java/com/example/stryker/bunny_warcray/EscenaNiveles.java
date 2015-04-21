package com.example.stryker.bunny_warcray;

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

public class EscenaNiveles extends EscenaBase{
    // *** Fondo
    private Sprite spriteFondo; //(el fondo de la escena, estático)

    // *** Botones del menú
    private ButtonSprite btnN0;
    private ButtonSprite btnN1;
    private ButtonSprite btnN2;
    private ButtonSprite btnN3;
    private ButtonSprite btnN4;
    private ButtonSprite btnN5;

    @Override
    public void crearEscena() {
        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionFondoNivel,admRecursos.vbom) {
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
        btnN1 = new ButtonSprite(215,356,
                admRecursos.regionBtnN1,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de JUGAR
                    admEscenas.crearEscenaJuego1();
                    admEscenas.setEscena(TipoEscena.ESCENA_JUEGO1);
                    admEscenas.liberarEscenaNiveles();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        registerTouchArea(btnN1);
        attachChild(btnN1);

        btnN2 = new ButtonSprite(415,356,
                admRecursos.regionBtnN2,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de JUGAR
                    admEscenas.crearEscenaJuego2();
                    admEscenas.setEscena(TipoEscena.ESCENA_JUEGO2);
                    admEscenas.liberarEscenaNiveles();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        registerTouchArea(btnN2);
        attachChild(btnN2);

        btnN3 = new ButtonSprite(615,356,
                admRecursos.regionBtnN3,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionUp()) {
                    // Cambia a la escena de JUGAR
                    admEscenas.crearEscenaJuego3();
                    admEscenas.setEscena(TipoEscena.ESCENA_JUEGO3);
                    admEscenas.liberarEscenaNiveles();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        registerTouchArea(btnN3);
        attachChild(btnN3);

    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaNiveles();

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_NIVELES;
    }

    @Override
    public void liberarEscena() {

        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
}
