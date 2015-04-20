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
public class EscenaExperiencia extends EscenaBase{
    // *** Fondo
    private Sprite spriteFondo; //(el fondo de la escena, estático)
    private int experienciaTotal;
    private int experienciaGanada;
    private int puntosUsados;
    private int puntosDisponibles;
    private int puntosTotales;
    private int fuerza;
    private int vida;
    private int velocidad;
    private int laser;
    private Sprite barraF;
    private Sprite barraV;
    private Sprite barraVi;
    private Sprite barraL;




    @Override
    public void crearEscena() {
        // Creamos el sprite de manera óptima
        spriteFondo = new Sprite(0,0, admRecursos.regionFondoExperiencia,admRecursos.vbom) {
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

        SharedPreferences preferencias = admRecursos.actividadJuego.getSharedPreferences(
                "personaje", Context.MODE_PRIVATE);
        experienciaGanada = preferencias.getInt("ExperienciaGanada",0);
        experienciaTotal = preferencias.getInt("ExperienciaTotal",0);
        experienciaTotal=experienciaTotal+experienciaGanada;
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt("ExperienciaTotal", experienciaTotal);
        editor.commit();
        puntosUsados = preferencias.getInt("PuntosUsados",0);
        calcularpuntos();
        fuerza = preferencias.getInt("Fuerza",0);
        velocidad = preferencias.getInt("Velocidad",0);
        vida = preferencias.getInt("Vida",0);
        laser = preferencias.getInt("Laser",0);

        crearBarrasF();
        crearBarrasV();
        crearBarrasVi();
        crearBarrasL();

        dibujarBarras();





    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaExperiencia();

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_EXPERIENCIA;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
    }
    public void calcularpuntos(){
        if (experienciaTotal>=0){
            puntosTotales=0;
        }
        if (experienciaTotal>=60){
            puntosTotales=1;
        }
        if (experienciaTotal>=150){
            puntosTotales=2;
        }
        if (experienciaTotal>=240){
            puntosTotales=3;
        }
        if (experienciaTotal>=330){
            puntosTotales=4;
        }
        if (experienciaTotal>=420){
            puntosTotales=5;
        }
        if (experienciaTotal>=510){
            puntosTotales=6;
        }
        if (experienciaTotal>=600){
            puntosTotales=7;
        }
        if (experienciaTotal>=690){
            puntosTotales=8;
        }
        if (experienciaTotal>=780){
            puntosTotales=9;
        }
        if (experienciaTotal>=870){
            puntosTotales=10;
        }
        if (experienciaTotal>=960){
            puntosTotales=11;
        }
        if (experienciaTotal>=1050){
            puntosTotales=12;
        }
        if (experienciaTotal>=1140){
            puntosTotales=13;
        }
        if (experienciaTotal>=1230){
            puntosTotales=14;
        }
        if (experienciaTotal>=1320){
            puntosTotales=15;
        }
        if (experienciaTotal>=1410){
            puntosTotales=16;
        }
        if (experienciaTotal>=1500){
            puntosTotales=17;
        }
        if (experienciaTotal>=1590){
            puntosTotales=18;
        }
        if (experienciaTotal>=1680){
            puntosTotales=19;
        }
        if (experienciaTotal>=1770){
            puntosTotales=20;
        }

        puntosDisponibles=puntosTotales-puntosUsados;

    }
    public void crearBarrasF(){
        if (fuerza==0){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel0,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (fuerza==1){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel1,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (fuerza==2){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel2,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (fuerza==3){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel3,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (fuerza==4){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel4,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (fuerza==5){
            barraF = new Sprite(826,374, admRecursos.regionBarranivel5,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }



    }
    public void crearBarrasV(){
        if (velocidad==0){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel0,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (velocidad==1){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel1,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (velocidad==2){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel2,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (velocidad==3){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel3,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (velocidad==4){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel4,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (velocidad==5){
            barraV = new Sprite(826,462, admRecursos.regionBarranivel5,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }



    }
    public void crearBarrasVi(){
        if (vida==0){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel0,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (vida==1){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel1,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (vida==2){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel2,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (vida==3){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel3,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (vida==4){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel4,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (vida==5){
            barraVi = new Sprite(826,544, admRecursos.regionBarranivel5,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }



    }
    public void crearBarrasL(){
        if (laser==0){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel0,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (laser==1){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel1,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (laser==2){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel2,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (laser==3){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel3,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (laser==4){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel4,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }
        if (laser==5){
            barraL = new Sprite(826,285, admRecursos.regionBarranivel5,admRecursos.vbom) {
                @Override
                protected void preDraw(GLState pGLState, Camera pCamera) {
                    super.preDraw(pGLState, pCamera);
                    pGLState.enableDither();
                }
            };
        }



    }
    public void dibujarBarras(){
        attachChild(barraF);
        attachChild(barraV);
        attachChild(barraVi);
        attachChild(barraL);

    }
}
