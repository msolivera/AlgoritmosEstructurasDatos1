/*
 Partiendo de las implementaciones que tienes del TDA Lista, desarrolla un TDA Conjunto que, en particular, implemente las funciones:
• Union: dada una segunda instancia del TDA Conjunto, devuelve una tercera, producto de aplicar esta operación sobre los elementos propios y de la segunda TODOS.
• Interseccion: dada una segunda instancia del TDA Conjunto, devuelve una tercera, producto de aplicar esta operación sobre los elementos propios y de la segunda SOLOS EN COMUN.
 */
package ut3_pd7;


/**
 *
 * @author Meki
 */
public interface IConjunto<T> extends ILista<T> {

    public IConjunto<T> union(IConjunto<T> otroConjunto);

    public IConjunto<T> interseccion(IConjunto<T> otroConjunto);
}
