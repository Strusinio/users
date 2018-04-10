package servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
	private Konto akutalnieZalogowany;
	Map<String, Konto> kontaMap = new HashMap<>();

	public Model() {
		System.out.println("inicjalizacja modelu");
		Konto admin = new Konto("admin", "admin");
		admin.setUprawnienie(Uprawnienie.ADMIN);
		kontaMap.put(admin.getLogin(), admin);
	}

	public Konto getAkutalnieZalogowany() {
		return akutalnieZalogowany;
	}

	public void setAkutalnieZalogowany(Konto akutalnieZalogowany) {
		this.akutalnieZalogowany = akutalnieZalogowany;
	}

	public Konto pobierzPoNazwie(String login) {
		return kontaMap.get(login);
	}

	public void dodajKonto(Konto konto) {
		kontaMap.put(konto.getLogin(), konto);
	}

	public List<Konto> kontaDoEdycji() {
		List<Konto> konta = new ArrayList<>();
		for (Konto konto : kontaMap.values()) {
			if (konto.getUprawnienie() != Uprawnienie.ADMIN) {
				konta.add(konto);
			}
		}
		return konta;
	}

	public void zmienUprawnienie(String login) {
		Konto konto = kontaMap.get(login);
		if (konto.getUprawnienie() == Uprawnienie.NORMALNY) {
			konto.setUprawnienie(Uprawnienie.PREMUIM);
		} else if (konto.getUprawnienie() == Uprawnienie.PREMUIM) {
			konto.setUprawnienie(Uprawnienie.NORMALNY);
		}
	}

}