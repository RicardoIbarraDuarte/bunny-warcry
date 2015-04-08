package com.example.stryker.bunny_warcray;

import android.util.Log;

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

public class EscenaJuego extends EscenaBase
{

    private EnemigoHamster hamster1;
    private boolean hamster1Vivo = true;
    private EnemigoHamster hamster2;
    private EnemigoHamster hamster3;
    private Personaje personaje;
    private DigitalOnScreenControl control;
    private ITextureRegion[] regionesPersonaje;
    private TiledTextureRegion[] regionesPersonajeAtacando;
    private ButtonSprite btnAtacar;
    private boolean ataque =false;
    private boolean ataqueA=false;
    private float tiempoAtaque;
    private float tiempoDaño=0;
    private boolean dañado=true;
    private Rectangle barraVida;
    private Sprite Fondo;
    private float anchoVida;


    @Override
    public void crearEscena() {
        // Creamos el Fondo
        Fondo = new Sprite(0,0,admRecursos.regionFondoJuego,admRecursos.vbom) {
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

        regionesPersonaje = new ITextureRegion[]{admRecursos.regionPersonajeFrente,
                admRecursos.regionPersonajeAtras,admRecursos.regionPersonajeDerecha,
                admRecursos.regionPersonajeIzquierda,admRecursos.regionPersonajeGolpeado};
        personaje = new Personaje();
        personaje.crearPersonaje(0,0,regionesPersonaje,admRecursos.vbom);
        regionesPersonajeAtacando= new TiledTextureRegion[]{admRecursos.regionPataqueFrente,
                admRecursos.regionPataqueAtras,admRecursos.regionPataqueDerecha,
                admRecursos.regionPataqueIzquierda};
        personaje.crearPersonajeAtacando(0,0,regionesPersonajeAtacando,admRecursos.vbom);
        //crear enemigo
        hamster1 = new EnemigoHamster();
        hamster1.crearEnemigo(0,0,admRecursos.regionEnemigo,admRecursos.vbom);
        hamster2 = new EnemigoHamster();
        hamster2.crearEnemigo(0,0,admRecursos.regionEnemigo,admRecursos.vbom);
        hamster3 = new EnemigoHamster();
        hamster3.crearEnemigo(0,0,admRecursos.regionEnemigo,admRecursos.vbom);

        // Configuración de la imagen


        // Crea el fondo de la pantalla


        btnAtacar = new ButtonSprite(1100,150,admRecursos.regionBtnAtacar,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    if (dañado) {
                        ataque = true;
                        tiempoAtaque = 0;
                    }
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnAtacar.setScale(.4f);
        registerTouchArea(btnAtacar);
        attachChild(btnAtacar);

        //dibujar enemigo
        hamster1.dibujarEnemigo();
        hamster2.dibujarEnemigo();
        hamster3.dibujarEnemigo();
        personaje.dibujarPersonaje();
        attachChild(hamster1.getEnemigo());
        //attachChild(hamster2.getEnemigo());
        //attachChild(hamster3.getEnemigo());
        attachChild(personaje.getPersonaje());
        agregarJoystick();
        anchoVida=300;
        barraVida = new Rectangle(1100,520,anchoVida,55,admRecursos.vbom);
        barraVida.setColor(1,0,0);  // RGB [0,1]
        attachChild(barraVida);

        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
                hamster1.movimientoEnemigo(personaje.getPersonaje());
                //hamster2.movimientoEnemigo();
                //hamster3.movimientoEnemigo();
                if (personaje.direccion==0 && personaje.direcAnte!=0){
                    personaje.setPersonaje(0);
                    attachChild(personaje.getPersonaje());
                }

                if (personaje.direccion==1 && personaje.direcAnte!=1){
                    personaje.setPersonaje(1);
                    attachChild(personaje.getPersonaje());
                }
                if (personaje.direccion==2 && personaje.direcAnte!=2){
                    personaje.setPersonaje(2);
                    attachChild(personaje.getPersonaje());
                }
                if (personaje.direccion==3 && personaje.direcAnte!=3){
                    personaje.setPersonaje(3);
                    attachChild(personaje.getPersonaje());
                }

                //Log.i("hola","valor"+pSecondsElapsed);
                if (ataque){
                    atacarPersonaje();
                    tiempoAtaque=pSecondsElapsed+tiempoAtaque;
                }
                if (tiempoAtaque>.3&&ataque){
                    ataque=false;
                    personaje.getPersonajeAtacando().detachSelf();
                    attachChild(personaje.getPersonaje());
                    ataqueA=false;
                }

                comprobarColission();
                if (!dañado){
                    tiempoDaño=pSecondsElapsed+tiempoDaño;
                }
                if (tiempoDaño>.6){
                    dañado=true;
                    personaje.setPersonaje(0);
                    attachChild(personaje.getPersonaje());
                    tiempoDaño=0;
                }

            }

            @Override
            public void reset() {

            }

        });
        //botones del movimiento


    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaJuego();

    }
    public void agregarJoystick() {
        control = new DigitalOnScreenControl(180, 160, admRecursos.camara,
                admRecursos.regionFondoControl,admRecursos.regionBotonControl, 0.03f,false,
                admRecursos.vbom, new DigitalOnScreenControl.IOnScreenControlListener(){

            @Override
            public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX, float pValueY) {
                if (!ataque) {
                    float x = personaje.getPersonaje().getX() + personaje.velocidadPersonaje *
                            pValueX;
                    float y = personaje.getPersonaje().getY() + personaje.velocidadPersonaje *
                            pValueY;
                    if (x > 1100 || x < 180) {
                        x = personaje.getPersonaje().getX();
                    }
                    if (y > 540 || y < 160) {
                        y = personaje.getPersonaje().getY();
                    }
                    personaje.getPersonaje().setPosition(x, y);

                    if (pValueY == -1.0 && personaje.direcAnte != 0) {
                        personaje.direccion = 0;

                    }

                    if (pValueY == 1.0 && personaje.direcAnte != 1) {
                        personaje.direccion = 1;

                    }
                    if (pValueX == 1.0 && personaje.direcAnte != 2) {
                        personaje.direccion = 2;

                    }
                    if (pValueX == -1.0 && personaje.direcAnte != 3) {
                        personaje.direccion = 3;


                    }

                    //Log.i("valor","valor"+pValueX);
                    //Log.i("valor","valor"+pValueY);
                }
            }
        });
        final Sprite botonControl = control.getControlKnob();
        botonControl.setScale(2f);


        setChildScene(control);

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_JUEGO;
    }

    @Override
    public void liberarEscena() {


        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
    public void comprobarColission() {
        float ex1 = hamster1.getEnemigo().getX();
        float ex2 = hamster2.getEnemigo().getX();
        float ex3 = hamster3.getEnemigo().getX();
        float ey1 = hamster1.getEnemigo().getY();
        float ey2 = hamster2.getEnemigo().getY();
        float ey3 = hamster3.getEnemigo().getY();
        float px = personaje.getPersonaje().getX();
        float py = personaje.getPersonaje().getY();


        if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                < (hamster1.radioImagen + personaje.radioImagen) * (hamster1.radioImagen +
                personaje.radioImagen)&&hamster1Vivo) {
            if (ataque) {
                hamster1.getEnemigo().detachSelf();
                hamster1Vivo=false;
            } else {
                if (dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    detachChild(barraVida);
                    anchoVida = anchoVida-100;
                    barraVida = new Rectangle(1100,520,anchoVida,55,admRecursos.vbom);
                    barraVida.setColor(1,0,0);  // RGB [0,1]
                    attachChild(barraVida);
                    dañado = false;
                }

            }
        }
    }

    public void atacarPersonaje() {
        if (!ataqueA) {
            personaje.atacarPersonaje();
            attachChild(personaje.getPersonajeAtacando());
            ataqueA=true;
        }
    }
}

