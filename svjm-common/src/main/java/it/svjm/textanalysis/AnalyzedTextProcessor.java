package it.svjm.textanalysis;

import it.svjm.textanalysis.model.AnalyzedText;
import it.svjm.textanalysis.model.Annotation;
import it.svjm.textanalysis.model.Mood;

import java.util.Collection;
import java.util.Map;

public interface AnalyzedTextProcessor {

	// @formatter:off
	/**
	 * Estrae il "mood" associato a un testo, in base alla polarità complessiva
	 * assegnata dalla fase di analisi.
	 * 
	 * Tra tutte le annotazioni presenti devono essere prese in considerazione
	 * solo quelle di tipo Polarity. Nel caso ce ne sia più di una, si sceglie
	 * la prima (nell'ordine restituito da getAnnotations()). Il Mood restituito
	 * è calcolato nel seguente modo: NEGATIVE se la prima Polarity ha un valore
	 * compreso tra 0 e 50 POSITIVE se la prima Polarity ha un valore compreso
	 * tra 51 e 100 NONE in tutti gli altri casi
	 *
	 */
	// @formatter:on
	public Mood extractMood(AnalyzedText analyzedText);

	// @formatter:off
	/**
	 * Estrae l'elenco delle entità di tipo PERSON riconosciute all'interno di
	 * un testo analizzato.
	 * 
	 * Tra tutte le annotazioni presenti devono essere prese in considerazione
	 * solo quelle di tipo Entity che abbiano type uguale a PERSON. Deve essere
	 * restituita una mappa che abbia per chiave la posizione iniziale
	 * dell'entità riconosciuta e come valore l'entità stessa.
	 */
	// @formatter:on
	public Map<Integer, Annotation> indexPersons(AnalyzedText analyzedText);

	// @formatter:off
	/**
	 * Estrae l'elenco delle entità di tipo LOCATION riconosciute all'interno di
	 * un testo analizzato.
	 * 
	 * Tra tutte le annotazioni presenti devono essere prese in considerazione
	 * solo quelle di tipo Entity che abbiano type uguale a LOCATION. Deve
	 * essere restituita una mappa che abbia per chiave la posizione iniziale
	 * dell'entità riconosciuta e come valore l'entità stessa.
	 */
	// @formatter:on
	public Map<Integer, Annotation> indexLocations(AnalyzedText analyzedText);

	// @formatter:off
	/**
	 * Estrae l'elenco delle entità riconosciute all'interno di un testo
	 * analizzato che abbiano una lunghezza minore o uguale al valore indicato
	 * (maxLength).
	 * 
	 * Tra tutte le annotazioni presenti devono essere prese in considerazione
	 * solo quelle di tipo Entity che soddisfino la condizione (end - begin) <=
	 * maxLength. Deve essere restituita una mappa che abbia per chiave la
	 * posizione iniziale dell'entità riconosciuta e come valore l'entità
	 * stessa.
	 */
	// @formatter:on
	public Map<Integer, Annotation> indexShortEntities(
			AnalyzedText analyzedText, int maxLength);

	// @formatter:off
	/**
	 * Restituisce l'elenco delle entità che compaiono più volte all'interno del
	 * testo analizzato.
	 * 
	 * Le annotazioni di tipo Entity devono essere raggruppate in base al numero
	 * di volte che la stessa entità compare nel testo, quindi devono essere
	 * selezionate solo quelle con frequenza massima. Deve essere restituito
	 * l'elenco delle IRI delle entità che compaiono con maggiore frequenza.
	 */
	// @formatter:on
	public Collection<String> mostFrequentEntities(AnalyzedText analyzedText);

}
