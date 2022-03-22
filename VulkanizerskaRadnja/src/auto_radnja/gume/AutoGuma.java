package auto_radnja.gume;

/**
 * 
 * Predstavlja jedan objekat gume za automobil.
 * 
 * @author Mario64NP
 * @version 1.0
 */
public class AutoGuma {
	/**
	 * Porizvodjac i model gume
	 */
	private String markaModel = null;
	/**
	 * Precnik gume u cm
	 */
	private int precnik = -1;
	/**
	 * Sirina gume u cm
	 */
	private int sirina = -1;
	/**
	 * Visina gume u cm
	 */
	private int visina = -1;

	/**
	 * Default konstruktor
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor sa svim parametrima
	 * @param markaModel proizvodjac i model gume
	 * @param precnik precnik gume
	 * @param sirina sirina gume
	 * @param visina visina gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca proizvodjaca i model gume
	 * @return proizvodjac i model gume (string)
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja proizvodjaca i model gume
	 * @param markaModel naziv proizvodjaca i model gume
	 * @throws NullPointerException ako je prosledjen null
	 * @throws IllegalArgumentException ako prosledjeni naziv ima manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume
	 * @return precnik gume (int)
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume
	 * @param precnik precnik gume u cm
	 * @throws IllegalArgumentException ako je uneti parametar van dozvoljenog opsega [13-22]
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca siriinu gume
	 * @return sirina gume (int)
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume
	 * @param sirina sirina gume u cm
	 * @throws IllegalArgumentException ako je uneti parametar van dozvoljenog opsega [135-355]
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume
	 * @return visina gume (int)
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume
	 * @param visina visina gume u cm
	 * @throws IllegalArgumentException ako je uneti parametar van dozvoljenog opsega [25-95]
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Predstavlja objekat kao string
	 * @return String reprezentacija objekta
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Proverava da li je prosledjena guma jednaka trenutnoj
	 * @return true ako su svi parametri jednaki kod obe gume; u suprotnom false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}