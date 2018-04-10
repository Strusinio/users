package servlets;

public class Konto {
	private String login;
	private String haslo;
	private Uprawnienie uprawnienie;

	public Konto(String login, String haslo) {
		this.login = login;
		this.haslo = haslo;
		uprawnienie = Uprawnienie.NORMALNY;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String Login) {
		this.login = Login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String Haslo) {
		this.haslo = Haslo;
	}

	public Uprawnienie getUprawnienie() {
		return uprawnienie;
	}

	public void setUprawnienie(Uprawnienie uprawnienie) {
		this.uprawnienie = uprawnienie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((haslo == null) ? 0 : haslo.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Konto other = (Konto) obj;
		if (haslo == null) {
			if (other.haslo != null)
				return false;
		} else if (!haslo.equals(other.haslo))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}