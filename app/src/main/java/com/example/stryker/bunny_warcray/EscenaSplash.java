package com.example.stryker.bunny_warcray;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

/**
 * Representa la escena que se muestra cuando se corre la aplicación
 */
public class EscenaSplash extends EscenaBase
{
    private Sprite spriteFondo; //(el fondo de la escena, estático)

    @Override
    public void crearEscena() {
        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionSplash,admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        // Configuración de la imagen
        spriteFondo.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);

        // Crea el fondo de la pantalla
        SpriteBackground fondo = new SpriteBackground(1,0.5f,0,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_SPLASH;
    }

    @Override
    public void liberarEscena() {
        // Liberar cada recurso usado en esta escena
        spriteFondo.detachSelf();   // Se desconecta de la escena
        spriteFondo.dispose();      // Libera la memoria

        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
}
