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
public class EscenaCreditos extends EscenaBase
{
    // *** Fondo
    private Sprite spriteFondo; //(el fondo de la escena, estático)

    @Override
    public void crearEscena() {
        if (!admRecursos.actividadJuego.musicaMenu.isPlaying()){
            admRecursos.actividadJuego.musicaMenu.play();

        }
        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionFondoCreditos,admRecursos.vbom) {
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

    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaCreditos();

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_CREDITOS;
    }

    @Override
    public void liberarEscena() {

        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
}
