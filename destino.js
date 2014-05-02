var destinos = 
[
"Aeroporto Internacional de Brasília - Presidente Juscelino Kubitschek",
"Aeroporto Internacional de Goiânia - Santa Genoveva",
"Aeroporto Internacional de Campo Grande",
"Aeroporto Internacional Marechal Rondon",
"Aeroporto Internacional de Rio Branco - Presidente Médici",
"Aeroporto Internacional de Manaus - Eduardo Gomes",
"Aeroporto Regional de Parintins",
"Aeroporto Internacional de Macapá",
"Aeroporto Internacional de Belém - Val de Cans",
"Aeroporto de Marabá",
"Aeroporto de Santarém - Maestro Wilson Fonseca",
"Aeroporto Internacional de Porto Velho - Governador Jorge Teixeira de Oliveira",
"Aeroporto Internacional de Boa Vista - Atlas Brasil",
"Aeroporto de Palmas - Brigadeiro Lysias Rodrigues",
"Aeroporto Internacional de Maceió - Zumbi dos Palmares",
"Aeroporto de Ilhéus - Jorge Amado",
"Aeroporto de Porto Seguro",
"Aeroporto Internacional de Salvador - Deputado Luís Eduardo Magalhães",
"Aeroporto Internacional de Fortaleza - Pinto Martins",
"Aeroporto de Imperatriz - Guilherme Cortez",
"Aeroporto Internacional de São Luís - Marechal Cunha Machado",
"Aeroporto Internacional de João Pessoa - Presidente Castro Pinto",
"Aeroporto de Petrolina",
"Aeroporto Internacional do Recife - Gilberto Freyre",
"Aeroporto de Teresina - Senador Petrônio Portela",
"Aeroporto Internacional de Natal - Augusto Severo",
"Aeroporto Internacional de Aracaju - Santa Maria",
"Aeroporto de Vitória - Eurico de Aguiar Salles",
"Aeroporto Internacional de Belo Horizonte-Confins",
"Aeroporto de Uberlândia - Aeroporto César Bombonato",
"Aeroporto Santos Dumont",
"Aeroporto Internacional do Rio de Janeiro-Galeão",
"Aeroporto de Bauru-Arealva",
"Aeroporto Internacional de Campinas - Viracopos",
"Aeroporto de Presidente Prudente",
"Aeroporto de Ribeirão Preto",
"Aeroporto de São José do Rio Preto",
"Aeroporto de Congonhas",
"Aeroporto Internacional de São Paulo-Guarulhos",
"Aeroporto Internacional de Curitiba - Afonso Pena",
"Aeroporto Internacional de Foz do Iguaçu - Cataratas",
"Aeroporto de Londrina - Governador José Richa",
"Aeroporto Internacional de Porto Alegre - Salgado Filho",
"Aeroporto Internacional de Florianópolis - Hercílio Luz",
"Aeroporto de Joinville - Lauro Carneiro de Loyola",
"Aeroporto Internacional de Navegantes - Ministro Victor Konder",
]

function oriDes(){
	document.getElementById("origem").innerHTML = "<option value='0'>--</option>";
	for (var i=0; i<destinos.length; i++){
		document.getElementById("origem").innerHTML += "<option value="+(i+1).toString()+">"+destinos[i]+"</option>";
	}
	document.getElementById("destino").innerHTML = "<option value='0'>--</option>";
	for (var i=0; i<destinos.length; i++){
		document.getElementById("destino").innerHTML += "<option value="+(i+1).toString()+">"+destinos[i]+"</option>";
	}
	document.getElementById('menu').style.display = 'none';
	document.getElementById('origem-destino').style.display = 'block';
}

function excluiOpcao(otherSelect,properSelect){
	var e = document.getElementById(otherSelect);
	var strUser = e.options[e.selectedIndex].value;
	document.getElementById(properSelect).innerHTML = "";
	for (var i=0; i<destinos.length; i++){
		if(i+1!=strUser){
			document.getElementById(properSelect).innerHTML += "<option value="+(i+1).toString()+">"+destinos[i]+"</option>";
		}
	}
}