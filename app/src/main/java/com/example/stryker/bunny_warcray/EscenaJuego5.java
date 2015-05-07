package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;

public class EscenaJuego5 extends EscenaBase
{


    private Personaje personaje;
    private DigitalOnScreenControl control;
    private TiledTextureRegion[] regionesPersonaje;
    private TiledTextureRegion[] regionesPersonajeQuieto;
    private TiledTextureRegion[] regionesPersonajeAtacando;
    private ButtonSprite btnAtacar;
    private boolean ataque = false;
    private boolean ataqueA = false;
    private float tiempoAtaque;
    private float tiempoDaño = 0;
    private boolean dañado = false;
    private Rectangle barraVida;
    private Sprite Fondo;
    private float anchoVida;
    private boolean acabarNivel=false;
    private int tipoNivel;
    private boolean faseDos = false;
    private Sprite barra;
    private int experienciaGanada;
    private ControlJuego preferencia;
    public AnimatedSprite mara1;
    public AnimatedSprite mara2;
    public boolean mara2Vivo=false;
    public float tiempo;
    public float radioMara=200;
    public float maraVida=50;
    public ButtonSprite btnlaser;
    private Sprite laser;
    private int tiempolaser;
    private boolean laserVivo;
    private int direcLaser;
    private int radiolaser=50;
    private boolean musicaGeneral;
    private boolean juegoEnPausa;
    private Scene escenaPausa;
    private ButtonSprite btnPausa;
    private ButtonSprite btnPausa2;
    private ButtonSprite btnMenu;
    private Sprite FondoPausa;



    @Override
    public void crearEscena() {
       SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences("Sonido", Context.MODE_PRIVATE);
        musicaGeneral = preferencias.getBoolean("musicaGeneral",true);
        if (musicaGeneral){
            admRecursos.actividadJuego.musicaJuego.play();
        }

        preferencia = admRecursos.actividadJuego;
        // Creamos el Fondo
        Fondo = new Sprite(0, 0, admRecursos.regionFondoJuego, admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        Fondo.setPosition(1280 / 2, 720 / 2);
        SpriteBackground fondo = new SpriteBackground(1, 0.3f, 0.3f, Fondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        // Creamos personaje
        regionesPersonaje = new TiledTextureRegion[]{admRecursos.regionCaminarFrente,
                admRecursos.regionCaminarAtras, admRecursos.regionCaminarDerecha,
                admRecursos.regionCaminarIzquierda, admRecursos.regionPersonajeGolpeado};
        personaje = new Personaje();
        personaje.crearStats(preferencia);
        personaje.crearPersonaje(0, 0, regionesPersonaje, admRecursos.vbom);
        regionesPersonajeAtacando = new TiledTextureRegion[]{admRecursos.regionPataqueFrente,
                admRecursos.regionPataqueAtras, admRecursos.regionPataqueDerecha,
                admRecursos.regionPataqueIzquierda};
        personaje.crearPersonajeAtacando(0, 0, regionesPersonajeAtacando, admRecursos.vbom);
        regionesPersonajeQuieto = new TiledTextureRegion[]{admRecursos.regionPersonajeFrente,
                admRecursos.regionPersonajeAtras, admRecursos.regionPersonajeDerecha,
                admRecursos.regionPersonajeIzquierda};
        personaje.crearPersonajeQuieto(0, 0, regionesPersonajeQuieto, admRecursos.vbom);
        personaje.dibujarPersonaje();
        attachChild(personaje.getPersonaje());

        //Creamos joystick
        agregarJoystick();

        //Creamos barra de vida
        anchoVida = 300;
        barraVida = new Rectangle(880, 680, anchoVida, 35, admRecursos.vbom);
        barraVida.setColor(1, 0, 0);  // RGB [0,1]
        barraVida.setAnchorCenterX(0);
        attachChild(barraVida);

        laser = new Sprite(0, 0, admRecursos.regionLaser, admRecursos.vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        btnlaser = new ButtonSprite(1150,250,admRecursos.regionBtnLaser,admRecursos.vbom){
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    if (!laserVivo) {
                        laserVivo=true;
                    }
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnlaser.setScale(.4f);

        registerTouchArea(btnlaser);
        attachChild(btnlaser);

        //Creamos boton de ataque
        btnAtacar = new ButtonSprite(1100, 120, admRecursos.regionBtnAtacar, admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    if (!dañado) {
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

        barra = new Sprite(880, 680, admRecursos.regionBarra, admRecursos.vbom);
        barra.setAnchorCenterX(0);
        attachChild(barra);

        btnPausa = new ButtonSprite(50,660,admRecursos.regionBtnPausa,admRecursos.vbom) {
            // Aquí el código que ejecuta el botón cuando es presionado
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float
                    pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    if(!juegoEnPausa){
                        Log.i("hola", "quitandopausa");
                        juegoEnPausa=true;
                    }

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        btnPausa.setScale(.4f);
        registerTouchArea(btnPausa);
        attachChild(btnPausa);


        mara1 = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                admRecursos.regionMara1.getHeight(),
                admRecursos.regionMara1,admRecursos.vbom);

        mara2 = new AnimatedSprite(ControlJuego.ANCHO_CAMARA/2,
                admRecursos.regionMara2.getHeight(),
                admRecursos.regionMara2,admRecursos.vbom);

        mara1.setPosition(1040,390);
        mara1.setScale(.5f);

        mara1.animate(80,100);

        attachChild(mara1);


        //Creamos el nivel aleatorio y los enemigos


        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
                if (juegoEnPausa){
                    setChildScene(escenaPausa,false,true,true);
                    return;
                }

                tiempo=tiempo+pSecondsElapsed;

                if (tiempo<4){
                    float x=mara1.getX();
                    mara1.setX(x-1.5f);
                }
                if (tiempo>4){
                    if (!mara2Vivo){
                        detachChild(mara1);
                        attachChild(mara2);
                        mara2.animate(80,true);
                        mara2Vivo=true;
                    }
                }
                if (tiempo>7 && !mara2Vivo){
                    acabarNivel=true;
                }


                comprobarDireccionPersonaje();
                if (ataque) {
                    atacarPersonaje();
                    tiempoAtaque = pSecondsElapsed + tiempoAtaque;
                    personaje.quieto = false;
                }
                if (tiempoAtaque > .3 && ataque) {
                    ataque = false;
                    personaje.getPersonaje().detachSelf();
                    attachChild(personaje.getPersonaje());
                    ataqueA = false;
                }
                ataqueEnemigos();
                ataqueLaser();
                comprobarColissionLaser();
                comprobarColission();
                comprobarColissionProyectiles();
                if (dañado) {
                    tiempoDaño = pSecondsElapsed + tiempoDaño;
                }
                if (tiempoDaño > .8) {
                    dañado = false;
                    personaje.setPersonaje(0);
                    attachChild(personaje.getPersonaje());
                    personaje.vida = personaje.vida - 1;
                    tiempoDaño = 0;
                }
                comprobarVida();
                terminarNivel();

            }

            @Override
            public void reset() {

            }

        });


    }

    @Override
    public void onBackKeyPressed() {
        if(!juegoEnPausa){
            Log.i("hola","quitandopausa");
            juegoEnPausa=true;
        }


    }

    public void agregarJoystick() {
        control = new DigitalOnScreenControl(180, 160, admRecursos.camara,
                admRecursos.regionFondoControl, admRecursos.regionBotonControl, 0.03f, false,
                admRecursos.vbom, new DigitalOnScreenControl.IOnScreenControlListener() {

            @Override
            public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX, float pValueY) {
                if (!ataque) {
                    personaje.quieto = false;
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
                    if (pValueX == 0.0 && pValueY == 0.0) {
                        personaje.quieto = true;


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
        return TipoEscena.ESCENA_JUEGO5;
    }

    @Override
    public void liberarEscena() {


        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }

    public void comprobarColission() {
            if (mara2Vivo) {
                float ex1 = mara2.getX();
                float ey1 = mara2.getY();
                float px = personaje.getPersonaje().getX();
                float py = personaje.getPersonaje().getY();

                if (mara2Vivo) {
                    if (ataque) {

                        if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                                < (radioMara + personaje.radioImagenAtacando) * (radioMara +
                                personaje.radioImagenAtacando) && mara2Vivo) {
                            if (ataque) {
                                if(personaje.fuerza==6 && personaje.fuerzaLaser==6){
                                    mara2.detachSelf();
                                    mara2Vivo = false;
                                    acabarNivel=true;

                                }

                            } else {
                                if (!dañado) {
                                    personaje.setPersonaje(4);
                                    attachChild(personaje.getPersonaje());
                                    dañado = true;
                                }

                            }
                        }
                    }else{
                        if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                                < (radioMara + personaje.radioImagen) * (radioMara +
                                personaje.radioImagen) && mara2Vivo) {

                                if (!dañado) {
                                    personaje.setPersonaje(4);
                                    attachChild(personaje.getPersonaje());
                                    dañado = true;
                                }


                        }

                    }
                }
            }


    }

    public void comprobarColissionProyectiles(){
        if (mara2Vivo) {
            /*
            float px = personaje.getPersonaje().getX();
            float py = personaje.getPersonaje().getY();
            float pr1x = proyectil1.getX();
            float pr1y = proyectil1.getY();
            float pr2x = proyectil2.getX();
            float pr2y = proyectil2.getY();
            float pr3x = proyectil3.getX();
            float pr3y = proyectil3.getY();


            if (((pr1x - px) * (pr1x - px)) + ((pr1y - py) * (pr1y - py))
                    < (radioImagenProyectil1 + personaje.radioImagen) * (radioImagenProyectil1 +
                    personaje.radioImagen) && proyectilesvivos) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr2x - px) * (pr2x - px)) + ((pr2y - py) * (pr2y - py))
                    < (radioImagenProyectil2 + personaje.radioImagen) * (radioImagenProyectil2 +
                    personaje.radioImagen) && proyectilesvivos) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr3x - px) * (pr3x - px)) + ((pr3y - py) * (pr3y - py))
                    < (radioImagenProyectil3 + personaje.radioImagen) * (radioImagenProyectil3 +
                    personaje.radioImagen) && proyectilesvivos) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            */
        }


    }

    public void atacarPersonaje() {
        if (!ataqueA) {
            personaje.atacarPersonaje();
            attachChild(personaje.getPersonaje());
            ataqueA = true;
        }
    }

    public void terminarNivel() {
        if (personaje.vida <= 0) {
            admEscenas.crearEscenaGameover();
            admEscenas.setEscena(TipoEscena.ESCENA_GAMEOVER);
            admEscenas.liberarEscenaJuego5();
            admRecursos.actividadJuego.musicaJuego.pause();
        }
        if (acabarNivel) {
            experienciaGanada = 120;
            SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences(
                    "personaje", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putInt("ExperienciaGanada", experienciaGanada);
            editor.commit();

            admEscenas.crearEscenaNiveles();
            admEscenas.setEscena(TipoEscena.ESCENA_NIVELES);
            admEscenas.liberarEscenaJuego1();
            admRecursos.actividadJuego.musicaJuego.pause();

        }

    }



    public void comprobarDireccionPersonaje() {
        if (personaje.direccion == 0 && personaje.direcAnte != 0) {
            personaje.setPersonaje(0);
            attachChild(personaje.getPersonaje());
        }
        if (personaje.direccion == 1 && personaje.direcAnte != 1) {
            personaje.setPersonaje(1);
            attachChild(personaje.getPersonaje());
        }
        if (personaje.direccion == 2 && personaje.direcAnte != 2) {
            personaje.setPersonaje(2);
            attachChild(personaje.getPersonaje());
        }
        if (personaje.direccion == 3 && personaje.direcAnte != 3) {
            personaje.setPersonaje(3);
            attachChild(personaje.getPersonaje());
        }
        if (personaje.quieto&&!dañado) {
            if (personaje.direccion == 0) {
                personaje.setPersonajeQuieto(0);
                attachChild(personaje.getPersonaje());
            }
            if (personaje.direccion == 1) {
                personaje.setPersonajeQuieto(1);
                attachChild(personaje.getPersonaje());
            }
            if (personaje.direccion == 2) {
                personaje.setPersonajeQuieto(2);
                attachChild(personaje.getPersonaje());
            }
            if (personaje.direccion == 3) {
                personaje.setPersonajeQuieto(3);
                attachChild(personaje.getPersonaje());
            }


        }
    }

    public void comprobarVida() {
        if (personaje.vidaA != personaje.vida) {
            detachChild(barraVida);
            detachChild(barra);
            anchoVida = personaje.vida * 300 / personaje.vidaTotal;
            barraVida = new Rectangle(880, 680, anchoVida, 35, admRecursos.vbom);
            barraVida.setColor(1, 0, 0);  // RGB [0,1]
            barraVida.setAnchorCenterX(0);
            attachChild(barraVida);
            attachChild(barra);
            personaje.vidaA = personaje.vida;
        }
    }

    public void ataqueEnemigos() {

    }

    public void ataqueMara() {


    }
    public void comprobarColissionLaser(){

            if (mara2Vivo) {
                float e1x = mara2.getX();
                float e1y = mara2.getY();
                float pr1x = laser.getX();
                float pr1y = laser.getY();

                if (((pr1x - e1x) * (pr1x - e1x)) + ((pr1y - e1y) * (pr1y - e1y))
                        < (radiolaser + radioMara) * (radiolaser +
                        radioMara) && laserVivo) {
                    maraVida = maraVida - personaje.fuerzaLaser;
                    if(personaje.fuerza==6 && personaje.fuerzaLaser==6){
                        mara2.detachSelf();
                        mara2Vivo = false;
                        acabarNivel=true;

                    }



                }

            }


    }
    public void ataqueLaser(){
        if (laserVivo) {
            if (tiempolaser == 0) {
                float px = personaje.getPersonaje().getX();
                float py = personaje.getPersonaje().getY();
                laser.setX(px);
                laser.setY(py);
                direcLaser = personaje.direccion;
                if (direcLaser == 0 ) {
                    laser.setRotation(90);
                }
                if (direcLaser == 1 ){
                    laser.setRotation(90);
                }
                if (direcLaser == 2 ) {
                    laser.setRotation(0);
                }
                if (direcLaser == 3 ){
                    laser.setRotation(0);
                }

                attachChild(laser);
            }
            if (direcLaser == 0) {
                laser.setY(laser.getY() - 9);
            }
            if (direcLaser == 1) {
                laser.setY(laser.getY() + 9);
            }
            if (direcLaser == 2) {
                laser.setX(laser.getX() + 9);
            }
            if (direcLaser == 3) {
                laser.setX(laser.getX() - 9);
            }
            tiempolaser++;
            if (tiempolaser == 70) {
                detachChild(laser);
                laserVivo = false;
                tiempolaser = 0;
            }



        }

    }
}

