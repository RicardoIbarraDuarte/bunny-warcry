package com.example.stryker.bunny_warcray;

import android.util.Log;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.bitmap.AssetBitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import java.io.IOException;

public class
        AdministradorRecursos
{
    // Instancia única de la clase
    private static final AdministradorRecursos INSTANCE = new AdministradorRecursos();

    public Engine engine;
    public ControlJuego actividadJuego;
    public Camera camara;
    public VertexBufferObjectManager vbom;

    // ** TEXTURAS **
    // Escena Splash (imagen estática)
    private ITexture texturaSplash;
    public ITextureRegion regionSplash;

    // Escena gameover (imagen estática)
    private ITexture texturaGameover;
    public ITextureRegion regionGameover;

    // Escena Juegos
    private ITexture texturaFondoJuego;
    public ITextureRegion regionFondoJuego;
    private ITexture texturaFondo1;
    public ITextureRegion regionFondo1;
    private ITexture texturaFondo2;
    public ITextureRegion regionFondo2;
    private ITexture texturaFondo3;
    public ITextureRegion regionFondo3;
    private ITexture texturaFondo4;
    public ITextureRegion regionFondo4;
    private ITexture texturaHamster;
    public ITextureRegion regionHamster;
    private ITexture texturaHamstercreepy;
    public ITextureRegion regionHamstercreepy;
    private BuildableBitmapTextureAtlas texturaPersonajeFrente;
    public TiledTextureRegion regionPersonajeFrente;
    private BuildableBitmapTextureAtlas texturaPersonajeAtras;
    public TiledTextureRegion regionPersonajeAtras;
    private BuildableBitmapTextureAtlas texturaPersonajeDerecha;
    public TiledTextureRegion regionPersonajeDerecha;
    private BuildableBitmapTextureAtlas texturaPersonajeGolpeado;
    public TiledTextureRegion regionPersonajeGolpeado;
    private BuildableBitmapTextureAtlas texturaPersonajeIzquierda;
    public TiledTextureRegion regionPersonajeIzquierda;
    private ITexture texturaFondoControl;
    public ITextureRegion regionFondoControl;
    private ITexture texturaBotonControl;
    public ITextureRegion regionBotonControl;
    private ITexture texturaBarra;
    public ITextureRegion regionBarra;
    public ITiledTextureRegion regionBtnAtacar;
    private BuildableBitmapTextureAtlas btaBtnAtacar;
    public ITiledTextureRegion regionBtnLaser;
    private BuildableBitmapTextureAtlas btaBtnLaser;
    private BuildableBitmapTextureAtlas texturaPataqueAtras;
    public TiledTextureRegion regionPataqueAtras;
    private BuildableBitmapTextureAtlas texturaPataqueIzquierda;
    public TiledTextureRegion regionPataqueIzquierda;
    private BuildableBitmapTextureAtlas texturaPataqueDerecha;
    public TiledTextureRegion regionPataqueDerecha;
    private BuildableBitmapTextureAtlas texturaPataqueFrente;
    public TiledTextureRegion regionPataqueFrente;
    private BuildableBitmapTextureAtlas texturaCaminarFrente;
    public TiledTextureRegion regionCaminarFrente;
    private BuildableBitmapTextureAtlas texturaCaminarAtras;
    public TiledTextureRegion regionCaminarAtras;
    private BuildableBitmapTextureAtlas texturaCaminarIzquierda;
    public TiledTextureRegion regionCaminarIzquierda;
    private BuildableBitmapTextureAtlas texturaCaminarDerecha;
    public TiledTextureRegion regionCaminarDerecha;

    private BuildableBitmapTextureAtlas texturaHamsterFrente;
    public TiledTextureRegion regionHamsterFrente;
    private BuildableBitmapTextureAtlas texturaHamsteraAtras;
    public TiledTextureRegion regionHamsterAtrasC;
    private BuildableBitmapTextureAtlas texturaHamsterIzquierda;
    public TiledTextureRegion regionHamsterIzquierda;
    private BuildableBitmapTextureAtlas texturaHamsterDerecha;
    public TiledTextureRegion regionHamsterDerecha;
    public TiledTextureRegion[] regionesHamster;

    private BuildableBitmapTextureAtlas texturaHamsterFrenteC;
    public TiledTextureRegion regionHamsterFrenteC;
    private BuildableBitmapTextureAtlas texturaHamsteraAtrasC;
    public TiledTextureRegion regionHamsterAtras;
    private BuildableBitmapTextureAtlas texturaHamsterIzquierdaC;
    public TiledTextureRegion regionHamsterIzquierdaC;
    private BuildableBitmapTextureAtlas texturaHamsterDerechaC;
    public TiledTextureRegion regionHamsterDerechaC;
    public TiledTextureRegion[] regionesHamsterC;

    private BuildableBitmapTextureAtlas texturaPorugaFrente;
    public TiledTextureRegion regionPorugaFrente;
    private BuildableBitmapTextureAtlas texturaPorugaAtras;
    public TiledTextureRegion regionPorugaAtras;
    private BuildableBitmapTextureAtlas texturaPorugaIzquierda;
    public TiledTextureRegion regionPorugaIzquierda;
    private BuildableBitmapTextureAtlas texturaPorugaDerecha;
    public TiledTextureRegion regionPorugaDerecha;
    public TiledTextureRegion[] regionesPoruga;

    private BuildableBitmapTextureAtlas texturaPorugaFrenteC;
    public TiledTextureRegion regionPorugaFrenteC;
    private BuildableBitmapTextureAtlas texturaPorugaAtrasC;
    public TiledTextureRegion regionPorugaAtrasC;
    private BuildableBitmapTextureAtlas texturaPorugaIzquierdaC;
    public TiledTextureRegion regionPorugaIzquierdaC;
    private BuildableBitmapTextureAtlas texturaPorugaDerechaC;
    public TiledTextureRegion regionPorugaDerechaC;
    public TiledTextureRegion[] regionesPorugaC;

    private BuildableBitmapTextureAtlas texturaGuamomi;
    public TiledTextureRegion regionGuamomi;
    private ITexture texturaLagrimas;
    public ITextureRegion regionLagrimas;
    public TiledTextureRegion[] regionesGuamomi;

    private BuildableBitmapTextureAtlas texturaGuamomiC;
    public TiledTextureRegion regionGuamomiC;
    private ITexture texturaLagrimasC;
    public ITextureRegion regionLagrimasC;
    public TiledTextureRegion[] regionesGuamomiC;

    private ITexture texturaOdio;
    public ITextureRegion regionOdio;

    private BuildableBitmapTextureAtlas texturaYamiDerecha;
    public TiledTextureRegion regionYamiDerecha;
    private BuildableBitmapTextureAtlas texturaYamiIzquierda;
    public TiledTextureRegion regionYamiIzquierda;
    public TiledTextureRegion[] regionesYami;
    private BuildableBitmapTextureAtlas texturaYamiDerechaC;
    public TiledTextureRegion regionYamiDerechaC;
    private BuildableBitmapTextureAtlas texturaYamiIzquierdaC;
    public TiledTextureRegion regionYamiIzquierdaC;
    public TiledTextureRegion[] regionesYamiC;

    private BuildableBitmapTextureAtlas texturaMara1;
    public TiledTextureRegion regionMara1;
    private BuildableBitmapTextureAtlas texturaMara2;
    public TiledTextureRegion regionMara2;

    private ITexture texturaLaser;
    public ITextureRegion regionLaser;


    // Escena Acerca de (imagen estática)
    private ITexture texturaFondoAcerca;
    public ITextureRegion regionFondoAcerca;

    // Escena Creditos (imagen estática)
    private ITexture texturaFondoCreditos;
    public ITextureRegion regionFondoCreditos;

    // Escena Menú (imagen estática)
    private ITexture texturaMenu;
    public ITextureRegion regionMenu;

    // Botón jugar del menú
    public ITiledTextureRegion regionBtnJugar;
    private BuildableBitmapTextureAtlas btaBtnJugar;

    public ITiledTextureRegion regionBtnOpciones;
    private BuildableBitmapTextureAtlas btaBtnOpciones;

    // Botón acerca de del menú
    public ITiledTextureRegion regionBtnAcerca;
    private BuildableBitmapTextureAtlas btaBtnAcerca;

    // Botón creditos del menú
    public ITiledTextureRegion regionBtnCreditos;
    private BuildableBitmapTextureAtlas btaBtnCreditos;

    // Escena niveles (imagen estática)
    private ITexture texturaFondoNivel;
    public ITextureRegion regionFondoNivel;

    // Botón niveles
    public ITiledTextureRegion regionBtnN0;
    private BuildableBitmapTextureAtlas btaBtnN0;
    public ITiledTextureRegion regionBtnN1;
    private BuildableBitmapTextureAtlas btaBtnN1;
    public ITiledTextureRegion regionBtnN2;
    private BuildableBitmapTextureAtlas btaBtnN2;
    public ITiledTextureRegion regionBtnN3;
    private BuildableBitmapTextureAtlas btaBtnN3;
    public ITiledTextureRegion regionBtnN4;
    private BuildableBitmapTextureAtlas btaBtnN4;
    public ITiledTextureRegion regionBtnN5;
    private BuildableBitmapTextureAtlas btaExperiencia;
    public ITiledTextureRegion regionbtaExperiencia;
    private BuildableBitmapTextureAtlas btaBtnN5;

    public ITextureRegion regionFondoExperiencia;
    private ITexture texturaFondoExperiencia;
    public ITextureRegion regionBarranivel0;
    private ITexture texturaBarranivel0;
    public ITextureRegion regionBarranivel1;
    private ITexture texturaBarranivel1;
    public ITextureRegion regionBarranivel2;
    private ITexture texturaBarranivel2;
    public ITextureRegion regionBarranivel3;
    private ITexture texturaBarranivel3;
    public ITextureRegion regionBarranivel4;
    private ITexture texturaBarranivel4;
    public ITextureRegion regionBarranivel5;
    private ITexture texturaBarranivel5;
    public ITiledTextureRegion regionbtnBarras;
    private BuildableBitmapTextureAtlas btaBarras;


    private ITexture texturaFondoOpciones;
    public ITextureRegion regionFondoOpciones;


    public ITiledTextureRegion regionBtnSonidoOff;
    private BuildableBitmapTextureAtlas btaBtnSonidoOff;
    public ITiledTextureRegion regionBtnSonidoOn;
    private BuildableBitmapTextureAtlas btaBtnSonidoON;
    public ITiledTextureRegion regionBtnBorrarStats;
    private BuildableBitmapTextureAtlas btaBorrarStats;


    public static AdministradorRecursos getInstance() {
        return INSTANCE;
    }

    public static void inicializarAdministrador(Engine engine,
                                                ControlJuego control, Camera camara,
                                                VertexBufferObjectManager vbom) {

        getInstance().engine = engine;
        getInstance().actividadJuego=control;
        getInstance().camara = camara;
        getInstance().vbom = vbom;
    }

    //*** Recursos de la pantalla de Splash
    public void cargarRecursosSplash() {

    try {
        // Carga la imagen de fondo de la pantalla Splash
        texturaSplash = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                actividadJuego.getAssets(), "EscenaSplash/logoTec.png");
        regionSplash = TextureRegionFactory.extractFromTexture(texturaSplash);
        texturaSplash.load();
    } catch (IOException e) {

        Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
    }
}
    public void liberarRecursosSplash() {

        texturaSplash.unload();
        regionSplash = null;
    }

    public void cargarRecursosJuego0() {
        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondo1 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel0/parte1.jpg");
            regionFondo1 = TextureRegionFactory.extractFromTexture(texturaFondo1);
            texturaFondo1.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }
        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondo2 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel0/parte2.jpg");
            regionFondo2 = TextureRegionFactory.extractFromTexture(texturaFondo2);
            texturaFondo2.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }
        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondo3 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel0/parte3.jpg");
            regionFondo3 = TextureRegionFactory.extractFromTexture(texturaFondo3);
            texturaFondo3.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }
        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondo4 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel0/parte4.jpg");
            regionFondo4 = TextureRegionFactory.extractFromTexture(texturaFondo4);
            texturaFondo4.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }

    }
    public void liberarRecursosJuego0() {
        texturaFondo1.unload();
        regionFondo1 = null;


    }

    //*** Recursos de la pantalla de juego
    public void cargarRecursosJuego() {


        try {

            // Carga la imagen del enemigo
            texturaHamster = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Enemigos/Hamster/Hamster.png");
            regionHamster = TextureRegionFactory.extractFromTexture(texturaHamster);
            texturaHamster.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el enemigo");
        }
        try {

            // Carga la imagen del enemigo
            texturaHamstercreepy = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Enemigos/Hamster/HamsterCreep.png");
            regionHamstercreepy = TextureRegionFactory.extractFromTexture(texturaHamstercreepy);
            texturaHamstercreepy.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el enemigo");
        }

    }
    public void liberarRecursosJuego() {
        texturaFondoJuego.unload();
        regionFondoJuego = null;
        texturaHamster.unload();
        regionHamster = null;
        texturaPersonajeFrente.unload();
        regionPersonajeFrente = null;
        texturaBotonControl.unload();
        regionBotonControl = null;

    }

    //*** Recursos de la pantalla de juego1
    public void cargarRecursosJuego1() {
        cargarPersonajeAtacando();
        cargarPersonajeCaminando();
        cargarUI(1);
        cargaEnemigos(1);



    }
    public void liberarRecursosJuego1() {
        liberarPersonaje();
        liberarEnemigos(1);
        liberarUI();

    }

    public void cargarRecursosJuego3() {
        cargarPersonajeAtacando();
        cargarPersonajeCaminando();
        cargarUI(2);
        cargaEnemigos(3);



    }
    public void liberarRecursosJuego3() {
        liberarPersonaje();
        liberarEnemigos(3);
        liberarUI();

    }

    public void cargarRecursosJuego2() {
        cargarPersonajeAtacando();
        cargarPersonajeCaminando();
        cargarUI(1);
        cargaEnemigos(2);



    }
    public void liberarRecursosJuego2() {
        liberarPersonaje();
        liberarEnemigos(2);
        liberarUI();

    }

    public void cargarRecursosJuego4() {
    cargarPersonajeAtacando();
    cargarPersonajeCaminando();
    cargarUI(3);
    cargaEnemigos(4);

        btaBtnLaser = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnLaser = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnLaser,
                actividadJuego.getAssets(),
                "EscenaJuego/BotonLaser.png", 1, 1);

        try {
            btaBtnLaser.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón atacar");
        }
        btaBtnLaser.load();

        try {
            texturaLaser = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/Laserya.png");
            regionLaser = TextureRegionFactory.extractFromTexture(texturaLaser);
            texturaLaser.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
        }





}
    public void liberarRecursosJuego4() {
        liberarPersonaje();
        liberarEnemigos(4);
        liberarUI();

    }

    public void cargarRecursosJuego5() {
        cargarPersonajeAtacando();
        cargarPersonajeCaminando();
        cargarUI(4);

        texturaMara1 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                1600,400);
        regionMara1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaMara1,actividadJuego, "Enemigos/MaraNormalLeft.png",4,1);
        try {
            texturaMara1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaMara1.load();

        texturaMara2 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                2000,500);
        regionMara2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaMara2,actividadJuego, "Enemigos/Marasprite.png",4,1);
        try {
            texturaMara2.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaMara2.load();

        btaBtnLaser = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnLaser = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnLaser,
                actividadJuego.getAssets(),
                "EscenaJuego/BotonLaser.png", 1, 1);

        try {
            btaBtnLaser.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón atacar");
        }
        btaBtnLaser.load();

        try {
            texturaLaser = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/Laserya.png");
            regionLaser = TextureRegionFactory.extractFromTexture(texturaLaser);
            texturaLaser.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
        }






    }
    public void liberarRecursosJuego5() {
        liberarPersonaje();
        liberarUI();

    }

    // crear escena acerca de
    public void cargarRecursosAcercaDe() {
        try {
            // Carga la imagen de fondo de la pantalla de Acerca
            texturaFondoAcerca = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaAcercaDe/AcercaDeMusica.png");
            regionFondoAcerca = TextureRegionFactory.extractFromTexture(texturaFondoAcerca);
            texturaFondoAcerca.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondoAcercaDe");
        }
    }
    public void liberarRecursosAcercaDe() {
        // Fondo
        texturaFondoAcerca.unload();
        regionFondoAcerca = null;
    }

    // crear escena créditos
    public void cargarRecursosCreditos() {
        try {
            // Carga la imagen de fondo de la pantalla de créditos
            texturaFondoCreditos = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaCreditos/FondoCreditos.jpg");
            regionFondoCreditos = TextureRegionFactory.extractFromTexture(texturaFondoCreditos);
            texturaFondoCreditos.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondoCreditos");
        }
    }
    public void liberarRecursosCreditos() {
        // Fondo
        texturaFondoCreditos.unload();
        regionFondoCreditos = null;
    }

    //*** Recursos de la pantalla de Menú
    public void cargarRecursosMenu() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaMenu = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaMenu/FondoMenu.jpg");
            regionMenu = TextureRegionFactory.extractFromTexture(texturaMenu);
            texturaMenu.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondoMenu");

        }

        // Carga la imagen para el botón jugar
        btaBtnJugar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                348,146);
        regionBtnJugar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnJugar,
                actividadJuego.getAssets(),
                "EscenaMenu/BotonJugar.png", 1, 1);
        try {
            btaBtnJugar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnJugar.load();
        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnAcerca = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                348,146);
        regionBtnAcerca = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAcerca,
                actividadJuego.getAssets(),
                "EscenaMenu/BotonAcercaDe.png", 1, 1);
        try {
            btaBtnAcerca.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón acerca de");
        }
        btaBtnAcerca.load();
        // Carga la imagen para el botón Creditos
        btaBtnCreditos = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                157,240);
        regionBtnCreditos = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                btaBtnCreditos, actividadJuego.getAssets(),
                "EscenaMenu/BotonCredito.png", 1, 1);
        try {
            btaBtnCreditos.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón creditos");
        }
        btaBtnCreditos.load();
        btaBtnOpciones = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                348,146);
        regionBtnOpciones = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                btaBtnOpciones, actividadJuego.getAssets(),
                "EscenaMenu/BotonOpciones.png", 1, 1);
        try {
            btaBtnOpciones.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón creditos");
        }
        btaBtnOpciones.load();

    }
    public void liberarRecursosMenu() {
        // Fondo
        texturaMenu.unload();
        regionMenu = null;
        // botón jugar
        btaBtnJugar.unload();
        regionBtnJugar = null;
        btaBtnAcerca.unload();
        regionBtnAcerca = null;
        btaBtnOpciones.unload();
        regionBtnOpciones = null;
        btaBtnCreditos.unload();
        regionBtnCreditos = null;
    }

    public void cargarRecursosOpciones() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaFondoOpciones = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaOpciones/FondoOpciones.jpg");
            regionFondoOpciones = TextureRegionFactory.extractFromTexture(texturaFondoOpciones);
            texturaFondoOpciones.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondoMenu");

        }

        // Carga la imagen para el botón jugar
        btaBtnSonidoOff = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnSonidoOff = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnSonidoOff,
                actividadJuego.getAssets(),
                "EscenaOpciones/BotonSonidoOff.png", 1, 1);
        try {
            btaBtnSonidoOff.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnSonidoOff.load();
        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnSonidoON = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnSonidoOn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnSonidoON ,
                actividadJuego.getAssets(),
                "EscenaOpciones/BotonSonidoOn.png", 1, 1);
        try {
            btaBtnSonidoON .build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón acerca de");
        }
        btaBtnSonidoON .load();
        // Carga la imagen para el botón Creditos
        btaBorrarStats = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnBorrarStats = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                btaBorrarStats, actividadJuego.getAssets(),
                "EscenaOpciones/BotonBorrarStats.png", 1, 1);
        try {
            btaBorrarStats.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón creditos");
        }
        btaBorrarStats.load();

    }
    public void liberarRecursosOpciones() {
        // Fondo

    }

    public void cargarRecursosNiveles() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaFondoNivel = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel/fondoNiveles.jpg");
            regionFondoNivel = TextureRegionFactory.extractFromTexture(texturaFondoNivel);
            texturaFondoNivel.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondoNiveles");

        }

        // Carga la imagen para el botón jugar
        btaBtnN0 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN0 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN0,
                actividadJuego.getAssets(),
                "EscenaNivel/btaBtnN0.png", 1, 1);
        try {
            btaBtnN0.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón nivel 0 ");
        }
        btaBtnN0.load();


        // Carga la imagen para el botón Acerca de
        btaBtnN1 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN1,
        actividadJuego.getAssets(),
                "EscenaNivel/btaBtnN1.png", 1, 1);
        try {
            btaBtnN1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN1.load();
        // Carga la imagen para el botón Creditos
        btaBtnN2 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN2,
        actividadJuego.getAssets(),
                "EscenaNivel/BotonN2.png", 1, 1);
        try {
            btaBtnN2.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN2.load();
        btaBtnN3 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN3,
        actividadJuego.getAssets(),
                "EscenaNivel/BotonN3.png", 1, 1);
        try {
            btaBtnN3.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN3.load();
        btaBtnN4 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN4,
        actividadJuego.getAssets(),
                "EscenaNivel/BotonN4.png", 1, 1);
        try {
            btaBtnN4.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN4.load();
        btaBtnN5 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN5 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN5,
                actividadJuego.getAssets(),
                "EscenaNivel/BotonN5.png", 1, 1);
        try {
            btaBtnN5.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN5.load();
        btaExperiencia = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                348,146);
        regionbtaExperiencia = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaExperiencia,
                actividadJuego.getAssets(),
                "EscenaNivel/BotonEx.png", 1, 1);
        try {
            btaExperiencia.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaExperiencia.load();



    }
    public void liberarRecursosNiveles() {
        // Fondo
        texturaFondoNivel.unload();
        regionFondoNivel = null;
        // botón jugar
        btaBtnN0.unload();
        regionBtnN0 = null;
    /*    btaBtnN1.unload();
        regionBtnN1 = null;
        btaBtnN2.unload();
        regionBtnN2 = null;
        btaBtnN3.unload();
        regionBtnN3 = null;
        btaBtnN4.unload();
        regionBtnN4 = null;
        */
    }

    public void cargarRecursosGameover() {

    try {
        // Carga la imagen de fondo de la pantalla Splash
        texturaGameover = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                actividadJuego.getAssets(), "EscenaGameover/fondoGameover.jpg");
        regionGameover = TextureRegionFactory.extractFromTexture(texturaGameover);
        texturaGameover.load();
    } catch (IOException e) {

        Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
    }
}
    public void liberarRecursosGameover() {
        texturaGameover.unload();
        regionGameover = null;
    }

    public void cargarRecursosExperiencia() {

        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaFondoExperiencia = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/Experiencia.jpg");
            regionFondoExperiencia = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaFondoExperiencia.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel0 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp0.jpg");
            regionBarranivel0 = TextureRegionFactory.extractFromTexture(texturaBarranivel0);
            texturaBarranivel0.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel1 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp1.jpg");
            regionBarranivel1 = TextureRegionFactory.extractFromTexture(texturaBarranivel1);
            texturaBarranivel1.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel2 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp2.jpg");
            regionBarranivel2 = TextureRegionFactory.extractFromTexture( texturaBarranivel2);
            texturaBarranivel2.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel3 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp3.jpg");
            regionBarranivel3 = TextureRegionFactory.extractFromTexture(texturaBarranivel3);
            texturaBarranivel3.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel4 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp4.jpg");
            regionBarranivel4 = TextureRegionFactory.extractFromTexture(texturaBarranivel4);
            texturaBarranivel4.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel5 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp5.jpg");
            regionBarranivel5 = TextureRegionFactory.extractFromTexture(texturaBarranivel5);
            texturaBarranivel5.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        btaBarras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                251,33);
        regionbtnBarras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBarras,
                actividadJuego.getAssets(),
                "EscenaExperiencia/botomInvi.png", 1, 1);

        try {
            btaBarras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón atacar");
        }
        btaBarras.load();
    }
    public void liberarRecursosExperiencia() {
        texturaFondoExperiencia.unload();
        regionFondoExperiencia = null;
    }

    public void cargarPersonajeCaminando(){
        texturaCaminarFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                643,143);
        regionCaminarFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaCaminarFrente,actividadJuego, "Personaje/caminata frente.png",4,1);
        try {
            texturaCaminarFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaCaminarFrente.load();

        texturaCaminarAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                622,151);
        regionCaminarAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaCaminarAtras,actividadJuego, "Personaje/caminata detras.png",4,1);
        try {
            texturaCaminarAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaCaminarAtras.load();

        texturaCaminarIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                568,141);
        regionCaminarIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaCaminarIzquierda,actividadJuego, "Personaje/caminata izquierda.png",4,1);
        try {
            texturaCaminarIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaCaminarIzquierda.load();

        texturaCaminarDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                560,155);
        regionCaminarDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaCaminarDerecha,actividadJuego, "Personaje/caminata derecha.png",4,1);
        try {
            texturaCaminarDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaCaminarDerecha.load();

        texturaPersonajeFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,140,140);
        regionPersonajeFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPersonajeFrente,actividadJuego, "Personaje/personajeFrente.png",1,1);
        try {
            texturaPersonajeFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPersonajeFrente.load();

        texturaPersonajeAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,140,140);
        regionPersonajeAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPersonajeAtras,actividadJuego, "Personaje/personajeAtras.png",1,1);
        try {
            texturaPersonajeAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPersonajeAtras.load();

        texturaPersonajeDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,140,140);
        regionPersonajeDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPersonajeDerecha,actividadJuego, "Personaje/personajeDerecha.png",1,1);
        try {
            texturaPersonajeDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPersonajeDerecha.load();

        texturaPersonajeIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,140,140);
        regionPersonajeIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPersonajeIzquierda,actividadJuego, "Personaje/personajeIzquierda.png",1,1);
        try {
            texturaPersonajeIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPersonajeIzquierda.load();

    }
    public void cargarPersonajeAtacando(){
        // Carga la imagen del ataque de frente
        texturaPataqueFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                902,174);
        regionPataqueFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueFrente,actividadJuego, "Personaje/PataqueFrente.png",5,1);
        try {
            texturaPataqueFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaPataqueFrente.load();

        // Carga la imagen del ataque de derecha
        texturaPataqueDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                905,156);
        regionPataqueDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueDerecha,actividadJuego, "Personaje/PataqueDerecha.png",5,1);
        try {
            texturaPataqueDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueDerecha");
        }
        texturaPataqueDerecha.load();

        // Carga la imagen del ataque de atras
        texturaPataqueAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                913,162);
        regionPataqueAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueAtras,actividadJuego, "Personaje/PataqueAtras.png",5,1);
        try {
            texturaPataqueAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueAtras");
        }
        texturaPataqueAtras.load();

        // Carga la imagen del ataque de izquierda
        texturaPataqueIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,895,154);
        regionPataqueIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueIzquierda,actividadJuego, "Personaje/PataqueIzquierda.png",5,1);
        try {
            texturaPataqueIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPataqueIzquierda.load();

        texturaPersonajeGolpeado = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,151,138);
        regionPersonajeGolpeado = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPersonajeGolpeado,actividadJuego, "Personaje/ConejoGolpeado.png",1,1);
        try {
            texturaPersonajeGolpeado.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPersonajeGolpeado.load();

    }
    public void cargarUI(int x){
        try {
            texturaFondoControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/BaseControl.png");
            texturaBotonControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/BotonControl.png");
            regionFondoControl = TextureRegionFactory.extractFromTexture(texturaFondoControl);
            texturaFondoControl.load();
            regionBotonControl = TextureRegionFactory.extractFromTexture(texturaBotonControl);
            texturaBotonControl.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
        }
        // Carga la imagen del botón de ataque
        btaBtnAtacar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnAtacar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAtacar,
                actividadJuego.getAssets(),
                "EscenaJuego/BotonPalo.png", 1, 1);

        try {
            btaBtnAtacar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón atacar");
        }
        btaBtnAtacar.load();
        try {
            texturaBarra = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/barraVida.png");
            regionBarra = TextureRegionFactory.extractFromTexture(texturaBarra);
            texturaBarra.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
        }

        if (x==1){
            try {
                // Carga la imagen de fondo de la pantalla juego
                texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "EscenaJuego/FondoJuego.jpg");
                regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
                texturaFondoJuego.load();
            } catch (IOException e) {

                Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
            }
        }
        if (x==2){
            try {
                // Carga la imagen de fondo de la pantalla juego
                texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "EscenaJuego/FondoJuego2.png");
                regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
                texturaFondoJuego.load();
            } catch (IOException e) {

                Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
            }
        }
        if (x==3){
            try {
                // Carga la imagen de fondo de la pantalla juego
                texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "EscenaJuego/FondoJuego3.jpg");
                regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
                texturaFondoJuego.load();
            } catch (IOException e) {

                Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
            }
        }
        if (x==4 || x==5){
            try {
                // Carga la imagen de fondo de la pantalla juego
                texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "EscenaJuego/FondoJuego4.jpg");
                regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
                texturaFondoJuego.load();
            } catch (IOException e) {

                Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
            }
        }
    }
    public void cargaEnemigos(int x){
        if (x==1 || x==2 || x==3 || x==4){
            texturaHamsterFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    595,116);
            regionHamsterFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterFrente,actividadJuego, "Enemigos/Hamster/HamsterFrente.png",5,1);
            try {
                texturaHamsterFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterFrente.load();

            texturaHamsterIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    585,125);
            regionHamsterIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterIzquierda,actividadJuego, "Enemigos/Hamster/HamsterIzquierda.png",5,1);
            try {
                texturaHamsterIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterIzquierda.load();

            texturaHamsterDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    585,125);
            regionHamsterDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterDerecha,actividadJuego, "Enemigos/Hamster/HamsterDerecha.png",5,1);
            try {
                texturaHamsterDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterDerecha.load();

            texturaHamsteraAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    592,116);
            regionHamsterAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsteraAtras,actividadJuego, "Enemigos/Hamster/HamsterAtras.png",5,1);
            try {
                texturaHamsteraAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsteraAtras.load();

            regionesHamster = new TiledTextureRegion[]{regionHamsterFrente,regionHamsterAtras,regionHamsterDerecha,regionHamsterIzquierda};

            texturaHamsterFrenteC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1444,289);
            regionHamsterFrenteC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterFrenteC,actividadJuego, "Enemigos/Hamster/hamstercripifrente.png",4,1);
            try {
                texturaHamsterFrenteC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterFrenteC.load();

            texturaHamsterIzquierdaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1324,289);
            regionHamsterIzquierdaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterIzquierdaC,actividadJuego, "Enemigos/Hamster/hamstercripiladoizq.png",4,1);
            try {
                texturaHamsterIzquierdaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterIzquierdaC.load();

            texturaHamsterDerechaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1324,289);
            regionHamsterDerechaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsterDerechaC,actividadJuego, "Enemigos/Hamster/hamstercripiladoderecho.png",4,1);
            try {
                texturaHamsterDerechaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsterDerechaC.load();

            texturaHamsteraAtrasC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1444,289);
            regionHamsterAtrasC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaHamsteraAtrasC,actividadJuego, "Enemigos/Hamster/hamstercripiatras.png",4,1);
            try {
                texturaHamsteraAtrasC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaHamsteraAtrasC.load();

            regionesHamsterC = new TiledTextureRegion[]{regionHamsterFrenteC,regionHamsterAtrasC,regionHamsterDerechaC,regionHamsterIzquierdaC};



        }


        if (x==2 || x==3 || x==4){
            texturaGuamomi = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,389);
            regionGuamomi = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaGuamomi,actividadJuego, "Enemigos/Guamomi/SpriteSheetGuamominormal.png",4,1);
            try {
                texturaGuamomi.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaGuamomi.load();

            regionesGuamomi = new TiledTextureRegion[]{regionGuamomi};

            try {
                texturaLagrimas = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "Enemigos/Guamomi/LagrimasGuamomi.png");
                regionLagrimas = TextureRegionFactory.extractFromTexture(texturaLagrimas);
                texturaLagrimas.load();
            } catch (IOException e) {
                Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
            }

            texturaGuamomiC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    2400,400);
            regionGuamomiC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaGuamomiC,actividadJuego, "Enemigos/Guamomi/GuamomiCreepy.png",6,1);
            try {
                texturaGuamomiC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaGuamomiC.load();

            regionesGuamomiC = new TiledTextureRegion[]{regionGuamomiC};

            try {
                texturaLagrimasC = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "Enemigos/Guamomi/LagrimasGuamomiCreep.png");
                regionLagrimasC = TextureRegionFactory.extractFromTexture(texturaLagrimasC);
                texturaLagrimasC.load();
            } catch (IOException e) {
                Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
            }





        }
        if (x==3 || x==4){
            texturaYamiDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    795,163);
            regionYamiDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaYamiDerecha,actividadJuego, "Enemigos/Jamieltopo/Jami el topoDerecha.png",5,1);
            try {
                texturaYamiDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaYamiDerecha.load();

            texturaYamiIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    795,163);
            regionYamiIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaYamiIzquierda,actividadJuego, "Enemigos/Jamieltopo/Jami el topoIzquierda.png",5,1);
            try {
                texturaYamiIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaYamiIzquierda.load();

            regionesYami =  new TiledTextureRegion[]{regionYamiDerecha, regionYamiIzquierda};

            texturaYamiDerechaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    2000,400);
            regionYamiDerechaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaYamiDerechaC,actividadJuego, "Enemigos/Jamieltopo/SpriteSheetJamiCreepyD.png",5,1);
            try {
                texturaYamiDerechaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaYamiDerechaC.load();

            texturaYamiIzquierdaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    2000,400);
            regionYamiIzquierdaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaYamiIzquierdaC,actividadJuego, "Enemigos/Jamieltopo/SpriteSheetJamiCreepyD.png",5,1);
            try {
                texturaYamiIzquierdaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaYamiIzquierdaC.load();

            regionesYamiC =  new TiledTextureRegion[]{regionYamiDerechaC, regionYamiIzquierdaC};


        }
        if (x==4){
            texturaPorugaFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1805,389);
            regionPorugaFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaFrente,actividadJuego, "Enemigos/Poruga/spritesheet-poruga-delante.png",5,1);
            try {
                texturaPorugaFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaFrente.load();

            texturaPorugaIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaIzquierda,actividadJuego, "Enemigos/Poruga/poruga izquierda.png",4,1);
            try {
                texturaPorugaIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaIzquierda.load();

            texturaPorugaDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaDerecha,actividadJuego, "Enemigos/Poruga/PorugaDerecha.png",4,1);
            try {
                texturaPorugaDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaDerecha.load();

            texturaPorugaAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1888,390);
            regionPorugaAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaAtras,actividadJuego, "Enemigos/Poruga/spritesheet-poruga-atras.png",5,1);
            try {
                texturaPorugaAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaAtras.load();

            regionesPoruga = new TiledTextureRegion[]{regionPorugaFrente,regionPorugaAtras,regionPorugaDerecha,regionPorugaIzquierda};
            try {
                texturaOdio = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                        actividadJuego.getAssets(), "Enemigos/Poruga/proyectil poruga.png");
                regionOdio = TextureRegionFactory.extractFromTexture(texturaOdio);
                texturaOdio.load();
            } catch (IOException e) {
                Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
            }

            texturaPorugaFrenteC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaFrenteC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaFrenteC,actividadJuego, "Enemigos/Poruga/PorugaFront.png",4,1);
            try {
                texturaPorugaFrenteC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaFrenteC.load();

            texturaPorugaIzquierdaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaIzquierdaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaIzquierdaC,actividadJuego, "Enemigos/Poruga/PorugaLeft.png",4,1);
            try {
                texturaPorugaIzquierdaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaIzquierdaC.load();

            texturaPorugaDerechaC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaDerechaC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaDerechaC,actividadJuego, "Enemigos/Poruga/PorugaRight.png",4,1);
            try {
                texturaPorugaDerechaC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaDerechaC.load();

            texturaPorugaAtrasC = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                    1600,400);
            regionPorugaAtrasC = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                    texturaPorugaAtrasC,actividadJuego, "Enemigos/Poruga/PorugaBack.png",4,1);
            try {
                texturaPorugaAtrasC.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                        BitmapTextureAtlas>(0,0,0));
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
                Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
            }
            texturaPorugaAtrasC.load();

            regionesPorugaC = new TiledTextureRegion[]{regionPorugaFrenteC,regionPorugaAtrasC,regionPorugaDerechaC,regionPorugaIzquierdaC};

        }
    }
    public void liberarPersonaje(){
        texturaPataqueAtras.unload();
        regionPataqueAtras = null;
        texturaPataqueFrente.unload();
        regionPataqueFrente = null;
        texturaPataqueDerecha.unload();
        regionPataqueDerecha = null;
        texturaPataqueIzquierda.unload();
        regionPataqueIzquierda = null;
        texturaPersonajeAtras.unload();
        regionPersonajeAtras = null;
        texturaPersonajeIzquierda.unload();
        regionPersonajeIzquierda = null;
        texturaPersonajeDerecha.unload();
        regionPersonajeDerecha = null;
        texturaPersonajeFrente.unload();
        regionPersonajeFrente = null;
        texturaCaminarDerecha.unload();
        regionCaminarDerecha = null;
        texturaCaminarAtras.unload();
        regionCaminarAtras = null;
        texturaCaminarIzquierda.unload();
        regionCaminarIzquierda = null;
        texturaCaminarFrente.unload();
        regionCaminarFrente = null;
        texturaPersonajeGolpeado.unload();
        regionPersonajeGolpeado = null;



    }
    public void liberarEnemigos(int x){
        if (x==1 || x==2 || x==3 || x==4){
            texturaHamsterFrente.unload();
            regionHamsterFrente = null;
            texturaHamsterIzquierda.unload();
            regionHamsterIzquierda = null;
            texturaHamsterDerecha.unload();
            regionHamsterDerecha = null;
            texturaHamsteraAtras.unload();
            regionHamsterAtras = null;
        }


        if (x==2 || x==3 || x==4){
            texturaGuamomi.unload();
            regionGuamomi=null;
            texturaLagrimas.unload();
            regionLagrimas=null;

        }
        if (x==3 || x==4){

        }
        if (x==4){

        }

    }
    public void liberarUI() {
        texturaFondoJuego.unload();
        regionFondoJuego = null;
        texturaBotonControl.unload();
        regionBotonControl = null;
        texturaFondoControl.unload();
        regionFondoControl = null;
        btaBtnAtacar.unload();
        regionBotonControl = null;
    }
}
