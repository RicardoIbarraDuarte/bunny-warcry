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

/**
 * Carga/Descarga los recurso del juego. Imágenes, Audios
 */
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
    public TiledTextureRegion regionHamsterAtras;
    private BuildableBitmapTextureAtlas texturaHamsterIzquierda;
    public TiledTextureRegion regionHamsterIzquierda;
    private BuildableBitmapTextureAtlas texturaHamsterDerecha;
    public TiledTextureRegion regionHamsterDerecha;
    public TiledTextureRegion[] regionesHamster;



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

    // crear escena acerca de
    public void cargarRecursosAcercaDe() {
        try {
            // Carga la imagen de fondo de la pantalla de Acerca
            texturaFondoAcerca = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaAcercaDe/FondoAcercaDe.jpg");
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

    }
    public void liberarRecursosMenu() {
        // Fondo
        texturaMenu.unload();
        regionMenu = null;
        // botón jugar
        btaBtnJugar.unload();
        regionBtnJugar = null;
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

/*        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnN1 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,150);
        regionBtnN1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN1,
        actividadJuego.getAssets(),
                "btaBtnN1.png", 1, 1);
        try {
            btaBtnN1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN1.load();
        // Carga la imagen para el botón Creditos
        btaBtnN2 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN2,
        actividadJuego.getAssets(),
                "BotonN2.png", 1, 1);
        try {
            btaBtnN2.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN2.load();
        btaBtnN3 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN3,
        actividadJuego.getAssets(),
                "BotonN3.png", 1, 1);
        try {
            btaBtnN3.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN3.load();
        btaBtnN4 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN4,
        actividadJuego.getAssets(),
                "BotonN4.png", 1, 1);
        try {
            btaBtnN4.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN4.load();
        */

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
            regionBarranivel0 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel0.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel1 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp1.jpg");
            regionBarranivel1 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel1.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel2 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp2.jpg");
            regionBarranivel2 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel2.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel3 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp3.jpg");
            regionBarranivel3 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel3.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel4 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp4.jpg");
            regionBarranivel4 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel4.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaBarranivel5 = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/BarraExp5.jpg");
            regionBarranivel5 = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaBarranivel5.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
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
                        actividadJuego.getAssets(), "EscenaJuego/FondoJuego2.jpg");
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



        }


        if (x==2 || x==3 || x==4){

        }
        if (x==3 || x==4){

        }
        if (x==4){

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
