package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * 
 * Predstavlja interfejs za vulkanizersku radnju
 * 
 * @author Mario64NP
 * @version 1.0
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju
	 * @param a nova guma koja se dodaje
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pretrazuje sve gume po nazivu proizvodjaca i modelu
	 * @param markaModel naziv proizvodjaca i model
	 * @return trazena guma (AutoGuma)
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca listu svih guma
	 * @return lista svih guma (List)
	 */
	List<AutoGuma> vratiSveGume();
}