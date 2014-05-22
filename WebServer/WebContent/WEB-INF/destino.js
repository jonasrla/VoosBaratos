var destinos = 
[
{Nome:"--", ICAO:"none"},
{Nome:"Brasilia - Presidente Juscelino Kubitschek", ICAO:"BSB"},
{Nome:"Goiania - Santa Genoveva", ICAO:"GYN"},
{Nome:"Campo Grande", ICAO:"CGR"},
{Nome:"Marechal Rondon", ICAO:"CGB"},
{Nome:"Rio Branco - Presidente Medici", ICAO:"RBR"},
{Nome:"Manaus - Eduardo Gomes", ICAO:"MAO"},
{Nome:"Parintins", ICAO:""},																//
{Nome:"Macapa", ICAO:"MCP"},
{Nome:"Belem - Val de Cans", ICAO:"BEL"},
{Nome:"Maraba", ICAO:"MAB"},
{Nome:"Santarem - Maestro Wilson Fonseca", ICAO:"STM"},
{Nome:"Porto Velho - Governador Jorge Teixeira de Oliveira", ICAO:"PVH"},
{Nome:"Boa Vista - Atlas Brasil", ICAO:"BVB"},
{Nome:"Palmas - Brigadeiro Lysias Rodrigues", ICAO:"PMW"},
{Nome:"Maceio - Zumbi dos Palmares", ICAO:"MCZ"},
{Nome:"Ilheus - Jorge Amado", ICAO:"IOS"},
{Nome:"Porto Seguro", ICAO:"BPS"},
{Nome:"Salvador - Deputado Luis Eduardo Magalhaes", ICAO:"SSA"},
{Nome:"Fortaleza - Pinto Martins", ICAO:"FOR"},
{Nome:"Imperatriz - Guilherme Cortez", ICAO:"IMP"},
{Nome:"Sao Luis - Marechal Cunha Machado", ICAO:"SLZ"},
{Nome:"Joao Pessoa - Presidente Castro Pinto", ICAO:"JPA"},
{Nome:"Petrolina", ICAO:"PNZ"},
{Nome:"Recife - Gilberto Freyre", ICAO:"REC"},
{Nome:"Teresina - Senador Petronio Portela", ICAO:"THE"},
{Nome:"Natal - Augusto Severo", ICAO:"NAT"},
{Nome:"Aracaju - Santa Maria", ICAO:"RIA"},
{Nome:"Vitoria - Eurico de Aguiar Salles", ICAO:"VIX"},
{Nome:"Belo Horizonte-Confins", ICAO:"PLU"},
{Nome:"Uberlandia - Cesar Bombonato", ICAO:"UDI"},
{Nome:"Santos Dumont", ICAO:"SDU"},
{Nome:"Rio de Janeiro-Galeao", ICAO:"GIG"},
{Nome:"Bauru-Arealva", ICAO:""},																	//
{Nome:"Campinas - Viracopos", ICAO:"VCP"},
{Nome:"Presidente Prudente", ICAO:"PPB"},
{Nome:"Ribeirao Preto", ICAO:"RAO"},
{Nome:"Sao Jose do Rio Preto", ICAO:"SJP"},
{Nome:"Congonhas", ICAO:"CGH"},
{Nome:"Sao Paulo-Guarulhos", ICAO:"GRU"},
{Nome:"Curitiba - Afonso Pena", ICAO:"BFH"},
{Nome:"Foz do Iguacu - Cataratas", ICAO:"IGU"},
{Nome:"Londrina - Governador Jose Richa", ICAO:"LDB"},
{Nome:"Porto Alegre - Salgado Filho", ICAO:"POA"},
{Nome:"Florianopolis - Hercilio Luz", ICAO:"FLN"},
{Nome:"Joinville - Lauro Carneiro de Loyola", ICAO:"JOI"},
{Nome:"Navegantes - Ministro Victor Konder", ICAO:"NVT"},
]

function oriDes(){
	for (var i=0; i<destinos.length; i++){
		document.getElementById("origem").innerHTML += "<option value="+destinos[i].ICAO+">"+destinos[i].Nome+"</option>";
	}
	for (var i=0; i<destinos.length; i++){
		document.getElementById("destino").innerHTML += "<option value="+destinos[i].ICAO+">"+destinos[i].Nome+"</option>";
	}
}

function excluiOpcao(otherSelect,properSelect){
	var e1 = document.getElementById(properSelect);
	var strUser1 = e1.options[e1.selectedIndex].value;
	var e2 = document.getElementById(otherSelect);
	var strUser2 = e2.options[e2.selectedIndex].value;
	alert(strUser1 +" "+ strUser2)
	if (!(strUser1 == "none" && strUser2 == "none")){
		document.getElementById(otherSelect).innerHTML = "";
		for (var i=0; i<destinos.length; i++){
			if(destinos[i].ICAO!=strUser1){
				if (destinos[i].ICAO == strUser2){
					document.getElementById(otherSelect).innerHTML += "<option value="+destinos[i].ICAO+" selected>"+destinos[i].Nome+"</option>";
				}
				else{
					document.getElementById(otherSelect).innerHTML += "<option value="+destinos[i].ICAO+">"+destinos[i].Nome+"</option>";
				}
			}
		}
	}
}