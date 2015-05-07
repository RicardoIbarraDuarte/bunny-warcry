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
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;

public class EscenaJuego3 extends EscenaBase {

    private boolean Enemigo1Vivo = true;
    private boolean Enemigo2Vivo = true;
    private boolean Enemigo3Vivo = true;
    private boolean Enemigo4Vivo = true;
    private boolean Enemigo5Vivo = true;
    private boolean Enemigo6Vivo = true;
    private Enemigo Enemigo1;
    private Enemigo Enemigo2;
    private Enemigo Enemigo3;
    private Enemigo Enemigo4;
    private Enemigo Enemigo5;
    private Enemigo Enemigo6;
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
    private float enemigosVivos;
    private int tipoNivel;
    private boolean faseDos = false;
    private Sprite barra;
    private int experienciaGanada;
    private ControlJuego preferencia;
    public Sprite lagrima1;
    public Sprite lagrima2;
    public Sprite lagrima3;
    public Sprite lagrima4;
    public Sprite lagrima5;
    public Sprite lagrima6;
    public Sprite lagrima7;
    public Sprite lagrima8;
    private boolean ataqueInicio = true;
    private float xinicial;
    private float yinicial;
    private int tiempoAtaqueEspera = 100;
    private int tiempoAtaquelagrima1 = 0;
    private int tiempoAtaquelagrima2 = 0;
    private int tiempoAtaquelagrima3 = 0;
    private int tiempoAtaquelagrima4 = 0;
    private int tiempoAtaquelagrima5 = 0;
    private int tiempoAtaquelagrima6 = 0;
    private int tiempoAtaquelagrima7 = 0;
    private int tiempoAtaquelagrima8 = 0;
    private boolean lagrima1viva = false;
    private boolean lagrima2viva = false;
    private boolean lagrima3viva = false;
    private boolean lagrima4viva = false;
    private boolean lagrima5viva = false;
    private boolean lagrima6viva = false;
    private boolean lagrima7viva = false;
    private boolean lagrima8viva = false;
    private boolean yamiOculta = false;
    private float tiempoAtaqueyami = 0;
    private TiledTextureRegion[] EnemigoImagen1;
    private TiledTextureRegion[] EnemigoImagen2;
    private TiledTextureRegion[] EnemigoImagen3;
    private TiledTextureRegion[] EnemigoImagen4;
    private TiledTextureRegion[] EnemigoImagen5;
    private TiledTextureRegion[] EnemigoImagen6;
    private int randomCreepy;
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
        Enemigo1= new EnemigoYami();
        Enemigo2 = new EnemigoHamster();
        Enemigo3 = new EnemigoHamster();
        Enemigo4 = new EnemigoYami();
        Enemigo5 = new EnemigoGua();
        Enemigo6 = new EnemigoGua();
        Enemigo1.setRadios();
        Enemigo2.setRadios();
        Enemigo3.setRadios();
        Enemigo4.setRadios();
        Enemigo5.setRadios();
        Enemigo6.setRadios();

        int contador=0;
        while (contador<=6){
            randomCreepy=(int)((Math.random() * 10) + 1);
            if (contador==1&&randomCreepy<=8){
                EnemigoImagen1=admRecursos.regionesYami;
                Enemigo1.radioImagen=Enemigo1.radioImagenN;

            }
            if (contador==1&&randomCreepy>=9){
                EnemigoImagen1=admRecursos.regionesYamiC;
                Enemigo1.radioImagen=Enemigo1.radioImagenC;


            }
            if (contador==2&&randomCreepy<=6){
                EnemigoImagen2=admRecursos.regionesHamster;
                Enemigo2.radioImagen=Enemigo2.radioImagenN;

            }
            if (contador==2&&randomCreepy>=7){
                EnemigoImagen2=admRecursos.regionesHamsterC;
                Enemigo2.radioImagen=Enemigo2.radioImagenC;

            }
            if (contador==3&&randomCreepy<=6){
                EnemigoImagen3=admRecursos.regionesHamster;
                Enemigo3.radioImagen=Enemigo3.radioImagenN;

            }
            if (contador==3&&randomCreepy>=7){
                EnemigoImagen3=admRecursos.regionesHamsterC;
                Enemigo3.radioImagen=Enemigo3.radioImagenC;

            }
            if (contador==4&&randomCreepy<=8){
                EnemigoImagen4=admRecursos.regionesYami;
                Enemigo4.radioImagen=Enemigo4.radioImagenN;

            }
            if (contador==4&&randomCreepy>=9){
                EnemigoImagen4=admRecursos.regionesYamiC;
                Enemigo4.radioImagen=Enemigo4.radioImagenC;

            }
            if (contador==5&&randomCreepy<=5){
                EnemigoImagen5=admRecursos.regionesGuamomi;
                Enemigo5.radioImagen=Enemigo5.radioImagenN;

            }
            if (contador==5&&randomCreepy>=6){
                EnemigoImagen5=admRecursos.regionesGuamomiC;
                Enemigo5.radioImagen=Enemigo5.radioImagenC;

            }
            if (contador==6&&randomCreepy<=5){
                EnemigoImagen6=admRecursos.regionesGuamomi;
                Enemigo6.radioImagen=Enemigo6.radioImagenN;

            }
            if (contador==6&&randomCreepy>=6){
                EnemigoImagen6=admRecursos.regionesGuamomiC;
                Enemigo6.radioImagen=Enemigo6.radioImagenC;

            }
            contador++;

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

        //Creamos boton de ataque
        btnAtacar = new ButtonSprite(1100, 150, admRecursos.regionBtnAtacar, admRecursos.vbom) {
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


        //Creamos el nivel aleatorio y los enemigos
        tipoNivel = 1; //(int)((Math.random() * 4) + 1);
        generadorDenivel();

        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
                if (juegoEnPausa){
                    setChildScene(escenaPausa,false,true,true);
                    return;
                }

                movimientoEnemigos();

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
                comprobarColission();
                comprobarColissionLagrimas();
                comprobarFase2();
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
                if (!Enemigo5Vivo) {
                    detachChild(lagrima1);
                    detachChild(lagrima2);
                    detachChild(lagrima3);
                    detachChild(lagrima4);
                }

                if (!Enemigo6Vivo) {
                    detachChild(lagrima5);
                    detachChild(lagrima6);
                    detachChild(lagrima7);
                    detachChild(lagrima8);
                }


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
        return TipoEscena.ESCENA_JUEGO3;
    }

    @Override
    public void liberarEscena() {


        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }

    public void comprobarColission(){
        if (tipoNivel==1) {
            if (ataque) {
                if (!faseDos) {
                    float ex1 = Enemigo1.getEnemigo().getX();
                    float ex2 = Enemigo2.getEnemigo().getX();
                    float ex3 = Enemigo3.getEnemigo().getX();
                    float ey1 = Enemigo1.getEnemigo().getY();
                    float ey2 = Enemigo2.getEnemigo().getY();
                    float ey3 = Enemigo3.getEnemigo().getY();
                    float px = personaje.getPersonaje().getX();
                    float py = personaje.getPersonaje().getY();

                    if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                            < (Enemigo1.radioImagen + personaje.radioImagenAtacando) * (Enemigo1.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo1Vivo) {
                        if (ataque) {
                            Enemigo1.vida = Enemigo1.vida - personaje.fuerza;
                            if (Enemigo1.vida <= 0) {
                                Enemigo1.getEnemigo().detachSelf();
                                Enemigo1Vivo = false;
                                enemigosVivos = enemigosVivos - 1;


                            }
                        }
                    }
                    if (((ex2 - px) * (ex2 - px)) + ((ey2 - py) * (ey2 - py))
                            < (Enemigo2.radioImagen + personaje.radioImagenAtacando) * (Enemigo2.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo2Vivo) {
                        if (ataque) {
                            Enemigo2.vida = Enemigo2.vida - personaje.fuerza;
                            if (Enemigo2.vida <= 0) {
                                Enemigo2.getEnemigo().detachSelf();
                                Enemigo2Vivo = false;
                                enemigosVivos = enemigosVivos - 1;
                            }

                        }
                    }
                    if (((ex3 - px) * (ex3 - px)) + ((ey3 - py) * (ey3 - py))
                            < (Enemigo3.radioImagen + personaje.radioImagenAtacando) * (Enemigo3.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo3Vivo) {
                        if (ataque) {
                            Enemigo3.vida = Enemigo3.vida - personaje.fuerza;
                            if (Enemigo3.vida <= 0) {
                                Enemigo3.getEnemigo().detachSelf();
                                Enemigo3Vivo = false;
                                enemigosVivos = enemigosVivos - 1;
                            }
                        }
                    }




                }
                if (faseDos) {
                    float ex4 = Enemigo4.getEnemigo().getX();
                    float ex5 = Enemigo5.getEnemigo().getX();
                    float ex6 = Enemigo6.getEnemigo().getX();
                    float ey4 = Enemigo4.getEnemigo().getY();
                    float ey5 = Enemigo5.getEnemigo().getY();
                    float ey6 = Enemigo6.getEnemigo().getY();
                    float px = personaje.getPersonaje().getX();
                    float py = personaje.getPersonaje().getY();


                    if (((ex4 - px) * (ex4 - px)) + ((ey4 - py) * (ey4 - py))
                            < (Enemigo4.radioImagen + personaje.radioImagenAtacando) * (Enemigo4.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo4Vivo) {
                        if (ataque) {
                            Enemigo4.vida = Enemigo4.vida - personaje.fuerza;
                            if (Enemigo4.vida <= 0) {
                                Enemigo4.getEnemigo().detachSelf();
                                Enemigo4Vivo = false;
                                enemigosVivos = enemigosVivos - 1;
                            }
                        }
                    }
                    if (((ex5 - px) * (ex5 - px)) + ((ey5 - py) * (ey5 - py))
                            < (Enemigo5.radioImagen + personaje.radioImagenAtacando) * (Enemigo5.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo5Vivo) {
                        if (ataque) {
                            Enemigo5.vida = Enemigo5.vida - personaje.fuerza;
                            if (Enemigo5.vida <= 0) {
                                Enemigo5.getEnemigo().detachSelf();
                                Enemigo5Vivo = false;
                                enemigosVivos = enemigosVivos - 1;
                            }
                        }
                    }
                    if (((ex6 - px) * (ex6 - px)) + ((ey6 - py) * (ey6 - py))
                            < (Enemigo6.radioImagen + personaje.radioImagenAtacando) * (Enemigo6.radioImagen +
                            personaje.radioImagenAtacando) && Enemigo6Vivo) {
                        if (ataque) {
                            Enemigo6.vida = Enemigo6.vida - personaje.fuerza;
                            if (Enemigo6.vida <= 0) {
                                Enemigo6.getEnemigo().detachSelf();
                                Enemigo6Vivo = false;
                                enemigosVivos = enemigosVivos - 1;
                            }
                        }
                    }
                }
            }
            else{
                if (!faseDos) {
                    float ex1 = Enemigo1.getEnemigo().getX();
                    float ex2 = Enemigo2.getEnemigo().getX();
                    float ex3 = Enemigo3.getEnemigo().getX();
                    float ey1 = Enemigo1.getEnemigo().getY();
                    float ey2 = Enemigo2.getEnemigo().getY();
                    float ey3 = Enemigo3.getEnemigo().getY();
                    float px = personaje.getPersonaje().getX();
                    float py = personaje.getPersonaje().getY();

                    if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                            < (Enemigo1.radioImagen + personaje.radioImagen) * (Enemigo1.radioImagen +
                            personaje.radioImagen) && Enemigo1Vivo) {
                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }
                    }
                    if (((ex2 - px) * (ex2 - px)) + ((ey2 - py) * (ey2 - py))
                            < (Enemigo2.radioImagen + personaje.radioImagen) * (Enemigo2.radioImagen +
                            personaje.radioImagen) && Enemigo2Vivo) {

                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }
                    }
                    if (((ex3 - px) * (ex3 - px)) + ((ey3 - py) * (ey3 - py))
                            < (Enemigo3.radioImagen + personaje.radioImagen) * (Enemigo3.radioImagen +
                            personaje.radioImagen) && Enemigo3Vivo) {

                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }


                    }

                }
                if (faseDos){
                    float ex4 = Enemigo4.getEnemigo().getX();
                    float ex5 = Enemigo5.getEnemigo().getX();
                    float ex6 = Enemigo6.getEnemigo().getX();
                    float ey4 = Enemigo4.getEnemigo().getY();
                    float ey5 = Enemigo5.getEnemigo().getY();
                    float ey6 = Enemigo6.getEnemigo().getY();
                    float px = personaje.getPersonaje().getX();
                    float py = personaje.getPersonaje().getY();



                    if (((ex4 - px) * (ex4 - px)) + ((ey4 - py) * (ey4 - py))
                            < (Enemigo4.radioImagen + personaje.radioImagen) * (Enemigo4.radioImagen +
                            personaje.radioImagen) && Enemigo4Vivo) {

                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }


                    }
                    if (((ex5 - px) * (ex5 - px)) + ((ey5 - py) * (ey5 - py))
                            < (Enemigo5.radioImagen + personaje.radioImagen) * (Enemigo5.radioImagen +
                            personaje.radioImagen) && Enemigo5Vivo) {

                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }


                    }
                    if (((ex6 - px) * (ex6 - px)) + ((ey6 - py) * (ey6 - py))
                            < (Enemigo6.radioImagen + personaje.radioImagen) * (Enemigo6.radioImagen +
                            personaje.radioImagen) && Enemigo6Vivo) {

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

    public void comprobarColissionLagrimas() {
        if (faseDos) {

            float px = personaje.getPersonaje().getX();
            float py = personaje.getPersonaje().getY();
            float pr1x = lagrima1.getX();
            float pr1y = lagrima1.getY();
            float pr2x = lagrima2.getX();
            float pr2y = lagrima2.getY();
            float pr3x = lagrima3.getX();
            float pr3y = lagrima3.getY();
            float pr4x = lagrima4.getX();
            float pr4y = lagrima4.getY();

            if (((pr1x - px) * (pr1x - px)) + ((pr1y - py) * (pr1y - py))
                    < (Enemigo5.radioImagenProyectil + personaje.radioImagen) * (Enemigo5.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo5Vivo && lagrima1viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr2x - px) * (pr2x - px)) + ((pr2y - py) * (pr2y - py))
                    < (Enemigo5.radioImagenProyectil + personaje.radioImagen) * (Enemigo5.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo5Vivo && lagrima2viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr3x - px) * (pr3x - px)) + ((pr3y - py) * (pr3y - py))
                    < (Enemigo5.radioImagenProyectil + personaje.radioImagen) * (Enemigo5.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo5Vivo && lagrima3viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr4x - px) * (pr4x - px)) + ((pr4y - py) * (pr4y - py))
                    < (Enemigo5.radioImagenProyectil + personaje.radioImagen) * (Enemigo5.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo5Vivo && lagrima4viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            float pr5x = lagrima5.getX();
            float pr5y = lagrima5.getY();
            float pr6x = lagrima6.getX();
            float pr6y = lagrima6.getY();
            float pr7x = lagrima7.getX();
            float pr7y = lagrima7.getY();
            float pr8x = lagrima8.getX();
            float pr8y = lagrima8.getY();

            if (((pr5x - px) * (pr5x - px)) + ((pr5y - py) * (pr5y - py))
                    < (Enemigo6.radioImagenProyectil + personaje.radioImagen) * (Enemigo6.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo6Vivo && lagrima5viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr6x - px) * (pr6x - px)) + ((pr6y - py) * (pr6y - py))
                    < (Enemigo6.radioImagenProyectil + personaje.radioImagen) * (Enemigo6.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo6Vivo && lagrima6viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr7x - px) * (pr7x - px)) + ((pr7y - py) * (pr7y - py))
                    < (Enemigo6.radioImagenProyectil + personaje.radioImagen) * (Enemigo6.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo6Vivo && lagrima7viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }
            if (((pr8x - px) * (pr8x - px)) + ((pr8y - py) * (pr8y - py))
                    < (Enemigo6.radioImagenProyectil + personaje.radioImagen) * (Enemigo6.radioImagenProyectil +
                    personaje.radioImagen) && Enemigo6Vivo && lagrima8viva) {
                if (!dañado) {
                    personaje.setPersonaje(4);
                    attachChild(personaje.getPersonaje());
                    dañado = true;


                }
            }


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
            admEscenas.liberarEscenaJuego3();
            admRecursos.actividadJuego.musicaJuego.pause();
        }
        if (enemigosVivos == 0) {
            if (tipoNivel == 1) {
                experienciaGanada = 90;
                SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences(
                        "personaje", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putInt("ExperienciaGanada", experienciaGanada);
                editor.commit();
            }
            admEscenas.crearEscenaNiveles();
            admEscenas.setEscena(TipoEscena.ESCENA_NIVELES);
            admEscenas.liberarEscenaJuego1();
            admRecursos.actividadJuego.musicaJuego.pause();
        }
    }

    public void generadorDenivel() {
        if (tipoNivel == 1) {


            Enemigo1.crearEnemigo(0, 0, EnemigoImagen1, admRecursos.vbom);
            Enemigo1.dibujarEnemigo();
            attachChild(Enemigo1.getEnemigo());



            Enemigo2.crearEnemigo(0, 0, EnemigoImagen2, admRecursos.vbom);

            Enemigo3.crearEnemigo(0, 0, EnemigoImagen3, admRecursos.vbom);


            Enemigo2.dibujarEnemigo();
            Enemigo3.dibujarEnemigo();


            attachChild(Enemigo2.getEnemigo());
            attachChild(Enemigo3.getEnemigo());
            enemigosVivos = 6;

        }

    }

    public void movimientoEnemigos() {
        if (tipoNivel == 1) {
            Enemigo1.movimientoEnemigo();
            if (Enemigo1.dibujar && Enemigo1Vivo) {
                attachChild(Enemigo1.getEnemigo());
                Enemigo1.dibujar = false;
            }
            Enemigo2.movimientoEnemigo();
            if (Enemigo2.dibujar && Enemigo2Vivo) {
                attachChild(Enemigo2.getEnemigo());
                Enemigo2.dibujar = false;
            }
            Enemigo3.movimientoEnemigo();
            if (Enemigo3.dibujar && Enemigo3Vivo) {
                attachChild(Enemigo3.getEnemigo());
                Enemigo3.dibujar = false;
            }

            if (faseDos) {
                Enemigo4.movimientoEnemigo();
                if (Enemigo4.dibujar && Enemigo4Vivo) {
                    attachChild(Enemigo4.getEnemigo());
                    Enemigo4.dibujar = false;
                }
                Enemigo5.movimientoEnemigo();
                if (Enemigo5.dibujar && Enemigo5Vivo) {
                    attachChild(Enemigo5.getEnemigo());
                    Enemigo5.dibujar = false;
                }
                Enemigo6.movimientoEnemigo();
                if (Enemigo6.dibujar && Enemigo6Vivo) {
                    attachChild(Enemigo6.getEnemigo());
                    Enemigo6.dibujar = false;
                }
            }

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

    public void comprobarFase2() {
        if (tipoNivel == 1) {
            if (!faseDos) {
                if (enemigosVivos == 3) {

                    Enemigo4.crearEnemigo(0, 0, EnemigoImagen4, admRecursos.vbom);
                    lagrima1 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima2 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima3 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima4 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima5 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima6 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima7 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };
                    lagrima8 = new Sprite(0, 0, admRecursos.regionLagrimas, admRecursos.vbom) {
                        @Override
                        protected void preDraw(GLState pGLState, Camera pCamera) {
                            super.preDraw(pGLState, pCamera);
                            pGLState.enableDither();
                        }
                    };

                    Enemigo5.crearEnemigo(0, 0, EnemigoImagen5, admRecursos.vbom);

                    Enemigo6.crearEnemigo(0, 0, EnemigoImagen6, admRecursos.vbom);
                    Enemigo4.dibujarEnemigo();
                    Enemigo5.dibujarEnemigo();
                    Enemigo6.dibujarEnemigo();
                    attachChild(Enemigo4.getEnemigo());
                    attachChild(Enemigo5.getEnemigo());
                    attachChild(Enemigo6.getEnemigo());
                    faseDos = true;
                    tiempoAtaqueyami=0;
                    yamiOculta=false;
                }
            }
        }

    }

    public void ataqueEnemigos() {
        if (faseDos) {
            ataqueGuamomi();
        }
        ataqueYami();
    }

    public void ataqueGuamomi() {
        if (Enemigo5Vivo) {
            if (tiempoAtaquelagrima1 == 60) {
                float x = Enemigo5.getEnemigo().getX();
                float y = Enemigo5.getEnemigo().getY();
                lagrima1.setX(x);
                lagrima1.setY(y);
                lagrima1.setScale(.5f);
                attachChild(lagrima1);
                lagrima1.setZIndex(-1);
                lagrima1viva = true;

            }
            if (tiempoAtaquelagrima1 == 100) {
                detachChild(lagrima1);
                lagrima1.detachSelf();
                lagrima1viva = false;
                tiempoAtaquelagrima1 = 0;
            }
            if (tiempoAtaquelagrima2 == 80) {
                float x = Enemigo5.getEnemigo().getX();
                float y = Enemigo5.getEnemigo().getY();
                lagrima2.setX(x);
                lagrima2.setY(y);
                lagrima2.setScale(.5f);
                attachChild(lagrima2);
                lagrima2.setZIndex(-1);
                lagrima2viva = true;

            }
            if (tiempoAtaquelagrima2 == 140) {
                detachChild(lagrima2);
                lagrima2.detachSelf();
                lagrima2viva = false;
                tiempoAtaquelagrima2 = 0;
            }
            if (tiempoAtaquelagrima3 == 100) {
                float x = Enemigo5.getEnemigo().getX();
                float y = Enemigo5.getEnemigo().getY();
                lagrima3.setX(x);
                lagrima3.setY(y);
                lagrima3.setScale(.5f);
                attachChild(lagrima3);
                lagrima3.setZIndex(-1);
                lagrima3viva = true;

            }
            if (tiempoAtaquelagrima3 == 180) {
                detachChild(lagrima3);
                lagrima3.detachSelf();
                lagrima3viva = false;
                tiempoAtaquelagrima3 = 0;
            }
            if (tiempoAtaquelagrima4 == 120) {
                float x = Enemigo5.getEnemigo().getX();
                float y = Enemigo5.getEnemigo().getY();
                lagrima4.setX(x);
                lagrima4.setY(y);
                lagrima4.setScale(.5f);
                attachChild(lagrima4);
                lagrima4.setZIndex(-1);
                lagrima4viva = true;

            }
            if (tiempoAtaquelagrima4 == 220) {
                detachChild(lagrima4);
                lagrima4.detachSelf();
                lagrima4viva = false;
                tiempoAtaquelagrima4 = 0;
            }

            tiempoAtaquelagrima1++;
            tiempoAtaquelagrima2++;
            tiempoAtaquelagrima3++;
            tiempoAtaquelagrima4++;
            sortChildren();
        }

        if (Enemigo6Vivo) {
            if (tiempoAtaquelagrima5 == 60) {
                float x = Enemigo6.getEnemigo().getX();
                float y = Enemigo6.getEnemigo().getY();
                lagrima5.setX(x);
                lagrima5.setY(y);
                lagrima5.setScale(.5f);
                attachChild(lagrima5);
                lagrima5.setZIndex(-1);
                lagrima5viva = true;

            }
            if (tiempoAtaquelagrima5 == 100) {
                detachChild(lagrima5);
                lagrima5.detachSelf();
                lagrima5viva = false;
                tiempoAtaquelagrima5 = 0;
            }
            if (tiempoAtaquelagrima6 == 80) {
                float x = Enemigo6.getEnemigo().getX();
                float y = Enemigo6.getEnemigo().getY();
                lagrima6.setX(x);
                lagrima6.setY(y);
                lagrima6.setScale(.5f);
                attachChild(lagrima6);
                lagrima6.setZIndex(-1);
                lagrima6viva = true;

            }
            if (tiempoAtaquelagrima6 == 140) {
                detachChild(lagrima6);
                lagrima6.detachSelf();
                lagrima6viva = false;
                tiempoAtaquelagrima6 = 0;
            }
            if (tiempoAtaquelagrima7 == 100) {
                float x = Enemigo6.getEnemigo().getX();
                float y = Enemigo6.getEnemigo().getY();
                lagrima7.setX(x);
                lagrima7.setY(y);
                lagrima7.setScale(.5f);
                attachChild(lagrima7);
                lagrima7.setZIndex(-1);
                lagrima7viva = true;

            }
            if (tiempoAtaquelagrima7 == 180) {
                detachChild(lagrima7);
                lagrima7.detachSelf();
                lagrima7viva = false;
                tiempoAtaquelagrima7 = 0;
            }
            if (tiempoAtaquelagrima8 == 120) {
                float x = Enemigo6.getEnemigo().getX();
                float y = Enemigo6.getEnemigo().getY();
                lagrima8.setX(x);
                lagrima8.setY(y);
                lagrima8.setScale(.5f);
                attachChild(lagrima8);
                lagrima8.setZIndex(-1);
                lagrima8viva = true;

            }
            if (tiempoAtaquelagrima8 == 220) {
                detachChild(lagrima8);
                lagrima8.detachSelf();
                lagrima8viva = false;
                tiempoAtaquelagrima8 = 0;
            }
            tiempoAtaquelagrima5++;
            tiempoAtaquelagrima6++;
            tiempoAtaquelagrima7++;
            tiempoAtaquelagrima8++;
            sortChildren();

        }


    }

    public void ataqueYami(){
        if (Enemigo1Vivo) {
            if (tiempoAtaqueyami == 70) {
                detachChild(Enemigo1.getEnemigo());
                yamiOculta = true;

            }
            if (tiempoAtaqueyami==200){
                    float x = personaje.getPersonaje().getX();
                    float y = personaje.getPersonaje().getY();
                    if (personaje.direccion == 0) {
                        y = y + Enemigo1.radioImagen - 10;
                    }
                    if (personaje.direccion == 1) {
                        y = y - Enemigo1.radioImagen + 10;
                    }
                    if (personaje.direccion == 2) {
                        x = x - Enemigo1.radioImagen + 10;
                        Enemigo1.direccion=1;
                    }
                    if (personaje.direccion == 3) {
                        x = x + Enemigo1.radioImagen - 10;
                        Enemigo1.direccion=2;
                    }
                    Enemigo1.getEnemigo().setX(x);
                    Enemigo1.getEnemigo().setY(y);

            }
            if (tiempoAtaqueyami==220){
                if (personaje.direccion==2||personaje.direccion==3) {
                    attachChild(Enemigo1.getEnemigo());
                    Enemigo1.animarYami();
                    yamiOculta = false;
                    tiempoAtaqueyami = 0;
                }
                else{
                    tiempoAtaqueyami=199;
                }
            }
            tiempoAtaqueyami++;
        }

        if (faseDos){
            if (Enemigo4Vivo) {
                if (tiempoAtaqueyami == 70) {
                    detachChild(Enemigo4.getEnemigo());
                    yamiOculta = true;

                }
                if (tiempoAtaqueyami==200){
                    float x = personaje.getPersonaje().getX();
                    float y = personaje.getPersonaje().getY();
                    if (personaje.direccion == 0) {
                        y = y + Enemigo4.radioImagen - 10;
                    }
                    if (personaje.direccion == 1) {
                        y = y - Enemigo4.radioImagen + 10;
                    }
                    if (personaje.direccion == 2) {
                        x = x - Enemigo4.radioImagen + 10;
                        Enemigo4.direccion=1;
                    }
                    if (personaje.direccion == 3) {
                        x = x + Enemigo4.radioImagen - 10;
                        Enemigo4.direccion=2;
                    }
                    Enemigo4.getEnemigo().setX(x);
                    Enemigo4.getEnemigo().setY(y);

                }
                if (tiempoAtaqueyami==220){
                    if (personaje.direccion==2||personaje.direccion==3) {
                        attachChild(Enemigo4.getEnemigo());
                        Enemigo4.animarYami();
                        yamiOculta = false;
                        tiempoAtaqueyami = 0;
                    }
                    else{
                        tiempoAtaqueyami=199;
                    }
                }
                tiempoAtaqueyami++;
            }
        }
    }
}
