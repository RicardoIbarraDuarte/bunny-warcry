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
public class AdministradorRecursos
{
    // Instancia única de la clase
    private static final AdministradorRecursos INSTANCE =
            new AdministradorRecursos();

    public Engine engine;
    public ControlJuego actividadJuego;
    public Camera camara;
    public VertexBufferObjectManager vbom;

    // ** TEXTURAS **
    // Escena Splash (imagen estática)
    private ITexture texturaSplash;
    public ITextureRegion regionSplash;

    // Escena Juego
    private ITexture texturaFondoJuego;
    public ITextureRegion regionFondoJuego;
    private ITexture texturaEnemigo;
    public ITextureRegion regionEnemigo;
    private ITexture texturaPersonajeFrente;
    public ITextureRegion regionPersonajeFrente;
    private ITexture texturaPersonajeAtras;
    public ITextureRegion regionPersonajeAtras;
    private ITexture texturaPersonajeDerecha;
    public ITextureRegion regionPersonajeDerecha;
    private ITexture texturaPersonajeGolpeado;
    public ITextureRegion regionPersonajeGolpeado;
    private ITexture texturaPersonajeIzquierda;
    public ITextureRegion regionPersonajeIzquierda;
    private ITexture texturaFondoControl;
    public ITextureRegion regionFondoControl;
    private ITexture texturaBotonControl;
    public ITextureRegion regionBotonControl;
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
    // Escena Acerca de (imagen estática)
    private ITexture texturaFondoAcerca;
    public ITextureRegion regionFondoAcerca;

    // Escena Creditos (imagen estática)
    private ITexture texturaFondoCreditos;
    public ITextureRegion regionFondoCreditos;

    // Botón regrear
    public ITiledTextureRegion regionBtnRegresar;
    private BuildableBitmapTextureAtlas btaBtnRegresar;


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
    // Botón jugar del menú
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

    public static AdministradorRecursos getInstance() {
        return INSTANCE;
    }

    public static void inicializarAdministrador(Engine engine,
                                                ControlJuego control, Camera camara, VertexBufferObjectManager vbom) {

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
                    actividadJuego.getAssets(), "logoTec.png");
            regionSplash = TextureRegionFactory.extractFromTexture(texturaSplash);
            texturaSplash.load();
        } catch (IOException e) {
            Log.d("cargarRecursosSplash", "No se puede cargar el fondo");
        }
    }

    public void liberarRecursosSplash() {
        texturaSplash.unload();
        regionSplash = null;
    }

    //*** Recursos de la pantalla de juego
    public void cargarRecursosJuego() {
        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "FondoJuego.jpg");
            regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
            texturaFondoJuego.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }
        try {
            // Carga la imagen del enemigo
            texturaEnemigo = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "enemigo.png");
            regionEnemigo = TextureRegionFactory.extractFromTexture(texturaEnemigo);
            texturaEnemigo.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el enemigo");
        }
        try {
            // Carga la imagen del personaje
            texturaPersonajeFrente = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "personajeFrente.png");
            regionPersonajeFrente = TextureRegionFactory.extractFromTexture(texturaPersonajeFrente);
            texturaPersonajeFrente.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personaje");
        }
        try {
            // Carga la imagen del personaje
            texturaPersonajeGolpeado = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "ConejoGolpeado.png");
            regionPersonajeGolpeado = TextureRegionFactory.extractFromTexture(texturaPersonajeGolpeado );
            texturaPersonajeGolpeado.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personaje");
        }
        try {
            // Carga la imagen del personaje
            texturaPersonajeAtras = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "personajeAtras.png");
            regionPersonajeAtras = TextureRegionFactory.extractFromTexture(texturaPersonajeAtras);
            texturaPersonajeAtras.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personaje");
        }
        try {
            // Carga la imagen del personaje
            texturaPersonajeDerecha = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "personajeDerecha.png");
            regionPersonajeDerecha = TextureRegionFactory.extractFromTexture(texturaPersonajeDerecha);
            texturaPersonajeDerecha.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personaje");
        }
        try {
            // Carga la imagen del personaje
            texturaPersonajeIzquierda = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "personajeIzquierda.png");
            regionPersonajeIzquierda = TextureRegionFactory.extractFromTexture(texturaPersonajeIzquierda);
            texturaPersonajeIzquierda.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personaje");
        }
        // Carga la imagen para el botón arriba
        try {
            texturaFondoControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(),"BaseControl.png");
            texturaBotonControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(),"BotonControl.png");
            regionFondoControl = TextureRegionFactory.extractFromTexture(texturaFondoControl);
            texturaFondoControl.load();
            regionBotonControl = TextureRegionFactory.extractFromTexture(texturaBotonControl);
            texturaBotonControl.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el boton");
        }
        btaBtnAtacar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnAtacar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAtacar, actividadJuego.getAssets(),
                "BotonPalo.png", 1, 1);
        try {
            btaBtnAtacar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnAtacar.load();

        texturaPataqueFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),795,131);
        regionPataqueFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueFrente,actividadJuego, "PataqueFrente.png",5,1);
        try {
            texturaPataqueFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen para el Sprite del perro Animado");
        }
        texturaPataqueFrente.load();

        texturaPataqueDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),795,131);
        regionPataqueDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueDerecha,actividadJuego, "PataqueDerecha.png",5,1);
        try {
            texturaPataqueDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen para el Sprite del perro Animado");
        }
        texturaPataqueDerecha.load();

        texturaPataqueAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),795,131);
        regionPataqueAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueAtras,actividadJuego, "PataqueAtras.png",5,1);
        try {
            texturaPataqueAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen para el Sprite del perro Animado");
        }
        texturaPataqueAtras.load();

        texturaPataqueIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),795,131);
        regionPataqueIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueIzquierda,actividadJuego, "PataqueIzquierda.png",5,1);
        try {
            texturaPataqueIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen para el Sprite del perro Animado");
        }
        texturaPataqueIzquierda.load();


    }

    public void liberarRecursosJuego() {
        texturaFondoJuego.unload();
        regionFondoJuego = null;
        texturaEnemigo.unload();
        regionEnemigo = null;
        texturaPersonajeFrente.unload();
        regionPersonajeFrente = null;
        texturaBotonControl.unload();
        regionBotonControl = null;

    }
    // crear escena acerca de
    public void cargarRecursosAcercaDe() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaFondoAcerca = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "FondoAcercaDe.jpg");
            regionFondoAcerca = TextureRegionFactory.extractFromTexture(texturaFondoAcerca);
            texturaFondoAcerca.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondo");
        }
        btaBtnRegresar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                142,108);
        regionBtnRegresar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnRegresar, actividadJuego.getAssets(),
                "Flecha.png", 1, 1);
        try {
            btaBtnRegresar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnRegresar.load();
    }
    public void liberarRecursosAcercaDe() {
        // Fondo
        texturaFondoAcerca.unload();
        regionFondoAcerca = null;
        // botón regresar
        btaBtnRegresar.unload();
        regionBtnRegresar = null;
    }
    // crear escena creditos
    public void cargarRecursosCreditos() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaFondoCreditos = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "FondoCreditos.jpg");
            regionFondoCreditos = TextureRegionFactory.extractFromTexture(texturaFondoCreditos);
            texturaFondoCreditos.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondo");
        }
        btaBtnRegresar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                142,108);
        regionBtnRegresar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnRegresar, actividadJuego.getAssets(),
                "Flecha.png", 1, 1);
        try {
            btaBtnRegresar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnRegresar.load();
    }
    public void liberarRecursosCreditos() {
        // Fondo
        texturaFondoCreditos.unload();
        regionFondoCreditos = null;
        // botón jugar
        btaBtnRegresar.unload();
        regionBtnRegresar = null;
    }



    //*** Recursos de la pantalla de Menú
    public void cargarRecursosMenu() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaMenu = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "FondoMenu.jpg");
            regionMenu = TextureRegionFactory.extractFromTexture(texturaMenu);
            texturaMenu.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondo");

        }

        // Carga la imagen para el botón jugar
        btaBtnJugar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                368,120);
        regionBtnJugar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnJugar, actividadJuego.getAssets(),
                "BotonJugar.png", 1, 1);
        try {
            btaBtnJugar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnJugar.load();
        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnAcerca = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                368,120);
        regionBtnAcerca = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAcerca, actividadJuego.getAssets(),
                "BotonAcercaDe.png", 1, 1);
        try {
            btaBtnAcerca.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnAcerca.load();
        // Carga la imagen para el botón Creditos
        btaBtnCreditos = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnCreditos = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnCreditos, actividadJuego.getAssets(),
                "BotonCredito.jpg", 1, 1);
        try {
            btaBtnCreditos.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
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
                    actividadJuego.getAssets(), "fondoNiveles.jpg");
            regionFondoNivel = TextureRegionFactory.extractFromTexture(texturaFondoNivel);
            texturaFondoNivel.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondo");

        }

        // Carga la imagen para el botón jugar
        btaBtnN0 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN0 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN0, actividadJuego.getAssets(),
                "btaBtnN0.png", 1, 1);
        try {
            btaBtnN0.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón ");
        }
        btaBtnN0.load();

/*        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnN1 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,150);
        regionBtnN1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN1, actividadJuego.getAssets(),
                "btaBtnN1.png", 1, 1);
        try {
            btaBtnN1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN1.load();
        // Carga la imagen para el botón Creditos
        btaBtnN2 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN2, actividadJuego.getAssets(),
                "BotonN2.png", 1, 1);
        try {
            btaBtnN2.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN2.load();
        btaBtnN3 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN3, actividadJuego.getAssets(),
                "BotonN3.png", 1, 1);
        try {
            btaBtnN3.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN3.load();
        btaBtnN4 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN4, actividadJuego.getAssets(),
                "BotonN4.png", 1, 1);
        try {
            btaBtnN4.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,0,0));

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
}
