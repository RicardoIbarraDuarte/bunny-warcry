/*package com.example.stryker.bunny_warcray;

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
    private ITextureRegion[] regionesPersonaje;
    private TiledTextureRegion[] regionesPersonajeAtacando;
    private ButtonSprite btnAtacar;
    private boolean ataque =false;
    private boolean ataqueA=false;
    private float tiempoAtaque=0;
    private float tiempoDaño=0;
    private boolean dañado=false;
    private Rectangle barraVida;
    private Sprite Fondo;
    private float anchoVida;
    private float enemigosVivos;
    private int tipoNivel;
    private boolean faseDos =false;
    public Sprite lagrima1;
    public Sprite lagrima2;
    public Sprite lagrima3;
    public Sprite lagrima4;
    private boolean ataqueInicio=true;
    private float xinicial;
    private float yinicial;
    private int tiempoAtaqueEspera=100;
    private int tiempoAtaquelagrima1=0;
    private int tiempoAtaquelagrima2=0;
    private int tiempoAtaquelagrima3=0;
    private int tiempoAtaquelagrima4=0;
    private boolean lagrima1viva=false;
    private boolean lagrima2viva=false;
    private boolean lagrima3viva=false;
    private boolean lagrima4viva=false;

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

        // Creamos personaje
        regionesPersonaje = new ITextureRegion[]{admRecursos.regionPersonajeFrente,
                admRecursos.regionPersonajeAtras,admRecursos.regionPersonajeDerecha,
                admRecursos.regionPersonajeIzquierda,admRecursos.regionPersonajeGolpeado};
        personaje = new Personaje();
        personaje.crearPersonaje(0,0,regionesPersonaje,admRecursos.vbom);
        regionesPersonajeAtacando= new TiledTextureRegion[]{admRecursos.regionPataqueFrente,
                admRecursos.regionPataqueAtras,admRecursos.regionPataqueDerecha,
                admRecursos.regionPataqueIzquierda};
        personaje.crearPersonajeAtacando(0,0,regionesPersonajeAtacando,admRecursos.vbom);
        personaje.dibujarPersonaje();
        attachChild(personaje.getPersonaje());

        //Creamos joystick
        agregarJoystick();

        //Creamos barra de vida
        anchoVida=300;
        barraVida = new Rectangle(1100,520,anchoVida,55,admRecursos.vbom);
        barraVida.setColor(1,0,0);  // RGB [0,1]
        barraVida.setAnchorCenterX(0);
        attachChild(barraVida);

        //Creamos boton de ataque
        btnAtacar = new ButtonSprite(1100,150,admRecursos.regionBtnAtacar,admRecursos.vbom) {
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

        //Creamos el nivel aleatorio y los enemigos
        tipoNivel = 1; //(int)((Math.random() * 4) + 1);
        generadorDenivel();


        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
                movimientoEnemigos();
                comprobarDireccionPersonaje();
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
                ataqueEnemigos();
                comprobarFase2();
                if (dañado){
                    tiempoDaño=pSecondsElapsed+tiempoDaño;
                }
                if (tiempoDaño>.8){
                    dañado=false;
                    personaje.setPersonaje(0);
                    attachChild(personaje.getPersonaje());
                    personaje.vida=personaje.vida-1;
                    tiempoDaño=0;
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
        if (tipoNivel==1) {
            if (!faseDos) {
                float ex1 = Enemigo1.getEnemigo().getX();
                float ey1 = Enemigo1.getEnemigo().getY();
                float px = personaje.getPersonaje().getX();
                float py = personaje.getPersonaje().getY();
                float pr1x=  lagrima1.getX();
                float pr1y=  lagrima1.getY();
                float pr2x=  lagrima2.getX();
                float pr2y=  lagrima2.getY();
                float pr3x=  lagrima3.getX();
                float pr3y=  lagrima3.getY();
                float pr4x=  lagrima4.getX();
                float pr4y=  lagrima4.getY();

                if (((ex1 - px) * (ex1 - px)) + ((ey1 - py) * (ey1 - py))
                        < (Enemigo1.radioImagen + personaje.radioImagen) * (Enemigo1.radioImagen +
                        personaje.radioImagen) && Enemigo1Vivo) {
                    if (ataque) {
                        Enemigo1.vida = Enemigo1.vida - personaje.fuerza;
                        if (Enemigo1.vida <= 0) {
                            Enemigo1.getEnemigo().detachSelf();
                            Enemigo1Vivo = false;
                            enemigosVivos = enemigosVivos - 1;
                        }
                    } else {
                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }

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
                    if (ataque) {
                        Enemigo4.vida=Enemigo4.vida-personaje.fuerza;
                        if (Enemigo4.vida<=0) {
                            Enemigo4.getEnemigo().detachSelf();
                            Enemigo4Vivo = false;
                            enemigosVivos = enemigosVivos - 1;
                        }
                    } else {
                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }

                    }
                }
                if (((ex5 - px) * (ex5 - px)) + ((ey5 - py) * (ey5 - py))
                        < (Enemigo5.radioImagen + personaje.radioImagen) * (Enemigo5.radioImagen +
                        personaje.radioImagen) && Enemigo5Vivo) {
                    if (ataque) {
                        Enemigo5.vida=Enemigo5.vida-personaje.fuerza;
                        if (Enemigo5.vida<=0) {
                            Enemigo5.getEnemigo().detachSelf();
                            Enemigo5Vivo = false;
                            enemigosVivos = enemigosVivos - 1;
                        }
                    } else {
                        if (!dañado) {
                            personaje.setPersonaje(4);
                            attachChild(personaje.getPersonaje());
                            dañado = true;
                        }

                    }
                }
                if (((ex6 - px) * (ex6 - px)) + ((ey6 - py) * (ey6 - py))
                        < (Enemigo6.radioImagen + personaje.radioImagen) * (Enemigo6.radioImagen +
                        personaje.radioImagen) && Enemigo6Vivo) {
                    if (ataque) {
                        Enemigo6.vida=Enemigo6.vida-personaje.fuerza;
                        if (Enemigo6.vida<=0) {
                            Enemigo6.getEnemigo().detachSelf();
                            Enemigo6Vivo = false;
                            enemigosVivos = enemigosVivos - 1;
                        }
                    } else {
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
    public void atacarPersonaje() {
        if (!ataqueA) {
            personaje.atacarPersonaje();
            attachChild(personaje.getPersonajeAtacando());
            ataqueA=true;
        }
    }
    public void terminarNivel(){
        if (personaje.vida<=0){
            admEscenas.crearEscenaGameover();
            admEscenas.setEscena(TipoEscena.ESCENA_GAMEOVER);
            admEscenas.liberarEscenaJuego();
        }
        if (enemigosVivos==0){
            admEscenas.crearEscenaExperiencia();
            admEscenas.setEscena(TipoEscena.ESCENA_EXPERIENCIA);
            admEscenas.liberarEscenaJuego();
        }
    }
    public void generadorDenivel(){
        if (tipoNivel==1) {


            enemigosVivos=4;


        }
        if (tipoNivel==2){

        }
    }
    public void movimientoEnemigos(){
        if (tipoNivel==1) {
            Enemigo1.movimientoEnemigo();
            if (faseDos) {
                Enemigo4.movimientoEnemigo();
                Enemigo5.movimientoEnemigo();
                Enemigo6.movimientoEnemigo();
            }
        }
        if (tipoNivel==2){
            Enemigo1.movimientoEnemigo();
            Enemigo2.movimientoEnemigo();
        }
    }
    public void comprobarDireccionPersonaje(){
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
    }
    public void comprobarVida(){
        if (personaje.vidaA!=personaje.vida) {
            detachChild(barraVida);
            anchoVida = personaje.vida * 300 / personaje.vidaTotal;
            barraVida = new Rectangle(1100, 520, anchoVida, 55, admRecursos.vbom);
            barraVida.setColor(1, 0, 0);  // RGB [0,1]
            barraVida.setAnchorCenterX(0);
            attachChild(barraVida);
            personaje.vidaA=personaje.vida;
        }
    }
    public void comprobarFase2(){
        if (tipoNivel==1) {
            if (!faseDos) {
                if (enemigosVivos == 3) {
                    Enemigo4 = new EnemigoHamster();
                    //      Enemigo4.crearEnemigo(0, 0, admRecursos.regionHamster, admRecursos.vbom);
                    Enemigo5 = new EnemigoHamster();
                    //      Enemigo5.crearEnemigo(0, 0, admRecursos.regionHamster, admRecursos.vbom);
                    Enemigo6 = new EnemigoHamster();
                    //     Enemigo6.crearEnemigo(0, 0, admRecursos.regionHamster, admRecursos.vbom);
                    Enemigo4.dibujarEnemigo();
                    Enemigo5.dibujarEnemigo();
                    Enemigo6.dibujarEnemigo();
                    attachChild(Enemigo4.getEnemigo());
                    attachChild(Enemigo5.getEnemigo());
                    attachChild(Enemigo6.getEnemigo());
                    faseDos=true;
                }
            }
        }
    }
    public void ataqueEnemigos(){
        if (tipoNivel==1){
            ataqueGuamomi();
        }

    }
    public void ataqueGuamomi(){
        if (tiempoAtaquelagrima1==60){
            float x = Enemigo1.getEnemigo().getX();
            float y = Enemigo1.getEnemigo().getY();
            lagrima1.setX(x);
            lagrima1.setY(y);
            attachChild(lagrima1);
            lagrima1viva=true;

        }
        if (tiempoAtaquelagrima1==100){
            detachChild(lagrima1);
            lagrima1.detachSelf();
            lagrima1viva=false;
            tiempoAtaquelagrima1=0;
        }
        if (tiempoAtaquelagrima2==80){
            float x = Enemigo1.getEnemigo().getX();
            float y = Enemigo1.getEnemigo().getY();
            lagrima2.setX(x);
            lagrima2.setY(y);
            attachChild(lagrima2);
            lagrima2viva=true;

        }
        if (tiempoAtaquelagrima2==140){
            detachChild(lagrima2);
            lagrima2.detachSelf();
            lagrima2viva=false;
            tiempoAtaquelagrima2=0;
        }
        if (tiempoAtaquelagrima3==100){
            float x = Enemigo1.getEnemigo().getX();
            float y = Enemigo1.getEnemigo().getY();
            lagrima3.setX(x);
            lagrima3.setY(y);
            attachChild(lagrima3);
            lagrima3viva=true;

        }
        if (tiempoAtaquelagrima3==180){
            detachChild(lagrima3);
            lagrima3.detachSelf();
            lagrima3viva=false;
            tiempoAtaquelagrima3=0;
        }
        if (tiempoAtaquelagrima4==120){
            float x = Enemigo1.getEnemigo().getX();
            float y = Enemigo1.getEnemigo().getY();
            lagrima4.setX(x);
            lagrima4.setY(y);
            attachChild(lagrima4);
            lagrima4viva=true;

        }
        if (tiempoAtaquelagrima4==220){
            detachChild(lagrima4);
            lagrima4.detachSelf();
            lagrima4viva=false;
            tiempoAtaquelagrima4=0;
        }

        tiempoAtaquelagrima1++;
        tiempoAtaquelagrima2++;
        tiempoAtaquelagrima3++;
        tiempoAtaquelagrima4++;






    }
}

*/