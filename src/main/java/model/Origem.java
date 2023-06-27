package model;

public enum Origem {

	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");

	private String descricao;

	Origem(String descricao){

		this.descricao = descricao;
	}

	public String getDecricao() {
		return descricao;
	}

}
