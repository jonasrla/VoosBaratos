var destinos = 
[
"--",
"Brasilia - Presidente Juscelino Kubitschek",
"Goiania - Santa Genoveva",
"Campo Grande",
"Marechal Rondon",
"Rio Branco - Presidente Medici",
"Manaus - Eduardo Gomes",
"Regional de Parintins",
"Macapa",
"Belem - Val de Cans",
"Maraba",
"Santarem - Maestro Wilson Fonseca",
"Porto Velho - Governador Jorge Teixeira de Oliveira",
"Boa Vista - Atlas Brasil",
"Palmas - Brigadeiro Lysias Rodrigues",
"Maceio - Zumbi dos Palmares",
"Ilheus - Jorge Amado",
"Porto Seguro",
"Salvador - Deputado Luis Eduardo Magalhaes",
"Fortaleza - Pinto Martins",
"Imperatriz - Guilherme Cortez",
"Sao Luis - Marechal Cunha Machado",
"Joao Pessoa - Presidente Castro Pinto",
"Petrolina",
"Recife - Gilberto Freyre",
"Teresina - Senador Petronio Portela",
"Natal - Augusto Severo",
"Aracaju - Santa Maria",
"Vitoria - Eurico de Aguiar Salles",
"Belo Horizonte-Confins",
"Uberlandia - Cesar Bombonato",
"Santos Dumont",
"Rio de Janeiro-Galeao",
"Bauru-Arealva",
"Campinas - Viracopos",
"Presidente Prudente",
"Ribeirao Preto",
"Sao Jose do Rio Preto",
"Congonhas",
"Sao Paulo-Guarulhos",
"Curitiba - Afonso Pena",
"Foz do Iguacu - Cataratas",
"Londrina - Governador Jose Richa",
"Porto Alegre - Salgado Filho",
"Florianopolis - Hercilio Luz",
"Joinville - Lauro Carneiro de Loyola",
"Navegantes - Ministro Victor Konder",
]

function oriDes(){
	for (var i=0; i<destinos.length; i++){
		document.getElementById("origem").innerHTML += "<option value="+(i-1).toString()+">"+destinos[i]+"</option>";
	}
	for (var i=0; i<destinos.length; i++){
		document.getElementById("destino").innerHTML += "<option value="+(i-1).toString()+">"+destinos[i]+"</option>";
	}
}

function excluiOpcao(otherSelect,properSelect){
	var e1 = document.getElementById(properSelect);
	var strUser1 = e1.options[e1.selectedIndex].value;
	var e2 = document.getElementById(otherSelect);
	var strUser2 = e2.options[e2.selectedIndex].value;	
	if (!(strUser1 == -1 && strUser2 == -1)){
		document.getElementById(otherSelect).innerHTML = "";
		for (var i=0; i<destinos.length; i++){
			if(i-1!=strUser1){
				if (i-1 == strUser2){
					document.getElementById(otherSelect).innerHTML += "<option value="+(i-1).toString()+" selected>"+destinos[i]+"</option>";
				}
				else{
					document.getElementById(otherSelect).innerHTML += "<option value="+(i-1).toString()+">"+destinos[i]+"</option>";
				}
			}
		}
	}
}