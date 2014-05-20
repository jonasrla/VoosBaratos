var destinos = 
[
"--",
"Aeroporto Internacional de Brasilia - Presidente Juscelino Kubitschek",
"Aeroporto Internacional de Goiania - Santa Genoveva",
"Aeroporto Internacional de Campo Grande",
"Aeroporto Internacional Marechal Rondon",
"Aeroporto Internacional de Rio Branco - Presidente Medici",
"Aeroporto Internacional de Manaus - Eduardo Gomes",
"Aeroporto Regional de Parintins",
"Aeroporto Internacional de Macapa",
"Aeroporto Internacional de Belem - Val de Cans",
"Aeroporto de Maraba",
"Aeroporto de Santarem - Maestro Wilson Fonseca",
"Aeroporto Internacional de Porto Velho - Governador Jorge Teixeira de Oliveira",
"Aeroporto Internacional de Boa Vista - Atlas Brasil",
"Aeroporto de Palmas - Brigadeiro Lysias Rodrigues",
"Aeroporto Internacional de Maceio - Zumbi dos Palmares",
"Aeroporto de Ilheus - Jorge Amado",
"Aeroporto de Porto Seguro",
"Aeroporto Internacional de Salvador - Deputado Luis Eduardo Magalhaes",
"Aeroporto Internacional de Fortaleza - Pinto Martins",
"Aeroporto de Imperatriz - Guilherme Cortez",
"Aeroporto Internacional de Sao Luis - Marechal Cunha Machado",
"Aeroporto Internacional de Joao Pessoa - Presidente Castro Pinto",
"Aeroporto de Petrolina",
"Aeroporto Internacional do Recife - Gilberto Freyre",
"Aeroporto de Teresina - Senador Petronio Portela",
"Aeroporto Internacional de Natal - Augusto Severo",
"Aeroporto Internacional de Aracaju - Santa Maria",
"Aeroporto de Vitoria - Eurico de Aguiar Salles",
"Aeroporto Internacional de Belo Horizonte-Confins",
"Aeroporto de Uberlandia - Aeroporto Cesar Bombonato",
"Aeroporto Santos Dumont",
"Aeroporto Internacional do Rio de Janeiro-Galeao",
"Aeroporto de Bauru-Arealva",
"Aeroporto Internacional de Campinas - Viracopos",
"Aeroporto de Presidente Prudente",
"Aeroporto de Ribeirao Preto",
"Aeroporto de Sao Jose do Rio Preto",
"Aeroporto de Congonhas",
"Aeroporto Internacional de Sao Paulo-Guarulhos",
"Aeroporto Internacional de Curitiba - Afonso Pena",
"Aeroporto Internacional de Foz do Iguacu - Cataratas",
"Aeroporto de Londrina - Governador Jose Richa",
"Aeroporto Internacional de Porto Alegre - Salgado Filho",
"Aeroporto Internacional de Florianopolis - Hercilio Luz",
"Aeroporto de Joinville - Lauro Carneiro de Loyola",
"Aeroporto Internacional de Navegantes - Ministro Victor Konder",
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